package com.ges_abs.service.impl;

import com.ges_abs.data.models.entity.EtudiantCours;
import com.ges_abs.data.repositories.EtudiantCoursRepository;
import com.ges_abs.service.EtudiantCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantCoursServiceImpl implements EtudiantCoursService {

    @Autowired
    private EtudiantCoursRepository repository;

    @Override
    public EtudiantCours save(EtudiantCours etudiantCours) {
        return repository.save(etudiantCours);
    }

    @Override
    public List<EtudiantCours> findAll() {
        return repository.findAll();
    }

    @Override
    public EtudiantCours findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
