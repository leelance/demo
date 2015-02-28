package com.lance.dev.hibernate.service;

import org.springframework.stereotype.Service;

/**
 * @author lance
 * @since 2015/2/28 17:51.
 */
@Service
public class UserServiceImpl{
    public String tenantId = "qhdevelop18";

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}
