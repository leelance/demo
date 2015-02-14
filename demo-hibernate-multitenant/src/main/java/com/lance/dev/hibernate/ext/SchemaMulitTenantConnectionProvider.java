package com.lance.dev.hibernate.ext;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.cfg.Environment;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author lance
 * @since 2015/2/14 14:57.
 */
public class SchemaMulitTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl implements ServiceRegistryAwareService {
    private static Logger logger = LogManager.getLogger(SchemaMulitTenantConnectionProvider.class);
    public final String DEFAULT_SCHEMA = "qhdevelop18";

    private DruidDataSource ds;

    @Override
    public void injectServices(ServiceRegistryImplementor serviceRegistryImplementor) {
        logger.debug("----------injectServices----------{}", serviceRegistryImplementor);
        Map setting = serviceRegistryImplementor.getService(ConfigurationService.class).getSettings();
        ds = (DruidDataSource)setting.get(Environment.DATASOURCE);
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return null;
    }

    @Override
    protected DataSource selectDataSource(String s) {
        return null;
    }
}
