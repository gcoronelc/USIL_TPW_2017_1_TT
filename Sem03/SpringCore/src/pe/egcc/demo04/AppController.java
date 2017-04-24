package pe.egcc.demo04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppController {

  @Autowired
  private AppService service;

  @Autowired
  private AppService2 service2;
  
  public int sumar(int n1, int n2){
    return service.sumar(n1, n2);
  }
  
  public long factorial(int n){
    return service2.factorial(n);
  }
  
}
