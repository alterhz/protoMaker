package protoMaker.core;

public class SCMessageResult extends Message {

	public SCMessageResult(int msgId, String baseName) {
		super(msgId, baseName, "SC" + baseName + "Result");
	}

}
