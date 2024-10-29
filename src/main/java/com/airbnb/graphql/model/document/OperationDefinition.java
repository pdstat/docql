package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

public class OperationDefinition extends Definition {
	
	public static class Builder extends Definition.Builder<Builder> {

		public Builder() {
			super(new OperationDefinition());
		}
		
		public Builder operation(String operation) {
			((OperationDefinition)instance).operation = operation;
			return self();
		}
		
		public Builder addVariableDefinition(VariableDefinition variableDefinition) {
			((OperationDefinition)instance).variableDefinitions.add(variableDefinition);
			return self();
		}
		
		@Override
		protected Builder self() {
			return this;
		}
		
	}
	
	private String operation;

	private List<VariableDefinition> variableDefinitions = new ArrayList<>();

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public List<VariableDefinition> getVariableDefinitions() {
		return variableDefinitions;
	}

	public void setVariableDefinitions(List<VariableDefinition> variableDefinitions) {
		this.variableDefinitions = variableDefinitions;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(operation).append(" ").append(getName().getValue());
		
		if (!variableDefinitions.isEmpty()) {
			sb.append("(");
			for (int i=0; i < variableDefinitions.size(); i++) {
				sb.append(variableDefinitions.get(i));
				if (i != variableDefinitions.size() - 1) {
					sb.append(", ");
				}
			}
			sb.append(")");
		}
		
		sb.append(" {\\n ").append(getSelectionSet());
		
		long openingBraces = sb.chars().filter(c -> c == (int)'{').count();
		long closingBraces = sb.chars().filter(c -> c == (int)'}').count();
		
		if (openingBraces > closingBraces) {
			long difference = openingBraces - closingBraces;
			for (int i=0; i < difference; i++) {
				sb.append("}\\n");
			}
		}
		
		return sb.toString();
	}

}
