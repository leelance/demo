package com.lance.dev.hibernate.ext;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Tan Liang (Bred Tan)
 * @since 2014/12/19
 */
public class TenantIdResolver implements CurrentTenantIdentifierResolver {
    private static Logger logger = LoggerFactory.getLogger(TenantIdResolver.class);

    /**
     * Resolve the current tenant identifier.
     *
     * @return The current tenant identifier
     */
    @Override
    public String resolveCurrentTenantIdentifier() {
        //return MultiTenancyApp.TenantIdentifier;
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
        return false;
    }
}
