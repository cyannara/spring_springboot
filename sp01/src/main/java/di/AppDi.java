package di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppDi {
    public static void main(String[] args) {
        // 1. Spring 컨테이너
        AbstractApplicationContext factory = 
            new GenericXmlApplicationContext("di/diContext.xml");
        
        // 2. Spring DI
        TV tv = (TV)factory.getBean("tv");
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        
        // 3. Spring 컨테이너
        factory.close();

    }
}

