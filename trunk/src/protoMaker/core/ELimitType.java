package protoMaker.core;

public enum ELimitType {
	REQUIRED("required"),
	OPTIONAL("optional"),
	REPEATED("repeated"),
	;
	
	private final String name;
	private ELimitType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
