package com.yunhe.activitymanagement.service.impl;

import com.yunhe.activitymanagement.dao.TemplateDetailsMapper;
import com.yunhe.activitymanagement.entity.PackageCommodity;
import com.yunhe.activitymanagement.dao.PackageCommodityMapper;
import com.yunhe.activitymanagement.entity.TemplateDetails;
import com.yunhe.activitymanagement.service.IPackageCommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-08
 */
@Service
public class PackageCommodityServiceImpl extends ServiceImpl<PackageCommodityMapper, PackageCommodity> implements IPackageCommodityService {
    @Resource
    PackageCommodityMapper packageCommodityMapper;

    @Override
    public int insertTemplateDetails(PackageCommodity packageCommodity) {

        return packageCommodityMapper.insert(packageCommodity);
    }
}
