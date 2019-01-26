package com.yunhe.basicdata.controller;

import com.yunhe.basicdata.entity.WarehouseManagement;
import com.yunhe.basicdata.service.impl.WarehouseManagementServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * 仓库管理 前端控制器
 * </p>
 *
 * @author 李恒奎, 唐凯宽
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/basicdata/warehouse-management")
public class WarehouseManagementController {
    @Resource
    WarehouseManagementServiceImpl warehouseManagementService;

    /**
     * 跳转列表页面
     *
     * @return 列表页面
     */
    @RequestMapping("/login")
    public ModelAndView Login() {
        return new ModelAndView("basicdata/admin-list.html");
    }

    /**
     * 跳转增加仓库页面
     *
     * @return 增加仓库页面
     */
    @RequestMapping("/addWare")
    public ModelAndView addWare() {
        return new ModelAndView("basicdata/admin-add.html");
    }

    /**
     * 跳转修改仓库页面
     *
     * @return 修改仓库页面
     */
    @RequestMapping("/UpdateWareHouse")
    public ModelAndView UpdateWareHouse(int id) {
        System.out.println("id===>" + id);
        ModelAndView mv = new ModelAndView();
        WarehouseManagement warehouseManagemenst = warehouseManagementService.selectByid(id);
        mv.addObject("whm", warehouseManagemenst);
        mv.setViewName("basicdata/editWareHouse");
        return mv;
    }

    /**
     * 分页查询仓库
     *
     * @param pageSize            每页显示条数
     * @param pageNum             当前页
     * @param data 模糊查询
     * @return 查询后返回的数据
     */
    @RequestMapping("/select")
    public Map select(String data,int pageSize, int pageNum) {
        Map map = new HashMap();
        map = warehouseManagementService.selectWareList(data,pageSize, pageNum);
        return map;
    }
    /**
     * <>
     * 删除仓库
     * </>
     *
     * @param id 要删除仓库的
     * @return 删除成功之后返回 success
     */
    @RequestMapping("/deletebyid")
    public String deleteByid(int id) {
        warehouseManagementService.deleteByid(id);
        return "success";
    }

    /**
     * <>
     * 修改仓库
     * </>
     *
     * @param warehouseManagement 要修改的数据
     * @return success
     */
    @RequestMapping("/update")
    public Integer uptate(WarehouseManagement warehouseManagement) {
        System.out.println("id"+warehouseManagement.getWmName());
        return warehouseManagementService.update(warehouseManagement);
    }

    /**
     * 根据id查找仓库
     *
     * @param id 查找仓库的
     * @return 根据仓库id返回的数据
     */
    @RequestMapping("/selectByid")
    public Map selectByid(int id) {
        System.out.println("id===" + id);
        WarehouseManagement warehouseManagement = warehouseManagementService.selectByid(id);
        Map map = new HashMap();
        map.put("data", warehouseManagement);
        return map;
    }
    @RequestMapping("/selectByi")
    public ModelAndView selectByi(int id) {
        ModelAndView mv=new ModelAndView();
        System.out.println("id===" + id);
        WarehouseManagement warehouseManagement = warehouseManagementService.selectByid(id);
        mv.addObject("ss",warehouseManagement);
        return mv;
    }

    /**
     * <>
     * 模糊查询
     * </>
     *
     * @param data 要查询的信息
     * @return 根据data返回的数据
     */
    @RequestMapping("/vagueselect")
    public Map vagueselect(String data) {
        Map map = new HashMap();
        map = warehouseManagementService.vagueselect1(data);
        return map;
    }

    /**
     * 增加仓库
     *
     * @param warehouseManagement 增加仓库的数据
     * @return 视图
     */
    @RequestMapping("/addWarehouse")
    public Integer addWarehouse(WarehouseManagement warehouseManagement) {
        System.out.println("asd===" + warehouseManagement);
        return warehouseManagementService.addWarehouse(warehouseManagement);
    }
  /*查询仓库 勿删*/
    @RequestMapping("/selectware")
    public Map selectwarelist(){
       List<WarehouseManagement> warelist= warehouseManagementService.selectware();
       Map map=new HashMap();
       map.put("warelist",warelist);
       return map;
    }
}




