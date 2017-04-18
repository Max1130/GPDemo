package web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		}else{
			
		}
		
	}

	private void index(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		req.getRequestDispatcher("WEB-INF/yyb/hello.jsp").forward(req, res);
	}

	private void webLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		String Uname=req.getParameter("Uname");
		HttpSession session=req.getSession();
		session.setAttribute("Uname",Uname);
		//重定向到你需要的页面去
		res.sendRedirect("index.html");
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
		req.getRequestDispatcher("WEB-INF/yyb/tologin.jsp").forward(req, res);
	}

}
