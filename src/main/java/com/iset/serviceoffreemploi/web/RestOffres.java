package com.iset.serviceoffreemploi.web;
import com.iset.serviceoffreemploi.dao.OffreRepository;
import com.iset.serviceoffreemploi.entities.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/Offres")

public class RestOffres {
    @Autowired
    OffreRepository offreRepository;
    @GetMapping
    public List<Offre> getAll() {
        return offreRepository.findAll();
    }
    @GetMapping("/{id}")
    public Offre getById(@PathVariable Long id) {
        return offreRepository.findById(id).orElse(null);
    }
    @PostMapping
    public Offre saveOffre(@RequestBody Offre newoffre) {
        return offreRepository.save(newoffre);
    }
    @DeleteMapping ("/{id}")
    public void deleteOffre(@PathVariable Long id){
        offreRepository.deleteById(id);
    }
}
