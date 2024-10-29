package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonSubTypes({ @Type(value = FragmentSpreadSelection.class, name = "FragmentSpread"),
		@Type(value = FieldSelection.class, name = "Field"),
		@Type(value = InlineFragmentSelection.class, name = "InlineFragment")})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Selection {

	public static abstract class Builder<B extends Builder<B>> {

		protected Selection instance;

		protected abstract B self();

		public Builder(Selection instance) {
			this.instance = instance;
		}

		public B name(DefinitionName name) {
			instance.name = name;
			return self();
		}

		public Selection build() {
			return instance;
		}

	}

	private DefinitionName name;

	public DefinitionName getName() {
		return name;
	}

	public void setName(DefinitionName name) {
		this.name = name;
	}

}
