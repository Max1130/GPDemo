package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Catalogue;
import util.DBUtil;

public class CatalogueDaoImpl implements CatalogueDao{

	public List<Catalogue> findAll() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from catalogue";
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

	private Catalogue createCatalogue(ResultSet rs) throws SQLException {
		Catalogue catalogue = new Catalogue();
		
		catalogue.setC_id(rs.getInt("c_id"));
		catalogue.setC_name(rs.getString("c_name"));
		catalogue.setC_status(rs.getString("c_status"));
		
		return catalogue;
	}
	
	public static void main(String[] args) {
		CatalogueDao dao = new CatalogueDaoImpl();
		List<Catalogue> list = dao.findAll();
		Date date = new Date();
		long time = date.getTime();
		System.out.println(date);
		System.out.println(time);
//		System.out.println(list.size());
//		System.out.println(list.toString());
	}
}
