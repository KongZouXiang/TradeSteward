package com.yunhe.systemsetup.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.CharaManger;
import com.yunhe.systemsetup.dao.CharaMangerMapper;
import com.yunhe.systemsetup.service.ICharaMangerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author 刘延奇,heyuji
 * @since 2019-01-02
 */
@Service
public class CharaMangerServiceImpl extends ServiceImpl<CharaMangerMapper, CharaManger> implements ICharaMangerService {

    @Autowired
    public CharaMangerMapper charaMangerMapper;

    @Override
    public List<CharaManger> selectAll(Page page) {
        return charaMangerMapper.selectAll(page);
    }

    @Override
    public int insertRole(CharaManger charaManger) {
        return charaMangerMapper.insertRole(charaManger);
    }

    @Override
    public Boolean checkRole(CharaManger charaManger) {
        List<CharaManger> list=charaMangerMapper.checkChar(charaManger);
        Boolean b =false;
        if (list.size()==0){
            b=true;
        }
        return b;
    }



    public CharaMangerMapper getCharaMangerMapper() {
        return charaMangerMapper;
    }

    public void setCharaMangerMapper(CharaMangerMapper charaMangerMapper) {
        this.charaMangerMapper = charaMangerMapper;
    }
}
