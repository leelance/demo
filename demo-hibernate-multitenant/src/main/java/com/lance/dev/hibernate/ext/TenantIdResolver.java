package com.lance.dev.hibernate.ext;

import com.lance.dev.hibernate.common.ContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

/**
 * @since 2014/12/19
 */
public class TenantIdResolver implements CurrentTenantIdentifierResolver {
    private static Logger logger = LogManager.getLogger(TenantIdResolver.class);
    public final String DEFAULT_SCHEMA = "qhdevelop18";

    /**
     * Resolve the current tenant identifier.
     *
     * @return The current tenant identifier
     */
    @Override
    public String resolveCurrentTenantIdentifier() {
        logger.debug("----------resolveCurrentTenantIdentifier----------{}", ContextHolder.getContext());
        if(StringUtils.isNotBlank(ContextHolder.getContext())) {
            return ContextHolder.getContext();
        }

        return DEFAULT_SCHEMA;
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
        logger.debug("----------validateExistingCurrentSessions----------{}");
        return true;
    }
}
