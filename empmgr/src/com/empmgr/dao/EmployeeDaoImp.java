package com.empmgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.empmgr.entity.Employee;
import com.empmgr.util.DBUtil;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public int save(Employee emp) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into emp(ename,salary,birthday,dname)"+"values(?,?,?,?)";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEname());
			pstmt.setFloat(2, emp.getSalary());
			long time = emp.getBirthday().getTime();
			pstmt.setDate(3, new java.sql.Date(time));
			pstmt.setString(4, emp.getDname());
			
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("���ݱ���ʧ�ܣ�");
			e.printStackTrace();
		}finally {
			DBUtil.close(null, pstmt, conn);
		}
		
		return i;
	}

	@Override
	public int delete(int id) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt =null;
		String sql = "delete from emp where empno = ?";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("����ɾ��ʧ�ܣ�");
			e.printStackTrace();
		}finally {
			DBUtil.close(null, pstmt, conn);
		}
		
		return i;
	}

	@Override
	public Employee findById(int id) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "select empno,ename,salary,birthday,dname from emp where empno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setInt(1, id);//���ò���
			
			rs = pstmt.executeQuery();//ִ�в�ѯ
			while (rs.next()){//������ѯ�Ľ����
				String ename = rs.getString(2);//rs.getString("title");
				float salary = rs.getFloat(3);
				java.util.Date birthday = rs.getDate(4);
				String dname = rs.getString(5);
				
				emp = new Employee(id,ename,salary,birthday,dname);
			}
		}catch(Exception e){
			System.out.println("����id��ѯʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(rs,pstmt,conn);
		}
		
		return emp;
	}

	@Override
	public int update(Employee emp) {
		int i = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update emp set ename = ?,salary = ?,birthday = ?,dname = ? where empno = ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, emp.getEname());
			pstmt.setFloat(2, emp.getSalary());
			long time = emp.getBirthday().getTime();
			pstmt.setDate(3, new java.sql.Date(time));
			pstmt.setString(4, emp.getDname());
			pstmt.setInt(5, emp.getEmpno());
			
			i = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("�����޸�ʧ�ܣ�");
			e.printStackTrace();
			
		}finally{
			DBUtil.close(null,pstmt,conn);
		}
		
		return i;
	}

	@Override
	public List<Employee> findAll(String keyword) {
		List<Employee> list = new ArrayList<Employee>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet  rs = null;
		String sql = "select * from emp "+
		" where ename like ? or salary like ? or dname like ?";
		
		try {
			conn = DBUtil.getConnection();//��ȡ����
			pstmt = conn.prepareStatement(sql);//�õ�����
			pstmt.setString(1, "%"+keyword+ "%");//���ò���
			pstmt.setString(2, "%"+keyword+ "%");
			pstmt.setString(3, "%"+keyword+ "%");
			
			rs = pstmt.executeQuery();//ִ�в�ѯ
			while (rs.next()){//������ѯ�Ľ����
				int empno  = rs.getInt(1);
				String ename = rs.getString(2);
				float salary = rs.getFloat(3);
				java.util.Date birthday = rs.getDate(4);
				String dname = rs.getString(5);
				
				list.add(new Employee(empno,ename,salary,birthday,dname));
				}
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ģ����ѯʧ�ܣ�");
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,pstmt,conn);
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		//saveEmp();
		//deleteEmp();
		//updateEmp();
		//findByIdEmp();
		//findAlEmp();
	}

	private static void findAlEmp() {
		EmployeeDao dao = new EmployeeDaoImp();
		List<Employee> list = dao.findAll("CXK");
		for(Employee emp:list)
			System.out.println(emp);
	}

	private static void findByIdEmp() {
		EmployeeDao dao = new EmployeeDaoImp();
		Employee emp = dao.findById(2);
		System.out.println(emp);
	}

	private static void updateEmp() {
		EmployeeDao dao = new EmployeeDaoImp();
		Employee emp = new Employee(2,"CXK",1F,new java.util.Date(),"����rap����");
		
		dao.update(emp);
	}

	private static void deleteEmp() {
		EmployeeDao dao = new EmployeeDaoImp();
		int i = dao.delete(1);
		
		if(i>0){
			System.out.println("����ɾ���ɹ�");
		}else{
			System.out.println("����ɾ��ʧ��");
		}
	}

	private static void saveEmp() {
		EmployeeDao dao = new EmployeeDaoImp();
		Employee emp = new Employee("CXK",1F,new java.util.Date(),"����rap����");
		int i = dao.save(emp);
		
		if(i>0){
			System.out.println("���ݱ���ɹ�");
		}else{
			System.out.println("���ݱ���ʧ��");
		}
	}

}
