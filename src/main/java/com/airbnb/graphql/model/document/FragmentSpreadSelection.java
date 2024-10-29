package com.airbnb.graphql.model.document;

public class FragmentSpreadSelection extends Selection {

	public static class Builder extends Selection.Builder<Builder> {

		public Builder() {
			super(new FragmentSpreadSelection());
		}

		@Override
		protected Builder self() {
			return this;
		}
		
	}
	
	@Override
	public String toString() {
		return "..." + getName().getValue() + "\\n";
	}

}
