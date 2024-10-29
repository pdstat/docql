package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArgumentFieldTest {
	
	@Test
	void testToString() {
		DefinitionName fieldName = new DefinitionName();
		fieldName.setValue("adults");
		VariableArgumentValue fieldValue = new VariableArgumentValue(new DefinitionName("Name", "adults"));
		ArgumentField argField = new ArgumentField();
		argField.setName(fieldName);
		argField.setValue(fieldValue);
		
		Assertions.assertEquals("adults: $adults", argField.toString());
	}

}
