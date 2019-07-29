package protoMaker.core;

public class MessagePair {

	private final CSMessage csProtocol;
	
	private final SCMessage scProtocol;
	
	public MessagePair() {
		// TODO Auto-generated constructor stub
		
		int msgId = 16518;
		String msgName = "GetPetHangUpInfo";
		
		csProtocol = new CSMessage(++msgId, msgName);
		scProtocol = new SCMessage(++msgId, msgName);
	}
	


	
	
}
