package br.edu.famper.api_livros.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "livro")
@Data
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "titulo", length = 100)
    private String titulo;

    @NotNull
    @Column(name = "autor", length = 100)
    private String autor;

    @NotNull
    @Column(name = "ano_publicacao")
    private Number anoPublicacao;

    @NotNull
    @Column(name = "preco")
    private Double preco;

}
