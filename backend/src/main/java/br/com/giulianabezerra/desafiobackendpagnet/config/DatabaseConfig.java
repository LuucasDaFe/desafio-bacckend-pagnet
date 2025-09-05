package br.com.giulianabezerra.desafiobackendpagnet.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    @Primary
    public DataSource dataSource() {
        Properties dsProps = new Properties();
        dsProps.setProperty("url", dbUrl);
        dsProps.setProperty("user", username);
        dsProps.setProperty("password", password);
        
        // Configurações de SSL
        dsProps.setProperty("ssl", "true");
        dsProps.setProperty("sslmode", "require");
        dsProps.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        
        // Outras propriedades de conexão
        dsProps.setProperty("prepareThreshold", "0");
        dsProps.setProperty("preparedStatementCacheQueries", "0");
        dsProps.setProperty("preparedStatementCacheSizeMiB", "0");
        
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        config.setDataSourceProperties(dsProps);
        
        // Configurações do pool de conexões
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        config.setAutoCommit(true);
        config.setConnectionTestQuery("SELECT 1");
        config.setLeakDetectionThreshold(2000);
        
        return new HikariDataSource(config);
    }
}
