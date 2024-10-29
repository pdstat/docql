package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableDefinition {

	private Variable variable;

	private VariableType type;

	public VariableDefinition() {

	}

	public VariableDefinition(Variable variable, VariableType type) {
		this.variable = variable;
		this.type = type;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public VariableType getType() {
		return type;
	}

	public void setType(VariableType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		final String variableName = variable.getName().getValue();

		sb.append("$").append(variableName).append(": ").append(type);

		return sb.toString();
	}

}
