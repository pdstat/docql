package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

public class ListValue extends ArgumentValue {

	private List<ArgumentValue> values = new ArrayList<>();

	public List<ArgumentValue> getValues() {
		return values;
	}

	public void setValues(List<ArgumentValue> values) {
		this.values = values;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (ArgumentValue value : values) {
			sb.append(value).append("\\n");
		}
		sb.append("]");
		return sb.toString();
	}
	

}
