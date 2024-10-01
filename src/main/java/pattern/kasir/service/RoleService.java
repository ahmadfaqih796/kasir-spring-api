package pattern.kasir.service;

import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pattern.kasir.core.IService;
import pattern.kasir.dto.response.RoleResponse;
import pattern.kasir.dto.validation.RoleDTO;
import pattern.kasir.model.RoleEntity;
import pattern.kasir.module.role.RoleRepository;

@Service
public class RoleService implements IService<RoleDTO> {

  private final RoleRepository roleRepository;

  public RoleService(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  @Transactional
  public ResponseEntity<Object> save(RoleDTO roleDTO) {
    RoleEntity roleEntity = new RoleEntity(roleDTO.getName());
    roleRepository.save(roleEntity);
    RoleResponse roleResponse = new RoleResponse(
      roleEntity.getId(),
      roleEntity.getName(),
      roleEntity.getCreatedAt(),
      roleEntity.getUpdatedAt()
    );
    return ResponseEntity.ok(roleResponse);
  }

  @Override
  public ResponseEntity<Object> update(UUID id, RoleDTO roleDTO) {
    Optional<RoleEntity> role = roleRepository.findById(
      UUID.fromString(id.toString())
    );
    if (role.isPresent()) {
      RoleEntity roleEntity = role.get();
      roleEntity.setName(roleDTO.getName());
      roleRepository.save(roleEntity);
      RoleResponse roleResponse = new RoleResponse(
        roleEntity.getId(),
        roleEntity.getName(),
        roleEntity.getCreatedAt(),
        roleEntity.getUpdatedAt()
      );
      return ResponseEntity.ok(roleResponse);
    }
    return ResponseEntity.notFound().build();
  }
}
