package com.lance.dev.hibernate.ext;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 * @since 2014/12/19
 */
public class TenantIdResolver implements CurrentTenantIdentifierResolver {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * Resolve the current tenant identifier.
     *
     * @return The current tenant identifier
     */
    @Override
    public String resolveCurrentTenantIdentifier() {
        if(StringUtils.isNotBlank(threadLocal.get())) {
            return threadLocal.get();
        }
        return null;
    }

    /**
     * Should we validate that the tenant identifier on "current sessions" that already exist when
     * {@link org.hibernate.context.spi.CurrentSessionContext#currentSession()} is called matches the value returned here from
     * {@link #resolveCurrentTenantIdentifier()}?
     *
     * @return {@code true} indicates that the extra validation will be performed; {@code false} indicates it will not.
     * @see org.hibernate.context.TenantIdentifierMismatchException
     */
    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

    public void setTenant(String tenant) {
        threadLocal.set(tenant);
    }
}
