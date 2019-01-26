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
 * @author heyuji
 * @since 2019-01-02
 */
@Repository
public interface EmployMapper extends BaseMapper<Employ> {

    public List<Employ> selectPageEmploy(Page page, Employ employ);

    //插入员工
     public  int insertEmploy(Employ employ);

    //验证用户名是否存在,返回id

    public String  checkemname(Employ employ);

    //修改密码

    public int updatePass(Employ employ);

    //修改用户信息

    public int updatemess(Employ employ);


    /**
     * 查询出员工对应的板块
     *
     * @author 孔邹祥
     */
    List<String> selectEmployPlate(Integer id);

}
