package com.ges_abs.services.inter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ges_abs.data.models.entity.Session;

public interface SessionService {
    Session save(Session session);
    List<Session> findAll();
    Optional<Session> findById(String id);
    void delete(String id);
}

