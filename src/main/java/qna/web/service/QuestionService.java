package qna.web.service;

import org.apache.ibatis.session.SqlSession;

import qna.app.components.Service;
import qna.app.configuration.SessionFactory;
import qna.app.dao.QuestionDao;
import qna.web.vo.Question;

//MVC패턴의 m(model)에 해당하는 역할 (sercice는 dao랑만 얘기한다??)
public class QuestionService implements Service {
	
	private QuestionDao questionDao; //(sercice는 dao랑만 얘기한다??) --> 불러와 준다.
	private SqlSession sqlSession;
	
	//생성자를 만든다
	public QuestionService() {
		
		SqlSession session = SessionFactory.getSession(); //SessionFactory에서 get을 사용하면 호출을 하면서 세션이 열린다??
		questionDao = session.getMapper(QuestionDao.class); //Dao class를 다 가지고 온다??	
		
		this.sqlSession = session; //받아주어야 한다.
	}
	
	public void save(String title, String body) {
		
		Question question = new Question(title, body); // 여기에 title, body를 넣어준다. Question 클래스에 들어가서 비교하면서 이해
		//그럼 Question에서 현재시간... 같이 들어간다
		questionDao.save(question); //questionDao여기로 넘긴다
		
		sqlSession.commit(); //
		
	}
//

	// QuestionService > ctrl + 1 > add.....
	@Override
	public void autoWried() {
		// TODO Auto-generated method stub
		
	}
}
