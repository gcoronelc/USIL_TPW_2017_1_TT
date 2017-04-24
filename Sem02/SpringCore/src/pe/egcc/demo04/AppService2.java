package pe.egcc.demo04;

import org.springframework.stereotype.Component;

@Component
public class AppService2 {
  
  public long factorial(int n){
    long f = 1;
    for(int i=2; i <= n; i++){
      f *= i;
    }
    return f;
  }
  
}
