public class Triangle {

	public Triangle() {
		
	}

	

	public boolean isTrueTri(int side1,int side2,int side3) {
		if ((side1 + side2 > side3) && (side1 + side3 > side2) && (side3 + side2 > side1))
			return true;
		else
			return false;
	}

	public String type(int side1,int side2,int side3) {
		if ((side1>200 || side1<=0)||(side2>200 || side2<=0)||(side3>200 || side3<=0)) {
			return "����Ƿ�";
		}
		if (!isTrueTri(side1,side2,side3)) {
			return "��������";
		} else {
			if (side1 == side2 && side2 == side3) {
				return "�ȱ�������";
			} else if (side1 == side2 || side2 == side3 || side1 == side3) {
				return "����������";
			} else
				return "��ͨ������";
		}
	}

}
