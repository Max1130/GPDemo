package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import entity.GPAddress;
import util.DBUtil;
import util.UuidUtil;

public class AddressDaoImpl implements GPAddressDao{

	public boolean insert(GPAddress gpAddress) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into GP_ADDRESS(ID,USER_ID,PHONE_NUM,AREA,ADDRESS,RECEIVER,CREATE_DATE) "
					+ "values(?,?,?,?,?,?,sysdate)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gpAddress.getId() == null?UuidUtil.generateUUID():gpAddress.getId());
			ps.setString(2, gpAddress.getUserId());
			ps.setString(3, gpAddress.getPhoneNumber() == null?"":gpAddress.getPhoneNumber());
			ps.setString(4, gpAddress.getArea() == null?"":gpAddress.getArea());
			ps.setString(5, gpAddress.getAddressDetail() == null?"":gpAddress.getAddressDetail());
			ps.setString(6, gpAddress.getConsignee());//收货人
			
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

	public boolean update(GPAddress gpAddress) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update GP_ADDRESS set PHONE_NUM=?,AREA=?,ADDRESS=?,RECEIVER=?,CREATE_DATE=sysdate "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gpAddress.getPhoneNumber() == null?"":gpAddress.getPhoneNumber());
			ps.setString(2, gpAddress.getArea() == null?"":gpAddress.getArea());
			ps.setString(3, gpAddress.getAddressDetail() == null?"":gpAddress.getAddressDetail());
			ps.setString(4, gpAddress.getConsignee());//收货人
			ps.setString(5, gpAddress.getId());
			
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

	public boolean delete(String id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from GP_ADDRESS where id = '"+id+"'";
			Statement st = conn.createStatement();
			int i = st.executeUpdate(sql);
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

	public List<GPAddress> queryByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
