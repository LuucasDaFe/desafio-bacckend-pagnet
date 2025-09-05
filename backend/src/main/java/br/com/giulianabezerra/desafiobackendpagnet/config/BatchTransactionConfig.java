package br.com.giulianabezerra.desafiobackendpagnet.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableBatchProcessing
@EnableAutoConfiguration(exclude = {
    BatchAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
public class BatchTransactionConfig {
    // Configuração para desativar o gerenciamento automático de transações do Spring Batch
}
