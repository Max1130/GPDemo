package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserBean;
import util.DBUtil;

public class UserDAO {
	private static UserBean bean = null;
	
	/**
	 * ��֤�˺��Ƿ��Ѿ�����
	 * @param account
	 * @return
	 */
	public boolean isExistEmail(String account) {		
		// ���ض����ݿ�����ӣ��Ự������������������ִ�� SQL ��䲢���ؽ��
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;// ��ʾԤ�����SQL���Ķ���
		ResultSet rs = null;
		String sql = "select * from user_bean where id = ?";// ����sql��ѯ���
		try{
			// ������·��һ�����Statement���󼴿ɣ��������Insert��update������Ҫ���PreparedStatement�������
			pstmt = conn.prepareStatement(sql);
			// ����SQL���Ĳ���ֵ
			pstmt.setString(1,account);
			// �ڴ� PreparedStatement ������ִ�� SQL ��ѯ�������ظò�ѯ���ɵ� ResultSet ����
			rs = pstmt.executeQuery();
			if(rs.next()) // ����µĵ�ǰ����Ч���򷵻� true�������������һ�У��򷵻� false 
				return true;
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBUtil.close(conn);
		}
		return false;
	}

	/**
	 * ע����Ϣ����
	 * @param account
	 * @param password
	 */
	public void save(String account, String password, String username) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into user_bean ("
				+ "id,upsd,uname) values(?,?,?);";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
			// �����ݸ���
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �û���½
	 * @param account
	 * @param password
	 * @return
	 */
	public String login(String account, String password) {
		String nickname = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select uname from user_bean where id=? and upsd=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery(); // ִ��  ��ѯ
			if(rs.next()){
				// �� Java ��������� String ����ʽ��ȡ�� ResultSet ����ĵ�ǰ����ָ���е�ֵ
				nickname = rs.getString("uname");
				bean = new UserBean(account,password,nickname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(conn);
		}
		return nickname;
	}
	
	/**
	 * �����û���bean
	 * @return
	 */
	public UserBean getBean(){
		return bean;
	}

	/**
	 * �û��޸��Լ�����Ϣ
	 * @param bean
	 * @return
	 */
	public boolean modifyUserInformation(UserBean bean) {
		Connection conn = DBUtil.getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "update user_bean set upsd=?,uname=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			String uid = bean.getid();
			String upsd = bean.getUpsd();
			String uname = bean.getUname();
			if(upsd!=null && uname!=null && !upsd.equals("") && !uname.equals("")){
				pstmt.setString(1, upsd);
				pstmt.setString(2, uname);
				pstmt.setString(3, uid);
				if(pstmt.executeUpdate()>0){
					// ��Ȼ�Ѿ��޸ĳɹ�����ô�޸�bean
					this.bean = bean;
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(conn);
		}
		return false;
	}
}
