package pattern.kasir.dto.response;

import java.util.UUID;

public class RoleResponse {

  private UUID id;
  private String name;
  private String createdAt;
  private String updatedAt;

  // public RoleResponse(UUID id, String name, String createdAt, String updatedAt) {
  //   this.id = id;
  //   this.name = name;
  //   this.createdAt = createdAt == null ? null : createdAt;
  //   this.updatedAt = updatedAt == null ? null : updatedAt;
  // }

  public RoleResponse(
    UUID id,
    String name,
    String createdAt,
    String updatedAt
  ) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt == null ? null : createdAt;
    this.updatedAt = updatedAt == null ? null : updatedAt;
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

  public String getCreatedAt() {
    System.out.println("getCreatedAt: " + createdAt);
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    System.out.println("getUpdatedAt: " + updatedAt);
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
