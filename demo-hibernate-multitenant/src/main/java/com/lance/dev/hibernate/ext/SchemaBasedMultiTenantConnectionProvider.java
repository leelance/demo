package com.lance.dev.hibernate.ext;

import com.alibaba.druid.pool.DruidDataSource;
import com.lance.dev.hibernate.common.ApplicationContextUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.service.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Tan Liang (Bred Tan)
 * @since 2014/12/19
 */
@Component
@Lazy
public class SchemaBasedMultiTenantConnectionProvider implements MultiTenantConnectionProvider {
    private static Logger logger = LogManager.getLogger();
    private final String DEFAULT_SCHEMA = "qhdevelop18";

    //    private final DriverManagerConnectionProviderImpl connectionProvider = new DriverManagerConnectionProviderImpl();
    private DruidDataSource druidDataSource;

    public SchemaBasedMultiTenantConnectionProvider() {
        druidDataSource = (DruidDataSource) ApplicationContextUtils.getBean("dataSource");
    }

//    ConnectionProvider cp =
//    private final DriverManagerConnectionProviderImpl connectionProvider = ConnectionProviderUtils.buildConnectionProvider("master");

    /**
     * Allows access to the database metadata of the underlying database(s) in situations where we do not have a
     * tenant id (like startup processing, for example).
     *
     * @return The database metadata.
     * @throws java.sql.SQLException Indicates a problem opening a connection
     */
    @Override
    public Connection getAnyConnection() throws SQLException {
        logger.debug("-----getAnyConnection--------{}");
        return druidDataSource.getConnection();

//            return entityManager.unwrap(Connection.class);
//            final Connection connection = connectionProvider.getConnection();
//            return connection;
    }

    /**
     * Release a connection obtained from {@link #getAnyConnection}
     *
     * @param connection The JDBC connection to release
     * @throws java.sql.SQLException Indicates a problem closing the connection
     */
    @Override
    public void releaseAnyConnection(Connection connection) throws SQLException {
        logger.debug("-----releaseAnyConnection--------{}");
        connection.createStatement().execute(String.format("USE %s", DEFAULT_SCHEMA));
        connection.close();
//            entityManager.unwrap(Connection.class).close();
    }

    /**
     * Obtains a connection for Hibernate use according to the underlying strategy of this provider.
     *
     * @param tenantIdentifier The identifier of the tenant for which to get a connection
     * @return The obtained JDBC connection
     * @throws java.sql.SQLException            Indicates a problem opening a connection
     * @throws org.hibernate.HibernateException Indicates a problem otherwise obtaining a connection.
     */
    @Override
    public Connection getConnection(String tenantIdentifier) throws SQLException {
        logger.debug("-----getConnection tenantIdentifier--------{}", tenantIdentifier);
        final Connection connection = druidDataSource.getConnection();
        connection.createStatement().execute(String.format("USE %s", tenantIdentifier));

        return connection;
//            return null;
    }

    /**
     * Release a connection from Hibernate use.
     *
     * @param tenantIdentifier The identifier of the tenant.
     * @param connection       The JDBC connection to release
     * @throws java.sql.SQLException            Indicates a problem closing the connection
     * @throws org.hibernate.HibernateException Indicates a problem otherwise releasing a connection.
     */
    @Override
    public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
        logger.debug("-----releaseConnection--------{}");
        connection.createStatement().execute(String.format("USE %s", DEFAULT_SCHEMA));
//            entityManager.unwrap(Connection.class).close();
    }

    /**
     * Does this connection provider support aggressive release of JDBC
     * connections and re-acquisition of those connections (if need be) later?
     * <p/>
     * This is used in conjunction with {@link org.hibernate.cfg.Environment#RELEASE_CONNECTIONS}
     * to aggressively release JDBC connections.  However, the configured ConnectionProvider
     * must support re-acquisition of the same underlying connection for that semantic to work.
     * <p/>
     * Typically, this is only true in managed environments where a container
     * tracks connections by transaction or thread.
     * <p/>
     * Note that JTA semantic depends on the fact that the underlying connection provider does
     * support aggressive release.
     *
     * @return {@code true} if aggressive releasing is supported; {@code false} otherwise.
     */
    @Override
    public boolean supportsAggressiveRelease() {
        logger.debug("-----supportsAggressiveRelease--------{}");
        return false;
    }

    /**
     * Can this wrapped service be unwrapped as the indicated type?
     *
     * @param unwrapType The type to check.
     * @return True/false.
     */
    @Override
    public boolean isUnwrappableAs(Class unwrapType) {
        logger.debug("-----isUnwrappableAs--------{}");
        return false;
    }

    /**
     * Unproxy the service proxy
     *
     * @param unwrapType The java type as which to unwrap this instance.
     * @return The unwrapped reference
     * @throws org.hibernate.service.UnknownUnwrapTypeException if the servicebe unwrapped as the indicated type
     */
    @Override
    public <T> T unwrap(Class<T> unwrapType) {
        logger.debug("-----unwrap--------{}");
        return null;
    }

    public DruidDataSource getDruidDataSource() {
        return druidDataSource;
    }

    public void setDruidDataSource(DruidDataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
    }
}
