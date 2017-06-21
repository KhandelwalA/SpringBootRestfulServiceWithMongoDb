package com.khandelwal;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
public class MongoDbConfiguration {

	@Value("${spring.data.mongodb.uri}")
	private String mongoDbURI;

	public @Bean MongoClientURI mongoClientURI() {

		MongoClientURI mongoClientURI = new MongoClientURI(mongoDbURI);

		return mongoClientURI;
	}

	public @Bean MongoDbFactory mongoDbFactory() throws UnknownHostException {

		return new SimpleMongoDbFactory(mongoClientURI());
	}

	public @Bean MongoTemplate mongoTemplate() throws UnknownHostException {

		return new MongoTemplate(mongoDbFactory());
	}
}
