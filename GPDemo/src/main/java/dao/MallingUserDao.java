package dao;

import entity.MallingUser;

public interface MallingUserDao {
	/**
	 * 注册
	 * 描述方法作用
	 * @param userName
	 * @param password
	 * @author fudakui
	 * @date 2017年3月28日
	 * modify history
	 */
	public boolean insert(MallingUser user);
	/**
	 * 通过userName查询用户
	 * 描述方法作用
	 * @param userName
	 * @param password
	 * @return
	 * @author fudakui
	 * @date 2017年3月28日
	 * modify history
	 */
	public MallingUser findUserByName(String userName);
}
