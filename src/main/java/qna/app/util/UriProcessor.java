package qna.app.util;

import lombok.Getter;

@Getter
public class UriProcessor {
//uri를 받아서 나누어 준다
							// question/add, question/modify, question/delete(question은 변동이 없다)
	private String requestUri; // 이렇게 만들어 지기를 원하낟 -> /[controller uri code]/[행위에 대한것]/[그 정보에 대한 id]
	
	private boolean isIndex = false; //요청을 나누어준다?
	
	private boolean isValid = false; //url이 유효한지 안한지 판단할때
	
	private String ControllerCode = ""; //question 인지 answer인지 그것이 들어간다
	
	private int targetIndex = 0; //수정, 삭제할때 번호를 뽑아준다.
	
	//생성자
	public UriProcessor(String requestUri) { //이클래스가 생성될때 requestUri를 받아 넣어주고
		
		this.requestUri = requestUri;
		
		if(requestUri.equals("/qna/") || requestUri.equals("/qna")) { 
		//서비스를 들어왔을때 무전건 qna를 붙이는데 사람이 입력하는 두가지 경우를 생각해서 만들어 준다.
			this.isIndex = true;
			this.isValid = true; //이렇게 되면 true값을 주어라
		}
		
		//쪼개주는 코드 부분
//		requestUri.split("/"); //ctrl + 1
		String[] splitUri = requestUri.split("/"); 
		//ex) 위에서 들어온 요청이 / 로 쪼개어 진다 --> localhost8080//qna/questions/add
		//String[] --ex)쪼개면--> /qna/questions/1 --> 공백, qna, questions , 1 -> 0,1,2,3 ==> 4개가 나온다.
		
		//쪼개진거에 대한 갯수 가 다르다
		if(splitUri.length >= 3) {
			switch(splitUri[2]) { //필요한 값이 두번째 이기때문에
				case "questions":
				case "question": //사용자가 s를 빼먹는 실수를 해도 가능하도록 하나더 만들어 준다.
					this.ControllerCode = "question";
					this.isValid = true;
					break;	
			//question anser의 두경우로 만들어 준다.
				case "answers":
				case "answer":
					this.ControllerCode = "answers";
					this.isValid = true;
					break;
				default:
					this.ControllerCode = "";
					break;
			
			}
		}
		
		if(splitUri.length == 4) { //이숫자가 왔을때 3을 넣어준다??
			
			try {
			
			this.targetIndex = Integer.parseInt(splitUri[3]); //url은 String -> 형변환
			this.isValid = true;
			
			}catch(Exception e) {
				this.targetIndex = 0;
			}
		}else if(splitUri.length >= 5) { ////5개가 나오는 경우	
			
			try {
				this.targetIndex = Integer.parseInt(splitUri[4]);
				this.isValid = true;
			
			}catch(Exception e) {
				this.targetIndex = 0;
				this.isValid = false;
			}
		
		}
			
		
	}
		
	
	
}
