package protoMaker.main;

import protoMaker.core.CSMessage;
import protoMaker.core.SCMessageResult;
import protoMaker.core.Type;

public class GainPetHangUp {

	public GainPetHangUp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int msgId = 16520;
		String msgName = "GainPetHangUp";
		
		new CSMessage(++msgId, msgName)
		.addComment("获取宠物挂机经验")
		.print();
		
		new SCMessageResult(++msgId, msgName)
		.add(Type.INT, "result")
		.print();
	}
}
