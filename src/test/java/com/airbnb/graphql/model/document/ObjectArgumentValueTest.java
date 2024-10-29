package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ObjectArgumentValueTest {

	@Test
	void testToString() {
		ObjectArgumentValue objectArgValue = new ObjectArgumentValue.Builder()
				.addArgumentField(new ArgumentField(new DefinitionName("Name", "adults"),
						new VariableArgumentValue(new DefinitionName("Name", "adults"))))
				.addArgumentField(new ArgumentField(new DefinitionName("Name", "checkIn"),
						new VariableArgumentValue(new DefinitionName("Name", "checkIn"))))
				.addArgumentField(new ArgumentField(new DefinitionName("Name", "checkOut"),
						new VariableArgumentValue(new DefinitionName("Name", "checkOut"))))
				.build();
		
		final String expected = "{adults: $adults, checkIn: $checkIn, checkOut: $checkOut}";
		Assertions.assertEquals(expected, objectArgValue.toString());
	}

}
