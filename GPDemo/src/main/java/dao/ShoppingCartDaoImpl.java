package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.ShoppingCart;
import util.DBUtil;

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

	private ShoppingCart createShoppingCart(ResultSet rs) throws SQLException {
		ShoppingCart shopCart = new ShoppingCart();
		
		shopCart.setId(rs.getString("ID"));
		shopCart.setGoodId(rs.getString("GOOD_ID"));
		shopCart.setCount(rs.getInt("count"));
		
		return shopCart;
	}

	public static void main(String[] args) {
		ShoppingCartDaoImpl imp = new ShoppingCartDaoImpl();
		List<ShoppingCart> list = imp.queryByUserId("9b28e5d7ebbc4650a607445eb0af99a9");
		System.out.println(list.size());
	}
	
}
