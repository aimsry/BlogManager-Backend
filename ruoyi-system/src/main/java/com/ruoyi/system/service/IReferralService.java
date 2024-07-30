package com.ruoyi.system.service;

import com.ruoyi.system.domain.Referral;

import java.sql.Ref;
import java.util.List;

public interface IReferralService {
    List<Referral> selectReferralList();
    Referral selectReferralById(Integer referralID);
    int insertReferral(Referral referral);
    int updateReferral(Referral referral);
    int deleteReferral(Integer referralID);
    List<Referral> selectReviewedReferrals();
    List<Referral> selectUnreviewedReferrals();
    List<Referral> selectReviewedReferralByJobTitle(String jobTitle);
    List<Referral> selectUnreviewedReferralByJobTitle(String jobTitle);

}
