package pattern.kasir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.sql.Types;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import pattern.kasir.util.DateTimeUtil;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity {

  @Id
  @UuidGenerator
  // @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "CHAR(36)")
  @JdbcTypeCode(Types.CHAR)
  private UUID id;

  private String name;

  @Column(
    name = "created_at",
    columnDefinition = "TIMESTAMP",
    updatable = false
  )
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
  private OffsetDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    createdAt = DateTimeUtil.getCurrentTime();
    updatedAt = DateTimeUtil.getCurrentTime();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedAt = DateTimeUtil.getCurrentTime();
  }

  public RoleEntity() {}

  public RoleEntity(String name) {
    this.name = name;
    // this.updatedAt = DateTimeUtil.getCurrentTime();
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
