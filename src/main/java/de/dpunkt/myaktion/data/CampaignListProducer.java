package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.services.CampaignService;
import de.dpunkt.myaktion.util.Events;
import de.dpunkt.myaktion.util.Log;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by blackbird on 10/28/15.
 */
@RequestScoped
public class CampaignListProducer{

    private List<Campaign> campaigns;
    @Inject
    private CampaignService campaignService;
    @Inject
    @Log.TecLog
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
        campaignService.addCampaign(campaign);
        initializeCampaigns();
    }

    public void onCampaignDeleted(@Observes @Events.Deleted Campaign campaign){
        campaignService.deleteCampaign(campaign);
        initializeCampaigns();
    }

    public void onCampaignUpdated(@Observes @Events.Updated Campaign campaign) {
        campaignService.updateCampaign(campaign);
        initializeCampaigns();
    }

}
