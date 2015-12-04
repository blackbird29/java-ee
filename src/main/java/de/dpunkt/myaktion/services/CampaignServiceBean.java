package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.util.Log;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by blackbird on 12/2/15.
 */
@RequestScoped
public class CampaignServiceBean implements CampaignService {

    @Inject
    @Log.TecLog
    private Logger logger;

    @Override
    public List<Campaign> getAllCampaigns(){
        logger.log(Level.INFO, "All campaigns retrieved","Successful");
        return new LinkedList<>();
    }

}
