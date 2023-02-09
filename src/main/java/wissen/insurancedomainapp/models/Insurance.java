package wissen.insurancedomainapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="insurance")
public class Insurance {
    @Id @Column(name="policy_id")
    private int policyId;

    @Column(name="name")
    private String name;

    @Column(name="policy_amt")
    private double policyAmt;

    @Column(name="emi")
    private double emi;

    public Insurance() {}

    public Insurance(int policyId, String name, double policyAmt, int emi) {
        this.policyId = policyId;
        this.name = name;
        this.policyAmt = policyAmt;
        this.emi = emi;
    }

    // GETTERS FOR [Insurance] CLASS
    public int getPolicyId() {
        return this.policyId;
    }

    public String getName() {
        return this.name;
    }

    public double getPolicyAmt() {
        return this.policyAmt;
    }

    public double getEmi() {
        return this.emi;
    }

    // SETTERS FOR [Insurance] CLASS
    public void setName(String name) {
        this.name = name;
    }

    public void setPolicyAmt(double amt) {
        this.policyAmt = amt;
    }

    public void setEmi(double amt) {
        this.emi = amt;
    }

    public String toString() {
        return "Policy ID: " + policyId
                + "\nName: " + name
                + "\nPolicy Amount: " + policyAmt
                + "\nEMI: " + emi;
    }
}
