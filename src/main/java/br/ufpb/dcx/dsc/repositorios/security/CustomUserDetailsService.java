package br.ufpb.dcx.dsc.repositorios.security;

import br.ufpb.dcx.dsc.repositorios.models.Role;
import br.ufpb.dcx.dsc.repositorios.models.User;
import br.ufpb.dcx.dsc.repositorios.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByNome(username);
        if(u == null) {
            throw new UsernameNotFoundException("User não encontrado");
        }

        return u;
    }
}
