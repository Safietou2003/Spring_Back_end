package com.ges_abs.services.impl;

import com.ges_abs.services.inter.CoursService;
import org.springframework.stereotype.Service;

@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    private CoursRepository coursRepository;

    @Override
    public Cours save(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    @Override
    public Optional<Cours> findById(String id) {
        return coursRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        coursRepository.deleteById(id);
    }
}
