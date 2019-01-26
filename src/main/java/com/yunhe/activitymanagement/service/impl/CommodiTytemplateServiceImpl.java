package com.yunhe.activitymanagement.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.dao.CommodiTytemplateMapper;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


/**
 * <p>
 * 商品模板 服务实现类
 * </p>
 *
 * @author 刘栋
 * @since 2019-01-07
 */
@Service
public class CommodiTytemplateServiceImpl extends ServiceImpl<CommodiTytemplateMapper, CommodiTytemplate> implements ICommodiTytemplateService {


    @Resource
    private CommodiTytemplateMapper commodiTytemplateMapper;

    @Override
    public IPage selectLikePage(int current, int size, CommodiTytemplate commodiTytemplate) {

        return commodiTytemplateMapper.selectPage(
                new Page<CommodiTytemplate>(current, size),
                new QueryWrapper<CommodiTytemplate>()
                        .like("ct_template_number", commodiTytemplate.getCtTemplateNumber())
                        .or()
                        .like("ct_tytemplate_name", commodiTytemplate.getCtTytemplateName()));
    }

    @Override
    public List<CommodiTytemplate> selectAll() {
        return commodiTytemplateMapper.selectAll();
    }
    /**
     * 增加商品模板
     */

    @Override
    public int insertCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateMapper.insert(commodiTytemplate);
    }

    /**
     * 删除
     */
    @Override
    public int deleteById(Serializable id) {
        return commodiTytemplateMapper.deleteById(id);
    }

    /**
     * 获取模板id
     * @param commodiTytemplate
     * @return
     */
    @Override
    public int huoquid(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateMapper.huoquid(commodiTytemplate);
    }


    /**
     * 修改
     */
    @Override
    public int updateCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateMapper.updateById(commodiTytemplate);
    }


    /**
     * <p>
     * 查询数据
     * </P>
     *
     * @return 商品模板表：查询所有模板的结果集
     */
/*    @Override
    public List<CommodiTytemplate> selectAllCt() {
        return commodiTytemplateMapper.selectAllCt();
    }*/


    /**
     * 根据模板的id查询出来模板的详情
     * @param id
     * @return
     */
    @Override
    public CommodiTytemplate selectById(int id) {
        CommodiTytemplate moban = commodiTytemplateMapper.selectById(id);
        return moban;
    }

}


