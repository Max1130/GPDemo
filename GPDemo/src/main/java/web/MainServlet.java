package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.CatalogueDao;
import dao.CatalogueDaoImpl;
import dao.CatalogueExtendDao;
import dao.CatalogueExtendImpl;
import entity.Catalogue;
import entity.CatalogueExtend;
import util.DataList;
import util.JsonResult;

public class MainServlet<T> extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		System.out.println(path);
		if ("/allCata.do".equals(path)) {
			allCata(req,res);
		}else if ("/singleCata.do".equals(path)) {
			singleCata(req,res);
		}else {
			throw new RuntimeException("查无此页!");
		}
	}
	/**
	 * 通过参数cid查询某一级目录分类下的所有分类信息并返回 
	 * @param req
	 * @param res
	 * @author fudakui
	 * @date 2017年3月10日
	 * modify history
	 */
	private void singleCata(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.setContentType("text/plain");
//		res.setCharacterEncoding("UTF-8");
//		PrintWriter out = res.getWriter();
//		String cidStr = req.getParameter("cid");
//		
//		JsonResult<List<CatalogueExtend>> result = new JsonResult<List<CatalogueExtend>>();
//		Gson gson = new Gson();
//		
//		//通过cid查询二级分类信息
//		CatalogueExtendDao dao = new CatalogueExtendImpl();
//		
//		List<CatalogueExtend> list = dao.findCataExtend(Integer.parseInt(cidStr));
//		
//		if (list == null) {
//			result.setCode(JsonResult.FAILURE);
//		} else {
//			result.setCode(JsonResult.SUCCESS);
//			Map<String, List<CatalogueExtend>> map = new HashMap<String, List<CatalogueExtend>>();
//			map.put("catalogueExtend", list);
//			result.setData(map);
//		}
//		result.setTime(new Date().getTime());
//		//输出
//		out.write(gson.toJson(result));
//		out.flush(); 
//		out.close(); 
	}
	/**
	 * 查询出所有分类目录信息,并默认返回推荐分类的二级目录分类信息
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年3月10日
	 * modify history
	 */
	protected void allCata(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		JsonResult<DataList> result = new JsonResult<DataList>();
		
		Gson gson = new Gson();
		//查询所有一级目录分类信息
		CatalogueDao dao = new CatalogueDaoImpl();
		DataList dataList = new DataList();
		List<Catalogue> list = dao.findAll();
		
		if (list==null) {
			result.setCode(JsonResult.FAILURE);
		}else {
			//默认返回推荐分类的二级目录分类信息
			CatalogueExtendDao ceDao = new CatalogueExtendImpl();
			List<CatalogueExtend> ceList = ceDao.findById(list.get(0).getcid());
			if (ceList == null) {
				result.setCode(JsonResult.FAILURE);
			}else {
				result.setCode(JsonResult.SUCCESS);
				dataList.setCatalogue(list);
				dataList.setCatalogueExtend(ceList);
				result.setData(dataList);
			}
		}
		result.setTime(new Date().getTime());
		//输出 
		out.write(gson.toJson(result));
		out.flush(); 
		out.close(); 
	}
}
