package qna.web.repository;

import qna.app.components.Repository;
import qna.app.container.AppContainer;
import qna.app.dao.QuestionDao;

//implements로 불러와준다
public class QuestionRepository implements Repository {
	
	private QuestionDao questionDao;

	@Override
	public void autoWried() {
		questionDao = AppContainer.questionDao;
		
	}

}
