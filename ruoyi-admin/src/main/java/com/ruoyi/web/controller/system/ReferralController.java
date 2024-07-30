package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Referral;
import com.ruoyi.system.service.IReferralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/referrals")
public class ReferralController extends BaseController{
    @Autowired
    private IReferralService referralService;

    /**
     * 新增通知公告
     */
    @Log(title = "内推信息",businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult addReferral(@Validated @RequestBody Referral referral) {
        return toAjax(referralService.insertReferral(referral));
    }

    /**
     * 获取已审核内推通知列表
     */
    @GetMapping("/list")
    public TableDataInfo getReviewedReferralList() {
        startPage();
       List<Referral> list = referralService.selectReviewedReferrals();
       return getDataTable(list);
    }
    /**
     * 根据内推信息编号获得内推信息详细信息
     */
    @GetMapping(value = {"/{referralID}"})
    public AjaxResult getReferral(@PathVariable Integer referralID){
        return success(referralService.selectReferralById(referralID));
    }

    /**
     * 根据jobTitle查询内推信息
     */
    @GetMapping
    public TableDataInfo getReferralByJobTitle(@RequestParam String jobTitle,@RequestParam String address){
        startPage();
        List<Referral>list = referralService.selectReviewedReferralByJobTitle(jobTitle,address);
        return getDataTable(list);
    }
}
