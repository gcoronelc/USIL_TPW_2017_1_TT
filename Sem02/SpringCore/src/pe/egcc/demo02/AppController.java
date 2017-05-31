package pe.egcc.demo02;

import org.springframework.stereotype.Repository;

@Repository("Algo")
public class AppController {
  
  private AppService service;
  
  // Inyección con setter
  public void setService(AppService service) {
    this.service = service;
  }
  
  public int sumar(int n1, int n2){
    return service.sumar(n1, n2);
  }
  
}
