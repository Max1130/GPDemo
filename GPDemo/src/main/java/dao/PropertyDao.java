package dao;

import entity.PropertyBean;

public interface PropertyDao {
	PropertyBean queryByGoodNumber(String goodNumber);
}
