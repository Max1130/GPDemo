package dao;

import entity.MallingGoods;

import java.util.List;

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
	List<MallingGoods> queryAll();
	List<MallingGoods> findGoodsByName(String name);
	/**
	 * 分页查询商品
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<MallingGoods> findGoodsByPage(Integer pageIndex,Integer pageSize);
	/**
	 * 描述方法作用  查询所有商品记录数
	 * @author fudakui
	 * @date 2017/5/15
	 * modify history
	 */
	public Integer findRows();

	List<MallingGoods> findGoodsByNameForPage(Integer pageIndex, Integer pageSize,String name);

	public Integer findRowsForName(String name);
}
