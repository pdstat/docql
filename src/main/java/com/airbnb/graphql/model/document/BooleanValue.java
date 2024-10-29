package com.airbnb.graphql.model.document;

public class BooleanValue extends ArgumentValue {
	
	private boolean value;

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return Boolean.toString(value);
	}

}
