package qna.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestFactory {
	
	private HttpServletRequest req; // -->req로 줄인다
	private HttpServletResponse resp;
	
	//생서아를 만들어 준다
	public RequestFactory(HttpServletRequest req, HttpServletResponse resp) {
		
		//req.setCharacterEncoding("UTF-8"); --> ctrl + 1 --> catch클릭 하면 아래처럼 나온다
		try {
			req.setCharacterEncoding("UTF-8"); // == 들어오는 문자열을 utf-8로 인코딩 해줘라
		} catch (UnsupportedEncodingException e) { //오류가 뜨게 되면
			// TODO Auto-generated catch block
			e.printStackTrace(); //왜 잘못 되었는지 알려줘라(타입이 잘못 되었는지....)
		} 
		
		resp.setCharacterEncoding("UTF-8"); //요청이 욌을때 응답도 utf-8로 해줘라
		resp.setContentType("text/html; charset=UTF-8");//text는 html이고 utf-8이라를 알려 준다
		
		this.req = req;
		this.resp = resp;
		
		
	}
	
	
	//jsp로 보내주는 로직
	public void forwardToJsp(String path) {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF" + path + ".jsp");
		// -->path만 입력해주면 이동하게 만들어 준다 자동으로
		
		
		//requestDispatcher.forward(req, resp); -> ctrl + 1 -> try, catch사용
		try {
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HttpServletRequest getReq() {
		return this.req;
	}
	
	public HttpServletResponse getResp() {
		return this.resp;
	}
	
	
	
	
	
}
