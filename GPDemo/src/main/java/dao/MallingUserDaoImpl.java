package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.MallingUser;
import oracle.net.aso.r;
import util.DBUtil;

public class MallingUserDaoImpl implements MallingUserDao{

	public boolean insert(MallingUser user) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into malling_user values(?,?,?,sysdate,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getToken());
			
			int n = ps.executeUpdate();
			if (n == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.close(conn);
		}
		return false;
	}

	public MallingUser findUserByName(String userName) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from malling_user where user_name = "+userName;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			MallingUser user = new MallingUser();
			while (rs.next()) {
				user.setId(rs.getString("ID"));
				user.setUserName(userName);
				user.setPassword(rs.getString("PASSWORD"));
				user.setToken(rs.getString("TOKEN"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(conn);
		}
	}

}
