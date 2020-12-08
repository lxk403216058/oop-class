package Brush_Pro;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.*;

public class XMLBrush {
	
	public static Object getBean(String args)
	{
		try
		{
			//�����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;							
			doc = builder.parse(new File("control.xml")); 
			NodeList nl=null;
			Node classNode=null;
			String cName=null;
			nl = doc.getElementsByTagName("className");
			
			if(args.equals("lever"))
			{
				//��ȡ�����������ı��ڵ�
	            classNode=nl.item(0).getFirstChild();
	            
			}
			else if(args.equals("dial"))
			{
			   //��ȡ�����������ı��ڵ�
	            classNode=nl.item(1).getFirstChild();
			}
			else if(args.equals("brush")){
				 //��ȡ�����������ı��ڵ�
	            classNode=nl.item(2).getFirstChild();
			}
			
	         cName=classNode.getNodeValue();
	         //ͨ����������ʵ�����󲢽��䷵��
	         Class c=Class.forName(cName);
		  	 Object obj=c.newInstance();
	         return obj;		
           }   
           	catch(Exception e)
           	{
           		e.printStackTrace();
           		return null;
           	}
		}

}
