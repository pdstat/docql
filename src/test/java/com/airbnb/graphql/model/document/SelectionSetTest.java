package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSetTest {
	
	@Test
	void testToString() {
		SelectionArgument in = buildSelectionArgument("in",
				new ArgumentField(new DefinitionName("Name", "adults"),
						new VariableArgumentValue(new DefinitionName("Name", "adults"))),
				new ArgumentField(new DefinitionName("Name", "checkIn"),
						new VariableArgumentValue(new DefinitionName("Name", "checkIn"))),
				new ArgumentField(new DefinitionName("Name", "checkOut"),
						new VariableArgumentValue(new DefinitionName("Name", "checkOut"))));
		SelectionArgument out = buildSelectionArgument("out", new ArgumentField(new DefinitionName("Name", "checkOut"),
				new VariableArgumentValue(new DefinitionName("Name", "checkOut"))));

		Selection addWishlistItem = new FieldSelection.Builder().name(new DefinitionName("Name", "addWishlistItem"))
				.addArgument(in).addArgument(out).selectionSet(new SelectionSet()).build();
		
		SelectionSet selectionSet = new SelectionSet.Builder().addSelection(addWishlistItem).build();
		
		Assertions.assertEquals(
				"addWishlistItem(in: {adults: $adults, checkIn: $checkIn, checkOut: $checkOut}, out: {checkOut: $checkOut})  {\\n }\\n ",
				selectionSet.toString());
	}
	
	private SelectionArgument buildSelectionArgument(String argName, ArgumentField... fields) {
		ObjectArgumentValue.Builder argValueBuilder = new ObjectArgumentValue.Builder();
		if (fields != null && fields.length > 0) {
			for (ArgumentField field : fields) {
				argValueBuilder = argValueBuilder.addArgumentField(field);
			}
		}

		return new SelectionArgument(new DefinitionName(argName, argName), argValueBuilder.build());
	}

}
