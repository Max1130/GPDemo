package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dao.CatalogueDao;
import dao.CatalogueDaoImpl;
import entity.Catalogue;
import util.JsonResult;

public class MainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println(path);
		if ("/test.do".equals(path)) {
			test(req,res);
		}else {
			throw new RuntimeException("查无此页!");
		}
	}

	protected void test(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		JsonResult<List<Catalogue>> result = new JsonResult<List<Catalogue>>();
		//查询分类
		CatalogueDao dao = new CatalogueDaoImpl();
		List<Catalogue> list = dao.findAll();
		Map<String, List<Catalogue>> map = new HashMap<String, List<Catalogue>>();
		map.put("Catalogue", list);
		Gson gson = new Gson();
		
		if (list==null) {
			result.setCode(0);
		}else {
			result.setCode(1);
			result.setData(map);
			
		}
		result.setTime(new Date().getTime());
		//输出 
		out.write(gson.toJson(result));
		out.flush(); 
		out.close(); 
	}
}
