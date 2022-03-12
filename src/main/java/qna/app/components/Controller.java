package qna.app.components;

import qna.app.util.AppRequest;
import qna.app.util.UriProcessor;

public interface Controller extends Component{
	//메서드를 찾아서 들어가는 과정/ 들어온 요청을 필요한 곳에 전달해주는 역할

	public void getMapping(AppRequest appReq, UriProcessor uriProcessor);
	public void postMapping(AppRequest appReq, UriProcessor uriProcessor);
	
}

