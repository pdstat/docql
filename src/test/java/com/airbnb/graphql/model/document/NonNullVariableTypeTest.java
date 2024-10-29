package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NonNullVariableTypeTest {

	@Test
	void testToString() {
		NonNullVariableType nonNullType = new NonNullVariableType(
				new NamedVariableType(new DefinitionName("Name", "ID")));
		
		Assertions.assertEquals("ID!", nonNullType.toString());
	}

}
