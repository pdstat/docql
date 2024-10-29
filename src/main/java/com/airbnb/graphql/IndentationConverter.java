package com.airbnb.graphql;

public class IndentationConverter {
    public static String convertToReadableFormat(String input) {
        StringBuilder output = new StringBuilder();
        int indentLevel = 0;
        boolean isNewLine = true;

        for (char c : input.toCharArray()) {
            if (isNewLine) {
                if (c == ' ') {
                    indentLevel++;
                } else if (c == '\n') {
                    continue;
                } else {
                    isNewLine = false;
                }
            }

            if (c == '{') {
                output.append('\n').append(getIndentation(indentLevel)).append(c).append('\n');
                indentLevel++;
                output.append(getIndentation(indentLevel));
            } else if (c == '}') {
                indentLevel--;
                output.append('\n').append(getIndentation(indentLevel)).append(c).append('\n');
                output.append(getIndentation(indentLevel));
            } else if (c == '\n') {
                isNewLine = true;
                output.append(c).append(getIndentation(indentLevel));
            } else {
                output.append(c);
            }
        }

        return output.toString();
    }

    private static String getIndentation(int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("  "); // two spaces for each level of indentation
        }
        return indentation.toString();
    }

    public static void main(String[] args) {
        String input = "mutation approveBusinessLoginMutation($request: DelawareApproveBusinessLoginRequestInput!) {\n delaware {\n __typename\n approveBusinessLogin(request: $request) {\n __typename\n loginId\n  }\n }\n}\n";
        String output = convertToReadableFormat(input);
        System.out.println(output);
    }
}
