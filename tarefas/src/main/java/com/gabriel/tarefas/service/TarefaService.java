package com.gabriel.tarefas.service;

import com.gabriel.tarefas.entity.Tarefa;
import com.gabriel.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
//@RequiredArgsConstructor
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    //Listar todos
    public List<Tarefa> buscarTarefas(){
        return tarefaRepository.findAll();
    }

    //Buscar por ID
    public Optional<Tarefa> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    //Salvar
    public Tarefa salvarTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    //Atualizar
    public  Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada){
        return tarefaRepository.findById(id)
                .map(tarefa ->{
                    tarefa.setTitulo(tarefaAtualizada.getTitulo());
                    tarefa.setDescricao(tarefaAtualizada.getDescricao());
                    tarefa.setStatus(tarefaAtualizada.getStatus());
                    tarefa.setDataLimite(tarefaAtualizada.getDataLimite());

                    return tarefaRepository.save(tarefa);
                })
                .orElseThrow(()-> new RuntimeException("Tarefa não existe"));
    }
    //Deletar
    public void deletarTarefa(Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada");
        }
    }
}
