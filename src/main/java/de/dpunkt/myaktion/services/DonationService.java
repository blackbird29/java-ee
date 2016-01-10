package de.dpunkt.myaktion.services;

import de.dpunkt.myaktion.model.Donation;

import java.util.List;

/**
 * Created by blackbird on 12/11/15.
 */
public interface DonationService {

    List<Donation> getDonationList(Long campaignId);

    void addDonation(Long campaignId, Donation donation);

    void transferDonations();
}
