package Experiment1;

//ѧ����
public class Student {
	
	private String studentID;
	private String studentName;
	private double[] score = new double[4];

	public Student() {

	}

	public String getName() {// ���ݵķ�����
		return studentName;
	}

	public String getID() {
		return studentID;
	}

	public double[] getScore() {
		return score;
	}

	// ѧ�����췽��
	public Student(String studentID, String studentName, double[] score) {
		this.studentID = studentID;
		this.studentName = studentName;

		for (int i = 0; i < 4; i++)
			this.score[i] = score[i];
	}

	// �ҳ�ѧ������óɼ�
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

	// ����ѧ����ƽ���ɼ�
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
