package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonSubTypes({ @Type(value = NamedVariableType.class, name = "NamedType"),
		@Type(value = NonNullVariableType.class, name = "NonNullType"),
		@Type(value = ListVariableType.class, name = "ListType")})
public abstract class VariableType {

}
