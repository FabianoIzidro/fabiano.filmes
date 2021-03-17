package br.edu.cesmac.si.filmes.Repository;

import br.edu.cesmac.si.filmes.domain.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Long> {

}

