package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.Referral;
import com.ruoyi.system.mapper.ReferralMapper;
import com.ruoyi.system.service.IReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Ref;
import java.util.List;

@Service
public class ReferralServiceImpl implements IReferralService {
    @Autowired
    private ReferralMapper referralMapper;
    @Override
    public List<Referral> selectReferralList() {
        return referralMapper.selectReferralList();
    }

    @Override
    public Referral selectReferralById(Integer referralID) {
        return referralMapper.selectReferralById(referralID);
    }

    @Override
    public int insertReferral(Referral referral) {
        return referralMapper.insertReferral(referral);
    }
    @Override
    public int updateReferral(Referral referral) {
        return referralMapper.updateReferral(referral);
    }
    @Override
    public int deleteReferral(Integer referralID){
        return referralMapper.deleteReferralById(referralID);
    }
    @Override
    public List<Referral> selectReviewedReferrals(){
        return referralMapper.selectReviewedReferrals();
    }
    @Override
    public List<Referral> selectUnreviewedReferrals(){
        return referralMapper.selectUnreviewedReferrals();
    }
    @Override
    public List<Referral> selectReviewedReferralByJobTitle(String jobTitle){
        return referralMapper.selectReviewedReferralByJobTitle(jobTitle);
    }
    @Override
    public List<Referral> selectUnreviewedReferralByJobTitle(String jobTitle){
        return referralMapper.selectUnreviewedReferralByJobTitle(jobTitle);
    }
}
