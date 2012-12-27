package dridco.seleniumhtmltojava.commands

import javax.tools.SimpleJavaFileObject
import javax.tools.JavaFileObject.Kind

// adapted from http://www.java2s.com/Code/Java/JDK-6/CompilingfromMemory.htm
class JavaSourceFromString extends SimpleJavaFileObject {

	final String code;

	JavaSourceFromString(String name, String code) {
		super(URI.create("string:///" + name + Kind.SOURCE.extension), Kind.SOURCE);
		this.code = code;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return code;
	}
}
