package br.edu.famper.api_livros.service;

import br.edu.famper.api_livros.model.Livro;
import br.edu.famper.api_livros.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;

    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

    public ResponseEntity<Livro> findById(Long id) {
        return ResponseEntity.ok(livroRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Livro> save(Livro livro) {

        return ResponseEntity.ok(livroRepository.save(livro));
    }

    public ResponseEntity<Livro> update(Livro livro) {

        Livro livroSaved = livroRepository.findById(livro.getId())
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livroSaved.setTitulo(livro.getTitulo());
        livroSaved.setAutor(livro.getAutor());
        livroSaved.setAnoPublicacao(livro.getAnoPublicacao());
        livroSaved.setPreco(livro.getPreco());

        return ResponseEntity.ok(livroRepository.save(livroSaved));
    }

    public ResponseEntity<Void> delete(@RequestBody Livro livro) {
        livroRepository.deleteById(livro.getId());
        return null;
    }


}
