package com.example.springboots.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.springboots.dao.utore", sqlSessionFactoryRef = "utoreSqlSessionFactory")
public class UtoreDataSourceConfig {
    @Bean(name = "utoreDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.utore")
    public DataSource getUtoreDateSource() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "utoreSqlSessionFactory")
    public SqlSessionFactory utoreSqlSessionFactory(@Qualifier("utoreDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/utore/*.xml"));
        return bean.getObject();
    }
    @Bean("utoreSqlSessionTemplate")
    public SqlSessionTemplate utoreSqlSessionTemplate(
            @Qualifier("utoreSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

    /******配置事务管理********/

    @Bean
    public DataSourceTransactionManager utoreTransactionManager(@Qualifier("utoreDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}

