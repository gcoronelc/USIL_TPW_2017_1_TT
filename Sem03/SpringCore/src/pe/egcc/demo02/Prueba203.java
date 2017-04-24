package pe.egcc.demo02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Prueba203 {

  public static void main(String[] args) {
    
    // Instanciando el contexto
    String contexto = "/pe/egcc/demo02/contexto.xml";
    BeanFactory beanFactory;
    beanFactory = new ClassPathXmlApplicationContext(contexto);
    
    // Accediendo al objeto
    AppController control;
    control = beanFactory.getBean(AppController.class);
    
    // Probando el componente de servicios
    System.out.println("9 + 13 = " + control.sumar(9, 13));
    
    
    

  }

}
