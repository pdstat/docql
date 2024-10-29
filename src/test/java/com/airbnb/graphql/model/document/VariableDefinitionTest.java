package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VariableDefinitionTest {

	@Test
	void testToStringNamedType() {
		Variable pets = new Variable(new DefinitionName("Name", "pets"));
		VariableType intType = new NamedVariableType(new DefinitionName("Name", "Int"));

		VariableDefinition variableDef = new VariableDefinition(pets, intType);

		Assertions.assertEquals("$pets: Int", variableDef.toString());
	}

	@Test
	void testToStringNonNullType() {
		Variable pets = new Variable(new DefinitionName("Name", "pets"));
		VariableType intType = new NonNullVariableType(new NamedVariableType(new DefinitionName("Name", "Int")));

		VariableDefinition variableDef = new VariableDefinition(pets, intType);

		Assertions.assertEquals("$pets: Int!", variableDef.toString());
	}

}
