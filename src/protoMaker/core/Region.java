package protoMaker.core;

public class Region {
	
	private String content = "";
	
	public Region(String content) {
		this.content = content;
	}
	
	public static final String STR_LINE = "//--------------------------------------------------";
	
	public void begin() {
		System.out.println(STR_LINE);
		System.out.println("// " + content + " - begin - ");
		System.out.println(STR_LINE);
	}
	
	public void beginln() {
		begin();
		System.out.println();
	}
	
	public void end() {
		System.out.println(STR_LINE);
		System.out.println("// " + content + " - end - ");
		System.out.println(STR_LINE);
	}
	
	public void endln() {
		end();
		System.out.println();
	}
	
}
