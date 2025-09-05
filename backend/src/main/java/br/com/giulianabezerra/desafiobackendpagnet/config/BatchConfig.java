package br.com.giulianabezerra.desafiobackendpagnet.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableBatchProcessing
@EnableTransactionManagement
public class BatchConfig {
    // Esta classe está vazia, pois estamos apenas usando as anotações
    // para configurar o Spring Batch
}
