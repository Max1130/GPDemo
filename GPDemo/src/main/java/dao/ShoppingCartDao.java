package dao;

import entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
	
	/**
	 * 查看当前用户购物车列表
	 * 描述方法作用
	 * @param userId
	 * @return
	 * @author fudakui
	 * @date 2017年4月22日
	 * modify history
	 */
	public List<ShoppingCart> queryByUserId(String userId);

	/**
	 * 新增入购物车
	 * @param shoppingCart
	 * @return
	 */
	public boolean insert(ShoppingCart shoppingCart);
}
