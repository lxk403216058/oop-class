package com.bank.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.bank.controller.UserOperator;
import com.bank.entity.User;
import java.awt.Color;

public class CommonBusiness {
	
	public CommonBusiness(){
		JFrame frameIndex = new JFrame();
		JPanel panel = new JPanel(); 
		panel.setBackground(new Color(240, 255, 240));
		
		panel.setLayout(null);
		//��������������
		
		JLabel title = new JLabel("��ͨ�û���������");
		title.setFont(new Font("����",Font.BOLD,40));
		title.setBounds(210, 20, 400, 40);
		panel.add(title);
		
		JLabel txsfzh_label = new JLabel("���֤��:");
		txsfzh_label.setFont(new Font("����",Font.BOLD,20));
		txsfzh_label.setBounds(190,80,100,100);
		panel.add(txsfzh_label);
		final JTextField txsfzh_field = new JTextField();
		txsfzh_field.setPreferredSize(new Dimension(430,28)); 
		txsfzh_field.setBounds(300,115,200,30);
		panel.add(txsfzh_field);
		
		JLabel yhID_label = new JLabel("�û�����:");
		yhID_label.setFont(new Font("����",Font.BOLD,20));
		yhID_label.setBounds(190,150,100,100);
		panel.add(yhID_label);
		final JTextField yhID_field = new JTextField();
		yhID_field.setPreferredSize(new Dimension(430,28)); 
		yhID_field.setBounds(300,185,200,30);
		panel.add(yhID_field);
		
		JLabel mm_label = new JLabel("�û�����:");
		mm_label.setFont(new Font("����",Font.BOLD,20));
		mm_label.setBounds(190,220,100,100);
		panel.add(mm_label);
		final JTextField mm_field = new JTextField();
		mm_field.setPreferredSize(new Dimension(430,28)); 
		mm_field.setBounds(300,255,200,30);
		panel.add(mm_field);
		
		JLabel choice=new JLabel("ѡ���û�����:");
		choice.setFont(new Font("����",Font.BOLD,20));
		choice.setBounds(150,270,150,150);
		panel.add(choice);
		
		JButton btn3 = new JButton("��ͨ�û�");//��Ӱ�ť
		btn3.setBackground(new Color(152, 251, 152));
		JButton btn4=new JButton("VIP�û�");//��Ӱ�ť
		btn4.setBackground(new Color(152, 251, 152));
		
		btn3.setBounds(300,320,100,40);
		panel.add(btn3);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = txsfzh_field.getText();
				String name =  yhID_field.getText();
				String password = mm_field.getText();
				String type = "common";
				if (!"".equals(ID) && !"".equals(name) && !"".equals(password)) {
					UserOperator.saveUser(name, ID, password, type);
					User user = UserOperator.findUserID(ID);
					new PersonBusiness(user.getID());
					frameIndex.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "���֤�š�����������Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btn4.setBounds(430,320,100,40);
		panel.add(btn4);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ID = txsfzh_field.getText();
				String name =  yhID_field.getText();
				String password = mm_field.getText();
				String type = "vip";
				if (!"".equals(ID) && !"".equals(name) && !"".equals(password)) {
					UserOperator.saveUser(name, ID, password, type);
					User user = UserOperator.findUserID(ID);
					new PersonBusiness(user.getID());
					frameIndex.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "���֤�š�����������Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		frameIndex.getContentPane().add(panel, BorderLayout.CENTER);
		frameIndex.setSize(750, 500);//���ô��ڵĴ�С
		frameIndex.setLocation(500, 100);//��������
		frameIndex.setResizable(false);//�����Ƿ���Ըı䴰���С
		frameIndex.setIconImage(Toolkit.getDefaultToolkit().createImage("src/2.jpg"));//���ô������Ͻ���ʾ��ͼƬ
		frameIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��Ӵ���ر��¼�
		frameIndex.setVisible(true);//���ô����Ƿ�ɼ�
	}
	
	public static void main(String[] args) {
		new CommonBusiness();
	}

}
