package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import entity.PropertyBean;
import util.DBUtil;

public class PropertyDaoImpl implements PropertyDao{

	public PropertyBean queryByGoodNumber(String goodNumber) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from GP_GOOD_PROPERTY where good_number = '"+goodNumber+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				PropertyBean bean = new PropertyBean();
				bean.setGoodNumber(rs.getString("good_number"));
				bean.setCombination(rs.getString("combination"));
				bean.setSleeveLength(rs.getString("sleeve_length"));
				bean.setWaistType(rs.getString("waist_type"));
				bean.setSkirtType(rs.getString("skirt_type"));
				bean.setTexture(rs.getString("texture"));
				bean.setType(rs.getString("type"));
				bean.setPrice(rs.getString("price"));
				bean.setSize(rs.getString("size"));
				bean.setSkirtLength(rs.getString("skirt_length"));
				bean.setColor(rs.getString("color"));
				bean.setTime(rs.getString("time"));
				
				return bean;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return new PropertyBean();
	}
	
}
