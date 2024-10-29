package com.airbnb.graphql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.airbnb.graphql.service.GraphQLQueryGenService;

@SpringBootApplication
public class GraphqlApplication implements CommandLineRunner {

	@Autowired
	private GraphQLQueryGenService graphQLQueryGenService;

	@Autowired
	private ApplicationArguments appArgs;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (appArgs.containsOption(InputArguments.INPUT_FILE_ARG)) {
			try {
				graphQLQueryGenService
						.generateGraphQLQuery(Files.readString(Paths.get(appArgs.getOptionValues(InputArguments.INPUT_FILE_ARG).get(0))));
			} catch (IOException e) {
				logErrorForFile(appArgs.getOptionValues(InputArguments.INPUT_FILE_ARG).get(0));
			}
		} else {
			System.err.println("Missing input-file argument");
		}
	}

	private void logErrorForFile(String fileName) {
		System.out.println(fileName);
	}

}
