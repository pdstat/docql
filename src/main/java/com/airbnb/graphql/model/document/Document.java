package com.airbnb.graphql.model.document;

import java.util.ArrayList;
import java.util.List;

public class Document {

	private String kind;

	private List<Definition> definitions = new ArrayList<>();

	private OperationType operationType;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public List<Definition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<Definition> definitions) {
		this.definitions = definitions;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

}
