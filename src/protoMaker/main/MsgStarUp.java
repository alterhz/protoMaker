package protoMaker.main;

import protoMaker.core.CSMessage;
import protoMaker.core.Region;
import protoMaker.core.Type;

public class MsgStarUp {

	public static void main(String[] args) {
		
		Region regin = new Region("装备升星");
		
		regin.beginln();
		
		new CSMessage(2877, "StarUp")
		.comment("升星")
		.add(Type.LONG, "equipmentId")
		.add(Type.INT, "tarItemSn", "目标装备sn")
		.end()
		
		.createSCResult()
		.add(Type.INT, "result")
		.endln()
		
		.createCS("AttachEvil")
		.comment("附魔")
		.add(Type.LONG, "equipmentId")
		.addRepeated(Type.LONG, "costItemIds")
		.end()
		
		.createSCResult()
		.add(Type.INT, "result")
		.endln()
		
		// end
		;
		
		regin.end();
		
	}
}
