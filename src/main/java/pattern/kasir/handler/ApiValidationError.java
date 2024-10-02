package pattern.kasir.handler;

class ApiValidationError {

  private String field;
  private String message;
  private Object rejectedValue;

  //    private String objectName;
  public ApiValidationError(
    String field,
    String message,
    Object rejectedValue
  ) {
    this.field = field;
    this.message = message;
    //        this.objectName = objectName;
    this.rejectedValue = rejectedValue;
  }

  //    public String getObjectName() {
  //        return objectName;
  //    }
  //
  //    public void setObjectName(String objectName) {
  //        this.objectName = objectName;
  //    }

  public Object getRejectedValue() {
    return rejectedValue;
  }

  public void setRejectedValue(Object rejectedValue) {
    this.rejectedValue = rejectedValue;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
