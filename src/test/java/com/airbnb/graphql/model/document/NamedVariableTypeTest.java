package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamedVariableTypeTest {
	
	@Test
	void testToString() {
		NamedVariableType namedType = new NamedVariableType(new DefinitionName("Name", "ID"));
		
		Assertions.assertEquals("ID", namedType.toString());
	}

}
