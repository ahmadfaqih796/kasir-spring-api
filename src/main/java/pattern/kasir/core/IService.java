package pattern.kasir.core;

import org.springframework.http.ResponseEntity;

public interface IService<T> {
  public ResponseEntity<Object> save(T t); // 001-010

  public ResponseEntity<Object> update(Long id, T t); // 011-020

  public ResponseEntity<Object> delete(Long id, T t); // 021-030

  public ResponseEntity<Object> findAll(); // 031-040

  public ResponseEntity<Object> findById(Long id); // 041-050
}
