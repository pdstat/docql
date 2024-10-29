package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

public class ObjectArgumentValue extends ArgumentValue {

	public static class Builder {
		
		private ObjectArgumentValue instance = new ObjectArgumentValue();
		
		public Builder addArgumentField(ArgumentField field) {
			instance.fields.add(field);
			return this;
		}
		
		public ObjectArgumentValue build() {
			return instance;
		}
		
	}
	
	private List<ArgumentField> fields = new ArrayList<>();

	public List<ArgumentField> getFields() {
		return fields;
	}

	public void setFields(List<ArgumentField> fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i=0; i < fields.size(); i++) {
			sb.append(fields.get(i));
			if (i != fields.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("}");
		return sb.toString();
	}

}
