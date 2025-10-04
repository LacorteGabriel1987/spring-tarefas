package com.gabriel.tarefas.controller;

import com.gabriel.tarefas.entity.Tarefa;
import com.gabriel.tarefas.service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> todaTarefas(){
        return tarefaService.buscarTarefas();
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> tarefaPorId(@PathVariable Long id){
        return tarefaService.buscarPorId(id);
    }

    @PostMapping
    public Tarefa salvarTarefa(@RequestBody Tarefa tarefa){
        return tarefaService.salvarTarefa(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){
        return tarefaService.atualizarTarefa(id, tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }
}
