package qna.app.util;

public class UriProcessor {
//uri를 받아서 나누어 준다
							// question/add, question/modify, question/delete(question은 변동이 없다)
	private String uri; // 이렇게 만들어 지기를 원하낟 -> /[controller uri code]/[행위에 대한것]/[그 정보에 대한 id]
private String splitedUri;
													// == /[question]/[delete]/[id]
													//이런 단위로 쪼개는 작업을 해준다
	//class가 생성될때 외부에서 받아주기 위해 생성자를 만들어 준다
	public UriProcessor(String uri) {
		this.uri = uri;
	}
	
	public String getControllerCode() {
		//위의 첫번째로 나누는 controller uri code를 가지고 와서 -> 해당 처리 과정으로 가게 나누어 주는??작업??
		
		//예외처리를 해준다 /를 적는 사람도 있고 안쓰는 사람도 있기 때문에 그러한 것을 위한
		
		try {
			
//			uri.split("/"); -> local varible
			String[] splitedUri = uri.split("/"); // /로 쪼개주는 역할을 한다
			
//			splitedUri[1];      /[]/[]/[]
			String controllerCode = splitedUri[1]; // 배열은 0부터 시작인데 /게 공백으로 들어가기 때문에 0번을 가지고 가기때문에
			
			switch(controllerCode) {
				case "question":
					return controllerCode; //question이 아니고 없는것을 입력 또는 /나눌수 없을때 exception이 잡아주게 된다.
				default:
					throw new IllegalArgumentException("올바른 요청이 아닙니다.");
			}
			
		}catch(Exception e) { //어떤 에러가 났을때 아래처럼 나오게 해라
			throw new IllegalArgumentException("올바른 요청이 아닙니다.");
		}
		
		
	}

	
	
	public String getProcessCode() {
		//커트롤러에서 수행할 코드를 리턴해주는 역할
		
		try {
		
			//uri.split("/");
			String[] splitedUri = uri.split("/");  // /로 쪼개주는 역할
			
			//위에서의 나눈 것들중 2번을 뽑아는 과정을 만드는 코드
//			splitedUri[2];  -> ctrl + 1 
			String processCode = splitedUri[2]; 
			
			return processCode;
			
			
		}catch(Exception e) {
			
			throw new IllegalArgumentException("올바른 요청이 아닙니다.");
		
		}
		
	}
	
	
	
}
