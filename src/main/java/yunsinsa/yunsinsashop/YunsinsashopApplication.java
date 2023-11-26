package yunsinsa.yunsinsashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
어노테이션 순서는 크게 상관은 없지만,
중요한 어노테이션을 가장 클래스명과 밀접하게,
전역적으로 추가할 어노테이션들을 여기다가 추가
 */
@SpringBootApplication
public class YunsinsashopApplication {

	public static void main(String[] args) {
		SpringApplication.run(YunsinsashopApplication.class, args);
	}

}
