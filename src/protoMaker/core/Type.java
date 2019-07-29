package protoMaker.core;

public class Type {
	public final static Type INT = new Type("int32");
	public final static Type LONG = new Type("int64");
	public final static Type STRING = new Type("string");
	public final static Type BOOL = new Type("bool");
	public final static Type FLOAT = new Type("float");

	private final String name;
	private Type(String name) {
		this.name = name;
	}
	
	public static Type create(String name) {
		return new Type(name);
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}
