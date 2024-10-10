package pattern.kasir.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pattern.kasir.service.CloudinaryService;

@RestController
@RequestMapping("/cloudinary")
public class CloudinaryController {

  @Autowired
  private CloudinaryService cloudinaryService;

  @PostMapping("/upload")
  public ResponseEntity<Object> uploadImage(
    HttpServletRequest request,
    HttpServletResponse response,
    @RequestParam(value = "file") MultipartFile file
  ) {
    return cloudinaryService.upload(file, request);
  }
}
