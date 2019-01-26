package com.yunhe.systemsetup.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.CharaManger;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Repository
public interface CharaMangerMapper extends BaseMapper<CharaManger> {
    //查看所有的角色
    public List<CharaManger> selectAll(Page page);

    /**
     * 插入新的角色

     */
    public int insertRole(CharaManger charaManger);
    //检查角色的名称
    public List<CharaManger> checkChar(CharaManger charaManger);



}
