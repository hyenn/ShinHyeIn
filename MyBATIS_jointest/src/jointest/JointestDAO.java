package jointest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class JointestDAO {

	public EmpDTO oneToOne(int empno, SqlSessionFactory sqlMapper) throws Exception {
		EmpDTO dto = null;
		SqlSession session = sqlMapper.openSession();
		try {
				dto =  session.selectOne(
		         "jointest.oneToOne", 1);
		} finally {
		        session.close();
		}
		return dto;
	}

	public List oneToOneList(SqlSessionFactory sqlMapper) throws Exception {
		List list = null;
		SqlSession session = sqlMapper.openSession();
		try {
				list =  session.selectList("jointest.oneToOneList");
		} finally {
		        session.close();
		}
		return list;
	}

	public DeptDTO oneToMany(int deptno, SqlSessionFactory sqlMapper) throws Exception {
		DeptDTO dto = null;
		SqlSession session = sqlMapper.openSession();
		try {
				dto =  session.selectOne("jointest.oneToMany", deptno);
		} finally {
		        session.close();
		}
		return dto;
		
	}

	public List oneToManyList(SqlSessionFactory sqlMapper) {
		List list = null;
		SqlSession session = sqlMapper.openSession();
		try {
				list =  session.selectList("jointest.oneToManyList");
		} finally {
		        session.close();
		}
		return list;
	}

}
