package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationDefinitionTest {

	@Test
	void testToStringQuery() {

		Definition actionTrayQuery = new OperationDefinition.Builder().operation("query")
				.name(new DefinitionName("Name", "ActionTray"))
				.selectionSet(new SelectionSet.Builder().addSelection(new FieldSelection.Builder()
						.name(new DefinitionName("Name", "presentation"))
						.selectionSet(new SelectionSet.Builder()
								.addSelection(new FieldSelection.Builder()
										.name(new DefinitionName("Name", "__typename")).build())
								.addSelection(new FieldSelection.Builder()
										.name(new DefinitionName("Name", "actionTray"))
										.selectionSet(new SelectionSet.Builder()
												.addSelection(new FieldSelection.Builder()
														.name(new DefinitionName("Name", "__typename")).build())
												.addSelection(new FieldSelection.Builder()
														.name(new DefinitionName("Name", "actionItems"))
														.selectionSet(new SelectionSet.Builder()
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name", "__typename"))
																		.build())
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name", "icon"))
																		.build())
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name", "iconUrl"))
																		.build())
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name", "bodyText"))
																		.build())
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name", "ctaText"))
																		.build())
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name", "ctaUrl"))
																		.build())
																.addSelection(
																		new FragmentSpreadSelection.Builder()
																				.name(new DefinitionName("Name",
																						"ExplorePictureFragment"))
																				.build())
																.addSelection(new FieldSelection.Builder()
																		.name(new DefinitionName("Name",
																				"loggingContext"))
																		.selectionSet(new SelectionSet.Builder()
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"__typename"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"listingId"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"loggingId"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"paymentId"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"billToken"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"reservationId"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"actionType"))
																								.build())
																				.addSelection(
																						new FieldSelection.Builder()
																								.name(new DefinitionName(
																										"Name",
																										"tripUuid"))
																								.build())
																				.build())
																		.build())
																.build())
														.build())
												.build())
										.build())
								.build())
						.build()).build())
				.build();

		final String expectedQueryString = "query ActionTray {\\n presentation {\\n __typename\\n actionTray {\\n "
				+ "__typename\\n actionItems {\\n __typename\\n icon\\n iconUrl\\n bodyText\\n ctaText\\n ctaUrl\\n "
				+ "...ExplorePictureFragment\\n loggingContext {\\n __typename\\n listingId\\n loggingId\\n "
				+ "paymentId\\n billToken\\n reservationId\\n actionType\\n tripUuid\\n }\\n }\\n }\\n }\\n }\\n";

		Assertions.assertEquals(expectedQueryString, actionTrayQuery.toString());
	}

	@Test
	void testToStringMutation() {
		Definition addWishListMutation = new OperationDefinition.Builder().operation("mutation")
				.name(new DefinitionName("Name", "AddWishlistItemMutation"))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "adults")),
						new NamedVariableType(new DefinitionName("Name", "Int"))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "checkIn")),
						new NamedVariableType(new DefinitionName("Name", "String"))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "checkOut")),
						new NamedVariableType(new DefinitionName("Name", "String"))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "children")),
						new NamedVariableType(new DefinitionName("Name", "Int"))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "infants")),
						new NamedVariableType(new DefinitionName("Name", "Int"))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "pets")),
						new NamedVariableType(new DefinitionName("Name", "Int"))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "savedItemId")),
						new NonNullVariableType(new NamedVariableType(new DefinitionName("Name", "String")))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "savedItemType")),
						new NonNullVariableType(new NamedVariableType(new DefinitionName("Name", "WishlistItemType")))))
				.addVariableDefinition(new VariableDefinition(new Variable(new DefinitionName("Name", "wishlistId")),
						new NonNullVariableType(new NamedVariableType(new DefinitionName("Name", "ID")))))
				.selectionSet(new SelectionSet.Builder()
						.addSelection(new FieldSelection.Builder().name(new DefinitionName("Name", "addWishlistItem"))
								.addArgument(new SelectionArgument(new DefinitionName("Name", "input"),
										new ObjectArgumentValue.Builder()
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "adults"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "adults"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "checkIn"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "checkIn"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "checkOut"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "checkOut"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "children"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "children"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "infants"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "infants"))))
												.addArgumentField(new ArgumentField(new DefinitionName("Name", "pets"),
														new VariableArgumentValue(new DefinitionName("Name", "pets"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "savedItemId"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "savedItemId"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "savedItemType"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "savedItemType"))))
												.addArgumentField(
														new ArgumentField(new DefinitionName("Name", "wishlistId"),
																new VariableArgumentValue(
																		new DefinitionName("Name", "wishlistId"))))
												.build()))
								.selectionSet(new SelectionSet.Builder()
										.addSelection(new FieldSelection.Builder()
												.name(new DefinitionName("Name", "__typename")).build())
										.addSelection(new FieldSelection.Builder()
												.name(new DefinitionName("Name", "statusCode")).build())
										.addSelection(new FieldSelection.Builder()
												.name(new DefinitionName("Name", "statusMessage")).build())
										.addSelection(new FieldSelection.Builder()
												.name(new DefinitionName("Name", "wishlistItemId")).build())
										.build())
								.build())
						.build())
				.build();

		final String expectedMutationString = "mutation AddWishlistItemMutation($adults: Int, $checkIn: String, $checkOut: String,"
				+ " $children: Int, $infants: Int, $pets: Int, $savedItemId: String!, $savedItemType: WishlistItemType!, "
				+ "$wishlistId: ID!) {\\n addWishlistItem(input: {adults: $adults, checkIn: $checkIn, checkOut: $checkOut, children: "
				+ "$children, infants: $infants, pets: $pets, savedItemId: $savedItemId, savedItemType: $savedItemType, wishlistId: "
				+ "$wishlistId})  {\\n __typename\\n statusCode\\n statusMessage\\n wishlistItemId\\n }\\n }\\n";

		Assertions.assertEquals(expectedMutationString, addWishListMutation.toString());

	}

}
