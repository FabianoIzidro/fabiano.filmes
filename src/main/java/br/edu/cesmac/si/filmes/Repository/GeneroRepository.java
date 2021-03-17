package br.edu.cesmac.si.filmes.Repository;

import br.edu.cesmac.si.filmes.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {

}

