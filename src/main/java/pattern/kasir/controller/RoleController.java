package pattern.kasir.controller;

import jakarta.validation.Valid;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pattern.kasir.dto.validation.RoleDTO;
import pattern.kasir.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @GetMapping
  public ResponseEntity<Object> getAll() {
    return roleService.findAll(); // Gunakan service untuk mendapatkan semua role
  }

  @PostMapping
  public ResponseEntity<Object> createRole(
    @RequestBody @Valid RoleDTO roleDTO
  ) {
    return roleService.save(roleDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateRole(
    @PathVariable UUID id,
    @RequestBody @Valid RoleDTO roleDTO
  ) {
    System.out.println("PutRole");
    return roleService.update(id, roleDTO);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Object> patchRole(
    @PathVariable UUID id,
    @RequestBody RoleDTO roleDTO
  ) {
    System.out.println("patchRole");
    return roleService.update(id, roleDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteRole(@PathVariable UUID id) {
    return roleService.delete(id);
  }
}
