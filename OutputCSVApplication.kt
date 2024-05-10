package com.example.outputcsv

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(basePackages = ["repository"])
@SpringBootApplication
class OutputcsvApplication(private val exportcsvService: ExportCSVService) {
	@Bean
	fun ApplicationRunner() =
		ApplicationRunner {
			val FilePath = "Output.csv"
			exportcsvService.exportToCSV(FilePath)
		}
}

fun main(args: Array<String>) {
	val run = runApplication<OutputcsvApplication>(*args)
	run.close()
}