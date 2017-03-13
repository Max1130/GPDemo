package dao;

import java.util.List;

import entity.Catalogue;

public interface CatalogueDao {
	/**
	 * 查询所有一级分类信息,用于分类列表展示
	 * @return
	 */
	List<Catalogue> findAll();
}
