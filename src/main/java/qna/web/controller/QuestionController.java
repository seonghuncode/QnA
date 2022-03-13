package qna.web.controller;

import java.util.List;

import qna.app.components.Controller;
import qna.app.container.AppContainer;
import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;
import qna.web.service.QuestionService;
import qna.web.vo.Question;

public class QuestionController implements Controller {
	
	private QuestionService questionService;

	@Override
	public void autoWried() {
		
		questionService = AppContainer.questionService;  //서비스 연결
		
	}

	@Override
	public void getMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		
		switch(uriProcessor.getRequestUri()) {
			
		//get() 에서는 showWrite(), showModify,, /  post()에서는 doWrite()......		
		//getmapping의 기능을 비슷하게 만들어준 것이다.
		
			
		case "/qna/questions/add":
			showWriter(appReq);
			break;
			
		case"/qna/questions":
			showList(appReq);
			break;
		
	
		
		}
		
	}

	@Override
	public void postMapping(AppRequest appReq, UriProcessor uriProcessor) {
		
		
		
		switch(uriProcessor.getRequestUri()) {
			
			case "/qna/questions/add":
				doWrite(appReq);
				break;
			
		}
		
	}	
		
	

	public void showList(AppRequest appRequest) {
		
		List<Question> questions = questionService.findAll();
		
		appRequest.addAttribute("questions", questions); //html에서 쓸 이름 -> "question"/ qustion에 담아준다?
		appRequest.render("usr/question/list");
	}
	
	// --> 
	//alt shif s -> override methode
	
	
	public void showWriter(AppRequest appRequest) {
		appRequest.render("usr/question/add"); //주소에 redirect가 있으면 그걸짜르고 받아서 보여준다????
		
	}
	
	
	
	
	public void doWrite(AppRequest appRequest) {
		
		questionService.save(
				appRequest.getAttribute("title", String.class),
				appRequest.getAttribute("body", String.class)
				); //html에서 받은 title, body값을 꺼내준다
		
		appRequest.render("redirect:/"); //redirect가 있으면 자르고 1번에 있는 주소로 redirect를 보내줘라
		
	}
	
	
	

}

//controller를 서블릿으로 만드는게 아니라 자바클래스로 상솟 받아 만들어 준다
