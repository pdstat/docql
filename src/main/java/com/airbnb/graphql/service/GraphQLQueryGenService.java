package com.airbnb.graphql.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.airbnb.graphql.model.GraphQLQuery;
import com.airbnb.graphql.model.document.Document;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class GraphQLQueryGenService {

	private final ObjectMapper mapper;

	public GraphQLQueryGenService(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public void generateGraphQLQuery(String documentString) throws IOException {
		documentString = documentString.substring(1, documentString.length() - 1);
		documentString = documentString.replaceAll("\\\\\"", "\"");
		Document doc = mapper.readValue(documentString, Document.class);
		GraphQLQuery query = new GraphQLQuery(doc);
		String outQuery = mapper.writeValueAsString(query).replaceAll("\\\\n", "\\n");
		System.out.println(outQuery);
	}

}
