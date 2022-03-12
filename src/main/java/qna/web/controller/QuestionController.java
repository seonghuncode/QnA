package qna.web.controller;

import qna.app.components.Controller;
import qna.app.container.AppContainer;
import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;
import qna.web.service.QuestionService;

public class QuestionController implements Controller {
	
	private QuestionService questionService;

	@Override
	public void autoWried() {
		
		questionService = AppContainer.questionService;  //서비스 연결
		
	}

	@Override
	public void getMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		//get() 에서는 showWrite(), showModify,, /  post()에서는 doWrite()......		
		//getmapping의 기능을 비슷하게 만들어준 것이다.
		switch(uriProcessor.getRequestUri()) {
			
		case "/qna/questions/add":
			showWriter(appReq);
			break;
		
		}
		
	}

	@Override
	public void postMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		switch( uriProcessor.getRequestUri() ) {
		
			case "/qna/questions/add":
				doWrite(appReq);
				break;
		}
		
	}

	
	// --> 
	//alt shif s -> override methode
	
	
	public void showWrite(AppRequest appRequest) {
		appRequest.forwardToJsp("usr/question/add");
		
	}
	
	
	

}

//controller를 서블릿으로 만드는게 아니라 자바클래스로 상솟 받아 만들어 준다
