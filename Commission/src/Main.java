import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�����뱾�����۵�ǹ����ǹ�У�ǹ�ܵ�������");
		int x,y,z;
		x = input.nextInt();
		y = input.nextInt();
		z = input.nextInt();
		
		Commisssion commisssion = new Commisssion(x,y,z);
		commisssion.commission();
	}

}
