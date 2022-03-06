package qna.app.components;

public interface Component {
	//인터페이스 --> 이 component의 역할은 부품이라고 생각
	//component : (controller,service,repository 모두 components한테 상속을 시켜준다)
	
	//부품들을 연결하기 위해서 메서드 이름만 만들어 놓았다.(연결때문에 만들어 준것이다.)
	public void autoWried();
	
}
