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
			//创建文档对象
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
				//获取包含类名的文本节点
	            classNode=nl.item(0).getFirstChild();
	            
			}
			else if(args.equals("dial"))
			{
			   //获取包含类名的文本节点
	            classNode=nl.item(1).getFirstChild();
			}
			else if(args.equals("brush")){
				 //获取包含类名的文本节点
	            classNode=nl.item(2).getFirstChild();
			}
			
	         cName=classNode.getNodeValue();
	         //通过类名生成实例对象并将其返回
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
