package com.kotlination.jpapostgresql

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean

import com.kotlination.jpapostgresql.repo.CustomerRepository
import com.kotlination.jpapostgresql.model.Customer


@SpringBootApplication
open class KotlinSpringJpaPostgresqlApplication

fun main(args: Array<String>) {
	SpringApplication.run(KotlinSpringJpaPostgresqlApplication::class.java, *args)
}
