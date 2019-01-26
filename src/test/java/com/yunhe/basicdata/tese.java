package com.yunhe.basicdata;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tese {
    private Integer id;
    private Integer pId;
    private String name;
    private List<tese> children;

    public tese() {

    }

    public tese(Integer id, Integer pId, String name) {
        super();
        this.id = id;
        this.pId = pId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<tese> getChildren() {
        return children;
    }

    public void setChildren(List<tese> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeTest [id=" + id + ", pId=" + pId + ", name=" + name
                + ", children=" + children + "]";
    }

    // 测试数据

    public static void main(String[] args) {
        List<tese> list = new ArrayList<tese>();
        Map<Integer, tese> map = new HashMap<Integer, tese>();

        tese terr1 = new tese(1, 0, "一级父节点");
        tese terr2 = new tese(2, 1, "一级1子节点");
        tese terr3 = new tese(3, 2, "一级2子节点");
        tese terr4 = new tese(4, 0, "二级父节点");
        tese terr5 = new tese(5, 4, "二级1子节点");
        tese terr6 = new tese(6, 4, "二级1子节点2");
        tese terr7 = new tese(7, 3, "一级3子节点");
        tese terr8 = new tese(8, 5, "二级2子节点");
        map.put(terr1.getId(), terr1);
        map.put(terr2.getId(), terr2);
        map.put(terr3.getId(), terr3);
        map.put(terr4.getId(), terr4);
        map.put(terr5.getId(), terr5);
        map.put(terr6.getId(), terr6);
        map.put(terr7.getId(), terr7);
        map.put(terr8.getId(), terr8);
        /*
         * List<TreeTest> li = getChildren(map,0,1);
         *
         * System.out.println(JSON.toJSON(li));
         */
        Map<Integer, List<tese>> treemap = new HashMap<Integer, List<tese>>();
        for (tese treeTest : map.values()) {
            List<tese> listTree = treemap.get(treeTest.getpId());
            if (listTree == null) {
                listTree = new ArrayList<tese>();
                listTree.add(treeTest);
                treemap.put(treeTest.getpId(), listTree);
            } else {
                List<tese> ordTree = treemap.get(treeTest.getpId());
                ordTree.add(treeTest);
                treemap.put(treeTest.getpId(), ordTree);
            }
        }
        List<tese> lists = new ArrayList<tese>();
        lists.add(terr1);
        List<tese> li = getChildren(lists, treemap);
        System.out.println(JSON.toJSON(li));
    }

    // 递归树
    public static List<tese> getChildren(List<tese> trees,
                                         Map<Integer, List<tese>> children) {
        List<tese> childrenTree = null;
        for (tese tree : trees) {
            // 获得子节点
            childrenTree = children.get(tree.getId());
            if (childrenTree != null) {
                // 添加子节点
                tree.setChildren(childrenTree);
                // 递归
                getChildren(tree.getChildren(), children);
            }
        }
        return childrenTree;
    }

}