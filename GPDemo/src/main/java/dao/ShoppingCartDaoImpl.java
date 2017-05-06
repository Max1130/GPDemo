package dao;

import entity.ShoppingCart;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDaoImpl implements ShoppingCartDao{

	public List<ShoppingCart> queryByUserId(String userId) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from GP_SHOPPING_CART where USER_ID = '"+userId+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<ShoppingCart> list = new ArrayList<ShoppingCart>();
			while (rs.next()) {
				ShoppingCart shop = createShoppingCart(rs);
				list.add(shop);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(conn);
		}
	}

	public boolean insert(ShoppingCart shoppingCart) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into GP_SHOPPING_CART values(?,?,?,?,sysdate)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,shoppingCart.getId());
			ps.setString(2,shoppingCart.getGoodId());
			ps.setInt(3,shoppingCart.getCount());
			ps.setString(4,shoppingCart.getUserId());

            int n = ps.executeUpdate();
            if (n == 1) {
                return true;
            }
		}catch (Exception e){
            e.printStackTrace();
            DBUtil.rollback(conn);
            return false;
		}finally {
            DBUtil.close(conn);
        }
		return false;
	}

	private ShoppingCart createShoppingCart(ResultSet rs) throws SQLException {
		ShoppingCart shopCart = new ShoppingCart();
		
		shopCart.setId(rs.getString("ID"));
		shopCart.setGoodId(rs.getString("GOOD_ID"));
		shopCart.setCount(rs.getInt("count"));
		
		return shopCart;
	}


	
}
