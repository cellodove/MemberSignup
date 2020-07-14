package codevengers.mall.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codevengers.mall.dao.MemberDAO;
import codevengers.mall.dto.MemberDTO;

@WebServlet("/MemberCheckServlet")
public class MemberCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 받아오는 데이터 인코딩
		request.setCharacterEncoding("utf-8");

		// 자바에 넣기위한 변수에 리퀘스트겟을 사용해 데이터를 넣어준다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPasswd(passwd);
		

		MemberDAO memberDAO = new MemberDAO();
		memberDAO.check(memberDTO);
		
		
		
		
		
		
		
		
	}

}
