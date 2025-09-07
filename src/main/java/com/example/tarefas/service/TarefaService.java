package com.example.tarefas.service;

import com.example.tarefas.exception.ResourceNotFoundException;
import com.example.tarefas.model.Tarefa;
import com.example.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criar(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listar() {
        return repository.findAll();
    }

    public Tarefa obter(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id " + id));
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        Tarefa existente = obter(id);
        existente.setNome(tarefaAtualizada.getNome());
        existente.setDataEntrega(tarefaAtualizada.getDataEntrega());
        existente.setResponsavel(tarefaAtualizada.getResponsavel());
        return repository.save(existente);
    }

    public void remover(Long id) {
        Tarefa existente = obter(id);
        repository.delete(existente);
    }
}
