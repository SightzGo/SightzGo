package com.sightzgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sightzgo.dao.UserDao;
import com.sightzgo.dao.impl.UserDaoImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();
		String error = "0";
		int idint = 0;
		int success = 1;

		String loginname = request.getParameter("loginname");
		if (loginname == "") {
			success = 0;
			jsonObj.accumulate("error", "1");
			out.print(jsonObj);
		}

		String password = request.getParameter("password");
		if (password == "") {
			success = 0;
			jsonObj.accumulate("error", "2");
			out.print(jsonObj);
		}

		if (success == 1) {
			UserDao ud = new UserDaoImpl();
			success = ud.findUserName(loginname);
			
			if (success == 0) {
				jsonObj.accumulate("error", "3");
				out.print(jsonObj);
			} else {
				idint = ud.findUserId(loginname, password);
				String id = String.valueOf(idint);
				jsonObj.accumulate("id", id);
				out.print(jsonObj);
			}
		}

	}
}
