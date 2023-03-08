package com.mleczey

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class OnionApplication

fun main(args: Array<String>) {
  runApplication<OnionApplication>(*args)
}
