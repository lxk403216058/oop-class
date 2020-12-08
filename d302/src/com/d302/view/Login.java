package com.d302.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.d302.service.UserService;
import com.d302.service.UserServiceImpl;

public class Login {
	public static void main(String[] args) {
		//��ʼ��һ������
		JFrame loginWindow = new JFrame();
		
		//2.ȷ������Ĳ��ַ�ʽ
		loginWindow.setLayout(new BorderLayout());
		
		//3.ʹ��jlable��ǩ��logo��ֹ����Ӧ��λ��
		Icon logoimage = new ImageIcon("src/image/logo_login.jpg");
		JLabel logo = new JLabel(logoimage);
		
		//4.��Jlable�ŵ�IFrame������
		loginWindow.add(logo,BorderLayout.WEST);
		//loginWindow.setBackground(Color.WHITE);
		
		//ʹ���м�����:JPanel
		//��������������Ͱ�ť����JPane
		JPanel inputJPanel = new JPanel();//�м�����JPanel
		//����inputPanel�Ĳ��ַ�ʽΪ���Բ���
		inputJPanel.setLayout(null);
		
		//����û�����ǩ���û������
		JLabel name_label = new JLabel("��  ��");
		name_label.setBounds(20, 80, 80, 20);
		JTextField inputName = new JTextField(28);
		inputName.setBounds(20, 110, 220, 30);
		
		inputJPanel.add(name_label);
		inputJPanel.add(inputName);
		inputJPanel.setBackground(Color.WHITE);//������������ɫ
		
		//��������ǩ�����������
		JLabel pwd_label = new JLabel("��  ��");
		pwd_label.setBounds(20, 140, 80, 20);
		JPasswordField inputPwd = new JPasswordField(28);
		inputPwd.setBounds(20, 170, 220, 30);
		
		inputJPanel.add(pwd_label);
		inputJPanel.add(inputPwd);
		
		//��ӵ�¼���˳���ť
		JButton loginBtn = new JButton("��¼");
		loginBtn.setBounds(20, 220, 60, 30);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = inputName.getText().trim();
				String userPwd = inputPwd.getText();
				
				//�û��������벻��Ϊ��
				if (!"".equals(userName)&&!"".equals(userPwd)) {
					UserService userService = new UserServiceImpl();
					boolean loginFalg = userService.login(userName, userPwd);
					//����û���������������¼�ɹ�����ת����һ����
					if (loginFalg) {
						//��ת����һ����
						//System.out.println("������������");
						loginWindow.setVisible(false);//�ر����н���
						Index_test index_test = new Index_test();//�����µĽ���
						
					}else {
						//��ʾ�û������������
						JOptionPane.showMessageDialog(null, "�û������������");
					}
					//System.out.println("�û�����"+userName+ "\r\n���룺" +userPwd);
				} else {
					JOptionPane.showMessageDialog(null, "�û���������Ϊ��");
				}
			}
		});
		inputJPanel.add(loginBtn);
		
		JButton exitBtn = new JButton("�˳�");
		exitBtn.setBounds(180, 220, 60, 30);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		inputJPanel.add(exitBtn);
		
		loginWindow.add(inputJPanel, BorderLayout.CENTER);
		loginWindow.getContentPane().setBackground(Color.WHITE);//������������ɫ
		loginWindow.setIconImage(Toolkit.getDefaultToolkit().createImage("src/image/logo.jpg"));
		loginWindow.setResizable(false);//���ô���Ĵ�С���ɼ�
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setBounds(200, 200, 600, 400);//���ô�����ʾ��λ��
		loginWindow.setVisible(true);//���ô���ɼ�
	}

}
