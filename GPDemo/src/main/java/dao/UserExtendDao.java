package dao;

import entity.UserExtend;

public interface UserExtendDao {
	//新增用户信息
	boolean insert(UserExtend userExtend);
	boolean update(UserExtend userExtend);
	//上传
	boolean insert(String userId,String headUrl);
	//更新头像
	boolean update(String userId,String headUrl);
	
	UserExtend query(String userId);
}
