package com.clinica.popular_ph.repository;

import com.clinica.popular_ph.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*PEGANDO OS MÉTODOS DO SPRING*/
@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
