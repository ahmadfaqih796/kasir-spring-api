package pattern.kasir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Types;
import java.util.Date;
import java.util.UUID;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
  @CreationTimestamp
  private Date createdAt = new Date();

  @UpdateTimestamp
  @Column(
    name = "updated_at",
    columnDefinition = "TIMESTAMP",
    insertable = false
  )
  private Date updatedAt = new Date();

  public RoleEntity() {}

  public RoleEntity(String name) {
    this.name = name;
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

  public Date getCreatedAt() {
    System.out.println("getCreatedAt Role: " + createdAt);
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    System.out.println("getUpdatedAt Role: " + updatedAt);
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
