package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;
import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;
import de.dpunkt.myaktion.services.DonationService;
import de.dpunkt.myaktion.util.Events;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by blackbird on 10/28/15.
 */
@ViewScoped
@Named
public class ListCampaignsController implements Serializable {

    private static final long serialVersionUID = 8693277383648025822L;
    @Inject
    private CampaignProducer campaignProducer;
    private Campaign campaignToDelete;
    @Inject @Events.Deleted
    private Event<Campaign> campaignDeleteEvent;
    @Inject
    private DonationService donationService;


    public String doAddCampaign(){
        campaignProducer.prepareAddCampaign();
        return Pages.EDIT_CAMPAIGN;
    }

    public String doEditCampaign(Campaign campaign){
        campaignProducer.prepareEditCampaign(campaign);
        return Pages.EDIT_CAMPAIGN;
    }

    public String doEditDonationForm(Campaign campaign){
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.EDIT_DONATION_FORM;
    }

    public String doListDonations(Campaign campaign){
        final List<Donation> donations =
                donationService.getDonationList(campaign.getId());
        campaign.setDonations(donations);
        campaignProducer.setSelectedCampaign(campaign);
        return Pages.LIST_DONATIONS;
    }

    public void doDeleteCampaign(Campaign campaign){
        this.campaignToDelete = campaign;
        System.out.println("Campaign prepared to delete");
    }

    public void commitDeleteCampaign(){
        campaignDeleteEvent.fire(campaignToDelete);
    }

}
