package web;

import com.google.gson.Gson;
import dao.*;
import entity.*;
import util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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
		}else if ("/toShoppingCartList.do".equals(path)) {//获取购物车列表
			toShoppingCartList(req,res);
		}else if ("/addShoppingCart.do".equals(path)){//添加到购物车
			addShoppingCart(req,res);
		}else {
			error(req,res);
			throw new RuntimeException("查无此页!");
		}
	}

	/**
	 * 添加到购物车
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	private void addShoppingCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String userId = req.getParameter("userId");
		String goodId = req.getParameter("goodId");
		String countStr = req.getParameter("count");
		resultMap.put("ts", new Date().getTime());
		if (userId==null || goodId==null || countStr==null){
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "参数为空");
			resultMap.put("data", "");
			out.write(gson.toJson(resultMap));
			out.flush();
			out.close();
			return;
		}
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(UuidUtil.generateUUID());
		shoppingCart.setGoodId(goodId);
		shoppingCart.setCount(Integer.parseInt(countStr));
		shoppingCart.setUserId(userId);
		ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();
		boolean bool = shoppingCartDao.insert(shoppingCart);
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
	 * 返回购物车列表
	 * 描述方法作用
	 * @param req
	 * @param res
	 * @author fudakui
	 * @date 2017年4月22日
	 * modify history
	 */
	private void toShoppingCartList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/plain");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String userId = req.getParameter("userId");
		
		resultMap.put("ts", new Date().getTime());
		if (userId == null) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "参数为空");
			resultMap.put("data", "");
			out.write(gson.toJson(resultMap));
			out.flush(); 
			out.close();
			return;
		}
		Map<String, Object> data = new HashMap<String, Object>();
		resultMap.put("code", ResultCode.SUCCEED);
		MallingGoodDao goodDao = new MallingGoodDaoImpl();
		
		//通过userId查询购物车列表
		ShoppingCartDao shopDao = new ShoppingCartDaoImpl();
		List<ShoppingCart> shopVos = shopDao.queryByUserId(userId);
		List<Map<String, Object>> shoppingCartList = new ArrayList<Map<String,Object>>();
		for (ShoppingCart shopVo : shopVos) {
			Map<String, Object> shopGoodMap = new HashMap<String, Object>();
			MallingGoods shopGoodVo = goodDao.findGoodById(shopVo.getGoodId());
			shopGoodMap.put("name", shopGoodVo.getGoodName());
			shopGoodMap.put("price", shopGoodVo.getPrice()*100);
			shopGoodMap.put("described", shopGoodVo.getDescription());
			shopGoodMap.put("url", IPUtil.getContentpath()+shopGoodVo.getImageUrl());
			shopGoodMap.put("count", shopVo.getCount());
			shoppingCartList.add(shopGoodMap);
		}
		data.put("shoppingCartList", shoppingCartList);
		
		//通过userId查询浏览商品id记录
		GoodsRecommendDao recommendDao = new GoodsRecommendDaoImpl();
		List<String> recommendIds = recommendDao.queryByUserId(userId);
		List<Map<String, Object>> recommendedList = new ArrayList<Map<String,Object>>();
		Random rand = new Random();
		for (String goodId: recommendIds) {
			Map<String, Object> recommendGoodMap = new HashMap<String, Object>();
			MallingGoods recommendGoodVo = goodDao.findGoodById(goodId);
			recommendGoodMap.put("name", recommendGoodVo.getGoodName());
			recommendGoodMap.put("price", recommendGoodVo.getPrice()*100);
			recommendGoodMap.put("url", IPUtil.getContentpath()+recommendGoodVo.getImageUrl());
			recommendGoodMap.put("type", rand.nextInt(2)+1);
			recommendedList.add(recommendGoodMap);
		}
		data.put("recommendedList", recommendedList);
		resultMap.put("data", data);
		out.write(gson.toJson(resultMap));
		out.flush(); 
		out.close();
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
		Map<String, Object> resultMap = new HashMap<String, Object>();//最外层
		Map<String, Object> mapList = new HashMap<String, Object>();//data层
		Gson gson = new Gson();
		
		//通过cid查询二级分类信息
		CatalogueExtendDao dao = new CatalogueExtendImpl();
		List<CatalogueExtend> ceList = dao.findById(cidStr);
		
		if (ceList.isEmpty()) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("data", mapList);
			resultMap.put("msg", "暂无数据");
		} else {
			List<Map<String, Object>> categoryList = new ArrayList<Map<String,Object>>();//categoryList层
			CatalogueThreeDao threeDao = new CatalogueThreeDaoImpl();
			for (CatalogueExtend catalogueExtend : ceList) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("titleName", catalogueExtend.getCename());
				//通过二级分类ID查询对应三级分类
				List<CatalogueThree> list = threeDao.findById(catalogueExtend.getCeid());
				List<Map<String, String>> products = new ArrayList<Map<String,String>>();
				for (CatalogueThree catathree : list) {
					Map<String, String> three = new HashMap<String, String>();
					three.put("title", catathree.getTname());
					three.put("id", catathree.getTid());
					three.put("url", IPUtil.getContentpath()+catathree.getPurl());
					products.add(three);
				}
				map.put("products", products);
				categoryList.add(map);
			}
			mapList.put("categoryList", categoryList);
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
