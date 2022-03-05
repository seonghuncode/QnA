package qna.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.service.QuestionService;
import qna.util.RequestFactory;


@WebServlet("/question/add")
public class QuestionController extends HttpServlet {
	
	private QuestionService questionService = new QuestionService(); //사용하기 위해 만들어 준다
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response);
		factory.forwardToJsp("usr/question/add"); //usr(유저) , ("/WEB-INF" + path + ".jsp")여기 들어간다
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestFactory factory = new RequestFactory(request, response);
		
		HttpServletRequest req = factory.getReq(); 
		
		String title = req.getParameter("title").toString();//html에 있는 폼테크를 servlet에서 받기 위해서 써준다.
		String body = req.getParameter("body").toString(); 
		//getparameter("qqq") -> 폼테그안에 qqq를 찾아 값을 찾아온다. 이 값은 objext로 리턴이 되기 때문에 toString을 적어준다.
		
		
		questionService.save(title, body); //save에게 넘겨준다
		
	}
//
}
