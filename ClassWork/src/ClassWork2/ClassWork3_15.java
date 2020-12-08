package ClassWork2;

import java.util.Scanner;

public class ClassWork3_15 {
	public static void main(String[] args) {
		int lottery=(int)(Math.random()*1000);
		Scanner input =new Scanner(System.in);
		System.out.println("Enter your lottery pick(three digits):");
		int guess = input.nextInt();
		System.out.println("The lottery number is "+lottery);
		
		int[] GuessDigits= new int[3];//1,GuessDigits2,GuessDigits3;
		GuessDigits[0]=guess/100;
		GuessDigits[1]=guess/10%10;
		GuessDigits[2]=guess%10;
		
		int[] LotteryDigits=new int[3];//1,LotteryDigits2,LotteryDigits3;
		LotteryDigits[0]=lottery/100;
		LotteryDigits[1]=lottery/10%10;
		LotteryDigits[2]=lottery%10;
		
		
		if(guess==lottery)
			System.out.println("Exact match: you win $10,000");
		else {
			int i,j,flag;
			flag=0;
			
			for (i=0;i<3;i++) {
				for (j=0;j<3;j++) {
					if (GuessDigits[i]==LotteryDigits[j]) {
						flag++;
						break;
					}
				}
			}
			if (flag==3) 
				System.out.println("Match three digits: you win $3,000");
			/*else if (flag==2) 
				System.out.println("Match two match :you win $2,000");*/
			else if (flag==1)
				System.out.println("Match one match :you win $1,000");
			else
				System.out.println("Sorry no match");
		}
		
	}

}
