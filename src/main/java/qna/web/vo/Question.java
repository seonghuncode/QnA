package qna.web.vo;

import java.time.LocalDateTime;

//vo의 역할을 하게 된다.
public class Question {
	
	private int id; //번호를 넣어준다 항상 들어올 수 있도록?? //autoincremaent로 자동으로 증가되게 해준다(db에서)
	
	private String title;
	private String body;
	
	private LocalDateTime regDate;
	private LocalDateTime updateDate;
	
	//생성자를 만들어 준다
	public Question(String title, String body) {
		
		this.title = title;
		this.body = body; 	//받아온 후 위에(title, body) 넣어주기 위한 코드
		
		regDate = LocalDateTime.now();
		updateDate = LocalDateTime.now();
		
	}
	//
	

}
