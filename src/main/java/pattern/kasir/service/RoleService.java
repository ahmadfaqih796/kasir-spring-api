package pattern.kasir.service;

import jakarta.transaction.Transactional;
import java.util.List;
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
      null
    );
    return ResponseEntity.ok(roleResponse);
  }

  @Override
  @Transactional
  public ResponseEntity<Object> update(UUID id, RoleDTO roleDTO) {
    Optional<RoleEntity> role = roleRepository.findById(
      UUID.fromString(id.toString())
    );
    if (role.isPresent()) {
      RoleEntity roleEntity = role.get();
      roleEntity.setName(roleDTO.getName());
      // roleRepository.save(roleEntity);y
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

  @Override
  @Transactional
  public ResponseEntity<Object> delete(UUID id) {
    Optional<RoleEntity> role = roleRepository.findById(id);
    if (role.isPresent()) {
      roleRepository.deleteById(id);
      // return ResponseEntity.ok(role.get());
      return ResponseEntity.ok("Role with ID " + id + " has been deleted.");
    }
    return ResponseEntity.notFound().build();
  }

  @Override
  public ResponseEntity<Object> findAll() {
    List<RoleEntity> roles = roleRepository.findAll();
    List<RoleResponse> roleResponses = roles
      .stream()
      .map(role ->
        new RoleResponse(
          role.getId(),
          role.getName(),
          role.getCreatedAt(),
          role.getUpdatedAt()
        )
      )
      .toList();
    return ResponseEntity.ok(roleResponses);
  }

  @Override
  public ResponseEntity<Object> findById(UUID id) {
    Optional<RoleEntity> role = roleRepository.findById(id);
    if (role.isPresent()) {
      RoleEntity roleEntity = role.get();
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
