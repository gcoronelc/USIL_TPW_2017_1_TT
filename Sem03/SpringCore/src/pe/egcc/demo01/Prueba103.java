package pe.egcc.demo01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba103 {

  public static void main(String[] args) {
    
    // Instanciando el contexto
    String contexto = "/pe/egcc/demo01/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    // Accediendo al objeto
    AppService service;
    service = beanFactory.getBean(AppService.class);
    
    // Probando el componente de servicios
    System.out.println("9 + 13 = " + service.sumar(9, 13));
    
    
    

  }

}
