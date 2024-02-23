package com.demo.otelspringgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class OtelSpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtelSpringGatewayApplication.class, args);
		Hooks.enableAutomaticContextPropagation();
	}

}
