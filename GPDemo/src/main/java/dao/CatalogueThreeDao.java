package dao;

import java.util.List;

import entity.CatalogueThree;

public interface CatalogueThreeDao {
	/**
	 * 
	 * 描述方法作用  通过上级分类ID查询分类信息
	 * @param ceid
	 * @return
	 * @author fudakui
	 * @date 2017年3月15日
	 * modify history
	 */
	List<CatalogueThree> findById(Integer ceid);
}
