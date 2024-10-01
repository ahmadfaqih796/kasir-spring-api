package pattern.kasir.dto.validation;

import jakarta.validation.constraints.NotBlank;

public class RoleDTO {

  @NotBlank(message = "Name is required")
  private String name;

  // Getter dan Setter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
