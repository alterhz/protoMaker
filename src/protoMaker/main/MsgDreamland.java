package protoMaker.main;

import protoMaker.core.CSMessage;
import protoMaker.core.Region;
import protoMaker.core.Type;

public class MsgDreamland {

	public static void main(String[] args) {
		Region regin = new Region("暴风幻境");
		regin.beginln();
		
		new CSMessage(16710, "GetDreamLandLineInfo")
		.comment("获取暴风幻境数据")
		.add(Type.INT, "stageSn")
		
		.createSCResult()
		.add(Type.BOOL, "coreRight", "核心进入权限")
		.addRepeated(Type.create("DLineInfo"), "lineInfos")
		.addRepeated(Type.create("DKillInfo"), "monsterInfos")
		.endln()
		
		.createCS("GetDreamLandDamageInfo")
		.comment("获取伤害数据")
		.add(Type.INT, "stageSn")
		.add(Type.INT, "monsterSn")
		
		.createSCResult()
		.add(Type.INT, "stageSn")
		.add(Type.INT, "monsterSn")
		.addRepeated(Type.create("DDamageInfo"), "damageInfos")
		.endln()
		
		// 独立结构，不是协议
		.create("DLineInfo")
		.comment("分线数据")
		.add(Type.LONG, "stageId")
		.add(Type.INT, "humanNum", "场景人数")
		.add(Type.INT, "unionHumanNum", "工会人数")
		.endln()
		
		.create("DKillInfo")
		.comment("击杀数据")
		.add(Type.INT, "monsterSn")
		.add(Type.BOOL, "dead", "怪物是否死亡")
		.addOptional(Type.LONG, "firstBloodHumanId", "第一击玩家")
		.addOptional(Type.STRING, "firstBloodHumanName")
		.addOptional(Type.LONG, "firstBloodDamageValue", "第一击玩家所属工会伤害")
		.addOptional(Type.LONG, "lastBloodHumanId", "最后一击玩家")
		.addOptional(Type.STRING, "lasttBloodHumanName")
		.addOptional(Type.LONG, "lastBloodDamageValue", "最后一击玩家所属工会伤害")
		.addOptional(Type.STRING, "unionName", "伤害最高的帮派名称")
		.endln()
		
		.create("DDamageInfo")
		.comment("伤害数据")
		.add(Type.INT, "unionId")
		.add(Type.STRING, "unionName", "最后击杀者帮派名称")
		.add(Type.LONG, "damage", "伤害")
		.endln()
		
		;
		
		regin.endln();
	}
}
