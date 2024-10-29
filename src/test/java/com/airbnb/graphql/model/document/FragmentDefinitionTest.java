package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FragmentDefinitionTest {

	@Test
	void testToString() {
		Definition fragmentDefinition = new FragmentDefinition.Builder()
				.name(new DefinitionName("Name", "ExplorePictureFragment"))
				.typeCondition(new NamedVariableType(new DefinitionName("Name", "ExplorePicture")))
				.selectionSet(new SelectionSet.Builder()
						.addSelection(
								new FieldSelection.Builder().name(new DefinitionName("Name", "__typename")).build())
						.addSelection(
								new FieldSelection.Builder().name(new DefinitionName("Name", "caption"))
								.selectionSet(new SelectionSet.Builder()
										.addSelection(
												new FieldSelection.Builder().name(new DefinitionName("Name", "__typename")).build())
										.addSelection(
												new FieldSelection.Builder().name(new DefinitionName("Name", "kickerBadge"))
												.selectionSet(new SelectionSet.Builder()
														.addSelection(
																new FieldSelection.Builder().name(new DefinitionName("Name", "__typename")).build())
														.addSelection(
																new FieldSelection.Builder().name(new DefinitionName("Name", "label")).build())
														.addSelection(
																new FieldSelection.Builder().name(new DefinitionName("Name", "type")).build())
														.build())
												.build())
										.addSelection(
												new FieldSelection.Builder().name(new DefinitionName("Name", "messages")).build())
										.build())
								.build())
						.addSelection(
								new FieldSelection.Builder().name(new DefinitionName("Name", "id")).build())
						.addSelection(
								new FieldSelection.Builder().name(new DefinitionName("Name", "picture")).build())
						.build())
				.build();
		
		final String expectedFragmentString = "fragment ExplorePictureFragment on ExplorePicture {\\n __typename\\n "
				+ "caption {\\n __typename\\n kickerBadge {\\n __typename\\n label\\n type\\n }\\n messages\\n }\\n id\\n picture\\n }";
		
		Assertions.assertEquals(expectedFragmentString, fragmentDefinition.toString());
	}

}
