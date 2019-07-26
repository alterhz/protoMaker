package protoMaker.core;

public class Field {

	private final Type type;
	private final String name;
	private ELimitType eLimitType = ELimitType.REQUIRED;
	
	private Field(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	
	private Field(Type type, String name, ELimitType eLimitType) {
		this.type = type;
		this.name = name;
		this.eLimitType = eLimitType;
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public static Field make(Type type, String name) {
		return new Field(type, name);
	}
	
	public static Field make(Type type, String name, ELimitType eLimitType) {
		return new Field(type, name, eLimitType);
	}
	
	public static Field toHumanId() {
		return new Field(Type.LONG, "humanId");
	}

	public String getOptional() {
		return eLimitType.getName();
	}

}
