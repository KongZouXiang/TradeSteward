package com.yunhe.systemsetup.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.CharaManger;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author 贺裕基
 * @since 2019-01-02
 */
public interface ICharaMangerService extends IService<CharaManger> {
    /**s
     *
     * @return List<CHaraManger><
     * 查看所有的角色
     */
    public List<CharaManger> selectAll(Page page);

    /**
     * @return int
     * 插入新的角色
     */
    public int insertRole(CharaManger charaManger);
    /**
     *
     * 检查角色的名称
     */
    public Boolean checkRole(CharaManger charaManger);


}
