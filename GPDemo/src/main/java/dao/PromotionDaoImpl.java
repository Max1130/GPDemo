package dao;

import entity.PromotionBean;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromotionDaoImpl implements PromotionDao{

	public List<PromotionBean> queryByGoodId(String goodId) {
		Connection conn = null;
		List<PromotionBean> list = new ArrayList<PromotionBean>();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from GP_GOOD_PROMOTION where good_id = '"+goodId+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()){
				PromotionBean bean = new PromotionBean();
				bean.setDescription(rs.getString("description"));
				bean.setPromotion(rs.getInt("promotion"));
				list.add(bean);
			}
			return  list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}
	
}
