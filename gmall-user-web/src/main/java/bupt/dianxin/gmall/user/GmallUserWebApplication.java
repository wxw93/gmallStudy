package bupt.dianxin.gmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**服务端口号：server.port=8060
* */
@SpringBootApplication
@MapperScan("bupt.dianxin.gmall.user.mapper")
public class GmallUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserWebApplication.class, args);
    }
}
