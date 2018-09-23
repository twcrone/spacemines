package com.example.spacemines;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayTestConfig {

    @Bean
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        return (Flyway flyway) -> {
                flyway.clean();
                flyway.migrate();
        };
    }

}
