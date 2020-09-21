package br.com.vizir.falemais;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.vizir.falemais.service.MinutoExcedentePlano;
import br.com.vizir.falemais.service.impl.MinutoExcedentePlanoImpl;

@Configuration
//@ComponentScan(basePackages = "com.test")
//@EnableJpaRepositories(basePackages = "com.test.repository")
public class AppConfig {
	
//	@Value("${app.url}")
//    private String url;
//    @Value("${app.username}")
//    private String username;
//    @Value("${app.password}")
//    private String password;
	
	@Bean
    public MinutoExcedentePlano minutoExcedentePlano() {
        return new MinutoExcedentePlanoImpl();
    }
	
//	@Bean
//	public DataSource dataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setUrl(url);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		return dataSource;
//	}
}
