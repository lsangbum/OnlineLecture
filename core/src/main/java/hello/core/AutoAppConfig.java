package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Configuration 이 붙은 AppConfig 라는 객체가 존재하기에 ComponentScan 이 스캔을 할때 예외시킬 클래스에 Filter 를 적용해둔다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {



}//class
