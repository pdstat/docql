package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

public class FieldSelection extends Selection {

	public static class Builder extends Selection.Builder<Builder> {

		public Builder() {
			super(new FieldSelection());
		}

		public Builder alias(DefinitionName alias) {
			((FieldSelection) instance).alias = alias;
			return self();
		}
		
		public Builder addArgument(SelectionArgument argument) {
			((FieldSelection) instance).arguments.add(argument);
			return self();
		}
		
		public Builder addDirective(Directive directive) {
			((FieldSelection) instance).directives.add(directive);
			return self();
		}

		public Builder selectionSet(SelectionSet selectionSet) {
			((FieldSelection) instance).selectionSet = selectionSet;
			return self();
		}

		@Override
		protected Builder self() {
			return this;
		}

	}

	private DefinitionName alias;

	private List<SelectionArgument> arguments = new ArrayList<>();
	
	private List<Directive> directives = new ArrayList<>();

	private SelectionSet selectionSet;

	public List<SelectionArgument> getArguments() {
		return arguments;
	}

	public void setArguments(List<SelectionArgument> arguments) {
		this.arguments = arguments;
	}

	public SelectionSet getSelectionSet() {
		return selectionSet;
	}

	public void setSelectionSet(SelectionSet selectionSet) {
		this.selectionSet = selectionSet;
	}

	public DefinitionName getAlias() {
		return alias;
	}

	public void setAlias(DefinitionName alias) {
		this.alias = alias;
	}
	
	public List<Directive> getDirectives() {
		return directives;
	}

	public void setDirectives(List<Directive> directives) {
		this.directives = directives;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		final String selectionName = getName().getValue();
		if (selectionSet == null) {
			if (alias == null) {
				return sb.append(selectionName).append("\\n").toString();
			}
			return sb.append(alias.getValue()).append(": ").append(selectionName).append("\\n").toString();
		}

		if (!arguments.isEmpty()) {
			if (alias == null) {
				sb.append(selectionName).append("(");
			} else {
				sb.append(alias.getValue()).append(": ").append(selectionName).append("(");
			}
			for (int i = 0; i < arguments.size(); i++) {
				SelectionArgument argument = arguments.get(i);
				final String argName = argument.getName().getValue();
				sb.append(argName).append(": ").append(argument.getValue());
				if (i != arguments.size() - 1) {
					sb.append(", ");
				}
			}
			sb.append(") ");
			
			if (!directives.isEmpty()) {
				for (int i=0; i < directives.size(); i++) {
					sb.append(directives.get(i));
					if (i != directives.size() - 1) {
						sb.append(" ");
					}
				}
			}
			sb.append(" {\\n");

			if (selectionSet != null) {
				sb.append(" ").append(selectionSet).append("}\\n");
			}

			return sb.toString();
		}
		
		if (!directives.isEmpty()) {
			if (alias == null) {
				sb.append(selectionName).append(" ");
			} else {
				sb.append(alias.getValue()).append(": ").append(selectionName).append(" ");
			}
			for (int i=0; i < directives.size(); i++) {
				sb.append(directives.get(i));
				if (i != directives.size() - 1) {
					sb.append(" ");
				}
			}
			
			sb.append(" {\\n");
			
			if (selectionSet != null) {
				sb.append(" ").append(selectionSet).append("}\\n");
			}
			return sb.toString();
		} else {
			if (alias == null) {
				sb.append(selectionName).append(" {\\n");
			} else {
				sb.append(alias.getValue()).append(": ").append(selectionName).append(" {\\n");
			}

			if (selectionSet != null) {
				sb.append(" ").append(selectionSet).append("}\\n");
			}

			return sb.toString();			
		}
	}

}
