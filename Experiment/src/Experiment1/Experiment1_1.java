package Experiment1;

import java.util.Scanner;

public class Experiment1_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] s = new double[4];// 成绩数组
		double[] f = new double[4];// 成绩数组
		String id, name;// 学生的学号和名字
		Student[] students = new Student[30];// 30个学生对象
		int i = 0, j = 0;// 循环变量

		for (i = 0; i < 30; i++) {// 创建30个学生对象的循环

			for (j = 0; j <= 3; j++) {
				s[j] = Math.random() * 100;// 随机产生学生们的成绩
			}
			name = "";
			for (j = 0; j < 5; j++) {
				name += (char) ('a' + Math.random() * 27);// 随机产生一个小写字母
			}
			id = "" + (13201100 + i + 1);//学号的构造
			students[i] = new Student(id, name, s);//创建学生对象
		}

		int sumAverage = 0;// 全班学生平均成绩之和
		double averageMax = 0, averageAll = 0;// 全班平均成绩的中最大的那个，全班的平均成绩
		
		for (i = 0; i < 30; i++) {// 求全班人平均分最高的那个和求全班人平均分的和
			if (averageMax < students[i].averageScore()) {
				averageMax = students[i].averageScore();// 找出平均成绩最好的学生并记住他的位置
				j = i;
			}
			sumAverage += students[i].averageScore();// 获得全班人平均成绩的和
		}
		averageAll = sumAverage / 30;//求全班平均成绩

		System.out.println("请输入学生姓名:");
		name = input.next();
		System.out.println("请输入学生学号:");
		id = input.next();
		System.out.println("请输入四门课的成绩，以空格分隔: ");
		f[0] = input.nextInt();
		f[1] = input.nextInt();
		f[2] = input.nextInt();
		f[3] = input.nextInt();
		Student s1;
		s1 = new Student(id, name, f);//新建学生对象

		if (f[0] > 100 || f[1] > 100 || f[2] > 100 || f[3] > 100)// 输入学生成绩有一门以上超过100
			System.out.println("课程成绩不能高于100分！！");

		else if (s1.averageScore() < averageAll) {// 输入的学生成绩小于全班平均成绩时
			System.out.println(s1.getName() + "(ID:" + s1.getID() + ") 平均分 " + s1.averageScore() + " 最高分 " + s1.max());
			System.out.println(students[j].getName()  + "(ID:" + students[j].getID() + ") 平均分 "+ students[j].averageScore() + " 最高分 " + students[j].max());
			System.out.println(s1.getName()  + "的平均成绩低于全班的平均分 " + averageAll);
		} 
		
		else if (s1.averageScore() > averageAll && s1.averageScore() < students[j].averageScore()) {// 输入的学生成绩大于全班平均成绩时且小于平均成绩最高学生的平均成绩
			System.out.println(s1.getName()  + "(ID:" + s1.getID() + ") 平均分 " + s1.averageScore() + " 最高分 " + s1.max());
			System.out.println(students[j].getName() + "(ID:" + students[j].getID() + ") 平均分 "+ students[j].averageScore() + " 最高分 " + students[j].max());
			System.out.println(s1.getName()  + "的平均成绩高于全班的平均分 " + averageAll);
		} 
		
		else {// 输入的学生成绩大于平均成绩最高学生的平均成绩
			System.out.println(s1.getName()  + "(ID:" + s1.getID() + ") 平均分 " + s1.averageScore() + " 最高分 " + s1.max());
			System.out.println(s1.getName()  + "现在是班上成绩最好的学生了");
			System.out.println(s1.getName()  + "的平均成绩高于全班的平均分 " + averageAll);
		}
	}
}


