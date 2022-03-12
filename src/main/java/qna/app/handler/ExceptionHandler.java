package qna.app.handler;

import qna.app.util.AppRequest;

//ctrl + 1 --> add 불러와준다
public class ExceptionHandler implements Handler {

	@Override
	public void handlerRequest(AppRequest appRequest) {
		appRequest.forwardToJsp("error/error");
		
	}
//오류가 생겼을때 이 페이지를 보여준다
	
	
}
