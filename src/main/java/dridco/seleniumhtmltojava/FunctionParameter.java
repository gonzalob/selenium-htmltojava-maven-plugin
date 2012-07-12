package dridco.seleniumhtmltojava;

import static java.lang.String.format;

class FunctionParameter {

	private String name;
	private Class<?> type;

	public FunctionParameter(String name, Class<?> type) {
		this.name = name;
		this.type = type;
	}

	String renderForDeclaration() {
		return format("%s %s", type.getName(), name);
	}

}
