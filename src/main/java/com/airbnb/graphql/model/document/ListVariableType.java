package com.airbnb.graphql.model.document;

public class ListVariableType extends VariableType {

	private VariableType type;
	
	public ListVariableType() {
		
	}

	public ListVariableType(VariableType type) {
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
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(type).append("]");
		if (type instanceof NonNullVariableType) {
			sb.append("!");
		}
		return sb.toString();
	}
	
	

}
