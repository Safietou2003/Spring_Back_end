package com.ges_abs.services.inter;

public interface CoursService {
    Cours save(Cours cours);
    List<Cours> findAll();
    Optional<Cours> findById(String id);
    void delete(String id);
}
