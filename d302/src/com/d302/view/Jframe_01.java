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
		//1.初始化窗体
		JFrame jf = new JFrame("我的第一个窗体");
		jf.setLayout(new BorderLayout());
		//添加组件
		
		JButton test_north = new JButton("唱跳rap篮球");
		jf.add(test_north,BorderLayout.NORTH);
		
		JButton test_west = new JButton("我是蔡徐坤");
		jf.add(test_west,BorderLayout.WEST);
		jf.setIconImage(Toolkit.getDefaultToolkit().createImage("src/image/lp1.jpg"));
		jf.setResizable(false);//设置窗体的大小不可见
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 500, 400);//设置窗体显示的位置
		jf.setVisible(true);//设置窗体可见
		

	}

}

class MyWindowListener extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.out.println("我要关闭了....");
		System.exit(0);
	}
}
