package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;

import java.util.List;

/**
 * Created by blackbird on 12/2/15.
 */
public interface CampaignService {

    Campaign getCampaign(Long campaignId);

    List<Campaign> getAllCampaigns();

    Campaign addCampaign(Campaign campaign);

    void deleteCampaign(Campaign campaign);

    void deleteCampaign(Long campaignId);

    Campaign updateCampaign(Campaign campaign);

}
