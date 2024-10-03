package pattern.kasir.handler;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pattern.kasir.config.OtherConfig;
import pattern.kasir.util.LoggingFile;

/*
	KODE EXCEPTION
	VALIDATION		= 01
	DATA			= 02
	AUTH			= 03
	MEDIA / FILE	= 04
	EXTERNAL API	= 05
	UNKNOW			= 99
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private List<ApiValidationError> lsSubError = new ArrayList<ApiValidationError>();
  private String[] strExceptionArr = new String[2];

  public GlobalExceptionHandler() {
    strExceptionArr[0] = "GlobalExceptionHandler";
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex,
    HttpHeaders headers,
    HttpStatusCode status,
    WebRequest request
  ) {
    lsSubError.clear();
    for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      lsSubError.add(
        new ApiValidationError(
          fieldError.getField(),
          fieldError.getDefaultMessage(),
          fieldError.getRejectedValue()
        )
      );
    }
    ApiError apiError = new ApiError(
      HttpStatus.BAD_REQUEST,
      "Data Tidak Valid !!",
      ex,
      request.getDescription(false),
      "X-01-001"
    );
    apiError.setSubErrors(lsSubError);
    strExceptionArr[1] =
      "handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status,WebServlet request) \n" +
      RequestCapture.allRequest(request); //perubahan 12-12-2023
    LoggingFile.exceptionStringz(
      strExceptionArr,
      ex,
      OtherConfig.getFlagLogging()
    );
    return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);
    //		return super.handleMethodArgumentNotValid(ex, headers, status, request);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> dataIntegrityViolationException(
    DataIntegrityViolationException ex,
    HttpServletRequest request
  ) {
    LoggingFile.exceptionStringz(
      strExceptionArr,
      ex,
      OtherConfig.getFlagLogging()
    );
    return buildResponseEntity(
      new ApiError(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "DATA TIDAK VALID",
        ex,
        request.getPathInfo(),
        "X-02-001"
      )
    );
  }

  @ExceptionHandler(UnexpectedRollbackException.class)
  public ResponseEntity<Object> unexpectedRollbackException(
    UnexpectedRollbackException ex,
    HttpServletRequest request
  ) {
    strExceptionArr[1] =
      "unexpectedRollbackException(UnexpectedRollbackException ex, HttpServletRequest request) \n" +
      RequestCapture.allRequest(request);
    LoggingFile.exceptionStringz(
      strExceptionArr,
      ex,
      OtherConfig.getFlagLogging()
    );
    return buildResponseEntity(
      new ApiError(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "DATA TIDAK VALID",
        ex,
        request.getPathInfo(),
        "X-02-001"
      )
    );
  }

  private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }

  @ExceptionHandler(MultipartException.class)
  public ResponseEntity<Object> multipartException(
    MultipartException ex,
    HttpServletRequest request
  ) {
    strExceptionArr[1] =
      "MultipartException(MultipartException ex, HttpServletRequest request) \n" +
      RequestCapture.allRequest(request);
    //  LoggingFile.exceptionStringz(
    //    strExceptionArr,
    //    ex,
    //    OtherConfig.getFlagLogging()
    //  );
    return buildResponseEntity(
      new ApiError(
        HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        "Konten harus Multipart",
        ex,
        request.getPathInfo(),
        "X-04-001"
      )
    );
  }

  @ExceptionHandler(FileUploadException.class)
  public ResponseEntity<Object> fileUploadException(
    FileUploadException ex,
    HttpServletRequest request
  ) {
    strExceptionArr[1] =
      "fileUploadException(FileUploadException ex, HttpServletRequest request) \n" +
      RequestCapture.allRequest(request);
    LoggingFile.exceptionStringz(
      strExceptionArr,
      ex,
      OtherConfig.getFlagLogging()
    );
    return buildResponseEntity(
      new ApiError(
        HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        "File Tidak Sesuai",
        ex,
        request.getPathInfo(),
        "X-04-002"
      )
    );
  }

  protected ResponseEntity<Object> handleExceptionInternal(
    Exception ex,
    @Nullable Object body,
    HttpHeaders headers,
    HttpStatus status,
    HttpServletRequest request
  ) {
    strExceptionArr[1] =
      "handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, HttpServletRequest request) \n" +
      RequestCapture.allRequest(request); //perubahan 12-12-2023
    LoggingFile.exceptionStringz(
      strExceptionArr,
      ex,
      OtherConfig.getFlagLogging()
    );
    return buildResponseEntity(
      new ApiError(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "TIDAK DAPAT DIPROSES",
        ex,
        request.getPathInfo(),
        "X-99-001"
      )
    );
  }
}
