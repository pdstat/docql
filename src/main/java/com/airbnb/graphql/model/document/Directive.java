package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

public class Directive {
	
	public static class Builder {
		
		private Directive instance = new Directive();
		
		public Builder name(DefinitionName name) {
			instance.name = name;
			return this;
		}
		
		public Builder addArgument(SelectionArgument argument) {
			instance.arguments.add(argument);
			return this;
		}
		
		public Directive build() {
			return instance;
		}
		
	}
	
	private DefinitionName name;
	
	private List<SelectionArgument> arguments = new ArrayList<>();

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

	public List<SelectionArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<SelectionArgument> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("@").append(name.getValue()).append("(");
		for (int i=0; i < arguments.size(); i++) {
			sb.append(arguments.get(i));
			if (i != arguments.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}

}
