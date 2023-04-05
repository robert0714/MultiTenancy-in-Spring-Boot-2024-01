package io.github.danielnaczo.multitenancydemo.database.multitenancy;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TenantFilter extends OncePerRequestFilter {

    private static final String TENANT_HEADER_NAME = "X-Tenant-Id";

    private final TenantContext tenantContext;

    public TenantFilter(TenantContext tenantContext) {
        this.tenantContext = tenantContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String tenant = request.getHeader(TENANT_HEADER_NAME);
        tenantContext.setTenant(tenant);
        filterChain.doFilter(request, response);
    }
}
