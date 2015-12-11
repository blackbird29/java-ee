package de.dpunkt.myaktion.model;

import javax.persistence.*;

/**
 * Created by blackbird on 10/18/15.
 */
@Entity
public class Donation {

    @GeneratedValue
    @Id
    private Long id;

    private Double amount;
    private String donorName;
    private Boolean receiptsRequested;
    private Status status;
    @Embedded
    private Account account;
    @ManyToOne
    private Campaign campaign;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Donation() {
        this.account = new Account();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Boolean getReceiptRequested() {
        return receiptsRequested;
    }

    public void setReceiptRequested(Boolean receiptsRequested) {
        this.receiptsRequested = receiptsRequested;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
