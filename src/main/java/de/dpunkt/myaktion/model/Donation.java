package de.dpunkt.myaktion.model;

/**
 * Created by blackbird on 10/18/15.
 */
public class Donation {

    private Double amount;
    private String donorName;
    private Boolean receiptsRequested;
    private Status status;
    private Account account;

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

    public Boolean getReceiptsRequested() {
        return receiptsRequested;
    }

    public void setReceiptsRequested(Boolean receiptsRequested) {
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
}
