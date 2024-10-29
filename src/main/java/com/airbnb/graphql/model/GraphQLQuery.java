package com.airbnb.graphql.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.airbnb.graphql.model.document.Definition;
import com.airbnb.graphql.model.document.Document;
import com.airbnb.graphql.model.document.NamedVariableType;
import com.airbnb.graphql.model.document.OperationDefinition;
import com.airbnb.graphql.model.document.Variable;
import com.airbnb.graphql.model.document.VariableType;

public class GraphQLQuery {

	private String operationName;

	private final Map<String, Object> variables = new HashMap<>();

	private String query;

	public GraphQLQuery(Document document) {
		init(document);
	}

	private void init(Document document) {
		List<Definition> definitions = document.getDefinitions();
		OperationDefinition operationDefinition = (OperationDefinition) definitions.get(0);
		this.operationName = operationDefinition.getName().getValue();
		this.query = buildQueryString(definitions);
		operationDefinition.getVariableDefinitions().forEach(variableDef -> {
			Variable variable = variableDef.getVariable();
			VariableType type = variableDef.getType();
			String varType = null;
			if (type instanceof NamedVariableType) {
				varType = ((NamedVariableType) type).getName().getValue();
			} else {
				varType = "";
			}

			switch (varType) {
			case "Int":
				variables.put(variable.getName().getValue(), 0);
				break;
			case "Float":
				variables.put(variable.getName().getValue(), 0.0f);
				break;
			case "Long":
				variables.put(variable.getName().getValue(), 0L);
				break;
			case "Boolean":
				variables.put(variable.getName().getValue(), false);
				break;
			default:
				variables.put(variable.getName().getValue(), "X");
				break;
			}
		});
	}

	private String buildQueryString(List<Definition> definitions) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < definitions.size(); i++) {
			sb.append(definitions.get(i));
			if (i != definitions.size() - 1) {
				sb.append("\\n");
			}
		}
		return sb.toString();
	}

	public String getOperationName() {
		return operationName;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public String getQuery() {
		return query;
	}

}
