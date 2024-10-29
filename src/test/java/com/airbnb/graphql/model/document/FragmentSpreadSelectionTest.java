package com.airbnb.graphql.model.document;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FragmentSpreadSelectionTest {

	@Test
	void testToString() {
		Selection fragmentSelection = new FragmentSpreadSelection.Builder()
				.name(new DefinitionName("Name", "ExplorePictureFragment")).build();

		Assertions.assertEquals("...ExplorePictureFragment\\n", fragmentSelection.toString());
	}

}
