package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VariableArgumentValueTest {

	@Test
	void testToString() {
		VariableArgumentValue varArg = new VariableArgumentValue(new DefinitionName("Name", "roomTypeId"));
		Assertions.assertEquals("$roomTypeId", varArg.toString());
	}

}
