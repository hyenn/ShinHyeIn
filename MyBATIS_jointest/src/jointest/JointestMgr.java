package jointest;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import sqlmap.MyAppSqlConfig;

public class JointestMgr {
	private static JointestDAO dao;
	private static SqlSessionFactory sqlMapper;
	
	static{
		dao = new JointestDAO();
		sqlMapper = MyAppSqlConfig.getSqlMapInstance();
	}
	
	public EmpDTO oneToOne(int empno){
		EmpDTO dto = null;
		try{
			dto = dao.oneToOne(empno,sqlMapper);
		}catch(Exception e){
			System.out.println(e);
		}
		return dto;
	}
	
	public List oneToOneList(){
		List list = null;
		try{
			list = dao.oneToOneList(sqlMapper);
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	public DeptDTO oneToMany(int deptno){
		DeptDTO dto = null;
		try{
			dto = dao.oneToMany(deptno,sqlMapper);
		}catch(Exception e){
			System.out.println(e);
		}
		return dto;
	}

	public List oneToManyList() {
		// TODO Auto-generated method stub
		List list = null;
		try{
			list = dao.oneToManyList(sqlMapper);
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}
	
	
	
}
