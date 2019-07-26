package protoMaker.main;

import protoMaker.core.CSMessage;
import protoMaker.core.Type;

public class MsgPetHangUp {

	public MsgPetHangUp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		new CSMessage(16519, "GetPetHangUpInfo")
		.addComment("获取宠物挂机数据")
		.print()
		
		.createSCResult()
		
		.add(Type.INT, "killCount")
		.add(Type.INT, "maxKillCount")
		.add(Type.INT, "accelerateCount")

		// optional
		.addOptional(Type.LONG, "petId")
		.addOptional(Type.INT, "reduceInAdvance")
		.addOptional(Type.INT, "totalKillCount")
		.addOptional(Type.BOOL, "accelerate")
		.addOptional(Type.BOOL, "finish")
		.addOptional(Type.LONG, "duration")
		.println()
		
		.createCS("GainPetHangUp")
		.addComment("获取宠物挂机经验")
		.print()
		
		.createSCResult()
		.add(Type.INT, "result")
		.addOptional(Type.LONG, "exp")
		.addRepeated(Type.create("DRewardItem"), "items")
		
		.println()
		
		// 独立结构，不是协议
//		.create("DRewardItem")
//		.addComment("道具奖励结构")
//		.add(Type.INT, "sn")
//		.add(Type.INT, "num")
//		.println()
		
		
		;

	}
}
