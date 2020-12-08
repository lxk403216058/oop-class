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
	//使用卡片布局模式实现不同菜单显示不同页面
	final JPanel panel = new JPanel();
	
	Object[][] datas = null;
	int pageSize = 3;
	int pageNo = 1;
	JTable booksTable = null;
	public static void main(String args[]){
		Index_test index = new Index_test();
	}
	
	//构造方法
	public Index_test(){
		//初始化主界面的窗口
		JFrame indexWindow = new JFrame("图书管理系统");
		panel.setLayout(card);//设置主Panel的布局方式为卡片布局
		
		//给窗体添加菜单栏导航
		JMenuBar menuBar = new JMenuBar();
		//给菜单栏添加菜单项
		JMenu serarchBooksMenu = new JMenu("查询图书");
		//给菜单添加监听事件
		serarchBooksMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				card.show(panel, "serarchBooksPanel");
			}
		});
		JMenu addBookMenu = new JMenu("添加图书");
		//给菜单添加监听事件
		addBookMenu.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				card.show(panel, "addBooksPanel");
			}
		});
		JMenu helpMenu = new JMenu("帮助");
		menuBar.add(serarchBooksMenu);//将菜单项绑定到导航栏
		menuBar.add(addBookMenu);//将菜单项绑定到导航栏
		menuBar.add(helpMenu);//将菜单项绑定到导航栏
		
		//添加导航栏结束
		
		JPanel serarchBooksPanel = new JPanel();
		serarchBooksPanel.setLayout(new BorderLayout());
		
		datas = parseData(pageNo,pageSize);//将数据格式化
		final String[] title = {"序号", "书名" , "作者" , "出版社", "出版时间", "价格"};
		
		DefaultTableModel tableModel = new DefaultTableModel(datas, title);
		
		booksTable = new JTable(tableModel);
		
		JScrollPane scrollpane = new JScrollPane(booksTable);

	    serarchBooksPanel.add(scrollpane,BorderLayout.CENTER);
		
	    //加上一页下一页按钮
	    JPanel btnsPanel = new JPanel();//创建一个中间面板
	    
	    JButton upPage = new JButton("上一页");
	    btnsPanel.add(upPage);//将按钮添加到中间面板
	    
	    JButton downPage = new JButton("下一页");
	    downPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pageNo += 1;
				datas = parseData(pageNo, pageSize);
				DefaultTableModel tableModelRef = new DefaultTableModel(datas, title);
				booksTable.setModel(tableModelRef);
			}
		});
	    btnsPanel.add(downPage);//将按钮添加到中间面板
	    
	    serarchBooksPanel.add(btnsPanel,BorderLayout.SOUTH);
	    
		//给serarchBooksPanel添加一个组件Button
		JButton serBooBtn = new JButton("查询图书");
		serarchBooksPanel.add(serBooBtn,BorderLayout.NORTH);
		
		
		JPanel addBooksPanel = new JPanel(); 
		addBooksPanel.setLayout(new FlowLayout());
		//给serarchBooksPanel添加一个组件Button
		JButton addBooBtn = new JButton("添加图书");
		addBooksPanel.add(addBooBtn);
		
		panel.add(serarchBooksPanel, "serarchBooksPanel");
		panel.add(addBooksPanel, "addBooksPanel");
		
		
		
		indexWindow.add(panel,BorderLayout.CENTER);
		indexWindow.setJMenuBar(menuBar);//将导航栏绑定到窗体
		indexWindow.setResizable(false);
		indexWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		indexWindow.setBounds(200, 200, 600, 600);//设置窗体的大小
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
