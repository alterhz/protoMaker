package protoMaker.core;

public class CSMessage extends Message {

	public CSMessage(int msgId, String baseName) {
		super(msgId, baseName, "CS" + baseName);
	}
	
	public CSMessage(int msgId, String baseName, String comment) {
		super(msgId, baseName, "CS" + baseName, comment);
	}

}
