package de.dpunkt.myaktion.util;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;

/**
 * Created by blackbird on 12/1/15.
 */
@Dependent
public class Resources {
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint){
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName(),"messages");
    }

    @Produces
    @RequestScoped
    public FacesContext produceFacesContext(){
        return FacesContext.getCurrentInstance();
    }
}
