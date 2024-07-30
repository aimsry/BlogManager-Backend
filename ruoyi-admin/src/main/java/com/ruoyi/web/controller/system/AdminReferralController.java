package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Referral;
import com.ruoyi.system.service.IReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/admin/managerReferral")
public class AdminReferralController extends BaseController {
    @Autowired
    private IReferralService referralService;

    /**
     * 获取已审核内推信息列表
     */
    @GetMapping("/managerReviewedReferral/list")
    public TableDataInfo getReviewedReferrals(){
        startPage();
        List<Referral> list = referralService.selectReviewedReferrals();
        return getDataTable(list);
    }

    /**
     * 获取未审核内推信息列表
     * @return
     */
    @GetMapping("/managerUnreviewedReferral/list")
    public TableDataInfo getUnreviewedReferrals(){
        startPage();
        List<Referral> list = referralService.selectUnreviewedReferrals();
        return getDataTable(list);
    }

    /**
     * 获取已审核内推信息详情
     */
    @GetMapping(value = "/managerReviewedReferral/{referralID}")
    public AjaxResult getReviewedReferral(@PathVariable Integer referralID){
        return success(referralService.selectReferralById(referralID));
    }

    /**
     * 获取未审核内推详情
     */
    @GetMapping(value = "/managerUnreviewedReferral/{referralID}")
    public AjaxResult getUnreviewedReferral(@PathVariable Integer referralID){
        return success(referralService.selectReferralById(referralID));
    }

    /**
     * 删除已审核内推信息
     */
    @Log(title = "内推信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/managerReviewedReferral/{referralID}")
    public AjaxResult deleteReviewedReferral(@PathVariable Integer referralID){
        return toAjax( referralService.deleteReferral(referralID));
    }

    /**
     * 删除未审核内推信息
     */
    @DeleteMapping("/managerUnreviewedReferral/{referralID}")
    public AjaxResult deleteUnreviewedReferral(@PathVariable Integer referralID){
        return toAjax(referralService.deleteReferral(referralID));
    }

    /**
     * 按照jobTitle获取已审核内推
     */
    @GetMapping("/managerReviewedReferral")
    public TableDataInfo getReviewedReferralByJobTitle(@RequestParam String jobTitle){
        startPage();
        List<Referral>list = referralService.selectReviewedReferralByJobTitle(jobTitle);
        return getDataTable(list);
    }

    /**
     * 按照jobTitle获取未审核内推
     */
    @GetMapping("/managerUnreviewedReferral")
    public TableDataInfo getUnreviewedReferralByJobTitle(@RequestParam String jobTitle){
        startPage();
        List<Referral> list = referralService.selectUnreviewedReferralByJobTitle(jobTitle);
        return getDataTable(list);
    }

    /**
     * 审核未审核内推信息
     */
    @PutMapping("/managerUnreviewedReferral")
    public AjaxResult reviewUnreviewedReferral(@RequestBody Referral referral){
        referral.setReferral_status(1);
        return toAjax(referralService.updateReferral(referral));
    }
}
