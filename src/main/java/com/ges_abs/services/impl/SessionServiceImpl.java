package com.ges_abs.services.impl;

import com.ges_abs.data.repository.SessionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ges_abs.data.models.entity.Session;
import com.ges_abs.services.inter.SessionService;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Optional<Session> findById(String id) {
        return sessionRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        sessionRepository.deleteById(id);
    }
}
