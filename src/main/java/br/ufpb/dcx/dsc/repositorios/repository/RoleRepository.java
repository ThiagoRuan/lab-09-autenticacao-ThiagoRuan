package br.ufpb.dcx.dsc.repositorios.repository;

import br.ufpb.dcx.dsc.repositorios.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNome(String nome);
}
