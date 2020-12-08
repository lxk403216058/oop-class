package Test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
	String request1 = null;

	public Check() {

	}

	public boolean check(String request) {//�Դ�����ַ�����ʽ�ж�
		request1 = request;
		String[] regexString = { "\\(FR,\\d+,(UP|DOWN),\\d+\\)", "\\(ER,\\d+,\\d+\\)" };

		for (int i = 0; i < regexString.length; i++) {
			Pattern pattern = Pattern.compile(regexString[i]);
			Matcher matcher = pattern.matcher(request);

			if (matcher.matches()) {
				return checkFloor(request) && checkTime(request);
			}
		}
		return false;

	}

	public boolean checkFloor(String request) {//�ж�¥���Ƿ����10¥С��1¥
		String[] str = request.split(",");

		if (Integer.valueOf(str[1]) > 10 || Integer.valueOf(str[1]) < 1) {
			return false;
		}

		return true;
	}

	public boolean checkTime(String request) {//�ж�ʱ���Ƿ�С��0

		String[] str = request.split(",");
		switch (str[0]) {
		case "(FR":
			if (Float.valueOf(str[3].replace(")", "")) < 0) {
				if (Integer.valueOf(str[1]) == 1){
					return str[2] != "DOWN";
				}
				if (Integer.valueOf(str[1]) == 10){
					return str[2] != "UP";
				}
				return false;
			}
			break;
		case "(ER":
			if (Float.valueOf(str[2].replace(")", "")) < 0) {
				return false;
			}
			break;
		}

		return true;
	}
	
	public String toString(){
		return "INVALID[" + request1 + "]";
	}
}
