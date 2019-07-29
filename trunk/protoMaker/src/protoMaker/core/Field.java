package protoMaker.core;

public class Field {

	private final Type type;
	private final String name;
	private ELimitType eLimitType = ELimitType.REQUIRED;

	/**
	 * 注释
	 */
	private String comment = "";
	
	private Field(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	
	private Field(Type type, String name, ELimitType eLimitType) {
		this.type = type;
		this.name = name;
		this.eLimitType = eLimitType;
	}
	
	private Field(Type type, String name, String comment) {
		this.type = type;
		this.name = name;
		this.comment = comment;
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
	public Field limitType(ELimitType eLimitType) {
		this.eLimitType = eLimitType;
		return this;
	}
	
	public Field comment(String comment) {
		this.comment = comment;
		return this;
	}
	
	public static Field make(Type type, String name) {
		return new Field(type, name);
	}
	
	public static Field make(Type type, String name, String comment) {
		return new Field(type, name, comment);
	}
	
	public static Field make(Type type, String name, ELimitType eLimitType) {
		return new Field(type, name, eLimitType);
	}
	
	public static Field make(Type type, String name, ELimitType eLimitType, String comment) {
		return new Field(type, name, eLimitType).comment(comment);
	}
	
	public static Field toHumanId() {
		return new Field(Type.LONG, "humanId");
	}

	public String getOptional() {
		return eLimitType.getName();
	}

	public String getComment() {
		if (comment.length() == 0) {
			return "";
		}
		
		return "// " + comment;
	}

}
