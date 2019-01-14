package com.yunhe.basicdata.dao;

import com.yunhe.basicdata.entity.Commclass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类 Mapper 接口
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
public interface CommclassMapper extends BaseMapper<Commclass> {
    /**
     * <p>
     *   商品分类列表
     * <p/>
     * @return 商品列表
     */
    public List<Commclass>  query();
    /**
     * <p>
     *   增加商品分类前查重
     * <p/>
     * @param name 分类名称
     * @return 商品列表
     */
    public List<Commclass> sel(String name);
    /**
     * <p>
     *     添加商品分类
     * <p/>
     * @param ccDefault 要增加商品分类名
     * @return 无返回
     */
    public void add(String ccDefault);
    /**
     * <p>
     *   修改商品分类名字
     * <p/>
     * @param map 修改前分类名
     * @return 无返回
     */
    public void updateCommclass(Map map);
    /**
     * <p>
     *     删除商品分类
     * <p/>
     *
     * @param name 要删除的分类名
     * @return 无返回
     */
    public void deleteCommclass(String name);

}
