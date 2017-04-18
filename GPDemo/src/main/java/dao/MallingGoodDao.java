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
	/**
	 * 通过商品ID查询商品信息
	 * 描述方法作用
	 * @param id
	 * @return
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	MallingGoods findGoodById(String id);
	/**
	 * 通过很多商品ID查询返回商品list
	 * 描述方法作用
	 * @param ids
	 * @return
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	List<MallingGoods> findGoodsByIds(List<String> ids);
}
