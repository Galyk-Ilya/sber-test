package ru.galuk.sbertest.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@TestConfiguration
public class TestJdbcConfig {

    @Bean
    public EmbeddedDatabase dataSourceTest() {
        return new EmbeddedDatabaseBuilder(new FileSystemResourceLoader())
            .setScriptEncoding("UTF-8")
            .setType(EmbeddedDatabaseType.H2)
            .addScripts(
                "src/test/resources/sql/create-table.sql",
                "src/test/resources/sql/insert-data.sql"
            )
            .build();
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplateTest(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
