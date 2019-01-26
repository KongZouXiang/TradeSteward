package com.yunhe.activitymanagement.service;

import com.yunhe.activitymanagement.entity.PackageCommodity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.activitymanagement.entity.TemplateDetails;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-08
 */
public interface IPackageCommodityService extends IService<PackageCommodity> {
    int insertTemplateDetails(PackageCommodity packageCommodity);
}
