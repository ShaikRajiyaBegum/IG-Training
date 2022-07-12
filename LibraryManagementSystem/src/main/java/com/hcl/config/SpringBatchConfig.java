package com.hcl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.hcl.controller.BookIssueController;
import com.hcl.model.BookInfo;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBatchConfig.class);

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<BookInfo> itemReader, ItemProcessor<BookInfo, BookInfo> itemProcessor,
			ItemWriter<BookInfo> itemWriter) {

		LOGGER.info("SpringBatchConfig:: Job!!!! start :");

		Step step = stepBuilderFactory.get("ETL-file-load").<BookInfo, BookInfo>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();

		LOGGER.info("SpringBatchConfig:: Job!!!! end :");

		return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).build();
	}

	@Bean
	public FlatFileItemReader<BookInfo> itemReader() {

		LOGGER.info("SpringBatchConfig:: itemReader !!!! start :");

		FlatFileItemReader<BookInfo> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource("src/main/resources/Books.csv"));
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());

		LOGGER.info("SpringBatchConfig:: itemReader !!!! end :");

		return flatFileItemReader;
	}

	@Bean
	public LineMapper<BookInfo> lineMapper() {

		LOGGER.info("SpringBatchConfig:: lineMapper !!!! start :");

		DefaultLineMapper<BookInfo> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("book_Id", "book_Name", "author", "price", "book_Pages", "no_Of_Copies",
				"book_Publication");

		BeanWrapperFieldSetMapper<BookInfo> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(BookInfo.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);

		LOGGER.info("SpringBatchConfig:: lineMapper !!!! end :");

		return defaultLineMapper;
	}
}