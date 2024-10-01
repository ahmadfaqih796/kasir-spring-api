package pattern.kasir.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public class RoleResponse {

  private UUID id;
  private String name;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;

  public RoleResponse(
    UUID id,
    String name,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
  ) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

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

  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
