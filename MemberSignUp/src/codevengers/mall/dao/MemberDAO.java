package codevengers.mall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import codevengers.mall.dto.MemberDTO;

public class MemberDAO {

	MemberDTO memberDTO = new MemberDTO();

	public void insert(MemberDTO memberDTO) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {

			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc");
			connection = dataSource.getConnection();

			String sql = "insert into member(id,passwd,passwdk,name,tel1,tel2,tel3,address,gender,email) ";
			sql += " values(?,?,?,?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, memberDTO.getId());
			preparedStatement.setString(2, memberDTO.getPasswd());
			preparedStatement.setString(3, memberDTO.getPasswdk());
			preparedStatement.setString(4, memberDTO.getName());
			preparedStatement.setInt(5, memberDTO.getTel1());
			preparedStatement.setInt(6, memberDTO.getTel2());
			preparedStatement.setInt(7, memberDTO.getTel3());
			preparedStatement.setString(8, memberDTO.getAddress());
			preparedStatement.setString(9, memberDTO.getGender());
			preparedStatement.setString(10, memberDTO.getEmail());

			int count = preparedStatement.executeUpdate();

			if (count > 0) {
				System.out.println("회원가입되었습니다.");
				connection.commit();

			} else {
				connection.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("으악! 에러났다!!!!");
		} finally {
			try {
				preparedStatement.close();
				connection.close();

			} catch (Exception e2) {

				e2.printStackTrace();
				System.out.println("으악! 에러났다2!!!!");
			}
		}

	}

	public void check(MemberDTO memberDTO) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookupLink("java:comp/env/jdbc");
			connection = dataSource.getConnection();
			String id = memberDTO.getId();
			String passwd = memberDTO.getPasswd();

			String sql = "select id,passwd from member";
			sql += " where id = ?";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String id1 = resultSet.getString("id");
				String passwd1 = resultSet.getString("passwd");
				if (id.equals(id1)) {
					if (passwd.equals(passwd1)) {
						System.out.println("로그인되었습니다.");

					} else {
						System.out.println("비밀번호가 틀렸습니다.");
					}

				} else {
					System.out.println("없는 아이디입니다.");
				}

			}

		} catch (Exception e) {
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
