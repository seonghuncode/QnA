package qna.app.dao;

import qna.web.vo.Question;


//app으로 이동시켜 준다
//자바 인터페이스로 만들어 준다
public interface QuestionDao {

	void save(Question question);
	//
}
