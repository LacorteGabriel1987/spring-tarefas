package com.gabriel.usuario.service;

import com.gabriel.tarefas.entity.Usuario;
import com.gabriel.tarefas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    // ===========================
    // LISTAR TODOS OS USUÁRIOS
    // ===========================
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // ===========================
    // BUSCAR USUÁRIO POR ID
    // ===========================
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    // ===========================
    // SALVAR NOVO USUÁRIO
    // ===========================
    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // ===========================
    // ATUALIZAR USUÁRIO EXISTENTE
    // ===========================
    public Usuario atualizarUsuario(Usuario usuario, Long id) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setNome(usuario.getNome());
                    usuarioExistente.setEmail(usuario.getEmail());
                    // Adicione outros campos caso a entidade Usuario tenha
                    return usuarioRepository.save(usuarioExistente);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID " + id));
    }

    // ===========================
    // DELETAR USUÁRIO POR ID
    // ===========================
    public void deletarUsuario(Long id) {
        if(!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com ID " + id);
        }
        usuarioRepository.deleteById(id);
    }

}
