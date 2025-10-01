import com.gabriel.tarefas.entity.Usuario;
import com.gabriel.tarefas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    //Buscar por id
    public Optional<Usuario> buscarId(Long id){
        return usuarioRepository.findById(id);
    }

    //Salvar Usuario
    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    //Atualizar
    public Usuario atualizarUsuario(Usuario usuario, Long id){
        return usuarioRepository.findById(id)
                .map(Usuario ->{
                    usuario.setEmail(atualizarUsuario().getEmail());
                    usuario.setNome(atualizarUsuario().getNome())
                            return usuarioRepository.save(usuario);
                })
                .orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

    }

    //Deleta
    public void deletarUsuario(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else
            throw new RuntimeException("Usuario não encontrado com ID" + id);
    }
//    //Ou desta forma DELETAR
//    public void deletarUsuario(Long id) {
//        usuarioRepository.deleteById(id);
//    }

}