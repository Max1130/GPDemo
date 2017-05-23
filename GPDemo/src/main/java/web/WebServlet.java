package web;

import dao.MallingGoodDao;
import dao.MallingGoodDaoImpl;
import dao.MallingUserDao;
import dao.MallingUserDaoImpl;
import entity.MallingGoods;
import entity.MallingUser;
import util.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WebServlet extends HttpServlet{

	/**
	* @Fields WebServlet.java
	*/
	private static final long serialVersionUID = -1241143686187976749L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String path = req.getServletPath();
		//控制台输出请求路径
		System.out.println(path);
		if ("/towebLogin.html".equals(path)) {
			towebLogin(req,res);
		}else if ("/webLogin.html".equals(path)) {
			webLogin(req,res);
		}else if ("/index.html".equals(path)) {
			index(req,res);
		}else if ("/towebRegister.html".equals(path)) {
			towebRegister(req,res);
		}else if ("/webRegister.html".equals(path)){
			webRegister(req,res);
		}else if ("/logout.html".equals(path)){
			logout(req,res);
		}else if ("/searchGoods.html".equals(path)){
			searchGoods(req,res);
		}else if ("/listGoodData.html".equals(path)){
			listGoodData(req,res);
		}else{
			error(req,res);
		}
		
	}

	private void error(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		req.getRequestDispatcher("error.jsp").forward(req,res);
	}

	private void webRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		String Uname=req.getParameter("userName");
		String password = req.getParameter("password");

		//首先判断该用户名是否已经被注册过
		MallingUserDao userDao = new MallingUserDaoImpl();
		MallingUser user = userDao.findUserByName(Uname);
		if (user != null){//该用户名已存在
			req.setAttribute("hasUser","用户名已存在!");
			req.getRequestDispatcher("register.jsp").forward(req,res);
		}else{//可以注册,并重定向到登录页面
			MallingUser insertUser = new MallingUser();
			insertUser.setId(UuidUtil.generateUUID());
			insertUser.setUserName(Uname);
			insertUser.setPassword(password);
			insertUser.setToken(UuidUtil.generateUUID());
			userDao.insert(insertUser);
			PrintWriter out = res.getWriter();
			//重定向到登录页面
			out.print("<script type='text/javascript'>"
					+ "alert('恭喜你注册成功啦!');"
					+ "window.location='towebLogin.html';"
					+ "</script>");
		}
	}

	private void listGoodData(HttpServletRequest req, HttpServletResponse res)  throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		MallingGoodDao goodDao = new MallingGoodDaoImpl();
		List<MallingGoods> goodList = goodDao.queryAll();

		req.setAttribute("goodsList", goodList);

	}



	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");

		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		String Uname = (String)session.getAttribute("Uname");

		if(Uname!=null && !Uname.equals("")){
			// 销毁session
			//session.invalidate();
			session.setAttribute("Uname", null);
			out.print("<script type='text/javascript'>"
					+ "alert('"+Uname+"成功退出');"
					+ "window.location='index.html';"
					+ "</script>");

		} else {
			System.out.println("已经退出过了");
			session.invalidate();
			res.sendRedirect("index.jsp");
		}
	}

	/**
	 * 描述方法作用 暂不用
	 * @author fudakui
	 * @date 2017/5/18
	 * modify history
	 */
	private void searchGoods(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");

		String goodName = req.getParameter("searchText");
		String pageIndex = req.getParameter("pageIndex");//第几页
		String pageSize  =req.getParameter("pageSize");//每页显示的条数

		//默认加载第一页10条数据
		if (pageIndex == null){
			pageIndex = "1";
		}
		if (pageSize == null){
			pageSize= "10" ;
		}


		MallingGoodDao goodDao = new MallingGoodDaoImpl();
		List<MallingGoods> goodList = new ArrayList<MallingGoods>();//
		Integer rows = 0;
		Integer totalPageSize = 0;
		if (goodName != null && !"".equals(goodName)){//查询
			goodList = goodDao.findGoodsByNameForPage(new Integer(pageIndex),new Integer(pageSize),goodName);
			rows = goodDao.findRowsForName(goodName);
		}else {
			goodList = goodDao.findGoodsByPage(new Integer(pageIndex),new Integer(pageSize));
			rows = goodDao.findRows();
		}

		totalPageSize = rows/new Integer(pageSize);
		if (rows % new Integer(pageSize) != 0) {
			totalPageSize++;
		}

		req.setAttribute("totalPageSize",totalPageSize);
		req.setAttribute("pageIndex",pageIndex);
		req.setAttribute("pageSize",pageSize);
		req.setAttribute("goodsList", goodList);
		req.setAttribute("operate","search");
		req.getRequestDispatcher("index1.jsp").forward(req,res);
	}

	/**
	 * 主页   显示所有商品
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年5月8日
	 * modify history
	 */
	private void index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");

		String goodName = req.getParameter("searchText");
		String pageIndex = req.getParameter("pageIndex");//第几页
		String pageSize  =req.getParameter("pageSize");//每页显示的条数

		//默认加载第一页10条数据
		if (pageIndex == null){
			pageIndex = "1";
		}
		if (pageSize == null){
			pageSize= "10" ;
		}


		MallingGoodDao goodDao = new MallingGoodDaoImpl();

		List<MallingGoods> goodList = new ArrayList<MallingGoods>();
		//获取记录总行数,用于计算总页数
		Integer rows = 0;
		Integer totalPageSize = 0;
		if (goodName != null && !"".equals(goodName)){//查询
			goodList = goodDao.findGoodsByNameForPage(new Integer(pageIndex),new Integer(pageSize),goodName);
			rows = goodDao.findRowsForName(goodName);
		}else {
			goodList = goodDao.findGoodsByPage(new Integer(pageIndex),new Integer(pageSize));
			rows = goodDao.findRows();
		}

		totalPageSize = rows/new Integer(pageSize);
		if (rows % new Integer(pageSize) != 0) {
			totalPageSize++;
		}

		req.setAttribute("goodsList", goodList);
		req.setAttribute("totalPageSize",totalPageSize);
		req.setAttribute("pageIndex",pageIndex);
		req.setAttribute("pageSize",pageSize);
		req.setAttribute("operate",goodName);
		req.getRequestDispatcher("index1.jsp").forward(req, res);

//		req.getRequestDispatcher("index.jsp").forward(req, res);
	}

	private void webLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=utf-8");
		String Uname=req.getParameter("userName");
		String password = req.getParameter("password");
		MallingUserDao userDao = new MallingUserDaoImpl();
		MallingUser user = userDao.findUserByName(Uname);
		if (user == null){
			req.setAttribute("noUser","用户名不存在!");
			req.getRequestDispatcher("login.jsp").forward(req,res);
		}else if (!password.equals(user.getPassword())){
			req.setAttribute("pwWrong","密码错误!");
			req.getRequestDispatcher("login.jsp").forward(req,res);
		}else {
			HttpSession session=req.getSession();
			PrintWriter out = res.getWriter();
			session.setAttribute("Uname",Uname);
			out.print("<script type='text/javascript'>"
					+ "window.location='index.html';"
					+ "</script>");
			//重定向到你需要的页面去
		}
	}
	
	/**
	 * 定位到注册页面
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年4月19日
	 * modify history
	 */
	private void towebRegister(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("register.jsp").forward(req, res);
	}
	/**
	 * 定位到登录页面
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年4月12日
	 * modify history
	 */
	private void towebLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		req.getRequestDispatcher("login.jsp").forward(req, res);
	}

}
