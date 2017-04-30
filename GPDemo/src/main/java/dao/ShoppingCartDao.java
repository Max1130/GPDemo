package dao;

import java.util.List;

import entity.ShoppingCart;

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
}
