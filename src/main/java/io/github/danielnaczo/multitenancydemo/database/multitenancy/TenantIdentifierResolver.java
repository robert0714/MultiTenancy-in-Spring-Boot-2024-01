package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    private final String dbDefault;
//    private final HashMap<String, String> tenantMap;
    private static final ThreadLocal<String> currentTenant = new ThreadLocal();

    @Autowired
    public TenantIdentifierResolver() {
        this.dbDefault = "shared";
//        this.tenantMap = new HashMap();
    }

    public void setTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public void setTenantToDefault() {
        currentTenant.set(this.dbDefault);
    }

//    public HashMap<String, String> getTenantMap() {
//        return tenantMap;
//    }
//
//    public void addTenant(String country, String tenant) {
//        this.tenantMap.put(country, tenant);
//    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        if (currentTenant.get() != null) {
            return currentTenant.get();
        }
        throw new RuntimeException("Current tenant not set");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
}
