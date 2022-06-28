package com.hcl.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@JmsListener(destination = "InMemory_ActiveMQ")
	public void listener(String message) {

		System.out.println("Received mesage:" + message);
	}

}
