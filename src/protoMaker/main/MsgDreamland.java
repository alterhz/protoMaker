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
		
		.createCS("GetDreamLandBossInfo")
		.comment("获取场景怪物信息")
		.add(Type.INT, "stageSn")
		
		.createSCResult()
		.add(Type.INT, "stageSn")
		.add(Type.BOOL, "refresh", "是否刷新")
		.addOptional(Type.LONG, "waitTime", "等待时间")
		.addRepeated(Type.create("DBossInfo"), "bossInfos")
		.endln()
		
		//////////////////////////////////////////
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
		.addOptional(Type.create("DBloodInfo"), "firstBlood")
		.addOptional(Type.create("DBloodInfo"), "lastBlood")
		.addOptional(Type.LONG, "maxDamageUnionId")
		.addOptional(Type.STRING, "maxDamageUnionName")
		.addOptional(Type.LONG, "fightDuration")
		.endln()

		.create("DBloodInfo")
		.comment("第一击和最后一击数据")
		.add(Type.LONG, "humanId", "玩家")
		.add(Type.STRING, "humanName")
		.add(Type.LONG, "unionId", "玩家所属工会")
		.add(Type.STRING, "unionName")
		.add(Type.LONG, "damageValue", "工会伤害")
		.endln()

		.create("DDamageInfo")
		.comment("伤害数据")
		.add(Type.LONG, "unionId")
		.add(Type.STRING, "unionName", "最后击杀者帮派名称")
		.add(Type.LONG, "damage", "伤害")
		.endln()
		
		.create("DBossInfo")
		.comment("怪物数据")
		.add(Type.INT, "bossSn")
		.add(Type.LONG, "hp", "怪物血量")
		.endln()

		.finish();
		;
		
		regin.endln();
	}
}
