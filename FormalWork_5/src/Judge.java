
public class Judge {
	private boolean value = true;

	public Judge() {//无参构造

	}

	public boolean JudgeValue(String[] strs) {//综合判断方法减少圈复杂度
		if (strs.length == 4) {
			value = JudgeS(strs);
		} else if (strs.length == 3) {
			value = JudgeL(strs);
		}else{
			value = false;
		}
		return value;
	}
	
	public boolean init(){//同一个类要用到此类需要重置此对象
		value = true;
		return true;
	}
	
	private boolean JudgeS(String[] strs) {//判断楼层类请求是否符合规范
		
		if(strs[1].matches("1")&&strs[2].matches("DOWN"))
			value = false;
		if(strs[1].matches("10")&&strs[2].matches("UP"))
			value = false;
		if (!strs[0].matches("\\(FR"))
			value = false;
		if (!strs[1].matches("[\\d]*"))
			value = false;
		else if (Integer.valueOf(strs[1]) > 10 || Integer.valueOf(strs[1]) < 1) {
			value = false;
		}
		if (!(strs[2].matches("UP") || strs[2].matches("DOWN")))
			value = false;
		if (!strs[3].matches("[\\d]*\\)"))
			value = false;
		
		return value;
	}

	private boolean JudgeL(String[] strs) {//判断电梯内请求是否符合规范
		if (!strs[0].matches("\\(ER"))
			value = false;
		if (!strs[1].matches("[\\d]*"))
			value = false;
		else if (Integer.valueOf(strs[1]) > 10 || Integer.valueOf(strs[1]) < 1) {
			value = false;
		}
		if (!strs[2].matches("[\\d]*\\)"))
			value = false;
		
		return value;
	}

}
