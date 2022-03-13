package qna.web.service;

import java.util.List;
import java.util.NoSuchElementException;

import qna.app.components.Service;
import qna.app.container.AppContainer;
import qna.web.repository.QuestionRepository;
import qna.web.vo.Question;

//MVC패턴의 m(model)에 해당하는 역할 (sercice는 dao랑만 얘기한다??)
public class QuestionService implements Service {
	
	
	private QuestionRepository questionRepository;
	
	
	// QuestionService > ctrl + 1 > add.....
		@Override
		public void autoWried() {
			// TODO Auto-generated method stub
			this.questionRepository = AppContainer.questionRepository;
		}
	
	
	
	
	
	
	public void save(String title, String body) {
		
		questionRepository.save(title, body);  //받아온 title,body를 여기에 넘겨준다.
		
	}
//






	public List<Question> findAll() {
		return questionRepository.findAll();
	}






	public Question findById(int id) {
		Question findById = questionRepository.findById(id);
		
		if(findById != null) {
			return findById;
		}else {
			throw new NoSuchElementException("해당 질문은 존재 하지 않습니다.");
		}
	}


	public void modify(Question question) {
		
		questionRepository.modify(question);
		
	}

	
}
