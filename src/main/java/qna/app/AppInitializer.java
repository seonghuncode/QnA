package qna.app;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import qna.app.container.AppContainer;

@WebListener
public class AppInitializer implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		AppContainer.componentAssemble(); //서버가 실행될때 딱 한번만 돌아서 콘데이너에서 컴포넌트들이 서로 알기 위해서 어셈블을 실행
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	
	}
	//==?
	//alt + shifit + s ==> implements 오버라이드 -> 클릭 (implements두개 클릭 -> ok)
	
	
}
