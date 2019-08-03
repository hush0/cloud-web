package com.hush.cloudweb.config;

import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.SettingsTools;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

/**
 * @Author: huangshuai
 * @Date: 2019-08-02
 * @Version 1.0
 */

@Configuration
@EnableJdbcRepositories
@Import(JdbcConfiguration.class)
public class JooqConfig {


    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    DefaultDSLContext dsl() {
        return new DefaultDSLContext(configuration());
    }

    public DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider());
        jooqConfiguration.setSQLDialect(SQLDialect.MYSQL_5_7);
        jooqConfiguration.setSettings(SettingsTools.defaultSettings()
                .withRenderSchema(false)
                .withRenderNameStyle(RenderNameStyle.LOWER));
        return jooqConfiguration;
    }
}
