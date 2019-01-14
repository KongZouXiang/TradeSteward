package com.yunhe.systemsetup.service.impl;

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
    public List<CharaManger> selectAll() {
        return charaMangerMapper.selectAll();
    }

    public CharaMangerMapper getCharaMangerMapper() {
        return charaMangerMapper;
    }

    public void setCharaMangerMapper(CharaMangerMapper charaMangerMapper) {
        this.charaMangerMapper = charaMangerMapper;
    }
}
