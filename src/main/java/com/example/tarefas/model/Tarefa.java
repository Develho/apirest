package com.example.tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da tarefa é obrigatório.")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "A data de entrega é obrigatória.")
    private LocalDate dataEntrega;

    @NotBlank(message = "O responsável é obrigatório.")
    @Column(nullable = false)
    private String responsavel;

    public Tarefa() {}

    public Tarefa(Long id, String nome, LocalDate dataEntrega, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
