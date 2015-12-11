package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Campaign;
import de.dpunkt.myaktion.model.Donation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by blackbird on 12/11/15.
 */
@Stateless
public class DonationServiceBean implements DonationService {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Donation> getDonationList(Long campaignId) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
        List<Donation> donations = managedCampaign.getDonations();
        donations.size();
        return donations;
    }

    @Override
    public void addDonation(Long campaignId, Donation donation) {
        Campaign managedCampaign = entityManager.find(Campaign.class, campaignId);
        donation.setCampaign(managedCampaign);
        entityManager.persist(donation);
    }
}
