package wtf.jacquant.directorykata.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "wtf.jacquant.directorykata.repositories")
@EnableTransactionManagement
public class JpaConfig {
}
