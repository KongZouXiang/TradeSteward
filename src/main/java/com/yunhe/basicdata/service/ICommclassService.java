package com.yunhe.basicdata.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yunhe.basicdata.entity.Commclass;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author 李恒奎,唐凯宽
 * @since 2019-01-02
 */
public interface ICommclassService extends IService<Commclass> {
    /**
     * <p>
     *   商品分类列表
     * <p/>
     * @return 商品列表
     */
public List<Commclass> query();
    /**
     * <p>
     *   增加商品分类前查重
     * <p/>
     * @param name 分类名称
     * @return 商品列表
     */
    List<Commclass> sel(String name);
    /**
     * <p>
     *     添加商品分类
     * <p/>
     * @param ccdefault 要增加商品分类名
     * @return 无返回
     */
    public void add(Commclass commclass);
    /**
     * <p>
     *   修改商品分类名字
     * <p/>
     * @param map 修改前后分类
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

    /**
     * 根据id查name
     * @param name
     * @return id
     */
    int selectidbyname(String name) throws Exception;
}
