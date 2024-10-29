package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArgumentFieldValue {

	private DefinitionName name;
	
	public ArgumentFieldValue() {
		
	}

	public ArgumentFieldValue(DefinitionName name) {
		this.name = name;
	}

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

}
