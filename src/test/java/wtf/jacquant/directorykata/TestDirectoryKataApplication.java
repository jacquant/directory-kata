package wtf.jacquant.directorykata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestDirectoryKataApplication {

    public static void main(String[] args) {
        SpringApplication.from(DirectoryKataApplication::main).with(TestDirectoryKataApplication.class).run(args);
    }

}
