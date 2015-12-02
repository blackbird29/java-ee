package de.dpunkt.myaktion.data;

import de.dpunkt.myaktion.model.Account;
import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.model.Status;
import de.dpunkt.myaktion.services.CampaignService;
import de.dpunkt.myaktion.util.Events;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Decorated;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by blackbird on 10/28/15.
 */
@SessionScoped
public class CampaignListProducer implements Serializable {

    private static final long serialVersionUID = -182866064791747156L;
    private List<Campaign> campaigns;
    @Inject
    private CampaignService campaignService;

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

}
