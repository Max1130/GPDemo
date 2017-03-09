package dao;

import java.util.List;

import entity.Catalogue;

public interface CatalogueDao {
	/**
	 * 查询所有分类
	 * @return
	 */
	List<Catalogue> findAll();
}
