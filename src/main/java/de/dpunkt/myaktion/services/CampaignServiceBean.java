package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Organizer;
import de.dpunkt.myaktion.util.Log;
import de.dpunkt.myaktion.util.TransactionInterceptor;
import org.omg.IOP.ExceptionDetailMessage;
import org.omg.PortableInterceptor.ORBIdHelper;
import org.omg.PortableInterceptor.ObjectReferenceFactory;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by blackbird on 12/2/15.
 */
@RolesAllowed("Organizer")
@Stateless
public class CampaignServiceBean implements CampaignService {

    @Inject
    @Log.TecLog
    private Logger logger;
    @Inject
    EntityManager entityManager;
    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Campaign> getAllCampaigns(){
        TypedQuery<Campaign> query = entityManager.createNamedQuery(Campaign.findByOrganizer, Campaign.class);
        query.setParameter("organizer", getLoggedInOrganizer());
        List<Campaign> campaigns = query.getResultList();
        campaigns.forEach( campaign -> {
            campaign.setAmountDonatedSoFar(getAmountDonatedSoFar(campaign));
            logger.log(Level.INFO, "Campaign "+ campaign.getName(),"Successful");
        } );
        logger.log(Level.INFO, "All campaigns retrieved","Successful");
        return campaigns;
    }

    @Override
    public void addCampaign(Campaign campaign) {
            Organizer organizer = getLoggedInOrganizer();
            campaign.setOrganizer(organizer);
            entityManager.persist(campaign);

    }

    @Override
    public void deleteCampaign(Campaign campaign) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaign.getId());
        entityManager.remove(managedCampaign);
    }

    @Override
    public void updateCampaign(Campaign campaign) {
        entityManager.merge(campaign);
    }

    private Double getAmountDonatedSoFar(Campaign campaign){
        TypedQuery<Double> query =
                entityManager.createNamedQuery(Campaign.getAmountDonatedSoFar, Double.class);
        query.setParameter("campaign", campaign);
        Double result = query.getSingleResult();
        if( result == null ){
            result = 0d;
        }
        return result;
    }

    private Organizer getLoggedInOrganizer(){
        String organizerEmail = sessionContext.getCallerPrincipal().getName();
        Organizer organizer = entityManager.createNamedQuery(Organizer.findByEmail, Organizer.class)
                                            .setParameter("email", organizerEmail).getSingleResult();
        return organizer;
    }

}
