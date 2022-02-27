package qna.dao;

import qna.vo.Question;

//자바 인터페이스로 만들어 준다
public interface QuestionDao {

	void save(Question question);
	
}
