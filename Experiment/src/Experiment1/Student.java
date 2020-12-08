package Experiment1;

//学生类
public class Student {
	
	private String studentID;
	private String studentName;
	private double[] score = new double[4];

	public Student() {

	}

	public String getName() {// 数据的访问器
		return studentName;
	}

	public String getID() {
		return studentID;
	}

	public double[] getScore() {
		return score;
	}

	// 学生构造方法
	public Student(String studentID, String studentName, double[] score) {
		this.studentID = studentID;
		this.studentName = studentName;

		for (int i = 0; i < 4; i++)
			this.score[i] = score[i];
	}

	// 找出学生的最好成绩
	public double max() {
		int i;
		double max;
		max = 0;

		for (i = 0; i <= 3; i++) {
			if (max < score[i])
				max = score[i];
		}

		return max;

	}

	// 计算学生的平均成绩
	public double averageScore() {
		double average = 0, sum = 0;
		int i;

		for (i = 0; i < 4; i++) {
			sum += score[i];
		}
		average = sum / 4;

		return average;
	}
}
