package com.animalkingdom.animal.infrastructure.config.db;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.animalkingdom.animal.infrastructure.config.db.repository")
public class MongoConfig {
}