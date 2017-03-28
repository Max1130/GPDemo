package dao;

import java.util.List;

import entity.CatalogueExtend;

public interface CatalogueExtendDao {
	/**
	 * 通过一级分类ID查询二级分类信息
	 * 描述方法作用
	 * @param cid
	 * @return
	 * @author fudakui
	 * @date 2017年3月10日
	 * modify history
	 */
	List<CatalogueExtend> findById(String cid);
}
