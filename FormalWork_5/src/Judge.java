
public class Judge {
	private boolean value = true;

	public Judge() {//�޲ι���

	}

	public boolean JudgeValue(String[] strs) {//�ۺ��жϷ�������Ȧ���Ӷ�
		if (strs.length == 4) {
			value = JudgeS(strs);
		} else if (strs.length == 3) {
			value = JudgeL(strs);
		}else{
			value = false;
		}
		return value;
	}
	
	public boolean init(){//ͬһ����Ҫ�õ�������Ҫ���ô˶���
		value = true;
		return true;
	}
	
	private boolean JudgeS(String[] strs) {//�ж�¥���������Ƿ���Ϲ淶
		
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

	private boolean JudgeL(String[] strs) {//�жϵ����������Ƿ���Ϲ淶
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
