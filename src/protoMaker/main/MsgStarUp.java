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
		
		.createSCResult()
		.add(Type.INT, "result")
		.endln()
		
		.createCS("AttachEvil")
		.comment("附魔")
		.add(Type.LONG, "equipmentId")
		.add(Type.INT, "star", "洗练目标星级属性")
		.addRepeated(Type.LONG, "costItemIds")
		
		.createSCResult()
		.add(Type.INT, "result")
		.endln()
		
		.createSC("UpdateEvilEffect")
		.comment("更新附魔效果")
		.add(Type.INT, "suit", "套装")
		.add(Type.INT, "star", "星级")
		.endln()
		
		.finish();
		
		regin.end();
		
	}
}
