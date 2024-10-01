package pattern.kasir.dto.response;

import java.sql.Timestamp;
import java.util.UUID;

public class RoleResponse {

  private UUID id;
  private String name;
  private Timestamp createdAt;
  private Timestamp updatedAt;

  public RoleResponse(
    UUID id,
    String name,
    Timestamp createdAt,
    Timestamp updatedAt
  ) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  // Getter dan Setter
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }
}
