package Facts.Arch.ArchFacts.security;

import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(email);

        if (usuarioOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Usuário %s não encontrado", email));
        }
        Usuario usuario = usuarioOptional.get();
//        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(),
//                new ArrayList<>());
        return usuario; // Classe usuario já implementa userdetails
    }
}
