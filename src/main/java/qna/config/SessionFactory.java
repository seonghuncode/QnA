package qna.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	
	static SqlSessionFactory sqlSessionFactory = null; // 필드(정적필드) 일반적으로 선언하고 동시에 초기값을 준다
	
	//아래는 실제값을 초기화 해서 넣어주는 것이다/ sqlSessionFactory값을 재할당
	static { // -> static을 초기화 시켜준 것이다(static SqlSessionFactory sqlSessionFactory = null; --> 초기화 시키는 과정)
		
		String path = "myBatisConfig.xml";//이걸 사용하는 이유는 mybatis에서 필요하다고 한거기 때문에 약속이다
		InputStream inputStream = null; 
		//inputstream = String path를 주소이름만 알려준 상황인데 inpustram안에 소스가 있어서 "myBatisConfig.xml이 파일을 자바가 읽을 수 있도록
		//STring으로 변환해주는 역할
		
//		inputStream = Resources.getResourceAsStream(path); // Ctrl + 1 -> try cath
		try {
			inputStream = Resources.getResourceAsStream(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// -> sqlSessionFactory만들기 위해서는 builder가 필요하고 필요한 재료는 inputStream이다
		
		
	}
	
	public static SqlSession getSession() {
		
		//SqlSession openSession = sqlSessionFactory.openSession(); //ctrl + 1 변수로 만들어 준다(위의 sqlSessionFactory를 가지고 와서)
		SqlSession	session = sqlSessionFactory.openSession(); // -> Session이 열리도록 해준다.
		
		return session; //필요할때 사용할수있도록 return
		
	}
	
	
}
