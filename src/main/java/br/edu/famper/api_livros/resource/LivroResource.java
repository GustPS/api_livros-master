package br.edu.famper.api_livros.resource;

import br.edu.famper.api_livros.model.Livro;
import br.edu.famper.api_livros.service.LivroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@RequiredArgsConstructor
@Slf4j
public class LivroResource {

    @Autowired
    private final LivroService livroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Livro>> findAll() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        return livroService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livro> update(@RequestBody Livro livro) {
        return livroService.save(livro);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Livro livro) {
        livroService.delete(livro);
        return ResponseEntity.noContent().build();
    }

}
