package protoMaker.core;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	public static final String STR_COMMENT = "// %s\n";
	
	public static final String STR_OUT_PUT = "message %s {\n" + 
			"%s" + 
			"%s" +
			"}\n";
	
	public static final String STR_OPTION = "	option (msgid) = %d;\n";
	
	public static final String STR_FIELD = "	%s %s %s = %d;\n";
	
	private String comment = "";
	private final int msgId;
	private final String baseName;
	private final String msgName;
	private List<Field> protoFields = new ArrayList<>();
	
	public Message(String baseName) {
		this.msgId = 0;
		this.baseName = baseName;
		this.msgName = baseName;
	}
	
	protected Message(int msgId, String baseName, String msgName) {
		this.msgId = msgId;
		this.baseName = baseName;
		this.msgName = msgName;
	}
	
	protected Message(int msgId, String baseName, String msgName, String comment) {
		this.msgId = msgId;
		this.baseName = baseName;
		this.msgName = msgName;
		this.comment = comment;
	}
	
	public Message create(String baseName) {
		return new Message(baseName);
	}
	
	public CSMessage createCS() {
		return new CSMessage(this.msgId + 1, this.msgName);
	}
	
	public CSMessage createCS(String baseName) {
		return new CSMessage(this.msgId + 1, baseName);
	}
	
	public SCMessage createSC() {
		return new SCMessage(this.msgId + 1, this.baseName);
	}
	
	public SCMessage createSC(String baseName) {
		return new SCMessage(this.msgId + 1, baseName);
	}
	
	public SCMessageResult createSCResult() {
		return new SCMessageResult(this.msgId + 1, this.baseName);
	}
	
	public SCMessageResult createSCResult(String baseName) {
		return new SCMessageResult(this.msgId + 1, baseName);
	}
	
	public Message addComment(String comment) {
		this.comment = comment;
		return this;
	}
	
	public Message add(Field field) {
		protoFields.add(field);
		return this;
	}
	
	public Message add(Type type, String name) {
		protoFields.add(Field.make(type, name));
		return this;
	}
	
	public Message add(Type type, String name, ELimitType eLimitType) {
		protoFields.add(Field.make(type, name, eLimitType));
		return this;
	}
	
	public Message addOptional(Type type, String name) {
		protoFields.add(Field.make(type, name, ELimitType.OPTIONAL));
		return this;
	}
	
	public Message addRepeated(Type type, String name) {
		protoFields.add(Field.make(type, name, ELimitType.REPEATED));
		return this;
	}
	
	public String genProto() {
		String outComment = "";
		
		if (comment.length() > 0) {
			outComment = String.format(STR_COMMENT, comment);
		}
		
		String outFields = genFields(protoFields);
		
		String outOption = "";
		
		if (0 != msgId) {
			outOption = String.format(STR_OPTION, getMsgId());
		}
		
		String outMessage = String.format(STR_OUT_PUT, getMsgName(), outOption, outFields);
		
		return outComment + outMessage;
	}
	
	private String genFields(List<Field> protoFields) {
		String outStrFields = "";
		
		int number = 0;
		for (Field field : protoFields) {
			String outStrField = String.format(STR_FIELD, field.getOptional(), field.getType(), field.getName(), ++number);
			
			outStrFields += outStrField;
		}
		
		return outStrFields;
	}

	public Message print() {
		System.out.print(genProto());
		return this;
	}
	
	public Message println() {
		System.out.print(genProto());
		System.out.print("\n");
		return this;
	}

	public String getComment() {
		return comment;
	}

	public int getMsgId() {
		return msgId;
	}

	public String getMsgName() {
		return msgName;
	}
	
}