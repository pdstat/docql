package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Variable {

	private DefinitionName name;

	public Variable() {
		
	}
	
	public Variable(DefinitionName name) {
		this.name = name;
	}

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

}
