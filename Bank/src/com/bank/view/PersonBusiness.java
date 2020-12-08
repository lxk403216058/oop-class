package com.bank.view;
//�������ҵ��ʱҪʵ�ֵ�2�����棬�����У�1��ѯ�˻���Ϣ��2�洢Ǯ�3ȡ����Ǯ��4ת�ˣ�5�����»���6�޸����룬ʹ�ÿ�Ƭ����


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.bank.controller.UserOperator;
import com.bank.entity.User;



public class PersonBusiness {
	CardLayout card = new CardLayout();
	JPanel panel = new JPanel(); 
	private int flag = 0;
	private User user;

	public PersonBusiness (int cno){
		JFrame frameIndex = new JFrame();

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(245, 255, 250));
		
		menuBar.setPreferredSize(new Dimension(40,60));
		
		final JMenu search = new JMenu("��ѯ�˻���Ϣ");
		search.setBackground(new Color(240, 255, 240));
		search.setFont(new Font("����",Font.BOLD,20));
		search.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				card.show(panel, "searchPanel");
			}
		});
		menuBar.add(search);
		
		
		JMenu save = new JMenu("��/ȡǮ��");
		save.setFont(new Font("����",Font.BOLD,20));
		
		save.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				Object[] obj2={"���","ȡ��"};
				String string = (String) JOptionPane.showInputDialog(null,"������ѡ��:\n","��/ȡ���",JOptionPane.PLAIN_MESSAGE,new ImageIcon("src//1.jpg"),obj2,"���");
				if(string != null){
				if("���".equals(string)||"ȡ��".equals(string)){
					card.show(panel, "addPanel");
					if ("���".equals(string)) {
						flag = 1;
					} else {
						flag = 2;
					}
				}
				else
					card.show(panel, "searchPanel");
			}
		}
	});
		
		menuBar.add(save);
				
		JMenu zz = new JMenu("ת��");
		zz.setFont(new Font("����",Font.BOLD,20));
		zz.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
			 card.show(panel,"zzPanel");
			}
		});	
		menuBar.add(zz);
		
		JMenu kh = new JMenu("����");
		kh.setFont(new Font("����",Font.BOLD,20));
		kh.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
			 card.show(panel,"khPanel");
			}
		});
		menuBar.add(kh);
		
		
		JMenu xg = new JMenu("�޸�����");
		xg.setFont(new Font("����",Font.BOLD,20));
		xg.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
			 card.show(panel,"xgPanel");
			}
		});
		menuBar.add(xg);
		
		frameIndex.setJMenuBar(menuBar);
		panel.setBackground(Color.WHITE);
		
		//������
		panel.setLayout(card);
		
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(240, 255, 240));
		searchPanel.setLayout(null);
		//��ӱ�����
		//�����ά������Ϊ�������
        
		//��Ӵ�/ȡǮ���
		JPanel addPanel = new JPanel();
		addPanel.setBackground(new Color(240, 255, 240));
		addPanel.setLayout(null);
		
		//���ת�����
		JPanel zzPanel = new JPanel();
		zzPanel.setBackground(new Color(240, 255, 240));
		zzPanel.setLayout(null);
		
	    //�޸��������
		JPanel xgPanel = new JPanel();
		xgPanel.setBackground(new Color(240, 255, 240));
		xgPanel.setLayout(null);
		
		//�������
	    JPanel khPanel=new JPanel();
	    khPanel.setBackground(new Color(240, 255, 240));
		khPanel.setLayout(null);
		
		//��������������
		JLabel txsfzh_label = new JLabel("���֤��:");
		txsfzh_label.setFont(new Font("����",Font.BOLD,20));
		txsfzh_label.setBounds(160,30,96,40);
		khPanel.add(txsfzh_label);
		final JTextField txsfzh_field = new JTextField();
		txsfzh_field.setPreferredSize(new Dimension(430,28)); 
		txsfzh_field.setBounds(270,37,200,30);
		khPanel.add(txsfzh_field);
		
		JLabel yhID_label = new JLabel("�û�����:");
		yhID_label.setFont(new Font("����",Font.BOLD,20));
		yhID_label.setBounds(160,100,100,40);
		khPanel.add(yhID_label);
		final JTextField yhID_field = new JTextField();
		yhID_field.setPreferredSize(new Dimension(430,28)); 
		yhID_field.setBounds(270,107,200,30);
		khPanel.add(yhID_field);
		
		JLabel mm_label = new JLabel("�û�����:");
		mm_label.setFont(new Font("����",Font.BOLD,20));
		mm_label.setBounds(160,170,96,40);
		khPanel.add(mm_label);
		final JTextField mm_field = new JTextField();
		mm_field.setPreferredSize(new Dimension(430,28)); 
		mm_field.setBounds(270,177,200,30);
		khPanel.add(mm_field);
		
		JLabel choice=new JLabel("ѡ���û�����:");
		choice.setFont(new Font("����",Font.BOLD,20));
		choice.setBounds(110,241,142,45);
		khPanel.add(choice);
		
		//��ѯ�û���Ϣ����������
		user = UserOperator.find(cno);
		JLabel kh2_label = new JLabel("����:");
		kh2_label.setFont(new Font("����",Font.BOLD,20));
		kh2_label.setBounds(240,10,100,100);
		searchPanel.add(kh2_label);
		TextField userCno = new TextField();
		String userC = null;
		if (user != null) {
			userC = user.getID()+"";
		}
		
		userCno.setText(userC);
		userCno.setFont(new Font("����",Font.BOLD,20));
		userCno.setBounds(340, 50, 150, 30);
		searchPanel.add(userCno);
	
		JLabel yhmc_label=new JLabel("�û�����:");
		yhmc_label.setFont(new Font("����",Font.BOLD,20));
		yhmc_label.setBounds(200,50,100,100);
		searchPanel.add(yhmc_label);
		TextField userName = new TextField();
		if (user != null) {
			userName.setText(user.getName());
		}
		userName.setFont(new Font("����",Font.BOLD,20));
		userName.setBounds(340, 88, 150, 30);
		searchPanel.add(userName);
		
		JLabel sfzh_label=new JLabel("���֤��:");
		sfzh_label.setFont(new Font("����",Font.BOLD,20));
		sfzh_label.setBounds(200,90,100,100);
		searchPanel.add(sfzh_label);
		TextField userID = new TextField();
		if (user != null) {
			userID.setText(user.getIDNo());
		}
		userID.setFont(new Font("����",Font.BOLD,20));
		userID.setBounds(340, 126, 150, 30);
		searchPanel.add(userID);
		
		JLabel kzbh_label=new JLabel("���۱��:");
		kzbh_label.setFont(new Font("����",Font.BOLD,20));
		kzbh_label.setBounds(200,130,100,100);
		searchPanel.add(kzbh_label);
		TextField userPno = new TextField();
		if (user != null) {
			userPno.setText(user.getPno());
		}
		userPno.setFont(new Font("����",Font.BOLD,20));
		userPno.setBounds(340, 164, 150, 30);
		searchPanel.add(userPno);
		
		JLabel zhye_label=new JLabel("�˻����:");
		zhye_label.setFont(new Font("����",Font.BOLD,20));
		zhye_label.setBounds(200,170,100,100);
		searchPanel.add(zhye_label);
		String ac = null;
		if (user != null) {
			ac = user.getAmount()+"";
		}
		TextField userAmount = new TextField();
		userAmount.setText(ac);
		userAmount.setFont(new Font("����",Font.BOLD,20));
		userAmount.setBounds(340, 205, 150, 30);
		searchPanel.add(userAmount);
		
		JLabel type_label=new JLabel("�û�����:");
		type_label.setFont(new Font("����",Font.BOLD,20));
		type_label.setBounds(200,210,100,100);
		searchPanel.add(type_label);
		TextField userType = new TextField();
		if (user != null) {
			userType.setText(user.getType());
		}
		userType.setFont(new Font("����",Font.BOLD,20));
		userType.setBounds(340, 246, 150, 30);
		searchPanel.add(userType);

		
		
		//�޸��������������
		
		JLabel ymm_label = new JLabel("ԭ����:");
		ymm_label.setFont(new Font("����",Font.BOLD,20));
		ymm_label.setBounds(188,49,84,40);
		xgPanel.add(ymm_label);
		final JTextField ymm_field = new JTextField();
		ymm_field.setPreferredSize(new Dimension(430,28)); 
		ymm_field.setBounds(286,56,200,30);
		xgPanel.add(ymm_field);
		
		JLabel xmm_label = new JLabel("������:");	
		xmm_label.setFont(new Font("����",Font.BOLD,20));
		xmm_label.setBounds(188,119,84,40);
		xgPanel.add(xmm_label);
		final JTextField xmm_field = new JTextField();
		xmm_field.setPreferredSize(new Dimension(430,28)); 
		xmm_field.setBounds(286,126,200,30);
		xgPanel.add(xmm_field);

		
		//ת�˽���������
		JLabel ykh_label = new JLabel("ת�˿���:");
		ykh_label.setFont(new Font("����",Font.BOLD,20));
		ykh_label.setBounds(160,44,100,43);
		zzPanel.add(ykh_label);
		final JTextField ykh_field = new JTextField();
		ykh_field.setPreferredSize(new Dimension(430,28)); 
		ykh_field.setBounds(292,52,200,30);
		zzPanel.add(ykh_field);
		
		JLabel xkh_label = new JLabel("����:");
		xkh_label.setFont(new Font("����",Font.BOLD,20));
		xkh_label.setBounds(200,109,60,43);
		zzPanel.add(xkh_label);
		final JTextField xkh_field = new JTextField();
		xkh_field.setPreferredSize(new Dimension(430,28)); 
	    xkh_field.setBounds(292,117,200,30);
		zzPanel.add(xkh_field);
		
		JLabel zzje_label= new JLabel("ת�˽��:");	
		zzje_label.setFont(new Font("����",Font.BOLD,20));
		zzje_label.setBounds(165,169,95,43);
		zzPanel.add(zzje_label);
		final JTextField zzje_field = new JTextField();
		zzje_field.setPreferredSize(new Dimension(430,28)); 
		zzje_field.setBounds(292,177,200,30);
		zzPanel.add(zzje_field);
		
		
		//��ȡ�����������	
		
		JLabel yhmm_label = new JLabel("�û�����:");
		yhmm_label.setFont(new Font("����",Font.BOLD,20));
		yhmm_label.setBounds(196,28,100,100);
		addPanel.add(yhmm_label);	
		final JTextField yhmm_field = new JTextField();
		yhmm_field.setBounds(318,65,200,30);
		yhmm_field.setPreferredSize(new Dimension(430,28));
		addPanel.add(yhmm_field);
		
		JLabel je_label = new JLabel("���:");
		je_label.setFont(new Font("����",Font.BOLD,20));
		je_label.setBounds(236,88,100,100);
		addPanel.add(je_label);
		final JTextField je_field = new JTextField();
		je_field.setBounds(318,125,200,30);
		je_field.setPreferredSize(new Dimension(430,28));
		addPanel.add(je_field);
		
		JButton btn = new JButton("ȷ��");//��Ӱ�ť
		btn.setBackground(new Color(152, 251, 152));
		JButton btn1 = new JButton("ȷ��");//��Ӱ�ť
		btn1.setBackground(new Color(152, 251, 152));
		JButton btn2 = new JButton("ȷ��");//��Ӱ�ť
		btn2.setBackground(new Color(144, 238, 144));
		JButton btn3 = new JButton("��ͨ�û�");//��Ӱ�ť
		btn3.setBackground(new Color(152, 251, 152));
		JButton btn4=new JButton("VIP�û�");
		btn4.setBackground(new Color(152, 251, 152));
		
		btn.setBounds(354,191,122,30);
		addPanel.add(btn);
		btn.addActionListener(new ActionListener() {//��Ǯ/ȡǮ�¼�
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String password = yhmm_field.getText();
				String str = je_field.getText();
				int num = Integer.parseInt(str);
				int i = UserOperator.verification(cno, password);
				if (i > 0 && flag == 1) {
					UserOperator.deposit(cno, num);
					user = UserOperator.find(cno);
					String acc = user.getAmount()+"";
					userAmount.setText(acc);
					JOptionPane.showMessageDialog(null, "���ɹ���","��ϲ",JOptionPane.INFORMATION_MESSAGE);
				}else if(i > 0 && flag == 2) {
					if (user.getAmount() >= num) {
						UserOperator.withdraw(cno, num);
						user = UserOperator.find(cno);
						String acc = user.getAmount()+"";
						userAmount.setText(acc);
						JOptionPane.showMessageDialog(null, "ȡ��ɹ���","��ϲ",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "�˻����㣡","����",JOptionPane.WARNING_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "�������","����",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btn1.setBounds(324,190,126,30);//btn1�ľ��Զ�λ
		xgPanel.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String password = ymm_field.getText();
				String newPassword = xmm_field.getText();
				int i = UserOperator.verification(cno, password);
				if (i > 0) {
					UserOperator.updatePassword(cno, newPassword);
					JOptionPane.showMessageDialog(null, "�����޸ĳɹ�","��ϲ",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "�������","����",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btn2.setBounds(336,239,128,30);//btn2�ľ��Զ�λ
		zzPanel.add(btn2);
		btn2.addActionListener(new ActionListener() {//ת���¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String account2 = ykh_field.getText();
				int cno2 = Integer.parseInt(account2);
				String password = xkh_field.getText();
				String str = zzje_field.getText();
				System.out.println(str);
				int num = Integer.parseInt(str);
				int i = UserOperator.verification(cno, password);
				if (i > 0) {
					if (UserOperator.find(cno2) != null) {
						if (user.getAmount() >= num) {
							UserOperator.transfer(cno, cno2, num);
							user = UserOperator.find(cno);
							String acc = user.getAmount()+"";
							userAmount.setText(acc);
							JOptionPane.showMessageDialog(null, "ת�˳ɹ�","��ϲ",JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "�˻����㣡","����",JOptionPane.WARNING_MESSAGE);
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "�ÿ��Ų�����","����",JOptionPane.WARNING_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "�������","����",JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btn3.setBounds(270,245,100,40);
		khPanel.add(btn3);
		btn3.addActionListener(new ActionListener() {//��������ͨ�û���
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String IDno = txsfzh_field.getText();
				String name =  yhID_field.getText();
				String password = mm_field.getText();
				String type = "common";
				if (!"".equals(IDno) && !"".equals(name) && !"".equals(password)) {
					UserOperator.saveUser(name, IDno, password, type);
					JOptionPane.showMessageDialog(null, "�����ɹ���\r\n���ţ�" + UserOperator.findUserID(IDno).getID(),"��ϲ",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "���֤�š�����������Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btn4.setBounds(414,245,100,41);
		khPanel.add(btn4);
		btn4.addActionListener(new ActionListener() {//������VIP��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String IDno = txsfzh_field.getText();
				String name =  yhID_field.getText();
				String password = mm_field.getText();
				String type = "vip";
				if (!"".equals(IDno) && !"".equals(name) && !"".equals(password)) {
					UserOperator.saveUser(name, IDno, password, type);
					JOptionPane.showMessageDialog(null, "�����ɹ���\r\n���ţ�" + UserOperator.findUserID(IDno).getID(),"��ϲ",JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "���֤�š�����������Ϊ��","����",JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		
		panel.add(searchPanel, "searchPanel");
		panel.add(addPanel, "addPanel");
		panel.add(zzPanel, "zzPanel");
		panel.add(xgPanel, "xgPanel");
		panel.add(khPanel,"khPanel");
			
		frameIndex.getContentPane().add(panel, BorderLayout.CENTER);
		frameIndex.setSize(750, 500);//���ô��ڵĴ�С
		
		frameIndex.setLocation(500, 100);//��������
		frameIndex.setResizable(false);//�����Ƿ���Ըı䴰���С
		frameIndex.setIconImage(Toolkit.getDefaultToolkit().createImage("src/2.jpg"));//���ô������Ͻ���ʾ��ͼƬ
		frameIndex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��Ӵ���ر��¼�
		frameIndex.setVisible(true);//���ô����Ƿ�ɼ�
	}

}