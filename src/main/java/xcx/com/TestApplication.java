package xcx.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;


@SpringBootApplication(scanBasePackages = "xcx.com")
@MapperScan("xcx.com.dao")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

    }

}
