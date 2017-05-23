package dao;

import java.util.List;

import entity.PromotionBean;

public interface PromotionDao {

	List<PromotionBean> queryByGoodId(String goodId);
}
