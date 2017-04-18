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
import dao.CatalogueThreeDao;
import dao.CatalogueThreeDaoImpl;
import dao.GoodsRecommendDao;
import dao.GoodsRecommendDaoImpl;
import dao.MallingGoodDao;
import dao.MallingGoodDaoImpl;
import entity.Catalogue;
import entity.CatalogueExtend;
import entity.CatalogueThree;
import entity.GoodsRecommend;
import entity.MallingGoods;
import util.DataList;
import util.JsonResult;
import util.ResultCode;
import util.UuidUtil;

public class MainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = req.getServletPath();
		//控制台输出请求路径
		System.out.println(path);
		if ("/allCata.do".equals(path)) {//全部分类
			allCata(req,res);
		}else if ("/singleCata.do".equals(path)) {//id 1  某一种分类
			singleCata(req,res);
		}else if ("/findGoodsByType.do".equals(path)) {//type3    具体分类下的商品列表
			findGoodsByType(req,res);
		}else if ("/findGoodById.do".equals(path)) {//id   商品信息
			findGoodById(req,res);
		}else if ("/findRecommend.do".equals(path)) {//查看推荐  userId
			findRecommend(req,res);
		}else if ("/insertRecommend.do".equals(path)) {//存入用户推荐表中
			insertRecommend(req,res);
		}else {
			error(req,res);
			throw new RuntimeException("查无此页!");
		}
	}
	
	/**
	 * 存入用户浏览的商品ID
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	private void insertRecommend(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String userId = req.getParameter("userId");
		String goodId = req.getParameter("goodId");
		
		if (userId == null || goodId == null) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "参数为空");
			resultMap.put("data", "");
			resultMap.put("ts", new Date().getTime());
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close();
			return;
		}
		GoodsRecommendDao recommendDao = new GoodsRecommendDaoImpl();
		GoodsRecommend goodRecommend = new GoodsRecommend();
		goodRecommend.setRid(UuidUtil.generateUUID());
		goodRecommend.setUserId(userId);
		goodRecommend.setGoodId(goodId);
		
		boolean bool = recommendDao.insertOrUpdate(goodRecommend);
		if (bool) {
			resultMap.put("code", ResultCode.SUCCEED);
			resultMap.put("msg", "插入成功");
		}else {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "插入失败");
		}
		resultMap.put("data", "");
		resultMap.put("ts", new Date().getTime());
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close();
	}

	/**
	 * 根据userId查询推荐商品
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年4月16日
	 * modify history
	 */
	private void findRecommend(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//接收userId参数
		String userId = req.getParameter("userId");
		if (userId == null) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "参数为空");
			resultMap.put("data", "");
			resultMap.put("ts", new Date().getTime());
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close();
			return;
		}
		GoodsRecommendDao recommendDao = new GoodsRecommendDaoImpl();
		List<String> ids = recommendDao.queryByUserId(userId);
		MallingGoodDao goodDao = new MallingGoodDaoImpl();
		List<MallingGoods> goodList = goodDao.findGoodsByIds(ids);
		
		resultMap.put("code", ResultCode.SUCCEED);
		resultMap.put("msg", "查询成功");
		resultMap.put("data", goodList);
		resultMap.put("ts", new Date().getTime());
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close();
	}

	/**
	 * 未知原因错误返回状态值
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @author fudakui
	 * @date 2017年4月8日
	 * modify history
	 */
	private void error(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("code", ResultCode.UNKNOWN_ERROR);
		resultMap.put("msg", "");
		resultMap.put("data", "");
		resultMap.put("ts", new Date().getTime());
		
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close(); 
	}

	/**
	 * 通过商品ID查询商品信息
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年3月18日
	 * modify history
	 */
	private void findGoodById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		String idStr = req.getParameter("id");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Gson gson = new Gson();
		MallingGoodDao dao = new MallingGoodDaoImpl();
		MallingGoods good = dao.findGoodById(idStr);
		if (good == null) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "暂无数据");
			resultMap.put("data", good);
		}else {
			resultMap.put("code", ResultCode.SUCCEED);
			resultMap.put("msg", "查询成功");
			resultMap.put("data", good);
		}
		resultMap.put("ts", new Date().getTime());
		
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close(); 
	}

	/**
	 * 通过分类类型查询某一类商品
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @author fudakui
	 * @date 2017年3月18日
	 * modify history
	 */
	//type = 3
	private void findGoodsByType(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		String type = req.getParameter("type");
		JsonResult<DataList> result = new JsonResult<DataList>();
		Gson gson = new Gson();
		DataList dataList = new DataList();
		MallingGoodDao dao = new MallingGoodDaoImpl();
		
		List<MallingGoods> goodlist = dao.findByType(type);
		if (goodlist.isEmpty()) {
			result.setCode(ResultCode.FAILURE);
			result.setData(dataList);
			result.setMsg("暂无数据");
		}else {
			result.setCode(JsonResult.SUCCESS);
			dataList.setMallingGoods(goodlist);
			result.setData(dataList);
			result.setMsg("查询成功");
		}
		result.setTs(new Date().getTime());
		//输出
		out.write(gson.toJson(result));
		out.flush(); 
		out.close(); 
	}

	
	/**
	 * singleCata.do?id=
	 * 通过参数cid查询某一级目录分类下的所有分类信息并返回 
	 * @param req
	 * @param res
	 * @author fudakui
	 * @date 2017年3月10日
	 * modify history
	 */
	//(cid)id=1
	private void singleCata(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		String cidStr = req.getParameter("id");//获取一级目录ID
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> mapList = new HashMap<String, Object>();
		Gson gson = new Gson();
		
		//通过cid查询二级分类信息
		CatalogueExtendDao dao = new CatalogueExtendImpl();
		
		List<CatalogueExtend> ceList = dao.findById(cidStr);
		
		if (ceList.isEmpty()) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("data", mapList);
			resultMap.put("msg", "暂无数据");
		} else {
			List<CatalogueThree> threeList = new ArrayList<CatalogueThree>();
			CatalogueThreeDao threeDao = new CatalogueThreeDaoImpl();
			for (CatalogueExtend catalogueExtend : ceList) {
				List<CatalogueThree> list = threeDao.findById(catalogueExtend.getCeid()); 
				for (CatalogueThree catalogueThree : list) {
					catalogueThree.setCeid(catalogueExtend.getCeid());
					threeList.add(catalogueThree);
				}
			}
			if (threeList == null || threeList.size() < 1) {
				mapList.put("catalogueThree", "暂无数据");
			}else {
				mapList.put("catalogueThree", threeList);
			}
			mapList.put("catalogueExtend", ceList);
			resultMap.put("code", ResultCode.SUCCEED);
			resultMap.put("data", mapList);
			resultMap.put("msg", "查询成功");
			
		}
		resultMap.put("ts", new Date().getTime());
		//输出
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close(); 
	}
	
	
	/** 完成*****
	 * 查询出所有分类目录信息
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 * @author fudakui
	 * @date 2017年3月10日
	 * modify history
	 */
	private void allCata(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> mapList = new HashMap<String, Object>();
		
		Gson gson = new Gson();
		//查询所有一级目录分类信息
		CatalogueDao dao = new CatalogueDaoImpl();
		List<Catalogue> catalogueList = dao.findAll();
		
		if (catalogueList.isEmpty()) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "暂无数据");
			resultMap.put("data", mapList);
		}else {
//			mapList.put("catalogue", catalogueList);
			resultMap.put("code", ResultCode.SUCCEED);
			resultMap.put("data", catalogueList);
			resultMap.put("msg", "查询成功");
		}
		resultMap.put("ts", new Date().getTime());
		//输出 
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close(); 
	}
}
