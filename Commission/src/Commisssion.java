
public class Commisssion {
	private int x;
	private int y;
	private int z;
	
	public Commisssion() {

	}

	public Commisssion(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void commission() {
		float n;
		
		if ((x >= 1 && x <= 70) && (y >= 1 && y <= 80) && (z >= 1 && z <= 90)){
			 n = 45*x + 30*y + 25*z;
			if (n <= 1000) {
				System.out.println("ǹ������" + x + "ǹ������" + y + "ǹ������" + z + "�����ܶ" + n + "Ӷ��" + 0.1*n);
			} else if (n > 1000 && n <= 1800) {
				System.out.println("ǹ������" + x + "ǹ������" + y + "ǹ������" + z + "�����ܶ" + n + "Ӷ��" + 0.15*n);
			}else {
				System.out.println("ǹ������" + x + "ǹ������" + y + "ǹ������" + z + "�����ܶ" + n + "Ӷ��" + 0.2*n);
			}
		}else {
			System.out.println("���뷶Χ������");
		}
	}
	
}
