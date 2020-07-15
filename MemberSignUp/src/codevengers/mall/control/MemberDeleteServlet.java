package codevengers.mall.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import codevengers.mall.dao.MemberDAO;
import codevengers.mall.dto.MemberDTO;

@WebServlet("/MemberDeleteServlet")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		MemberDTO memberDTO = new MemberDTO();

		memberDTO.setId(id);
		memberDTO.setPasswd(passwd);

		MemberDAO memberDAO = new MemberDAO();
		memberDAO.delete(memberDTO);

		
		
		
		// html에 넣은데이터를 출력할수있도록 한다.
		response.setContentType("text/html; charset=UTF-8");
		// 출력할수있도록 인스턴스 생성
		PrintWriter printWriter = response.getWriter();

		printWriter.println("계정이 삭제되었습니다.");

	}
}
