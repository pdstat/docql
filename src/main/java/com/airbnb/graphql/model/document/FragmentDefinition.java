package com.airbnb.graphql.model.document;

public class FragmentDefinition extends Definition {

	public static class Builder extends Definition.Builder<Builder> {

		public Builder() {
			super(new FragmentDefinition());
		}

		public Builder typeCondition(NamedVariableType typeCondition) {
			((FragmentDefinition) instance).typeCondition = typeCondition;
			return self();

		}

		@Override
		protected Builder self() {
			return this;
		}

	}

	private NamedVariableType typeCondition;

	public NamedVariableType getTypeCondition() {
		return typeCondition;
	}

	public void setTypeCondition(NamedVariableType typeCondition) {
		this.typeCondition = typeCondition;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("fragment ").append(getName().getValue()).append(" on ").append(typeCondition.getName().getValue());
		sb.append(" {\\n ").append(getSelectionSet());

		long openingBraces = sb.chars().filter(c -> c == (int) '{').count();
		long closingBraces = sb.chars().filter(c -> c == (int) '}').count();

		if (openingBraces > closingBraces) {
			long difference = openingBraces - closingBraces;
			for (int i = 0; i < difference; i++) {
				sb.append("}");
			}
		}

		return sb.toString();
	}

}
