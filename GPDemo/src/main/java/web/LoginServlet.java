package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.MallingUserDao;
import dao.MallingUserDaoImpl;
import entity.MallingUser;
import util.ResultCode;
import util.UuidUtil;

public class LoginServlet extends HttpServlet{
	/**
	* @Fields LoginServlet.java
	*/
	private static final long serialVersionUID = -4563094501016356110L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String path = req.getServletPath();
		//控制台输出请求路径
		System.out.println(path);
		
		if ("/login.json".equals(path)) {
			login(req,res);
		}else if ("/register.json".equals(path)) {
			register(req,res);
		}else {
			throw new RuntimeException("查无此页!");
		}
		
	}
	
	/**
	 * 注册
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @author fudakui
	 * @date 2017年4月9日
	 * modify history
	 */
	private void register(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("ts", new Date().getTime());
		
//		if (username == null || "".equals(username)) {
//			resultMap.put("code", ResultCode.USER_NAME_EMPTY);
//			resultMap.put("msg", "用户名不能为空");
//			resultMap.put("data", "");
//			out.write(gson.toJson(resultMap));
//			out.flush(); 
//			out.close(); 
//			return ;
//		}
//		
//		if (password == null || "".equals(password)) {
//			resultMap.put("code", ResultCode.PASSWORD_EMPTY);
//			resultMap.put("msg", "密码不能为空");
//			resultMap.put("data", "");
//			out.write(gson.toJson(resultMap));
//			out.flush(); 
//			out.close(); 
//			return ;
//		}
		
		MallingUserDao userDao = new MallingUserDaoImpl();
		MallingUser user = userDao.findUserByName(username);
		if (user != null) {
			resultMap.put("code", ResultCode.USER_NAME_EXITS);
			resultMap.put("msg", "用户名已存在");
			resultMap.put("data", "");
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close(); 
			return ;
		}
		user = new MallingUser();
		user.setId(UuidUtil.generateUUID());
		user.setUserName(username);
		user.setPassword(password);
		user.setCreateTime(new Date());
		user.setToken(UuidUtil.generateUUID());
		if(userDao.insert(user)){
			resultMap.put("code", ResultCode.SUCCEED);
			resultMap.put("msg", "注册成功");
			resultMap.put("data", "");
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close(); 
			return ;
		}
		resultMap.put("code", ResultCode.UNKNOWN_ERROR);
		resultMap.put("msg", "注册失败");
		resultMap.put("data", "");
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close(); 
		return ;
		
	}

	/**
	 * 登录判断
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年4月9日
	 * modify history
	 */
	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("ts", new Date().getTime());
//		if (username == null || "".equals(username)) {
//			resultMap.put("code", ResultCode.USER_NAME_EMPTY);
//			resultMap.put("msg", "用户名不能为空");
//			resultMap.put("data", "");
//			out.write(gson.toJson(resultMap));
//			out.flush(); 
//			out.close(); 
//			return ;
//		}
//		
//		if (password == null || "".equals(password)) {
//			resultMap.put("code", ResultCode.PASSWORD_EMPTY);
//			resultMap.put("msg", "密码不能为空");
//			resultMap.put("data", "");
//			out.write(gson.toJson(resultMap));
//			out.flush(); 
//			out.close(); 
//			return ;
//		}
		
		MallingUserDao userDao = new MallingUserDaoImpl();
		MallingUser user = userDao.findUserByName(username);
		if (user == null) {
			resultMap.put("code", ResultCode.USER_NAME_NOTEXITS);
			resultMap.put("msg", "用户不存在");
			resultMap.put("data", "");
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close(); 
			return ;
		}
		if (!user.getPassword().equals(password)) {
			resultMap.put("code", ResultCode.PASSWORD_ERROR);
			resultMap.put("msg", "密码错误");
			resultMap.put("data", "");
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close(); 
			return ;
		}
		Map<String, String> data = new HashMap<String, String>();
		data.put("id", user.getId());
		data.put("token", user.getToken());
		resultMap.put("code", ResultCode.SUCCEED);
		resultMap.put("msg", "登录成功");
		resultMap.put("data", data);
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close(); 
		return ;
	}
	
	
	
	
	
	
}
