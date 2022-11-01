package rikkei.academy.service.role;

import org.springframework.beans.factory.annotation.Autowired;
import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.repository.IRoleRepository;
import rikkei.academy.service.role.IRoleService;

import java.util.Optional;

public class RoleServiceIMPL implements IRoleService {
    @Autowired
    private IRoleRepository repository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return repository.findByName(name);
    }
}
