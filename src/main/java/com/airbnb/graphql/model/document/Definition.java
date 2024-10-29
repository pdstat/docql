package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonSubTypes({ @Type(value = OperationDefinition.class, name = "OperationDefinition"),
		@Type(value = FragmentDefinition.class, name = "FragmentDefinition") })
public abstract class Definition {
	
	public static abstract class Builder<B extends Builder<B>> {
		
		protected Definition instance;
		
		protected abstract B self();
		
		public Builder(Definition instance) {
			this.instance = instance;
		}
		
		public B name(DefinitionName name) {
			instance.name = name;
			return self();
		}
		
		public B selectionSet(SelectionSet selectionSet) {
			instance.selectionSet = selectionSet;
			return self();
		}
		
		public Definition build() {
			return instance;
		}
		
	}

	private DefinitionName name;

	private SelectionSet selectionSet;

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

	public SelectionSet getSelectionSet() {
		return selectionSet;
	}

	public void setSelectionSet(SelectionSet selectionSet) {
		this.selectionSet = selectionSet;
	}

}
