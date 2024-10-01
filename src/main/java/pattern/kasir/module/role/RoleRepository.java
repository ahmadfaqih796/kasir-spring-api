package pattern.kasir.module.role;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pattern.kasir.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {}
