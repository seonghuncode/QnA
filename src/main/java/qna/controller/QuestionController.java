package qna.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.util.RequestFactory;


@WebServlet("/question/add")
public class QuestionController extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestFactory factory = new RequestFactory(request, response);
		factory.forwardToJsp("usr/question/add"); //use(유저) , ("/WEB-INF" + path + ".jsp")여기 들어간다
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestFactory factory = new RequestFactory(request, response);
		
		HttpServletRequest req = factory.getReq(); 
		
		String title = req.getParameter("title").toString();//html에 있는 폼테크를 servlet에서 받기 위해서 써준다.
		String body = req.getParameter("body").toString(); 
		//getparameter("qqq") -> 폼테그안에 qqq를 찾아 값을 찾아온다. 이 값은 objext로 리턴이 되기 때문에 toString을 적어준다.
		
		System.out.println(title);
		System.out.println(body); //위에서 받아온 값이 담겨 출력 되게 된다. run as를 해서 입력을 하면 콘솔창에 질 입력이 되어진다.
		
	}

}
