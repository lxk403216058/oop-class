package Experiment1;

import java.util.Scanner;

public class Experiment1_1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] s = new double[4];// �ɼ�����
		double[] f = new double[4];// �ɼ�����
		String id, name;// ѧ����ѧ�ź�����
		Student[] students = new Student[30];// 30��ѧ������
		int i = 0, j = 0;// ѭ������

		for (i = 0; i < 30; i++) {// ����30��ѧ�������ѭ��

			for (j = 0; j <= 3; j++) {
				s[j] = Math.random() * 100;// �������ѧ���ǵĳɼ�
			}
			name = "";
			for (j = 0; j < 5; j++) {
				name += (char) ('a' + Math.random() * 27);// �������һ��Сд��ĸ
			}
			id = "" + (13201100 + i + 1);//ѧ�ŵĹ���
			students[i] = new Student(id, name, s);//����ѧ������
		}

		int sumAverage = 0;// ȫ��ѧ��ƽ���ɼ�֮��
		double averageMax = 0, averageAll = 0;// ȫ��ƽ���ɼ����������Ǹ���ȫ���ƽ���ɼ�
		
		for (i = 0; i < 30; i++) {// ��ȫ����ƽ������ߵ��Ǹ�����ȫ����ƽ���ֵĺ�
			if (averageMax < students[i].averageScore()) {
				averageMax = students[i].averageScore();// �ҳ�ƽ���ɼ���õ�ѧ������ס����λ��
				j = i;
			}
			sumAverage += students[i].averageScore();// ���ȫ����ƽ���ɼ��ĺ�
		}
		averageAll = sumAverage / 30;//��ȫ��ƽ���ɼ�

		System.out.println("������ѧ������:");
		name = input.next();
		System.out.println("������ѧ��ѧ��:");
		id = input.next();
		System.out.println("���������ſεĳɼ����Կո�ָ�: ");
		f[0] = input.nextInt();
		f[1] = input.nextInt();
		f[2] = input.nextInt();
		f[3] = input.nextInt();
		Student s1;
		s1 = new Student(id, name, f);//�½�ѧ������

		if (f[0] > 100 || f[1] > 100 || f[2] > 100 || f[3] > 100)// ����ѧ���ɼ���һ�����ϳ���100
			System.out.println("�γ̳ɼ����ܸ���100�֣���");

		else if (s1.averageScore() < averageAll) {// �����ѧ���ɼ�С��ȫ��ƽ���ɼ�ʱ
			System.out.println(s1.getName() + "(ID:" + s1.getID() + ") ƽ���� " + s1.averageScore() + " ��߷� " + s1.max());
			System.out.println(students[j].getName()  + "(ID:" + students[j].getID() + ") ƽ���� "+ students[j].averageScore() + " ��߷� " + students[j].max());
			System.out.println(s1.getName()  + "��ƽ���ɼ�����ȫ���ƽ���� " + averageAll);
		} 
		
		else if (s1.averageScore() > averageAll && s1.averageScore() < students[j].averageScore()) {// �����ѧ���ɼ�����ȫ��ƽ���ɼ�ʱ��С��ƽ���ɼ����ѧ����ƽ���ɼ�
			System.out.println(s1.getName()  + "(ID:" + s1.getID() + ") ƽ���� " + s1.averageScore() + " ��߷� " + s1.max());
			System.out.println(students[j].getName() + "(ID:" + students[j].getID() + ") ƽ���� "+ students[j].averageScore() + " ��߷� " + students[j].max());
			System.out.println(s1.getName()  + "��ƽ���ɼ�����ȫ���ƽ���� " + averageAll);
		} 
		
		else {// �����ѧ���ɼ�����ƽ���ɼ����ѧ����ƽ���ɼ�
			System.out.println(s1.getName()  + "(ID:" + s1.getID() + ") ƽ���� " + s1.averageScore() + " ��߷� " + s1.max());
			System.out.println(s1.getName()  + "�����ǰ��ϳɼ���õ�ѧ����");
			System.out.println(s1.getName()  + "��ƽ���ɼ�����ȫ���ƽ���� " + averageAll);
		}
	}
}


