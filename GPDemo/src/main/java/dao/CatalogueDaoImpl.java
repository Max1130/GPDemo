package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Catalogue;
import util.DBUtil;

public class CatalogueDaoImpl implements CatalogueDao{

	public List<Catalogue> findAll() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from catalogue order by c_id";
//			System.out.println(conn);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Catalogue> list = new ArrayList<Catalogue>();
			while (rs.next()) {
				Catalogue catalogue = createCatalogue(rs);
				list.add(catalogue);
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
	 * 创建一个实体对象
	* @param rs
	* @throws SQLException
	* @return
	* @author fudakui
	* @date 2017年3月10日
	* modify history
	 */
	private Catalogue createCatalogue(ResultSet rs) throws SQLException {
		Catalogue catalogue = new Catalogue();
		
		catalogue.setcid(rs.getString("c_id"));
		catalogue.setcname(rs.getString("c_name"));
		
		return catalogue;
	}
	
	
	public static void main(String[] args) {
		CatalogueDao dao = new CatalogueDaoImpl();
		List<Catalogue> list = dao.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getcname());
		}
//		Date date = new Date();
//		long time = date.getTime();
//		System.out.println(date);
//		System.out.println(time);
//		System.out.println(list.size());
//		System.out.println(list.toString());
	}
}
