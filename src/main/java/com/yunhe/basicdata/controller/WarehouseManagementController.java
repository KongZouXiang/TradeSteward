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
    @RequestMapping("/login")
    public ModelAndView Login(){
        return new ModelAndView("user_list") ;
    }

    /**
     * 分页查询仓库
     * @param pageSize 每页显示条数
     * @param pageNum 当前页
     * @param warehouseManagement 模糊查询
     * @return 查询后返回的数据
     */
    @RequestMapping("/select")
  public Map select(int pageSize, int pageNum,WarehouseManagement warehouseManagement){
        Map map=new HashMap();
        map=warehouseManagementService.selectWareList(pageSize, pageNum);
      return map;
  }

    /**
     * <>
     *     删除仓库
     * </>
     * @param id 要删除仓库的
     * @return 删除成功之后返回 success
     */
  @RequestMapping("/deletebyid")
  public String deleteByid(int id){
        warehouseManagementService.deleteByid(id);
        return "success";
  }

    /**
     * <>
     *     修改仓库
     * </>
     * @param warehouseManagement 要修改的数据
     * @return success
     */
  @RequestMapping("/update")
  public String uptate(WarehouseManagement warehouseManagement){
      warehouseManagementService.update(warehouseManagement);
      return "success";
  }

    /**
     * 根据id查找仓库
     * @param id 查找仓库的
     * @return 根据仓库id返回的数据
     */
  @RequestMapping("/selectByid")
    public Map selectByid(int id){
     WarehouseManagement warehouseManagement= warehouseManagementService.selectByid(id);
     Map map=new HashMap();
     map.put("data",warehouseManagement);
     return map;
  }

    /**
     * <>
     *     模糊查询
     * </>
     * @param data 要查询的信息
     * @return 根据data返回的数据
     */
  @RequestMapping("/vagueselect")
public Map vagueselect(String data){
     List list= warehouseManagementService.vagueselect1(data);
     Map map=new HashMap();
     map.put("data",list);
     return map;

}

}



