package com.yunhe.basicdata.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.basicdata.entity.CommodityList;
import com.yunhe.basicdata.dao.CommodityListMapper;
import com.yunhe.basicdata.service.ICommodityListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品列表 服务实现类
 * </p>
 *
 * @author 李恒逵, 唐凯宽
 * @since 2019-01-02
 */
@Service
public class CommodityListServiceImpl extends ServiceImpl<CommodityListMapper, CommodityList> implements ICommodityListService {
    @Resource
    CommodityListMapper commodityListMapper;
    /**
     * 查询列表 分页
     * @param current       当前页
     * @param size          每页的条数
     * @param commodityList 查询商品的实体类
     * @return 返回分页的信息
     */
    @Override
    public Map selectAllcommList(int current, int size,CommodityList commodityList) {
        Page page=new Page(current,size);
        List<CommodityList> comlist = commodityListMapper.selectAllCommmList(page);
        Map map = new HashMap();
        map.put("total", page.getTotal());
        map.put("pages", page.getPages());
        map.put("commodityList",commodityList);
        map.put("comlist", comlist);
        return map;
    }


    /**
     * 增加商品的信息
     *
     * @param commodityList 增加商品的实体类
     * @return 返回增加后的商品信息
     */
    @Override
    public int insertComm(CommodityList commodityList) {
        return commodityListMapper.insertComm(commodityList);
    }

    /**
     * 查询用户的详细信息
     *
     * @param id 查询用户的id
     * @return 根据id查询的信息
     */
    @Override
    public CommodityList selectCommById(int id) {
        return commodityListMapper.selectCommById(id);
    }

    /**
     * 更改商品的信息
     *
     * @param commodityList 更改商品的实体类
     * @return 返回更改后的信息
     */
    @Override
    public int updateComm(CommodityList commodityList) {
        return commodityListMapper.updateComm(commodityList);
    }

    /**
     * 删除商品的信息
     *
     * @param commodityList 删除商品的实体类
     * @return 无返回
     */
    @Override
    public int deleteComm(CommodityList commodityList) {
        return commodityListMapper.deleteComm(commodityList);
    }

    /**
     * 模糊查询
     *
     * @param data 模糊查询的条件
     * @return 返回模糊查询的信息
     */
    @Override
    public List<CommodityList> selectCommstlist(String data) {
        List<CommodityList> commodityLists = (List<CommodityList>) commodityListMapper.selectList(new QueryWrapper<CommodityList>().like("cl_name", data).or().like("cl_scan", data));
        return commodityLists;
    }

    @Override
    public Map selectList() {
        List<CommodityList> list = commodityListMapper.selectList(new QueryWrapper<>());
        Map<String, Object> map = new HashMap<>();
        map.put("list",list);
        return map;
    }

}
