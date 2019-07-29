package protoMaker.core;

public class SCMessage extends Message {

	public SCMessage(int msgId, String baseName) {
		super(msgId, baseName, "SC" + baseName);
	}

}
