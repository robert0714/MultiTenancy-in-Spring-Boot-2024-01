package io.github.danielnaczo.multitenancydemo.database.multitenancy.aspect;

import io.github.danielnaczo.multitenancydemo.database.multitenancy.TenantIdentifierResolver;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResolveTenantAspect {

    private final TenantIdentifierResolver tenantIdentifierResolver;

    public ResolveTenantAspect(TenantIdentifierResolver tenantIdentifierResolver) {
        this.tenantIdentifierResolver = tenantIdentifierResolver;
    }

    @Before("execution(* io.github.danielnaczo.multitenancydemo.database.service.tenant.*.*(..))")
    public void resolveTenant() {
        //TODO implement
    }
}
