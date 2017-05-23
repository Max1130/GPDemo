package dao;

import entity.MallingGoods;
import util.DBUtil;
import util.IPUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MallingGoodDaoImpl implements MallingGoodDao{

	public List<MallingGoods> findByType(String type) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from GP_MALLING_GOODS where type = '"+type+"'";
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

	/**
	 * 得到一个商品对象
	 * 描述方法作用
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	private MallingGoods createMallingGood(ResultSet rs) throws SQLException {
		MallingGoods good = new MallingGoods();
		String path = "/YouYiBuy/images/";
		
		good.setId(rs.getString("ID"));
		good.setGoodNumber(rs.getString("GOODS_NUMBER"));
		good.setGoodName(rs.getString("GOODS_NAME"));
		good.setPrice(rs.getDouble("PRICE"));
		good.setDescription(rs.getString("DESCRIPTION"));
		String images = rs.getString("IMAGE_URL");
		String[] imageArr = images.split(",");
		String imageUrl = "";
		for (int i = 0; i < imageArr.length; i++) {
			if (i == 0) {
				imageUrl = imageUrl + (path + imageArr[i]);
			}else {
				imageUrl = imageUrl + "," + (path + imageArr[i]);
			}
		}
		good.setImageUrl(imageUrl);
		
		return good;
	}

	public MallingGoods findGoodById(String id) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from GP_MALLING_GOODS where id = '" + id+"'";
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
	
	public List<MallingGoods> findGoodsByIds(List<String> ids) {
		List<MallingGoods> goodList = new ArrayList<MallingGoods>();
		if (ids == null || ids.size()<1) {
			return goodList;
		}
		for (String id : ids) {
			MallingGoods good = new MallingGoods();
			good = findGoodById(id);
			goodList.add(good);
		}
		return goodList;
	}
	
	

	public List<MallingGoods> queryAll() {
		Connection conn = null;
		try {
			List<MallingGoods> goods = new ArrayList<MallingGoods>();
			conn = DBUtil.getConnection();
			String sql = "select * from GP_MALLING_GOODS";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				MallingGoods good = createMallingGood(rs);
				goods.add(good);
			}
			return goods;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public List<MallingGoods> findGoodsByName(String name) {
		Connection conn = null;
		try{

		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public List<MallingGoods> findGoodsByPage(Integer pageIndex, Integer pageSize) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from (" + "	select c.*,rownum r from (" + "	  select * from GP_MALLING_GOODS "
					+ " ) c" + ") where r between ? and ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (pageIndex - 1) * pageSize + 1);
			ps.setInt(2, pageIndex * pageSize);
			ResultSet rs = ps.executeQuery();
			List<MallingGoods> list = new ArrayList<MallingGoods>();
			while (rs.next()) {
				MallingGoods c = createMallingGood(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询帖子失败", e);
		} finally {
			DBUtil.close(con);
		}
	}

	public Integer findRows() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String  sql = "select count(*) from GP_MALLING_GOODS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}catch (Exception e ){
			e.printStackTrace();
			throw new RuntimeException("查询总行数失败",e);
		}finally {
			DBUtil.close(conn);
		}

		return 0;
	}

	public List<MallingGoods> findGoodsByNameForPage(Integer pageIndex, Integer pageSize,String name) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			String sql = "select * from (" + "	select c.*,rownum r from (" + "	  select * from GP_MALLING_GOODS WHERE"
					+ "  GOODS_NAME LIKE '%"+name+"%') c" + ") where r between ? and ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, (pageIndex - 1) * pageSize + 1);
			ps.setInt(2, pageIndex * pageSize);
			ResultSet rs = ps.executeQuery();
			List<MallingGoods> list = new ArrayList<MallingGoods>();
			while (rs.next()) {
				MallingGoods c = createMallingGood(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询帖子失败", e);
		} finally {
			DBUtil.close(con);
		}

	}

	public Integer findRowsForName(String name) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String  sql = "select count(*) from GP_MALLING_GOODS WHERE GOODS_NAME like '%"+name+"%'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		}catch (Exception e ){
			e.printStackTrace();
			throw new RuntimeException("查询总行数失败",e);
		}finally {
			DBUtil.close(conn);
		}

		return 0;
	}


//	public static void main(String[] args) {
//		MallingGoodDao dao = new MallingGoodDaoImpl();
//		List<MallingGoods> list = dao.findByType("3");
//		System.out.println(list.size());
//	}

	
}
