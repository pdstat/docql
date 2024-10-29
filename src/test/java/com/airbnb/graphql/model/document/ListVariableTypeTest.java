package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListVariableTypeTest {

	@Test
	void testToString() {
		ListVariableType listType = new ListVariableType(
				new NonNullVariableType(new NamedVariableType(new DefinitionName("Name", "String"))));
		
		Assertions.assertEquals("[String!]!", listType.toString());
	}

}
