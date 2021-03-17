package br.edu.cesmac.si.filmes.resource;

import br.edu.cesmac.si.filmes.Repository.AtorRepository;
import br.edu.cesmac.si.filmes.domain.Ator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorResource {

    @Autowired
    private AtorRepository atorRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ator> buscarPorId(@PathVariable("id") Long idAtor){
        return atorRepository.findById(idAtor).map(ator ->
                ResponseEntity.ok(ator)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Ator> listarTodas() {
        return atorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Ator ator){
        atorRepository.save(ator);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ator.getIdAtor()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void alterar(@RequestBody Ator ator){
        atorRepository.save(ator);
    }

    @DeleteMapping
    public void deletar(@RequestBody Ator ator){
        atorRepository.delete(ator);
    }
}
