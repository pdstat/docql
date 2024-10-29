package com.airbnb.graphql.model.document;

public class NonNullVariableType extends VariableType {
	
	private VariableType type;
	
	public NonNullVariableType() {
		
	}

	public NonNullVariableType(VariableType type) {
		this.type = type;
	}

	public VariableType getType() {
		return type;
	}

	public void setType(VariableType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type.toString() + "!";
	}

}
