package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static io.github.danielnaczo.multitenancydemo.database.multitenancy.MultiTenancyKeys.*;

@Component
public class MultiTenantRoutingDatasource extends AbstractRoutingDataSource {

    private final TenantIdentifierResolver tenantIdentifierResolver;

    @Autowired
    public MultiTenantRoutingDatasource(TenantIdentifierResolver tenantIdentifierResolver) {
        this.tenantIdentifierResolver = tenantIdentifierResolver;
        createDefaultDatabase();
        createTenantDatabases();
        this.afterPropertiesSet();
    }

    private void createDefaultDatabase() {
        String defaultDBUrl = urlPrefix + defaultDBName;
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
                .driverClassName(driverClassName)
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
