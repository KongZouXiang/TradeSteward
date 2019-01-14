package com.yunhe.activitymanagement.service;

import com.yunhe.activitymanagement.entity.TemplateDetails;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-10
 */
public interface ITemplateDetailsService extends IService<TemplateDetails> {

    int insertTemplateDetails(TemplateDetails templateDetails);
}
