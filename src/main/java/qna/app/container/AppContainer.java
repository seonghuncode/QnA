package qna.app.container;

import java.util.ArrayList;
import java.util.List;

import qna.app.components.Component;
import qna.app.configuration.SessionFactory;
import qna.app.dao.QuestionDao;
import qna.web.controller.QuestionController;
import qna.web.service.QuestionService;

public class AppContainer {
	//class로 만들어 준다 container의 기능 -> components들이 잘 연결되도록 도와주는 역할??
	//부품들 components들이 다 모여서 조립이 되는 과정
	
	private static List<Component> componentContainer; //comonents를 List로 가지고 오는 작업
	
	public static QuestionDao questionDao; //QuestionDAo를 가지고 온다
	
	public static QuestionController questionController;
	public static QuestionService questionservice;
	
	public static void componentAssemble() {
		//component들을 조림하는 역할
		
		componentContainer = new ArrayList<>();
		
		questionDao = SessionFactory.getSession().getMapper(QuestionDao.class);
		
		questionController = addComponent(new QuestionController());
		
	}
	
	//addComponent를 만들어 준다 //여기에 너어줌과 동시에 questionController에도 들어간다
	private static <T> T addComponent(Component component) {
		
		componentContainer.add(component);
		
		return (T) component;
		
	}
	
}
