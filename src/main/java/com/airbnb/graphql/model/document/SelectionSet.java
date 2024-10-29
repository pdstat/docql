package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SelectionSet {

	public static class Builder {

		private SelectionSet instance = new SelectionSet();

		public Builder addSelection(Selection selection) {
			instance.selections.add(selection);
			return this;
		}

		public SelectionSet build() {
			return instance;
		}

	}

	private List<Selection> selections = new ArrayList<>();

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Selection selection : selections) {
			sb.append(selection).append(" ");
		}
		return sb.toString();
	}

}
