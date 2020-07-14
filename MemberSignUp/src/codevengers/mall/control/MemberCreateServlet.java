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

@WebServlet("/MemberCreateServlet")
public class MemberCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 받아오는 데이터 인코딩
		request.setCharacterEncoding("utf-8");

		// 자바에 넣기위한 변수에 리퀘스트겟을 사용해 데이터를 넣어준다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String passwdk = request.getParameter("passwdk");
		String name = request.getParameter("name");
		int tel1 = Integer.parseInt(request.getParameter("tel1"));
		int tel2 = Integer.parseInt(request.getParameter("tel2"));
		int tel3 = Integer.parseInt(request.getParameter("tel3"));
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		// DTO넣기위해 인스턴스를 생성
		MemberDTO memberDTO = new MemberDTO();
		// DTO입력
		memberDTO.setId(id);
		memberDTO.setPasswd(passwd);
		memberDTO.setPasswdk(passwdk);
		memberDTO.setName(name);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setAddress(address);
		memberDTO.setGender(gender);
		memberDTO.setEmail(email);

		// DAO를 불러오기위해 인스턴스생성
		MemberDAO memberDAO = new MemberDAO();

		// DTO의 데이터를 DAO에 넣어준다.
		memberDAO.insert(memberDTO);

		// html에 넣은데이터를 출력할수있도록 한다.
		response.setContentType("text/html; charset=UTF-8");
		// 출력할수있도록 인스턴스 생성
		PrintWriter printWriter = response.getWriter();

		printWriter.println("아이디:" + id+"<br>");
		printWriter.println("비밀번호:" + passwd+"<br>");
		printWriter.println("이름:" + name+"<br>");
		printWriter.println("전화번호:" + tel1 + "-" + tel2 + "-" + tel3+"<br>");
		printWriter.println("주소:" + address+"<br>");
		printWriter.println("성별:" + gender+"<br>");
		printWriter.println("이메일:" + email+"<br>");

	}

}
