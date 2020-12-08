package com.d302.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.d302.entity.Book;
import com.d302.entity.Page;
import com.d302.service.BookService;
import com.d302.service.BookServiceImpl;

public class Index_test {
	CardLayout card = new CardLayout();
	//ʹ�ÿ�Ƭ����ģʽʵ�ֲ�ͬ�˵���ʾ��ͬҳ��
	final JPanel panel = new JPanel();
	
	Object[][] datas = null;
	int pageSize = 3;
	int pageNo = 1;
	JTable booksTable = null;
	public static void main(String args[]){
		Index_test index = new Index_test();
	}
	
	//���췽��
	public Index_test(){
		//��ʼ��������Ĵ���
		JFrame indexWindow = new JFrame("ͼ�����ϵͳ");
		panel.setLayout(card);//������Panel�Ĳ��ַ�ʽΪ��Ƭ����
		
		//��������Ӳ˵�������
		JMenuBar menuBar = new JMenuBar();
		//���˵�����Ӳ˵���
		JMenu serarchBooksMenu = new JMenu("��ѯͼ��");
		//���˵���Ӽ����¼�
		serarchBooksMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				card.show(panel, "serarchBooksPanel");
			}
		});
		JMenu addBookMenu = new JMenu("���ͼ��");
		//���˵���Ӽ����¼�
		addBookMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				card.show(panel, "addBooksPanel");
			}
		});
		JMenu helpMenu = new JMenu("����");
		menuBar.add(serarchBooksMenu);//���˵���󶨵�������
		menuBar.add(addBookMenu);//���˵���󶨵�������
		menuBar.add(helpMenu);//���˵���󶨵�������
		
		//��ӵ���������
		
		JPanel serarchBooksPanel = new JPanel();
		serarchBooksPanel.setLayout(new BorderLayout());
		
		datas = parseData(pageNo,pageSize);//�����ݸ�ʽ��
		final String[] title = {"���", "����" , "����" , "������", "����ʱ��", "�۸�"};
		
		DefaultTableModel tableModel = new DefaultTableModel(datas, title);
		
		booksTable = new JTable(tableModel);
		
		JScrollPane scrollpane = new JScrollPane(booksTable);

	    serarchBooksPanel.add(scrollpane,BorderLayout.CENTER);
		
	    //����һҳ��һҳ��ť
	    JPanel btnsPanel = new JPanel();//����һ���м����
	    
	    JButton upPage = new JButton("��һҳ");
	    btnsPanel.add(upPage);//����ť��ӵ��м����
	    
	    JButton downPage = new JButton("��һҳ");
	    downPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pageNo += 1;
				datas = parseData(pageNo, pageSize);
				DefaultTableModel tableModelRef = new DefaultTableModel(datas, title);
				booksTable.setModel(tableModelRef);
			}
		});
	    btnsPanel.add(downPage);//����ť��ӵ��м����
	    
	    serarchBooksPanel.add(btnsPanel,BorderLayout.SOUTH);
	    
		//��serarchBooksPanel���һ�����Button
		JButton serBooBtn = new JButton("��ѯͼ��");
		serarchBooksPanel.add(serBooBtn,BorderLayout.NORTH);
		
		
		JPanel addBooksPanel = new JPanel(); 
		addBooksPanel.setLayout(new FlowLayout());
		//��serarchBooksPanel���һ�����Button
		JButton addBooBtn = new JButton("���ͼ��");
		addBooksPanel.add(addBooBtn);
		
		panel.add(serarchBooksPanel, "serarchBooksPanel");
		panel.add(addBooksPanel, "addBooksPanel");
		
		
		
		indexWindow.add(panel,BorderLayout.CENTER);
		indexWindow.setJMenuBar(menuBar);//���������󶨵�����
		indexWindow.setResizable(false);
		indexWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		indexWindow.setBounds(200, 200, 600, 600);//���ô���Ĵ�С
		indexWindow.setVisible(true);
		
	}

	private Object[][] parseData(int pageNo,int pageSize) {
		BookService bs = new BookServiceImpl();
		Page page = bs.paging(pageNo, pageSize);
		List data = page.getData();
		Object[][] records = new Object[data.size()][6];
		
		for(int i = 0; i < data.size(); i++){
			Book book = (Book) data.get(i);
			Object[] record = {book.getId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getPub_date(),book.getPrice()};
			records[i] = record;
		}
		return records;
	}
	
}
