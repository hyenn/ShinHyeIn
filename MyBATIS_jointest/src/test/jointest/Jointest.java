package test.jointest;

import java.util.Iterator;
import java.util.List;

import jointest.DeptDTO;
import jointest.EmpDTO;
import jointest.Emp_bodyDTO;
import jointest.JointestMgr;

public class Jointest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JointestMgr mgr = new JointestMgr();
		//oneToOne(mgr);
		//oneToOneList(mgr);
		oneToMany(mgr);
		//oneToManyList(mgr);
	}

	private static void oneToManyList(JointestMgr mgr) {
		List list = mgr.oneToManyList();
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			DeptDTO ddto = (DeptDTO)iter.next();
			p("------------부서정보--------------");
			p(ddto);
		}
	}

	private static void p(DeptDTO ddto) {
		p(ddto.getDeptno()+"");
		p(ddto.getDeptname());
		p(ddto.getEmpdtoList());
		
	}

	private static void p(List empdtoList) {
		p("------------사원정보-------------");
		List list = empdtoList;
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			EmpDTO edto = (EmpDTO)iter.next();
			p(edto.getEmpno()+"");
			p(edto.getName());
			p(edto.getEmail());
			p(edto.getPhone());
			p(edto.getZipcode());
			p(edto.getAddress());
			p(edto.getRegdate());
			p(edto.getDeptno()+"");
			
		}
		
	}

	private static void oneToMany(JointestMgr mgr) {
		DeptDTO dto = mgr.oneToMany(1);
		p("------------부서정보-------------");
		p(dto.getDeptno()+"");
		p(dto.getDeptname());
		p("------------사원정보-------------");
		List list = dto.getEmpdtoList();
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			EmpDTO edto = (EmpDTO)iter.next();
			p(edto.getEmpno()+"");
			p(edto.getName());
			p(edto.getEmail());
			p(edto.getPhone());
			p(edto.getZipcode());
			p(edto.getAddress());
			p(edto.getRegdate());
			p(edto.getDeptno()+"");
			
		}
		
	}

	private static void oneToOneList(JointestMgr mgr) {
		List list = mgr.oneToOneList();
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			EmpDTO dto = (EmpDTO)iter.next();
			p(dto);
		}
	}

	private static void oneToOne(JointestMgr mgr) {
		EmpDTO dto = mgr.oneToOne(1);
		p(dto);
	}

	private static void p(EmpDTO dto) {
		p("--------사원정보-----------");
		p(dto.getEmpno()+"");
		p(dto.getName());
		p(dto.getEmail());
		p(dto.getPhone());
		p(dto.getZipcode());
		p(dto.getAddress());
		p(dto.getRegdate());
		p(dto.getDeptno()+"");
		p("---------신체정보----------");
		p(dto.getEbdto());
	}

	private static void p(Emp_bodyDTO ebdto) {
		p("사원번호"+ebdto.getEmpno());
		p("몸무게"+ebdto.getWeight());
		p("신장"+ebdto.getHeight());
		p("혈액형"+ebdto.getBlood());
		
		
	}

	private static void p(String string) {
		System.out.println(string);
		
	}

}
