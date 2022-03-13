package qna.app.servlet;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import qna.app.components.Controller;
import qna.app.container.AppContainer;
import qna.app.handler.ExceptionHandler;
import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;


//servlet으로 만들어 준다.
//모든 요청을 받아 해당 가야하는 부분으로 전달하고 결과를 받아 을답해주는 역할




//
//run as를 했을때 모든 url을 받아온다 어떤 url을 입력해도 받아온다(콘솔창으로 넘어온다?)
@WebServlet("/qna/*")  // /뒤에오는 모든 문자를 받아준다는 뜻 (모든요청은 url로 움직인다)
//("/*") ==> 이렇게 요청을 하면 나중에 문제가 생긴다 무한적으로 반복이 된다(어떤 요청이 와도 왔다갔다 반복한다)
public class DispatcherServlet extends HttpServlet {
	
	private ExceptionHandler exceptionHandler = new ExceptionHandler();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AppRequest appRequest = new AppRequest(request, response);
		
		UriProcessor uriProcessor = new UriProcessor(appRequest.getReqUri());
		
		if(uriProcessor.isIndex()) {
			appRequest.render("index");
		}
		
		//에러페이지를 보여주게끔
		if( !uriProcessor.isValid() || uriProcessor.getControllerCode().equals("")) {
			exceptionHandler.handlerRequest(appRequest);
		}
		
		//controller코드??
		Controller findController = findController(uriProcessor.getControllerCode());
		
		uriProcessor.printCurrentStatus();
		
		switch(appRequest.getMethod()) {
		
		case "GET":
			findController.getMapping(appRequest, uriProcessor);
		case "POST":
			findController.postMapping(appRequest, uriProcessor);
		}
		
		
	}
	
	private Controller findController(String controllerCode) { //component에 import
		
		switch( controllerCode ) {
			case "question":
				return AppContainer.questionController;
			default:
				return null;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
