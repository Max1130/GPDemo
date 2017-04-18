package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.State;

import entity.GoodsRecommend;
import oracle.net.aso.r;
import util.DBUtil;
import util.UuidUtil;

public class GoodsRecommendDaoImpl implements GoodsRecommendDao{

	public boolean insertOrUpdate(GoodsRecommend goodRecommend) {
		GoodsRecommend recommend = queryByUseridAndGoodid(goodRecommend);
		
		Connection conn = null;
		String sql = "";
		try {
			conn = DBUtil.getConnection();
			if (recommend != null) {//已经存在记录,只需更新修改日期
				sql = "update goods_recommend set modify_date = sysdate "
						+ "where rid = "+recommend.getRid();
			}else {
				sql = "insert into goods_recommend (rid,user_id,good_id,sort,modify_date) "
						+ "values ("+goodRecommend.getRid()+","+goodRecommend.getUserId()+""
								+ ","+goodRecommend.getGoodId()+","+getNextSort(goodRecommend.getUserId())+",sysdate)";
			}
			Statement st = conn.createStatement();
			int i = st.executeUpdate(sql);
			if (i > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(conn);
		}
	}
	
	private  GoodsRecommend queryByUseridAndGoodid(GoodsRecommend goodRecommend){
		Connection conn = null;
		GoodsRecommend recommend = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from goods_recommend where user_id = " + goodRecommend.getUserId()+",and good_id = " +goodRecommend.getGoodId();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				recommend = new GoodsRecommend();
				recommend.setRid(rs.getString("rid"));
				recommend.setUserId(rs.getString("user_id"));
				recommend.setGoodId(rs.getString("good_id"));
				recommend.setSort(rs.getInt("sort"));
				recommend.setModifyDate(rs.getDate("modify_date"));
			}
			return recommend;
		} catch (Exception e) {
			e.printStackTrace();
			return recommend;
		} finally {
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 获取当前用户推荐商品的下一个SORT
	 * 描述方法作用
	 * @return
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	private Integer getNextSort(String userId){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select max(sort) sort from goods_recommend where user_id="+userId;
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Integer sort = rs.getInt("sort");
				return sort+1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return 0;
	}
	
	public List<String> queryByUserId(String userId) {
		Connection conn = null;
		List<String> list = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select good_id from goods_recommend where user_id = " + userId + "order by modify_date desc";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			list = new ArrayList<String>();
			while (rs.next()) {
				String goodId = rs.getString("good_id");
				list.add(goodId);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return list;
		} finally {
			DBUtil.close(conn);
		}
	}

	public static void main(String[] args) {
		GoodsRecommend vo = new GoodsRecommend();
		vo.setRid("1");
		vo.setUserId("1");
		vo.setGoodId("1");
		vo.setSort(1);
		GoodsRecommendDao dao = new GoodsRecommendDaoImpl();
		boolean bool = dao.insertOrUpdate(vo);
		System.out.println(bool);
	}
	
}
