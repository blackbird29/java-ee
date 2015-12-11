package de.dpunkt.myaktion.util;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.logging.Logger;

/**
 * Created by blackbird on 12/1/15.
 */
@Dependent
public class Resources {
    @Produces
    @Log.FachLog
    public Logger produceFachLog(InjectionPoint injectionPoint){
        return Logger.getLogger("Fachlog:" + injectionPoint.getMember().getDeclaringClass().getName(),"messages");
    }

    @Produces
    @Log.TecLog
    public Logger produceTecLog(InjectionPoint injectionPoint){
        return Logger.getLogger("Teclog:" +injectionPoint.getMember().getDeclaringClass().getName(),"messages");
    }

    @Produces
    @RequestScoped
    public FacesContext produceFacesContext(){
        return FacesContext.getCurrentInstance();
    }

    @Produces
    @PersistenceContext
    private EntityManager entityManager;
}
