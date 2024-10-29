package com.airbnb.graphql.model.document;

public class NamedVariableType extends VariableType {

	private DefinitionName name;

	public NamedVariableType() {
		
	}
	
	public NamedVariableType(DefinitionName name) {
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
		return name.getValue();
	}


}
