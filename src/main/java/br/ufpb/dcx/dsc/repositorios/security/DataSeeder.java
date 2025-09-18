package br.ufpb.dcx.dsc.repositorios.security;

import br.ufpb.dcx.dsc.repositorios.models.Role;
import br.ufpb.dcx.dsc.repositorios.models.User;
import br.ufpb.dcx.dsc.repositorios.repository.RoleRepository;
import br.ufpb.dcx.dsc.repositorios.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DataSeeder(RoleRepository roleRepository, UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = createRoleIfNotFound("ROLE_ADMIN");
        Role userRole = createRoleIfNotFound("ROLE_USER");

        createUserIfNotFound("admin", "admin@test.com", "admin123", Set.of(adminRole, userRole));
    }

    private Role createRoleIfNotFound(String nome) {
        Optional<Role> role = roleRepository.findByNome(nome);
        if(role.isEmpty()) {
            Role newRole = new Role();
            newRole.setNome(nome);
            return roleRepository.save(newRole);
        }
        return role.get();
    }

    private void createUserIfNotFound(String username, String email, String password, Set<Role> roles){
        Optional<User> user = Optional.ofNullable(userRepository.findByNome(username));
        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setNome(username);
            newUser.setEmail(email);
            newUser.setSenha(passwordEncoder.encode(password));
            newUser.setRoles(roles);
            userRepository.save(newUser);
        }
    }
}
