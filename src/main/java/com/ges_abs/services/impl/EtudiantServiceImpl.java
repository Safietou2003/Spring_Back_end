package com.ges_abs.services.impl;

import com.ges_abs.data.repository.EtudiantRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ges_abs.data.models.entity.Etudiant;
import com.ges_abs.services.inter.EtudiantService;
import org.springframework.stereotype.Service;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Map<String, Object> getAllEtudiants(Pageable pageable) {
        Page<Etudiant> pageResult = etudiantRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("etudiants", pageResult.getContent());
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());

        return response;
    }

    @Override
    public Map<String, Object> getEtudiantByMatricule(String matricule) {
        Etudiant etudiant = etudiantRepository.findByMatricule(matricule)
                .orElseThrow(() -> new NoSuchElementException("Aucun étudiant trouvé avec le matricule : " + matricule));

        Map<String, Object> result = new HashMap<>();
        result.put("etudiant", etudiant);
        return result;
    }
}
