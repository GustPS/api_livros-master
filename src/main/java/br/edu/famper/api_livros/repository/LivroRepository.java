package br.edu.famper.api_livros.repository;

import br.edu.famper.api_livros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
