package com.yunhe.systemsetup.service;

import com.yunhe.systemsetup.entity.CharaManger;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
public interface ICharaMangerService extends IService<CharaManger> {
    /**s
     *
     * @return List<CHaraManger><
     * 查看所有的角色
     */
    public List<CharaManger> selectAll();
}
