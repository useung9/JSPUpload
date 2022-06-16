package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConn;
import dao.MemberDAO;
import dto.Member;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO mdao = new MemberDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		System.out.println("URI : " + uri);

		if (uri.contains("default")) {

		}
		if (uri.contains("add")) {

			// custno +1 값 가져오기
			int returnCustno = mdao.requestcustno();
			System.out.println("디비 리턴값 : " + returnCustno);

			request.setAttribute("requestCustno", returnCustno);

			int custno = Integer.parseInt(request.getParameter("custno"));
			String custname = request.getParameter("custname");
			String custphone = request.getParameter("custphone");
			String custaddress = request.getParameter("custaddress");
			// String custjoin = request.getParameter("custjoin");
			String custgrade = request.getParameter("custgrade");
			String custcity = request.getParameter("custcity");
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
			String sfdate = sf.format(date);

			Member member = new Member();
			member.setCustno(custno);
			member.setCustname(custname);
			member.setCustphone(custphone);
			member.setCustaddress(custaddress);
			member.setCustjoindate(sfdate);
			member.setCustgrade(custgrade);
			member.setCustcity(custcity);
			System.out.println(member);
			int result = mdao.insert(member);
			if (result == 1) {
				System.out.println(result);
				String msg = URLEncoder.encode("등록완료", "utf-8");
				response.sendRedirect("/jsp03_hrd/view/add.jsp?msg=" + msg);
			} else
				System.out.println("등록오류");

		} else if (uri.contains("search")) {
			// 회원목록 및 수정
			Member member = new Member();
			List<Member> mList = mdao.selectAll(member);

			request.setAttribute("mList", mList);
			request.getRequestDispatcher("/view/searchNmodify.jsp").forward(request, response);
		}

		else if (uri.contains("modify")) {
			// 해당 정보 수정창

			int custno = Integer.parseInt(request.getParameter("custno"));

			Member member = mdao.selectOne(custno);

			request.setAttribute("member", member);
			request.getRequestDispatcher("/view/modify.jsp?custno=" + member).forward(request, response);
		} else if (uri.contains("update")) {
			
			System.out.println(request.getParameter("custno"));
			System.out.println(request.getParameter("custname"));
			System.out.println(request.getParameter("custphone"));
			System.out.println(request.getParameter("custjoin"));
			System.out.println(request.getParameter("custaddress"));
			System.out.println(request.getParameter("custgrade"));
			System.out.println(request.getParameter("custcity"));
			Member member = null;
			member.setCustno(Integer.parseInt(request.getParameter("custno")));
			member.setCustname(request.getParameter("custname"));
			member.setCustphone(request.getParameter("custphone"));
			member.setCustjoindate(request.getParameter("custjoin"));
			member.setCustaddress(request.getParameter("custaddress"));
			member.setCustgrade(request.getParameter("custgrade"));
			member.setCustcity(request.getParameter("custcity"));
			
			int cnt = mdao.updateUser(member.getCustno());
		}

		else if (uri.contains("sales")) {
			Member member = new Member();
			List<Map<String, Object>> mlist = new ArrayList<Map<String, Object>>();
			mlist = mdao.result();
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/view/sales.jsp?reultSales").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
