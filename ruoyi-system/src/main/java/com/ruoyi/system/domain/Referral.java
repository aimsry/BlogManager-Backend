package com.ruoyi.system.domain;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
@Data
@Getter
@Setter
public class Referral {
    private int referralID;
    private String companyName;
    private String jobTitle;
    private String address;
    private String salary;
    private String contactNumber;
    private String contactName;
    private String techRquirement;
    private Date startTime;
    private Date endTime;
    private int referral_status;
    public Referral(){
        referral_status = 0;
    }
    public Referral(int referralID,String companyName,String jobTitle,String address,String salary,
                    String contactNumber,String contactName,String techRquirement,Date startTime,Date endTime){
        this.referralID = referralID;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.address = address;
        this.salary = salary;
        this.contactNumber = contactNumber;
        this.contactName = contactName;
        this.techRquirement = techRquirement;
        this.startTime = startTime;
        this.endTime = endTime;
        this.referral_status = 0;
    }

}
