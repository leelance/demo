package com.lance.dev.hibernate.service;

import com.lance.dev.hibernate.entity.MarriageEnumEntity;

import java.util.List;

/**
 * @author lance
 * @since 2015/2/13 14:01.
 */
public interface MarriageEnumService {
    List<MarriageEnumEntity> findAll();
}
