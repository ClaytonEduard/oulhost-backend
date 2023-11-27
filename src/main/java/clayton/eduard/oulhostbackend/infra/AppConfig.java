package clayton.eduard.oulhostbackend.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    // * toda vez que a aplicação for inciada irá chamar essa funcao
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
