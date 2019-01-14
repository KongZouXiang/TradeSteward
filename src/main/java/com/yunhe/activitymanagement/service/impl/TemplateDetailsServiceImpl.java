package com.yunhe.activitymanagement.service.impl;

import com.yunhe.activitymanagement.entity.TemplateDetails;
import com.yunhe.activitymanagement.dao.TemplateDetailsMapper;
import com.yunhe.activitymanagement.service.ITemplateDetailsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-10
 */
@Service
public class TemplateDetailsServiceImpl extends ServiceImpl<TemplateDetailsMapper, TemplateDetails> implements ITemplateDetailsService {

    @Resource
    TemplateDetailsMapper templateDetailsMapper;

    @Override
    public int insertTemplateDetails(TemplateDetails templateDetails) {

        return templateDetailsMapper.insert(templateDetails);
    }
}
