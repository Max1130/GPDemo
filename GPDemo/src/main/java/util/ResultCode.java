package util;

public class ResultCode {
	public static final Integer SUCCEED = 0;//成功
	public final static Integer FAILURE = 1;//失败
	public static final Integer USER_NAME_EMPTY = 101;//用户名不能为空
	public static final Integer USER_NAME_NOTEXITS = 102;//用户不存在
	public static final Integer TOKEN_EMPTY = 103;//Token 不能为空
	public static final Integer PASSWORD_EMPTY = 104;//密码不能为空
	public static final Integer PASSWORD_ERROR = 105;//密码错误
	public static final Integer USER_NAME_EXITS = 106;//用户名已存在
	
	public static final Integer UNKNOWN_ERROR = -1;//未知原因失败
}
