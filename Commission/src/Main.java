import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入本月销售的枪机，枪托，枪管的数量：");
		int x,y,z;
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		
		Commisssion commisssion = new Commisssion(x,y,z);
		commisssion.commission();
	}

}
