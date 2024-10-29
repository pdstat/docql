package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FieldSelectionTest {

	@Test
	void testToStringNullSelectionSet() {
		Selection typeName = new FieldSelection.Builder().name(new DefinitionName("Name", "__typename")).build();

		Assertions.assertEquals("__typename\\n", typeName.toString());
	}

	@Test
	void testToStringSelectionSet() {
		Selection actionItems = new FieldSelection.Builder().name(new DefinitionName("Name", "actionItems"))
				.selectionSet(new SelectionSet()).build();

		Assertions.assertEquals("actionItems {\\n }\\n", actionItems.toString());
	}

	@Test
	void testToStringObjectArguments() {
		SelectionArgument in = buildSelectionObjectArgument("in",
				new ArgumentField(new DefinitionName("Name", "adults"),
						new VariableArgumentValue(new DefinitionName("Name", "adults"))),
				new ArgumentField(new DefinitionName("Name", "checkIn"),
						new VariableArgumentValue(new DefinitionName("Name", "checkIn"))),
				new ArgumentField(new DefinitionName("Name", "checkOut"),
						new VariableArgumentValue(new DefinitionName("Name", "checkOut"))));
		SelectionArgument out = buildSelectionObjectArgument("out",
				new ArgumentField(new DefinitionName("Name", "checkOut"),
						new VariableArgumentValue(new DefinitionName("Name", "checkOut"))));

		Selection addWishlistItem = new FieldSelection.Builder().name(new DefinitionName("Name", "addWishlistItem"))
				.addArgument(in).addArgument(out).selectionSet(new SelectionSet()).build();

		Assertions.assertEquals(
				"addWishlistItem(in: {adults: $adults, checkIn: $checkIn, checkOut: $checkOut}, out: {checkOut: $checkOut})  {\\n }\\n",
				addWishlistItem.toString());
	}

	@Test
	void testToStringVariableArguments() {
		Selection staysListingCard = new FieldSelection.Builder().name(new DefinitionName("Name", "staysListingCard"))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "listingId"),
						new VariableArgumentValue(new DefinitionName("Name", "listingId"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "roomTypeId"),
						new VariableArgumentValue(new DefinitionName("Name", "roomTypeId"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "listingObjType"),
						new VariableArgumentValue(new DefinitionName("Name", "listingObjType"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "spaceType"),
						new VariableArgumentValue(new DefinitionName("Name", "spaceType"))))
				.selectionSet(new SelectionSet()).build();

		Assertions.assertEquals(
				"staysListingCard(listingId: $listingId, roomTypeId: $roomTypeId, listingObjType: $listingObjType, spaceType: $spaceType)  {\\n }\\n",
				staysListingCard.toString());
	}

	@Test
	void testToStringDirectives() {
		Selection staysListingCard = new FieldSelection.Builder().name(new DefinitionName("Name", "staysListingCard"))
				.addDirective(new Directive.Builder().name(new DefinitionName("Name", "serverMock"))
						.addArgument(new SelectionArgument(new DefinitionName("Name", "mockIdentifier1"),
								new VariableArgumentValue(new DefinitionName("Name", "mockIdentifier1"))))
						.addArgument(new SelectionArgument(new DefinitionName("Name", "mockIdentifier2"),
								new VariableArgumentValue(new DefinitionName("Name", "mockIdentifier2"))))
						.build())
				.selectionSet(new SelectionSet()).build();

		Assertions.assertEquals(
				"staysListingCard @serverMock(mockIdentifier1: $mockIdentifier1, mockIdentifier2: $mockIdentifier2) {\\n }\\n",
				staysListingCard.toString());
	}
	
	@Test
	void testToStringArgumentsAndDirectives() {
		Selection staysListingCard = new FieldSelection.Builder().name(new DefinitionName("Name", "staysListingCard"))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "listingId"),
						new VariableArgumentValue(new DefinitionName("Name", "listingId"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "roomTypeId"),
						new VariableArgumentValue(new DefinitionName("Name", "roomTypeId"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "listingObjType"),
						new VariableArgumentValue(new DefinitionName("Name", "listingObjType"))))
				.addArgument(new SelectionArgument(new DefinitionName("Name", "spaceType"),
						new VariableArgumentValue(new DefinitionName("Name", "spaceType"))))
				.addDirective(new Directive.Builder().name(new DefinitionName("Name", "serverMock"))
						.addArgument(new SelectionArgument(new DefinitionName("Name", "mockIdentifier1"),
								new VariableArgumentValue(new DefinitionName("Name", "mockIdentifier1"))))
						.addArgument(new SelectionArgument(new DefinitionName("Name", "mockIdentifier2"),
								new VariableArgumentValue(new DefinitionName("Name", "mockIdentifier2"))))
						.build())
				.selectionSet(new SelectionSet()).build();

		Assertions.assertEquals(
				"staysListingCard(listingId: $listingId, roomTypeId: $roomTypeId, listingObjType: $listingObjType, spaceType: $spaceType) @serverMock(mockIdentifier1: $mockIdentifier1, mockIdentifier2: $mockIdentifier2) {\\n }\\n",
				staysListingCard.toString());
	}

	private SelectionArgument buildSelectionObjectArgument(String argName, ArgumentField... fields) {
		ObjectArgumentValue.Builder argValueBuilder = new ObjectArgumentValue.Builder();
		if (fields != null && fields.length > 0) {
			for (ArgumentField field : fields) {
				argValueBuilder = argValueBuilder.addArgumentField(field);
			}
		}

		return new SelectionArgument(new DefinitionName(argName, argName), argValueBuilder.build());
	}

}
