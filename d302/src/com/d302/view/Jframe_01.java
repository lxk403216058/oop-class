package com.d302.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jframe_01 {

	public static void main(String[] args) {
		//1.��ʼ������
		JFrame jf = new JFrame("�ҵĵ�һ������");
		jf.setLayout(new BorderLayout());
		//������
		
		JButton test_north = new JButton("����rap����");
		jf.add(test_north,BorderLayout.NORTH);
		
		JButton test_west = new JButton("���ǲ�����");
		jf.add(test_west,BorderLayout.WEST);
		jf.setIconImage(Toolkit.getDefaultToolkit().createImage("src/image/lp1.jpg"));
		jf.setResizable(false);//���ô���Ĵ�С���ɼ�
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 500, 400);//���ô�����ʾ��λ��
		jf.setVisible(true);//���ô���ɼ�
		

	}

}

class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.out.println("��Ҫ�ر���....");
		System.exit(0);
	}
}
