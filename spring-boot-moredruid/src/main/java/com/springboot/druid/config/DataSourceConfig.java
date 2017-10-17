package com.springboot.druid.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {


    private final static String WRITE_DATASOURCE_KEY = "masterDataSource";
    private final static String READ1_DATASOURCE_KEY = "clusterDataSource";
//    private final static String READ2_DATASOURCE_KEY = "read2DataSource";

    @Bean
    public AbstractRoutingDataSource routingDataSource(
            @Qualifier("masterDataSource") DataSource masterDataSource,
            @Qualifier("clusterDataSource") DataSource  cluster1DataSource) {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(WRITE_DATASOURCE_KEY, masterDataSource);
        targetDataSources.put(READ1_DATASOURCE_KEY, cluster1DataSource);
//        targetDataSources.put(READ2_DATASOURCE_KEY, read2DataSource);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(masterDataSource);
        return dataSource;
    }
}
