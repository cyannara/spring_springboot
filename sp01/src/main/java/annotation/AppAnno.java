package annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppAnno {
    public static void main(String[] args) {

        AbstractApplicationContext ctx =  new GenericXmlApplicationContext("annotation/annoContext.xml");
        
        TV tv = (TV)ctx.getBean("tv");
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
        
        ctx.close();

    }
}

