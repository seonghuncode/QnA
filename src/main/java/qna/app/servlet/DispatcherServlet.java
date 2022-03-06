package qna.app.servlet;

import java.io.IOException;
//servlet으로 만들어 준다.
//모든 요청을 받아 해당 가야하는 부분으로 전달하고 결과를 받아 을답해주는 역할

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.app.util.RequestFactory;

//
//run as를 했을때 모든 url을 받아온다 어떤 url을 입력해도 받아온다(콘솔창으로 넘어온다?)
@WebServlet("/*")  // /뒤에오는 모든 문자를 받아준다는 뜻 (모든요청은 url로 움직인다)
public class DispatcherServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestFactory factory = new RequestFactory(request, response);
		
		
		System.out.println(request.getRequestURI());  //모든 요청이 오는지 확인하는 작업 -> run as
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
