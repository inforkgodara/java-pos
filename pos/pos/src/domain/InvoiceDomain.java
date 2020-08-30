/**
 * @author inforkgodara
 */

package domain;

import java.sql.Timestamp;

public class InvoiceDomain {
    private long id;
    private String customer;
    private String contactNumber;
    private float amount;
    private float other;
    private float total;
    private String remarks;
    private String type;
    private Timestamp createdOn;

    
    public long getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public float getAmount() {
        return amount;
    }

    public float getOther() {
        return other;
    }

    public float getTotal() {
        return total;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getType() {
        return type;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setOther(float other) {
        this.other = other;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
    
    
}


