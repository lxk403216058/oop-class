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
		//初始化一个窗口
		JFrame loginWindow = new JFrame();
		
		//2.确定窗体的布局方式
		loginWindow.setLayout(new BorderLayout());
		
		//3.使用jlable标签将logo防止在相应的位置
		Icon logoimage = new ImageIcon("src/image/logo_login.jpg");
		JLabel logo = new JLabel(logoimage);
		
		//4.将Jlable放到IFrame窗口上
		loginWindow.add(logo,BorderLayout.WEST);
		//loginWindow.setBackground(Color.WHITE);
		
		//使用中间容器:JPanel
		//将所有输入组件和按钮放至JPane
		JPanel inputJPanel = new JPanel();//中间容器JPanel
		//设置inputPanel的布局方式为绝对布局
		inputJPanel.setLayout(null);
		
		//添加用户名标签和用户输入框
		JLabel name_label = new JLabel("名  称");
		name_label.setBounds(20, 80, 80, 20);
		JTextField inputName = new JTextField(28);
		inputName.setBounds(20, 110, 220, 30);
		
		inputJPanel.add(name_label);
		inputJPanel.add(inputName);
		inputJPanel.setBackground(Color.WHITE);//设置输入框的颜色
		
		//添加密码标签和密码输入框
		JLabel pwd_label = new JLabel("密  码");
		pwd_label.setBounds(20, 140, 80, 20);
		JPasswordField inputPwd = new JPasswordField(28);
		inputPwd.setBounds(20, 170, 220, 30);
		
		inputJPanel.add(pwd_label);
		inputJPanel.add(inputPwd);
		
		//添加登录和退出按钮
		JButton loginBtn = new JButton("登录");
		loginBtn.setBounds(20, 220, 60, 30);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = inputName.getText().trim();
				String userPwd = inputPwd.getText();
				
				//用户名和密码不能为空
				if (!"".equals(userName)&&!"".equals(userPwd)) {
					UserService userService = new UserServiceImpl();
					boolean loginFalg = userService.login(userName, userPwd);
					//如果用户名和密码存在则登录成功，跳转至下一界面
					if (loginFalg) {
						//跳转到下一界面
						//System.out.println("这里是主界面");
						loginWindow.setVisible(false);//关闭现有界面
						Index_test index_test = new Index_test();//创建新的界面
						
					}else {
						//提示用户名或密码错误
						JOptionPane.showMessageDialog(null, "用户名或密码错误");
					}
					//System.out.println("用户名："+userName+ "\r\n密码：" +userPwd);
				} else {
					JOptionPane.showMessageDialog(null, "用户名或密码为空");
				}
			}
		});
		inputJPanel.add(loginBtn);
		
		JButton exitBtn = new JButton("退出");
		exitBtn.setBounds(180, 220, 60, 30);
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		inputJPanel.add(exitBtn);
		
		loginWindow.add(inputJPanel, BorderLayout.CENTER);
		loginWindow.getContentPane().setBackground(Color.WHITE);//设置主面板的颜色
		loginWindow.setIconImage(Toolkit.getDefaultToolkit().createImage("src/image/logo.jpg"));
		loginWindow.setResizable(false);//设置窗体的大小不可见
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setBounds(200, 200, 600, 400);//设置窗体显示的位置
		loginWindow.setVisible(true);//设置窗体可见
	}

}
