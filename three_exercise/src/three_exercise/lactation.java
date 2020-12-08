package three_exercise;
//海洋哺乳动物
public class lactation extends Animals {
	
	final static int numberRange = 200000;

	public lactation(String name, int age, String sex, int feedTime, trainer trainer) {
		super(name, age, sex, feedTime, trainer);
		tier = "海洋哺乳动物类";
	}
	public lactation(){
		
	}
}
