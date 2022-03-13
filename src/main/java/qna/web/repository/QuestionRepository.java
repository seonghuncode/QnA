package qna.web.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import qna.app.components.Repository;
import qna.app.configuration.SessionFactory;
import qna.app.dao.QuestionDao;
import qna.web.vo.Question;

//implements로 불러와준다
public class QuestionRepository implements Repository {
	
	private SqlSession session;
	
	private QuestionDao questionDao;

	@Override
	public void autoWried() {
		this.session = SessionFactory.getSession(); 
		this.questionDao = session.getMapper(QuestionDao.class);
		
	}

	public void save(String title, String body) {
		Question question = new Question(title, body);
		
		questionDao.save(question);
		
		session.commit(); //DB의 어떤한 데이터 조작이 일어날때 얺어준다.
		
	}

	public List<Question> findAll() {
		return questionDao.findAll();
	}

	public Question findById(int id) {
		return questionDao.findById(id);
	}
	public void modify(Question question) {
		questionDao.modify(question);
		session.commit();
	}

}
