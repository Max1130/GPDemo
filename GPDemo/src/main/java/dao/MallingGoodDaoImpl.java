package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.MallingGoods;
import util.DBUtil;

public class MallingGoodDaoImpl implements MallingGoodDao{

	public List<MallingGoods> findByType(String type) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from MALLING_GOODS where type = "+type;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<MallingGoods> list = new ArrayList<MallingGoods>();
			while (rs.next()) {
				MallingGoods good = createMallingGood(rs);
				list.add(good);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	private MallingGoods createMallingGood(ResultSet rs) throws SQLException {
		MallingGoods good = new MallingGoods();
		String path = "/YouYiBuy/images/";
		
		good.setId(rs.getString("ID"));
		good.setGoodNumber(rs.getString("GOODS_NUMBER"));
		good.setGoodName(rs.getString("GOODS_NAME"));
		good.setPrice(rs.getDouble("PRICE"));
		good.setDescription(rs.getString("DESCRIPTION"));
		good.setImageUrl(path+rs.getString("IMAGE_URL"));
		
		return good;
	}

	public MallingGoods findGoodById(String id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from MALLING_GOODS where id = " + id;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				MallingGoods good = createMallingGood(rs);
				return good;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		MallingGoodDao dao = new MallingGoodDaoImpl();
		List<MallingGoods> list = dao.findByType("3");
		System.out.println(list.size());
	}

	
}