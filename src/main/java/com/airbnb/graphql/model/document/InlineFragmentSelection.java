package com.airbnb.graphql.model.document;

public class InlineFragmentSelection extends Selection {

	public static class Builder extends Selection.Builder<Builder> {

		public Builder() {
			super(new InlineFragmentSelection());
		}

		public Builder typeCondition(NamedVariableType typeCondition) {
			((InlineFragmentSelection) instance).typeCondition = typeCondition;
			return self();
		}

		public Builder selectionSet(SelectionSet selectionSet) {
			((InlineFragmentSelection) instance).selectionSet = selectionSet;
			return self();
		}

		@Override
		protected Builder self() {
			return this;
		}

	}

	private NamedVariableType typeCondition;

	private SelectionSet selectionSet;

	public SelectionSet getSelectionSet() {
		return selectionSet;
	}

	public void setSelectionSet(SelectionSet selectionSet) {
		this.selectionSet = selectionSet;
	}

	public NamedVariableType getTypeCondition() {
		return typeCondition;
	}

	public void setTypeCondition(NamedVariableType typeCondition) {
		this.typeCondition = typeCondition;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("... on ").append(typeCondition.getName().getValue()).append(" {\\n");
		sb.append(selectionSet).append("}\\n");
		return sb.toString();
	}

}
