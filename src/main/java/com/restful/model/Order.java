package com.restful.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty
    private String custmer;

    private String address;

    @JsonProperty("bill-amount")
    private String amount;

    public String getCustmer() {
        return custmer;
    }
    public void setCustmer(String custmer) {
        this.custmer = custmer;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "custmer='" + custmer + '\'' +
                ", address='" + address + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}
