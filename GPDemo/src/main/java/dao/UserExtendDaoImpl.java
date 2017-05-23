package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.UserExtend;
import util.DBUtil;
import util.UuidUtil;

public class UserExtendDaoImpl implements UserExtendDao{

	public boolean insert(UserExtend userExtend) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into GP_USER_EXTEND(ID,USER_ID,NICK_NAME,GENDER,BIRTHDAY) "
					+ "values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userExtend.getId()==null?UuidUtil.generateUUID():userExtend.getId());
			ps.setString(2, userExtend.getUserId() == null?"":userExtend.getUserId());
			ps.setString(3, userExtend.getNickName()==null?"":userExtend.getNickName());
			ps.setInt(4, userExtend.getGender() == null?2:userExtend.getGender());
			ps.setString(5, userExtend.getBirthDay()==null?"":userExtend.getBirthDay());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(conn);
		}
		return false;
	}

	public boolean insert(String userId, String headUrl) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into GP_USER_EXTEND(ID,USER_ID,HEAD_URL) "
					+ "values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, UuidUtil.generateUUID());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(conn);
		}
		return false;
	}

	public boolean update(String userId, String headUrl) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(UserExtend userExtend) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update GP_USER_EXTEND set NICK_NAME=?,GENDER=?,BIRTHDAY=? where USER_ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userExtend.getNickName()==null?"":userExtend.getNickName());
			ps.setInt(2, userExtend.getGender() == null?2:userExtend.getGender());
			ps.setString(3, userExtend.getBirthDay()==null?"":userExtend.getBirthDay());
			ps.setString(4, userExtend.getUserId());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(conn);
		}
		return false;
	}

	public UserExtend query(String userId) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from GP_USER_EXTEND where user_id = '"+userId+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				UserExtend info = new UserExtend();
				info.setNickName(rs.getString("NICK_NAME"));
				info.setGender(rs.getInt("GENDER"));
				info.setBirthDay(rs.getString("BIRTHDAY"));
				
				return info;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.close(conn);
		}
		return null;
	}
	
	public static void main(String[] args) {
		UserExtend user = new UserExtend();
		user.setUserId("9b28e5d7ebbc4650a607445eb0af99a9");
		user.setNickName("嘻嘻嘻");
		user.setBirthDay("2017-11-1");
		user.setGender(1);
		new UserExtendDaoImpl().update(user);
	}
	
}
