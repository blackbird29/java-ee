package de.dpunkt.myaktion.model;

import java.util.Currency;
import java.util.List;

/**
 * Created by blackbird on 10/18/15.
 */
public class Campaign {

    private String name;
    private Double targetAmount;
    private Double donationMinimum;
    private Double amountDonatedSoFar;
    private Account account;
    private Long id;
    private List<Donation> donations;
    private String currency = "EUR";

    public Campaign() {
        this.account = new Account();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Double getDonationMinimum() {
        return donationMinimum;
    }

    public void setDonationMinimum(Double donationMinimun) {
        this.donationMinimum = donationMinimun;
    }

    public Double getAmountDonatedSoFar() {
        return amountDonatedSoFar;
    }

    public void setAmountDonatedSoFar(Double amountDonatedSoFar) {
        this.amountDonatedSoFar = amountDonatedSoFar;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public String getCurrency(){
        return currency;
    }
}
