package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import java.util.Map;

import static io.github.danielnaczo.multitenancydemo.database.multitenancy.MultiTenancyKeys.defaultDBName;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    private static final ThreadLocal<String> currentTenant = new ThreadLocal();

    public void setTenant(String tenant) {
        currentTenant.set(tenant);
    }

    public void setTenantToDefault() {
        currentTenant.set(defaultDBName);
    }

    @Override
    public String resolveCurrentTenantIdentifier() {
        if (currentTenant.get() != null) {
            return currentTenant.get();
        }
        return defaultDBName;
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
