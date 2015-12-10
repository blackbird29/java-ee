package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.services.CampaignService;
import de.dpunkt.myaktion.util.Events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by blackbird on 10/28/15.
 */
@SessionScoped
public class CampaignListProducer implements Serializable {

    private static final long serialVersionUID = -182866064791747156L;
    private List<Campaign> campaigns;
    @Inject
    private CampaignService campaignService;
    @Inject
    private Logger logger;

    @PostConstruct
    public void initializeCampaigns(){
        campaigns = campaignService.getAllCampaigns();
    }

    @Produces
    @Named
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void onCampaignAdded(@Observes @Events.Added Campaign campaign){
        getCampaigns().add(campaign);
    }

    public void onCampaignDeleted(@Observes @Events.Deleted Campaign campaign){
        getCampaigns().remove(campaign);
    }

    public void onCampaignUpdated(@Observes @Events.Updated Campaign campaign) {
        logger.log(Level.INFO, "Not implemented yet - Campaign update");
    }

}
