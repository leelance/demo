package com.lance.dev.hibernate.service;

import com.lance.dev.hibernate.entity.MarriageEnumEntity;
import com.lance.dev.hibernate.repository.MarriageEnumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lance
 * @since 2015/2/13 14:01.
 */
@Service
public class MarriageEnumServiceImpl implements MarriageEnumService{
    @Autowired
    private MarriageEnumRepository marriageEnumRepository;

    public List<MarriageEnumEntity> findAll() {
        return marriageEnumRepository.findAll();
    }
}
