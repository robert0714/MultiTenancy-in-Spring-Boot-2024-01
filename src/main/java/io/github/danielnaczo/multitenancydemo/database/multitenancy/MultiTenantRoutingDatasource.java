package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class MultiTenantRoutingDatasource extends AbstractRoutingDataSource {

    private final TenantIdentifierResolver tenantIdentifierResolver;

    private static final String urlPrefix = "jdbc:postgresql://localhost:5432/";
    private static final String username = "postgres";
    private static final String password = "";

    @Autowired
    public MultiTenantRoutingDatasource(TenantIdentifierResolver tenantIdentifierResolver) {
        this.tenantIdentifierResolver = tenantIdentifierResolver;
        createDefaultDatabase();
        createTenantDatabases();
        this.afterPropertiesSet();
    }

    private void createDefaultDatabase() {
        String defaultDBUrl = urlPrefix + "shared";
        setDefaultTargetDataSource(createDatasource(defaultDBUrl, username, password));
    }

    private void createTenantDatabases() {
        Map<Object, Object> targetDataSources = new HashMap();
        createTenantDatabase("germany", targetDataSources);
        createTenantDatabase("spain", targetDataSources);
        this.setTargetDataSources(targetDataSources);
    }

    private void createTenantDatabase(String databaseName, Map<Object, Object> targetDataSources) {
        DataSource dataSource = createDatasource(urlPrefix + databaseName, username, password);
        targetDataSources.put(databaseName, dataSource);
    }

    private DataSource createDatasource(String url, String username, String password) {
        return DataSourceBuilder
                .create()
                .driverClassName("org.hibernate.dialect.PostgreSQLDialect")
                .url(url)
                .username(username)
                .password(password)
                .build();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return this.tenantIdentifierResolver.resolveCurrentTenantIdentifier();
    }

}
