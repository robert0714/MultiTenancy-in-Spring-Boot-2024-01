package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Component
public class MultiTenantConnectionProviderImpl implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {

    private final MultiTenantRoutingDatasource multiTenantRoutingDatasource;

    @Autowired
    public MultiTenantConnectionProviderImpl(MultiTenantRoutingDatasource multiTenantRoutingDatasource) {
        this.multiTenantRoutingDatasource = multiTenantRoutingDatasource;
    }

    @Override
    public Connection getAnyConnection() throws SQLException {
        return multiTenantRoutingDatasource.getConnection();
    }

    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Connection getConnection(String connectionDetails) throws SQLException {
        String tenantIdentifier = connectionDetails.split(":")[0];
        Connection connection;
        if (tenantIdentifier.equals(MultiTenancyKeys.DEFAULT_DB_NAME)) {
            connection = this.multiTenantRoutingDatasource.getResolvedDefaultDataSource().getConnection();
        } else {
            connection = this.multiTenantRoutingDatasource.getResolvedDataSources().get(tenantIdentifier).getConnection();
        }
        return connection;
    }

    @Override
    public void releaseConnection(String s, Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public boolean supportsAggressiveRelease() {
        return false;
    }

    @Override
    public boolean isUnwrappableAs(Class<?> aClass) {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) {
        return null;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, this);
    }
}
