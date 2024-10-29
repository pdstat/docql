package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArgumentField {

	private DefinitionName name;

	private ArgumentValue value;

	public ArgumentField() {

	}

	public ArgumentField(DefinitionName name, ArgumentValue value) {
		this.name = name;
		this.value = value;
	}

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

	public ArgumentValue getValue() {
		return value;
	}

	public void setValue(ArgumentValue value) {
		this.value = value;
	}

	@Override
	public String toString() {
		final String fieldName = name.getValue();
		return fieldName + ": " + value;
	}

}
