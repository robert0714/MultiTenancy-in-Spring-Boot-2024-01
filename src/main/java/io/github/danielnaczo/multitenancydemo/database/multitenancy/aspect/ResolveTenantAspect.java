package io.github.danielnaczo.multitenancydemo.database.multitenancy.aspect;

import io.github.danielnaczo.multitenancydemo.database.multitenancy.TenantContext;
import io.github.danielnaczo.multitenancydemo.database.multitenancy.TenantIdentifierResolver;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(20)
public class ResolveTenantAspect {

    private final TenantIdentifierResolver tenantIdentifierResolver;
    private final TenantContext tenantContext;

    public ResolveTenantAspect(TenantIdentifierResolver tenantIdentifierResolver, TenantContext tenantContext) {
        this.tenantIdentifierResolver = tenantIdentifierResolver;
        this.tenantContext = tenantContext;
    }

    @Before("execution(* io.github.danielnaczo.multitenancydemo.database.service.tenant.*.*(..))")
    public void resolveTenant() {
        this.tenantIdentifierResolver.setTenant(tenantContext.getTenant());
    }

    @Before("@annotation(io.github.danielnaczo.multitenancydemo.database.multitenancy.aspect.annotation.SetTenantForTransaction)")
    public void resolveTenantBeforeTransaction() {
        this.tenantIdentifierResolver.setTenant(tenantContext.getTenant());
    }
}
