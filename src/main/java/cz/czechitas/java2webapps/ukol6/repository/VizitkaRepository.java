package cz.czechitas.java2webapps.ukol6.repository;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VizitkaRepository extends CrudRepository<Vizitka, Integer> {
    Optional<Vizitka> findById(int id);
}
