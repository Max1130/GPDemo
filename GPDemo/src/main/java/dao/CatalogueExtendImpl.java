package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.CatalogueExtend;
import util.DBUtil;

public class CatalogueExtendImpl implements CatalogueExtendDao{

	public List<CatalogueExtend> findById(String cid) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT C_E_ID,C_E_NAME FROM CATALOGUE_EXTEND WHERE C_ID = "+cid;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<CatalogueExtend> list = new ArrayList<CatalogueExtend>();
			while (rs.next()) {
				CatalogueExtend cePo = createCatalogueExtend(rs);
				list.add(cePo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	private CatalogueExtend createCatalogueExtend(ResultSet rs) throws SQLException {
		CatalogueExtend cePo = new CatalogueExtend();
		
		cePo.setCeid(rs.getString("C_E_ID"));
		cePo.setCename(rs.getString("C_E_NAME"));
		
		return cePo;
	}
	
	public static void main(String[] args) {
		CatalogueExtendDao dao = new CatalogueExtendImpl();
		List<CatalogueExtend> list = dao.findById("1");
		System.out.println(list.size());
	}

}
