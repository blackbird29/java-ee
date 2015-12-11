package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.util.Log;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by blackbird on 12/2/15.
 */
@Stateless
public class CampaignServiceBean implements CampaignService {

    @Inject
    @Log.TecLog
    private Logger logger;
    @Inject
    EntityManager entityManager;

    @Override
    public List<Campaign> getAllCampaigns(){
        TypedQuery<Campaign> query = entityManager.createNamedQuery(Campaign.findAll, Campaign.class);
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

}
