package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.stereotype.Component;

@Component
public class TenantFilterRegistration extends FilterRegistrationBean<TenantFilter> {

    public TenantFilterRegistration(TenantContext tenantContext) {
        this.setFilter(new TenantFilter(tenantContext));
    }
}
