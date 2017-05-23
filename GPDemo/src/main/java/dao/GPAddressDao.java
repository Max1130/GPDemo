package dao;

import java.util.List;

import entity.GPAddress;

public interface GPAddressDao {
	boolean insert(GPAddress gpAddress);
	boolean update(GPAddress address);
	boolean delete(String id);
	List<GPAddress> queryByUserId(String userId);
}
