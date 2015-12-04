package de.dpunkt.myaktion.controller;

import de.dpunkt.myaktion.data.CampaignProducer;
import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.util.Events;

import javax.enterprise.event.Event;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by blackbird on 11/21/15.
 */
@ViewScoped
@Named
public class EditCampaignController implements Serializable {

    private static final long serialVersionUID = 2815796004558360299L;

    @Inject
    private CampaignProducer campaignProducer;
    @Inject @Events.Added
    private Event<Campaign> campaignAddEvent;

    public String doSave(){
        if( campaignProducer.isAddMode() ){
            campaignAddEvent.fire(campaignProducer.getSelectedCampaign());
        }
        return Pages.LIST_CAMPAIGNS;
    }

    public String doCancel(){
        return Pages.LIST_CAMPAIGNS;
    }


}
