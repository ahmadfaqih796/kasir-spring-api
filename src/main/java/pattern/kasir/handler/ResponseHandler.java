package pattern.kasir.handler;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

  public ResponseEntity<Object> generateResponse(
    String message,
    HttpStatus status,
    Object responseObj,
    Object errorCode,
    HttpServletRequest request
  ) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("message", message);
    map.put("status", status.value());
    map.put("data", responseObj == null ? "" : responseObj);
    map.put("timestamp", new Date());
    map.put("success", !status.isError());
    if (errorCode != null) {
      map.put("errorCode", errorCode);
      map.put("path", request.getPathInfo());
    }
    return new ResponseEntity<Object>(map, status);
  }

  public Map<String, Object> generateResponseRaw(
    String message,
    HttpStatus status,
    Object responseObj,
    Object errorCode,
    HttpServletRequest request
  ) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("message", message);
    map.put("status", status.value());
    map.put("data", responseObj == null ? "" : responseObj);
    map.put("timestamp", new Date());
    map.put("success", !status.isError());
    if (errorCode != null) {
      map.put("errorCode", errorCode);
      map.put("path", request.getPathInfo());
    }
    map.put("httpStatus", status);
    return map;
  }
}
