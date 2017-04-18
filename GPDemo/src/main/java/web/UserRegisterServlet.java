package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public UserRegisterServlet(){
		super();
	}
	
	public void init(HttpServletRequest request,HttpServletResponse response){
		
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		// �����������Ӧ����
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		// �ж������Ƿ��Ѿ���ע��
		UserDAO dao = new UserDAO();
		boolean flag = dao.isExistEmail(account);
		if(flag){
			// �˺��Ѿ�ע�ᣬ���д�����ʾ�������������
			
			// ��ʱͳһת������ҳ��
			response.sendRedirect("error.html");
		} else{
			// �˺�δ��ע�ᣬ����ע���û���Ϣ
			dao.save(account,password,username);
			// ע��ɹ����ض��򵽵�½ҳ��
			response.sendRedirect("login.html");
		}
	}
	
	public void destory(){
		
	}
}
