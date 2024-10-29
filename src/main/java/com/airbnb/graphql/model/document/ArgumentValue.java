package com.airbnb.graphql.model.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonSubTypes({ @Type(value = VariableArgumentValue.class, name = "Variable"),
		@Type(value = ObjectArgumentValue.class, name = "ObjectValue"),
		@Type(value = StringArgumentValue.class, name = "StringValue"),
		@Type(value = ListValue.class, name = "ListValue"),
		@Type(value = EnumValue.class, name = "EnumValue"),
		@Type(value = BooleanValue.class, name = "BooleanValue")})
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ArgumentValue {


}
