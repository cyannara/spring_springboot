package container;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class AppContainer {
    public static void main(String[] args) {
  
        AbstractApplicationContext factory = 
            new GenericXmlApplicationContext("container/applicationContext.xml");
        
        TV tv = (TV)factory.getBean("tv");
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        

        factory.close();

    }
}

