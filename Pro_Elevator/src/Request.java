
import java.util.ArrayList;

public class Request {
	private Floor f;
	private Lift l = new Lift();
	private ArrayList<String> str = new ArrayList<String>();
	private ArrayList<String> s = new ArrayList<String>();

	public Request() {

	}

	public boolean checkRepeat(String req) {//判断时间错误的指令
		str.add(req);

		for (int i = 0; i < str.size(); i++) {

			String str1 = req.replace("(", "");
			str1 = str1.replace(")", "");
			String[] r1 = str1.split(",");//对需要判断的内容进行拆分
			for (int j = 0; j < i; j++) {
				String str2 = str.get(j).replace("(", "");
				str2 = str2.replace(")", "");
				String[] r2 = str2.split(",");

				if (r1[0].equals(r2[0]) && r1[1].equals(r2[1])) {

					if (r1.length == 3 && r2.length == 3) {
						float T1 = Float.valueOf(r1[2]);
						float T2 = Float.valueOf(r2[2]);
						int f1 = Integer.valueOf(r1[1]);

						if (j > 0) {//如果上上个指令正确则获得其楼层位置否则默认在一楼
							String str3 = str.get(j - 1).replace("(", "");
							str3 = str3.replace(")", "");
							String[] cmp = str3.split(",");
							int f0 = Integer.valueOf(cmp[1]);
							if (T1 <= (T2 + Math.abs(f1 - f0) * 0.5 + 1)) {
								s.add("SAME[" + str1 + "]");
								str.remove(str.size() - 1);//如果不符合要求则将其移除ArrayList
								return false;
							}
						} else {
							if (T1 <= (T2 + (f1 - 1) * 0.5 + 1)) {
								s.add("SAME[" + str1 + "]");
								str.remove(str.size() - 1);
								return false;
							}
						}
					}
					if (r1.length == 4 && r2.length == 4) {
						float T1 = Float.valueOf(r1[3]);
						float T2 = Float.valueOf(r2[3]);
						int f1 = Integer.valueOf(r1[1]);

						if (j > 0) {
							String str3 = str.get(j - 1).replace("(", "");
							str3 = str3.replace(")", "");
							String[] cmp = str3.split(",");
							int f0 = Integer.valueOf(cmp[1]);
							if (T1 <= (T2 + Math.abs(f1 - f0) * 0.5 + 1)) {
								s.add("SAME[" + str1 + "]");
								str.remove(str.size() - 1);
								return false;
							}
						} else {
							if (T1 <= (T2 + (f1 - 1) * 0.5 + 1)) {
								s.add("SAME[" + str1 + "]");
								str.remove(str.size() - 1);
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}

	public ArrayList<String> getStr() {
		return str;
	}

}
