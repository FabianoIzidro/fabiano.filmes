package br.edu.cesmac.si.filmes.Repository;

import br.edu.cesmac.si.filmes.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
