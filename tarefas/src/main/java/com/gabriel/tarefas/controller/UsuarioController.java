package com.gabriel.usuario.controller;

import com.gabriel.tarefas.entity.Usuario;
import com.gabriel.usuario.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // LISTAR TODOS OS USUÁRIOS
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    // BUSCAR USUÁRIO POR ID
    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .orElse(null); // retorna null se não encontrar (Postman mostra 200 com corpo vazio)
    }

    // SALVAR NOVO USUÁRIO
    @PostMapping
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    // ATUALIZAR USUÁRIO EXISTENTE
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioService.atualizarUsuario(usuario, id);
    }

    // DELETAR USUÁRIO
    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return "Usuário deletado com sucesso!";
    }
}
