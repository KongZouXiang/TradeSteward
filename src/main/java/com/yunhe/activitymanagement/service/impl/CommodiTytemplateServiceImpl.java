package com.yunhe.activitymanagement.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.activitymanagement.entity.CommodiTytemplate;
import com.yunhe.activitymanagement.dao.CommodiTytemplateMapper;
import com.yunhe.activitymanagement.service.ICommodiTytemplateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map queryLikeList(int current, int size, CommodiTytemplate commodiTytemplate) {
        Page page=new Page(current,size);
        List<CommodiTytemplate> commodilist = commodiTytemplateMapper.selectAllPage(page);
        Map map = new HashMap();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("commodiTytemplate",commodiTytemplate);
        map.put("commodilist", commodilist);
        return map;
    }

    /**
     * 增加商品模板
     * */

      @Override
      public int insertCt(CommodiTytemplate commodiTytemplate) {
          return commodiTytemplateMapper.insert(commodiTytemplate);
      }
    /**
     * 删除
     * */
    @Override
    public int deleteById(Serializable id) {
        return commodiTytemplateMapper.deleteById(id);
    }

/**
 * 修改
* */
    @Override
    public int updateCt(CommodiTytemplate commodiTytemplate) {
        return commodiTytemplateMapper.updateById(commodiTytemplate);
    }



    /**
     * <P>
     *     查询数据
     * </P>
     * @return 商品模板表：查询所有模板的结果集
     */
/*    @Override
    public List<CommodiTytemplate> selectAllCt() {
        return commodiTytemplateMapper.selectAllCt();
    }*/



    @Override
    public CommodiTytemplate selectById(int id) {
        CommodiTytemplate moban = commodiTytemplateMapper.selectById(id);
        return moban;
    }

}


