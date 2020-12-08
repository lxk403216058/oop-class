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
			return "输入非法";
		}
		if (!isTrueTri(side1,side2,side3)) {
			return "非三角形";
		} else {
			if (side1 == side2 && side2 == side3) {
				return "等边三角形";
			} else if (side1 == side2 || side2 == side3 || side1 == side3) {
				return "等腰三角形";
			} else
				return "普通三角形";
		}
	}

}
