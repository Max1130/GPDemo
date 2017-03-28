package dao;

import java.util.List;

import entity.MallingGoods;

public interface MallingGoodDao {
	/**
	 * 根据分类类型type查询商品列表
	 * 描述方法作用
	 * @param type
	 * @return
	 * @author fudakui
	 * @date 2017年3月18日
	 * modify history
	 */
	List<MallingGoods> findByType(String type);
	
	MallingGoods findGoodById(String id);
}
