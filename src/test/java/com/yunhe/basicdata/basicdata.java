package com.yunhe.basicdata;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class basicdata {
    private Integer id ;
    private Integer pId ;
    private String name;
    private List<basicdata> children;
    public basicdata() {

    }
    public basicdata(Integer id, Integer pId, String name) {
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


    public List<basicdata> getChildren() {
        return children;
    }
    public void setChildren(List<basicdata> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeTest [id=" + id + ", pId=" + pId + ", name=" + name
                + ", children=" + children + "]";
    }


    //测试数据

    public static void main(String[] args) {
        Map<Integer, basicdata> map = new HashMap<Integer, basicdata>();

        basicdata terr1 = new basicdata(1,0,"一级父节点");
        basicdata terr2 = new basicdata(2,1,"一级1子节点");
        basicdata terr3 = new basicdata(3,2,"一级2子节点");
        basicdata terr4 = new basicdata(4,0,"二级父节点");
        basicdata terr5 = new basicdata(5,4,"二级1子节点");
        basicdata terr6 = new basicdata(6,4,"二级1子节点2");
        basicdata terr7 = new basicdata(7,3,"一级3子节点");
        basicdata terr8 = new basicdata(8,5,"二级2子节点");
        map.put(terr1.getId(), terr1);
        map.put(terr2.getId(), terr2);
        map.put(terr3.getId(), terr3);
        map.put(terr4.getId(), terr4);
        map.put(terr5.getId(), terr5);
        map.put(terr6.getId(), terr6);
        map.put(terr7.getId(), terr7);
        map.put(terr8.getId(), terr8);
        List<basicdata> li =  getChildren(map,0,1);

        System.out.println(JSON.toJSON(li));
    }

    //递归树
    public static List<basicdata> getChildren(Map<Integer, basicdata> trees, Integer id, Integer leve){
        List<basicdata> list = new ArrayList<basicdata>();

        for (basicdata tree : trees.values()) {
            if(id == tree.getpId()){
                System.out.println("-递归" + tree.toString());
                List<basicdata> chidren = getChildren(trees,tree.getId(),++leve);
                list.add(tree);//本身
                tree.setChildren(chidren);//子节点
                leve--;
            }

        }
        return list;
    }





}