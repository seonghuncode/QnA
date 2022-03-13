package qna.web.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.app.util.AppRequest;

//처음 화면에 404오류 페이지가 아닌 다른 페이지를 보여주기 위해 만들어 준다..
@WebServlet("/")  //요청이 /로 간가
public class HomeServlet extends HttpServlet {
	
       
   
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AppRequest factory = new AppRequest(request, response);
		
		factory.render("index");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
