package com.airbnb.graphql.model.document;

public class VariableArgumentValue extends ArgumentValue {
	
	private DefinitionName name;
	
	public VariableArgumentValue() {
		
	}

	public VariableArgumentValue(DefinitionName name) {
		this.name = name;
	}

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "$" + name.getValue();
	}


}
