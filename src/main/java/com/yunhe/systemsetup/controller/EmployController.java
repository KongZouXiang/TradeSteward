package com.yunhe.systemsetup.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.yunhe.redis.service.RedisService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.json.JSONException;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yunhe.systemsetup.entity.Employ;
import com.yunhe.systemsetup.service.impl.EmployServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工管理 前端控制器
 * </p>
 *
 * @author heyuji
 * @since 2019-01-02
 */
@RestController
@RequestMapping("/systemsetup/employ")
public class EmployController {
    @Autowired
    private EmployServiceImpl employService;
    @Autowired
    private RedisService redisService;


    @RequestMapping(value = "/selectpage")
    public Map selectPage(Integer pageSize, Integer pageNum, Employ employ){
        ;
        System.out.println(employ.getEmUsername());
        Page page = new Page();
        page.setSize(pageSize);
        page.setCurrent(pageNum);

        List<Employ> list =employService.selectPageEmploy(page,employ);
        int total = (int) page.getTotal();
        System.out.println(list);
        System.out.println( );
        Map map = new HashMap();
        map.put("total",total);
        map.put("page",page);
        map.put("list",list);
        map.put("totalPage",page.getPages());
        return map;
    }

    @RequestMapping(value = "/list")
    public ModelAndView toList(){
        return new ModelAndView("/systemsetup/admin" );
    }

    @RequestMapping(value = "/addempl")
    public ModelAndView toAdd(){
        return new ModelAndView("/systemsetup/admin-add");
    }

    /**
     * 插入员工信息
     * @param employ
     * @return
     */
    @RequestMapping(value = "/insertempl")
    public int inserEmploy(Employ employ){
        System.out.println("进入Controleer");
        System.out.println(employ.getEmRole().equals("财务员"));
        if (employ.getEmRole().equals("管理员")){
            employ.setCh_id(1);
        }else if(employ.getEmRole().equals("财务员")){
            employ.setCh_id(2);
        }else if(employ.getEmRole().equals("仓管员")){
            employ.setCh_id(3);
        }else if (employ.getEmRole().equals("销售员")){
            employ.setCh_id(4);
        }
        int a =employService.insertEmploy(employ);
        return a;
    }
    /**
     * 修改密码
     */
    @RequestMapping(value = "/updatepwd")
    public ModelAndView updatepwd(Employ employ,HttpSession session) {
        System.out.println("进入Controleer");
        Employ employ1=employService.selectEmployById(employ.getId());
        session.setAttribute("employ",employ1);
        return new ModelAndView("/systemsetup/admin-pwd-update");
    }
    /**
     * 修改密码提交
     *
     */
    @RequestMapping(value = "/pwd")
    public int pwd(Employ employ) {
        System.out.println("进入Controleerk修改密码");
       int a =employService.updatePassword(employ);
        return a;
    }
    /**
     * 删除员工
     */
    @RequestMapping(value ="/deleteempl")
    public String deleteEmploy(Employ employ){
        employService.removeById(employ.getId());
        return null;
    }
    /**
     * 验证用户名是否存在
     */
    @RequestMapping(value = "/checkname")
    public Boolean checkname(Employ employ){
        Boolean b=employService.checkname(employ);
        return b;
    }
    /**
     *修改员工信息
     *
     */
    @RequestMapping(value = "/updateempl")
    public ModelAndView updateempl(int id,HttpSession session){
        Employ employ = employService.selectEmployById(id);
        session.setAttribute("employ",employ);
        return new ModelAndView("systemsetup/admin-edit");
    }
    /**
     * 修改员工信息提交
     */
    @RequestMapping(value = "/submitupdate")
    public int submitupdate(Employ employ){
        System.out.println("修改员工信息进入controller");
        if (employ.getEmRole().equals("管理员")){
            employ.setCh_id(1);
        }else if(employ.getEmRole().equals("财务员")){
            employ.setCh_id(2);
        }else if(employ.getEmRole().equals("仓管员")){
            employ.setCh_id(3);
        }else if (employ.getEmRole().equals("销售员")){
            employ.setCh_id(4);
        }
        int a =employService.updateMessage(employ);
        return a;
    }
    /**
     * 验证码发送
     */
    @RequestMapping(value = "/smsSend")
    public void smsSend(String phone){
        employService.createSmsCod(phone);
    }
    /**
     * 验证码校验
     */
    @RequestMapping(value = "/checkSend")
    public boolean checkSend(String phone,String num){
       String checknum=redisService.get(phone);
        System.out.println(checknum);
       if (checknum.equals(num)){
           return true;
       }else {
           return false;
       }

    }


    //导出Excel
    /**
     * <P>
     *      Excel导出
     * </P>
     * @param response 响应
     * @return  Excel导出到本地
     * @throws IOException
     */
    @RequestMapping("/export")
    public String createExcel(HttpServletResponse response) throws IOException {
        //获取查询结果的数据,只要对其进行封装就行了
        List<Employ> newlist = employService.list();
        System.out.println("数据行数："+newlist.size());
        //数据封装，这里的map之所以敢这样add是因为这里的add顺序和hql中的select字段顺序是一样的，总共就查询那么多字段
        List<Map<String,Object>> solist = new ArrayList();
        for(Employ obj:newlist){
            //每次循环都要重新new一个map，表示不同对象
            System.out.println("employ的第一个字段"+obj.getId());
            Map<String,Object> map = new HashMap();
            map.put("id", obj.getId());
            map.put("emUsername",obj.getEmUsername());
            map.put("emPassword",obj.getEmPassword());
            map.put("emRealname",obj.getEmRealname());
            map.put("emRole",obj.getEmRepo());
            map.put("emSex",obj.getEmSex());
            map.put("emPhone",obj.getEmPhone());
            map.put("emEmail",obj.getEmEmail());
            map.put("emStatus",obj.getEmStatus());
            map.put("emAddress",obj.getEmAddress());

            solist.add(map);
        }
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet=wb.createSheet("报表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1=sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell=row1.createCell(0);

        // 1.生成字体对象
        HSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("新宋体");

        // 2.生成样式对象，这里的设置居中样式和版本有关，我用的poi用HSSFCellStyle.ALIGN_CENTER会报错，所以用下面的
        HSSFCellStyle style = wb.createCellStyle();
        //设置居中样式
        /*style.setAlignment(HSSFCellStyle.ALIGN_CENTER);*/
        // 调用字体样式对象
        style.setFont(font);
        style.setWrapText(true);
        /*style.setAlignment(HorizontalAlignment.CENTER);//设置居中样式*/

        // 3.单元格应用样式
        cell.setCellStyle(style);

        //设置单元格内容
        cell.setCellValue("报表");
        //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));

        //在sheet里创建第二行
        HSSFRow row2=sheet.createRow(1);
        //创建单元格并设置单元格内容及样式
        HSSFCell cell0=row2.createCell(0);
        cell0.setCellStyle(style);
        cell0.setCellValue("序号");

        HSSFCell cell1=row2.createCell(1);
        cell1.setCellStyle(style);
        cell1.setCellValue("用户名");

        HSSFCell cell2=row2.createCell(2);
        cell2.setCellStyle(style);
        cell2.setCellValue("密码");


        HSSFCell cell3=row2.createCell(3);
        cell3.setCellStyle(style);
        cell3.setCellValue("姓名");

        HSSFCell cell4=row2.createCell(4);
        cell4.setCellStyle(style);
        cell4.setCellValue("角色");

        HSSFCell cell5=row2.createCell(5);
        cell5.setCellStyle(style);
        cell5.setCellValue("性别");

        HSSFCell cell6=row2.createCell(6);
        cell6.setCellStyle(style);
        cell6.setCellValue("电话");

        HSSFCell cell7=row2.createCell(7);
        cell7.setCellStyle(style);
        cell7.setCellValue("邮箱");

        HSSFCell cell8=row2.createCell(8);
        cell8.setCellStyle(style);
        cell8.setCellValue("态度");

        HSSFCell cell9=row2.createCell(9);
        cell9.setCellStyle(style);
        cell9.setCellValue("地址");
        //单元格宽度自适应
        sheet.autoSizeColumn((short)3);
        sheet.autoSizeColumn((short)4);
        sheet.autoSizeColumn((short)5);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        //宽度自适应可自行选择自适应哪一行，这里写在前面的是适应第二行，写在后面的是适应第三行
        for (int i = 0; i < solist.size(); i++) {
            //单元格宽度自适应
            sheet.autoSizeColumn((short)0);
            sheet.autoSizeColumn((short)1);
            sheet.autoSizeColumn((short)2);
            //从sheet第三行开始填充数据
            HSSFRow rowx=sheet.createRow(i+2);
            Map<String,Object> map = solist.get(i);
            //这里的hospitalid,idnumber等都是前面定义的全局变量
            HSSFCell cell00=rowx.createCell(0);
            cell00.setCellStyle(style);
            cell00.setCellValue((Integer) map.get("id"));

            HSSFCell cell01=rowx.createCell(1);
            cell01.setCellStyle(style);
            cell01.setCellValue((String) map.get("emUsername"));

            HSSFCell cell02=rowx.createCell(2);
            cell02.setCellStyle(style);
            cell02.setCellValue((String) map.get("emPassword"));

            HSSFCell cell03=rowx.createCell(3);
            cell03.setCellStyle(style);
            cell03.setCellValue((String) map.get("emRealname"));

            HSSFCell cell04=rowx.createCell(4);
            cell04.setCellStyle(style);
            cell04.setCellValue((String) map.get("emRole"));

            HSSFCell cell05=rowx.createCell(5);
            cell05.setCellStyle(style);
            cell05.setCellValue((String) map.get("emSex"));

            HSSFCell cell06=rowx.createCell(6);
            cell06.setCellStyle(style);
            cell06.setCellValue((String) map.get("emPhone"));

            HSSFCell cell07=rowx.createCell(7);
            cell07.setCellStyle(style);
            cell07.setCellValue((String) map.get("emEmail"));

            HSSFCell cell08=rowx.createCell(8);
            cell08.setCellStyle(style);
            cell08.setCellValue((String) map.get("emStatus"));

            HSSFCell cell09=rowx.createCell(9);
            cell09.setCellStyle(style);
            cell09.setCellValue((String) map.get("emAddress"));

        }
        //输出Excel文件
        OutputStream output=response.getOutputStream();
        response.reset();
        //文件名这里可以改
        response.setHeader("Content-disposition", "attachment; filename=Employ.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
        return "导出成功";
    }
}
