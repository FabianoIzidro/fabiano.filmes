package br.edu.cesmac.si.filmes.resource;

import br.edu.cesmac.si.filmes.Repository.FilmeRepository;
import br.edu.cesmac.si.filmes.domain.Ator;
import br.edu.cesmac.si.filmes.domain.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeResource {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable("id") Long idFilme){
        return filmeRepository.findById(idFilme).map(filme ->
                ResponseEntity.ok(filme)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public List<Filme> listarTodas() {
        return filmeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Filme filme){
        filmeRepository.save(filme);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(filme.getIdFilme()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public void alterar(@RequestBody Filme filme){
        filmeRepository.save(filme);
    }

    @DeleteMapping
    public void deletar(@RequestBody Filme filme){
        filmeRepository.delete(filme);
    }
}
