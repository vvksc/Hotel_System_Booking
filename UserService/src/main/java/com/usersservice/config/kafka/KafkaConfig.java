package com.usersservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

	@Bean
	public NewTopic topic() {
		return TopicBuilder.name("USER_CREATED").build();
	}
	@Bean
	public NewTopic topic1() {
		return TopicBuilder.name("USER_NOT_CREATED").build();
	}
	@Bean
	public NewTopic topic3() {
		return TopicBuilder.name("USER_DELETED").build();
	}
}
