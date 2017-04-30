package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.CatalogueThree;
import util.DBUtil;

public class CatalogueThreeDaoImpl implements CatalogueThreeDao{

	public List<CatalogueThree> findById(String ceid) {
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT THREE_ID,THREE_NAME,PICTURE_URL FROM GP_CATALOGUE_THREE WHERE C_E_ID = "+ceid;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<CatalogueThree> list = new ArrayList<CatalogueThree>();
			while (rs.next()) {
				CatalogueThree three = createCatalogueThree(rs);
				list.add(three);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	/**
	 * 
	 * 描述方法作用  创建CatalogueThree对象
	 * @param rs
	 * @return
	 * @author fudakui
	 * @throws SQLException 
	 * @date 2017年3月15日
	 * modify history
	 */
	private CatalogueThree createCatalogueThree(ResultSet rs) throws SQLException {
		CatalogueThree three = new CatalogueThree();
		String path = "/YouYiBuy/images/";
		
		three.setTid(rs.getString("THREE_ID"));
		three.setTname(rs.getString("THREE_NAME"));
		three.setPurl(path+rs.getString("PICTURE_URL"));
		// TODO Auto-generated method stub
		return three;
	}

	
	public static void main(String[] args) {
		CatalogueThreeDao dao = new CatalogueThreeDaoImpl();
		List<CatalogueThree> list = dao.findById("1");
		System.out.println(list.toString());
	}
}
