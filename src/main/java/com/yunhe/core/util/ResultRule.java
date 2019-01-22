package com.yunhe.core.util;

/**
 * 增删改查规则
 */
public interface ResultRule {

    /**
     * 增加操作
     * 1:增加成功
     * 2:增加失败
     */
    String[] CREATE = {"增加成功", "增加失败"};

    /**
     * 更新操作
     * 1:更新成功
     * 2:更新失败
     */
    String[] UPDATA = {"更新成功", "更新失败"};

//    String[] Rem = {"查询成功", "查询失败"};

    /**
     * 删除操作
     * 1:删除成功
     * 2:删除失败
     */
    String[] DELETE = {"删除成功", "删除失败"};
}
