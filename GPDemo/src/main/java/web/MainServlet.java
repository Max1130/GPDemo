package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.AddressDaoImpl;
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
import dao.PromotionDao;
import dao.PromotionDaoImpl;
import dao.PropertyDao;
import dao.PropertyDaoImpl;
import dao.ShoppingCartDao;
import dao.ShoppingCartDaoImpl;
import dao.UserExtendDao;
import dao.UserExtendDaoImpl;
import entity.Catalogue;
import entity.CatalogueExtend;
import entity.CatalogueThree;
import entity.GPAddress;
import entity.GoodsRecommend;
import entity.MallingGoods;
import entity.PromotionBean;
import entity.PropertyBean;
import entity.ShoppingCart;
import entity.UserExtend;
import util.IPUtil;
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
		}else if ("/toShoppingCartList.do".equals(path)) {//获取购物车列表
			toShoppingCartList(req,res);
		}else if ("/addShoppingCart.do".equals(path)){//添加到购物车
			addShoppingCart(req,res);
		}else if ("/uploadHeadImage.do".equals(path)) {
			uploadHeadImage(req,res);
		}else if ("/userInfo.do".equals(path)) {
			userInfo(req,res);
		}else if ("/addressAddOrUpdate.do".equals(path)) {
			addressAddOrUpdate(req,res);
		}else {
			error(req,res);
			throw new RuntimeException("查无此页!");
		}
	}

	
	private void addressAddOrUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/plain;charset=utf-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String address = req.getParameter("data");
		System.out.println("address:"+address);
		String userId = req.getParameter("userId");
		GPAddress gpaddress = gson.fromJson(address, new TypeToken<GPAddress>(){}.getType());
		gpaddress.setUserId(userId);

//		String addressId = req.getParameter("addressId");
//		String area = req.getParameter("area");
//		String consignee = req.getParameter("consignee");//收货人
//		String phoneNumber = req.getParameter("phoneNumber");
//		String addressDetail = req.getParameter("addressDetail");
		
		AddressDaoImpl dao = new AddressDaoImpl();
		boolean bool = false;
		try {
			if (gpaddress.getId() == null) {//新增
				bool = dao.insert(gpaddress);
			}else {
				bool = dao.update(gpaddress);
			}
			
			
			if (bool) {
				resultMap.put("code", ResultCode.SUCCEED);
				resultMap.put("msg", "地址信息更新成功!");
				resultMap.put("ts", new Date().getTime());
			}else {
				resultMap.put("code", ResultCode.FAILURE);
				resultMap.put("msg", "地址信息更新失败,请稍后重试!");
				resultMap.put("ts", new Date().getTime());
			}
			out.write(gson.toJson(resultMap));
			out.flush();
			out.close();
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "服务器异常!");
			resultMap.put("ts", new Date().getTime());
			out.write(gson.toJson(resultMap));
			out.flush();
			out.close();
		}
	}


	private void userInfo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/plain;charset=utf-8");
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String userId = req.getParameter("userId");
		String nickName = req.getParameter("nickName");
		String gender = req.getParameter("gender");
		String birthDay = req.getParameter("birthDay");
		
		if (userId == null) {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "参数缺失!");
			resultMap.put("ts", new Date().getTime());
			out.write(gson.toJson(resultMap));
			out.flush();
			out.close();
			return;
		}
		
		try {
			UserExtend userExtend = new UserExtend();
			userExtend.setId(UuidUtil.generateUUID());
			userExtend.setUserId(userId);
			userExtend.setNickName(nickName);
			userExtend.setGender(Integer.parseInt(gender));
			userExtend.setBirthDay(birthDay);
			UserExtendDao dao = new UserExtendDaoImpl();
			boolean bool = false;
			if (dao.query(userId) == null) {//新增
				bool = dao.insert(userExtend);
			}else {
				bool = dao.update(userExtend);
			}
			
			if (bool) {
				resultMap.put("code", ResultCode.SUCCEED);
				resultMap.put("msg", "用户信息更新成功!");
				resultMap.put("ts", new Date().getTime());
			}else {
				resultMap.put("code", ResultCode.FAILURE);
				resultMap.put("msg", "用户信息更新失败,请稍后重试!");
				resultMap.put("ts", new Date().getTime());
			}
			out.write(gson.toJson(resultMap));
			out.flush();
			out.close();
			return;
			
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "服务器异常!");
			resultMap.put("ts", new Date().getTime());
			out.write(gson.toJson(resultMap));
			out.flush();
			out.close();
		}
		
		
	}

	private void uploadHeadImage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/plain;charset=utf-8");
		String userId = req.getParameter("userId");
		System.out.println("userId:"+userId);
		
		String file = req.getParameter("file");
		System.out.println("file"+file);
		String path = "D:\\grass\\YouYiBuy\\headUrl\\"+userId;
//		File file=new File(path);//上传文件保存位置
//        File tempfile=new File("D:\\grass\\YouYiBuy\\headUrl");//上传缓存临时文件夹
//        if(!file.exists()){
//            file.mkdir();
//        }
//        if(!tempfile.exists()){
//            tempfile.mkdir();
//        }
        
//        PrintWriter out = res.getWriter();
//		Gson gson = new Gson();
//		
//        Map<String, Object> resultMap = new HashMap<String, Object>();
//        Map<String, Object> data = new HashMap<String, Object>();
//        
//        //判断是否上传文件表单,也就是form中是否有enctype="multipart/form-data"项;必须post提交,get提交对内容长度有限制
//        if(ServletFileUpload.isMultipartContent(req)){
//            DiskFileItemFactory factory=new DiskFileItemFactory();
//            factory.setSizeThreshold(1024*512);//设置缓冲区大小
//            factory.setRepository(tempfile);//设置临时文件夹
//            ServletFileUpload fileUpload=new ServletFileUpload(factory);
//            fileUpload.setFileSizeMax(10*1024*1024);//设置最大文件大小
//            
//            try {
//                @SuppressWarnings("unchecked")
//                List<FileItem> items=fileUpload.parseRequest(req);//获取所有表单
//                for(FileItem item:items){
//                    //判断当前的表单控件是否是一个普通控件
//                    if(!item.isFormField()){
//                        //是一个文件控件时
//                        String name=item.getName();
//                        System.out.println("上传文件名:"+name);
//                        System.out.println("文件大小:"+item.getSize());
//                        
//                        String extName=name.substring(name.lastIndexOf("."));
//                        String newName=new SimpleDateFormat("yyyyMMDDHHmmssms").format(new Date());
//                        
//                        System.out.println("扩展名"+extName);
//                        item.write(new File(path+newName+extName));
//                        
//                        resultMap.put("code", ResultCode.SUCCEED);
//                        resultMap.put("ts", new Date().getTime());
//                        resultMap.put("msg", "上传成功");
//                        out.write(gson.toJson(resultMap));
//                    	out.flush();
//            			out.close();
//                    }else{
//                        //是普通控件时
//                        String desc=item.getString("UTF-8");
//                        System.out.println("文件描述"+desc);
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                
//            }
//        }else{
//            throw new RuntimeException("请设置form表单的enctype属性");
//        }
////        response.sendRedirect("index.jsp?code=001");
		
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
			resultMap.put("msg", "添加购物车成功");
		}else {
			resultMap.put("code", ResultCode.FAILURE);
			resultMap.put("msg", "添加购物车失败!");
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
	//userId=9b28e5d7ebbc4650a607445eb0af99a9
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
			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("id", good.getId());
			data.put("name", good.getGoodName());
			data.put("url", good.getImageUrl());
			data.put("salesPrice", good.getPrice());
			
			//查询促销
			List<Map<String, String>> promotions = new ArrayList<Map<String,String>>(); 
			PromotionDao promotionDao = new PromotionDaoImpl();
			List<PromotionBean> promotionList = promotionDao.queryByGoodId(idStr);
			for (PromotionBean promotionBean : promotionList) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", promotionBean.getPromotion() == 1? "满减" : "买赠");
				map.put("description", promotionBean.getDescription());
				promotions.add(map);
			}
			data.put("promotions", promotions);
			
			//查询商品规格参数
			PropertyDao propertyDao = new PropertyDaoImpl();
			PropertyBean property = propertyDao.queryByGoodNumber(good.getGoodNumber());
			List<Map<String, String>> properties = new ArrayList<Map<String,String>>();
			Map<String, String> map1 = new HashMap<String, String>();
			map1.put("title", "商品编号");
			map1.put("value", property.getGoodNumber());
			properties.add(map1);
			
			Map<String, String> map2 = new HashMap<String, String>();
			map2.put("title", "组合形式");
			map2.put("value", property.getCombination());
			properties.add(map2);
			
			Map<String, String> map3 = new HashMap<String, String>();
			map3.put("title", "袖长");
			map3.put("value", property.getSleeveLength());
			properties.add(map3);
			
			Map<String, String> map4 = new HashMap<String, String>();
			map4.put("title", "腰型");
			map4.put("value", property.getWaistType());
			properties.add(map4);
			
			Map<String, String> map5 = new HashMap<String, String>();
			map5.put("title", "裙型");
			map5.put("value", property.getSkirtType());
			properties.add(map5);
			
			Map<String, String> map6 = new HashMap<String, String>();
			map6.put("title", "质地");
			map6.put("value", property.getTexture());
			properties.add(map6);
			
			Map<String, String> map7 = new HashMap<String, String>();
			map7.put("title", "价格");
			map7.put("value", property.getPrice());
			properties.add(map7);
			
			Map<String, String> map8 = new HashMap<String, String>();
			map8.put("title", "尺码");
			map8.put("value", property.getSize());
			properties.add(map8);
			
			Map<String, String> map9 = new HashMap<String, String>();
			map9.put("title", "裙长");
			map9.put("value", property.getSkirtLength());
			properties.add(map9);
			
			Map<String, String> map10 = new HashMap<String, String>();
			map10.put("title", "颜色");
			map10.put("value", property.getColor());
			properties.add(map10);
			
			Map<String, String> map11 = new HashMap<String, String>();
			map11.put("title", "上市时间");
			map11.put("value", property.getTime());
			properties.add(map11);
			
			Map<String, String> map12 = new HashMap<String, String>();
			map12.put("title", "类型");
			map12.put("value", property.getType());
			properties.add(map12);
			
			data.put("properties", properties);
			
			resultMap.put("data", data);
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
//		JsonResult<DataList> result = new JsonResult<DataList>();
		Gson gson = new Gson();
//		DataList dataList = new DataList();
		MallingGoodDao dao = new MallingGoodDaoImpl();
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<MallingGoods> goodlist = dao.findByType(type);
		if (goodlist.isEmpty()) {
			resultMap.put("code",ResultCode.FAILURE);
			resultMap.put("msg","暂无数据!");
//			result.setCode(ResultCode.FAILURE);
//			result.setData(dataList);
//			result.setMsg("暂无数据");
		}else {
			resultMap.put("code",ResultCode.SUCCEED);
			resultMap.put("msg","查询成功!");
			resultMap.put("data",goodlist);
//			result.setCode(JsonResult.SUCCESS);
//			dataList.setMallingGoods(goodlist);
//			result.setData(goodlist);
//			result.setMsg("查询成功");
		}
		resultMap.put("ts",new Date().getTime() );
//		result.setTs(new Date().getTime());
		//输出
		out.write(gson.toJson(resultMap));
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
