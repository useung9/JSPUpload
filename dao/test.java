package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dto.Member;

class test {

	@Test
	void test() {
		MemberDAO mdao = new MemberDAO();
		Member member = new Member();
		
		int cnt = mdao.requestcustno();
		System.out.println(cnt);
	}
	
	@Test
	void test2(){
		MemberDAO mdao = new MemberDAO();
		Member member = new Member();
		
		member = mdao.selectOne(100001);
		System.out.println(member);
	}
	
	
	@Test
	void test3() {
		MemberDAO mdao = new MemberDAO();
	
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list = mdao.result();
		System.out.println(list.size());
		for(Map<String,Object> m : list) {
			System.out.println(m.get("custno"));
			System.out.println(m.get("custname"));
			System.out.println(m.get("custgrade"));
			System.out.println(m.get("sales"));
			
					
		}
	}

}
