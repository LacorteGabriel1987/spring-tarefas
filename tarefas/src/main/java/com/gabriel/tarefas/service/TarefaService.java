package com.gabriel.tarefas.service;

import com.gabriel.tarefas.entity.Tarefa;
import com.gabriel.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> buscarTarefas(){
        return tarefaRepository.findAll();
    }


}
