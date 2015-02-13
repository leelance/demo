package com.lance.dev.hibernate.common;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * //@Table 可以不用写name, 表名自动加前缀和后缀
 * //@ManyToOne 和 //@OneToOne 的情况下， 只要写@JoinColumn ，属性名自动加前缀和后缀作为字段名
 * 单向一对多 比较复杂，自己命名
 * @since 14-5-23
 */
public class TMSJPAImprovedNamingStrategy extends ImprovedNamingStrategy {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    //表名的前缀 和 后缀
    private String tablePrefix = "tms_";
    private String tableSuffix = "";

    //外键的 前缀 和 后缀
    private String foreignKeyColumnPrefix = "fk_";
    private String foreignKeyColumnSuffix = "";

    private boolean isRemoveLastWord = true;

    @Override
    public String classToTableName(String className) {
        String rawTableName = super.classToTableName(className);

        if (isRemoveLastWord) {
            int pos = StringUtils.lastIndexOf(rawTableName, '_');
            return tablePrefix + StringUtils.substring(rawTableName, 0, pos) + tableSuffix;
        }

        return tablePrefix + rawTableName + tableSuffix;
    }

    @Override
    public String propertyToColumnName(String propertyName) {
        return super.propertyToColumnName(propertyName);
    }

    @Override
    public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity, String associatedEntityTable, String propertyName) {
        return super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName);
    }


    @Override
    public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
        String columnName = foreignKeyColumnPrefix + super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName, referencedColumnName);
        return columnName;
    }
}
