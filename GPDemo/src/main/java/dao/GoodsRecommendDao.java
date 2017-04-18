package dao;

import java.util.List;

import entity.GoodsRecommend;

public interface GoodsRecommendDao {
	/**
	 * 存入商品
	 * 描述方法作用
	 * @param goodRecommend
	 * @return
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	public boolean insertOrUpdate(GoodsRecommend goodRecommend);
	/**
	 * 根据用户ID查询浏览记录商品ID
	 * 描述方法作用
	 * @param userId
	 * @return
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	public List<String> queryByUserId(String userId);
}
