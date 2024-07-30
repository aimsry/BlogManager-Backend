package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Referral;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReferralMapper {
    /**
     * 分页查询内推信息
     */
    List<Referral> selectReferralList();

    /**
     * 按照jobTitle分页查询已经审核的内推
     * @param jobTitle 工作标题
     */
    List<Referral> selectReviewedReferralByJobTitle(@Param("jobTitle") String jobTitle);

    /**
     * 按照jobTitle分页查询未审核的内推
     */
    List<Referral> selectUnreviewedReferralByJobTitle(@Param("jobTitle") String jobTitle);
    /**
     * 按照内推信息ID获取详细信息
     * @param referralID 内推信息ID
     * @return 内推信息的详细内容
     */
    Referral selectReferralById( @Param("referralID") Integer referralID);

    /**
     * 新增内推信息
     * @param referral 新的内推信息
     * @return 新增成功返回1
     */
    int insertReferral(Referral referral);

    /**
     * 更新内推信息
     * @param referral 要被更新的内推信息
     * @return 更新成功返回1
     */
    int updateReferral(Referral referral);

    /**
     * 按照ID删除内推信息
     * @param referralID 将被删除的内推信息ID
     * @return 删除成功返回1
     */
    int deleteReferralById(@Param("referralID") Integer referralID);

    /**
     * 分页查询已审核内推信息
     */
    List<Referral> selectReviewedReferrals();

    /**
     * 分页查询未审核内推信息
     */
    List<Referral> selectUnreviewedReferrals();



}
