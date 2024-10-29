package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectiveTest {

	@Test
	void testToString() {
		Directive directive = new Directive.Builder().name(new DefinitionName("Name", "serverMock"))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "mockIdentifier1"),
						new VariableArgumentValue(new DefinitionName("Name", "mockIdentifier1"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "mockIdentifier2"),
						new VariableArgumentValue(new DefinitionName("Name", "mockIdentifier2"))))
				.build();
	
		Assertions.assertEquals("@serverMock(mockIdentifier1: $mockIdentifier1, mockIdentifier2: $mockIdentifier2)",
				directive.toString());
	}

}
