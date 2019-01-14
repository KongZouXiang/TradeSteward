package com.yunhe.systemsetup.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.Employ;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 员工管理 Mapper 接口
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Repository
public interface EmployMapper extends BaseMapper<Employ> {
    public List<Employ> selectPageEmploy(Page page, Employ employ);

    public  void  insertEmploy(Employ employ);

}
