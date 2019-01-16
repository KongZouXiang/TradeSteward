function reload(arg) {
    $("#querytype").val(arg);
    $("#resultList").flexReload(myPage,true);
    $("#selectAllCheckbox").removeAttr("checked");

}
function getproductversion(){
	return parent.$('#productversion').val();
}

$(function(){
	$(".expertSearch input,.expertSearch select").keyup(function(){
		if(event.keyCode == "13"){
			reload(1);
	    }  
	});
});
function bindKeySearch(){
	 if(event.keyCode == "13"){
			reload(0);
	    }  
}
// // 初始化内容页宽度
function resizecontent() {
	var totalwidth = 0;
	var colcount=0;
	var morewidth=0;
	var average=0;
	$(".tableStyle").find("th").each(function(index, element) {
		if(!$(this).is(":hidden")){
		colcount=colcount+1;
		totalwidth = totalwidth + Number($(this).attr("width"));
		}
	});
	if(totalwidth>document.body.clientWidth-85){
		$(".whiteBox").css("width", (document.body.clientWidth - 85) + "px");
	}else{
		morewidth=document.body.clientWidth-85-totalwidth;
		average=morewidth/colcount;
		$(".tableStyle").find("th").each(function(index, element) {
			$(this).attr("width",Number($(this).attr("width"))+average);
		});
	}
	
	//页面初始化触发
	$(window).resize();
}
function getSobState(){
	var flat=false;
	$.ajax({
        dataType: "json",
        data: {},
        cache: false,
        async: false,
        url: "/UCenter-webapp/commondata/getsobstate.json?" + Math.random(),
        type: "post",
        success: function(o) {
        	if(o.data=="3"){
        		showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
        		flat=false;
        	}else{
        		flat=true;
        	}
        },
        error: function() {
        	showErrorMsg("获取帐套状态失败");
        }
    });
	return flat;
}
function getSobStateAllowPD(){	//盘点时 允许
	var flat=false;
	$.ajax({
        dataType: "json",
        data: {},
        cache: false,
        async: false,
        url: "/UCenter-webapp/commondata/getsobstate.json?" + Math.random(),
        type: "post",
        success: function(o) {
        	if(o.data=="1"){
        		flat=true;
        	}else{
        		if(o.data=="0"){
            		showErrorMsg("当前帐套为期初状态,请先开帐.");
            		flat=false;
            	}else if(o.data=="2"){
            		showErrorMsg("当前帐套为封帐状态,请先开帐.");
            		flat=false;
            	}else if(o.data=="3"){
//            		showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
//            		flat=false;
            		flat= true;
            	}else{
            		showErrorMsg("当前帐套为期初状态,请先开帐.");
            		flat=false;
            	}
        	}
        },
        error: function() {
        	showErrorMsg("获取帐套状态失败");
        }
    });
	return flat;
}
// 是否显示作废单据
function funIsShowZF() {
    if ($("#chkShowZF").attr("checked") == "checked") {
        $("#hidIsShowZF").val("0");
        
        var sel_option = $('select[name="selauditstate"] option:eq(4)');
        sel_option.wrap("<span style='display:none'></span>");
        if($("#selauditstate").val()=="3"){
        	$("#selauditstate").val('');
        }
    } else {
        $("#hidIsShowZF").val("1");
        var sel_option = $('select[name="selauditstate"] option:eq(4)');
        var sel_optionP = sel_option.parent("span");
        sel_optionP.show();
        sel_option.show();
        sel_option.replaceAll(sel_optionP);
    }
    reload($("#querytype").val());
}
function funShowOrHideScan() {
    if ($("#StrScan").css("display") == "none") {
        $("#StrScan").show().focus();
    } else {
        $("#StrScan").hide();
    }
}
// 清空查询条件
function allclean(){
	$(".expertSearch input").val('').attr("disabled",false);;
	$(".expertSearch select").val('');
}
function advance() {
    $('.expertSearch').toggle();
    $('.search').toggle();
    if ($("#btnadvance").text() == "筛选") {
        $("#btnadvance").text("收起");
    } else {
        $("#btnadvance").text("筛选");
    }
}

// 打印信息
function showMsg(msg) {
	window.parent.showSuccessMsg(msg);
	if($(".noActionButton").length>0){
		$(".noActionButton").removeClass('noActionButton');
	}
	if($(".loadding").length>0){
		$(".loadding").hide();
	}
}
// 折扣率下拉框
function tagselectshow(_sId) {
    $("#" + _sId).show();
}
function tagselecthide(_sId) {
    $("#" + _sId).hide();
}
function selectTag(id) {
    $("#" + id).text($("#" + id).text() + "&nbsp;&nbsp;√");
    tagselecthide("tagselect");
}
function valSobState(val){
	var flat=true;
	if(val!="1"){
		if(val=="3"){
			showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
			flat=false;
		}
	}
	return flat;
}
/**
 * 允许
 * specify: "PD":盘点时允许！；"QC"：期初时允许！；"FZ"：封账时允许！；
 */
function valSobStateSpecify(val,specify){
	var flag= true;
	if("1"!= val){
		if("3"== val){
			if("PD"!= specify){
				showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
				flag=false;				
			}else{
				flag= true;
			}
		}
	}
	return flag;
}
/*--获取网页传递的参数--*/
function request(paras) {
    var url = location.href;
    var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
    var paraObj = {}
    for (i = 0; j = paraString[i]; i++) {
        paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
    }
    var returnValue = paraObj[paras.toLowerCase()];
    if (typeof(returnValue) == "undefined") {
        return "";
    } else {
        return returnValue;
    }
}
/*--获取URL的参数--*/
function requestByUrl(paras,url) { 
    var paraString = url.substring(url.indexOf("?") + 1, url.length).split("&");
    var paraObj = {}
    for (i = 0; j = paraString[i]; i++) {
        paraObj[j.substring(0, j.indexOf("=")).toLowerCase()] = j.substring(j.indexOf("=") + 1, j.length);
    }
    var returnValue = paraObj[paras.toLowerCase()];
    if (typeof(returnValue) == "undefined") {
        return "";
    } else {
        return returnValue;
    }
}

function GetEmptyRow() {
    var rows = null;
    $("#tabdetail tr:gt(0)").each(function() {
        var productid = $(this).find("input[name='hidProductId']").val();
        if (productid == '') {
            rows = this;
            currow = this;
            return false;
        }
    });
    if (rows == null) {
        row = addrow();
        currow = row;
    }
 // 初始化序号
	initorder();
    return rows;
}
// 单行商品选择序列号
// busiAction: Sale：销售单；Buy：进货单
function SingleSelectSerialNo(productId, RowId, warehouseId, busiAction,sns) {
	var ismulopen = $(parent.document).find("#hidisopenmultiplewarehouse").val();
    if (productId != '' && RowId != '') {
        // 进货直接退货同销售
        if (busiAction == "Sale") {
            if(ismulopen == 1){
            	if(warehouseId == undefined || warehouseId=="" || warehouseId==null){
            		//取最新创建的仓库
            		var param={};
            		$.post("/UCenter-webapp/Warehouse/getNearWarehouse.json", param, function(result, resultState) {
            			if (resultState == "success") {
            				if(result.isHave == "true"){
            					var warehouseid = result.warehouseid;
            					window.parent.showMainPage("/UCenter-webapp/Product/SnSelect.htm?productIds=" + productId + "&warehouseId=" + warehouseid + "&rowIds=" + RowId+"&sns="+sns, "选择序列号", 540, 1000);
            				}
            			}
            		});
            	}else{
            		window.parent.showMainPage("/UCenter-webapp/Product/SnSelect.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId+"&sns="+sns, "选择序列号", 540, 1000);
            	}
            }else{
            	window.parent.showMainPage("/UCenter-webapp/Product/SnSelect.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId+"&sns="+sns, "选择序列号", 540, 1000);
            }
        }
        if(busiAction == "BuyReturn"){
        	window.parent.showMainPage("/UCenter-webapp/Product/SnSelect.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId+"&sns="+sns, "选择序列号", 540, 1000);
        }
        
        // 销售直接退货同进货
        if (busiAction == "Buy" || busiAction == "SaleReturn") {
            window.parent.showMainPage("/UCenter-webapp/Product/SnSingleAdd.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId, "管理序列号", 560, 600);
        }
        // 库存盘点
        if (busiAction == "InvTak") {
            window.parent.showMainPage("/UCenter-webapp/Product/InvTakSN.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId, "盘点序列号", 555, 800);
        }
        //组装拆卸 新商品清单 
        //隐藏 导入按钮 hideImport=1
        if (busiAction == "Buy_Assembly") {
        	window.parent.showMainPage("/UCenter-webapp/Product/SnSingleAdd.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId+ "&hideImport=1", "管理序列号", 560, 600);
        }
    }
}


// 单行商品退货选择序列号
// busiAction: Sale：销售单；Buy：进货单
function SingleSelectReturnSerialNo(productId, RowId, warehouseId, busiAction) {
 if (productId != '' && RowId != '') {
     // 进货直接退货同销售
     if (busiAction == "Buy") {
         window.parent.showMainPage("/UCenter-webapp/Product/SnSingleReturn.htm?busiAction="+busiAction+"&productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId, "管理序列号", 450, 500);
     }
     // 销售直接退货同进货
     if (busiAction == "Sale") {
         window.parent.showMainPage("/UCenter-webapp/Product/SnSingleReturn.htm?busiAction="+busiAction+"&productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId, "管理序列号", 450, 500);
     }
     if (busiAction == "BuyReturn") {
         window.parent.showMainPage("/UCenter-webapp/Product/SnSingleReturn.htm?busiAction="+busiAction+"&productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId, "管理序列号", 450, 500);
     }
     if (busiAction == "SaleReturn") {
         window.parent.showMainPage("/UCenter-webapp/Product/SnSingleReturn.htm?busiAction="+busiAction+"&productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId, "管理序列号", 450, 500);
     }
 }
}
// 单行商品选择序列号
// busiAction: Sale：销售单；Buy：进货单
// busiType:1:归还 2：退货
function SingleSelectSerialNoByAllow(productId, RowId, warehouseId, busiAction, allowCount) {
  if (productId != '' && RowId != '') {
      // 进货直接退货同销售
      if (busiAction == "Sale" || busiAction == "BuyReturn") {
    	  window.parent.showMainPage("/UCenter-webapp/Product/SnSelect.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId+ "&allowCount=" + allowCount, "选择序列号", 540, 1000);
      }
      // 销售直接退货同进货
      if (busiAction == "Buy" || busiAction == "SaleReturn") {
    	  window.parent.showMainPage("/UCenter-webapp/Product/SnSingleAdd.htm?productIds=" + productId + "&warehouseId=" + warehouseId + "&rowIds=" + RowId+ "&allowCount=" + allowCount, "管理序列号", 560, 600);
      }
  }
}
/* 设置负库存 */
function SetNegativeInventory() {
    $.ajax({
        dataType: "json",
        data: {
            configcode: "IsAllowNegativeInventory",
            configvalue: "1",
            taxrate: "0"
        },
        cache: false,
        async: false,
        url: "/UCenter-webapp/SysConfig/updateConfig/?" + Math.random(),
        type: "post",
        success: function(o) {
            if (o.STATUS_SUCCESS == "1") {
                $(window.parent.frames["iframe"].document).find("#isNegativeInventory").val("1");
                showMsg("已允许负库存销售");
            } else if (o.STATUS_SUCCESS == "1") {
                showMsg("您没有权限，请管理员设置");
                return;
            } else {

}
        },
        error: function() {
            showMsg("失败");
        }
    });
}
// 条码扫描方法
function ScanChange(obj, row, warehouseId, busiAction) {
	if('InvTak'== busiAction &&(warehouseId=='' || warehouseId== undefined))
	{
		$(obj).val("");
		showErrorMsg("请选择盘点仓库!");
		return;
	}
	if('BuyReturn'== busiAction &&(warehouseId=='' || warehouseId== undefined))
	{
		$(obj).val("");
		showErrorMsg("请选择出库仓库!");
		return;
	}
	var isopenmultiwarehouse = parent.$("#hidisopenmultiplewarehouse").val();//多仓值
	var moduleName=$("#moduleName").val();
	var warehouseidStr="";
	var buyprice=$("#buyprice",parent.document).val();
    var isOpenSerialNo = $("#hidIsOpenSerialNo").val();
    var hidIsOpenIO = $("#hidIsOpenIO").val();
    var hidIsRealTimeIO = $("#hidIsLogisOut").val();
    if (event.keyCode == 13) {
    	//开启多仓后 销售模块 warehouseId传空
    	if(undefined != warehouseId && "" != warehouseId && "InvTak" != busiAction){
    		if(checkisLockWarehouse($('#choose-warehouse-val').val(),3)){
    			return;
    		}
    	}
    	if(busiAction == "Transfer"){
    		if(undefined != $('#outwarehouse').val() && "" != $('#outwarehouse').val()){
    			if(checkisLockWarehouse($('#outwarehouse').val(),3)){
        			return;
        		}
    		}
    	}
    	
        var strKey = $(obj).val();
        if (strKey != null && strKey != "") {
            $.ajax({
                dataType: "json",
                data: {
                    warehouseId: warehouseId,
                    key: strKey,
                    busiAction: busiAction,
                    isopenmultiwarehouse:isopenmultiwarehouse,
                    moduleName:moduleName
                },
                url: "/UCenter-webapp/Product/scanproduct.json",
                cache: false,
                type: "post",
                success: function(o) {
                    if (o.Items == null) {
                    	if(o.scanMulTip!=undefined && o.scanMulTip!="" && o.scanMulTip!=null){
                    		showErrorMsg(o.scanMulTip);
                    	}
                    	
                        $(obj).css("color", "red").val("未找到匹配商品");
                        setTimeout(function() {
                            $(obj).css("color", "#333").val("").focus();
                        },
                        1000); // 单位毫秒
                        return;
                    }
                    //开启多仓条码扫描序列号上时，做序列号所在仓库盘点判断
                    if(1==isopenmultiwarehouse){
                    	if(o.Items.warehouseid !=null && o.Items.warehouseid!=undefined && o.Items.warehouseid!=""){
                        	if(checkisLockWarehouse(o.Items.warehouseid,3)){
                        		return;
                        	}
                        }
                    }
                    
                    var jsonn = [];
                    o.Items["count"] = "1";
                    if (isOpenSerialNo == "1" && o.Items.snmanage == "1" && ((hidIsOpenIO == "1" && hidIsRealTimeIO == "1") || hidIsOpenIO == "0") && o.Items.scanType != "1") {
                        o.Items["count"] = "0";
                    }
					o.Items["type"] = "0";
					o.Items["lowerprice"]=o.Items.mainlowerprice;
					
					if(o.scantype!="1"){
						o.Items=initNearUnitByJson(o.Items,busiAction);
					}else{
						o.Items.mainunitid=o.Items.unitid;
					}
					
					o.Items["isscan"] = "1";//通过扫描获取到的商品
					//扫描多单位商品的主副单位条码时，对以下字段重新赋值mainunitname，mainunitid，mainsaleprice，mainbuyprice，mainpfprice，mainlowerprice，mainunitisdecimal
					if(o.Items["cpProductUnitSBs"] != undefined && o.Items["cpProductUnitSBs"]!=null && o.Items["cpProductUnitSBs"].length > 1){
						for( var i = 0; i < o.Items["cpProductUnitSBs"].length; i++){
							if(o.Items["mainunitid"]!=null && o.Items["mainunitid"]!= undefined && o.Items["mainunitid"].toLowerCase() == o.Items["cpProductUnitSBs"][i].unitid.toLowerCase() ){
								o.Items["mainunitname"] = o.Items["cpProductUnitSBs"][i].unitname;
								o.Items["mainunitid"] = o.Items["cpProductUnitSBs"][i].unitid;
								o.Items["mainsaleprice"] = o.Items["cpProductUnitSBs"][i].saleprice;
								o.Items["mainbuyprice"] = o.Items["cpProductUnitSBs"][i].buyprice;
								o.Items["mainpfprice"] = o.Items["cpProductUnitSBs"][i].pfprice;
								o.Items["mainlowerprice"] = o.Items["cpProductUnitSBs"][i].lowerprice;
								o.Items["clientpfprice1"] = o.Items["cpProductUnitSBs"][i].pfprice1;
								o.Items["clientpfprice2"] = o.Items["cpProductUnitSBs"][i].pfprice2;
								o.Items["clientpfprice3"] = o.Items["cpProductUnitSBs"][i].pfprice3;
								//o.Items["mainunitisdecimal"] = o.Items["cpProductUnitSBs"][i].isdecimal;
								//o.Items["mainbarcode"] = o.Items["cpProductUnitSBs"][i].barcode;
							}
						}
					}
                    jsonn.push(o.Items);
                    var temp = 0;
                    var hidObj = currow;
                    if(busiAction == "Transfer" && o.scantype != 1){
                    	//调拨扫描非条形码
                    	//获取最近单位
                		jsonn = initNearTranUnit(jsonn);
                    }
                    $("#tabdetail tr:gt(0)").each(function() {
                        var productid = $(this).find("input[name='hidProductId']").val();
                        var unitid=$(this).find("input[name='hidUnitId']").val();
                        if(isopenmultiwarehouse=="1" && busiAction != "Transfer"){//开启多仓
                        	 var warehouseid = o.Items.warehouseid;
                             var defaultwarehouse = $("#warehouseDropList .droplist .default").attr("data-value");
                             if(o.Items.scanType != "1"){
                            	
                                 //未设置默认仓库时，取商品所在仓库id,反之取默认仓库id
                                 if(warehouseid == null && defaultwarehouse != undefined && defaultwarehouse !=""){
                                 	warehouseid = defaultwarehouse;
                                 }else{
                                 	warehouseid="null";
                                 }
                            	var warehouseidd = "";
                            	//页面中商品id和扫描获取的商品id如果相同，则进入
                            	if (productid == o.Items.productid&&unitid==o.Items.mainunitid) {
                            		 $("#tabdetail tr:gt(0)").each(function() {
                            			 if(productid == $(this).find("input[name='hidProductId']").val()){
                            				 warehouseidd=$(this).find("input[name='hiddetailwarehouseid']").val();
                            				 if(warehouseidd == undefined || warehouseidd==""){
                            					 warehouseidd="null";
                            				 }
                            				 warehouseidStr += warehouseidd+",";
                            				 warehouseidd.replace(warehouseidd, "");
                            			 }
                            		 });
                            		 if(warehouseidStr.indexOf(warehouseid) != -1){
                                         hidObj = this;
                                         temp = 1;
                            		 }
                              }
                            	warehouseidd.replace(warehouseidd, "");;
                             }
                             if(o.Items.scanType == "1"){//序列号商品
                            	 if(hidIsOpenIO != '1'){
                            		 var warehouseidd = "";
                            		//页面中商品id和扫描获取的商品id如果相同，则进入
                            		 var tablewarehouseid = $(this).find("input[name='hiddetailwarehouseid']").val();
                                 	if (productid == o.Items.productid&&unitid==o.Items.mainunitid) {
                                 		 if(tablewarehouseid == warehouseid){
                                 			hidObj = this;
                                            temp = 1;
                                            return false;
                                 		 }
                                    }
                            	 }else{
                            		 if(productid == o.Items.productid&&unitid==o.Items.mainunitid){

                                      	hidObj = this;
                                          temp = 1;
                                 	 } 
                            	 }
                             }
                        }else{
                        	if(busiAction != "Transfer" && productid == o.Items.productid&&unitid==o.Items.mainunitid){
                            	hidObj = this;
                                temp = 1;
                        	}
                        	//调拨扫描非条形码
                        	if(busiAction == "Transfer" && o.scantype != 1){
                        		var nUnitId = o.Items.nearunitid;
                        		if(nUnitId == undefined || nUnitId ==null ){
                        			nUnitId = o.Items.mainunitid;
                        		}
                        		if( productid == o.Items.productid && unitid==nUnitId){
	                        		hidObj = this;
	                                temp = 1;
                        		}
                        	}
                        	//调拨扫描条形码
                        	if(busiAction == "Transfer" && o.scantype == 1){
                        		if( productid == o.Items.productid && unitid==o.Items.mainunitid){
	                        		hidObj = this;
	                                temp = 1;
                        		}
                        	}
                        	
                        }
                    });
                    //员工登录，无参考进货价权限时，不获取参考进货价
                    if('0'==buyprice)
                    {
                    	jsonn["mainbuyprice"]=0;
                    }
                    if('SpecialSale'==busiAction){//如果是特价扫描，较为特殊。
                    	selectok(jsonn);
                    }else{
                        if (temp == 0) {
                            selectok(jsonn);
                        } else {
                          	  if (o.Items.scanType == "1" && busiAction == "Sale") {
                            	  if ($(hidObj).find("input[name='hidSerialId']").val().indexOf(o.Items.serialid) < 0) {
                                	var hasserialids=$(hidObj).find("input[name='hidSerialId']").val();
                                	if(hasserialids.indexOf(";") < 0){
                                		hasserialids=hasserialids+";"+ o.Items.serialid + ";";
                                	}else{
                                		hasserialids=hasserialids + o.Items.serialid + ";";
                                	}
                                    $(hidObj).find("input[name='hidSerialId']").val(hasserialids);
                                    var count = $(hidObj).find("input[name='txbCount']").val();
                                    $(hidObj).find(".snno").html(Number(count) + 1);
                                    $(hidObj).find(".sncount").html(Number(count) + 1);
                                    var snhtml=$(hidObj).find(".spanSerialNo").html()+"<br />"+o.Items.serialno;
                                    $(hidObj).find(".spanSerialNo").html(snhtml);
                                    $(hidObj).find("input[name='txbCount']").val(Number(count) + 1).change();
                             }
                            } else if(busiAction=="InvTak"){
                             	showErrorMsg("商品："+strKey+" 已经被选中");
                            }else{
                                if (!(isOpenSerialNo == "1" && o.Items.snmanage == "1" && ((hidIsOpenIO == "1" && hidIsRealTimeIO == "1") || hidIsOpenIO == "0"))) {
                                    var count = $(hidObj).find("input[name='txbCount']").val();
                                    $(hidObj).find("input[name='txbCount']").val(Number(count) + 1).change();
                                }

                            }

                        }
                    }

                    $(obj).val(o.Items.productname);
                    setTimeout(function() {
                        $(obj).val("");
                        $(window.parent.frames["iframe"].document).find("#productsn").focus();
                    },
                    800); // 单位毫秒
                    // 打开序列号管理
                    if(1 != $("#hidIsOpenMultipleWarehouse").val()){//关闭多仓时进入hidIsOpenMultipleWarehouse hidIsMultiWarehouse
                    	 if (isOpenSerialNo == "1" && o.Items.snmanage != "0" && ((hidIsOpenIO == "1" && hidIsRealTimeIO == "1") || hidIsOpenIO == "0") && o.Items.scanType != "1") {
                         	
                         	if (busiAction == "Sale") {
                                 SingleSelectSerialNo($(hidObj).find('input[name=\'hidProductId\']').val(), $(hidObj).find('input[name=\'hidSerialId\']').attr('id').replace('sn_', ''), warehouseId, 'Sale');
                             }
                             if (busiAction == "Buy") {
                                 SingleSelectSerialNo($(hidObj).find('input[name=\'hidProductId\']').val(), $(hidObj).find('input[name=\'hidSerialNo\']').attr('id').replace('sno', ''), warehouseId, 'Buy');
                             }
                         } else {
                             $(obj).focus();
                         }
                    }
                    if(1 == $("#hidIsOpenMultipleWarehouse").val()){
                    	$(obj).focus();
                    }
                    
                    window.scrollTo(0,$(hidObj).offset().top-200); 
                },
                error: function() {
                    //alert("单据条码扫描失败");
                	$(obj).val("").focus();
                }

            });
        }
    }
}

var Business = Business || {};

Business.supplierCombo = function($_obj, opts) {
    if ($_obj.length == 0) {
        return
    };
    var opts = $.extend(true, {
        data: function() {
            return "commondata/getsupplier.htm";
        },
        ajaxOptions: {},
        width: 120,
        height: 300,
        formatText: function(row) {
            return row.text;
        },
        // formatResult: 'name',
        text: 'text',
        value: 'value',
        defaultSelected: 0,
        defaultFlag: false,
        cache: false,
        editable: true,
        forceSelection: false,
        triggerCls:'nospan',
        callback: {
            onChange: function(data) {}
        },
        extraListHtml: ''
    },
    opts);

    var supplierCombo = $_obj.combo(opts).getCombo();
    return supplierCombo;
};

Business.customerCombo = function($_obj, opts,branchId) {
    if ($_obj.length == 0) {
        return
    };
    var opts = $.extend(true, {
        data: function() {
            return "commondata/getcustomer.htm?branchid="+branchId;
        },
        ajaxOptions: {},
        width: 120,
        height: 300,
        formatText: function(row) {
            return row.text;
        },
        text: 'text',
        value: 'value',
        defaultSelected: -1,
        defaultFlag: false,
        cache: false,
        editable: true,
        forceSelection: false,
		triggerCls:'nospan',
        callback: {
            onChange: function(data) {}
        },
        extraListHtml: ''
    },
    opts);

    var customerCombo = $_obj.combo(opts).getCombo();
    return customerCombo;
};

Business.saleTypeCombo = function($_obj, opts) {
    if ($_obj.length == 0) {
        return
    };
    var opts = $.extend(true, {
        data: function() {
            return [{
                "text": "零售",
                "value": "0"
            },
            {
                "text": "批发",
                "value": "1"
            }];
        },
        ajaxOptions: {},
        width: 60,
        height: 300,
        formatText: function(row) {
            return row.text;
        },
        // formatResult: 'name',
        text: 'text',
        value: 'value',
        defaultSelected: 0,
        defaultFlag: false,
        cache: false,
        editable: false,
        forceSelection: false,
        callback: {
            onChange: function(data) {}
        },
        extraListHtml: ''
    },
    opts);

    var saleTypeCombo = $_obj.combo(opts).getCombo();
    return saleTypeCombo;
};
Business.discountTypeCombo = function($_obj, opts, showSymbol) {
    if ($_obj.length == 0) {
        return
    };
    var opts = $.extend(true, {
        data: function() {
            return [{
                "text": ("undefined"!=typeof showSymbol && showSymbol)?"折扣率（%）":"折扣率",
                "value": "0"
            },
            {
            	"text": ("undefined"!=typeof showSymbol && showSymbol)?"折扣额（元）":"折扣额",
                "value": "1"
            }];
        },
        ajaxOptions: {},
        width: 120,
        height: 300,
        formatText: function(row) {
            return row.text;
        },
        text: 'text',
        value: 'value',
        defaultSelected: 0,
        defaultFlag: false,
        cache: false,
        editable: false,
        forceSelection: false,
        callback: {
            onChange: function(data) {}
        },
        extraListHtml: ''
    },
    opts);

    var discountTypeCombo = $_obj.combo(opts).getCombo();
    return discountTypeCombo;
};

// JSON转换为字符串
function JSONstringify(Json) {
    if ($.browser.msie) {
        if ($.browser.version == "7.0" || $.browser.version == "6.0") {
            var result = jQuery.parseJSON(Json);
        } else {
            var result = JSON.stringify(Json);
        }
    } else {
        var result = JSON.stringify(Json);
    }
    return result;
}
// 打印
function OpenPrint(printUrl,width,height,menuId) {
	// 检查按钮权限
	if(!checkPerm(menuId,"PERM_PRINT")){
		return;
	}
	var pv = $(parent.document).find("#productversion").val();
	if(pv == 51){
		 window.parent.showMainPage(printUrl, '打印单据', height, width, true);
	}else{
		 window.parent.showMainPage(printUrl, '打印单据', height, width);
	}
}

// 检查输入对象的值是否符合整数格式
function isInteger(str) {
    var numStr = Number(str);
    if (str != "") {
        var regu = /^[-]{0,1}[0-9]{1,}$/;
        return regu.test(numStr.toString());
    }
    return true;
}
// 检查输入字符串是否是数字
function isNumber(str) {
	if(str.toString().indexOf('e-')>=0){
	    return true;
	}
    if (str != "") {
        var re = /^[+-]?\d+(\.\d+)?$/;
        if (re.test(str)) {
            return true;
        }
        return false;
    }
    return true;
}
function valBillCode(obj){
	if(!CheckCode($(obj).val())){
		showErrorMsg("单据编号必须为字母、数字、横杠或下划线，且不超过30个字符。");
	}
}
// 验证为数字、字母、下划线，长度为30
function CheckCode(str) {
    var flat = true;
    if (!str.match(/^[A-Za-z0-9_-]+$/))
        flat = false;
    if (str.length > 50)
        flat = false;
    return flat;
}
function valIsDecimal(unitid) {
	var temp = -1;
	$.ajax({
		dataType : "json",
		cache : false,
		async : false,
		url : "/UCenter-webapp/UnitSetting/valunitisdecimal.json?unitid="+unitid+"&"+ Math.random(),
		type : "post",
		success : function(data) {
			temp = data.isdecimal;
		},
		error : function() {
			showErrorMsg("获取单位信息失败");
		}
	});
	return temp;
}
// 选择k客户
function selectcr() {
	if(1!=$("#hidIsOpenMultipleWarehouse").val()){
	if($("#choose-warehouse-val").val()==""){
		showErrorMsg("请选择出库仓库!");
		return;
	}
	}
	window.parent.showMainPage('/UCenter-webapp/ClientInfo/PopList.htm?branchid='+$("#choose-warehouse-parentval").val(), '选择客户',575,1000);
}
var isOnlineOrder = request('isOnlineOrder');
function selectordercr() {
  	window.parent.showMainPage('/UCenter-webapp/ClientInfo/PopList.htm?branchid='+$("#choose-warehouse-parentval").val()+'&isonlineorder='+isOnlineOrder, '选择客户',575,1000);
}
// 选择供应商
function selectsr() {
	if($("#choose-warehouse-val").val()==""){
		showErrorMsg("请选择入库仓库!");
		return;
	}
	window.parent.showMainPage('/UCenter-webapp/SupplierInfo/PopList.htm?branchid='+$("#choose-warehouse-parentval").val(), '选择供应商',575,1000);
}

function selectordersr() {
	window.parent.showMainPage('/UCenter-webapp/SupplierInfo/PopList.htm?branchid='+$("#choose-warehouse-parentval").val(), '选择供应商',575,1000);
}


// 0=期初，1=进货，2=进货退货，3=销售，4=销售退货，5=盘点，6=组装拆卸,7=调拨,
// 8=借入,9=借出,10=借入归还,11=借出归还,12=借出转销售,13=借入转进货,14=待入库单,
// 15=待出库单,21=入库单,20=出库单 ,31=销售订单
function ShowBillDetail(busiType, busiId,isallow,clientid,supplierid) {
	//当前用户id
	var myuserid=$("#userid",parent.document).val();
	//是否允许查看他人单据
	var allowview=$("#allowview",parent.document).val();
	if((isallow==undefined || isallow==null ||isallow=="")&&allowview=="0"){
		//调用ajax 判断是否为查看他人单据
		if(getBusiUserId(myuserid,busiId)){
			showErrorMsg("没有查看他人单据权限");
			return;
		}
	}
	if('0'==isallow)
	{
		showErrorMsg("没有查看他人单据权限");
		return;
	}
 switch (busiType) {
     case 1:
    		if(!checkPerm('100201',"PERM_VIEW")){
    			return;
    		}
    	 parent.addTabByTitleAndUrl("进货单据明细", "Buy/Detail.htm?buyid="+busiId, "Buy-Detail",'WBILL',true);
         break;
     case 2:
    	 if(!checkPerm('100202',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("进货退货单据明细", "BuyReturn/Detail.htm?returnid="+busiId, "BuyReturn-Detail",'WBILL',true);
         break;
     case 3:
    	 if(!checkPerm('100101',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("销售单据明细", "Sale/Detail.htm?saleid="+busiId, "Sale-Detail",'WBILL',true);
         break;
     case 31:
    	 if(!checkPerm('100100',"PERM_VIEW")){
 			return;
 		 }
    	 var titlename = "销售订单明细";
    	 if($(parent.document).find("#productversion").val() == "51"){
    		 titlename = "门店订单明细";
    	 }
    	 parent.addTabByTitleAndUrl(titlename, "SaleOrder/Detail.htm?saleid="+busiId, "SaleOrder-Detail",'WBILL',true);
         break;
     case 32:
    	 if(!checkPerm('100100',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("订单详情", "orderPlusManagerShopOrder/detail.htm?saleid="+busiId, "orderPlusManagerShopOrder-detail",'WBILL',true);
         break;
     case 48:
	   	  if(!checkPerm('100400',"PERM_VIEW")){
	   		  return;
	   	  }
	   	  parent.addTabByTitleAndUrl('网店订单', "orderPlusManagerShopOrder/detail.htm?saleid="+busiId, "orderPlusManagerShopOrder-detail","WBILL",true);
	   	  break;
     case 4:
    	 if(!checkPerm('100102',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("销售退货单据明细", "SaleReturn/Detail.htm?returnid="+busiId, "SaleReturn-Detail",'WBILL',true);
         break;
     case 5:
    	 if(!checkPerm('100301',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("历史盘点单", "InvTak/Detail.htm?takbillid="+busiId, "InvTak-Detail",'WBILL',true);
         break;
     case 6:
    	 if(!checkPerm('100309',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("组装拆卸单据明细", "Assembly/detail.htm?assemblyid="+busiId, "Assembly-Detail",'WBILL',true);
         break;
     case 7:
    	 if(!checkPerm('100302',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("调拨明细", "Transfer/detail.htm?tranid="+busiId, "Transfer-Detail",'WBILL',true);
         break;
     case 8:
    	 if(!checkPerm('100303',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("借入明细", "Borrow/Detail.htm?lendid="+busiId, "Borrow-Detail",'WBILL',true);
         break;
     case 9:
    	 if(!checkPerm('100304',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("借出明细", "Lend/Detail.htm?lendid="+busiId, "Lend-Detail",'WBILL',true);
         break;
     case 10:
    	 if(!checkPerm('100303',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("借入归还明细", "LendReturn/Detail.htm?returnid="+busiId, "LendReturn-Detail",'WBILL',true);
         break;
     case 11:
    	 if(!checkPerm('100304',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("借出归还明细", "LendReturn/Detail.htm?returnid="+busiId, "LendReturn-Detail",'WBILL',true);
         break;
     case 12:
    	 if(!checkPerm('100101',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("借出转销售明细", "Sale/Detail.htm?saleid="+busiId, "Sale-Detail",'WBILL',true);
         break;
     case 13:
    	 if(!checkPerm('100201',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("借入转进货明细", "Buy/Detail.htm?buyid="+busiId, "Buy-Detail",'WBILL',true);
         break;
     case 21:
    	 if(!checkPerm('100308',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("入库单明细", "InStorage/Detail.htm?ioid="+busiId, "InStorage-Detail",'WBILL',true);
         break;
     case 20:
    	 if(!checkPerm('100307',"PERM_VIEW")){
 			return;
 		}
    	 parent.addTabByTitleAndUrl("出库单明细", "OutStorage/Detail.htm?ioid="+busiId, "OutStorage-Detail",'WBILL',true);
         break;
     case 24:
     	 if(!checkPerm('110201',"PERM_VIEW")){
    			return;
    		}
     	 parent.addTabByTitleAndUrl("收款单详情", "ClientReceive/ReceivablesSingleDetailInit.htm?businessid="+busiId+"&clientid="+clientid, "ClientReceive-ReceivablesSingleDetailInit",'WBI',true);
          break;
      case 25:
    	 	 if(!checkPerm('110202',"PERM_VIEW")){
    				return;
    			}
    		parent.addTabByTitleAndUrl('付款单详细', "SupplierPay/PaymentSingleDetailInit.htm?businessid="+busiId+"&supplierid="+supplierid, "SupplierPay-PaymentSingleDetailInit","WBI",true);
    		break;
     default:

 }
 
}

function closetips(){
	$("#divtips").hide();
}

// 替换英文单引号为中文单引号
function replaceMarks(obj){
	obj.value = obj.value.replace(/\'/g,"’");
}
// 获取是否检查销售价
function GetCheckSalePrice() {
	var NIVal = -1;
	$.ajax({
		dataType : "json",
		cache : false,
		async : false,
		url : "Sale/getCheckSalePrice.json?" + Math.random(),
		type : "post",
		success : function(o) {
			NIVal = o.data;
		},
		error : function() {
			showErrorMsg("获取业务设置失败");
		}
	});
	return NIVal;
}
// 统一绑定搜索区域的下拉框
function loadSearchSelect(businame){
	// 绑定门店
	var branchObj=$(".expertSearch").find("select[id*='Branch']");
	if(branchObj!=null&&branchObj!=undefined){
		$.ajax({
			dataType:"json",
			cache:false,
			async:false,
			url:"/UCenter-webapp/commondata/getbranch.json",
			type:"post",
			success:function(o){
				if(o.Items!=null){
					branchObj.each(function(){
						for(var i=0;i<o.Items.length;i++){
							$(this).append("<option value='"+o.Items[i]["value"]+"'>"+o.Items[i]["text"]+"</option>");
						}
					});
				}else{
					$(this).hide();
				}
			},
			error:function(){
				showErrorMsg("绑定门店下拉框失败");
			}
		});
	}
	// 绑定仓库
	if("saleorder"==businame){
		loadWarehousedatasearch();
	}else{
	levelSelect.init('/UCenter-webapp/commondata/getwarehouseincludestop.json', 'Warehouse',0,1);
	}
	if('buy'==businame || 'buyorder' == businame) {
		levelSelect.init('/UCenter-webapp/commondata/getuser.json?type=3', 'OperUser',0,1);
	} else if('onlineorder' == businame){
		//线上订单高级搜索加载仓库下拉框
		loadWarehousedatasearch();
		//线上订单 经手人 过滤 导购员
		/*
		 * 2017年7月26日 15:55:02
		 * 原本param=2
		 * 现在改成param=22（让此值不为2 即可）
		 * 是在高级搜索经手人时，要满足
		 * 1.总店员工账号登录，经手人下拉框的数据应为：所有门店的员工+导购员
		 * 2.子店员工账号登录，经手人下拉框的数据应为：该子店下的所有员工+导购员
		 * */
		levelSelect.init('/UCenter-webapp/commondata/getbranchuser.json?param=22&search=1&noguide=1', 'OperUser',0,1);
	} else {
		levelSelect.init('/UCenter-webapp/commondata/getbranchuser.json?param=22&search=1', 'OperUser',0,1);
	}
	// 绑定制单人
	levelSelect.init('/UCenter-webapp/commondata/getbranchuser.json?type=1&search=1', 'CreateUser',0,1,1);
	//结算账户
	levelSelect.init('/UCenter-webapp/commondata/getaccount.json?ispay=1&search=1&isstop=1', 'account',0,1);
}

// 检测用户新增单据勾选保存后打印 事发后有打印权限
function checkPrint(obj,resid,name){
	// 检查按钮权限
	if(!checkPerm(resid,"PERM_PRINT")){
		$(obj).removeAttr("checked");
		setCookie(name+"_print","0");
		return;
	}
	else
	{
		if($(obj).attr("checked"))
		{
			setCookie(name+"_print","1");
		}
		else
		{
			setCookie(name+"_print","0");
		}
	}
}
// 绑定客户
function bindcustomer() {
	var autoCompleteTextbox = $("#txbCr");
	if (!!autoCompleteTextbox) {
		// 智能提示 编号、名称、规格、单位、条形码、库存数量
		var productheader = {
			clientcode : "客户编号",
			clientname : "客户名称",
			clienttel : "联系电话"
				/*,
			clientlink : "联系人",
			clienttel : "联系电话",
			clientaddress:"地址"*/
		};
		$("#txbCr").autoComplete({
			header : productheader,
			url : "/UCenter-webapp/ClientInfo/FuzzyQuery.htm?branchid=" + $("#choose-warehouse-parentval").val(),
			width : 400,
			businame:'cs',
			selected : function(o) {
				var warehouseid = $("#choose-warehouse-val").val();
				if(warehouseid == undefined){
					warehouseid = "";
				}
				tempData[escape(warehouseid+"bill")] = null;
				
				var productversion = $("#productversion").val();
				if(productversion == undefined || productversion == ""){
					productversion = $("#hidproductversion").val();
				}
				$("#txbCr").removeClass("inputTextFontRed");
				
				if(1!=$("#hidIsOpenMultipleWarehouse").val()){
					if ($("#choose-warehouse-val").val() == ""&&$("#hidIsOpenMultipleWarehouse").val()!=1) {
						showErrorMsg("请选择出库仓库!");
						return;
					}
				}
				$("#txbClientRank").val(o["clientrank"]);//客户等级
				if(productversion == "51"){
					$("#txbCr").val(o["clientname"]).change();
				}else{
					$("#txbCr").val(o["clientname"]);
				}
				$("#crvalue").val(o["clientid"]).change();
				
				$("input[name='hidisgetnearprice']").val("0");
				$("#txclientlink").val(o["clientlink"]);
				$("#txclienttel").val(o["clienttel"]);
				$("#txreceaddress").val(o["clientaddress"]);
				if(parseFloat(o["receamt"])!=0||($("#thisreceamt").val()!=""&&parseFloat($("#thisreceamt").val())!=0)){
					$("#divreceamt").show();
				}else{
					$("#divreceamt").hide();
				}
				if(o["receamt"]==null||o["receamt"]==""){
					o["receamt"]="0.00";
				}
				$("#totalreceamt").html(o["receamt"]).attr("origin_value",o["receamt"]);
				$("#changeClientFuntion").val(o["receamt"]).change();//改变客户执行重新计算欠款事件
				$("#tabdetail tr").each(function(){
					// 绑定智能提示
					bindautocomplete($(this));
				});
				
				$("#txbCr").removeClass("inputTextFontRed");
				//根据客户的等级修改相应等级批发价格
				//changepfPriceByClientRank();
				//initSalePriceSNRAsyncTrue();
				var url = window.location.href;
				
				if(productversion == "51" || productversion == "1" || productversion == "2"){
					$("#hidDefaultItem").val(o.ext3);
					$("#salesmanuserid").val(o.ext3);
					$("#salesmanusername").val(o.salesmanusername);
					$("#salesmanisdel").val(o.salesmanisdel);
					$("#salesmanuserstatus").val(o.salesmanuserstatus);
					$("#salesmanusertype").val(o.salesmanusertype);
					if(o.ext3 != undefined && o.ext3 != null && o.ext3 != ""){
						$("#selectClientRelationIsNull").val(1);
					}else{
						$("#selectClientRelationIsNull").val(0);
					}
					if(url.indexOf("Lend/Add.htm") >= 0){
						//reloadHandMan(o.salesmanusername,o.ext3,o.salesmanusertype,o.salesmanisdel,o.salesmanuserstatus,"0");
					}else{
						var branchid = "";
						if(productversion == "2" && $("#choose-warehouse-parentval").val() != ""){
							branchid = $("#choose-warehouse-parentval").val();
						}
						var IsOpenMulti = $("#hidIsOpenMultipleWarehouse").val();
						if(IsOpenMulti == undefined || IsOpenMulti == ""){
							IsOpenMulti =  $("#ismultiwarehouse").val();
						}
						if(IsOpenMulti == "1"){
							reLoadUser();
						}else{
							reloadHandMan(o.salesmanusername,o.ext3,o.salesmanusertype,o.salesmanisdel,o.salesmanuserstatus,"1","1",branchid);
						}
					}
				}
				focusNextByObj($("#txbCr"));
			}
		});

	}
}

//绑定客户
function bindordercustomer(type,branchid) {
	if(branchid==undefined)
	{
		branchid=$("#choose-warehouse-parentval").val();
	}
	var autoCompleteTextbox = $("#txbCr");
	if (!!autoCompleteTextbox) {
		// 智能提示 编号、名称、规格、单位、条形码、库存数量
		var productheader = {
			clientcode : "客户编号",
			clientname : "客户名称",
			clienttel : "联系电话"
				/*,
			clientlink : "联系人",
			clienttel : "联系电话",
			clientaddress:"地址"*/
		};
		$("#txbCr").autoComplete({
			header : productheader,
			url : "/UCenter-webapp/ClientInfo/FuzzyQuery.htm?branchid=" + branchid,
			width : 400,
			businame:'cs',
			selected : function(o) {
				var warehouseid = $("#choose-warehouse-val").val();
				if(warehouseid == undefined){
					warehouseid = "";
				}
				tempData[escape(warehouseid+"bill")] = null;
				
				var productversion = $("#productversion").val();
				if(productversion == undefined || productversion == ""){
					productversion = $("#hidproductversion").val();
				}
				$("#txbCr").removeClass("inputTextFontRed");
				
				$("#txbClientRank").val(o["clientrank"]);//客户等级
				$("#crvalue").val(o["clientid"]);
				
				$("input[name='hidisgetnearprice']").val("0");
				if(productversion == "51"){
					$("#txbCr").val(o["clientname"]).change();
				}else{
					$("#txbCr").val(o["clientname"]);
				}
				$("#txclientlink").val(o["clientlink"]);
				$("#txclienttel").val(o["clienttel"]);
				$("#txreceaddress").val(o["clientaddress"]);
				$("#txclientext1").val(o.ext1);
				if(parseFloat(o["receamt"])!=0||($("#thisreceamt").val()!=""&&parseFloat($("#thisreceamt").val())!=0)){
					$("#divreceamt").show();
				}else{
					$("#divreceamt").hide();
				}
				if(o["receamt"]==null||o["receamt"]==""){
					o["receamt"]="0.00";
				}
				$("#totalreceamt").html(o["receamt"]);
				$("#tabdetail tr").each(function(){
					// 绑定智能提示
					bindautocomplete($(this));
				});
				//$("#txbCr").change();
				//根据客户的等级修改相应等级批发价格
				//	changepfPriceByClientRank();
				var url = window.location.href;
				
				if(productversion == "51" || productversion == "1" || productversion == "2"){
					$("#hidDefaultItem").val(o.ext3);
					$("#salesmanuserid").val(o.ext3);
					$("#salesmanusername").val(o.salesmanusername);
					$("#salesmanisdel").val(o.salesmanisdel);
					$("#salesmanuserstatus").val(o.salesmanuserstatus);
					$("#salesmanusertype").val(o.salesmanusertype);
					if(o.ext3 != undefined && o.ext3 != null && o.ext3 != ""){
						$("#selectClientRelationIsNull").val(1);
					}else{
						$("#selectClientRelationIsNull").val(0);
					}
					if(url.indexOf("Lend/Add.htm") >= 0){
						//reloadHandMan(o.salesmanusername,o.ext3,o.salesmanusertype,o.salesmanisdel,o.salesmanuserstatus,"0");
					}else{
						var branchid = "";
						if(productversion == "2" && $("#choose-warehouse-parentval").val() != ""){
							branchid = $("#choose-warehouse-parentval").val();
						}
						var IsOpenMulti = $("#hidIsOpenMultipleWarehouse").val();
						if(IsOpenMulti == undefined || IsOpenMulti == ""){
							IsOpenMulti =  $("#ismultiwarehouse").val();
						}
						if(IsOpenMulti == "1"){
							reLoadUser();
						}else{
							reloadHandMan(o.salesmanusername,o.ext3,o.salesmanusertype,o.salesmanisdel,o.salesmanuserstatus,"1","1",branchid);
						}
						
					}
				}
				setTimeout( function() {
					focusNextByObj($("#txbCr"));
				}, 300);
				
			}
		});

	}
}
// 绑定供应商
function bindsupplier(busiaction) {
	var autoCompleteTextbox = $("#txbCr");
	if (!!autoCompleteTextbox) {
		// 智能提示 编号、名称、规格、单位、条形码、库存数量
		var productheader = {
			suppliercode : "供应商编号",
			suppliername : "供应商名称"
				/*,
			supplierlink : "联系人",
			companytel : "单位电话",
			suppliertel:"联系电话",
			supplieraddress:"地址"*/
		};
		$("#txbCr").autoComplete({
			header : productheader,
			url : "/UCenter-webapp/SupplierInfo/FuzzyQuery.htm?branchid=" + $("#choose-warehouse-parentval").val()+"&busiaction="+busiaction,
			width : 400,
			businame:'cs',
			selected : function(o) {
				if ($("#choose-warehouse-val").val() == "") {
					showErrorMsg("请选择入库仓库!");
					return;
				}
				var warehouseid = $("#choose-warehouse-val").val();
				if(warehouseid == undefined){
					warehouseid = "";
				}
				tempData[escape(warehouseid+"bill")] = null;
				
				$("input[name='hidisgetnearprice']").val("0");
				$("#crvalue").val(o["supplierid"]);
				$("#tabdetail tr").each(function(){
					/*$(this).find("input[name='txbProductName']").parent().find("div[class='autoCompleteBox']").remove();
					$(this).find("input[name='txbProductName']").parent().find("div[class='autoCompleteBox']").remove();*/
					// 绑定智能提示
					bindautocomplete($(this));
				});
				$("#txbCr").val(o["suppliername"]);
				//$("#tabdetail tr:first").next().find("input[name='txbProductName']").focus();
				focusNextByObj($("#txbCr"));
			}
		});

	}
}

//绑定供应商
function bindordersupplier(busiaction) {
	var autoCompleteTextbox = $("#txbCr");
	if (!!autoCompleteTextbox) {
		// 智能提示 编号、名称、规格、单位、条形码、库存数量
		var productheader = {
			suppliercode : "供应商编号",
			suppliername : "供应商名称"
				/*,
			supplierlink : "联系人",
			companytel : "单位电话",
			suppliertel:"联系电话",
			supplieraddress:"地址"*/
		};
		$("#txbCr").autoComplete({
			header : productheader,
			url : "/UCenter-webapp/SupplierInfo/FuzzyQuery.htm?branchid=" + $("#choose-warehouse-parentval").val(),
			width : 400,
			businame:'cs',
			selected : function(o) {
				var warehouseid = $("#choose-warehouse-val").val();
				if(warehouseid == undefined){
					warehouseid = "";
				}
				tempData[escape(warehouseid+"bill")] = null;
				
				$("input[name='hidisgetnearprice']").val("0");
				$("#crvalue").val(o["supplierid"]);
				$("#tabdetail tr").each(function(){
					/*$(this).find("input[name='txbProductName']").parent().find("div[class='autoCompleteBox']").remove();
					$(this).find("input[name='txbProductName']").parent().find("div[class='autoCompleteBox']").remove();*/
					// 绑定智能提示
					bindautocomplete($(this));
				});
				$("#txbCr").val(o["suppliername"]);
				$("#tabdetail tr:first").next().find("input[name='txbProductName']").focus();
				
			}
		});

	}
}
// 获取默认往来单位
function setDefaultCr(busitype,branchid,busiAction){
	// 1:客户 2：供应商
	if(busitype=="1"){
		$.ajax({
			dataType:"json",
			cache:false,
			async:false,
			url:"/UCenter-webapp/commondata/getcustomer.htm?branchid="+branchid+"&defaultoption=1",
			type:"post",
			success:function(o){
				if(o!=null&&o.length>0){
					$("#txbCr").val(o[0]["text"]);
					$("#crvalue").val(o[0]["value"]).change();
					if(busiAction=="Sale"){
						//送货信息不为空才设置为 默认客户的送货信息
						if(''== $('#txclientlink').val() && ''==$('#txclienttel').val() && ''== $('#txreceaddress').val()){
							$("#txclientlink").val(o[0]["remark1"]);
							$("#txclienttel").val(o[0]["remark2"]);
							$("#txreceaddress").val(o[0]["remark3"]);
						}
						if(o[0]["receivables"]==undefined){
							o[0]["receivables"]=0;
						}
						if(o[0]["receivables"]!=0||Number($("#thisreceamt").val())!=0){
							$("#divreceamt").show();
						}else{
							$("#divreceamt").hide();
						}
						$("#totalreceamt").html(o[0]["receivables"]).attr("origin_value", o[0]["receivables"]);
						$("#clientOpenAccountPeriod").val( o[0]["clientopenaccountperiod"] );
						$("#txbClientRank").val( o[0]["clientrank"] );
					}
					var productversion = $("#productversion").val();
					if(productversion == undefined || productversion == ""){
						productversion = $("#hidproductversion").val();
					}
					if(busiAction !="Lend" && (productversion == "51" || productversion == "1" || productversion == "2" )){
						$("#hidDefaultItem").val(o[0].salesmanuserid);
						$("#salesmanuserid").val(o[0].salesmanuserid);
						$("#salesmanusername").val(o[0].salesmanusername);
						$("#salesmanisdel").val(o[0].salesmanisdel);
						$("#salesmanuserstatus").val(o[0].salesmanuserstatus);
						$("#salesmanusertype").val(o[0].salesmanusertype);
						if(o[0].salesmanuserid != undefined && o[0].salesmanuserid != null && o[0].salesmanuserid != ""){
							$("#selectClientRelationIsNull").val(1);
						}else{
							$("#selectClientRelationIsNull").val(0);
						}
						var url = window.location.href;
						reloadHandMan(o[0].salesmanusername,o[0].salesmanuserid,o[0].salesmanusertype,o[0].salesmanisdel,o[0].salesmanuserstatus,"1","1",branchid);	
					}
				}
				
			},
			error:function(){
				showErrorMsg("绑定默认客户失败");
			}
		});
	}else{
		$.ajax({
			dataType:"json",
			cache:false,
			async:false,
			url:"/UCenter-webapp/commondata/getsupplier.htm?branchid="+branchid+"&defaultoption=1",
			type:"post",
			success:function(o){
				if(o!=null&&o.length>0){
					$("#crvalue").val(o[0]["value"]);
					$("#txbCr").val(o[0]["text"]);
				}
				
			},
			error:function(){
				showErrorMsg("绑定默认供应商失败");
			}
		});
	}
}

function crchange(){
	$("#crvalue").val("");
	$("input[name='hidisgetnearprice']").val("0");
	$("#totalreceamt").html("0.00").attr("origin_value",0.00);
	$("#txbClientRank").val("0");
	$("input[name='hidisgetnearprice']").val("0");
	//清空商品信息缓存
	var warehouseid = $("#choose-warehouse-val").val();
	if(warehouseid == undefined){
		warehouseid = "";
	}
	tempData[escape(warehouseid+"bill")] = null;
	$("#tabdetail tr").each(function(){
		// 绑定智能提示
		bindautocomplete($(this));
	});
	
	setTimeout(function(){
		
		var productversion = $("#productversion").val();
		if(productversion == undefined || productversion == null || productversion ==""){
			productversion =$("#hidproductversion").val();
		}
		var clientname = $("#txbCr").val();
		if(productversion == "51" || productversion == "1" || productversion == "2"){
			if(clientname != undefined && $.trim(clientname) != ""){
				var url = window.location.href;
				if(url.indexOf("SaleOrder/Add.htm") >= 0
				  || url.indexOf("SaleOrder/CopyAdd.htm") >= 0
				  || url.indexOf("SaleOrder/EditInit.htm") >= 0
				  || url.indexOf("Sale/Add.htm") >= 0
				  || url.indexOf("Sale/CopyAdd.htm") >= 0
				  || url.indexOf("SaleReturn/Add.htm") >= 0
				  || url.indexOf("SaleReturn/CopyAdd.htm") >= 0
				  || url.indexOf("Lend/Add.htm")>=0
				){
					var isopenmultiplewarehouse = $(parent.document).find("#hidisopenmultiplewarehouse").val();
					//清空 客户关联业务员信息
					$("#salesmanuserid").val("");//关联业务员的ID
					$("#salesmanusername").val("");//关联业务员的名称
					$("#salesmanisdel").val("");//关联业务员 是否删除
					$("#salesmanuserstatus").val("");//关联业务员是否 锁定
					$("#salesmanusertype").val("");//关联业务的类型
					//客户名称 改变时，失去焦点，重新拉取客户信息
					
					var postUrl = "/UCenter-webapp/ClientInfo/getClientInfoByClientName.json";
					var param={};
					param["blurClientName"] = clientname;
					var branchid = "";//当前选择的仓库所在的门店
					if(productversion == "2" && $("#choose-warehouse-parentval").val() != undefined && $("#choose-warehouse-parentval").val() != ""){
						//连锁版，失去焦点执行change事件后，需要判断当前客户 是不是 当前 选择门店的 或者 是 共享的客户
						param["sameBranchid"] = $("#choose-warehouse-parentval").val();//$(parent.document).find("#branchid").val();
						branchid = $("#choose-warehouse-parentval").val();
					}
					$.post(postUrl,param,function(r,s){
						if(s == "success"){
							var o = r.serviceResult[0];
							if(o != undefined && o!=null ){
								//先判断 当前输入的客户 是否输入当前制单人 (当前制单人没有查看他人客户权限)
								var permflag = $("#permflag", parent.parent.document).val();
								var isAdmin = $("#isAdminRole", parent.parent.document).val();
								var clientBranchid = o.branchid;//客户所在门店的id
								var clientisShared = o.isshared;//是否是共享客户 1-是
								if(isAdmin != "true" && permflag.indexOf(";10;")<0){
									$("#txbCr").removeClass("ls-error");
									var userid = $(parent.document).find("#userid").val();//当前用户的id
									var clientToExt3 = o.ext3;
									var clientToSalesDel = o.salesmanisdel;
									var clientToSalesStatus = o.salesmanuserstatus;
									if(clientToSalesDel != 1 && clientToSalesStatus != 1){
										//非连锁版 判断当前 业务员的id 是否与 当前用户id相等
										if(productversion != "2"){
											if(clientToExt3 != undefined && clientToExt3 != null && clientToExt3 != ""){
												if(String(userid).toUpperCase() != String(clientToExt3).toUpperCase() ){
													$("#txbCr").addClass("inputTextFontRed");
													showErrorMsg("您暂无权限为该客户开单");
													return;
												}else{
													$("#txbCr").removeClass("inputTextFontRed");
												}
											}else{
												$("#txbCr").removeClass("inputTextFontRed");
											}
										}else{
											/*
											 *连锁版先判定当前客户 是否是共享客户
											 *如果不是 共享客户  则判定 所在门店 与 所选择的 门店是否一致 
											 */
											if(clientisShared != 1){
												if(String(clientBranchid).toUpperCase() == String(branchid).toUpperCase()){
													//是同门店 且 不是共享的
													$("#txbCr").removeClass("inputTextFontRed");
													if(clientToExt3 != undefined && clientToExt3 != null && clientToExt3 != ""){
														if(String(userid).toUpperCase() != String(clientToExt3).toUpperCase() ){
															$("#txbCr").addClass("inputTextFontRed");
															showErrorMsg("您暂无权限为该客户开单");
															return;
														}
													}
												}else{
													//不是共享 且不是同门店的
													$("#txbCr").addClass("ls-error");
													showErrorMsg("该客户与其他门店客户重复，请修改");
													return;
												}
											}else{
												$("#txbCr").removeClass("inputTextFontRed");
											}
										}
									}
								}else{
									$("#txbCr").removeClass("inputTextFontRed");
									$("#txbCr").removeClass("ls-error");
									if(productversion == "2"){
										if(clientisShared != 1){
											if(String(clientBranchid).toUpperCase() != String(branchid).toUpperCase()){
												//不是共享 且不是同门店的
												$("#txbCr").addClass("ls-error");
												showErrorMsg("该客户与其他门店客户重复，请修改");
												return;
											}
										}
									}
								}
								$("#txbClientRank").val(o["clientrank"]);//客户等级
								$("#txbCr").val(o["clientname"]);
								$("#crvalue").val(o["clientid"]).change();
								$("input[name='hidisgetnearprice']").val("0");
								if(url.indexOf("SaleOrder/EditInit.htm") >= 0){
									var isOnlineOrderParam = request('isOnlineOrder');
									if($("#txclientext1").val()!="1" || isOnlineOrderParam!="1"){
										$("#txclientlink").val(o["clientlink"]);
										$("#txclienttel").val(o["clienttel"]);
										$("#txreceaddress").val(o["clientaddress"]);
									}
								}else{
									$("#txclientlink").val(o["clientlink"]);
									$("#txclienttel").val(o["clienttel"]);
									$("#txreceaddress").val(o["clientaddress"]);
								}
								
								if(parseFloat(o["receamt"])!=0||($("#thisreceamt").val()!=""&&parseFloat($("#thisreceamt").val())!=0)){
									$("#divreceamt").show();
								}else{
									$("#divreceamt").hide();
								}
								if(o["receamt"]==null||o["receamt"]==""){
									o["receamt"]="0.00";
								}
								$("#totalreceamt").html(o["receamt"]).attr("origin_value",o["receamt"]);
								$("#changeClientFuntion").val(o["receamt"]).change();//改变客户执行重新计算欠款事件
								//借出、收款单、核销单，仅需要判断是否有查看他人客户权限即可，不受客户关联业务员影响；
								if(url.indexOf("Lend/Add.htm")>=0
								   || url.indexOf("ClientReceive/NewCollectionInit.htm")>=0
								   || url.indexOf("WriteOff/Add.htm") >=0
									){
									return;
								}
								
								$("#salesmanuserid").val(o.ext3);
								$("#salesmanusername").val(o.salesmanusername);
								$("#salesmanisdel").val(o.salesmanisdel);
								$("#salesmanuserstatus").val(o.salesmanuserstatus);
								$("#salesmanusertype").val(o.salesmanusertype);
								if(o.ext3 != undefined && o.ext3 != null && o.ext3 != ""){
									$("#selectClientRelationIsNull").val(1);
								}else{
									$("#selectClientRelationIsNull").val(0);
								}
								reloadHandMan(o.salesmanusername,o.ext3,o.salesmanusertype,o.salesmanisdel,o.salesmanuserstatus,"1","1",branchid);
							}else{
								$("#txbCr").removeClass("inputTextFontRed");
								$("#txbClientRank").val("0");//客户等级
								$("input[name='hidisgetnearprice']").val("0");
								if(url.indexOf("SaleOrder/EditInit.htm") >= 0){
									var isOnlineOrderParam = request('isOnlineOrder');
									if($("#txclientext1").val()!="1" || isOnlineOrderParam!="1"){
										$("#txclientlink").val("");
										$("#txclienttel").val("");
										$("#txreceaddress").val("");
									}
								}else{
									$("#txclientlink").val("");
									$("#txclienttel").val("");
									$("#txreceaddress").val("");
								}
								
								$("#selectClientRelationIsNull").val(0);
								if(isopenmultiplewarehouse == "1"){
									reLoadUser();
								}else{
									var changeAfterName = $("#txbCr").val();
									reloadHandMan(null,null,null,null,null,"1","1",branchid);
								}
							}
							
							//清空商品信息缓存
							var warehouseid = $("#choose-warehouse-val").val();
							if(warehouseid == undefined){
								warehouseid = "";
							}
							tempData[escape(warehouseid+"bill")] = null;
							$("#tabdetail tr").each(function(){
								// 绑定智能提示
								bindautocomplete($(this));
							});
							
						}
					});
				}
			}else{
				$("input[name='hidisgetnearprice']").val("0");
				
				$("#txbCr").removeClass("inputTextFontRed");
				$("#txbClientRank").val("0");//客户等级
				$("input[name='hidisgetnearprice']").val("0");
				$("#txclientlink").val("");
				$("#txclienttel").val("");
				$("#txreceaddress").val("");
				
				$("#selectClientRelationIsNull").val(0);
				if(isopenmultiplewarehouse == "1"){
					reLoadUser();
				}else{
					var branchid = $("#choose-warehouse-parentval").val();
					reloadHandMan(null,null,null,null,null,"1","1",branchid);
				}
			}
		}
	},300);

}

//切换仓库后，验证当前客户是否可用
function changeWarehouseValiateClient(){

	var productversion = $("#productversion").val();
	if(productversion == undefined || productversion == null || productversion ==""){
		productversion =$("#hidproductversion").val();
	}
	var clientname = $("#txbCr").val();
	if(productversion == "51" || productversion == "1" || productversion == "2"){
		if(clientname != undefined && $.trim(clientname) != ""){
			var url = window.location.href;
			if(url.indexOf("SaleOrder/Add.htm") >= 0
			  || url.indexOf("SaleOrder/CopyAdd.htm") >= 0
			  || url.indexOf("SaleOrder/EditInit.htm") >= 0
			  || url.indexOf("Sale/Add.htm") >= 0
			  || url.indexOf("Sale/CopyAdd.htm") >= 0
			  || url.indexOf("SaleReturn/Add.htm") >= 0
			  || url.indexOf("SaleReturn/CopyAdd.htm") >= 0
			  || url.indexOf("Lend/Add.htm")>=0
			){
				var isopenmultiplewarehouse = $(parent.document).find("#hidisopenmultiplewarehouse").val();
				//清空 客户关联业务员信息
				$("#salesmanuserid").val("");//关联业务员的ID
				$("#salesmanusername").val("");//关联业务员的名称
				$("#salesmanisdel").val("");//关联业务员 是否删除
				$("#salesmanuserstatus").val("");//关联业务员是否 锁定
				$("#salesmanusertype").val("");//关联业务的类型
				//客户名称 改变时，失去焦点，重新拉取客户信息
				
				var postUrl = "/UCenter-webapp/ClientInfo/getClientInfoByClientName.json";
				var param={};
				param["blurClientName"] = clientname;
				var branchid = "";//当前选择的仓库所在的门店
				if(productversion == "2" && $("#choose-warehouse-parentval").val() != undefined && $("#choose-warehouse-parentval").val() != ""){
					//连锁版，失去焦点执行change事件后，需要判断当前客户 是不是 当前 选择门店的 或者 是 共享的客户
					param["sameBranchid"] = $("#choose-warehouse-parentval").val();//$(parent.document).find("#branchid").val();
					branchid = $("#choose-warehouse-parentval").val();
				}
				$.post(postUrl,param,function(r,s){
					if(s == "success"){
						var o = r.serviceResult[0];
						if(o != undefined && o!=null ){
							//先判断 当前输入的客户 是否输入当前制单人 (当前制单人没有查看他人客户权限)
							var permflag = $("#permflag", parent.parent.document).val();
							var isAdmin = $("#isAdminRole", parent.parent.document).val();
							var clientBranchid = o.branchid;//客户所在门店的id
							var clientisShared = o.isshared;//是否是共享客户 1-是
							if(isAdmin != "true" && permflag.indexOf(";10;")<0){
								$("#txbCr").removeClass("ls-error");
								var userid = $(parent.document).find("#userid").val();//当前用户的id
								var clientToExt3 = o.ext3;
								var clientToSalesDel = o.salesmanisdel;
								var clientToSalesStatus = o.salesmanuserstatus;
								if(clientToSalesDel != 1 && clientToSalesStatus != 1){
									//非连锁版 判断当前 业务员的id 是否与 当前用户id相等
									if(productversion != "2"){
										if(clientToExt3 != undefined && clientToExt3 != null && clientToExt3 != ""){
											if(String(userid).toUpperCase() != String(clientToExt3).toUpperCase() ){
												$("#txbCr").addClass("inputTextFontRed");
												showErrorMsg("您暂无权限为该客户开单");
												return;
											}else{
												$("#txbCr").removeClass("inputTextFontRed");
											}
										}else{
											$("#txbCr").removeClass("inputTextFontRed");
										}
									}else{
										/*
										 *连锁版先判定当前客户 是否是共享客户
										 *如果不是 共享客户  则判定 所在门店 与 所选择的 门店是否一致 
										 */
										if(clientisShared != 1){
											if(String(clientBranchid).toUpperCase() == String(branchid).toUpperCase()){
												//是同门店 且 不是共享的
												$("#txbCr").removeClass("inputTextFontRed");
												if(clientToExt3 != undefined && clientToExt3 != null && clientToExt3 != ""){
													if(String(userid).toUpperCase() != String(clientToExt3).toUpperCase() ){
														$("#txbCr").addClass("inputTextFontRed");
														showErrorMsg("您暂无权限为该客户开单");
														return;
													}
												}
											}else{
												//不是共享 且不是同门店的
												$("#txbCr").addClass("ls-error");
												showErrorMsg("该客户与其他门店客户重复，请修改");
												return;
											}
										}else{
											$("#txbCr").removeClass("inputTextFontRed");
										}
									}
								}
							}else{
								$("#txbCr").removeClass("inputTextFontRed");
								$("#txbCr").removeClass("ls-error");
								if(productversion == "2"){
									if(clientisShared != 1){
										if(String(clientBranchid).toUpperCase() != String(branchid).toUpperCase()){
											//不是共享 且不是同门店的
											$("#txbCr").addClass("ls-error");
											showErrorMsg("该客户与其他门店客户重复，请修改");
											return;
										}
									}
								}
							}
							$("#salesmanuserid").val(o.ext3);
							$("#salesmanusername").val(o.salesmanusername);
							$("#salesmanisdel").val(o.salesmanisdel);
							$("#salesmanuserstatus").val(o.salesmanuserstatus);
							$("#salesmanusertype").val(o.salesmanusertype);
							if(o.ext3 != undefined && o.ext3 != null && o.ext3 != ""){
								$("#selectClientRelationIsNull").val(1);
							}else{
								$("#selectClientRelationIsNull").val(0);
							}
						}
					}
				});
			}
		}
	}
}

//核销 收款 客户输入框 失去焦点 自动获取客户信息
function bindClientInfo(){
	setTimeout(function(){
		var url = window.location.href;
		var clientname = $("#txbClient").val();
		var productversion = $("#productversion").val();
		var branchid=$("#hidbranchid").val();
		var txbId = "#txbClient";
		var txbValue = "#clientvalue";
		var postUrl = "/UCenter-webapp/ClientInfo/getClientInfoByClientName.json?isStopShow=1&ishx=1";
		var isClientReceive = false;
		if(url.indexOf("ClientReceive/NewCollectionInit.htm") >= 0){
			isClientReceive = true;
			postUrl = "/UCenter-webapp/ClientInfo/getClientInfoByClientName.json?";
			txbId = "#txbCr";
			txbValue = "#crvalue";
			clientname = $("#txbCr").val();
			branchid = $("#selbranchid").val();
		}
		if(productversion != "3" && clientname != undefined && $.trim(clientname) != ""){
			var param={};
			param["blurClientName"] = clientname;
			
			$.post(postUrl,param,function(r,s){
				if(s == "success"){
					var o = r.serviceResult[0];
					if(o != undefined && o!=null ){
						var permflag = $("#permflag", parent.parent.document).val();
						var isAdmin = $("#isAdminRole", parent.parent.document).val();
						var clientBranchid = o.branchid;//客户所在门店的id
						var clientisShared = o.isshared;//是否是共享客户 1-是
						if(isAdmin != "true" && permflag.indexOf(";10;")<0){
							//非管理员 且 没有 查看他人客户权限
							$(txbId).removeClass("ls-error");
							var userid = $(parent.document).find("#userid").val();//当前用户的id
							var clientToExt3 = o.ext3;//客户关联业务员的id
							//非连锁版 判断当前 业务员的id 是否与 当前用户id相等
							if(productversion != "2"){
								if(clientToExt3 != undefined && clientToExt3 != null && clientToExt3 != ""){
									if(String(userid).toUpperCase() != String(clientToExt3).toUpperCase() ){
										$(txbId).addClass("inputTextFontRed");
										showErrorMsg("您暂无权限为该客户开单");
										return;
									}else{
										$(txbId).removeClass("inputTextFontRed");
									}
								}else{
									$(txbId).removeClass("inputTextFontRed");
								}
							}else{
								/*
								 *连锁版先判定当前客户 是否是共享客户
								 *如果不是 共享客户  则判定 所在门店 与 所选择的 门店是否一致 
								 */
								if(clientisShared != 1){
									if(String(clientBranchid).toUpperCase() == String(branchid).toUpperCase()){
										//是同门店 且 不是共享的
										$(txbId).removeClass("inputTextFontRed");
										if(clientToExt3 != undefined && clientToExt3 != null && clientToExt3 != ""){
											if(String(userid).toUpperCase() != String(clientToExt3).toUpperCase() ){
												$(txbId).addClass("inputTextFontRed");
												showErrorMsg("您暂无权限为该客户开单");
												return;
											}
										}
									}else{
										//不是共享 且不是同门店的
										$(txbId).addClass("ls-error");
										showErrorMsg("该客户与其他门店客户重复，请修改");
										return;
									}
								}else{
									$(txbId).removeClass("inputTextFontRed");
								}
							}
							
						}else{
							$(txbId).removeClass("inputTextFontRed");
							$(txbId).removeClass("ls-error");
							if(productversion == "2"){
								if(clientisShared != 1){
									if(String(clientBranchid).toUpperCase() != String(branchid).toUpperCase()){
										//不是共享 且不是同门店的
										$(txbId).addClass("ls-error");
										showErrorMsg("该客户与其他门店客户重复，请修改");
										return;
									}
								}
							}
						}
						$(txbValue).val(o["clientid"]);
						$(txbId).val(o["clientname"]);
						
						if(isClientReceive){
							var receivables=o["receamt"];
							if(receivables==''||receivables==undefined){
								receivables="0";
							}
							$("#txbCr").val(o["clientname"]);
							$("#amtreceivables").val(receivables);
							$("#clientid").val(o["clientid"]);
							$("#clientbranchid").val(o["branchid"]);
							$("#clientisshared").val(o["isshared"]);
						}
					}else{
						$(txbId).removeClass("ls-error");
						$(txbId).removeClass("inputTextFontRed");
					}
				}	
			});
		}
	},300);
	
}

// 核销
function HXRC(obj, busiId, busiType, hxType) {
  var msg = "";
  if (hxType == 1) {
      msg = "确定要核销这张单据吗？";
  }
  if (hxType == 2) {
      msg = "确定要撤销已核销的这张单据吗？";
  } 
  $.ajax({
      dataType: "json",
      data: {
          busiId: busiId,
          busiType: busiType,
          hxType: hxType
      },
      url: "HomePage/HXRC.json",
      cache: false,
      type: "post",
      async: false,
      success: function (data) {
          var resultArr = data.result.split("|");
          if (resultArr.length == 3) {
              if (hxType == 1) {
                  $(obj).parent().parent().find('.hxqk').hide();
                  $(obj).parent().parent().find('.hhxqk').show();
                  $(obj).parent().parent().find('.hxTime').html(resultArr[1]);
                  $(obj).parent().parent().find('.hxUser').html(resultArr[2]);
              }
              else {
                  $(obj).parent().parent().parent().parent().find('.hxqk').show();
                  $(obj).parent().parent().parent().parent().find('.hhxqk').hide();
              }
          }
          else {
              showErrorMsg(data);
          }
      },
      error: function () {
    	  showErrorMsg("核销失败");
      }
  }); 
}

/**
 * 获取最近售价
 * @param productid
 * @param productunit
 * @param clientid
 * @param clientname
 * @returns {String}
 */
function getNearSalePrice(productid,productunit,clientid,clientname){
	if(1 != $("#hidIsOpenMultipleWarehouse").val()){//没开启多仓
		var branchid=$("#choose-warehouse-parentval").val(); 
	}else{//开启
		branchid =$("#hidbranchid").val();	
	}
	if(clientname==''){
		clientname="EMPTY";
	}
	var nearPrice="";
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  productid: productid,
	          productunit: productunit,
	          clientid: clientid,
	          clientname:clientname,
	          branchid:branchid
	      },
	      url: "Sale/getNearSalePrice.json",
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data!=null&&data.nearprice!=null){
	    		  nearPrice=parseFloat(data.nearprice).formatMoney();
	    		  specialprice = parseFloat(data.specialprice).formatMoney();
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	
	 return nearPrice;
}
/**
 * 获取最近售价
 * @param productid
 * @param productunit
 * @param clientid
 * @param clientname
 * @returns {String}
 */
/*function getNearUnitSalePrice(productid,productunit,clientid,clientname){
	if(1 != $("#hidIsOpenMultipleWarehouse").val()){//没开启多仓
		var branchid=$("#choose-warehouse-parentval").val(); 
	}else{//开启
		branchid =$("#hidbranchid").val();	
	}
	if(clientname==''){
		clientname="EMPTY";
	}
	var nearPrice="";
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  productid: productid,
	          productunit: productunit,
	          clientid: clientid,
	          clientname:clientname,
	          branchid:branchid
	      },
	      url: "Sale/getNearUnitSalePrice.json",
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data!=null&&data.nearprice!=null){
	    		  nearPrice=parseFloat(data.nearprice).formatMoney();
	    		  specialprice = parseFloat(data.specialprice).formatMoney();
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	
	 return nearPrice;
}*/
/**
 * 获取商品的特价/最近售价/等级价
 * */
function getNearSalePriceSpecial(productid,productunit,clientid,clientname){
	if(1 != $("#hidIsOpenMultipleWarehouse").val()){//没开启多仓
		var branchid=$("#choose-warehouse-parentval").val(); 
	}else{//开启
		branchid =$("#hidbranchid").val();	
	}
	if(clientname==''){
		clientname="EMPTY";
	}
	var nearPrice="";
	var specialprice = "";
	var ProductInfoSB="";
	var json={};
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  productid: productid,
	          productunit: productunit,
	          clientid: clientid,
	          clientname:clientname,
	          branchid:branchid
	      },
	      url: "Sale/getSalePriceSNR.json?"+Math.random(),
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data!=null&&data.nearprice!=null){
	    		  nearPrice=parseFloat(data.nearprice).formatMoney();
	    	  }
	    	  if(data!=null&& data.specialprice != null){
	    		  specialprice = parseFloat(data.specialprice).formatMoney();
	    	  }
	    	  if(data != null && data.ProductInfoSB != null){
	    		  ProductInfoSB = data.ProductInfoSB;
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	 json.nearPrice=nearPrice;
	 json.specialprice=specialprice;
	 json.ProductInfoSB = ProductInfoSB;
	 return json;
}

/**
 * 获取商品特价
 */
function getSpecialPrice(productid, productunit){
	var specialPrice="";
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  productid: productid,
	          productunit: productunit
	      },
	      url: "orderPlusManagerShopOrder/getSpecialPrice.json",
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data!=null&&data.specialprice!=null&&data.specialprice!=''){
	    		  specialPrice=parseFloat(data.specialprice).formatMoney();
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	 return specialPrice;
}

function getNearBuyPrice(productid,productunit,clientid,clientname){
	var nearPrice="";
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  productid: productid,
	          productunit: productunit,
	          clientid: clientid,
	          clientname:clientname
	      },
	      url: "Buy/getNearBuyPrice.json",
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data!=null&&data.nearprice!=null&&data.nearprice!=""){
	    		  nearPrice=parseFloat(data.nearprice).formatMoney();
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	 return nearPrice;
}
function funTipChooseWarehouse(t){
	var branchid=$("#choose-warehouse-parentval").val();
	var productversion=$("#hidproductversion").val();
	var isopenmultiplewarehouse = parent.$("#hidisopenmultiplewarehouse").val(); 
	if("1"!=isopenmultiplewarehouse && (productversion!="1"&&productversion!="3") && branchid==""){
		if(t=='0'){
			showErrorMsg("请选择出库仓库!");
			return;
		}else{
			showErrorMsg("请选择入库仓库!");
			return;
		}
	}
	levelSelect.show('user');
}
function setPrintTemplateList(busitype){
	var tempcode="";
	var tempcodeArr=new Array('00','01','02','03','04','05');
	switch (busitype) {
	case 302:
		tempcodeArr=new Array('00','01');
		break;
	case 301:
		tempcodeArr=new Array('00','01','02','03','04','05');
		break;
	case 3:
		tempcodeArr=new Array('00','01','02','03','04','05');
		break;
	case 101:
		tempcodeArr=new Array('00','01','02','03','04');
		break;
	case 1:
		tempcodeArr=new Array('00','01','02','03','04');
		break;
	case 4:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 2:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 7:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 8:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 9:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 10:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 11:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 21:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 20:
		tempcodeArr=new Array('00','01','02','03');
		break;
	case 22:
		tempcodeArr=new Array('00','01');
		break;
	case 23:
		tempcodeArr=new Array('00','01');
		break;
	case 24:
		tempcodeArr=new Array('00','01');
		break;
	case 25:
		tempcodeArr=new Array('00','01');
		break;
	case 26:
		tempcodeArr=new Array('00','01','02','03','04','05');
		break;	
	case 27:
		tempcodeArr=new Array('00','01');
		break;
	case 28:
		tempcodeArr=new Array('00','01');
		break;
	case 29:
		tempcodeArr=new Array('06','07');
		break;
	}
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  busitype: busitype
	      },
	      url: "/UCenter-webapp/PrintTemplate/TemplateList.json",
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data==null||data.listMap.length==0){
	    		  tempcode="all";
	    	  }else{
	    		  for(var i=0;i<data.listMap.length;i++){
	    			  if(data.listMap[i].isshow==0){
	    				  tempcodeArr=deleteArray(tempcodeArr,data.listMap[i].templatecode);
	    			  }
	    		  }
	    		  tempcode=tempcodeArr.join(',');
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	 return tempcode;
}
function deleteArray(list,key){
	var index=0;
    for(var i=0;i<list.length;i++){
    	if(list[i]==key){
    		index=i;
    		break;
    	}
    }
    list.splice(index,1);
    return list;
}
// 取得选中的id列表
function getSelectIds() {
	var cids = "";
	var selCtrls = $("input[listcheck='0']:checked");
	var id_len = selCtrls.length;
	for (var i = 0; i < id_len; i++) {
		if(i==0){
			cids += selCtrls[i].value ;
		} else {
			cids += ','+selCtrls[i].value;
		}
	}
	return cids;
}
function getTemplateName(Busi,templatecode,ReportGrf,isMulti){
	var templateurl="";
	if(ReportGrf==null||ReportGrf==""){
		ReportGrf=getReportGrfName(Busi,templatecode);
	}
	var pid = null;
	pid = request("pid");//从请求url中获取pid
	if(null==pid || ""==pid || undefined==pid)
		pid = getCookie("pid");
	$.ajax({
 	      dataType: "json",
 	      data: {
 	    	  Busi: Busi,
 	    	  templatecode:templatecode,
 	    	  ReportGrf:ReportGrf,
 	    	  isMulti:isMulti
 	      },
 	      url: "/UCenter-webapp/Print/getPrintReportUrl.json?pid="+pid,
 	      cache: false,
 	      type: "post",
 	      async: false,
 	      success: function (data) {
 	    	  if(data!=null&&data.ReportGrf!=""){
 	    		 if (data.ReportGrf != ""&&data.ReportGrf.indexOf("http") == -1)
 	    			templateurl = "/UCenter-webapp/printreport/" + data.ReportGrf + "?RAND=" + Math.random();
 	            else
 	            	templateurl = data.ReportGrf + "?RAND=" + Math.random();
 	    		 
 	    	  }
 	      },
 	      error: function () {
 	          
 	      }
 	  }); 
	return templateurl;
}

function getReportGrfName(Busi,Tempcode){
	var isOpenSaleDetailDiscount="";
	var oddProcess="";
	if($("#hidIsOpenSaleDetailDiscount").val()!=undefined){
		isOpenSaleDetailDiscount=$("#hidIsOpenSaleDetailDiscount").val();
	}
	if($("#hidOddProcess").val()!=undefined){
		oddProcess=$("#hidOddProcess").val();
	}
	if(Busi=="ShopOrder"){
		switch(Tempcode){
		case "00":
			return "ShopOrderDetail1.grf";
		case "01":
			return "ShopOrderDetail1.grf";
		}
	}
	if(Busi=="Sale"){
		switch(Tempcode){
		case "00":
			return "SaleDetail1"+isOpenSaleDetailDiscount+oddProcess+".grf";
		case "01":
			return "SaleDetail1"+isOpenSaleDetailDiscount+oddProcess+".grf";
		case "02":
			return "SaleDetail.grf";
		case "03":
			return "SaleDetail140.grf";
		case "04":
			return "SaleDetail190.grf";
		case "05":
			return "SaleDetail_POS.grf";
		}
	}else if(Busi=="SaleOrder"){
		switch(Tempcode){
		case "00":
			return "SaleOrderDetail1"+isOpenSaleDetailDiscount+oddProcess+".grf";
		case "01":
			return "SaleOrderDetail1"+isOpenSaleDetailDiscount+oddProcess+".grf";
		case "02":
			return "SaleOrderDetail.grf";
		case "03":
			return "SaleOrderDetail140.grf";
		case "04":
			return "SaleOrderDetail190.grf";
		}
	}else if(Busi=="Sell"){
		switch(Tempcode){
		case "06":
			return "SellDetail58"+isOpenSaleDetailDiscount+oddProcess+".grf";
		case "07":
			return "SellDetail80"+isOpenSaleDetailDiscount+oddProcess+".grf";
		}
	}
}

/**
 * 保存套餐
 * @param ptid
 * @param count
 * @param ishide
 * @param ptdetailid
 */
function bindPTDetail(ptid, count, ishide,ptdetailid,warehouseid,warehousename) {
	if(warehouseid==""){
		warehousename='预订';
	}
	var warehouse;
	if(1==$("#hidIsOpenMultipleWarehouse").val() || parent.$("#hidisopenmultiplewarehouse").val()=="1"){//开启多仓
		warehouse = warehouseid;
	}else{
		warehouse = $("#choose-warehouse-val").val();
	}
	$.ajax({
		dataType : "json",
		data : {
			ptid : ptid,
			warehouse : warehouse
		},
		cache : false,
		async : false,
		url : "/UCenter-webapp/ProductDT/getTemplateProductsPage.json?" + Math.random(),
		type : "post",
		success : function(o) {
			var row=null;
			var snmanage=null;
			var count=null;
			var isopenio=$("#isopenio",parent.document).val();
			for ( var i = 0; i < o.rows.length; i++) {
				count=1;
				o.rows[i]["ptdetailid"] = ptdetailid;
				o.rows[i]["warehouseid"]= warehouseid;
				o.rows[i]["warehousename"]=warehousename;
				if (ishide == 1) {
					o.rows[i]["type"] = "0";
				}else {
					if (isNI == "0" && warehouse!="") {
						if(1==$("#hidIsOpenMultipleWarehouse").val() || parent.$("#hidisopenmultiplewarehouse").val()=="1"){
							if(parseFloat(o.rows[i].canusestockcount)<(parseFloat(count)*parseFloat(o.rows[i].realcount))){
								continue;
							}
						}else{//关闭多仓时
							var busiType= $("#busitype").val();
							if('AddSaleOrder'!= busiType){	//新增销售订单 无需 库存判断
								if(parseFloat(o.rows[i].canusestockcount)<(parseFloat(count)*parseFloat(o.rows[i].realcount))){
									continue;
								}
							}
						}
						
					}
				}
				snmanage=o.rows[i].snmanage;
				count=o.rows[i].count;
				row=o.rows[i];
				if('1'==snmanage&&'0'==isopenio)
				{
					row.count=0;
				}
				binddetaildata(row, ishide);
			}
		},
		error : function() {
			showErrorMsg("获取模板明细失败");
		}
	});
}

//校验套餐商品库存后为库存不足商品标红
function redPTproductName(obj,ptid,stockcount,txbcount){
	var productname = $(obj).parent().parent().find("input[name='hidproductname']").val();
	$("input[name='hidptid'][value='" + ptid + "']").each(function() {
		if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="1"){
			var li = $(this).parent().parent().find('ul li ');
			var len = li.length;
			if(len > 0){
				for(var i=0 ; i<len;i++ ){
					if($(li[i]).find('h3').text() == productname){
						if(stockcount < txbcount){
							//销售订单 选择 预订仓库时  不做库存标红 显示
							var warehouseid =  $(this).parent().parent().find("input[name='hiddetailwarehouseid']").val();
							if(warehouseid != undefined && warehouseid != ""){
								$(li[i]).parent().parent().parent().find('.spanproductname').addClass("fontRed");
								$(li[i]).parent().parent().find('h1').addClass("fontRed");
								$(li[i]).find('h3').addClass("fontRed");
							}else{
								$(li[i]).find('h3').removeClass("fontRed");
								//商品名称移除fontRed
								var productNameElement = $(li[i]).parent().parent().parent().find('.spanproductname');
								//如果是商品已停用，则不移除fontRed样式
								var productNameRedBecauseProductIsStop = productNameElement.attr("productNameRedType");
								if("isstop"!=productNameRedBecauseProductIsStop)
									productNameElement.removeClass("fontRed");
								$(li[i]).parent().parent().find('h1').removeClass("fontRed");
							}
						}else{
							$(li[i]).find('h3').removeClass("fontRed");
							//商品名称移除fontRed
							var productNameElement = $(li[i]).parent().parent().parent().find('.spanproductname');
							//如果是商品已停用，则不移除fontRed样式
							var productNameRedBecauseProductIsStop = productNameElement.attr("productNameRedType");
							if("isstop"!=productNameRedBecauseProductIsStop)
								productNameElement.removeClass("fontRed");
							$(li[i]).parent().parent().find('h1').removeClass("fontRed");
						}
					}
				}
				
				for(var i=0 ; i<len;i++ ){
					if($(li[i]).find('h3').hasClass("fontRed")){
						$(li[i]).parent().parent().parent().find('.spanproductname').addClass("fontRed");
						$(li[i]).parent().parent().find('h1').addClass("fontRed");
					}
				}
				
			}
			
		}
	});
}

/* 验证套餐下商品 */
//isSave = 1 表示 在保存单据时，不做价格的重新计算
function validatePTproductStock(ptid, count,isSave) {
	var hidisopenmultiplewarehouse =  $(parent.document).find("#hidisopenmultiplewarehouse").val();
	var flatstatus = 0;
	var productnames = "";
	var isNegative = GetNegativeInventory();
	if(String(isSave) != "1"){
		$("input[name='hidptid'][value='" + ptid + "']").each(function() {
			if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
				$(this).parent().parent().find("input[name='txbCount']").val(parseFloat($(this).parent().parent().find("input[name='hidptcount']").val()) * count).change();
			}});
	}
	//找到 套餐内 该商品在页面中的 商品数量（同一个仓库下）
	$("input[name='hidptid'][value='" + ptid + "']").each(function() {
		if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
			var stockcount = Number($.trim($(this).parent().parent().find("input[name='hidstockcount']").val()));
			
			var txbcount = 0;
			var productid = $(this).parent().parent().find("input[name='hidProductId']").val();
			//循环页面中商品为此商品的（同一个仓库） 数量
			if(hidisopenmultiplewarehouse == 1){
				var warehouseid = $(this).parent().parent().find("input[name='hiddetailwarehouseid']").val();
				$("input[name='hidProductId'][value='"+productid+"']").each(function(){
					var eachWarehouseId = $(this).parent().parent().find("input[name='hiddetailwarehouseid']").val();
					if(warehouseid == eachWarehouseId){
						var eachTxbCount = Number($.trim($(this).parent().parent().find("input[name='txbCount']").val()));
						var eachUnitRatio = $(this).parent().parent().find("input[name='hidunitratio']").val();
						if (eachUnitRatio != '' && Number(eachUnitRatio) > 0) {
							eachTxbCount = eachTxbCount * Number(eachUnitRatio);
						}
						txbcount = txbcount + eachTxbCount;
					}
				});
			}else{
				var eachTxbCount = Number($.trim($(this).parent().parent().find("input[name='txbCount']").val()));
				var eachUnitRatio = $(this).parent().parent().find("input[name='hidunitratio']").val();
				if (eachUnitRatio != '' && Number(eachUnitRatio) > 0) {
					eachTxbCount = eachTxbCount * Number(eachUnitRatio);
				}
				txbcount = txbcount + eachTxbCount;
			}
			
//			$("input[name='hidptid'][value='" + ptid + "']").each(function() {
//				if(productid == $(this).parent().parent().find("input[name='hidProductId']").val()){					
//					var everytxbcount = Number($.trim($(this).parent().parent().find("input[name='txbCount']").val()));
//					var unitratio = $(this).parent().parent().find("input[name='hidunitratio']").val();
//					var m = 0;
//					if (unitratio != '' && Number(unitratio) > 0) {
//						everytxbcount = everytxbcount * Number(unitratio);
//					}
//					txbcount = txbcount + everytxbcount;
//				}
//			});
			if (stockcount < txbcount) {
				if (isNegative == "0") {
					flatstatus = 1;
				} else {
					flatstatus = 2;
				}
				productnames = productnames + $(this).parent().parent().find("input[name='txbProductName']").val()+",";
			}
			//校验套餐商品库存后为库存不足商品标红
			redPTproductName(this, ptid,stockcount,txbcount);
		}
	});
	if(productnames.length > 0){
		productnames = productnames.substring(0,productnames.length-1)
	}
	return flatstatus + "|" + productnames;
}
/* 验证套餐下商品 */
function setPTproductStock(ptid, count) {
	$("input[name='hidptid'][value='" + ptid + "']").each(function() {
		if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
			$(this).parent().parent().find("input[name='txbCount']").val(parseFloat($(this).parent().parent().find("input[name='hidptcount']").val()) * count);
		}
	});
}
function calCompositionAmt(ptid, ptamt) {
	var compositionArr = new Array();
	var compositionArr2=new Array();
	//alert($("input[name='hidptid'][value='" + ptid + "']").size());
	$("input[name='hidptid'][value='" + ptid + "']").each(function() {
		//if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
		   compositionArr.push(Number($.trim($(this).parent().parent().find("input[name='hidptamt']").val())));
		//}
	});
	// alert(compositionArr.join(','));
	var sumAmt = sum(compositionArr);
	var maxIndex = 0;
	if (sumAmt <= 0) {
		$("input[name='hidptid'][value='" + ptid + "']").each(function() {
		//	if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
				compositionArr.push(Number($.trim($(this).parent().parent().find("input[name='hidptcount']").val())));
		//	}
		});
		sumAmt = sum(compositionArr);
	}
	compositionArr2=compositionArr;
	for ( var i = 0; i < compositionArr.length; i++) {
		compositionArr[i] = ptamt * compositionArr[i] / sumAmt;
		if(isNaN(compositionArr[i])){
			compositionArr[i] = 0;
		}
		compositionArr[i]=formatNumberN(parseFloat(compositionArr[i]),8);
	}
	var saleSumAmt = formatNumberN(parseFloat(sum(compositionArr)),8);
	var poorAmt = formatNumberN((ptamt-saleSumAmt),8);
	if (poorAmt != 0) {
		maxIndex = arrayMax(compositionArr2);
		compositionArr[maxIndex] = formatNumberN((parseFloat(compositionArr[maxIndex]) + parseFloat(poorAmt)),8);
	}
	$("input[name='hidptid'][value='" + ptid + "']").each(function(n) {
		if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
			$(this).parent().parent().find("input[name='txbAmt']").val(parseFloat(compositionArr[n]).formatMoney(true)).change();
		}
	});
}
function sum(list) {
	return eval(list.join("+"));
}
function arrayMax(list) {
	var maxVal = 0;
	var index = 0;
	for ( var i = 0; i < list.length; i++) {
		if (parseFloat(list[i]) > maxVal) {
			maxVal = list[i];
			index = i;
		}
	}
	return index;
}

function printbill(obj){ 
	window.location.href = $(obj).attr(
	"href"); 
    $(obj).attr("href","javascript:;");
	window.parent.$("#main_showPage .popArea").css("width", "100%");
	window.parent.$("#main_showPage .popArea").css("height", "100%");
	window.parent.$("#main_showPage .popArea .content").css("height", "100%");
	window.parent.$("#main_showPage .popArea").css("left", "0");
	window.parent.$("#main_showPage .popArea").css("top", "0");
}

function initprint(busitype){
	var productversion=parent.$('#productversion').val();
	if(productversion==3){//如果是免费用户，使用freeprintreport目录下的打印模板
		$('a').each(function(){
			if($(this).attr('class').indexOf('temp')>-1){
				var url=$(this).attr('href');
				if(url.indexOf('ReportGrf=')>-1){
					var re=new RegExp("ReportGrf=","g");
					url=url.replace(re,"ReportGrf=freeprintreport/");
					$(this).attr('href',url);
				}
			}
		});
	}
	// $(".shadowBoxWhite").parent().click(function() {
	// printbill(this);
	// });
	var templatecode = '';
	$(".shadowBoxWhite").parent().hide();
	var tempcode = setPrintTemplateList(busitype);
	var tempcodeArr;
	if (tempcode == "all") {
		$(".shadowBoxWhite").parent().show();
	} else {
		tempcodeArr = tempcode.split(",");
		$.each(tempcodeArr, function(index, value) {
			$(".temp" + value).show();
			templatecode = value;
		});
		if (tempcodeArr.length == 1) {
			window.open($(".temp" + templatecode).attr(
			"href"));
		}
	}
}
function setPackageProductList(obj, ptid, productname) {
	var phtml = '<h1>' + productname + '</h1>';
	phtml += '<h2>成分商品</h2>';
	phtml += '<ul>';
	$("input[name='hidptid'][value='" + ptid + "']").each(function() {
		if($(this).parent().parent().find("input[name='hiddetailtype']").val()!="1"){
			phtml += '<li>';
			phtml += '<h3>'+$(this).parent().parent().find("input[name='txbProductName']").val()+'</h3>';
			phtml += '<p class="font999">';
			phtml += '<span class="fr">￥'+parseFloat($(this).parent().parent().find("input[name='hidptamt']").val()).formatMoney()+'</span>';
			phtml += '<span class="fl mr20">'+parseFloat($(this).parent().parent().find("input[name='hidptcount']").val()).formatNum(true)
			       +$(this).parent().parent().find("input[name='txbUnit']").val()+'*￥'
			       +parseFloat($(this).parent().parent().find("input[name='hidptprice']").val()).formatMoney()+'</span>';
			phtml += '</p>';
			phtml += '</li>';
		}
	});
	phtml += '</ul>';
	$(obj).find(".packageList").html(phtml);
}
function GetNegativeInventory() {
	var NIVal = -1;
	$.ajax({
		dataType : "json",
		cache : false,
		async : false,//不能为异步
		url : "Sale/getNegativeInventoryVal.json?" + Math.random(),
		type : "post",
		success : function(o) {
			NIVal = o.data;
		},
		error : function() {
			showErrorMsg("获取业务设置失败");
		}
	});
	return NIVal;
}

function getUrlParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = parent.window.location.search.substr(1).match(reg);
	if (r!=null) return unescape(r[2]); return null;
}

function setInventory(warehouseid,detailjson,type,busiid)
{
	parent.parentsetInventory(warehouseid,detailjson,type,busiid);
	return;
	var productIdArray=new Array();
	var productid=null;
	var record=null;
	var productids="";
	if(null==warehouseid)
	{
		warehouseid="";
	}
	if(null!=detailjson)
	{
		for(var i in detailjson)
		{
			record=detailjson[i];
			productid=record.productid;
			productIdArray.push(productid);
		}
		productids=JSON.stringify(productIdArray);
	}
	if(undefined==type)
	{
		type="";
	}
	if(undefined==busiid)
	{
		busiid="";
	}
	$.ajax({
		async:true,
	    url:'/UCenter-webapp/commondata/GetInventory.json',
	    data:{
	    	warehouseid:warehouseid,
	    	productids:productids,
	    	type:type,
	    	busiid:busiid
	    },
	    type:'post',    
	    cache:false,    
	    dataType:'json',    
	    success:function(data) {
	    	var serviceResult=data.serviceResult;
	    	var statu=serviceResult.statu;
	    	if('1'==statu)
	    	{
	    	}
	    	else
	    	{
	    		showErrorMsg("计算库存相关失败1");
	    	}
	    }
// ,
// error : function() {
// showErrorMsg("计算库存相关失败2");
// }
	});
	setTimeout('donothing()',500);
} 

/**
 * 计算库存新的方法多一个参数busidate，业务日期
 * @param busidate
 * @param warehouseid
 * @param detailjson
 * @param type
 * @param busiid
 */
function setNewInventory(busidate,warehouseid,detailjson,type,busiid)
{
	parent.parentsetNewInventory(busidate,warehouseid,detailjson,type,busiid);
} 

function donothing(){}

function importProductInit(title){
	var pageid=$("#pageid").val();
	var url = "commondata/ImportProductInit.htm?title="+encodeURI(title)+"&pageid="+pageid;
	var id = "commondata-ImportProductInit";
	if($("#crvalue").val() != undefined && $("#crvalue").val() != ""){
		url = url+"&supplierid="+$("#crvalue").val()
	}
	parent.addTabByTitleAndUrl(title, url, id,"WBILL");
}

function tranimport(title)
{
	var warehouseid=$("#outwarehouse").val();
	if(1!=$("#hidIsOpenMultipleWarehouse").val()){
		if (warehouseid  == "" || warehouseid == null) {
			showErrorMsg("请选择出库仓库");
			return;
		}
	}
	var pageid=$("#pageid").val();
	var url = "commondata/tranimport.htm?title="+encodeURI(title)+"&pageid="+pageid+"&warehouseid="+warehouseid;
	var id = "commondata-tranimport";
	parent.addTabByTitleAndUrl(title, url, id,"WBILL");
}
function saleimport(title){
	var txsaletype = 1;//零售
	if($("#txsaletype").val().indexOf("批发")>=0){
		txsaletype=2;//批发
	}
	
	var IsOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	var warehouseid = $("#choose-warehouse-val").val();
	if(IsOpenMultipleWarehouse !=1){
		if(warehouseid== undefined || warehouseid =="" || warehouseid==null){
			showErrorMsg("请选择出库仓库!");
			return;
		}
	}
	var clientid = $("#crvalue").val();
	var pageid=$("#pageid").val();
	var url = "commondata/saleimport.htm?title="+encodeURI(title)+"&pageid="+pageid+"&warehouseid="+warehouseid+"&txsaletype="+txsaletype+"&clientid="+clientid;
	var id = "commondata-saleimport";
	parent.addTabByTitleAndUrl(title, url, id,"WBILL");
}

//销售订单导入
function saleorderimport(pageType){
	var isMultiWarehouse = $("#ismultiwarehouse").val();
	var warehouseid = $("#choose-warehouse-val").val();
	var txsaletype = 1;//零售
	if($("#txsaletype").val().indexOf("批发")>=0){
		txsaletype=2;//批发
	}
	var clientid = $("#crvalue").val();
	var url = "commondata/saleorderimport.htm?warehouseid="+warehouseid+"&clientid="+clientid+"&importpagetype="+pageType+"&txsaletype="+txsaletype;
	var id = "commondata-saleorderimport";
	var title = "销售订单商品导入";
	if("51" == parent.$("#productversion").val())
		title = "门店订单商品导入";
	parent.addTabByTitleAndUrl(title, url, id,"WBILL");
}

function checksession() {
	var flag = false;
	$.ajax({ 
		async:false,
	    url:'../UCenter-webapp/index/checksession.json',// 跳转到 action    
	    data:{    
	    },    
	    type:'post',    
	    cache:false,    
	    dataType:'json',    
	    success:function(data) {
	    	if(data.flag=='1')
	    	{
	    		$('.loadding').hide();
	    		window.parent.showMainPage('../UCenter-webapp/Login/reloginpassword.htm.htm?random'+Math.random(),'录入密码',200,400);
	    		flag = true;
	    	} else if(data.flag=='4'){
				var pv = $(parent.document).find("#productversion").val();
				if(pv == 51){
					window.parent.location.href='../UCenter-webapp/orderPlusLogin/init.htm?msg=4';
				}else{
					window.parent.location.href='../UCenter-webapp/Login/Init.htm?msg=4';
				}
			}
	    },    
	    error : function() {    
	    }    
	}); 
	return flag;
}

//用户页面href 重定向使用，作用：校验session 过期弹出录入密码框页面
function openUrl(url){
	if(checksession()){
		return;
	}else{
		location=url;
	}
}


function auditorder(auditstate,audittype,ids){
	$.YY_post("commondata/auditorder.json", 
		{  	auditstate:auditstate,
	    	audittype:audittype,
	    	ids:ids
		}, function(data){
			if(data.result=="success"){
	    		if(auditstate==1){
	    			showSuccessMsg("审核成功");
	    		}else if(auditstate==0){
	    			showSuccessMsg("反审核成功");
	    		}
	    		try{
//	    			$("#resultList").flexReload(myPage,true, false);	
	    			$("#refresh").click();			
	    		}catch(Exception){
	    		}
	    	}else{
	    		showErrorMsg("操作失败");
	    	}
		}, null , null , null , false );
}



//时间戳
function timestamp() {
	return '&t='+new Date().getTime()+''+Math.floor(Math.random()*9999+1000);
}

//是否免税
function isDutyFree()
{
	var txbRate=null;
	var flag=true;
	$("#tabdetail tr:gt(0)").find("input[name='txbRate']").each(function() {
		txbRate=$(this).val();
		if(null!=txbRate&&undefined!=txbRate&&''!=txbRate)
		{
			txbRate=txbRate*1;
			if(txbRate!=0)
			{
				flag=false;
			}
		}
	});
	//免税
	if(flag)
	{
		$("#chkms").attr("checked","checked");
		$("#chkfreerate").attr("checked","checked");
	}
}



//初始化最近销售单位
function initNearUnitByJson(datarow,busiaction){ 
	//销售类型 0：零售   1：批发
	var billtype = $("#hidselectsaletype").val();
	var productid=datarow.productid;
	//初始化最近单位
	if(datarow.cpProductUnitSBs.length > 1){
		//销售
		if(busiaction=='Sale' || busiaction=='SaleReturn' || busiaction=='SaleOrder'){
			var unitid=getNearSaleUnitId(productid,billtype);
			if(unitid!=''){
				$.each(datarow.cpProductUnitSBs,function(index,value){
					if(value.unitid.toLowerCase()==unitid.toLowerCase()){
						datarow.mainsaleprice=value.saleprice;
						datarow.mainpfprice=value.pfprice;
						datarow.mainspecialprice=value.specialprice;
						datarow.mainisspecial=value.isspecialproduct;
						datarow.lowerprice=value.lowerprice;
						datarow.mainunitid=value.unitid;
						datarow.isdecimal=value.isdecimal;
						datarow.mainunitname=value.unitname;
						datarow.unitradio=value.unitratio;
					}
				});
			}
		}
		//进货
		if(busiaction=='Buy' || busiaction=='BuyReturn'){
			var unitid=getNearBuyUnitId(productid,billtype);
			if(unitid!=''){
				$.each(datarow.cpProductUnitSBs,function(index,value){
					if(value.unitid.toLowerCase()==unitid.toLowerCase()){
						datarow.mainsaleprice=value.saleprice;
						datarow.mainbuyprice=value.buyprice;
						datarow.mainpfprice=value.pfprice;
						datarow.lowerprice=value.lowerprice;
						datarow.mainunitid=value.unitid;
						datarow.isdecimal=value.isdecimal;
						datarow.mainunitname=value.unitname;
						datarow.unitradio=value.unitratio;
					}
				});
			}
		}
	}
	return datarow;
}
/**
 * 初始化最近价格:
 * </br>
 * 先选了客户时
 * 特价>最近售价>等级价>业务类型价
 * </br>
 * 未选择客户时
 * 特价>业务类型价>最近售价>等级价
 */
function initSalePriceSNRAsyncTrue(isChageSaleType){
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();//客户等级价
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	//var remmberClientid = $("#remmberClientid").val();//上一个客户的id
	var clientid = $("#crvalue").val();//客户id
	var clientname = $("#txbCr").val();//客户名称
	var branchid= $("#choose-warehouse-parentval").val();//门店ID 
	if(1 == $("#hidIsOpenMultipleWarehouse").val()){//开启多仓
		branchid =$("#hidbranchid").val();	
	}
	//价格权限 1-零售 2-批发价 3-参考进货价 4-最低售价 5-成本价 9-等级价
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	var url = window.location.href;
	var inputloading = "input[name='moneyLoadingTxbPrice']";
	var inputxb = "input[name='txbPrice']";
	var ulname = "ul[name='ulpriceli']";
	if(hidisopensaledetaildiscount == "1"){
		inputxb = "input[name='txbDiscountPrice']";
		inputloading = "input[name='moneyLoadingDis']";
		ulname = "ul[name='Disulpriceli']";
	}
	//金额合计行 ，合计金额，总计金额，实收金额，实退金额
	//显示loading 样式
	//合计行金额
	//if(url.indexOf("SaleOrder/TurnSale.htm") < 0){
		$("#sumAmt").hide();
		$("#moneyLoadingSumAmt").show();
		//合计金额
		$("#tdTotal").hide();
		$("#moneyLoadingTotalspan").show();
		//总计金额
		$("#tdFaRece").hide();
		$("#tdmoneyLoadingFaRece").show();
		//实收金额,实退金额
		$("#txbreceamt").hide();
		$("#txbpayamt").hide();
		$("#moneyLoadingRece").show();
		//保存标志 当保存标志为1时 表示 正在初始化价格 初始化完毕后 此值为0
		$("#savebillFlag").val("1");
	//}
	//var rows = 	Number(document.getElementById("tabdetail").rows.length) - 1;//总行数 去除首行
	var initCount = 0;//获取需要被初始化价格的有多少行商品
	$("#tabdetail tr:gt(0)").each(function(){
		 //套餐成分商品不处理
		var hiddetailtype = $(this).find("input[name='hiddetailtype']").val();
		if($(this).is(":hidden")){
			return;
		}
		 //开启单行折扣时，改变了销售类型，则对单价行进行业务类型重新赋值
		if(isChageSaleType ){
			$(this).removeAttr("init_price_flag");
			$(this).removeAttr("init_c_foreach");
			if(hidisopensaledetaildiscount == "1" && hiddetailtype != "1"){
				if("1" == selectsaletype){//批发
					  $(this).find("input[name='hidpricetype']").val("2");
		  			  var pfprice =  $(this).find("input[name='hidselpfprice']").val();
					  if(pfprice == undefined || pfprice == "-" || pfprice+"" == ""){
						  pfprice = 0;
					  }
					  if(isAdmin != "true" && permflag.indexOf(";2;") < 0 ){
						  $(this).find("input[name='txbPrice']").val(Number(0).formatMoney());
					  }else{
						  $(this).find("input[name='txbPrice']").val(Number(pfprice).formatMoney());
					  }
		  			  $(this).find("input[name='hidisgetnearprice']").val("0");
		  		   }else{
		  			  $(this).find("input[name='hidpricetype']").val("1");
		  			  var saleprice = $(this).find("input[name='hidselprice']").val();
		  			  if(saleprice == undefined || saleprice == "-" || saleprice+"" == ""){
		  				  saleprice = 0;
			    	  }
		  			  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 ){
		  				  $(this).find("input[name='txbPrice']").val(Number(0).formatMoney());
		  			  }else{
		  				  $(this).find("input[name='txbPrice']").val(Number(saleprice).formatMoney());
		  			  }
			  		  $(this).find("input[name='hidisgetnearprice']").val("0");
		  		   }
			}
		}
		//获取本行的隐式表示 判断 此行是否已经获取过了
		var trflag = $(this).attr("init_price_flag");
		//复制新增/编辑页面 初始化的数据不进行 价格初始化加载
		var cforeachflag = $(this).attr("init_c_foreach");
		var productid = $(this).find("input[name='hidProductId']").val();
		//当trflag不等于1时 表示 该行商品 未获取过初始化价格
		//也要过滤套餐及其 成分商品
		if(trflag != "1" && cforeachflag != "1" && productid != undefined && productid != "" ){
			initCount++;
		}
	});
	
	//如果客户累计欠款显示了 先进行隐藏
	var isHideDivReceamt = false;
	if($("#divreceamt").is(":visible")){
		$("#divreceamt").hide();
		isHideDivReceamt = true;
	}
	var haveProductCount = 0;//初始化的商品数量
	$("#tabdetail tr:gt(0)").each(function(){
		//改变了 销售类型
		if(isChageSaleType){
			$(this).removeAttr("init_price_flag");
			$(this).removeAttr("init_c_foreach");
		}
		//获取本行的隐式表示 判断 此行是否已经获取过了
		var trflag = $(this).attr("init_price_flag");
		//复制新增/编辑页面 初始化的数据不进行 价格初始化加载
		var cforeachflag = $(this).attr("init_c_foreach");
		var productid = $(this).find("input[name='hidProductId']").val();
		//当trflag不等于1时 表示 该行商品 未获取过初始化价格
		//也要过滤套餐及其 成分商品
		//var hiddetailtype = $(this).find("input[name='hiddetailtype']").val();
		if(trflag != "1" && cforeachflag != "1" && productid != undefined && productid != "" && $(this).is(":visible") ){
			var pcount = haveProductCount++;//当前循环到了哪一行
			//if(url.indexOf("SaleOrder/TurnSale.htm") < 0){
				//初始化加载前 显示loading 样式
				$(this).find(inputloading).show();//单价/折后单价列
				$(this).find(inputxb).hide();//单价/折后单价列
				$(this).find("input[name='moneyLoadingTxbAmt']").show();//金额列
				$(this).find("input[name='txbAmt']").hide();//金额列
			//}
			//判断是否是多单位商品
			var multiUnitFlag = false;
			if($(this).find("a[name='aunit']").is(":visible")){
				multiUnitFlag = true;
				$(this).find("a[name='aunit']").hide();
			}
			//权限判断
			if (isAdmin != "true" && permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 ) {
				//获取特价
				var isHaveSP = false;
				if( productversion == "51" ){
					var specialPrice = $(this).find(ulname).find("span[name='spanspecialsaleprice']").text();
					if(specialPrice != undefined && String(specialPrice) != "" && specialPrice != null && String(specialPrice) != "null"){
						//有特价
						isHaveSP = true;
						if(hidisopensaledetaildiscount == "1"){
							$(this).find("input[name='txbPrice']").val(0)
						}
						$(this).find(inputxb).val(specialPrice).change();
					}else{
						//无特价
						if(hidisopensaledetaildiscount == "1"){
							$(this).find("input[name='txbPrice']").val(0);
						}
						$(this).find(inputxb).val(0).change();
					}
				}
				if(!isHaveSP){
					if(hidisopensaledetaildiscount == "1"){
						$(this).find("input[name='txbPrice']").val(0);
					}
					$(this).find(inputxb).val(0).change();
				}
				$(this).find("input[name='hidisgetnearprice']").val(0);
				
				//去除loading 样式
	  			  $(this).find(inputloading).hide();
	  			  $(this).find("input[name='moneyLoadingTxbAmt']").hide();//金额列
	  			  $(this).find(inputxb).show();
	  			  $(this).find("input[name='txbAmt']").show();
	  			  //添加 价格初始化标记
		    	  $(this).attr("init_price_flag","1");
		    	  //绑定价格完毕后 显示 单位切换按钮
		    	  if(multiUnitFlag){
		    		  $(this).find("a[name='aunit']").show();
		    	  }
		    	  var rowindex = pcount+1;
		    	  if(rowindex == initCount){
		    		   //数据初始化完毕后，可以进行保存
		    			$("#savebillFlag").val("0");
		    			//隐藏loading 样式
		    			//合计行金额
		    			$("#sumAmt").show();
		    			$("#moneyLoadingSumAmt").hide();
		    			//合计金额
		    			$("#tdTotal").show();
		    			$("#moneyLoadingTotalspan").hide();
		    			//总计金额
		    			$("#tdFaRece").show();
		    			$("#tdmoneyLoadingFaRece").hide();
		    			//实收金额,实退金额
		    			$("#txbreceamt").show();
		    			$("#txbpayamt").show();
		    			$("#moneyLoadingRece").hide();
		    	  }
			}else{
				//有权限时
				var UnitId = $(this).find("input[name='hidUnitId']").val();
				if(clientname==''){
					clientname="EMPTY";
				}
				var obj = this;
				//获取特价/最近售价/等级价
			/*	var nearPrice="";
				var specialprice = "";
				var ProductInfoSB="";
				var json={};*/
				 $.ajax({
				      dataType: "json",
				      data: {
				    	  productid: productid,
				          productunit: UnitId,
				          clientid: clientid,
				          clientname:clientname,
				          branchid:branchid,
				          rowindex:pcount,
				          rowmultiUnitFlag:multiUnitFlag
				      },
				      url: "Sale/getSalePriceSNR.json?"+Math.random(),
				      cache: false,
				      type: "post",
				      async: true,
				      success: function (data) {
				    	  //各种价格
				    	  var SpecialPriceF= Number(0).formatMoney();//特价
				    	  var NearPriceF = Number(0).formatMoney();//最近售价
				    	  var saleTypePriceF = Number(0).formatMoney();//业务类型价 
				    	  var pfTypePriceF = Number(0).formatMoney();//业务类型价 
				    	  var RankPriceF =  Number(0).formatMoney();//等级价
				    	  
				    	  var rowindex = Number(data.rowindex)+1;//当前异步处理到了哪一行
				    	  //套餐
				    	  if($(obj).find("input[name='hiddetailtype']").val() == "1"){
				    		  $(obj).find(inputloading).hide();
				  			  $(obj).find("input[name='moneyLoadingTxbAmt']").hide();//金额列
				  			  $(obj).find(inputxb).show();
				  			  $(obj).find("input[name='txbAmt']").show();
				  			  //添加 价格初始化标记
					    	  $(obj).attr("init_price_flag","1");
					    	  if(rowindex == initCount){
					    		   //数据初始化完毕后，可以进行保存
					    			$("#savebillFlag").val("0");
					    			//隐藏loading 样式
					    			//合计行金额
					    			$("#sumAmt").show();
					    			$("#moneyLoadingSumAmt").hide();
					    			//合计金额
					    			$("#tdTotal").show();
					    			$("#moneyLoadingTotalspan").hide();
					    			//总计金额
					    			$("#tdFaRece").show();
					    			$("#tdmoneyLoadingFaRece").hide();
					    			//实收金额,实退金额
					    			$("#txbreceamt").show();
					    			$("#txbpayamt").show();
					    			$("#moneyLoadingRece").hide();
					    			//显示隐藏欠款
					    			if(isHideDivReceamt){
					    				$("#divreceamt").show();
					    			}
					    	  }
				    		  return;
				    	  }
				    	  //获取了价格后，进行初始化操作
				    	  //1.判断特价是否存在
				    	  var isHaveSpecialPrice = false;
				    	  if(productversion == "51"){
				    		  if(data!=null&& data.specialprice != null && data.specialprice != ""){
					    		  var specialprice = Number(data.specialprice).formatMoney();
					    		  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0){
					    			  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
						  			  $(obj).find("input[name='hidisgetnearprice']").val("0");
					    		  }else{
					    			  $(obj).find(inputxb).val(specialprice).change();
						  			  $(obj).find("input[name='hidisgetnearprice']").val("0"); 
					    		  }
					    		  SpecialPriceF=specialprice;
					  			  isHaveSpecialPrice = true;
					    	  }
				    	  }
				    	  //客户不存在时，第二步获取业务类型价格
				    	  var isHaveSaleTypePrice = false;
			    		  if("1" == selectsaletype){//批发
			    			  isHaveSaleTypePrice = true;
			    			 var pfprice =  $(obj).find("input[name='hidselpfprice']").val();
			    			 if(pfprice == undefined || pfprice == "-" || pfprice+"" == ""){
			    				 pfprice = 0;
			    			 }
			    			 
			    			 pfTypePriceF = Number(pfprice).formatMoney();
			    			 
				  			 $(obj).find("input[name='hidisgetnearprice']").val("0");
			    		  }else{
			    			  isHaveSaleTypePrice = true;
			    			  var saleprice = $(obj).find("input[name='hidselprice']").val();
			    			  if(saleprice == undefined || saleprice == "-" || saleprice+"" == ""){
			    				  saleprice = 0;
				    		  }
			    			  saleTypePriceF = Number(saleprice).formatMoney();
				  			  $(obj).find("input[name='hidisgetnearprice']").val("0");
			    		  }
				    	  var isHaveNearPrice = false;
			    		  //2.判断最近售价 是否存在
			    		  if(data!=null&& data.nearprice != null && data.nearprice != ""){
			    			  var nearPrice=Number(data.nearprice).formatMoney();
			    			  $(obj).find("input[name='hidisgetnearprice']").val("0");
			    			  NearPriceF = nearPrice;
				  			  isHaveNearPrice = true;
			    		  }
			    		  //是否是等级客户价格
				    	  var isHaveRankPrice = false;
				    	  if(productversion == "1" || productversion == "51"){
				    		  if(clientid != "" && clientid !=undefined && clientname!= "" && clientname != undefined ){
					    		  if(IsOpenClientRankPrice == 1){
					    			  //判断是否存在等级价
						    		  if(data!=null&& data.ProductInfoSB != null && data.ProductInfoSB != ""){
						    			  var chooseunitid = $(obj).find("input[name='hidUnitId']").val();
						    			  var rankprice1 = Number(0).formatMoney();
					    				  var rankprice2 = Number(0).formatMoney();
					    				  var rankprice3 = Number(0).formatMoney();
					    				  var ProductInfoSB = data.ProductInfoSB;
					    				  if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid1).toUpperCase()){
					    					    if(ProductInfoSB.pf1price1 != null && ProductInfoSB.pf1price1 != "null" && ProductInfoSB.pf1price1 != ""){
					    					    	rankprice1 = ProductInfoSB.pf1price1;
					    					    }
					    					    if( ProductInfoSB.pf2price1 != null &&  ProductInfoSB.pf2price1 != "null" &&  ProductInfoSB.pf2price1 != ""){
					    					    	rankprice2 = ProductInfoSB.pf2price1;
					    					    }
					    					    if(ProductInfoSB.pf3price1 != null && ProductInfoSB.pf3price1 != "null" && ProductInfoSB.pf3price1 != ""){
					    					    	rankprice3 = ProductInfoSB.pf3price1
					    					    }
					    					}
				    					 if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid2).toUpperCase()){
				    						 	if(ProductInfoSB.pf1price2 != null && ProductInfoSB.pf1price2 != "null" && ProductInfoSB.pf1price2 != ""){
				    						 		rankprice1 = ProductInfoSB.pf1price2;
				    						 	}
				    						 	if(ProductInfoSB.pf2price2 != null && ProductInfoSB.pf2price2 != "null" && ProductInfoSB.pf2price2 != ""){
				    						 		rankprice2 = ProductInfoSB.pf2price2;
				    						 	}
					    						if(ProductInfoSB.pf3price2 != null && ProductInfoSB.pf3price2 != "null" && ProductInfoSB.pf3price2 != ""){
					    							rankprice3 = ProductInfoSB.pf3price2;
					    						}
				    					    }
				    					 if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid3).toUpperCase()){
				    						 	if(ProductInfoSB.pf1price3 != null && ProductInfoSB.pf1price3 != "null" && ProductInfoSB.pf1price3 != ""){
				    						 		rankprice1 = ProductInfoSB.pf1price3;
				    						 	}
				    						 	if(ProductInfoSB.pf2price3 != null && ProductInfoSB.pf2price3 != "null" && ProductInfoSB.pf2price3 != ""){
				    						 		rankprice2 = ProductInfoSB.pf2price3;
				    						 	}
				    						 	if( ProductInfoSB.pf3price3 != null && ProductInfoSB.pf3price3 != "null" && ProductInfoSB.pf3price3 != ""){
				    						 		rankprice3 = ProductInfoSB.pf3price3;
				    						 	}
				    					   }
				    					 if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid4).toUpperCase()){
				    						 	if(ProductInfoSB.pf1price4 != null && ProductInfoSB.pf1price4 != "null" && ProductInfoSB.pf1price4 != ""){
				    						 		rankprice1 = ProductInfoSB.pf1price4;
				    						 	}
				    						 	if(ProductInfoSB.pf2price4 != null && ProductInfoSB.pf2price4 != "null" && ProductInfoSB.pf2price4 != ""){
				    						 		rankprice2 = ProductInfoSB.pf2price4;
				    						 	}
				    						 	if(ProductInfoSB.pf3price4 != null &&  ProductInfoSB.pf3price4 != "null" &&  ProductInfoSB.pf3price4 != ""){
				    						 		rankprice3 = ProductInfoSB.pf3price4;
				    						 	}
				    					  }
				    					 var rankprice = 0;
				    					 if(clientrank == "1"){
				    						 rankprice = rankprice1;
				    						 RankPriceF = rankprice1;
				    						 isHaveRankPrice = true;
				    					 }
				    					 if(clientrank == "2"){
				    						 rankprice = rankprice2;
				    						 RankPriceF = rankprice2;
				    						 isHaveRankPrice = true;
				    					 }
				    					 if( clientrank == "3"){
				    						 rankprice = rankprice3;
				    						 RankPriceF = rankprice3;
				    						 isHaveRankPrice = true;
				    					 }
						    		  }
					    		  }
					    	  }
				    	  }
				    	  
				    	 /*
				    	  *先选了客户时
						 * 特价>最近售价>等级价>业务类型价
						 * 未选择客户时
						 * 业务类型价
						 * 当都无价格权限时，价格默认为0；
				    	  * */
				    	  //如果有特价则显示特价
				    	  if(isHaveSpecialPrice){
				    		  $(obj).find(inputxb).val(SpecialPriceF).change();
				    	  }else{
				    		//未选择客户时
					    	  if(clientid == "" || clientid ==undefined || clientname == "" || clientname == undefined ){
					    		  if("1" == selectsaletype){//批发
					    			  if(isAdmin != "true" && permflag.indexOf(";2;") < 0 ){
					    				  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
					    			  }else{
					    				  $(obj).find(inputxb).val(pfTypePriceF).change();
					    			  }
					    		  }else{
					    			  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 ){
					    				  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
					    			  }else{
					    				  $(obj).find(inputxb).val(saleTypePriceF).change();
					    			  }
					    		  }
					    	  }else{
					    		  //存在客户时 进行 权限的判断
					    		  //最近售价权限的判断
					    		  var iSNear = false;
					    		  var isRank = false;
					    		  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0){
					    			  //无权限
					    		  }else{
					    			  
					    			  if(isHaveNearPrice){
					    				//有最近售价的
						    			  iSNear = true;
					    				  //存在最近售价
					    				  $(obj).find(inputxb).val(NearPriceF).change();
					    			  }
					    		  }
					    		  //等级价权限
					    		  if(iSNear == false){
					    			  if(permflag.indexOf(";9;") < 0 && isAdmin != "true"){
					    				  //无权限
					    			  }else{
					    				  if(isHaveRankPrice){
					    					//有等级价的
						    				  isRank = true;
					    					  //存在等级价
					    					  $(obj).find(inputxb).val(RankPriceF).change();
					    				  }
					    			  }
					    		  }
					    		  if(!iSNear && !isRank){
					    			  //前两个权限都没有的，则 获取 业务类型价格
					    			  if("1" == selectsaletype){//批发
					    				  if(isAdmin != "true" && permflag.indexOf(";2;") < 0 ){
					    					  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
					    				  }else{
					    					  var pfprice =  $(obj).find("input[name='hidselpfprice']").val();
								    		  if(pfprice == undefined || pfprice == "-" || pfprice+"" == ""){
								    			  pfprice = 0;
								    		  }
									  		  $(obj).find("input[name='hidisgetnearprice']").val("0");
					    					  $(obj).find(inputxb).val(pfprice).change();
					    				  }
						    		  }else{
						    			  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 ){
						    				  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
						    			  }else{
						    				  var saleprice = $(obj).find("input[name='hidselprice']").val();
							    			  if(saleprice == undefined || saleprice == "-" || saleprice+"" == ""){
							    				  saleprice = 0;
								    		  }
								  			  $(obj).find("input[name='hidisgetnearprice']").val("0");
						    				  $(obj).find(inputxb).val(saleprice).change();
						    			  }
						    			 
						    		  }
					    		  }
					    	  }
				    	  }
				    	  
				    	  
				    	  //去除loading 样式
			  			  $(obj).find(inputloading).hide();
			  			  $(obj).find("input[name='moneyLoadingTxbAmt']").hide();//金额列
			  			  $(obj).find(inputxb).show();
			  			  $(obj).find("input[name='txbAmt']").show();
			  			  //添加 价格初始化标记
				    	  $(obj).attr("init_price_flag","1");
				    	  //绑定价格完毕后 显示 单位切换按钮
				    	  var rowMultiUnitFlag = data.rowmultiUnitFlag;
				    	  var hiddetailtype = $(obj).find("input[name='hiddetailtype']").val();
				    	  if(rowMultiUnitFlag+"" == "true" && hiddetailtype != "1"){
				    		  $(obj).find("a[name='aunit']").show();
				    	  }
				    	 
				    	 // console.log(rowindex+" || "+initCount);
				    	  if(rowindex == initCount){
				    		   //数据初始化完毕后，可以进行保存
				    			$("#savebillFlag").val("0");
				    			//隐藏loading 样式
				    			//合计行金额
				    			$("#sumAmt").show();
				    			$("#moneyLoadingSumAmt").hide();
				    			//合计金额
				    			$("#tdTotal").show();
				    			$("#moneyLoadingTotalspan").hide();
				    			//总计金额
				    			$("#tdFaRece").show();
				    			$("#tdmoneyLoadingFaRece").hide();
				    			//实收金额,实退金额
				    			$("#txbreceamt").show();
				    			$("#txbpayamt").show();
				    			$("#moneyLoadingRece").hide();
				    			//显示隐藏欠款
				    			if(isHideDivReceamt){
				    				$("#divreceamt").show();
				    			}
				    	  }
				      },
				      error: function () {
				      }
				  }); 
			}
		}else{
			//直接切换销售类型类型时
			if(isChageSaleType){
				if(initCount == 0){
					 //数据初始化完毕后，可以进行保存
	    			$("#savebillFlag").val("0");
	    			//隐藏loading 样式
	    			//合计行金额
	    			$("#sumAmt").show();
	    			$("#moneyLoadingSumAmt").hide();
	    			//合计金额
	    			$("#tdTotal").show();
	    			$("#moneyLoadingTotalspan").hide();
	    			//总计金额
	    			$("#tdFaRece").show();
	    			$("#tdmoneyLoadingFaRece").hide();
	    			//实收金额,实退金额
	    			$("#txbreceamt").show();
	    			$("#txbpayamt").show();
	    			$("#moneyLoadingRece").hide();
	    			//显示隐藏欠款
	    			if(isHideDivReceamt){
	    				$("#divreceamt").show();
	    			}
				}
			}
		}
	});

	//初始化价格完毕后，记录当前客户的id
	//$("#remmberClientid").val(clientid);
}


/**
 * 初始化最近价格:
 * </br>
 * 先选了客户时
 * 最近售价>特价>等级价>业务类型价
 * </br>
 * 未选择客户时
 * 特价>业务类型价>最近售价>等级价
 */
function initSaleReturnPriceSNRAsyncTrue(isChageSaleType){
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();//客户等级价
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	//var remmberClientid = $("#remmberClientid").val();//上一个客户的id
	var clientid = $("#crvalue").val();//客户id
	var clientname = $("#txbCr").val();//客户名称
	var branchid= $("#choose-warehouse-parentval").val();//门店ID 
	if(1 == $("#hidIsOpenMultipleWarehouse").val()){//开启多仓
		branchid =$("#hidbranchid").val();	
	}
	//价格权限 1-零售 2-批发价 3-参考进货价 4-最低售价 5-成本价 9-等级价
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	var url = window.location.href;
	var inputloading = "input[name='moneyLoadingTxbPrice']";
	var inputxb = "input[name='txbPrice']";
	var ulname = "ul[name='ulpriceli']";
	if(hidisopensaledetaildiscount == "1"){
		inputxb = "input[name='txbDiscountPrice']";
		inputloading = "input[name='moneyLoadingDis']";
		ulname = "ul[name='Disulpriceli']";
	}
	//金额合计行 ，合计金额，总计金额，实收金额，实退金额
	//显示loading 样式
	//合计行金额
	//if(url.indexOf("SaleOrder/TurnSale.htm") < 0){
		$("#sumAmt").hide();
		$("#moneyLoadingSumAmt").show();
		//合计金额
		$("#tdTotal").hide();
		$("#moneyLoadingTotalspan").show();
		//总计金额
		$("#tdFaRece").hide();
		$("#tdmoneyLoadingFaRece").show();
		//实收金额,实退金额
		$("#txbreceamt").hide();
		$("#txbpayamt").hide();
		$("#moneyLoadingRece").show();
		//保存标志 当保存标志为1时 表示 正在初始化价格 初始化完毕后 此值为0
		$("#savebillFlag").val("1");
	//}
	//var rows = 	Number(document.getElementById("tabdetail").rows.length) - 1;//总行数 去除首行
	var initCount = 0;//获取需要被初始化价格的有多少行商品
	$("#tabdetail tr:gt(0)").each(function(){
		 //套餐成分商品不处理
		var hiddetailtype = $(this).find("input[name='hiddetailtype']").val();
		if($(this).is(":hidden")){
			return;
		}
		 //开启单行折扣时，改变了销售类型，则对单价行进行业务类型重新赋值
		if(isChageSaleType ){
			$(this).removeAttr("init_price_flag");
			$(this).removeAttr("init_c_foreach");
			if(hidisopensaledetaildiscount == "1" && hiddetailtype != "1"){
				if("1" == selectsaletype){//批发
					  $(this).find("input[name='hidpricetype']").val("2");
		  			  var pfprice =  $(this).find("input[name='hidselpfprice']").val();
					  if(pfprice == undefined || pfprice == "-" || pfprice+"" == ""){
						  pfprice = 0;
					  }
					  if(isAdmin != "true" && permflag.indexOf(";2;") < 0 ){
						  $(this).find("input[name='txbPrice']").val(Number(0).formatMoney());
					  }else{
						  $(this).find("input[name='txbPrice']").val(Number(pfprice).formatMoney());
					  }
		  			  $(this).find("input[name='hidisgetnearprice']").val("0");
		  		   }else{
		  			  $(this).find("input[name='hidpricetype']").val("1");
		  			  var saleprice = $(this).find("input[name='hidselprice']").val();
		  			  if(saleprice == undefined || saleprice == "-" || saleprice+"" == ""){
		  				  saleprice = 0;
			    	  }
		  			  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 ){
		  				  $(this).find("input[name='txbPrice']").val(Number(0).formatMoney());
		  			  }else{
		  				  $(this).find("input[name='txbPrice']").val(Number(saleprice).formatMoney());
		  			  }
			  		  $(this).find("input[name='hidisgetnearprice']").val("0");
		  		   }
			}
		}
		//获取本行的隐式表示 判断 此行是否已经获取过了
		var trflag = $(this).attr("init_price_flag");
		//复制新增/编辑页面 初始化的数据不进行 价格初始化加载
		var cforeachflag = $(this).attr("init_c_foreach");
		var productid = $(this).find("input[name='hidProductId']").val();
		//当trflag不等于1时 表示 该行商品 未获取过初始化价格
		//也要过滤套餐及其 成分商品
		if(trflag != "1" && cforeachflag != "1" && productid != undefined && productid != "" ){
			initCount++;
		}
	});
	
	//如果客户累计欠款显示了 先进行隐藏
	var isHideDivReceamt = false;
	if($("#divreceamt").is(":visible")){
		$("#divreceamt").hide();
		isHideDivReceamt = true;
	}
	var haveProductCount = 0;//初始化的商品数量
	$("#tabdetail tr:gt(0)").each(function(){
		//改变了 销售类型
		if(isChageSaleType){
			$(this).removeAttr("init_price_flag");
			$(this).removeAttr("init_c_foreach");
		}
		//获取本行的隐式表示 判断 此行是否已经获取过了
		var trflag = $(this).attr("init_price_flag");
		//复制新增/编辑页面 初始化的数据不进行 价格初始化加载
		var cforeachflag = $(this).attr("init_c_foreach");
		var productid = $(this).find("input[name='hidProductId']").val();
		//当trflag不等于1时 表示 该行商品 未获取过初始化价格
		//也要过滤套餐及其 成分商品
		//var hiddetailtype = $(this).find("input[name='hiddetailtype']").val();
		if(trflag != "1" && cforeachflag != "1" && productid != undefined && productid != "" && $(this).is(":visible") ){
			var pcount = haveProductCount++;//当前循环到了哪一行
			//if(url.indexOf("SaleOrder/TurnSale.htm") < 0){
				//初始化加载前 显示loading 样式
				$(this).find(inputloading).show();//单价/折后单价列
				$(this).find(inputxb).hide();//单价/折后单价列
				$(this).find("input[name='moneyLoadingTxbAmt']").show();//金额列
				$(this).find("input[name='txbAmt']").hide();//金额列
			//}
			//判断是否是多单位商品
			var multiUnitFlag = false;
			if($(this).find("a[name='aunit']").is(":visible")){
				multiUnitFlag = true;
				$(this).find("a[name='aunit']").hide();
			}
			//权限判断
			if (isAdmin != "true" && permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 ) {
				
				if( productversion == "51" ){
					var specialPrice = $(this).find(ulname).find("span[name='spanspecialsaleprice']").text();
					if(specialPrice != undefined && String(specialPrice) != "" && specialPrice != null && String(specialPrice) != "null"){
						//有特价
						isHaveSP = true;
						if(hidisopensaledetaildiscount == "1"){
							$(this).find("input[name='txbPrice']").val(0)
						}
						$(this).find(inputxb).val(specialPrice).change();
					}else{
						//无特价
						if(hidisopensaledetaildiscount == "1"){
							$(this).find("input[name='txbPrice']").val(0);
						}
						$(this).find(inputxb).val(0).change();
					}
				}
				if(!isHaveSP){
					if(hidisopensaledetaildiscount == "1"){
						$(this).find("input[name='txbPrice']").val(0);
					}
					$(this).find(inputxb).val(0).change();
				}
				
				$(this).find("input[name='hidisgetnearprice']").val("0");
				
				//去除loading 样式
	  			  $(this).find(inputloading).hide();
	  			  $(this).find("input[name='moneyLoadingTxbAmt']").hide();//金额列
	  			  $(this).find(inputxb).show();
	  			  $(this).find("input[name='txbAmt']").show();
	  			  //添加 价格初始化标记
		    	  $(this).attr("init_price_flag","1");
		    	  //绑定价格完毕后 显示 单位切换按钮
		    	  if(multiUnitFlag){
		    		  $(this).find("a[name='aunit']").show();
		    	  }
		    	  var rowindex = pcount+1;
		    	  if(rowindex == initCount){
		    		   //数据初始化完毕后，可以进行保存
		    			$("#savebillFlag").val("0");
		    			//隐藏loading 样式
		    			//合计行金额
		    			$("#sumAmt").show();
		    			$("#moneyLoadingSumAmt").hide();
		    			//合计金额
		    			$("#tdTotal").show();
		    			$("#moneyLoadingTotalspan").hide();
		    			//总计金额
		    			$("#tdFaRece").show();
		    			$("#tdmoneyLoadingFaRece").hide();
		    			//实收金额,实退金额
		    			$("#txbreceamt").show();
		    			$("#txbpayamt").show();
		    			$("#moneyLoadingRece").hide();
		    	  }
			}else{
				//有权限时
				var UnitId = $(this).find("input[name='hidUnitId']").val();
				if(clientname==''){
					clientname="EMPTY";
				}
				var obj = this;
				//获取特价/最近售价/等级价
			/*	var nearPrice="";
				var specialprice = "";
				var ProductInfoSB="";
				var json={};*/
				 $.ajax({
				      dataType: "json",
				      data: {
				    	  productid: productid,
				          productunit: UnitId,
				          clientid: clientid,
				          clientname:clientname,
				          branchid:branchid,
				          rowindex:pcount,
				          rowmultiUnitFlag:multiUnitFlag
				      },
				      url: "Sale/getSalePriceSNR.json?"+Math.random(),
				      cache: false,
				      type: "post",
				      async: true,
				      success: function (data) {
				    	  //各种价格
				    	  var SpecialPriceF= Number(0).formatMoney();//特价
				    	  var NearPriceF = Number(0).formatMoney();//最近售价
				    	  var saleTypePriceF = Number(0).formatMoney();//业务类型价 
				    	  var pfTypePriceF = Number(0).formatMoney();//业务类型价 
				    	  var RankPriceF =  Number(0).formatMoney();//等级价
				    	  
				    	  var rowindex = Number(data.rowindex)+1;//当前异步处理到了哪一行
				    	  //套餐
				    	  if($(obj).find("input[name='hiddetailtype']").val() == "1"){
				    		  $(obj).find(inputloading).hide();
				  			  $(obj).find("input[name='moneyLoadingTxbAmt']").hide();//金额列
				  			  $(obj).find(inputxb).show();
				  			  $(obj).find("input[name='txbAmt']").show();
				  			  //添加 价格初始化标记
					    	  $(obj).attr("init_price_flag","1");
					    	  if(rowindex == initCount){
					    		   //数据初始化完毕后，可以进行保存
					    			$("#savebillFlag").val("0");
					    			//隐藏loading 样式
					    			//合计行金额
					    			$("#sumAmt").show();
					    			$("#moneyLoadingSumAmt").hide();
					    			//合计金额
					    			$("#tdTotal").show();
					    			$("#moneyLoadingTotalspan").hide();
					    			//总计金额
					    			$("#tdFaRece").show();
					    			$("#tdmoneyLoadingFaRece").hide();
					    			//实收金额,实退金额
					    			$("#txbreceamt").show();
					    			$("#txbpayamt").show();
					    			$("#moneyLoadingRece").hide();
					    			//显示隐藏欠款
					    			if(isHideDivReceamt){
					    				$("#divreceamt").show();
					    			}
					    	  }
				    		  return;
				    	  }
				    	  //获取了价格后，进行初始化操作
				    	  //客户不存在时，第二步获取业务类型价格
				    	  var isHaveSaleTypePrice = false;
				    	  if( clientid == "" || clientid ==undefined || clientname == "" || clientname == undefined ){
				    		  if("1" == selectsaletype){//批发
				    			  isHaveSaleTypePrice = true;
				    			 var pfprice =  $(obj).find("input[name='hidselpfprice']").val();
				    			 if(pfprice == undefined || pfprice == "-" || pfprice+"" == ""){
				    				 pfprice = 0;
				    			 }
				    			 pfTypePriceF = Number(pfprice).formatMoney();
				    			 
					  			 $(obj).find("input[name='hidisgetnearprice']").val("0");
				    		  }else{
				    			  isHaveSaleTypePrice = true;
				    			  var saleprice = $(obj).find("input[name='hidselprice']").val();
				    			  if(saleprice == undefined || saleprice == "-" || saleprice+"" == ""){
				    				  saleprice = 0;
					    		  }
				    			  saleTypePriceF = Number(saleprice).formatMoney();
					  			 $(obj).find("input[name='hidisgetnearprice']").val("0");
				    		  }
				    	  }
				    	  var isHaveNearPrice = false;
			    		  //2.判断最近售价 是否存在
			    		  if(data!=null&& data.nearprice != null && data.nearprice != ""){
			    			  var nearPrice=Number(data.nearprice).formatMoney();
			    			  $(obj).find("input[name='hidisgetnearprice']").val("0");
			    			  NearPriceF = nearPrice;
				  			  isHaveNearPrice = true;
			    		  }
				    	  
			    		 //1.判断特价是否存在
				    	  var isHaveSpecialPrice = false;
				    	  if(productversion == "51"){
				    		  if(data!=null&& data.specialprice != null && data.specialprice != ""){
					    		  var specialprice = Number(data.specialprice).formatMoney();
					    		  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0){
					    			  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
						  			  $(obj).find("input[name='hidisgetnearprice']").val("0");
					    		  }else{
					    			  $(obj).find(inputxb).val(specialprice).change();
						  			  $(obj).find("input[name='hidisgetnearprice']").val("0"); 
					    		  }
					    		  SpecialPriceF=specialprice;
					  			  isHaveSpecialPrice = true;
					    	  }
				    	  }
				    	  var isHaveRankPrice = false;//是否是等级客户价格
				    	  if(productversion == "1" || productversion == "51"){
				    		  if(clientid != "" && clientid !=undefined && clientname!= "" && clientname != undefined ){
					    		  if(IsOpenClientRankPrice == 1){
					    			  //判断是否存在等级价
						    		  if(data!=null&& data.ProductInfoSB != null && data.ProductInfoSB != ""){
						    			  var chooseunitid = $(obj).find("input[name='hidUnitId']").val();
						    			  var rankprice1 = Number(0).formatMoney();
					    				  var rankprice2 = Number(0).formatMoney();
					    				  var rankprice3 = Number(0).formatMoney();
					    				  var ProductInfoSB = data.ProductInfoSB;
					    				  if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid1).toUpperCase()){
					    					    if(ProductInfoSB.pf1price1 != null && ProductInfoSB.pf1price1 != "null" && ProductInfoSB.pf1price1 != ""){
					    					    	rankprice1 = ProductInfoSB.pf1price1;
					    					    }
					    					    if( ProductInfoSB.pf2price1 != null &&  ProductInfoSB.pf2price1 != "null" &&  ProductInfoSB.pf2price1 != ""){
					    					    	rankprice2 = ProductInfoSB.pf2price1;
					    					    }
					    					    if(ProductInfoSB.pf3price1 != null && ProductInfoSB.pf3price1 != "null" && ProductInfoSB.pf3price1 != ""){
					    					    	rankprice3 = ProductInfoSB.pf3price1
					    					    }
					    					}
				    					 if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid2).toUpperCase()){
				    						 	if(ProductInfoSB.pf1price2 != null && ProductInfoSB.pf1price2 != "null" && ProductInfoSB.pf1price2 != ""){
				    						 		rankprice1 = ProductInfoSB.pf1price2;
				    						 	}
				    						 	if(ProductInfoSB.pf2price2 != null && ProductInfoSB.pf2price2 != "null" && ProductInfoSB.pf2price2 != ""){
				    						 		rankprice2 = ProductInfoSB.pf2price2;
				    						 	}
					    						if(ProductInfoSB.pf3price2 != null && ProductInfoSB.pf3price2 != "null" && ProductInfoSB.pf3price2 != ""){
					    							rankprice3 = ProductInfoSB.pf3price2;
					    						}
				    					    }
				    					 if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid3).toUpperCase()){
				    						 	if(ProductInfoSB.pf1price3 != null && ProductInfoSB.pf1price3 != "null" && ProductInfoSB.pf1price3 != ""){
				    						 		rankprice1 = ProductInfoSB.pf1price3;
				    						 	}
				    						 	if(ProductInfoSB.pf2price3 != null && ProductInfoSB.pf2price3 != "null" && ProductInfoSB.pf2price3 != ""){
				    						 		rankprice2 = ProductInfoSB.pf2price3;
				    						 	}
				    						 	if( ProductInfoSB.pf3price3 != null && ProductInfoSB.pf3price3 != "null" && ProductInfoSB.pf3price3 != ""){
				    						 		rankprice3 = ProductInfoSB.pf3price3;
				    						 	}
				    					   }
				    					 if(String(chooseunitid).toUpperCase() == String(ProductInfoSB.unitid4).toUpperCase()){
				    						 	if(ProductInfoSB.pf1price4 != null && ProductInfoSB.pf1price4 != "null" && ProductInfoSB.pf1price4 != ""){
				    						 		rankprice1 = ProductInfoSB.pf1price4;
				    						 	}
				    						 	if(ProductInfoSB.pf2price4 != null && ProductInfoSB.pf2price4 != "null" && ProductInfoSB.pf2price4 != ""){
				    						 		rankprice2 = ProductInfoSB.pf2price4;
				    						 	}
				    						 	if(ProductInfoSB.pf3price4 != null &&  ProductInfoSB.pf3price4 != "null" &&  ProductInfoSB.pf3price4 != ""){
				    						 		rankprice3 = ProductInfoSB.pf3price4;
				    						 	}
				    					  }
				    					 var rankprice = 0;
				    					 if(clientrank == "1"){
				    						 rankprice = rankprice1;
				    						 RankPriceF = rankprice1;
				    						 isHaveRankPrice = true;
				    					 }
				    					 if(clientrank == "2"){
				    						 rankprice = rankprice2;
				    						 RankPriceF = rankprice2;
				    						 isHaveRankPrice = true;
				    					 }
				    					 if( clientrank == "3"){
				    						 rankprice = rankprice3;
				    						 RankPriceF = rankprice3;
				    						 isHaveRankPrice = true;
				    					 }
						    		  }
					    		  }
					    	  }
				    	  }
				    	  //业务类型价格(客户存在时)
			    		  if(clientid != "" && clientid !=undefined && clientname!= "" && clientname != undefined){
			    			  if("1" == selectsaletype){//批发
				    			 var pfprice =  $(obj).find("input[name='hidselpfprice']").val();
				    			 if(pfprice == undefined || pfprice == "-" || pfprice+"" == ""){
				    				 pfprice = 0;
				    			 }
					  			 $(obj).find("input[name='hidisgetnearprice']").val("0");
					  			 pfTypePriceF = Number(pfprice).formatMoney();
				    		  }else{
				    			  var saleprice = $(obj).find("input[name='hidselprice']").val();
				    			  if(saleprice == undefined || saleprice == "-" || saleprice+"" == ""){
				    				  saleprice = 0;
					    			 }
					  			 $(obj).find("input[name='hidisgetnearprice']").val("0");
					  			saleTypePriceF = Number(saleprice).formatMoney();
				    		  }
			    		  }
				    	  
				    	 /*
				    	  *先选了客户时
						 * 最近售价>特价>等级价>业务类型价
						 * 未选择客户时
						 * 业务类型价
						 * 当都无价格权限时，价格默认为0；
				    	  * */
				    	  //如果有特价则显示特价
				    	  var iSNear = false;
			    		  var isRank = false;
			    		  var isSpecial=false;
			    		//未选择客户时
				    	  if(clientid == "" || clientid ==undefined || clientname == "" || clientname == undefined ){
				    		  if(isHaveSpecialPrice){//
				    				 //有特价
				    				  isSpecial = true;
				    				  //存在特价
					    			  $(obj).find(inputxb).val(SpecialPriceF).change();
				    	      }else{
					    	    	  if("1" == selectsaletype){//批发
					    			  if(isAdmin != "true" && permflag.indexOf(";2;") < 0 ){
					    				  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
					    			  }else{
					    				  $(obj).find(inputxb).val(pfTypePriceF).change();
					    			  }
					    		  }else{
					    			  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 ){
					    				  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
					    			  }else{
					    				  $(obj).find(inputxb).val(saleTypePriceF).change();
					    			  }
					    		  }
				    	      }
				    	  }else{
				    		  if(isHaveNearPrice && (isAdmin == "true" || permflag.indexOf(";9;") > 0)){
				    			  //isHaveNearPrice
				    			  iSNear = true;
			    				  //存在最近售价
			    				  $(obj).find(inputxb).val(NearPriceF).change();
					    	  }else{
					    		  if(isHaveSpecialPrice){
					    			 //有特价
				    				  isSpecial = true;
				    				  //存在特价
					    			  $(obj).find(inputxb).val(SpecialPriceF).change();//NearPriceF
					    			  $(obj).find("input[name='txbRowRemark']").val("【特价】");
					    			  $(obj).find("input[name='hidpricetype']").val("7");
					    		  }
					    	  }
				    		  //等级价权限
				    		  if(!iSNear && !isSpecial){
				    			  if(permflag.indexOf(";9;") < 0 && isAdmin != "true"){
				    				  //无权限
				    			  }else{
				    				  if(isHaveRankPrice){
				    					//有等级价的
					    				  isRank = true;
				    					  //存在等级价
				    					  $(obj).find(inputxb).val(RankPriceF).change();
				    				  }
				    			  }
				    		  }
				    		  if(!iSNear && !isRank && !isSpecial){
				    			  //前两个权限都没有的，则 获取 业务类型价格
				    			  if("1" == selectsaletype){//批发
				    				  if(isAdmin != "true" && permflag.indexOf(";2;") < 0 ){
				    					  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
				    				  }else{
				    					  $(obj).find(inputxb).val(pfTypePriceF).change();
				    				  }
					    		  }else{
					    			  if(isAdmin != "true" && permflag.indexOf(";1;") < 0 ){
					    				  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
					    			  }else{
					    				  $(obj).find(inputxb).val(saleTypePriceF).change();
					    			  }
					    			 
					    		  }
				    		  }
				    	  }
				    	  
				    	  //去除loading 样式
			  			  $(obj).find(inputloading).hide();
			  			  $(obj).find("input[name='moneyLoadingTxbAmt']").hide();//金额列
			  			  $(obj).find(inputxb).show();
			  			  $(obj).find("input[name='txbAmt']").show();
			  			  //添加 价格初始化标记
				    	  $(obj).attr("init_price_flag","1");
				    	  //绑定价格完毕后 显示 单位切换按钮
				    	  var rowMultiUnitFlag = data.rowmultiUnitFlag;
				    	  var hiddetailtype = $(obj).find("input[name='hiddetailtype']").val();
				    	  if(rowMultiUnitFlag+"" == "true" && hiddetailtype != "1"){
				    		  $(obj).find("a[name='aunit']").show();
				    	  }
				    	 
				    	  if(rowindex == initCount){
				    		   //数据初始化完毕后，可以进行保存
				    			$("#savebillFlag").val("0");
				    			//隐藏loading 样式
				    			//合计行金额
				    			$("#sumAmt").show();
				    			$("#moneyLoadingSumAmt").hide();
				    			//合计金额
				    			$("#tdTotal").show();
				    			$("#moneyLoadingTotalspan").hide();
				    			//总计金额
				    			$("#tdFaRece").show();
				    			$("#tdmoneyLoadingFaRece").hide();
				    			//实收金额,实退金额
				    			$("#txbreceamt").show();
				    			$("#txbpayamt").show();
				    			$("#moneyLoadingRece").hide();
				    			//显示隐藏欠款
				    			if(isHideDivReceamt){
				    				$("#divreceamt").show();
				    			}
				    	  }
				      },
				      error: function () {
				      }
				  }); 
			}
		}else{
			//直接切换销售类型类型时
			if(isChageSaleType){
				if(initCount == 0){
					 //数据初始化完毕后，可以进行保存
	    			$("#savebillFlag").val("0");
	    			//隐藏loading 样式
	    			//合计行金额
	    			$("#sumAmt").show();
	    			$("#moneyLoadingSumAmt").hide();
	    			//合计金额
	    			$("#tdTotal").show();
	    			$("#moneyLoadingTotalspan").hide();
	    			//总计金额
	    			$("#tdFaRece").show();
	    			$("#tdmoneyLoadingFaRece").hide();
	    			//实收金额,实退金额
	    			$("#txbreceamt").show();
	    			$("#txbpayamt").show();
	    			$("#moneyLoadingRece").hide();
	    			//显示隐藏欠款
	    			if(isHideDivReceamt){
	    				$("#divreceamt").show();
	    			}
				}
			}
		}
	});

	//初始化价格完毕后，记录当前客户的id
	//$("#remmberClientid").val(clientid);
}
function initSaleNearPrice(tablerow) {
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	var productid = $(tablerow).find("input[name='hidProductId']").val();
	if (productid != undefined && productid != '') {
		//价格权限 1-零售 2-批发价 3-参考进货价 4-最低售价 5-成本价 9-等级价
		var permflag = $("#permflag", parent.parent.document).val();
		var isAdmin = $("#isAdminRole", parent.parent.document).val();
		
		if(1 != $("#hidIsOpenMultipleWarehouse").val()){//没开启多仓
			var branchid=$("#choose-warehouse-parentval").val(); 
		}else{//开启
			branchid =$("#hidbranchid").val();	
		}
		 var productunit = $(tablerow).find("input[name='hidUnitId']").val();
		 var clientid = $("#crvalue").val();
		 var clientname = $("#txbCr").val();
		if(clientname==''){
			clientname="EMPTY";
		}
		//异步获取价格
		var nearPrice='';
		 $.ajax({
		      dataType: "json",
		      data: {
		    	  productid: productid,
		          productunit: productunit,
		          clientid: clientid,
		          clientname:clientname,
		          branchid:branchid
		      },
		      url: "Sale/getNearSalePrice.json",
		      cache: false,
		      type: "post",
		      async: true,
		      success: function (data) {
		    	  if(data!=null&&data.nearprice!=null){
		    		  nearPrice=parseFloat(data.nearprice).formatMoney();
		    	  }
		    	  if (permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 && isAdmin != "true") {
		    		  $(tablerow).find(txbInput).val(0).change();
		  			  $(tablerow).find("input[name='hidisgetnearprice']").val("0");
		    	  }else{
		    		 
		  			  if (nearPrice != '') {
						$(tablerow).find(txbInput).val(nearPrice).change();
						$(tablerow).find("input[name='hidisgetnearprice']").val("0");
					  }
		    	  }
		    	  //根据客户的等级修改相应等级批发价格
		    	  changepfPriceByClientRankRowNearprice(tablerow,nearPrice);
		      },
		      error: function () {
		          
		      }
		  }); 
	 }
		/*var nearprice ='';
		if (permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 && isAdmin != "true") {
			$(tablerow).find(txbInput).val(0).change();
			$(tablerow).find("input[name='hidisgetnearprice']").val("0");
		}else{
			var unitid = $(tablerow).find("input[name='hidUnitId']").val();
			var crvalue = $("#crvalue").val();
			var txbcr = $("#txbCr").val();
			nearprice = getNearSalePrice(productid, unitid, crvalue, txbcr);
			if (nearprice != '') {
				$(tablerow).find(txbInput).val(nearprice).change();
				$(tablerow).find("input[name='hidisgetnearprice']").val("0");
			}
		}
	}
	//根据客户的等级修改相应等级批发价格
	changepfPriceByClientRankRowNearprice(tablerow,nearprice);*/
}
function initSaleReturnNearPrice(tablerow) {
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	var productid = $(tablerow).find("input[name='hidProductId']").val();
	if (productid != undefined && productid != '') {
		//价格权限 1-零售 2-批发价 3-参考进货价 4-最低售价 5-成本价 9-等级价
		var permflag = $("#permflag", parent.parent.document).val();
		var isAdmin = $("#isAdminRole", parent.parent.document).val();
		var nearprice ='';
		if (permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 && isAdmin != "true") {
			$(tablerow).find(txbInput).val(0).change();
			$(tablerow).find("input[name='hidisgetnearprice']").val("0");
		}else{
			var unitid = $(tablerow).find("input[name='hidUnitId']").val();
			var crvalue = $("#crvalue").val();
			var txbcr = $("#txbCr").val();
			nearprice = getNearSalePrice(productid, unitid, crvalue, txbcr);
			if (nearprice != '') {
				$(tablerow).find(txbInput).val(nearprice).change();
				$(tablerow).find("input[name='hidisgetnearprice']").val("0");
			}
		}
	}
	//根据客户的等级修改相应等级批发价格
	changeSaleReturnpfPriceByClientRankRowNearprice(tablerow,nearprice);
}
function initBuyNearPrice(tablerow) {
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	var productid = $(tablerow).find("input[name='hidProductId']").val();
	if (productid != undefined && productid != '') {
		//价格权限 1-零售 2-批发价 3-参考进货价 4-最低售价 5-成本价 9-等级价
		var permflag = $("#permflag", parent.parent.document).val();
		var isAdmin = $("#isAdminRole", parent.parent.document).val();
		var nearbuypricepermflag = $("#nearbuypricepermflag", parent.parent.document).val();//最近进货价权限 1-有权限 0-无权限
		var nearprice ='';
		if(nearbuypricepermflag == 1){
			var unitid = $(tablerow).find("input[name='hidUnitId']").val();
			var crvalue = $("#crvalue").val();
			var txbcr = $("#txbCr").val();
			nearprice = getNearBuyPrice(productid, unitid, crvalue, txbcr);
			if (nearprice != '' && String(txbcr) != "" && String(txbcr) != "undefined" ) {
				$(tablerow).find(txbInput).val(nearprice).change();
				$(tablerow).find("ul[name='ulpriceli'] li[dataname='linknear']").show();
				$(tablerow).find("ul[name='ulpriceli'] li span[name='spannearbuyprice']").html(nearprice);
			}
		}
		/*if (permflag.indexOf(";3;") < 0 && isAdmin != "true") {
			$(tablerow).find(txbInput).val(0).change();
		}else{
			var unitid = $(tablerow).find("input[name='hidUnitId']").val();
			var crvalue = $("#crvalue").val();
			var txbcr = $("#txbCr").val();
			nearprice = getNearBuyPrice(productid, unitid, crvalue, txbcr);
			if (nearprice != '' && String(txbcr) != "" && String(txbcr) != "undefined" ) {
				$(tablerow).find(txbInput).val(nearprice).change();
				$(tablerow).find("ul[name='ulpriceli'] li[dataname='linknear']").show();
				$(tablerow).find("ul[name='ulpriceli'] li span[name='spannearbuyprice']").html(nearprice);
			}
		}*/
	}
}



//根据客户的等级修改相应等级价格
function changepfPriceByClientRankRowNearprice(obj,nearprice){
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();//客户等级价
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	var url = window.location.href;
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	//价格权限
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	
	if(("51"== productversion || "1"== productversion ) ){//订货平台开通客户等级价
		//存在商品则进行循环
		var productid = $(obj).find("input[name='hidProductId']").val();
		if(undefined !=productid && productid !=""){
			var pfpirce = 0;//2017年12月6日  pfpirce现在不代表普通批发价了。改成了 代表 等级价了（囊括了 零售价和批发价）
			if(IsOpenClientRankPrice == 1){
				if(clientrank == "1"||clientrank == "2"||clientrank == "3"){//存在客户等级价
					//根据客户等级获取相应等级的批发价(2017年12月6日 废弃)
					//根据客户等级获取相应等级价
					 pfpirce = Number($(obj).find("input[name=hidselpfprice"+clientrank+"]").val());
					 //判断 有无等级价权限
					 if(permflag.indexOf("9") < 0 && isAdmin != "true") {
						 pfpirce = '-';
					  }
				}else{
					if("1"==selectsaletype){//销售类型是批发
						//获取批发价
						pfpirce = Number($(obj).find("input[name='hidselpfprice']").val());
					}else{
						//获取零售价
						pfpirce = Number($(obj).find("input[name='hidselprice']").val());
					}
				}
			}else{
				if("1"==selectsaletype){//销售类型是批发
					//获取批发价
					pfpirce = Number($(obj).find("input[name='hidselpfprice']").val());
				}else{
					//获取零售价
					pfpirce = Number($(obj).find("input[name='hidselprice']").val());
				}
			}
			pfpirce =='-'?0:Number(pfpirce).formatMoney();
			//修改单价下拉框
			//$(obj).find("ul[name='ulpriceli'] li:eq(1) span").text(pfpirce);
			
			if("1"==selectsaletype){//销售类型是批发
				if (permflag.indexOf(";2;") < 0 && isAdmin != "true") {
					pfpirce = '-';
				}
				if(url.indexOf("Lend/Add.htm") >=0 ){
					$(obj).find("input[name='txbPrice']").val(pfpirce=='-'?0:pfpirce);
				}else{
					/*订货佳版本，如果有特价 则取 特价
					 * 如果没有特价 则取 最近售价
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("51"== productversion){
						var selectSpecialPeice = $(obj).find("input[name='hidspecialprice']").val();//特价
						var pFlag = false;
						if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
							$(obj).find(txbInput).val(selectSpecialPeice);
							pFlag = true;
						}
						if(!pFlag){
							if (nearprice == '') {
								$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
							}else{
								$(obj).find(txbInput).val(nearprice);
							}
						}
					}
					/*专业版本
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("1"== productversion){
						if (nearprice == '') {
							$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
						}else{
							$(obj).find(txbInput).val(nearprice);
						}
					}
				}
			}else{//零售
				if (permflag.indexOf(";1;") < 0 && isAdmin != "true") {
					pfpirce = '-';
				}
				//获取零售价格
				var saleprice =pfpirce; //Number($(obj).find("ul[name='ulpriceli'] li:eq(0) span").text()).formatMoney();
				if (isNaN(saleprice)) {
					saleprice=0;
				}
				//4- 是最低售价 不是最近售价权限，最近售价 只要零售/批发有其一 就可以显示
				/*if (permflag.indexOf("4") < 0 && isAdmin != "true") {
					nearprice = 0;
				}*/
				if(url.indexOf("Lend/Add.htm") >=0 ){
					$(obj).find("input[name='txbPrice']").val(saleprice);
				}else{
					/*订货佳版本，如果有特价 则取 特价
					 * 如果没有特价 则取 最近售价
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("51"== productversion){
						var selectSpecialPeice = $(obj).find("input[name='hidspecialprice']").val();//特价
						var pFlag = false;
						if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
							$(obj).find(txbInput).val(selectSpecialPeice);
							pFlag = true;
						}
						if(!pFlag){
							if (nearprice == '') {
								$(obj).find(txbInput).val(saleprice);
							}else{
								$(obj).find(txbInput).val(nearprice);
							}
						}
					}
					/*专业版本
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("1"== productversion){
						if (nearprice == '') {
							$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
						}else{
							$(obj).find(txbInput).val(nearprice);
						}
					}
				}
			}
			$(obj).find(txbInput).change();
		}
	}
}

//根据客户的等级修改相应等级价格
function changeSaleReturnpfPriceByClientRankRowNearprice(obj,nearprice){
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();//客户等级价
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	var url = window.location.href;
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	//价格权限
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	
	if(("51"== productversion || "1"== productversion ) ){//订货平台开通客户等级价
		//存在商品则进行循环
		var productid = $(obj).find("input[name='hidProductId']").val();
		if(undefined !=productid && productid !=""){
			var pfpirce = 0;//2017年12月6日  pfpirce现在不代表普通批发价了。改成了 代表 等级价了（囊括了 零售价和批发价）
			if(IsOpenClientRankPrice == 1){
				if(clientrank == "1"||clientrank == "2"||clientrank == "3"){//存在客户等级价
					//根据客户等级获取相应等级的批发价(2017年12月6日 废弃)
					//根据客户等级获取相应等级价
					 pfpirce = Number($(obj).find("input[name=hidselpfprice"+clientrank+"]").val());
					 //判断 有无等级价权限
					 if(permflag.indexOf("9") < 0 && isAdmin != "true") {
						 pfpirce = '-';
					  }
				}else{
					if("1"==selectsaletype){//销售类型是批发
						//获取批发价
						pfpirce = Number($(obj).find("input[name='hidselpfprice']").val());
					}else{
						//获取零售价
						pfpirce = Number($(obj).find("input[name='hidselprice']").val());
					}
				}
			}else{
				if("1"==selectsaletype){//销售类型是批发
					//获取批发价
					pfpirce = Number($(obj).find("input[name='hidselpfprice']").val());
				}else{
					//获取零售价
					pfpirce = Number($(obj).find("input[name='hidselprice']").val());
				}
			}
			pfpirce =='-'?0:Number(pfpirce).formatMoney();
			//修改单价下拉框
			//$(obj).find("ul[name='ulpriceli'] li:eq(1) span").text(pfpirce);
			
			if("1"==selectsaletype){//销售类型是批发
				if (permflag.indexOf(";2;") < 0 && isAdmin != "true") {
					pfpirce = '-';
				}
				if(url.indexOf("Lend/Add.htm") >=0 ){
					$(obj).find("input[name='txbPrice']").val(pfpirce=='-'?0:pfpirce);
				}else{
					/*订货佳版本，如果有最近售价 则取 最近售价
					 * 如果没有最近售价 则取 特价
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("51"== productversion){
						if (nearprice == '') {
							var selectSpecialPeice = $(obj).find("input[name='hidspecialprice']").val();//特价
							var pFlag = false;
							if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
								$(obj).find(txbInput).val(selectSpecialPeice);
								//特价增加备注
								if($(obj).find("input[name='txbRowRemark']").val()==""){
									$(obj).find("input[name='txbRowRemark']").val("【特价】");
								}
								pFlag = true;
							}
							if(!pFlag){
								$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
								//非特价清空备注
								if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
									$(obj).find("input[name='txbRowRemark']").val("");
								}
							}
							
						}else{
							$(obj).find(txbInput).val(nearprice);
							//非特价清空备注
							if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
								$(obj).find("input[name='txbRowRemark']").val("");
							}
						}
						
					}
					/*专业版本
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("1"== productversion){
						if (nearprice == '') {
							$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
						}else{
							$(obj).find(txbInput).val(nearprice);
						}
					}
				}
			}else{//零售
				if (permflag.indexOf(";1;") < 0 && isAdmin != "true") {
					pfpirce = '-';
				}
				//获取零售价格
				var saleprice =pfpirce; //Number($(obj).find("ul[name='ulpriceli'] li:eq(0) span").text()).formatMoney();
				if (isNaN(saleprice)) {
					saleprice=0;
				}
				//4- 是最低售价 不是最近售价权限，最近售价 只要零售/批发有其一 就可以显示
				/*if (permflag.indexOf("4") < 0 && isAdmin != "true") {
					nearprice = 0;
				}*/
				if(url.indexOf("Lend/Add.htm") >=0 ){
					$(obj).find("input[name='txbPrice']").val(saleprice);
				}else{
					/*订货佳版本，如果有特价 则取 特价
					 * 如果没有特价 则取 最近售价
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("51"== productversion){
						if (nearprice == '') {
							var selectSpecialPeice = $(obj).find("input[name='hidspecialprice']").val();//特价
							var pFlag = false;
							if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
								$(obj).find(txbInput).val(selectSpecialPeice);
								pFlag = true;
								//特价增加备注
								if($(obj).find("input[name='txbRowRemark']").val()==""){
									$(obj).find("input[name='txbRowRemark']").val("【特价】");
								}
							}
							if(!pFlag){
								$(obj).find(txbInput).val(saleprice);
								//非特价清空备注
								if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
									$(obj).find("input[name='txbRowRemark']").val("");
								}
							}
							
						}else{
							$(obj).find(txbInput).val(nearprice);
							//非特价清空备注
							if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
								$(obj).find("input[name='txbRowRemark']").val("");
							}
						}
						
					}
					/*专业版本
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("1"== productversion){
						if (nearprice == '') {
							$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
						}else{
							$(obj).find(txbInput).val(nearprice);
						}
					}
				}
			}
			$(obj).find(txbInput).change();
		}
	}
}
//根据客户的等级修改相应等级批发价格
function changepfPriceByClientRankRow(obj){
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	var url = window.location.href;
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	//价格权限
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	if("51"== productversion || "1"== productversion ){//订货平台开通客户等级价
		//存在商品则进行循环
		var productid = $(obj).find("input[name='hidProductId']").val();
		if(undefined !=productid && productid !=""){
			var pfpirce = 0;
			if(IsOpenClientRankPrice == 1){
				if(clientrank == "1"||clientrank == "2"||clientrank == "3"){//存在客户等级价
					//根据客户等级获取相应等级价
					 pfpirce = Number($(obj).find("input[name=hidselpfprice"+clientrank+"]").val());
					 if (permflag.indexOf("9") < 0 && isAdmin != "true") {
							pfpirce = '-';
						}
				}else{
					//获取普通批发价
					if("1"==selectsaletype){//销售类型是批发
						//获取批发价
						pfpirce = Number($(obj).find("input[name='hidselpfprice']").val());
					}else{
						//获取零售价
						pfpirce = Number($(obj).find("input[name='hidselprice']").val());
					}
				}
			}else{
				if("1"==selectsaletype){//销售类型是批发
					//获取批发价
					pfpirce = Number($(obj).find("input[name='hidselpfprice']").val());
				}else{
					//获取零售价
					pfpirce = Number($(obj).find("input[name='hidselprice']").val());
				}
			}
			pfpirce =="-"? 0: Number(pfpirce).formatMoney();
			//修改单价下拉框
			//$(obj).find("ul[name='ulpriceli'] li:eq(1) span").text(pfpirce);
			
			//获取最近售价
			var nearprice = '';
			if (productid != undefined && productid != '' && url.indexOf("Lend/Add.htm") < 0) {
				var unitid = $(obj).find("input[name='hidUnitId']").val();
				var crvalue = $("#crvalue").val();
				var txbcr = $("#txbCr").val();
				if(permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 && isAdmin != "true"){
					nearprice = '';
				}else{
					nearprice = getNearSalePrice(productid, unitid, crvalue, txbcr);
				}
			}
			if("1"==selectsaletype){//销售类型是批发
				if (permflag.indexOf(";2;") < 0 && isAdmin != "true") {
					pfpirce = '-';
				}
				if(url.indexOf("Lend/Add.htm") >=0 ){
					//借出 只和 业务类型价 有关
					var sprice = $(obj).find("input[name='hidselpfprice']").val();
					if(sprice == undefined || sprice == "null" || sprice+"" == "" || sprice == "-"){
						sprice = 0;
					}
					$(obj).find("input[name='txbPrice']").val(Number(sprice).formatMoney());
				}else{
					/*订货佳版本，如果有特价 则取 特价
					 * 如果没有特价 则取 最近售价
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("51"== productversion){
						var selectSpecialPeice = $(obj).find("input[name='hidspecialprice']").val();//特价
						var pFlag = false;
						if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
							$(obj).find(txbInput).val(selectSpecialPeice);
							pFlag = true;
						}
						if(!pFlag){
							if (nearprice == '') {
								$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
							}else{
								$(obj).find(txbInput).val(nearprice);
							}
						}
					}
					/*专业版本
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("1"== productversion){
						if (nearprice == '') {
							$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
						}else{
							$(obj).find(txbInput).val(nearprice);
						}
					}
				}
			}else{//零售
				//获取零售价格
				if (permflag.indexOf(";1;") < 0 && isAdmin != "true") {
					pfpirce = '-';
				}
				var saleprice =pfpirce;// Number($(obj).find("ul[name='ulpriceli'] li:eq(0) span").text()).formatMoney();
				if (isNaN(saleprice)) {
					saleprice=0;
				}
				
				if(url.indexOf("Lend/Add.htm") >=0 ){
					//借出 只和 业务类型价 有关
					var sprice = $(obj).find("input[name='hidselprice']").val();
					if(sprice == undefined || sprice == "null" || sprice+"" == "" || sprice == "-"){
						sprice = 0;
					}
					$(obj).find("input[name='txbPrice']").val(Number(sprice).formatMoney());
				}else{
					/*订货佳版本，如果有特价 则取 特价
					 * 如果没有特价 则取 最近售价
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("51"== productversion){
						var selectSpecialPeice = $(obj).find("input[name='hidspecialprice']").val();//特价
						var pFlag = false;
						if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
							$(obj).find(txbInput).val(selectSpecialPeice);
							pFlag = true;
						}
						if(!pFlag){
							if (nearprice == '') {
								$(obj).find(txbInput).val(saleprice);
							}else{
								$(obj).find(txbInput).val(nearprice);
							}
						}
					}
					/*专业版本
					 * 如果没有 最近售价 则取 等级价
					 * 如果没有等级价 则取 业务类型价
					 * */
					if("1"== productversion){
						if (nearprice == '') {
							$(obj).find(txbInput).val(pfpirce=='-'?0:pfpirce);
						}else{
							$(obj).find(txbInput).val(nearprice);
						}
					}
				}
			}
			$(obj).find(txbInput).change();
			}
	}
}


//根据客户的等级修改相应等级批发价格
function changepfPriceByClientRank(isInit){
	var url = window.location.href;
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	//价格权限
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	
	if(("51"== productversion || "1"== productversion )){//订货平台开通客户等级价
	$("#tabdetail tr:gt(0)").each(function() {
		//存在商品则进行循环
		var productid = $(this).find("input[name='hidProductId']").val();
		if(undefined !=productid && productid !=""){
			var pfpirce = 0;
			if(1==IsOpenClientRankPrice){
				if(clientrank == "1"||clientrank == "2"||clientrank == "3"){//存在客户等级价
					//根据客户等级获取相应等级的批发价(2017年12月6日 废弃)
					//根据客户等级获取相应等级价
					 pfpirce = Number($(this).find("input[name=hidselpfprice"+clientrank+"]").val());
					 if(permflag.indexOf("9") < 0 && isAdmin != "true"){
						 pfpirce="-";
					 }
				}else{
					if("1"==selectsaletype){//销售类型是批发
						//获取批发价
						pfpirce = Number($(this).find("input[name='hidselpfprice']").val());
					}else{
						//获取零售价
						pfpirce = Number($(this).find("input[name='hidselprice']").val());
					}
				}
			}else{
				if("1"==selectsaletype){//销售类型是批发
					//获取批发价
					pfpirce = Number($(this).find("input[name='hidselpfprice']").val());
				}else{
					//获取零售价
					pfpirce = Number($(this).find("input[name='hidselprice']").val());
				}
			}
			pfpirce =="-"? 0: Number(pfpirce).formatMoney();
			//修改单价下拉框
			//$(this).find("ul[name='ulpriceli'] li:eq(1) span").text(pfpirce);
			
			//销售订单转销售，销售单的复制新增，和销退的复制新增，页面初始化时（打开时），商品显示的价格，为原单据价格，不需要做处理
		 	if( isInit && (url.indexOf("SaleOrder/TurnSale")!=-1 
					|| url.indexOf("SaleReturn/CopyAdd")!=-1
					|| url.indexOf("Sale/CopyAdd")!=-1)){
				//不操作单价
			}else{
				//获取最近售价
				var nearprice='';
				if (productid != undefined && productid != '' && url.indexOf("Lend/Add.htm") < 0) {
					var unitid = $(this).find("input[name='hidUnitId']").val();
					var crvalue = $("#crvalue").val();
					var txbcr = $("#txbCr").val();
					if(permflag.indexOf(";1;") < 0 && permflag.indexOf(";2;") < 0 && permflag.indexOf(";9;") < 0 && isAdmin != "true"){
						nearprice='';
					}else{
						nearprice = getNearSalePrice(productid, unitid, crvalue, txbcr);
					}
				}
				if("1"==selectsaletype){//销售类型是批发
					if (permflag.indexOf(";2;") < 0 && isAdmin != "true") {
						pfpirce = '-';
					}
					if(url.indexOf("Lend/Add.htm") >=0 ){
						//借出 只和 业务类型价 有关
						var sprice = $(this).find("input[name='hidselpfprice']").val();
						if(sprice == undefined || sprice == "null" || sprice+"" == "" || sprice == "-"){
							sprice = 0;
						}
						$(this).find("input[name='txbPrice']").val(Number(sprice).formatMoney());
					}else{
						/*订货佳版本，如果有特价 则取 特价
						 * 如果没有特价 则取 最近售价
						 * 如果没有 最近售价 则取 等级价
						 * 如果没有等级价 则取 业务类型价
						 * */
						if("51"== productversion){
							//var selectSpecialPeice = $(this).find("input[name='hidspecialprice']").val();//特价
							var pFlag = false;
						/*	if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
								//判断只有销售单、销售订单和销售退货新增时才修改显示价格，编辑、复制新增和修改都不修改显示的价格，显示的价格是原单的价格
								//if(url.indexOf("Sale/Add")>=0 ||url.indexOf("SaleOrder/Add")>=0 ||url.indexOf("SaleReturn/Add")>=0 ){
									$(this).find(txbInput).val(selectSpecialPeice);
									pFlag = true;
								//}
							}*/
							if(!pFlag){
								if (nearprice == '') {
									$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
								}else{
									//判断只有销售单、销售订单和销售退货新增时才修改显示价格，编辑、复制新增和修改都不修改显示的价格，显示的价格是原单的价格
									//if(url.indexOf("Sale/Add")>=0 ||url.indexOf("SaleOrder/Add")>=0 ||url.indexOf("SaleReturn/Add")>=0 ){
										$(this).find(txbInput).val(nearprice);
									//}
								}
							}
						}
						/*专业版本
						 * 如果没有 最近售价 则取 等级价
						 * 如果没有等级价 则取 业务类型价
						 * */
						if("1"== productversion){
							if (nearprice == '') {
								$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
							}else{
								//判断只有销售单、销售订单和销售退货新增时才修改显示价格，编辑、复制新增和修改都不修改显示的价格，显示的价格是原单的价格
								//if(url.indexOf("Sale/Add")>=0 ||url.indexOf("SaleOrder/Add")>=0 ||url.indexOf("SaleReturn/Add")>=0 ){
									$(this).find(txbInput).val(nearprice);
								//}
							}
						}
					}
				}else{//零售
					//获取零售价格
					if (permflag.indexOf(";1;") < 0 && isAdmin != "true") {
						pfpirce = '-';
					}
					var saleprice =pfpirce;// Number($(this).find("ul[name='ulpriceli'] li:eq(0) span").text()).formatMoney();
					if (isNaN(saleprice)) {
						saleprice=0;
					}
					if(url.indexOf("Lend/Add.htm") >=0 ){
						//借出 只和 业务类型价 有关
						var sprice = $(this).find("input[name='hidselprice']").val();
						if(sprice == undefined || sprice == "null" || sprice+"" == "" || sprice == "-"){
							sprice = 0;
						}
						$(this).find("input[name='txbPrice']").val(Number(sprice).formatMoney());
					}else{
						
						/*订货佳版本，如果有特价 则取 特价
						 * 如果没有特价 则取 最近售价
						 * 如果没有 最近售价 则取 等级价
						 * 如果没有等级价 则取 业务类型价
						 * */
						if("51"== productversion){
							//var selectSpecialPeice = $(this).find("input[name='hidspecialprice']").val();//特价
							var pFlag = false;
							/*if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
								//判断只有销售单、销售订单和销售退货新增时才修改显示价格，编辑、复制新增和修改都不修改显示的价格，显示的价格是原单的价格
								//if(url.indexOf("Sale/Add")>=0 ||url.indexOf("SaleOrder/Add")>=0 ||url.indexOf("SaleReturn/Add")>=0 ){
									$(this).find(txbInput).val(selectSpecialPeice);
									pFlag = true;
								//}
							}*/
							if(!pFlag){
								if (nearprice == '') {
									$(this).find(txbInput).val(saleprice);
								}else{
									//判断只有销售单、销售订单和销售退货新增时才修改显示价格，编辑、复制新增和修改都不修改显示的价格，显示的价格是原单的价格
									//if(url.indexOf("Sale/Add")>=0 ||url.indexOf("SaleOrder/Add")>=0 ||url.indexOf("SaleReturn/Add")>=0 ){
										$(this).find(txbInput).val(nearprice);
									//}
								}
							}
						}
						/*专业版本
						 * 如果没有 最近售价 则取 等级价
						 * 如果没有等级价 则取 业务类型价
						 * */
						if("1"== productversion){
							if (nearprice == '') {
								$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
							}else{
								//判断只有销售单、销售订单和销售退货新增时才修改显示价格，编辑、复制新增和修改都不修改显示的价格，显示的价格是原单的价格
								//if(url.indexOf("Sale/Add")>=0 ||url.indexOf("SaleOrder/Add")>=0 ||url.indexOf("SaleReturn/Add")>=0 ){
									$(this).find(txbInput).val(nearprice);
								//}
							}
						}
					}
				}
				$(this).find(txbInput).change();
			}
		   }
		});
	}
}


//根据客户的等级修改相应等级批发价格forlendturnsale
function changepfPriceForlendturnsale(isInit){
	var url = window.location.href;
	var IsOpenClientRankPrice = $(parent.document).find("#hidisopenclientrankprice").val();
	var productversion = $(parent.document).find("#productversion").val();//版本
	var selectsaletype = $("#hidselectsaletype").val();//选择的销售类型
	var clientrank = $("#txbClientRank").val();//客户等级
	var hidisopensaledetaildiscount = $("#hidisopensaledetaildiscount").val();//单行折扣
	//价格权限
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	//如果开启了单行折扣，则赋值给 单行折扣
	var txbInput = "input[name='txbPrice']";
	if(hidisopensaledetaildiscount == "1"){
		txbInput = "input[name='txbDiscountPrice']";
	}
	
	if("51"== productversion || "1" == productversion){//订货平台开通客户等级价
	$("#tabdetail tr:gt(0)").each(function() {
		//存在商品则进行循环
		var productid = $(this).find("input[name='hidProductId']").val();
		if(undefined !=productid && productid !=""){
			var pfpirce = 0;
			if(1==IsOpenClientRankPrice){
				if(clientrank == "1"||clientrank == "2"||clientrank == "3"){//存在客户等级价
					//根据客户等级获取相应等级的批发价
					 pfpirce = Number($(this).find("input[name=hidselpfprice"+clientrank+"]").val()).formatMoney();
					 if(permflag.indexOf("9") < 0 && isAdmin != "true"){
						 pfpirce="-";
					 }
				}else{
					if("1"==selectsaletype){//销售类型是批发
						//获取批发价
						pfpirce = Number($(this).find("input[name='hidselpfprice']").val());
					}else{
						//获取零售价
						pfpirce = Number($(this).find("input[name='hidselprice']").val());
					}
				}
			}else{
				if("1"==selectsaletype){//销售类型是批发
					//获取批发价
					pfpirce = Number($(this).find("input[name='hidselpfprice']").val());
				}else{
					//获取零售价
					pfpirce = Number($(this).find("input[name='hidselprice']").val());
				}
			}
			pfpirce =="-"? 0: Number(pfpirce).formatMoney();
			
			//修改单价下拉框
			//$(this).find("ul[name='ulpriceli'] li:eq(1) span").text(pfpirce);
			//借出转销售
			if(!isInit){
				var hidselectpricetype = $(this).find("input[name='hidselectpricetype']").val();
			//	if("3" != hidselectpricetype){//不是最近售价
					if("1"==selectsaletype){//销售类型是批发
						if("51"== productversion){
							//var selectSpecialPeice = $(this).find("input[name='hidspecialprice']").val();//特价
							var pFlag = false;
							/*if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
								$(this).find(txbInput).val(selectSpecialPeice);
								pFlag = true;
							}*/
							if(!pFlag){
								//如果没有特价，则查看是否有最近售价
								var nearprice = $(this).find(txbInput).parent().find("li[dataname='linear']").find(".money").text();
								if(nearprice != undefined && nearprice!="null" && nearprice+"" != ""){
									nearprice = nearprice.replace(/,/g, "");
									if(nearprice == "-"){
										nearprice = 0;
									}
									nearprice = Number(nearprice).formatMoney();
									$(this).find(txbInput).val(nearprice);
								}else{
									$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
								}
							}
						}
						if("1"== productversion){
							//如果没有特价，则查看是否有最近售价
							var nearprice = $(this).find(txbInput).parent().find("li[dataname='linear']").find(".money").text();
							if(nearprice != undefined && nearprice!="null" && nearprice+"" != ""){
								nearprice = nearprice.replace(/,/g, "");
								if(nearprice == "-"){
									nearprice = 0;
								}
								nearprice = Number(nearprice).formatMoney();
								$(this).find(txbInput).val(nearprice);
							}else{
								$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
							}
						}
					//	$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
					}else{//零售
						if("51"== productversion){
							//var selectSpecialPeice = $(this).find("input[name='hidspecialprice']").val();//特价
							var pFlag = false;
							/*if(selectSpecialPeice != undefined && selectSpecialPeice != null && String(selectSpecialPeice) != "null" && String(selectSpecialPeice) != ''){
								$(this).find(txbInput).val(selectSpecialPeice);
								pFlag = true;
							}*/
							if(!pFlag){
								var nearprice = $(this).find(txbInput).parent().find("li[dataname='linear']").find(".money").text();
								if(nearprice != undefined && nearprice!="null" && nearprice+"" != ""){
									nearprice = nearprice.replace(/,/g, "");
									if(nearprice == "-"){
										nearprice = 0;
									}
									nearprice = Number(nearprice).formatMoney();
									$(this).find(txbInput).val(nearprice);
								}else{
									$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
								}
							}
						}
						if("1"== productversion){
							var nearprice = $(this).find(txbInput).parent().find("li[dataname='linear']").find(".money").text();
							if(nearprice != undefined && nearprice!="null" && nearprice+"" != ""){
								nearprice = nearprice.replace(/,/g, "");
								if(nearprice == "-"){
									nearprice = 0;
								}
								nearprice = Number(nearprice).formatMoney();
								$(this).find(txbInput).val(nearprice);
							}else{
								$(this).find(txbInput).val(pfpirce=='-'?0:pfpirce);
							}
						}
					}
				//}
				$(this).find(txbInput).change();
			}
			}
		});
	}
}

/**
 * 打开支付界面
 */
function toOnlinePay(busiid,amount,busitype,lastpaytype,accounttype){
	//判断是否第一次使用移动支付  如果是第一次先弹出选择界面
	parent.layer.open({
		title:false,
	    type: 2,
	    area: ['651px', '355px'],
	    fix: false, //不固定
	    maxmin: false,
	    closeBtn:false,
	    content: "/UCenter-webapp/OnlinePay/Pay.htm?paytype="+lastpaytype+"&busiid="+busiid+"&amount="+amount+"&busitype="+busitype+"&accounttype="+accounttype,
	    success:function(layero,index){
	    }
	});
}
/**
 * 打开选择支付界面
 */
function toChooseOnlinePayType(accounttype){
	parent.layer.open({
		title:false,
	    type: 2,
	    area: ['651px', '355px'],
	    fix: false, //不固定
	    maxmin: false,
	    closeBtn:false,
	    content: "/UCenter-webapp/OnlinePay/ChoosePayType.htm?accounttype="+accounttype,
	    success:function(layero,index){
	     }
	});
}
function levelremark(){
	 
	var accounttype=$("#levelSelect-account .ls-remark").val();
	 
	if(accounttype=="1"||accounttype=="2"){
		$("#txbreceamt").attr("readonly",true);
		$("#txbreceamt").addClass("inputReadOnly");
		var fareceamt=Number($.trim($("#spanFaReceAmt").html().replace(",", "")));
		if($("#txbdeposit").val()!=undefined){
			fareceamt=fareceamt-Number($("#txbdeposit").val());
		}
		$("#txbreceamt").val(fareceamt.formatMoney()).change();
	}else{
		$("#txbreceamt").attr("readonly",false);
		$("#txbreceamt").removeClass("inputReadOnly");
		var fareceamt = Number($.trim($("#spanFaReceAmt").html().replace(",", "")));
		if($("#txbdeposit").val()!=undefined){
			fareceamt=fareceamt-Number($.trim($("#txbdeposit").val()));
 		}
		var autoCompleteSaleReceamt=1;
		if($('#AutoCompleteSaleReceAmt').val()!=undefined){
			autoCompleteSaleReceamt=$('#AutoCompleteSaleReceAmt').val();
		}
		if(autoCompleteSaleReceamt==1){
			$("#txbreceamt").val(fareceamt.formatMoney()).change();
		}else{
			//未开启销售时自动补齐实收金额时，不修改实收金额值
			if(""==$("#txbreceamt").val()){
				var fareceamt = 0;
				$("#txbreceamt").val(fareceamt.formatMoney());
			}
		}
	}
}


/**
 * 载入门店
 * @param branchId
 */
function initBranch(branchId){
	$.ajax({  
        type: "POST",  
        url: "/UCenter-webapp/Branch/getBranch.json",  
        success:function(result, resultState){  
        	if(result!=null&&typeof(result)!="object"&&result.indexOf("智慧商贸 登录")>-1){//跳转到登陆界面
        		parent.window.location.parentCancelReload(true);
        	}
        	if (resultState == "success") {
    			if (result.serviceResult.statu == 1) {
    				var branchHtml="<select id='branch' onchange='showButton()'>";
    	        	var branchList = result.serviceResult.rows;
    	        	if(branchList!=null){
    	        		var len = branchList.length;
        	        	for(var i=0;i<len;i++){
        	        		var branchname = branchList[i].branchname;
    						if (branchname.length > 10) {
    							branchname = branchname.substring(0, 15)
    									+ '...';
    						}
        	        		if(branchId==branchList[i].branchid){
        	        			$("#hidbranchissys").val(branchList[i].issys);
        	        			branchHtml += '<option selected="selected" value="'+branchList[i].branchid+'" title="'+branchList[i].branchname+'" isSys="'+branchList[i].issys+'"> '+branchname+'</option>';
        	        		} else {
        	        			branchHtml += '<option value="'+branchList[i].branchid+'" title="'+branchList[i].branchname+'" isSys="'+branchList[i].issys+'"> '+branchname+'</option>';
        	        		}
        	        	}
        	        	branchHtml += '</select>';
        	        	$("#branch_td").empty();
        	        	$("#branch_td").append(branchHtml);
    	        	}
    			} else {
    				showErrorMsg(result.serviceResult.message);
    			}
    		} else {
    			showErrorMsg("操作失败");
    		}
        }
 });  
}
//开启多仓销售订单高级搜索加载仓库
function loadWarehousedatasearch(queryWarehouseOkFunc, branchid, type, excludeStop){
$.ajax({
	dataType : "json",
	data : {
		"branchid" : ("undefined"!=typeof branchid && null!=branchid && ""!=branchid)? branchid : null,
		"type" : ("undefined"!=typeof type && null!=type && ""!=type)? type : 1,
		"excludestop" : excludeStop
	},
	cache : false,
	async : false,
	url : "/UCenter-webapp/commondata/getwarehouseincludestop.json",
	type : "post",
	success : function(data) {
		if("undefined" != typeof queryWarehouseOkFunc && ""!=queryWarehouseOkFunc){
			queryWarehouseOkFunc(data);
		}else{
			$("#warehouseDropList .droplist").append("<div class=\"list-item default\" id=\"all\" onclick=\"searchchooseWarehouse(this)\" data-value=\""+""+"\">全部</div>");
			for ( var i = 0; i < data.Items.length; i++) {
				$("#warehouseDropList .droplist").append("<div class=\"list-item\" onclick=\"searchchooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\">"+data.Items[i]["text"]+"</div>");
			}
			$("#txbWarehouse").val($("#all").html());
		}
	 },
	error : function() {
		alert("加载列表仓库下拉框失败");
	}
});
}
//开启多仓销售订单选择仓库
function searchchooseWarehouse(obj){
  	var warehousename=$(obj).html();
	var warehouseid=$(obj).attr("data-value");
	if(warehouseid==undefined){
		warehousename="预订";
	}
  	if(warehousename=="预订"&&(warehouseid==undefined)){
		$(obj).parent().parent().parent().parent().find("input[name='hiddetailwarehouseid']").val("00000000-0000-0000-0000-000000000000");
		$(obj).parent().parent().parent().parent().find("input[name='txbWarehouse']").val(warehousename);
	}else{
	 $(obj).parent().parent().parent().parent().find("input[name='hiddetailwarehouseid']").val(warehouseid);
	 $(obj).parent().parent().parent().parent().find("input[name='txbWarehouse']").val(warehousename);
	}
	$(".yun-ui-droplist-wrap").hide();
	
}
/**
 * 加载仓库下拉框  包括列表和批量
 */
function loadWarehouseDropListData(){
	var sel = window.location.href;
	$.ajax({
		dataType : "json",
		data : {},
		cache : false,
		async : false,
		url : "/UCenter-webapp/commondata/getwarehouse.json?type=1",
		type : "post",
		success : function(data) {
			for ( var i = 0; i < data.Items.length; i++) {
				if(data.Items[i]["selected"]=="1"){
					if(sel.indexOf("SaleOrder/Add")>=0 ||sel.indexOf("SaleOrder/CopyAdd")>=0 ||sel.indexOf("SaleOrder/EditInit")>=0 ){
						$("#warehouseDropList .droplist").append("<div class=\"list-item default\" tabindex=\"0\" name=\"multiwarehouse\" id=\"multiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
						
					}else{
						if(data.Items[i]["islocked"]=="1"){
							$("#warehouseDropList .droplist").append("<div style='color:#FD6C54;' title='盘点中' class=\"list-item default\" tabindex=\"0\" name=\"multiwarehouse\" id=\"multiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
						}else{
							$("#warehouseDropList .droplist").append("<div class=\"list-item default\" tabindex=\"0\" name=\"multiwarehouse\" id=\"multiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
						}
					}
				}else{
					if(sel.indexOf("SaleOrder/Add")>=0 ||sel.indexOf("SaleOrder/CopyAdd")>=0 ||sel.indexOf("SaleOrder/EditInit")>=0 ){
						$("#warehouseDropList .droplist").append("<div class=\"list-item\" tabindex=\"0\" name=\"multiwarehouse\" id=\"multiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
						
					}else{
						if(data.Items[i]["islocked"]=="1"){
							$("#warehouseDropList .droplist").append("<div style='color:#FD6C54;' title='盘点中' class=\"list-item\" tabindex=\"0\" name=\"multiwarehouse\" id=\"multiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
						}else{
							$("#warehouseDropList .droplist").append("<div class=\"list-item\" tabindex=\"0\" name=\"multiwarehouse\" id=\"multiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
						}
						
					}
				}
				if(sel.indexOf("SaleOrder/Add")>=0 ||sel.indexOf("SaleOrder/CopyAdd")>=0 ||sel.indexOf("SaleOrder/EditInit")>=0 ){
					$("#batchChooseWarehouse ul").append("<li onclick=\"BatchChooseWarehouse(this)\" name=\"batchmultiwarehouse\"  data-islocked=\""+data.Items[i]["islocked"]+"\" data-id=\""+data.Items[i]["value"]+"\" data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</li>");
					
				}else{
					if(data.Items[i]["islocked"]=="1"){
						$("#batchChooseWarehouse ul").append("<li style='color:#FD6C54;' title='盘点中' onclick=\"BatchChooseWarehouse(this)\" name=\"batchmultiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" data-id=\""+data.Items[i]["value"]+"\" data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</li>");
					}else{
						$("#batchChooseWarehouse ul").append("<li onclick=\"BatchChooseWarehouse(this)\" name=\"batchmultiwarehouse\" data-islocked=\""+data.Items[i]["islocked"]+"\" data-id=\""+data.Items[i]["value"]+"\" data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</li>");
					}
				}
			}
		},
		error : function() {
			alert("加载列表仓库下拉框失败");
		}
	});

}
/**
 * 下拉框仓库选中
 * @param obj
 */
function chooseWarehouse(obj){
	var warehousename=$(obj).attr("data-name");
	var warehouseid=$(obj).attr("data-value");
	var islocked = $(obj).attr("data-islocked");
	var url = window.location.href;

	if(url.indexOf("/SaleOrder/Add.htm")>=0 || url.indexOf("/SaleOrder/CopyAdd.htm")>=0 || url.indexOf("/SaleOrder/EditInit.htm")>=0){
		
	}else{
		if(checkisLockWarehouse(warehouseid,2)){
			return;
		}
	}
	var rowobj=$(obj).parent().parent().parent().parent().parent();
	if(warehouseid==undefined || warehouseid==null || warehouseid==""){
		warehousename="预订";
		rowobj=$(obj).parent().parent().parent().parent();
	}
	var detailtype=$(rowobj).find("input[name='hiddetailtype']").val();
	$(obj).parent().parent().parent().parent().find("input[name='hiddetailwarehouseid']").val(warehouseid);
	$(obj).parent().parent().parent().parent().find("input[name='txbWarehouse']").val(warehousename);
	$(obj).parent().parent().parent().parent().find("input[name='hiddetailwarehouseislocked']").val(islocked);
	
	getProductStock($(obj).parents("tr:first"));
	
	//相同商品的锁库量需要合计，因此库存需要重新计算
	if("orderPlusManagerShopOrder-receOrder"==$("#pagebusinessname").val()
			&& "undefined"!=typeof sumStockCountBySameProductOrderCount){
		//sumStockCountBySameProductOrderCount();
	}
	
	if(detailtype=="1"){
		var ptid=$(rowobj).find("input[name='hidptid']").val();
		
		$("input[name='hidptid'][value='" + ptid + "']").each(function() {
			if($(this).parent().parent().find("input[name='hiddetailtype']").val()=="0"){
				$(this).parent().parent().find("input[name='hiddetailwarehouseid']").val(warehouseid);
				$(this).parent().parent().find("input[name='txbWarehouse']").val(warehousename);
				$(this).parent().parent().find("input[name='hiddetailwarehouseislocked']").val(islocked);
				getProductStock($(this).parent().parent());
				
				//相同商品的锁库量需要合计，因此库存需要重新计算
				if("orderPlusManagerShopOrder-receOrder"==$("#pagebusinessname").val()
					&& "undefined"!=typeof sumStockCountBySameProductOrderCount
				){
					//sumStockCountBySameProductOrderCount();
				}
				
			}
		});
		if($(rowobj).find("input[name='hiddetailtype']").val()=="1"){
			if($("#hidstockTipsRsul").val() == 2){
				calamt($(rowobj), 'count');
				if("undefined" != typeof caltotalamt)
					caltotalamt();
			}
		}
		
	}else{
		if($("#hidstockTipsRsul").val() == 2 ){
			calamt($(rowobj), 'count');
			if("undefined" != typeof caltotalamt)
				caltotalamt();
		}
	}
	
	
	$(".yun-ui-droplist-wrap").hide();
	reLoadUser();
	if($(obj).parent().parent().parent().find(".receiptsInputTextError").is(":visible")){
		$(obj).parent().parent().parent().find("#hdetailwarehousename").removeClass("receiptsInputTextError");
		$(obj).parent().parent().parent().find("#hdetailwarehousename").addClass("receiptsInputText");
	}
	//选中多仓仓库后将焦点置于数量狂
	$(rowobj).find("input[name='txbCount']").focus();
	$(rowobj).find("input[name='txbCount']").select();
}
function reLoadUser(){
	if($("#thechooseuser").val()==""){
		$("#thechooseuser").val($("#choose-user-val").val());
	}
	var warehouseids=getChooseWarehouseIds();
	//是否验证查看他人单据权限
	var isnotvalidate = $("#isnotvalidate").val();
	var isAddBill = 0;
	var url = 'commondata/getuser.json?warehouseids=' + warehouseids;
	//目前仅限制销售模块
	if("1" == isnotvalidate){
		url += "&isaddbill=1"
	}
	//销售订单模块
	var noWarehouseTab = 1;
	if("AddSaleOrder"==$("#busitype").val() || "saleorder"==$("#pagebusinessname").val()){
		var warehouseidarr = [];
		if(null!=warehouseids){
			warehouseidarr = warehouseids.split(",");
		}
		var hasNoYd = false;//是否有不是预订的仓库
		for(var i in warehouseidarr){
			if(""!=warehouseidarr[i]){
				hasNoYd = true;
				break;
			}
		}
		if(!hasNoYd){
			url = url+'&nowarehouse=1';//如果全部是预定仓库的话，则不需要过滤仓库权限
			noWarehouseTab =0;
		}
			
	}
	var productversion =$("#productversion").val();
	if(productversion == undefined || productversion == null || productversion == ""){
		productversion =$("#hidproductversion").val();
	}
	if(productversion == undefined || productversion == null || productversion == ""){
		productversion = $(parent.document).find("#productversion").val();
	}
	if((productversion == "51" || productversion == "1")&& $("#crvalue").val() != undefined && $("#crvalue").val() != null && $("#crvalue").val() != "" && $("#selectClientRelationIsNull").val() == "1"){
		var salesmanuserid = $("#salesmanuserid").val();//关联业务员的ID
		var salesmanusername = $("#salesmanusername").val();//关联业务员的名称
		var salesmanisdel = $("#salesmanisdel").val();//关联业务员 是否删除
		var salesmanuserstatus = $("#salesmanuserstatus").val();//关联业务员是否 锁定
		var salesmanusertype = $("#salesmanusertype").val();//关联业务的类型
		reloadHandMan(salesmanusername,salesmanuserid,salesmanusertype,salesmanisdel,salesmanuserstatus,"1","1");
	}else{
		levelSelect.init(url, 'user',1,0,0,false);
		$("#levelSelect-user").find("input[name='levelSelect-user-input']").removeClass("InputBdRed");
		//在选中刚才选中的人
		$("#ls-li-user-"+$("#thechooseuser").val()).click();
	}
	
	
}
/**
 * 选择商品后加载仓库下拉框
 * @param warehouseid
 * @returns
 */
function tableLoadWarehouseDropList(warehouseid){
	var obj=$("#warehouseDropList").clone().attr("id","lineWarehouseDropList");
	return obj;
}
/**
 * 批量选择仓库选中事件
 * @param obj
 */
function BatchChooseWarehouse(obj){
	var len=0;
	$("#tabdetail tr:not(:first):not(:last)").each(function() {
		var productid = $(this).find("input[name='hidProductId']").val();
		if (productid != '' &&productid!=undefined && $(this).find("input[name='hiddetailtype']").val() != "1") {
			len++;
		}
	});
	var urlsaleorder = window.location.href;
	if( Number(len) >0 && (urlsaleorder.indexOf("/SaleOrder/Add.htm")==-1 && urlsaleorder.indexOf("/SaleOrder/CopyAdd.htm")==-1 && urlsaleorder.indexOf("/SaleOrder/EditInit.htm")==-1)){
		if(checkisLockWarehouse($(obj).attr("data-id"),2)){
			return;
		}
		$(".popArea:not(#FriendlyTip)").css("width", "350px");
		$("#importName1").html("正在检查库存不足商品");
		$("#importName2").html("已检查");
		$(".importDiv").show();
		$(document.body).css("overflow", "hidden");
		$("#totalnumber").html(len);
		$("#numberSpan").show();
	}
	
	setTimeout(function(){

		
		var warehousename=$(obj).attr("data-name");
		var warehouseid=$(obj).attr("data-id");
		var islocked = $(obj).attr("data-islocked");
		var url = window.location.href;
		
		if(url.indexOf("/SaleOrder/Add.htm")>=0 || url.indexOf("/SaleOrder/CopyAdd.htm")>=0 || url.indexOf("/SaleOrder/EditInit.htm")>=0){
			
		}else{
			if(checkisLockWarehouse(warehouseid,2)){
				return;
			}
		}
		if(warehouseid==undefined || warehouseid==null || warehouseid==""){
			warehousename="预订";
		}
		$("input[name='txbWarehouse']").val(warehousename);
		$("input[name='hiddetailwarehouseid']").val(warehouseid);
		$("input[name='hiddetailwarehouseislocked']").val(islocked);
		$("#batchChooseWarehouse").hide();
		var i=0;
		$("#tabdetail tr:gt(0)").each(function() {
			var productid = $(this).find("input[name='hidProductId']").val();
			if (productid != '' &&productid!=undefined && $(this).find("input[name='hiddetailtype']").val() != "1") {
				if (i < len) {
					i++;
					$("#currentnumber").html(i);
					$(".progressIN").css("width", (i / len * 100) + "%");
				} else {
					$(".importDiv").hide();
					$("#numberSpan").hide();
					$(document.body).css("overflow", "auto");
				}
				
				getProductStock(this);
				
				if($("#hidstockTipsRsul").val() == 2){
					calamt(this, 'count');
				}
			}

			if(productid != '' &&productid!=undefined && $(this).find("input[name='hiddetailtype']").val()=="1"){
				if($("#hidstockTipsRsul").val() == 2){
					calamt(this, 'count');
					caltotalamt();
				}
			}
		});
		
		var warehouseids=getChooseWarehouseIds();
		if(warehouseids!=""){
			reLoadUser();
		}
		$(".importDiv").hide();
		$("#numberSpan").hide();
		$(document.body).css("overflow", "auto");
	},100);
	
}

function getRatioCount2WarehouseList(ratio, stock, unitname, mainunitname) {
	var m = 0, n = 0, showstr = '';
	if (ratio != '' && Number(ratio) > 0) {
		n = stock % ratio;
		m = (stock - n) / ratio;
		showstr = formatRatioUnit(m);
		if (n != 0  && unitname!=mainunitname) {
			showstr += unitname + formatRatioUnit(n) + mainunitname;
		}else if(n != 0 && unitname==mainunitname){
			showstr = formatRatioUnit(m+n) + mainunitname;
		}else if(Number(showstr)!=0){
			showstr+=unitname;
		}
	} else {
		showstr = stock;
	}
	return showstr;
}

function formatRatioUnit(value){
	return parseFloat(formatCountN(parseFloat(Number(String(value).replace(/,/g, "")))));
}

//批量按钮点击事件 显示仓库下拉
function showBatchWarehouse(){
	$(".WarehouseDrop").hide();
	$("#batchChooseWarehouse").show();
}
function showWarehouseDropList(obj,type){
	//type = ReceOrder 表示 网店订单接单时，单行选择仓库 需要显示该行商品的 库存信息
	if("undefined" != typeof type ){
		var stockWarehouseFalg = false;
		if("ReceOrder" == type ){
			//var paytype = $("#paytype").val();//3-货到付款 5-欠款结算
			//if( undefined != paytype && (3 == paytype || 5 == paytype) ){
				stockWarehouseFalg = true;
			//}
		}else if("Sale" == type || "SaleOrder" == type || "TurnSale" == type){
			stockWarehouseFalg = true;
		}
		if(stockWarehouseFalg){
			var curTrObj = $(obj).parent().parent().parent();
			var isNoPT = $(curTrObj).find("input[name='hidptid']").val() == undefined || $(curTrObj).find("input[name='hidptid']").val() == "" ? true : false;
			if(!$(obj).parent().find("div[name='warehouselist']").is(":visible") ){
				if(isNoPT){
					getOrdinaryWarehouseList(obj,type);
				}else{
					getPTWarehouseList(obj,type);
				}
			}
		}
	}
	$(".FSvalue").hide();
	//$(".WarehouseDrop").hide();
	if(!$(obj).parent().find("div[name='warehouselist']").is(":visible")){
		$(".WarehouseDrop").hide();
  	}
	$(obj).parent().find("div[name='warehouselist']").toggle();
}
//获取所有行选中的仓库id
function getChooseWarehouseIds(){
	var warehouseids="";
	$("#tabdetail tr:gt(0)").each(function() {
		var productid = $(this).find("input[name='hidProductId']").val();
		if (productid!=undefined && productid !=null &&productid != '') {
			var warehouseid=$(this).find("input[name='hiddetailwarehouseid']").val();
			if(warehouseid!=undefined && warehouseids.indexOf(warehouseid)<0){
				warehouseids+=warehouseid+",";
			}
		}
	});
	return warehouseids;
	
}
//更改仓库时获取库存
function getProductStock(obj,isScan, isdaoru){
	var isPageAddSale = $("#busitype").val();
	//当是销售退货时。没有查询库存
   if($("#pagebusinessname").val()!="SaleReturn"){
	var warehouseid=$(obj).find("input[name='hiddetailwarehouseid']").val();
	var productid=$(obj).find("input[name='hidProductId']").val();
	//获取未转销售数量
	var noReturnCount=$.trim($(obj).find("input[name='hidnoreturncount']").val());
	var unitRatio=$.trim($(obj).find("input[name='hidunitratio']").val());
	var oldWarehouseId=$.trim($(obj).find("input[name='hidoldwarehouseid']").val());
	if(productid!='' && productid!=null && warehouseid!='' && warehouseid!=null ){
	   //清空序列号
		if(String(isScan).indexOf("1")==-1 && String(isdaoru).indexOf("isdaoru")==-1){
			$(obj).find("input[name='hidSerialId']").val("");
	  		$(obj).find("input[name='hidSerialNo']").val("");
			if(($(obj).find("input[name='hidSnmanage']").val()=="1") || ($(obj).find("span[class='sn']").is(":visible") == true)){
	  			if($("#pagebusinessname").val() == 'add-sale'){//新增销售单页面切换仓库 情况序列号数量等
	  				$(obj).find(".snno ").html("0");
	  	 			$(obj).find(".sncount").html("0");
	  	  			$(obj).find(".spanSerialNo").html("");
	  	  			$(obj).find("input[name='txbCount']").val("");
	  			}else{
	  				//$(obj).find(".snno ").html("0");//转销售时 不清空“数量”行，清空“序列号”行
	  	 			$(obj).find(".sncount").html("0");
	  	  			$(obj).find(".spanSerialNo").html("");
	  	  			//$(obj).find("input[name='txbCount']").val("");
	  			}
			}
		}
     	
		$.ajax({
	        dataType: "json",
	        data: {
	        	warehouseid: warehouseid,
	            productid: productid
	        },
	        cache: false,
	        async: false,
	        url: "/UCenter-webapp/Product/GetProductStock.json?" + Math.random(),
	        type: "post",
	        success: function(o) {
	        	if(o.data!=null&&o.data!=undefined){
	        		var stockcount=0;
	        		//当前库存
	        		var curCount = 0;
	        		//锁库量
	        		var orderCount = 0;
	        		if(isPageAddSale == "TurnSaleOrderPage" ){
	        			stockcount= Number(o.data.curstockcount) + Number(getProductBillOrderStock(productid,warehouseid)); //+o.data.orderstock;
	        		}else if(isPageAddSale == "orderPlusManagerShopOrder-receOrder"){
	        			stockcount=o.data.curstockcount + getProductBillOrderStock(productid,warehouseid);
	        		}else{
	        			if(isPageAddSale=="AddSaleOrder" ||"CopyAddSaleOrder"==isPageAddSale ||"EditSaleOrder"==isPageAddSale || oldWarehouseId != warehouseid){
		        			stockcount=o.data.curstockcount;
		        		}else{
		        			stockcount=o.data.curstockcount+ o.data.orderstock;
		        			orderCount = ""==noReturnCount ? 0 : o.data.orderstock;
		        			curCount = o.data.curstockcount;
		        		}
	        		}
	        		
	        		$(obj).find("input[name='hidstockcount']").val(stockcount);
	        		//将库存分别保存在属性值中
	        		$(obj).find("input[name='hidstockcount']").attr("getStockCount", stockcount);
	        		//$(obj).find("input[name='hidstockcount']").attr("orderStockCount", orderCount);
	        	}else{
	        		$(obj).find("input[name='hidstockcount']").val("0");
	        		//将库存分别保存在属性值中
	        		$(obj).find("input[name='hidstockcount']").attr("getStockCount", 0);
	        		$(obj).find("input[name='hidstockcount']").attr("orderStockCount", 0);
	        	}
	        },
	        error: function() {
	        	showErrorMsg("获取商品库存失败");
	        }
	    });
	}
}
}

function leveluseronloadlist(){
	$("#thechooseuser").val($("#choose-user-val").val());
	if($(parent.document).find("#productversion").val() == "51"){
		$("#hidDefaultItem").val($("#choose-user-val").val());
	}
	
}
//未开启多仓单 更改仓库 清空序列号
function getClearProducrStock(obj){
	//清空序列号
	//当hidSerialId有值时 此商品为序列号商品

	if($(obj).find("span[class='sn']").is(":visible") == true){
		$(obj).find("input[name='hidSerialId']").val("");
		$(obj).find("input[name='hidSerialNo']").val("");
		$(obj).find(".snno").html("0");
		$(obj).find("input[name='txbCount']").val("");
		$(obj).find(".sncount").html("0");
		$(obj).find(".spanSerialNo").html("");
	}

}


//设置cookie，记忆折扣类型
function setCookieDisCountType(branchid,discounttype){
	setCookie(branchid, discounttype);
}
//获取cookie
function getCookieDisCountType(branchid){
	var type = getCookie(branchid);
	if(type == null || type=="" ||type==undefined){
		type =0;
	}
	
	if(type == 0){//折扣率
		$("#txdiscounttype").val("折扣率");
		$("#hiddiscounttype").val("0");
		$("#COMBO_WRAP div:first .droplist div:first").addClass("selected");
		$("#COMBO_WRAP div:first .droplist div:last").removeClass("selected");
		
		$("#showdisrate").show();
		$("#showdisamt").hide();
	}else{//折扣额
		$("#txdiscounttype").val("折扣额");
		$("#hiddiscounttype").val("1");
		$("#COMBO_WRAP div:first .droplist div:first").removeClass("selected");
		$("#COMBO_WRAP div:first .droplist div:last").addClass("selected");
		
		$("#showdisamt").show();
		$("#showdisrate").hide();
	}
	
}
/**
 * 作废他人单据权限判断
 */
function writeBackOtherUserBill(userid){
	var flat=false;
	$.ajax({
        dataType: "json",
        data: {userid:userid},
        cache: false,
        async: false,
        url: "/UCenter-webapp/SysUser/getuserinfo.json?" + Math.random(),
        type: "post",
        success: function(o) {
        	if(o.permflag.indexOf(';8;') != -1){//允许 作废他人单据权限
        		
        		flat = true;
        	}
        },
        error: function() {
        	console.log("查询 当前登录用户是否拥有作废他人单据权限失败");
        }
    });
	return flat;
}

function getWareHouseIsLocked(type){
	var isstop = false;
	var islock = $("#hiddetailwarehouseislocked").val();
	if(islock == 1){
		cancelSelect();
		if(type == 1){
			alert("该仓库正在盘点，解锁后才能进行出入库类业务操作！");
		}
		isstop = true;
	}
	return isstop;
}
/*
 * 保存保存单据时做仓库判断
 * @param warehouseid
 * @returns {Boolean}
 */
function checkisLockWarehouse(warehouseid,type){
	var pv = $(parent.document).find("#productversion").val();
	var flat = false;
	if(pv != 3){
		var param={};
		param['warehouseid'] = warehouseid;
		if(undefined != warehouseid && ""!=warehouseid && null != warehouseid){
			$.ajax({
		        dataType: "json",
		        data: {warehouseid:warehouseid},
		        cache: false,
		        async: false,
		        url: "/UCenter-webapp/Warehouse/Warehouseinfo.json?" + Math.random(),
		        type: "post",
		        success: function(o) {
		        	var lock = o.serviceResult.islocked;
		        	if(type==1){
		        		if(lock == 1){
							showErrorMsg("单据中所选仓库正在盘点中，解锁后才能进行出入库类业务操作!");
							flat = true;
		        		}
		        	}else if(type == 2){
		        		if(lock == 1){
		        			alert("该仓库正在盘点，解锁后才能进行出入库类业务操作！");
			        		flat = true;
		        		}
		        	}else if(type == 3){
		        		if(lock == 1){
		        			alert("该序列号所在仓库正在盘点，解锁后才能进行出入库类业务操作！");
			        		$("#StrScan").val("");
			        		flat = true;
		        		}
		        		
		        	}else if(type == 4){
		        		if(lock == 1){
		        			cancelSelect();
		        			alert("该仓库正在盘点，解锁后才能进行出入库类业务操作！");
			        		flat = true;
		        		}
		        		
		        	}else if(type == 5){
		        		if(lock ==1){
		        			alert("原单据中的仓库正在盘点，请解锁该仓库后再进行此操作！");
			        		flat = true;
		        		}
		        	}else if(type == 8){
		        		if(lock ==1){
		        			//新增单据判断到仓库锁定时 无需提示
			        		flat = true;
		        		}
		        	}
					
		        },
		        error: function() {
		        	
		        }
		    });
		}
		return flat;
	}else{
		return flat;
	}
}

function checkisLockMultiWarehouse(warehouseids,islocked,type){
	var pv = $(parent.document).find("#productversion").val();
	var flat = false;
	if(pv != 3){
		
		$.ajax({
	        dataType: "json",
	        data: {warehouseids:warehouseids,
	        	islocked:islocked
	        		},
	        cache: false,
	        async: false,
	        url: "/UCenter-webapp/Warehouse/MultiWarehouseInfo.json?" + Math.random(),
	        type: "post",
	        success: function(o) {
	        		if(o.count > 0){
	        			if(type == 1){
							showErrorMsg("原单据中所选仓库正在盘点中，解锁后才能进行出入库类业务操作!");
							flat = true;
	        			}else if(type == 2){
	        				showErrorMsg("单据中所选仓库正在盘点中，解锁后才能进行出入库类业务操作!");
							flat = true;
	        			}
	        		}
	        },
	        error: function() {
	        }
	    });
		return flat;
	}else{
		return flat;
	}
}

function getuserwarehouse(){
	var userid = parent.$("#userid").val();//当前登录的用户
	var warehouseids="";
	$.ajax({
        dataType: "json",
        data: {userid:userid},
        cache: false,
        async: false,
        url: "/UCenter-webapp/Warehouse/getuserwarehouseinfo.json?" + Math.random(),
        type: "post",
        success: function(o) {
        		if(o.count > 0){
        			for(var i=0;i< o.count;i++){
        				warehouseids+=o.serviceResult[i].warehouseid+",";
        			}
        			warehouseids+=o.isAdmin;
        		}
        },
        error: function() {
        }
    });
	return warehouseids;
}

//免费版
function getwarehouseislocked(type){
	var userid = parent.$("#userid").val();//当前登录的用户
	var islocked = false;
	$.ajax({
        dataType: "json",
        data: {userid:userid},
        cache: false,
        async: false,
        url: "/UCenter-webapp/Warehouse/getuserwarehouseinfo.json?" + Math.random(),
        type: "post",
        success: function(o) {
        		if(o.count > 0){
        			if(o.serviceResult[0].islocked == 1){
        				if(type ==1){
        					islocked = true;
        				}else if(type == 2){
            				islocked = false;	
        				}else if(type == 3){
        					islocked = false;
        				}else{
        					showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
            				islocked = true;	
        				}
        			}else{
        				if(type == 2){
            				showErrorMsg("盘点前请锁定帐套，点击【盘点前锁定】可以锁定帐套。");
            				islocked = true;
        				}
        				if(type == 1){
        					islocked = false;	
        				}
        				if(type == 3){
        					islocked = true;
        				}
        			}
        		}
        },
        error: function() {
        }
    });
	return islocked;
}

//专业连锁版验证
function getwarehouseislockedTS(type){
	var userid = parent.$("#userid").val();//当前登录的用户
	var islocked = false;
	$.ajax({
        dataType: "json",
        data: {userid:userid},
        cache: false,
        async: false,
        url: "/UCenter-webapp/Warehouse/getuserwarehouseinfo.json?" + Math.random(),
        type: "post",
        success: function(o) {
        		if(o.count > 0){
        			if(o.count2>0){//有盘点中的仓库
        				islocked = true;	
        			}
        		}else{
        			//无仓库权限，判断账套状态
        			if(3==o.sobstate){
        				islocked = true;
        			}
        		}
        },
        error: function() {
        }
    });
	return islocked;
}
//获取是否存在 出于锁定中的仓库
function getWarehouseIsLockedBoolean(){
	var userid = parent.$("#userid").val();//当前登录的用户
	var islocked = false;
	$.ajax({
        dataType: "json",
        data: {userid:userid},
        cache: false,
        async: false,
        url: "/UCenter-webapp/Warehouse/getuserwarehouseinfo.json?" + Math.random(),
        type: "post",
        success: function(o) {
    		if(o.count > 0){
    			if(o.count2>0){//有盘点中的仓库
    				islocked = true;	
    			}
    		}
        },
        error: function() {
        }
    });
	return islocked;
}

function randomDateMin(){
	var minD="1900-01-01";
	//限制日期控件
	var date = $(parent.document).find("#lastbalanceenddate").val();
	if(date==null || date==""){//没有结存过
		return
	}
	
	var date2 =new Date(Date.parse(date.replace(/-/g,"/")));
	var nextMonth=new Date(date2.getFullYear(),date2.getMonth()+1);
	var mon = nextMonth.format("yyyy-MM-dd yyyy-MM-dd HH:mm:ss");//格式化上次结存的日期
		minD = mon;
	
	return minD;
}

//限制单据业务日期时间在结存时间之后
var mon;
function limiBalanceTimeToBill(id){
	var date = $(parent.document).find("#lastbalanceenddate").val();
	if(date==null || date==""){
		return;
	}
	
	if(window.location.href.indexOf("SaleOrder/List") >=0 
		|| 	window.location.href.indexOf("Sale/List") >=0 
		|| window.location.href.indexOf("SaleReturn/List") >=0 
		|| window.location.href.indexOf("BuyOrder/List") >=0 
		|| window.location.href.indexOf("Buy/List") >=0 
		|| window.location.href.indexOf("BuyReturn/List") >=0 
		|| window.location.href.indexOf("InvTak/List") >=0 
		|| window.location.href.indexOf("Assembly/List") >=0 
		|| window.location.href.indexOf("Transfer/List") >=0 
		|| window.location.href.indexOf("InStorage/List") >=0 
		|| window.location.href.indexOf("OutStorage/List") >=0 
		|| window.location.href.indexOf("Borrow/List") >=0 
		|| window.location.href.indexOf("Lend/List") >=0 
		|| window.location.href.indexOf("QueryProductSN/List") >=0 
		|| window.location.href.indexOf("IncomeAndPay/List") >=0 
		|| window.location.href.indexOf("WriteOff/List") >=0 
		|| window.location.href.indexOf("FundsFlow/Init") >=0 
		|| window.location.href.indexOf("ProfitReport/List") >=0 
	  ){
		var date2 =new Date(Date.parse(date.replace(/-/g,"/")));
		var nextMonth=new Date(date2.getFullYear(),date2.getMonth()+1);
		mon = nextMonth.format("yyyy-MM-dd");
		$("#"+id).focus(function(){
			WdatePicker({
				isShowOK:true,
				isShowToday:true,
				isShowClear:true,
				minDate:mon,
				dateFmt:'yyyy-MM-dd'
			});
		});
	}else{
		var date2 =new Date(Date.parse(date.replace(/-/g,"/")));
		var nextMonth=new Date(date2.getFullYear(),date2.getMonth()+1);
		mon = nextMonth.format("yyyy-MM-dd HH:mm:ss");
		$("#"+id).focus(function(){
			WdatePicker({
				isShowOK:true,
				isShowToday:true,
				isShowClear:true,
				minDate:mon,
				dateFmt:'yyyy-MM-dd HH:mm:ss'
			});
		});
	}
	
}
//验证当前帐套是否为老帐套
function checkCurrentSobP(){
	var isOldSob = true;
	$.YY_post('/UCenter-webapp/SysReset/checkSOB.json', {} , function(result,statu){
		if(false==result.isoldsob){
			isOldSob = false;
		}else{
			isOldSob = true;
		}
	}, null , null , null , false);
	return isOldSob;
}
 
//当结存失败提示过后，则更新数据不再提示“本次结存失败”
function updatebalIsView(balid){
	var param={};
	param['balid']=balid;
	param['isview']=0;
	$.post("/UCenter-webapp/SysReset/updatefailtip.json", param, function(result, resultState) {
		if (resultState == "success") {
			var tipmessage = result.failtip;
			$("#balname").text(balance[0].balname);
			$("#failtip").text(tipmessage);
			$("#main_cover").show();
			$("#balanceState6").show();
		}
	});
}


/**
 * 
 * 1234
 */
function initIElement(){
	var initElement=[];
	var elementIndex=0;
	$("li").each(function(){
		$(this).addClass('enterindex');
		
	});
	$("input[type='text']").each(function(){
		$(this).addClass('enterindex');
	});
	$("input[type='checkbox']").each(function(){
		$(this).addClass('enterindex');
	});
	$("div[name='multiwarehouse']").each(function(){
		$(this).addClass('enterindex');
	});
	$("#txbRemark").each(function(){
		$(this).addClass('enterindex');
	});
	$("#aaddrow").addClass('enterindex');
	
	$(".enterindex").each(function(){
		$(this).attr('focusindex',elementIndex);
		initElement.push({elementIndex:elementIndex,rowobj:$(this)});
		elementIndex++;
	});
	return initElement;
}
/*----------初始化销售进货调拨单快捷键START------------------*/
function focusupchainpayout(curobj,id1,id2){
	if(String(id1).indexOf(String(id2))>=0){
		var t = $(curobj).parent().find("li");
		var indext=Number($(curobj).attr("focusindex")); 
		var btip=false;
		for(var i=t.length-1;i>=0;i--){
			var ind = Number($(t[i]).attr("focusindex"));
			if(ind < indext){
				$(t[i]).focus();
				$(t[i]).select();
				btip =true;
				break;
			}
		}
		if(btip == false){
			$(t[t.length-1]).focus();
			$(t[t.length-1]).select();
		}
		return;
	}
}

function focusdownchainpayout(curobj,id1,id2){
	if(String(id1).indexOf(String(id2))>=0){
		var t = $(curobj).parent().find("li");
		var indext=Number($(curobj).attr("focusindex")); 
		var btip=false;
		for(var i=0;i<t.length;i++){
			var ind = Number($(t[i]).attr("focusindex"));
			if(ind > indext){
				$(t[i]).focus();
				$(t[i]).select();
				btip =true;
				break;
			}
		}
		if(btip == false){
			$(t[0]).mousemove();
			$(t[0]).focus();
			$(t[0]).select();
		}
		return;
	}

}

function uiliupchain(curobj,id1,id2,id3,id4,pv){
	if(String(id1).indexOf(String(id2))>=0){
		var lianWarehouse =  $(curobj).parent().parent().parent().parent().find("#"+id3).is(":visible");
		if(lianWarehouse == true){
			var t = $(curobj).parent().parent().find("#"+id4).find("li");
			var indext=Number($(curobj).attr("focusindex")); 
			var btip=false;
			for(var i=t.length-1;i>=0;i--){
				var ind = Number($(t[i]).attr("focusindex"));
				if(ind < indext){
					var idt = $(t[i]).attr("t");
					$(".secList").hide();
					if(pv!=null && pv !=undefined && pv !=""){
						$("#ls-li-children-"+pv+"warehouse-" + idt).show();
					}else{
						$("#ls-li-children-warehouse-" + idt).show();
					}
					$(t[i]).focus();
					$(t[i]).select();
					btip =true;
					break;
				}
			}
			if(btip == false){
				var idt = $(t[t.length-1]).attr("t");
				$(".secList").hide();
				if(pv!=null && pv !=undefined && pv !=""){
					$("#ls-li-children-"+pv+"warehouse-" + idt).show();
				}else{
					$("#ls-li-children-warehouse-" + idt).show();
				}
				$(t[t.length-1]).focus();
				$(t[t.length-1]).select();
			}
		}
	}
}

function uilidownchain(curobj,id1,id2,id3,id4,pv){
	if(String(id1).indexOf(String(id2))>=0){
		var lianWarehouse =  $(curobj).parent().parent().parent().parent().find("#"+id3).is(":visible");
		if(lianWarehouse == true){
			var t = $(curobj).parent().parent().find("#"+id4).find("li");
			var indext=Number($(curobj).attr("focusindex")); 
			var btip=false;
			for(var i=0;i<t.length;i++){
				var ind = Number($(t[i]).attr("focusindex"));
				if(ind > indext){
					var idt = $(t[i]).attr("t");
					$(".secList").hide();
					if(pv!=null && pv !=undefined && pv !=""){
						$("#ls-li-children-"+pv+"warehouse-" + idt).show();
					}else{
						$("#ls-li-children-warehouse-" + idt).show();
					}
					
					$(t[i]).focus();
					$(t[i]).select();
					btip =true;
					break;
				}
			}
			if(btip == false){
				var idt = $(t[0]).attr("t");
				$(".secList").hide();
				if(pv!=null && pv !=undefined && pv !=""){
					$("#ls-li-children-"+pv+"warehouse-" + idt).show();
				}else{
					$("#ls-li-children-warehouse-" + idt).show();
				}
				$(t[0]).focus();
				$(t[0]).select();
			}
		}
	}
}

function uiliup(curobj,id1,id2,id3){
	if(String(id1).indexOf(String(id2))>=0){
		//当焦点置于 单仓仓库上时
		var warehouseIsShow =$(curobj).parent().parent().parent().parent().find("#"+id3).is(":visible");
		if(warehouseIsShow == true){
			var t = $(curobj).parent().parent().parent().parent().find("#"+id3).find("ul li");
			var indext=Number($(curobj).attr("focusindex")); 
			var btip=false;
			for(var i=t.length-1;i>=0;i--){
				var ind = Number($(t[i]).attr("focusindex"));
				if(ind < indext){
					$(t[i]).focus();
					$(t[i]).select();
					btip =true;
					break;
				}
			}
			if(btip == false){
				$(t[t.length-1]).focus();
				$(t[t.length-1]).select();
			}
		}
	}
}

function uilidown(curobj,id1,id2,id3){
	if(String(id1).indexOf(String(id2))>=0){
		//当焦点置于 单仓仓库上时
		var warehouseIsShow =$(curobj).parent().parent().parent().parent().find("#"+id3).is(":visible");
		if(warehouseIsShow == true){
			var t = $(curobj).parent().parent().parent().parent().find("#"+id3).find("ul li");
			var indext=Number($(curobj).attr("focusindex")); 
			var btip=false;
			for(var i=0;i<t.length;i++){
				var ind = Number($(t[i]).attr("focusindex"));
				if(ind > indext){
					$(t[i]).focus();
					$(t[i]).select();
					btip =true;
					break;
				}
			}
			if(btip == false){
				$(t[0]).focus();
				$(t[0]).select();
			}
		}
	}
}

function initSaleDownUpElemnt(){
	var SaleDownElement=[];
	var elementIndex=0;
	$("div[name='multiwarehouse']").each(function(){
		$(this).attr('diventerindex',elementIndex);
		SaleDownElement.push({elementIndex:elementIndex,rowobj:$(this)});
		elementIndex++;
	});
	return SaleDownElement;
}
//多仓仓库下来列表 按下键的 方法
function focusMultiWarehouseDown(event){
	var multiwarehoudedown = initSaleDownUpElemnt();
	var curobj=event.target; 
	var curname=$(curobj).attr("name");//multiwarehouse
	var isfirst = false;
	var enterindex=Number($(curobj).attr("diventerindex"));
	$.each(multiwarehoudedown,function(index,value){
		var name=$(value.rowobj).attr("name");
		if(value.elementIndex>enterindex && curname == "txbWarehouse" && name=="multiwarehouse"){
			var readonly=$(value.rowobj).attr("readonly");
			var disabled=$(value.rowobj).attr("disabled");
			var ishidden=$(value.rowobj).is(":hidden");
			if(!isfirst && name=="multiwarehouse" && readonly==undefined && disabled==undefined && ishidden==false){
				$(value.rowobj).focus();
				$(value.rowobj).select(); 
				$(value.rowobj).prev().removeClass("shortcut-01");
				$(value.rowobj).addClass("shortcut-01");
				$(value.rowobj).next().removeClass("shortcut-01");
				isfirst=true;
			}
		}
	});
}
/*----------初始化销售单快捷键END------------------*/


function resetfocus(obj){
	var activefocusIndex = $("#activefocus").val();
	var initElement = initIElement();
	$.each(initElement,function(index,value){
		if(value.elementIndex == activefocusIndex){
			var name=$(value.rowobj).attr("name");
			var id = $(value.rowobj).attr("id");
			$(value.rowobj).focus();
			$(value.rowobj).select();
		}
	});
}

/**
 * 检查连锁版单据客户名称是否重复
 * 客户A存在门店1下，且此时客户A不共享，门店2新增销售时，输入框内输入该客户A
 * 应标红输入框，并提示“该客户与其他门店客户重复，请修改”
 * @param isSync 是否异步
 */
function checkChainBillClientRepeat(isSync){
	//定义方法
	var repeatFunc = function(isSync){
		if(undefined==isSync || null== isSync)
			isSync = false;
		
		if("1"==$("#txbCr").attr("clientname_repeat"))
			$("#txbCr").addClass("ls-error");
		
		if("2"!=$("#productversion", parent.document).val()){
			return true;
		}
		
		var clientname = $("#txbCr").val();
		var clientid = $("#crvalue").val();
		var branchid = $("#choose-warehouse-parentval").val();
		
		if(	 window.location.href.indexOf("SaleOrder/CopyAdd.htm") <0
				&& window.location.href.indexOf("Sale/CopyAdd.htm") <0
				&& window.location.href.indexOf("SaleReturn/CopyAdd.htm") <0
				&& window.location.href.indexOf("SaleOrder/EditInit.htm?isOnlineOrder=1") <0
				&& window.location.href.indexOf("Sale/Add.htm") <0 
		){
			if(""!=clientid){
				$("#txbCr").removeAttr("clientname_repeat");
				$("#txbCr").removeClass("ls-error");
				return true;
			}
		}
		
		var path = false;//需要是同步的
		$.YY_post('/UCenter-webapp/ClientInfo/isExist.json', {
			"clientname" : clientname
		} , function(result,statu){
			if(null!=result.error && branchid!=result.branchid && "1"!=result.isshared){
				$("#txbCr").addClass("ls-error");
				$("#txbCr").attr("clientname_repeat", 1);
				$("#txbCr").focus(function(){
					if($(this).hasClass("ls-error"))
						$(this).removeClass("ls-error");
				});
				showErrorMsg("该客户与其他门店客户重复，请修改");
				path = false;
			}else{
				$("#txbCr").removeClass("ls-error");
				$("#txbCr").removeAttr("clientname_repeat");
				path = true;
			}
		}, null , null , null , isSync);
		
		return path;
	};
	
	//判断是否是：选择智能匹配导致客户输入框失去焦点
	var isAutoCompleteFocus = $("#clientauto").find(".autoCompleteBox:visible").length>0
		&& $("#clientauto").find(".autoCompleteBox:visible").is(":hover");
	
	//如果不是，直接执行方法
	if(!isAutoCompleteFocus){
		return repeatFunc(isSync);
	}else{
		//如果是选择智能匹配，则延时执行，保证已经选择了客户
		setTimeout(function(){
			repeatFunc(isSync);
		},200)
	}
	
}

/**
 * 绑定网店订单详细的提示
 */
function bindShowOrHideShopOrderDetailTip(){
	$(".showShopOrderPathTipElement").bind("mouseover",function(){
		$("#shopOrderPathTip").show();
	});
	$(".showShopOrderPathTipElement").bind("mouseout",function(){
		$("#shopOrderPathTip").hide();
	});
}


function initNearTranUnit(datajson){
	var productids="";
	for (var i = 0; i < datajson.length; i++) {
		if(null != datajson[i].cpProductUnitSBs && datajson[i].cpProductUnitSBs != "undefined" && datajson[i].cpProductUnitSBs.length>1){
			productids = datajson[i].productid;
			break;
		}
	}
	if(productids.length > 0){
		$.ajax({
	        dataType: "json",
	        data: {productid:productids},
	        cache: false,
	        async: false,
	        url: "/UCenter-webapp/Transfer/getNearProductTranUnit.json?" + Math.random(),
	        type: "post",
	        success: function(o) {
	        	if(jQuery.isEmptyObject(o) == false){
	        		if(o.isSuccess == 1){
	        			var nearUnitInfo = o.serviceResult;
	        			var nearUnitId = o.productUnitId;
	        			var nearUnitName = nearUnitInfo.productunitname;
	        			//最近单位列表有值时，则进行下一步匹配
	        			for (var i = 0; i < datajson.length; i++) {
	        				if(null != datajson[i].cpProductUnitSBs && datajson[i].cpProductUnitSBs != "undefined" && datajson[i].cpProductUnitSBs.length>1){
	        					//多单位商品进入此处
	        					var product1 = String(datajson[i].productid).toUpperCase();
	        					var product2 = String(nearUnitInfo.productid).toUpperCase();
	        					if(product1 == product2){
	        						datajson[i]["nearunitid"]=nearUnitId;//单位ID
        							datajson[i]["nearunitname"] = nearUnitName;//单位名称
        							for(var j = 0; j < datajson[i].cpProductUnitSBs.length; j++){
        								var unitid = datajson[i].cpProductUnitSBs[j].unitid;
        								if( String(nearUnitId).toUpperCase() == String(unitid).toUpperCase()){
        									datajson[i]["nearunitisdecimal"] = datajson[i].cpProductUnitSBs[j].isdecimal;//单位是否允许小数
        									datajson[i]["nearunitunitratio"] = datajson[i].cpProductUnitSBs[j].unitratio;//单位换算比率
        									datajson[i]["nearunitismainunit"] = datajson[i].cpProductUnitSBs[j].ismainunit;//是否是主单位
        									break;
        								}
        								
        							}
        							datajson[i]["isHaveNear"] = 1;
        							break;
	        					}
	        				}
	        			}
	        		}
	        	}
	        },
	        error: function() {
	        }
	    });
	}
	
	return datajson;
}

function clickprice(obj){
	$(obj).find("a[name='aprice']").click();
}

function clickprice1(obj){
	$(".FSvalue").hide();
	$(obj).parent().find("a[name='aprice']").click();
}

function hidepeice(obj){
	$(obj).find("ul[name='ulpriceli']").hide();
}

function disclickprice(obj){
	$(obj).find("a[name='Disaprice']").click();
}

function disclickprice1(obj){
	$(".FSvalue").hide();
	$(obj).parent().find("a[name='Disaprice']").click();
}

function dishidepeice(obj){
	$(obj).find("ul[name='Disulpriceli']").hide();
}

/** 
 * 抹零方式 
 * 
 * 0:不抹零  1：抹掉零头“分”  2：抹掉零头“角”   3：四舍五入到“角”  4：四舍五入到“元”
 */  
function roundWay(totalAmt,roundWay){  
    var scal = 1; //精确小数位  
    var accuracy = Math.pow(10,scal);  
    var newTotalAmt=totalAmt;
    switch (roundWay) {  
    case '1':  
    	newTotalAmt=Math.floor(totalAmt*accuracy)/accuracy; 
        break; 
    case '2':  
    	newTotalAmt=Math.floor(totalAmt);  
        break; 
    case '3':  
    	newTotalAmt=Math.round(totalAmt*accuracy)/accuracy;  
        break; 
    case '4':  
    	newTotalAmt=Math.round(totalAmt);  
        break;  
    default:
    	return totalAmt;
    	break;
    }  
    return totalAmt-newTotalAmt;
}  
//添加行样式
function addAutoMaxHeightOverflowy(obj){
	var rows = 	Number(document.getElementById("tabdetail").rows.length) - 2;//总行数 去除首尾两行
	var rowindex = $(obj).parents("tr:first").find("span[class='num']").text();//当前行号
	if(isNaN(rowindex)){
		return;
	}else{
		rowindex = Number(rowindex);
	}
	if((rows - rowindex) == 0){//最后一行
		$(obj).parent().find("ul[name='Disulpriceli']").css("max-height","40px");
		$(obj).parent().find("ul[name='Disulpriceli']").css("overflow-y","auto");
	}else
	if((rows - rowindex) == 1){//倒数第二行
		$(obj).parent().find("ul[name='Disulpriceli']").css("max-height","82px");
		$(obj).parent().find("ul[name='Disulpriceli']").css("overflow-y","auto");
	}else{
		$(obj).parent().find("ul[name='Disulpriceli']").css("max-height","");
		$(obj).parent().find("ul[name='Disulpriceli']").css("overflow-y","");
	}
}
//去除行样式
function removeAutoMaxHeightOverflowy(obj){
	$(obj).parent().css("max-height","");
	$(obj).parent().css("overflow-y","");
}
/**
 * 前台打印
 * @param saleid 
 * @param isOpenSaleDetailDiscount 是否开启单行折扣
 * @param oddProcess 是否开启抹零
 */
function printPos(saleid,isOpenSaleDetailDiscount,oddProcess){
	var tempcode = setPrintTemplateList(29);
	var printTempCode="07";
	if (tempcode == "all") {
	} else {
		tempcodeArr = tempcode.split(",");
		if (tempcodeArr.length >= 1) {
			printTempCode=tempcodeArr[0];
		}
	}
	var isOpenSaleDetailDiscountStr="";
	var oddProcessStr="";
	if(isOpenSaleDetailDiscount!=undefined && isOpenSaleDetailDiscount=="1"){
		isOpenSaleDetailDiscountStr="_D";
	}
	if(oddProcess!=undefined && oddProcess=="1"){
		oddProcessStr="_M";
	}
	var printtempname = "";
	if(tempcodeArr=="06"){
		printtempname = "SellDetail58"+isOpenSaleDetailDiscountStr+oddProcessStr+".grf";
	}else if(tempcodeArr=="07"){
		printtempname = "SellDetail80"+isOpenSaleDetailDiscountStr+oddProcessStr+".grf";
	}
	signPrint('Sell',printTempCode,printtempname,null);
}
/**
 * 将所有单位是否允许小数 缓存到全局变量中，调用时需要在全局定义一个 unitSettingMap 的全局变量；
 */
function getUnitSettingMap(){
	$.ajax({
        dataType: "json",
        data: {
        },
        cache: false,
        async: false,
        url: "/UCenter-webapp/UnitSetting/getCPUnittingByContactIdAndSOBId.htm?" + Math.random(),
        type: "post",
        success: function(o) {
            for(var i=0;i<o.length;i++){
            	unitSettingMap[o[i].unitid.toLowerCase()]=o[i].isdecimal;
            }
        },
        error: function() {
            showMsg("获取单位缓存失败");
        }
    });
}

//选择客户后 重新加载经手人公共
/**
 * salesmanname 关联业务员名称</br>
 * salesmanuserid 关联业务员id</br>
 * salesmanusertype 关联业务员id 1-导购员</br>
 * salesmanisdel 关联业务员是否删除 1-删除</br>
 * salesmanuserstatus 关联业务员状态 1-锁定</br>
 * isHaveSales 是否允许导购员作为经手人 0-不允许 1-允许</br>
 * urlchang 忽略查看单据权限 1-忽略 不为1 则不忽略</br>
 * 
 */
function reloadHandMan(salesmanname,salesmanuserid,salesmanusertype,salesmanisdel,salesmanuserstatus,isHaveSales,urlchang,branchid){
	var selectClientRelationIsNull = $("#selectClientRelationIsNull").val();
	var isopenmultiplewarehouse = $(parent.document).find("#hidisopenmultiplewarehouse").val();
	var url = window.location.href;
	if(isHaveSales == "0"){
		if(salesmanuserid != undefined && salesmanuserid != null && salesmanuserid != ""){
			if(salesmanusertype == "1"){
				//导购员
				$("#hidDefaultItem").val("");
				levelSelect.init('/UCenter-webapp/commondata/getuser.json', 'user',0);
				if(salesmanisdel != "1" && salesmanuserstatus != "1"){
					$("#choose-user-val").val("");
					$("#hidDefaultItem").val("");
					$("#salesmanuserid").val("");
					$("#salesmanusername").val("");
					$("#salesmanisdel").val("");
					$("#salesmanuserstatus").val("");
					$("#salesmanusertype").val("");
					$("#levelSelect-user .ls-input").val("");
					$("#levelSelect-user .ls-input").addClass("InputBdRed");
					showErrorMsg("该客户关联的业务员不可作为本单经手人");
				}
			}else if(salesmanusertype == "0"){
				if(salesmanisdel == "1" || salesmanuserstatus == "1"){
					$("#hidDefaultItem").val("");
					$("#levelSelect-user .ls-input").removeClass("InputBdRed");
					levelSelect.init('/UCenter-webapp/commondata/getuser.json', 'user',0);
				}else{
					$("#hidDefaultItem").val(salesmanuserid);
					$("#levelSelect-user .ls-input").removeClass("InputBdRed");
					levelSelect.init('/UCenter-webapp/commondata/getuser.json?branchid='+branchid+'&salesmanuserid='+salesmanuserid+"&salesmanisdel="+salesmanisdel+"&salesmanuserstatus="+salesmanuserstatus, 'user',0);
					//获取当前业务员的仓库权限
					if( isAdmin != "true" && $("#choose-warehouse-val").val() != undefined && $("#choose-warehouse-val").val() != null && $("#choose-warehouse-val").val() != ""){
						getSalesmanRelationWarehouse(salesmanuserid,salesmanname);
					}
				}
			}
		}else{
			$("#hidDefaultItem").val("");
			$("#levelSelect-user .ls-input").removeClass("InputBdRed");
			levelSelect.init('/UCenter-webapp/commondata/getuser.json', 'user',0);
		}
	}else if(isHaveSales == "1"){
		if(salesmanuserid != undefined && salesmanuserid != null && salesmanuserid != "null" && salesmanuserid != ""){
			//判断客户关联的 业务员 是否被删除或者锁定
			if(salesmanisdel == "1" || salesmanuserstatus == "1"){
				if(urlchang == "1"){
					if(url.indexOf("Lend/TurnSale.htm") >= 0){
						var hidDefaultValue = $("#hidDefaultValue").val();
						if(hidDefaultValue == undefined ){
							hidDefaultValue = "";
						}
						levelSelect.init('commondata/getuser.json?isaddbill=1&branchid='+ $("#hidbranchid").val()+ '&warehouseid=' + $("#hielendwarehouseid").val(), 'user');
					}else{
						if(isopenmultiplewarehouse == "1"){
							var warehouseids=getChooseWarehouseIds();
							var userUrl = "/UCenter-webapp/commondata/getuser.json?isaddbill=1&warehouseids="+warehouseids;
							//销售订单模块
							var noWarehouseTab = 1;
							if("AddSaleOrder"==$("#busitype").val() || "saleorder"==$("#pagebusinessname").val()){
								var warehouseidarr = [];
								if(null!=warehouseids){
									warehouseidarr = warehouseids.split(",");
								}
								var hasNoYd = false;//是否有不是预订的仓库
								for(var i in warehouseidarr){
									if(""!=warehouseidarr[i]){
										hasNoYd = true;
										break;
									}
								}
								if(!hasNoYd){
									userUrl = userUrl+'&nowarehouse=1';//如果全部是预定仓库的话，则不需要过滤仓库权限
									noWarehouseTab =0;
								}
							}
							levelSelect.init(userUrl, 'user',0);
						}else{
							levelSelect.init('/UCenter-webapp/commondata/getuser.json?branchid='+branchid+'&isaddbill=1&warehouseid=' + $("#choose-warehouse-val").val(), 'user',0);
						}
					}
					//在选中刚才选中的人
					var thechooseuser = $("#thechooseuser").val();
					if(thechooseuser != undefined && thechooseuser != ""){
						thechooseuser = String(thechooseuser).toUpperCase();
					}
					$("#ls-li-user-"+thechooseuser).click();
				}else{
					levelSelect.init('/UCenter-webapp/commondata/getuser.json', 'user',0);
				}
				$("#hidDefaultItem").val("");
				$("#salesmanuserid").val("");
				$("#salesmanusername").val("");
				$("#salesmanisdel").val("");
				$("#salesmanuserstatus").val("");
				$("#salesmanusertype").val("");
				$("#levelSelect-user .ls-input").removeClass("InputBdRed");
			}else{
				$("#hidDefaultItem").val(salesmanuserid);
				$("#levelSelect-user .ls-input").removeClass("InputBdRed");
				if(urlchang == "1"){
					var userUrl = '/UCenter-webapp/commondata/getuser.json?branchid='+branchid+'&isaddbill=1&salesmanuserid='+salesmanuserid+"&salesmanisdel="+salesmanisdel+"&salesmanuserstatus="+salesmanuserstatus;
					if(isopenmultiplewarehouse == "1"){
						var warehouseids=getChooseWarehouseIds();
						//销售订单模块
						var noWarehouseTab = 1;
						if("AddSaleOrder"==$("#busitype").val() || "saleorder"==$("#pagebusinessname").val()){
							var warehouseidarr = [];
							if(null!=warehouseids){
								warehouseidarr = warehouseids.split(",");
							}
							var hasNoYd = false;//是否有不是预订的仓库
							for(var i in warehouseidarr){
								if(""!=warehouseidarr[i]){
									hasNoYd = true;
									break;
								}
							}
							if(!hasNoYd){
								userUrl = userUrl+'&nowarehouse=1';//如果全部是预定仓库的话，则不需要过滤仓库权限
								noWarehouseTab =0;
							}
						}
					}
					levelSelect.init(userUrl, 'user',0);
				}else{
					levelSelect.init('/UCenter-webapp/commondata/getuser.json?branchid='+branchid+'&salesmanuserid='+salesmanuserid+"&salesmanisdel="+salesmanisdel+"&salesmanuserstatus="+salesmanuserstatus, 'user',0);
				}
				//(客户存在关联业务员的时候)经手人加载完毕后 改变thechooseuser的值
				$("#thechooseuser").val($("#choose-user-val").val());
				//员工查询仓库权限
				if(salesmanusertype == "0"){
					if(url.indexOf("Lend/TurnSale.htm") >= 0){
						getSalesmanRelationWarehouse(salesmanuserid,salesmanname);
					}else{
						var isopenmultiwarehouse = $(parent.document).find("#hidisopenmultiplewarehouse").val();
						if(isopenmultiwarehouse == "1"){
							var warehouseids=getChooseWarehouseIds();
							//销售订单模块
							var noWarehouseTab = 1;
							if("AddSaleOrder"==$("#busitype").val() || "saleorder"==$("#pagebusinessname").val()){
								var warehouseidarr = [];
								if(null!=warehouseids){
									warehouseidarr = warehouseids.split(",");
								}
								var hasNoYd = false;//是否有不是预订的仓库
								for(var i in warehouseidarr){
									if(""!=warehouseidarr[i]){
										hasNoYd = true;
										break;
									}
								}
								if(!hasNoYd){
									//如果全部是预定仓库的话，则不需要过滤仓库权限
									noWarehouseTab =0;
								}
							}
							//noWarehouseTab = 1 需要判断仓库权限，0-不需要判断仓库权限
							if(noWarehouseTab == 1){
								//仓库id，warehouseids
								getSalesmanRelationWarehouse(salesmanuserid,salesmanname,warehouseids);
							}
						}else{
							if($("#choose-warehouse-val").val() != undefined && $("#choose-warehouse-val").val() != null && $("#choose-warehouse-val").val() != ""){
								getSalesmanRelationWarehouse(salesmanuserid,salesmanname);
							}
						}
					}
				}
			}
		}else{
		/*	$("#salesmanuserid").val("");
			$("#salesmanusername").val("");
			$("#salesmanisdel").val("");
			$("#salesmanuserstatus").val("");
			$("#salesmanusertype").val("");*/
			$("#levelSelect-user .ls-input").removeClass("InputBdRed");
			if(urlchang == "1"){
				if(url.indexOf("Lend/TurnSale.htm") >= 0){
					var hidDefaultValue = $("#hidDefaultValue").val();
					if(hidDefaultValue == undefined ){
						hidDefaultValue = "";
					}
					levelSelect.init('commondata/getuser.json?isaddbill=1&defaultvalue='+hidDefaultValue+'&branchid='+ $("#hidbranchid").val()+ '&warehouseid=' + $("#hielendwarehouseid").val(), 'user');
				}else{
					if(isopenmultiplewarehouse == "1"){
						var warehouseids=getChooseWarehouseIds();
						var userUrl = "/UCenter-webapp/commondata/getuser.json?isaddbill=1&warehouseids="+warehouseids;
						//销售订单模块
						var noWarehouseTab = 1;
						if("AddSaleOrder"==$("#busitype").val() || "saleorder"==$("#pagebusinessname").val()){
							var warehouseidarr = [];
							if(null!=warehouseids){
								warehouseidarr = warehouseids.split(",");
							}
							var hasNoYd = false;//是否有不是预订的仓库
							for(var i in warehouseidarr){
								if(""!=warehouseidarr[i]){
									hasNoYd = true;
									break;
								}
							}
							if(!hasNoYd){
								userUrl = userUrl+'&nowarehouse=1';//如果全部是预定仓库的话，则不需要过滤仓库权限
								noWarehouseTab =0;
							}
						}
						levelSelect.init(userUrl, 'user',0);
					}else{
						levelSelect.init('/UCenter-webapp/commondata/getuser.json?branchid='+branchid+'&isaddbill=1&warehouseid=' + $("#choose-warehouse-val").val(), 'user',0);
					}
				}
				//在选中刚才选中的人
				var thechooseuser = $("#thechooseuser").val();
				if(thechooseuser != undefined && thechooseuser != ""){
					thechooseuser = String(thechooseuser).toUpperCase();
				}
				$("#ls-li-user-"+thechooseuser).click();
			}else{
				levelSelect.init('/UCenter-webapp/commondata/getuser.json', 'user',0);
			}
			//在选中刚才选中的人
			var thechooseuser = $("#thechooseuser").val();
			if(thechooseuser != undefined && thechooseuser != ""){
				thechooseuser = String(thechooseuser).toUpperCase();
			}
			$("#ls-li-user-"+thechooseuser).click();
		}
	}
}

function getSalesmanRelationWarehouse(userid,username,warehouseids){
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	var text = "<div class='SalesPopTips' style='top: 6px;'><p class='font14 font333'>"
			+"该客户关联的业务员【"+username+"】无当前出库仓库权限，请做以下检查：</p>"
			+"<p class='mt15 font12 font999'>1、仓库或客户是否选择正确；</p>"
			+"<p class='font12 font999'>2、该业务员是否具备当前选择的出库仓库权限</p>"
			+"<p class='mt15'><a href='javascript:;'  title='员工管理' basepath='/UCenter-webapp/' url='SysUser/List.htm' onclick='addnewPage(this)' >" 
			+"去检查</a></p></div>";
	if(isAdmin != "true"){
		text = "<div class='SalesPopTips' style='top: 6px;'><p class='font14 font333'>"
			+"该客户关联的业务员【"+username+"】无当前出库仓库权限，请做以下检查：</p>"
			+"<p class='mt15 font12 font999'>1、仓库或客户是否选择正确；</p>"
			+"<p class='font12 font999'>2、该业务员是否具备当前选择的出库仓库权限</p>"
			+"<p class='mt15'></p></div>";
	}
	
	var urllocation = window.location.href;
	var url = "/UCenter-webapp/Warehouse/getUserWarehouse.json";
	var param = {};
	param["userid"] = userid;
	/*$.ajaxSetup({
		async:false
	});*/
	$.post(url,param,function(r,s){
		if(s == "success"){
			var isHaveWarehouse = r.isHaveWarehouse;
			if(isHaveWarehouse == 0){
				//当前客户关联的业务员 ，没有任何仓库权限
				$("#levelSelect-user .ls-input").val("");//清空经手人名称
				$("#levelSelect-user .ls-input-val").val("");//清空经手人ID
				$("#levelSelect-user .ls-input").addClass("InputBdRed");
				$("#levelSelect-user-list div:first").remove("div");
				$("#levelSelect-user-list").append(text);
				showErrorMsg("该客户关联的业务员不可作为本单经手人");
			}else if(isHaveWarehouse == 1){
				//当前客户关联的业务员 有仓库权限
				var warehouselist = r.warehouselist;
				var isopenmultiwarehouse = $(parent.document).find("#hidisopenmultiplewarehouse").val();
				if(isopenmultiwarehouse == "1" && urllocation.indexOf("Lend/TurnSale.htm") < 0){
					if(warehouseids != undefined && warehouseids != null && warehouseids != ""){
						var warehouseidStr = String(r.warehouseidStr).toUpperCase();//当前关联业务员 所有拥有的仓库
						warehouseids = String(warehouseids).toUpperCase();//当前单据中 所选择的仓库
						var wArray = warehouseids.split(",");
						var haveNoPermflag = false;
						for(var i=0; i<wArray.length ; i++){
							if(wArray[i].length > 0 && warehouseidStr.indexOf(wArray[i]) < 0){
								haveNoPermflag = true;
								break;
							}
						}
						//当前列表中存在仓库 是 这个关联业务员 没有权限的仓库
						if(haveNoPermflag){
							//当前客户关联的业务员 ，没有任何仓库权限
							$("#levelSelect-user .ls-input").val("");//清空经手人名称
							$("#levelSelect-user .ls-input-val").val("");//清空经手人ID
							$("#levelSelect-user .ls-input").addClass("InputBdRed");//添加标红样式
							$("#levelSelect-user-list div:first").remove("div");//移除经手人下拉列表
							$("#levelSelect-user-list").append(text);
							showErrorMsg("该客户关联的业务员不可作为本单经手人");
						}
					}
				}else{
					var choosewarehouseid = $("#choose-warehouse-val").val();
					if(urllocation.indexOf("Lend/TurnSale.htm") >= 0){
						choosewarehouseid = $("#hielendwarehouseid").val();
					}
					var warehouseFlag = false;
					for(var i=0; i<warehouselist.length;i++){
						var id = warehouselist[i].warehouseid;
						if( String(id).toUpperCase() == String(choosewarehouseid).toUpperCase() ){
							warehouseFlag = true; 
							break;
						}
					}
					if(!warehouseFlag){
						//当前客户关联的业务员 ，没有任何仓库权限
						$("#levelSelect-user .ls-input").val("");//清空经手人名称
						$("#levelSelect-user .ls-input-val").val("");//清空经手人ID
						$("#levelSelect-user .ls-input").addClass("InputBdRed");
						$("#levelSelect-user-list div:first").remove("div");
						$("#levelSelect-user-list").append(text);
						showErrorMsg("该客户关联的业务员不可作为本单经手人");
					}
				}
			}
		}
	});
}
function getNearBuyUnitId(productid,billtype){
	var branchid=$("#choose-warehouse-parentval").val(); 
	if(branchid==undefined){
		branchid=parent.$(".main:visible").find("#iframe")[0].contentWindow.$("#choose-warehouse-parentval").val(); 
	}
	var unitid="";
	var requrl = "/UCenter-webapp/Buy/getNearBuyPrice.json";
	 $.ajax({
	      dataType: "json",
	      data: {
	    	  productid: productid,
	          productunit: "",
	          clientid: "",
	          clientname:"",
	          branchid:branchid
	      },
	      url: requrl,
	      cache: false,
	      type: "post",
	      async: false,
	      success: function (data) {
	    	  if(data!=null&&data.unitid!=null&&data.unitid!=''){
	    		  unitid=data.unitid;
	    	  }
	      },
	      error: function () {
	          
	      }
	  }); 
	 
	 return unitid;
}
//打开新页面
function addnewPage(obj){
	parent.addTab(obj);
}
function noLockChoose(){
	//todo
}


/*明细页面点击打印按钮触发事件*/
var detailPrint1 = null;
function openPrintWindowElse(busiid,temptype,busitype){
	//防止两次点击
	if (detailPrint1 == null) {
		detailPrint1 = new Date().getTime();
	} else {
		var detailPrint2 = new Date().getTime();
		if (detailPrint2 - detailPrint1 < 1000) {
			detailPrint1 = detailPrint2;
			return;
		} else {
			detailPrint1 = detailPrint2;
		}
	}
	var tempcode = setPrintTemplateList(temptype);
	var isMulti=$("#hidisopenmultiwarehouse").val();
	var isOpenSaleDetailDiscount = $("#isOpenSaleDetailDiscount").val();
	var isOpenSaleDetailDiscountStr="";
	var oddProcess = $("#oddProcess").val();
	var oddProcessStr="";
	if(isOpenSaleDetailDiscount!=undefined && isOpenSaleDetailDiscount=="1"){
		isOpenSaleDetailDiscountStr="_D";
	}
	if(oddProcess!=undefined && oddProcess!="0"){
		oddProcessStr="_M";
	}
	switch(busitype){
	case "SaleReturn":
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/SaleReturn/Print.htm?returnid='+busiid+'&ismultiwarehouse='+isMulti,830,225,'100102');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "SaleReturnDetail_A4.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "SaleReturnDetail_A4.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "SaleReturnDetail.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "SaleReturnDetail140.grf";
				}
				signPrint2('SaleReturn',tempcodeArr,printtempname,busiid,"/UCenter-webapp/SaleReturn/PrintSaleReturnDetail.htm?ReturnId=");
			}else{
				OpenPrint('/UCenter-webapp/SaleReturn/Print.htm?returnid='+busiid+'&ismultiwarehouse='+isMulti,830,225,'100102');
			}
		}
		break;
	case "Buy":
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/Buy/Print.htm?buyid='+busiid,810,222,'100201');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "BuyDetail"+isOpenSaleDetailDiscountStr+oddProcessStr+".grf";
				}else if(tempcodeArr=="01"){
					printtempname = "BuyDetail"+isOpenSaleDetailDiscountStr+oddProcessStr+".grf";
				}else if(tempcodeArr=="02"){
					printtempname = "BuyDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "BuyDetail140.grf";
				}else if(tempcodeArr=="04"){
					printtempname = "BuyDetail190.grf";
				}
				signPrint2('Buy',tempcodeArr,printtempname,busiid,"/UCenter-webapp/Buy/PrintBuyDetail.htm?BuyId=");
			}else{
				OpenPrint('/UCenter-webapp/Buy/Print.htm?buyid='+busiid,810,222,'100201');
			}
		}
		break;
	case "BuyOrder"://101
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/BuyOrder/Print.htm?buyid='+busiid,810,224,'100200');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "BuyOrderDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "BuyOrderDetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "BuyOrderDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "BuyOrderDetail140.grf";
				}else if(tempcodeArr=="04"){
					printtempname = "BuyOrderDetail190.grf";
				}
				signPrint2('BuyOrder',tempcodeArr,printtempname,busiid,"/UCenter-webapp/BuyOrder/PrintBuyDetail.htm?BuyId=");
			}else{
				OpenPrint('/UCenter-webapp/BuyOrder/Print.htm?buyid='+busiid,810,224,'100200');
			}
		}
		break;
	case "BuyReturn"://2
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/BuyReturn/Print.htm?returnid='+busiid,810,224,'100202');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "BuyReturnDetail_A4.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "BuyReturnDetail_A4.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "BuyReturnDetail.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "BuyReturnDetail140.grf";
				}
				signPrint2('BuyReturn',tempcodeArr,printtempname,busiid,"/UCenter-webapp/BuyReturn/PrintBuyReturnDetail.htm?ReturnId=");
			}else{
				OpenPrint('/UCenter-webapp/BuyReturn/Print.htm?returnid='+busiid,810,224,'100202');
			}
		}
		break;
	case "Transfer"://2
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/Transfer/Print.htm?tranid='+busiid,810,224,'100302');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "TransferDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "TransferDetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "TransferDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "TransferDetail140.grf";
				}
				signPrint2('Transfer',tempcodeArr,printtempname,busiid,"/UCenter-webapp/Transfer/PrintTransferDetail.htm?tranid=");
			}else{
				OpenPrint('/UCenter-webapp/Transfer/Print.htm?tranid='+busiid,810,224,'100302');
			}
		}
		break;
	case "Borrow"://8
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/Borrow/Print.htm?lendid='+busiid,825,223,'100303');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "LendDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "LendDetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "LendDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "LendDetail140.grf";
				}
				signPrint2('Borrow',tempcodeArr,printtempname,busiid,"/UCenter-webapp/Borrow/PrintBorrowDetail.htm?LendId=");
			}else{
				OpenPrint('/UCenter-webapp/Borrow/Print.htm?lendid='+busiid,825,223,'100303');
			}
		}
		break;
	case "Lend"://9
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/Lend/Print.htm?lendid='+busiid,810,220,'100304');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "LendDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "LendDetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "LendDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "LendDetail140.grf";
				}
				signPrint2('Lend',tempcodeArr,printtempname,busiid,"/UCenter-webapp/Lend/PrintLendDetail.htm?LendId=");
			}else{
				OpenPrint('/UCenter-webapp/Lend/Print.htm?lendid='+busiid,810,220,'100304');
			}
		}
		break;
	case "LendReturn"://11
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/LendReturn/Print.htm?returnid=' + busiid + "&lendtype=" + $("#hidlendtype").val(),810,220,'100304');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "LendReturnDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "LendReturnDetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "LendReturnDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "LendReturnDetail140.grf";
				}
				signPrint2('LendReturnOut',tempcodeArr,printtempname,busiid,"/UCenter-webapp/LendReturn/PrintLendReturnDetail.htm?ReturnId=");
			}else{
				OpenPrint('/UCenter-webapp/LendReturn/Print.htm?returnid=' + busiid + "&lendtype=" + $("#hidlendtype").val(),810,220,'100304');
			}
		}
		break;
	case "BorrowReturn"://10
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/LendReturn/Print.htm?returnid=' + busiid + "&lendtype=" + $("#hidlendtype").val(),810,220,'100303');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "LendReturnDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "LendReturnDetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "LendReturnDetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "LendReturnDetail140.grf";
				}
				signPrint2('LendReturn',tempcodeArr,printtempname,busiid,"/UCenter-webapp/LendReturn/PrintLendReturnDetail.htm?ReturnId=");
			}else{
				OpenPrint('/UCenter-webapp/LendReturn/Print.htm?returnid=' + busiid + "&lendtype=" + $("#hidlendtype").val(),810,220,'100303');
			}
		}
		break;
	case "InStorage"://21
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/InStorage/Print.htm?ioid='+busiid,810,220,'100308');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "InIODetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "InIODetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "InIODetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "InIODetail140.grf";
				}
				signPrint2('InStorage',tempcodeArr,printtempname,busiid,"/UCenter-webapp/InStorage/PrintDetail.htm?ioid=");
			}else{
				OpenPrint('/UCenter-webapp/InStorage/Print.htm?ioid='+busiid,810,220,'100308');
			}
		}
		break;
	case "OutStorage"://21
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/OutStorage/Print.htm?ioid='+busiid,810,220,'100307');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "OutIODetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "OutIODetail.grf";
				}else if(tempcodeArr=="02"){
					printtempname = "OutIODetail93.grf";
				}else if(tempcodeArr=="03"){
					printtempname = "OutIODetail140.grf";
				}
				signPrint2('OutStorage',tempcodeArr,printtempname,busiid,"/UCenter-webapp/OutStorage/PrintDetail.htm?ioid=");
			}else{
				OpenPrint('/UCenter-webapp/OutStorage/Print.htm?ioid='+busiid,810,220,'100307');
			}
		}
		break;
	case "IncomeAndPay"://22/23
		var capitalno=$("#capitalno").val();
		var projecttype=$("#projecttype").val();

		if (tempcode == "all") {
			OpenPrint("/UCenter-webapp/IncomeAndPay/Print.htm?id="+busiid+"&searchprojecttype="+projecttype+"&capitalno="+capitalno,800,221,'110101');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				printtempname = "IncomeAndPayDetail.grf";
				var param=null;
			    	var capitalno=$("#capitalno").val();
			    	param="?id="+busiid+"&capitalno="+capitalno;
			    	param= escape(param);
			    	if(projecttype=="1"){
			    		signPrint3('IncomeAndPay',tempcodeArr,printtempname,"/UCenter-webapp/IncomeAndPay/PrintIncomeAndPayDetail.htm"+param);
			    	}else{
			    		signPrint3('IPay',tempcodeArr,printtempname,"/UCenter-webapp/IncomeAndPay/PrintIncomeAndPayDetail.htm"+param);
			    	}
			}else{
				OpenPrint("/UCenter-webapp/IncomeAndPay/Print.htm?id="+busiid+"&searchprojecttype="+projecttype+"&capitalno="+capitalno,800,221,'110101');
			}
		}
		break;
	case "ClientReceive"://22/23

		if (tempcode == "all") {
			OpenPrint("/UCenter-webapp/ClientReceive/Print.htm?businessid="+busiid,800,221,'110201');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				var productversion = $(parent.document).find("#productversion").val();
		    		if(productversion == 3){
		    			if(tempcodeArr=="00"){
						printtempname = "freeprintreport/ReceiveDetail.grf";
					}else if(tempcodeArr=="01"){
						printtempname = "freeprintreport/ReceiveDetail.grf";
					}
		    		}else{
		    			if(tempcodeArr=="00"){
						printtempname = "ReceiveDetail.grf";
					}else if(tempcodeArr=="01"){
						printtempname = "ReceiveDetail.grf";
					}
		    		}
		        	var param=null;
		        	param="?businessid="+busiid;
		        	param= escape(param);
				signPrint3('ReceiveAndPay',tempcodeArr,printtempname,"/UCenter-webapp/ClientReceive/PrintReceiveDetail.htm"+param);
			}else{
				var businessid=$("#businessid").val();
				var businessno=$("#businessno").val();
				OpenPrint("/UCenter-webapp/ClientReceive/Print.htm?businessid="+businessid+"&businessno="+businessno,800,221,'110201');
			}
		}
		break;
	case "SupplierPay"://25;

		if (tempcode == "all") {
			OpenPrint("/UCenter-webapp/SupplierPay/Print.htm?businessid="+busiid,800,222,'110202');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "PayDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "PayDetail.grf";
				}
				var param=null;
			    	param="?businessid="+busiid;
			    	param= escape(param);
				signPrint3('Pay',tempcodeArr,printtempname,"/UCenter-webapp/SupplierPay/PrintPayDetail.htm"+param);
			}else{
				var businessid=$("#businessid").val();
				var businessno=$("#businessno").val();
				OpenPrint("/UCenter-webapp/SupplierPay/Print.htm?businessid="+businessid+"&businessno="+businessno,800,222,'110202');
			}
		}
		break;
	case "WriteOff"://22/23
		var woid=$("#woid").val();

		if (tempcode == "all") {
			OpenPrint("/UCenter-webapp/WriteOff/Print.htm?woid="+woid,810,221,'110205');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				if(tempcodeArr=="00"){
					printtempname = "WriteOffDetail.grf";
				}else if(tempcodeArr=="01"){
					printtempname = "WriteOffDetail.grf";
				}
		        	var param=null;
		        	param="?woid="+woid;
		        	param= escape(param);
		        	signPrint4WriteOff('WriteOff',tempcodeArr,printtempname,woid);
			}else{
				OpenPrint("/UCenter-webapp/WriteOff/Print.htm?woid="+woid,810,221,'110205');
			}
		}
		break;
	case "picklistPrint"://28
		var billidstring=$("#hidbillidstring").val();
		
		var sortName=$("#hidsortname").val();
		var sortDesc=$("#hidsortdesc").val();

		if (tempcode == "all") {
			OpenPrint("/UCenter-webapp/Sale/PrintPickPage.htm?sortname="+sortName+"&sortdesc="+sortDesc+"&billidstring="+billidstring,810,225,'100101');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				printtempname = "PickingListDetail.grf";
				
				signPrint4PickPrint('PickingList',tempcodeArr,printtempname,busiid,"/UCenter-webapp/Sale/PrintPickingList.htm");
			}else{
				OpenPrint("/UCenter-webapp/Sale/PrintPickPage.htm?sortname="+sortName+"&sortdesc="+sortDesc+"&billidstring="+billidstring,810,225,'100101');
			}
		}
		break;
	case "picklistPrintOut"://28
		var billidstring=$("#hidbillidstring").val();
		
		var sortName=$("#hidsortname").val();
		var sortDesc=$("#hidsortdesc").val();

		if (tempcode == "all") {
			OpenPrint("/UCenter-webapp/OutStorage/PrintPickPage.htm?sortname="+sortName+"&sortdesc="+sortDesc+"&billidstring="+billidstring,810,225,'100307');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				printtempname = "PickingListDetail.grf";
				
				signPrint4PickPrint('PickingList',tempcodeArr,printtempname,busiid,"/UCenter-webapp/OutStorage/PrintPickingList.htm");
			}else{
				OpenPrint("/UCenter-webapp/OutStorage/PrintPickPage.htm?sortname="+sortName+"&sortdesc="+sortDesc+"&billidstring="+billidstring,810,225,'100307');
			}
		}
		break;
	case "ShopOrder"://301
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/orderPlusManagerShopOrder/print.htm?saleid='+busiid,810,225,'100400');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var printtempname = "";
				printtempname = "ShopOrderDetail1.grf";
				signPrint2('ShopOrder',tempcodeArr,printtempname,busiid,"/UCenter-webapp/orderPlusManagerShopOrder/PrintSaleDetail.htm?SaleId=");
			}else{
				OpenPrint('/UCenter-webapp/orderPlusManagerShopOrder/print.htm?saleid='+busiid,810,225,'100400');
			}
		}
		break;
	case "Sale"://3
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/Sale/Print.htm?saleid='+busiid,785,230,'100101');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var thetemplatecode="00";
				var printtempname = "";
				var isOpenSaleDetailDiscount = $("#isOpenSaleDetailDiscount").val();
				var isOpenSaleDetailDiscountStr="";
				var oddProcess = $("#oddProcess").val();
				var oddProcessStr="";
				if(isOpenSaleDetailDiscount!=undefined && isOpenSaleDetailDiscount=="1"){
					isOpenSaleDetailDiscountStr="_D";
				}
				if(oddProcess!=undefined && oddProcess!="0"){
					oddProcessStr="_M";
				}
				if(tempcodeArr=="00"){
					thetemplatecode="00";
					printtempname = "SaleDetail1.grf";
				}else if(tempcodeArr=="01"){
					thetemplatecode="01";
					printtempname = "SaleDetail1.grf";
				}else if(tempcodeArr=="02"){
					thetemplatecode="02";
					printtempname = "SaleDetail.grf";
				}else if(tempcodeArr=="03"){
					thetemplatecode="03";
					printtempname = "SaleDetail140.grf";
				}else if(tempcodeArr=="04"){
					thetemplatecode="04";
					printtempname = "SaleDetail190.grf";
				}else if(tempcodeArr=="05"){
					thetemplatecode="05";
					printtempname = "SaleDetail_POS.grf";
				}
				$("#hidprintbusitype").val("Sale");
				$("#hidprintbusiid").val(busiid);
				if(parent.$('#isusefirstprint').val()==1){
					signPrint1('Sale',thetemplatecode,printtempname,busiid);
				}else{
					printClick("/UCenter-webapp/Print/PrintReport.htm?Busi=Sale&templatecode="+thetemplatecode+"&Type=sys&ReportGrf="+printtempname+"&IsMulti="+$("#hidIsMultipleWarehouse").val()+"&DataUrl=/UCenter-webapp/Sale/PrintSaleDetail.htm?SaleId="+busiid);
				}
			}else{
				OpenPrint('/UCenter-webapp/Sale/Print.htm?saleid='+busiid,785,230,'100101');
			}
		}
		break;
	case "SaleOrder"://301
		if (tempcode == "all") {
			OpenPrint('/UCenter-webapp/SaleOrder/Print.htm?saleid='+busiid+'&ismulti='+isMulti,810,225,'100100');
		} else {
			tempcodeArr = tempcode.split(",");
			 $.each(tempcodeArr, function(index, value) {
				$(".temp" + value).show();
				templatecode = value;
			}); 
			if (tempcodeArr.length == 1) {
				var thetemplatecode="00";
				var printtempname = "";
				var isOpenSaleDetailDiscount = $("#isOpenSaleDetailDiscount").val();
				var isOpenSaleDetailDiscountStr="";
				var oddProcess = $("#oddProcess").val();
				var oddProcessStr="";
				if(isOpenSaleDetailDiscount!=undefined && isOpenSaleDetailDiscount=="1"){
					isOpenSaleDetailDiscountStr="_D";
				}
				if(oddProcess!=undefined && oddProcess!="0"){
					oddProcessStr="_M";
				}
				if(tempcodeArr=="00"){
					thetemplatecode="00";
					printtempname = "SaleOrderDetail1.grf";
				}else if(tempcodeArr=="01"){
					thetemplatecode="01";
					printtempname = "SaleOrderDetail1.grf";
				}else if(tempcodeArr=="02"){
					thetemplatecode="02";
					printtempname = "SaleOrderDetail.grf";
				}else if(tempcodeArr=="03"){
					thetemplatecode="03";
					printtempname = "SaleOrderDetail140.grf";
				}else if(tempcodeArr=="04"){
					thetemplatecode="04";
					printtempname = "SaleOrderDetail190.grf";
				}else if(tempcodeArr=="05"){
					thetemplatecode="05";
					printtempname = "SaleOrderDetail_POS.grf";
				}
				$("#hidprintbusitype").val("SaleOrder");
				$("#hidprintbusiid").val(busiid);
				if(parent.$('#isusefirstprint').val()==1){
					signPrintSaleOrder('SaleOrder',thetemplatecode,printtempname,busiid);
				}else{
					printClick('/UCenter-webapp/Print/PrintReport.htm?Busi=SaleOrder&templatecode='+thetemplatecode+'&Type=sys&ReportGrf='+printtempname+'&IsMulti='+$("#hidisopenmultiplewarehouse").val()+'&DataUrl=/UCenter-webapp/SaleOrder/PrintSaleDetail.htm?SaleId='+busiid);
				}
			}else{
				OpenPrint('/UCenter-webapp/SaleOrder/Print.htm?saleid='+busiid+'&ismulti='+isMulti,810,225,'100100');
			}
		}
		break;
	}
	
}
function signPrint2(Busi, templatecode, ReportGrf,saleid,url) {
	if(Busi=="SaleReturn"){
		printClick('/UCenter-webapp/Print/PrintReport.htm?Busi='+Busi+'&templatecode='+templatecode+'&Type=sys&ReportGrf='+ReportGrf+'&IsMulti='+parent.$("#hidisopenmultiplewarehouse").val()+'&DataUrl='+url+saleid);
	}else{
		printClick('/UCenter-webapp/Print/PrintReport.htm?Busi='+Busi+'&templatecode='+templatecode+'&Type=sys&ReportGrf='+ReportGrf+'&DataUrl='+url+saleid);

	}
	return;
	//除销售单、销售订单外，其他不支持快速打印
	if(parent.$('#isusefirstprint').val()!=1){
		if(Busi=="SaleReturn"){
			printClick('/UCenter-webapp/Print/PrintReport.htm?Busi='+Busi+'&templatecode='+templatecode+'&Type=sys&ReportGrf='+ReportGrf+'&IsMulti='+parent.$("#hidisopenmultiplewarehouse").val()+'&DataUrl='+url+saleid);
		}else{
			printClick('/UCenter-webapp/Print/PrintReport.htm?Busi='+Busi+'&templatecode='+templatecode+'&Type=sys&ReportGrf='+ReportGrf+'&DataUrl='+url+saleid);

		}
		return;
	}
	
    showSuccessMsg("正在打印...");
	isFirst = 0;
	var pid = null;
	pid = request("pid");
	if(null==pid || undefined==pid || ""==pid)
		pid = getCookie("pid");
	var ids = null;
	if(saleid!=null){
		ids = saleid;
	}else{
		ids = $('#saleid').val();
	}
	var idArr = ids.split(',');
	var isMulti=$("#hidismultiwarehouse").val();
	templateurl = getTemplateName(Busi, templatecode, ReportGrf,isMulti);
	if (templateurl == "") {
		showErrorMsg("找不到打印模板");
		return;
	}
  //检查打印方式
	var printtype = checkUserPrintType();
	if("0"==printtype){
		Report.LoadFromURL(templateurl);
		AjaxSyncLoadReportData(Report,url+ idArr[0] + "&pid="+pid+"&RAND=" + Math.random());
		Report.Print(false);
		parent.doCancel();
	}else{
		//打印的页面，调用打印助手
		//使用批量打印的方式
		var url = "/UCenter-webapp/Print/fastPrint.htm?pid=pid_param&templateurl=code_param&dataurl=data_param";
		url = url.replace("pid_param", getCookie("pid"));
		url = url.replace("code_param", templateurl);
		url = url.replace("data_param", url + idArr[0] + "&pid="+pid+"&RAND=" + Math.random());
		printClick(url, 2);
	}
}
function signPrint3(Busi, templatecode, ReportGrf,url) {
	if(templatecode=="00")
	{
	printClick("/UCenter-webapp/Print/PrintReport.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=sys&ReportGrf="+ReportGrf+"&DataUrl="+url);
	}else{
		printClick("/UCenter-webapp/Print/PrintReport.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=user&ReportGrf="+ReportGrf+"&DataUrl="+url);
	}
	return;
	//除销售单、销售订单外，其他不支持快速打印
	if(parent.$('#isusefirstprint').val()!=1){
		if(templatecode=="00")
	    	{
			printClick("/UCenter-webapp/Print/PrintReport.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=sys&ReportGrf="+ReportGrf+"&DataUrl="+url);
	    	}else{
	    		printClick("/UCenter-webapp/Print/PrintReport.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=user&ReportGrf="+ReportGrf+"&DataUrl="+url);
	    	}
	    	return;
	}
    showSuccessMsg("正在打印...");
	isFirst = 0;
	var pid = null;
	pid = request("pid");
	if(null==pid || undefined==pid || ""==pid)
		pid = getCookie("pid");
	var isMulti=$("#hidismultiwarehouse").val();
	templateurl = getTemplateName(Busi, templatecode, ReportGrf,isMulti);
	if (templateurl == "") {
		showErrorMsg("找不到打印模板");
		return;
	}
  //检查打印方式
	var printtype = checkUserPrintType();
	if("0"==printtype){
		Report.LoadFromURL(templateurl);
		AjaxSyncLoadReportData(Report,url + "&pid="+pid+"&RAND=" + Math.random());
		Report.Print(false);
		parent.doCancel();
	}else{
		//打印的页面，调用打印助手
		//使用批量打印的方式
		var url = "/UCenter-webapp/Print/fastPrint.htm?pid=pid_param&templateurl=code_param&dataurl=data_param";
		url = url.replace("pid_param", getCookie("pid"));
		url = url.replace("code_param", templateurl);
		url = url.replace("data_param", url + "&pid="+pid+"&RAND=" + Math.random());
		printClick(url, 2);
	}
}
function signPrint4WriteOff(Busi, templatecode, ReportGrf,woid) {
	if(templatecode=="00")
	{
	printClick("/UCenter-webapp/Print/PrintWriteOff.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=sys&ReportGrf="+ReportGrf+"&woid="+woid);
	}else{
		printClick("/UCenter-webapp/Print/PrintWriteOff.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=user&ReportGrf="+ReportGrf+"&woid="+woid);
	}
	return;
	//除销售单、销售订单外，其他不支持快速打印
	if(parent.$('#isusefirstprint').val()!=1){
		if(templatecode=="00")
	    	{
			printClick("/UCenter-webapp/Print/PrintWriteOff.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=sys&ReportGrf="+ReportGrf+"&woid="+woid);
	    	}else{
	    		printClick("/UCenter-webapp/Print/PrintWriteOff.htm?Busi="+Busi+"&templatecode="+templatecode+"&Type=user&ReportGrf="+ReportGrf+"&woid="+woid);
	    	}
	    	return;
	}
    showSuccessMsg("正在打印...");
	isFirst = 0;
	var pid = null;
	pid = request("pid");
	if(null==pid || undefined==pid || ""==pid)
		pid = getCookie("pid");
	templateurl = getTemplateName(Busi, templatecode, ReportGrf,0);
	if (templateurl == "") {
		showErrorMsg("找不到打印模板");
		return;
	}
  //检查打印方式
	var printtype = checkUserPrintType();
	if("0"==printtype){
		Report.LoadFromURL(templateurl);
		AjaxSyncLoadReportData(Report,url + "&pid="+pid+"&RAND=" + Math.random());
		Report.Print(false);
		parent.doCancel();
	}else{
		//打印的页面，调用打印助手
		//使用批量打印的方式
		var url = "/UCenter-webapp/Print/fastPrint.htm?pid=pid_param&templateurl=code_param&dataurl=data_param";
		url = url.replace("pid_param", getCookie("pid"));
		url = url.replace("code_param", templateurl);
		url = url.replace("data_param", "/UCenter-webapp/WriteOff/PrintWriteOff.htm?woid="+ woid + "&pid="+pid+"&RAND=" + Math.random());
		printClick(url, 2);
	}
}
function signPrint4PickPrint(Busi, templatecode, ReportGrf,saleid,url) {
	var songhuoyuan=$("#songhuoyuan").val();
	var peihuoyuan=$("#peihuoyuan").val();
	var pickingid=$("#hidbillidstring").val();
	var txbremark=$("#txbRemark").val();
	var sortName=$("#hidsortname").val();
	var sortDesc=$("#hidsortdesc").val();
	var param=null;
	param="?pickingid="+pickingid+'&sortname='+sortName+'&sortdesc='+sortDesc;
	param= escape(param);
	printClick('/UCenter-webapp/Print/PrintReport.htm?templatecode='+templatecode+'&Busi='+Busi+'&Type=sys&ReportGrf='+ReportGrf+'&songhuoyuan='+songhuoyuan+'&peihuoyuan='+peihuoyuan+'&txbremark='+txbremark+'&DataUrl='+url+param);
	return;
	//除销售单、销售订单外，其他不支持快速打印
	if(parent.$('#isusefirstprint').val()!=1){
		var songhuoyuan=$("#songhuoyuan").val();
		var peihuoyuan=$("#peihuoyuan").val();
		var pickingid=$("#hidbillidstring").val();
		var txbremark=$("#txbRemark").val();
		var sortName=$("#hidsortname").val();
		var sortDesc=$("#hidsortdesc").val();
		var param=null;
		param="?pickingid="+pickingid+'&sortname='+sortName+'&sortdesc='+sortDesc;
		param= escape(param);
		printClick('/UCenter-webapp/Print/PrintReport.htm?templatecode='+templatecode+'&Busi='+Busi+'&Type=sys&ReportGrf='+ReportGrf+'&songhuoyuan='+songhuoyuan+'&peihuoyuan='+peihuoyuan+'&txbremark='+txbremark+'&DataUrl='+url+param);
		return;
	}

    showSuccessMsg("正在打印...");
	isFirst = 0;
	var pid = null;
	pid = request("pid");
	if(null==pid || undefined==pid || ""==pid)
		pid = getCookie("pid");
	var ids = null;
	if(saleid!=null){
		ids = saleid;
	}else{
		ids = $('#saleid').val();
	}
	var idArr = ids.split(',');
	var isMulti=$("#hidismultiwarehouse").val();
	templateurl = getTemplateName(Busi, templatecode, ReportGrf,isMulti);
	if (templateurl == "") {
		showErrorMsg("找不到打印模板");
		return;
	}
	
	var pickingid=$("#hidbillidstring").val();
	var sortName=$("#hidsortname").val();
	var sortDesc=$("#hidsortdesc").val();
	var href=null;
	var param=null;
	param="?pickingid="+pickingid+'&sortname='+sortName+'&sortdesc='+sortDesc;
	param= escape(param);
	
  //检查打印方式
	var printtype = checkUserPrintType();
	if("0"==printtype){
		Report.LoadFromURL(templateurl);
		AjaxSyncLoadReportData(Report,"/UCenter-webapp/Sale/PrintPickingList.htm"
				+ param + "&pid="+pid+"&RAND=" + Math.random());
		Report.Print(false);
		parent.doCancel();
	}else{
		//打印的页面，调用打印助手
		//使用批量打印的方式
		var url = "/UCenter-webapp/Print/fastPrint.htm?pid=pid_param&templateurl=code_param&dataurl=data_param";
		url = url.replace("pid_param", getCookie("pid"));
		url = url.replace("code_param", templateurl);
		url = url.replace("data_param", "/UCenter-webapp/Sale/PrintPickingList.htm"
				+ param + "&pid="+pid+"&RAND=" + Math.random());
		printClick(url, 2);
	}
}

//首页 有 当前帐套的sobid 和 最新帐套的sobid 如果二者不一致 则说明 当前为老帐套
function isCurrentOldSetOfBooks(type){
	var flag = false;
	var productversion = $(parent.document).find("#productversion").val();
	var currentSob = $(parent.document).find("#sobid").val();
	var newSob = $(parent.document).find("#newSobid").val();
	if(productversion != "51"){
		if(currentSob != newSob){
			if(type == 1){
				showErrorMsg("当前为已结存账套，无法进行该操作");
			}
			flag = true;
		}
	}
	return flag;
}

function priceChange4Special(obj,price){
	//如果是特价，则判断修改后是否为特价了
	var specialprice=$(obj).find("input[name='hidspecialprice']").val();
	if(specialprice!=undefined && specialprice!="" && specialprice!="0"){
		if(Number(specialprice)==Number(price)){
			$(obj).find("input[name='hidpricetype']").val("7");
			//特价增加备注
			if($(obj).find("input[name='txbRowRemark']").val()==""){
				$(obj).find("input[name='txbRowRemark']").val("【特价】");
			}
		}else{
			if (saleTypeCombo.getValue() == "0" ){
				$(obj).find("input[name='hidpricetype']").val("1");
			}else{
				$(obj).find("input[name='hidpricetype']").val("2");
			}
			//非特价清空备注
			if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
				$(obj).find("input[name='txbRowRemark']").val("");
			}
		}
	}else{
		if (saleTypeCombo.getValue() == "0" ){
			$(obj).find("input[name='hidpricetype']").val("1");
		}else{
			$(obj).find("input[name='hidpricetype']").val("2");
		}
		//非特价清空备注
		if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
			$(obj).find("input[name='txbRowRemark']").val("");
		}
	}
}

function priceReturnChange4Special(obj,price){
	//如果是特价，则判断修改后是否为特价了
	var specialprice=$(obj).find("input[name='hidspecialprice']").val();
	if(specialprice!=undefined && specialprice!="" && specialprice!="0"){
		if(Number(specialprice)==Number(price)){
			$(obj).find("input[name='hidpricetype']").val("7");
			//特价增加备注
			if($(obj).find("input[name='txbRowRemark']").val()==""){
				$(obj).find("input[name='txbRowRemark']").val("【特价】");
			}
		}else{
			if ($("#hidbilltype").val() == "0" ){
				$(obj).find("input[name='hidpricetype']").val("1");
			}else{
				$(obj).find("input[name='hidpricetype']").val("2");
			}
			//非特价清空备注
			if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
				$(obj).find("input[name='txbRowRemark']").val("");
			}
		}
	}else{
		if ($("#hidbilltype").val() == "0" ){
			$(obj).find("input[name='hidpricetype']").val("1");
		}else{
			$(obj).find("input[name='hidpricetype']").val("2");
		}
		//非特价清空备注
		if($(obj).find("input[name='txbRowRemark']").val()=="【特价】"){
			$(obj).find("input[name='txbRowRemark']").val("");
		}
	}
}


//判断浏览器类型
function myBrowserType(){
	var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
	var isOpera = userAgent.indexOf("Opera") > -1;
	if (isOpera) {
	   return "Opera"
	}; //判断是否Opera浏览器
	if (userAgent.indexOf("Firefox") > -1) {
	   return "FF";
	} //判断是否Firefox浏览器
	if (userAgent.indexOf("Chrome") > -1){
	   return "Chrome";
	}
	if (userAgent.indexOf("Safari") > -1) {
	   return "Safari";
	} //判断是否Safari浏览器
	if (userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1 && !isOpera) {
	   return "IE";
	}; //判断是否IE浏览器
	if (userAgent.indexOf("Trident") > -1) {
	   return "Edge";
	} //判断是否Edge浏览器
}

//IE浏览器图片保存本地
function SaveAs4IEdeg(imgURL){
	var oPop = window.open(imgURL,"","width=1, height=1, top=5000, left=5000");
	for(; oPop.document.readyState != "complete"; )
	{
	   if (oPop.document.readyState == "complete")break;
	}
	oPop.document.execCommand("SaveAs");
	oPop.close();
}

//谷歌，360极速等浏览器下载
function download4Image(src) {
	var $a = document.createElement('a');
	$a.setAttribute("href", src);
	$a.setAttribute("download", "");
	
	var evObj = document.createEvent('MouseEvents');
	evObj.initMouseEvent( 'click', true, true, window, 0, 0, 0, 0, 0, false, false, true, false, 0, null);
	$a.dispatchEvent(evObj);
}

function oDownLoadImage(url) {
	var bType = myBrowserType();
	if (bType =="IE"||bType=="Edge"){
		SaveAs4IEdeg(url);
	}else{
		download4Image(url);
	}
}
/**
 * 进货模块初始化 异步初始化最近进货价
 */
function initBuyPriceSNRAsyncTrue(){
	var productversion = $(parent.document).find("#productversion").val();//版本
	var supplierid = $("#crvalue").val();//供应商id
	var suppliername = $("#txbCr").val();//供应商名称
	var branchid= $("#choose-warehouse-parentval").val();//门店ID 
	//价格权限 1-零售 2-批发价 3-参考进货价 4-最低售价 5-成本价 9-等级价
	var permflag = $("#permflag", parent.parent.document).val();
	var isAdmin = $("#isAdminRole", parent.parent.document).val();
	var nearbuypricepermflag = $("#nearbuypricepermflag", parent.parent.document).val();//最近进货价权限 1-有权限 0-无权限
	var url = window.location.href;
	var inputxb = "input[name='txbPrice']";
	var ulname = "ul[name='ulpriceli']";
	$("#tabdetail tr:gt(0)").each(function(){
		//获取本行的隐式表示 判断 此行是否已经获取过了
		var trflag = $(this).attr("init_price_flag");
		//复制新增/编辑页面 初始化的数据不进行 价格初始化加载
		var cforeachflag = $(this).attr("init_c_foreach");
		var productid = $(this).find("input[name='hidProductId']").val();
		//当trflag不等于1时 表示 该行商品 未获取过初始化价格
		if(trflag != "1" && cforeachflag != "1" && productid != undefined && productid != "" && $(this).is(":visible") ){
			
			var UnitId = $(this).find("input[name='hidUnitId']").val();
			if(suppliername==''){
				suppliername="EMPTY";
			}
			var obj = this;
			 $.ajax({
			      dataType: "json",
			      data: {
			    	  productid: productid,
			    	  productunit: UnitId,
			    	  clientid: supplierid,
			    	  clientname:suppliername,
			          branchid:branchid
			      },
			      url: "Buy/getNearBuyPrice.json?"+Math.random(),
			      cache: false,
			      type: "post",
			      async: true,
			      success: function (data) {
			    	  //价格输入框 原始值是 类型价格
			    	  var nearBuyPrice = Number(0).formatMoney();//最近进货价
			    	  if(data!=null&&data.nearprice!=null&&data.nearprice!=""){
			    		  if(nearbuypricepermflag == "1"){
			    			  nearBuyPrice=parseFloat(data.nearprice).formatMoney();
			    			  $(obj).find(inputxb).val(nearBuyPrice).change();
			    		  }else{
			    			  if (isAdmin != "true" && permflag.indexOf(";3;") < 0 ) {
				    			  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
				    		  }
			    		  }
			    	  }else{
			    		  if (isAdmin != "true" && permflag.indexOf(";3;") < 0 ) {
			    			  $(obj).find(inputxb).val(Number(0).formatMoney()).change();
			    		  }
			    	  }
			    	  $(obj).attr("init_price_flag","1");
			      }
			 });
		}
	});
	
}

/**
 * 延迟打印
 * @param id
 * @returns
 */
function setTimeoutPrint(busiid,temptype,busitype){
	setTimeout(function(){
		openPrintWindowElse(busiid,temptype,busitype);
	}, 2000 );
	
}

/**
 * 显示辅助数量
 * @returns
 */
function showAuxUnitCount(){
	$("[getAuxUnitCount]").each(function(){
		// 本元素可见/没有设置过
		if($(this).is(":visible") && ""==$(this).text()){
			var obj = $(this);
			var count = $(this).attr("getAuxUnitCount").split(",")[0];
			var ratio = $(this).attr("getAuxUnitCount").split(",")[1];
			var unitname = $(this).attr("getAuxUnitCount").split(",")[2];
			var productid = $(this).attr("getAuxUnitCount").split(",")[3];
			if(null==count || ""==count || isNaN(count) || ""==productid || null==productid){
				;
			}else{
				getAuxUnitCount(count, ratio, unitname, null, productid, $(this));
			}
		}
	});
}

/**
 * 得到辅助库存
 * @returns
 */
function getAuxUnitCount(thisUnitCount, thisUnitRatio, thisUnitName, productUnitArr, getProductUnitArrByProductId, targetObj){
	//定义获取辅助数量方法
	var func = function(baseUnitCount, productUnitArr){
		if(null==productUnitArr || productUnitArr.length==0 || isNaN(baseUnitCount))
			return "";
		
		//单位排序
		var productUnitArrCopy = JSON.parse(JSON.stringify(productUnitArr));
		productUnitArrCopy.sort(function(a, b){
			return b.unitratio - a.unitratio
		});
		
		var str = "";
		var tempCount = baseUnitCount;
		
		for(var i in productUnitArrCopy){
			var unit = productUnitArrCopy[i];
			var ratio = unit.unitratio;
			if(0 == tempCount){
				break;
			}
			//最后一个, 直接加到主单位
			if(i == Number(productUnitArrCopy.length)-1 && 0!=tempCount){
				str = str + tempCount + unit.unitname;
				break;
			}
			//本单位所占数量
			var thisUnitCount = String(tempCount / ratio).split(".")[0];
			if(0 != thisUnitCount){
				str = str + thisUnitCount + unit.unitname;
				tempCount = Math.sub(Number(tempCount), Number(thisUnitCount * ratio));
			}
		}
		
		return str;	
	}
	
	//单单位时是"", 特殊处理下
	if(""==thisUnitRatio)
		thisUnitRatio = 1;
	//判断
	if("undefined"!=productUnitArr && null!=productUnitArr){
		if(productUnitArr.length==0){
			return thisUnitCount+thisUnitName;
		}
		//单单位
		if(productUnitArr.length==1){
			productUnitArr = [{
				unitname : thisUnitName,
				unitratio : thisUnitRatio
			}];
		}
		var baseUnitCount = Number(thisUnitCount) * Number(thisUnitRatio);
		return func(baseUnitCount, productUnitArr, getProductUnitArrByProductId, targetObj);
	}else if("undefined"!=getProductUnitArrByProductId && null!=getProductUnitArrByProductId){
		$.ajax({
			url : "Product/GetCPProductUnitByProductId.json",
			async : true,
			data : {
				productid : getProductUnitArrByProductId
			},
			success : function(data){
				var baseUnitCount = Number(thisUnitCount) * Number(thisUnitRatio);
				var str = func(baseUnitCount, JSON.parse(data.jsonString));
				$(targetObj).text(str);
			}
		});
	}
}

var SalePrint1 = null;
function signPrint1(Busi, templatecode, ReportGrf,saleid) {
			//防止两次点击
			if (SalePrint1 == null) {
				SalePrint1 = new Date().getTime();
			} else {
				var Print2 = new Date().getTime();
				if (Print2 - SalePrint1 < 1000) {
					SalePrint1 = Print2;
					return;
				} else {
					SalePrint1 = Print2;
				}
			}
	        showSuccessMsg("正在打印...");
			isFirst = 0;
			var ids = null;
			if(saleid!=null){
				ids = saleid;
			}else{
				ids = $('#saleid').val();
			}
			var idArr = ids.split(',');
			templateurl = getTemplateName(Busi, templatecode, ReportGrf);
			if (templateurl == "") {
				showErrorMsg("找不到打印模板");
				return;
			}
			var pid = null;
			pid = request("pid");
			if(null==pid || ""==pid || undefined==pid)
				pid = getCookie("pid");
			//检查打印方式
    		var printtype = checkUserPrintType();
    		if("0"==printtype){
    			Report.LoadFromURL(templateurl);
    			AjaxSyncLoadReportData(Report,"/UCenter-webapp/Sale/PrintSaleDetail.htm?SaleId=" + idArr[0]+"&templatecode="+templatecode + "&pid="+pid+"&RAND=" + Math.random());
                Report.Print(false);
                //打印标记
                var len0 = idArr[0].length;
                var len1 = 0;
                if(len0 > 0){
                	var param={};
                	$.post("/UCenter-webapp/Sale/isPrint.json?SaleId="+idArr[0]+"&isPrintExt1=1&PrintModule=Sale&pid="+pid,param,function(result, resultState){
                		if (resultState == "success") {
                			parent.doCancel();
                		}
                	});
                }
                if(idArr[1] != undefined ){
                	len1 = idArr[1].length
                	if(len0 <= 0 && len1 > 0){
                		var param={};
        				$.post("/UCenter-webapp/Sale/isPrint.json?SaleId="+idArr[1]+"&isPrintExt1=1&PrintModule=Sale&pid="+pid,param,function(result, resultState){
        					if (resultState == "success") {
                    			parent.doCancel();
                    		}
        				});
        			}
                }
             
    		}else{
    			//打印的页面，调用打印助手
    			//使用批量打印的方式
    			var url = "/UCenter-webapp/Sale/BatchPrint.htm?printtype=printtype_param&saleids=ids_param&tempcodes=code_param&pid=pid_param";
    			url = url.replace("printtype_param", 1);
    			//url = url.replace("printtype_param", "${printtype}");
    			url = url.replace("ids_param", idArr[0]);
    			url = url.replace("code_param", templatecode);
    			url = url.replace("pid_param", getCookie("pid"));
    			printClick(url, 2);
    		}
}


var SaleOrderPrint1 = null;
function signPrintSaleOrder(Busi, templatecode, ReportGrf,saleid) {
			//防止两次点击
			if (SaleOrderPrint1 == null) {
				SaleOrderPrint1 = new Date().getTime();
			} else {
				var Print2 = new Date().getTime();
				if (Print2 - SaleOrderPrint1 < 1000) {
					SaleOrderPrint1 = Print2;
					return;
				} else {
					SaleOrderPrint1 = Print2;
				}
			}
	        showSuccessMsg("正在打印...");
			isFirst = 0;
			var pid = null;
			pid = request("pid");
			if(null==pid || undefined==pid || ""==pid)
				pid = getCookie("pid");
			var ids = null;
			if(saleid!=null){
				ids = saleid;
			}else{
				ids = $('#saleid').val();
			}
			var idArr = ids.split(',');
			var isMulti=$("#hidismultiwarehouse").val();
			templateurl = getTemplateName(Busi, templatecode, ReportGrf,isMulti);
			if (templateurl == "") {
				showErrorMsg("找不到打印模板");
				return;
			}
          //检查打印方式
    		var printtype = checkUserPrintType();
    		if("0"==printtype){
    			Report.LoadFromURL(templateurl);
    			AjaxSyncLoadReportData(Report,"/UCenter-webapp/SaleOrder/PrintSaleDetail.htm?SaleId="
    					+ idArr[0] + "&pid="+pid+"&RAND=" + Math.random());
    			Report.Print(false);
    			parent.doCancel();
    		}else{
    			//打印的页面，调用打印助手
    			//使用批量打印的方式
    			var url = "/UCenter-webapp/Print/fastPrint.htm?pid=pid_param&templateurl=code_param&dataurl=data_param";
				url = url.replace("pid_param", getCookie("pid"));
				url = url.replace("code_param", templateurl);
				url = url.replace("data_param", "/UCenter-webapp/SaleOrder/PrintSaleDetail.htm?SaleId="
    					+ idArr[0] + "&pid="+pid+"&RAND=" + Math.random());
				printClick(url, 2);
    		}
}

function getOrdinaryWarehouseList(obj,type){
	var isOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	if(type == "ReceOrder" || type == "TurnSale"){
		isOpenMultipleWarehouse = $("#hidisopenmultiplewarehouse").val();
	}else if(type == "Sale" || type == "SaleOrder"){
		isOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	}
	var curTrObj = $(obj).parent().parent().parent();
	//网店订单，接单页面 选择仓库 显示库存
	var productStocklist = getStockByProductId($(curTrObj).find("input[name='hidProductId']").val());
	if(productStocklist.length > 0){
		$(obj).parent().find("div[name='warehouselist']").addClass("warehouse-ul-list-preant");
		$(obj).parent().find(".droplist").addClass("warehouse-ul-list");
		//获取当前行选择的单位
		var unitId = $(curTrObj).find("input[name='hidUnitId']").val();
		var untiName = $(curTrObj).find("input[name='txbUnit']").val();
		if(type == "ReceOrder" && 3 != $("#paytype").val() && 5 != $("#paytype").val() ){
			untiName = $(curTrObj).find("td[class='noTF']").attr("noTF");
		}
		var unitRatio = $(curTrObj).find("input[name='hidunitratio']").val();
		if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
			unitRatio = 1;
		}
		//获取主副单位
		var mainUnitName = $(curTrObj).find("ul[name='ulunitli']").find("li:first").find("input[name='lihideunitname']").val();
		var mainUnitId = $(curTrObj).find("ul[name='ulunitli']").find("li:first").find("input[name='lihideunitid']").val();
		
		if(type == "TurnSale"){
			untiName = $(curTrObj).find("span[name='spanunitname']").text();
			mainUnitName = $(curTrObj).find("span[name='spanunitname']").attr("mainunit");
		}
		if(type == "Sale" || type == "SaleOrder"){
			if($(curTrObj).find("ul[name='ulunitli']").find("li").length == 0){
				mainUnitName = $(curTrObj).find("input[name='txbUnit']").val();
			}else if($(curTrObj).find("ul[name='ulunitli']").find("li").length > 0){
				mainUnitName = $(curTrObj).find("ul[name='ulunitli']").find("li:first").find("span:first").text();
			}
		}
		var stockName = "库存数量";
		if($("#hidIsOpenIO").val() == 1 || isOpenMultipleWarehouse == 1){
			stockName = "可用库存";
		}
		//循环仓库列表
		$(obj).parent().find("div[name='warehouselist']").find("div[name='multiwarehouse']").each(function(){
			var warehouseid = $(this).attr("data-value");
			var warehousename = $(this).attr("data-name");
			var isStockInfo = false;
			for(var i=0;i<productStocklist.length;i++){
				if( warehouseid.toUpperCase() == productStocklist[i].warehouseid.toUpperCase() ){
					isStockInfo = true;
					var productStockCount = 0;
					if(type == "ReceOrder" || type == "TurnSale"){
						productStockCount = (Number(productStocklist[i].availablestock) + Number(getProductBillOrderStock($(curTrObj).find("input[name='hidProductId']").val(),warehouseid)));
					}else if(type == "Sale" || type == "SaleOrder"){
						productStockCount = Number(productStocklist[i].availablestock);
					}
					$(this).html(warehousename
							+"&nbsp;<span class='warehouse-ul-list-li-span'>("+stockName+":"
							+getRatioCount2WarehouseList(unitRatio,productStockCount,untiName,mainUnitName)
							+")</span>");
					break;
				}
			}
			if(!isStockInfo){
				$(this).html(warehousename+"&nbsp;<span class='warehouse-ul-list-li-span'>("+stockName+":0"+untiName+")</span>");
			}
		});
	}
}

function getPTWarehouseList(obj,type){
	var isOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	if(type == "ReceOrder" || type == "TurnSale"){
		isOpenMultipleWarehouse = $("#hidisopenmultiplewarehouse").val();
	}else if(type == "Sale" || type == "SaleOrder"){
		isOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	}
	$(obj).parent().find("div[name='warehouselist']").addClass("warehouse-ul-list-preant");
	$(obj).parent().find(".droplist").addClass("warehouse-ul-list");
	var curTrObj = $(obj).parent().parent().parent();
	var ptid = $(curTrObj).find("input[name='hidptid']").val();
	var curTabObj = $(obj).parent().parent().parent().parent();
	var productAllStock=[];
	//获取成分商品 在所有仓库的库存信息 并且相同的商品 进行 库存合计
	var remberId = "";
	$(curTabObj).find("tr:hidden").each(function(){
		var thisPTId = $(this).find("input[name='hidptid']").val();
		if(undefined != thisPTId && "" != thisPTId){
			if(ptid.toUpperCase() == thisPTId.toUpperCase()){
				var productid = $(this).find("input[name='hidProductId']").val();
				//获取当前套餐内 这个商品的 所有单位的 成分比例
				var lastptcount = 0;
				if(type == "ReceOrder" || type == "SaleOrder"){
					ptid = ptid.toUpperCase()
				}else if(type == "Sale" ){
					ptid = ptid;
					if($(curTabObj).find(".ptdetails_"+ptid+":hidden").length <= 0){
						ptid = ptid.toUpperCase();
					}
				}
				$(curTabObj).find(".ptdetails_"+ptid+":hidden").each(function(){
					var hidProductId = $(this).find("input[name='hidProductId']").val();
					if( productid.toUpperCase() == hidProductId.toUpperCase() ){
						var ptcount = $(this).find("input[name='hidptcount']").val();
						var unitRatio = $(this).find("input[name='hidunitratio']").val();
						if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
							unitRatio = 1;
						}
						ptcount = ptcount * unitRatio;
						lastptcount = lastptcount + ptcount;
					}
				});
				//去掉重复的查询
				if( remberId.indexOf(productid) < 0){
					var result = getStockByProductId(productid);
					//循环仓库列表，填充结果中没有的 库存信息的仓库
					$(obj).parent().find("div[name='warehouselist']").find("div[name='multiwarehouse']").each(function(){
						var warehouseid = $(this).attr("data-value");//仓库ID
						var isWFlag = false;
						for(var i=0;i<result.length;i++){
							if(String(warehouseid).toUpperCase() == String(result[i].warehouseid).toUpperCase()){
								isWFlag = true;
								break;
							}
						}
						if(isWFlag == false){
							var warehouseStockInfo = {};
							warehouseStockInfo["availablestock"] = 0;
							warehouseStockInfo["curcount"] = 0;
							warehouseStockInfo["orderstock"] = 0;
							warehouseStockInfo["writeback"] = 0;
							warehouseStockInfo["isdel"] = 0;
							warehouseStockInfo["productid"] = productid;
							warehouseStockInfo["warehouseid"] = warehouseid;
							result.push(warehouseStockInfo);
						}
					});
					var ptRat = {};
					ptRat["ptcount"] = lastptcount;
					result.push(ptRat);
					productAllStock.push(result);
				}
				remberId = remberId + ","+productid
			}
		}
	});
	//循环仓库，计算仓库 比较 最小的库存
	$(obj).parent().find("div[name='warehouselist']").find("div[name='multiwarehouse']").each(function(){
		var trObj = $(this).parent().parent().parent().parent().parent();
		var ptid = $(trObj).find("input[name='hidptid']").val();
		var warehousename = $(this).attr("data-name");
		var warehouseid = $(this).attr("data-value");//A仓库
		var smallStock = 0;
		//第一个商品的 库存信息，在A仓库的 库存数量
		var stock = 0;
		var ss = true;
		//循环 成份商品
		var isHaveCurWarehouse = false;
		for(var i=0;i<productAllStock.length;i++){
			var productStockInfo = productAllStock[i];
			//循环找到 成份商品的  A仓库的库存信息
			
			for(var j=0;j<productStockInfo.length;j++){
				//找到当前 商品在 套餐里的 成份数量
				var ptcount = productStockInfo[productStockInfo.length-1].ptcount;//已经换算成基本单位的 套餐数量
				if(undefined != productStockInfo[j].warehouseid){
					//循环商品 然后依据仓库id 匹配出 当前仓库 的库存
					if(warehouseid.toUpperCase() == productStockInfo[j].warehouseid.toUpperCase()){
						isHaveCurWarehouse = true;
						//除以成份数量 获取 成份比例库存 取最小的
						var productStockCount = 0;
						if(type == "ReceOrder" || type == "TurnSale"){
							productStockCount = (Number(productStockInfo[j].availablestock) + Number(getProductBillOrderStock(productStockInfo[j].productid,productStockInfo[j].warehouseid)));
						}else if(type == "Sale" || type == "SaleOrder"){
							productStockCount = Number(productStockInfo[j].availablestock) ;
						}
						smallStock = Number(productStockCount)/ptcount;
						if(ss == true ){
							stock = Number(productStockCount)/ptcount;
							ss = false;
						}
					}
					//这个成分商品没有 循环到的仓库的库存信息，则库存为0
//					if(!isHaveCurWarehouse){
//						if(ss == true){
//							stock = 0;
//							ss = false;
//						}
//					}
				}
			}
			if(Number(smallStock) < Number(stock) ){
				stock = smallStock;
			}
		}
		//最小库存
		stock = parseInt(stock);
		
		if($("#hidIsOpenIO").val() == 1 || isOpenMultipleWarehouse == 1){
			$(this).html(warehousename+"&nbsp;<span class='warehouse-ul-list-li-span'>(可用库存:"+stock+"个)</span>");
		}else{
			$(this).html(warehousename+"&nbsp;<span class='warehouse-ul-list-li-span'>(库存数量:"+stock+"个)</span>");
		}
	});
}

function getStockByProductId(productid,warehouseid){
	var result = [];
	$.ajax({
        dataType: "json",
        data: {
        		productId:productid,
        		warehouseid:warehouseid
        	},
        cache: false,
        async: false,
        url: "/UCenter-webapp/Product/getStockByProductId.json",
        type: "post",
        success: function(o) {
        	if(undefined != o.serviceResult){
        		result = o.serviceResult;
        	}
         },
        error: function() {
        	//showErrorMsg("获取信息失败");
        }
	});
	return result;
}


function productStockShow(obj,type,pagetype){
	$(".stockFSvalue").hide();
	if(type == 2){
		return;
	}
	var isOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	if(pagetype == "ReceOrder" || pagetype == "TurnSale" || pagetype == "LendTurnSale"){
		isOpenMultipleWarehouse = $("#hidisopenmultiplewarehouse").val();
	}else if(pagetype == "Sale" || pagetype == "SaleOrder"){
		isOpenMultipleWarehouse = $("#hidIsOpenMultipleWarehouse").val();
	}
	var curTrObj = $(obj).parent().parent();
	if(isOpenMultipleWarehouse == 1){
		var wName = $(curTrObj).find("input[name='txbWarehouse']").val(); 
		var wId = $(curTrObj).find("input[name='hiddetailwarehouseid']").val();
		if(pagetype == "LendTurnSale"){
			 wName = $("#hidlendwarehousename").val(); 
			 wId = $("#hielendwarehouseid").val();
		}
		if( wName == undefined || String(wName) == "" || wId == undefined || wId == "" ){
			return;
		}
	}else{
		if($("#choose-warehouse-val").val() == "" || $("#choose-warehouse-val").val() == undefined){
			return;
		}
	}
	
	
	//套餐显示库存提示 需要特殊 处理
	var ptid = $(curTrObj).find("input[name='hidptid']").val();
	if(ptid != undefined && ptid != null && ptid != ""){
		var remberId = "";
		var smallStock = 0;
		var lastStock = 0;
		var sFlag = false;
		if(pagetype == "ReceOrder"|| pagetype == "SaleOrder"){
			ptid = ptid.toUpperCase();
		}else if(pagetype == "Sale" || pagetype == "TurnSale"){
			ptid = ptid;
			if($(curTrObj).parent().find(".ptdetails_"+ptid).length <= 0){
				ptid = ptid.toUpperCase();
			}
		}
		var trTxbCount = $(curTrObj).find("input[name='txbCount']").val();
		$(curTrObj).parent().find(".ptdetails_"+ptid).each(function(){
			var productid = $(this).find("input[name='hidProductId']").val();
			
			if(remberId.indexOf(productid) >= 0){
				//跳过此次循环
				return true
			}
			var wareshouseidnow = $(this).find("input[name='hiddetailwarehouseid']").val();//当前行的仓库id
			if(isOpenMultipleWarehouse != 1){
				wareshouseidnow = $("#choose-warehouse-val").val();
			}
			var resultList = getStockByProductId(productid,wareshouseidnow);
			//获取这个商品的库存
			var stock = 0;
			if(pagetype == "ReceOrder" || pagetype == "TurnSale"){
				ptid = ptid.toUpperCase();
				if(undefined != resultList && resultList.length > 0){
					stock = Number(resultList[0].availablestock) + Number(getProductBillOrderStock(productid,wareshouseidnow));
				}else{
					stock = Number(getProductBillOrderStock(productid,wareshouseidnow));
				}
			}else if(pagetype == "Sale" || pagetype == "SaleOrder"){
				ptid = ptid;
				if(pagetype == "SaleOrder"){
					ptid = ptid.toUpperCase();
				}
				if(undefined != resultList && resultList.length > 0){
					stock = Number(resultList[0].availablestock) ;
				}
			}
			
			//获取该商品在本套餐中的 成分比例
			var benPTCount = 0;
			$(curTrObj).parent().parent().find(".ptdetails_"+ptid).each(function(){
				var hidproductid = $(this).find("input[name='hidProductId']").val();
				if(productid == hidproductid ){
					var ptcount = $(this).find("input[name='hidptcount']").val();
					var unitRatio = $(this).find("input[name='hidunitratio']").val();
					if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
						unitRatio = 1;
					}
					ptcount = ptcount * unitRatio;
					benPTCount = Number(benPTCount) + Number(ptcount);
				}
			});
			//循环获取商品在列表中的成分比例
			var lastptcount = 0;
			$("#tabdetail tr:gt(0)").each(function() {
				var eachWarehouseId = $(this).find("input[name='hiddetailwarehouseid']").val();
				var hidproductid = $(this).find("input[name='hidProductId']").val();
				if(productid == hidproductid ){
					var curtxbCount =  $(this).find("input[name='txbCount']").val();
					if(isOpenMultipleWarehouse != 1){
						if($(this).is(":hidden")){
							//如果是套餐商品，则获取套餐的数量
							var hidptid = $(this).find("input[name='hidptid']").val();
							if(hidptid != undefined && hidptid != ""){
								$(this).parent().find("input[name='hiddetailtype'][value='1']").each(function(){
									if(String(hidptid).toUpperCase() == String($(this).parent().find("input[name='hidptid']").val()).toUpperCase() ){
										curtxbCount = $(this).parent().parent().find("input[name='txbCount']").val();
										return false;
									}
								});
							}
							var ptcount = $(this).find("input[name='hidptcount']").val();
							var unitRatio = $(this).find("input[name='hidunitratio']").val();
							if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
								unitRatio = 1;
							}
							ptcount = ptcount * unitRatio * curtxbCount;
							lastptcount = lastptcount + ptcount;
						}else{
							var ptcount = $(this).find("input[name='txbCount']").val();
							var unitRatio = $(this).find("input[name='hidunitratio']").val();
							if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
								unitRatio = 1;
							}
							ptcount = ptcount * unitRatio;
							lastptcount = lastptcount + ptcount;
						}
					}else{
						if(wareshouseidnow == eachWarehouseId){
							//同一个商品同一个仓库
							if($(this).is(":hidden")){
								//如果是套餐商品，则获取套餐的数量
								var hidptid = $(this).find("input[name='hidptid']").val();
								if(hidptid != undefined && hidptid != ""){
									$(this).parent().find("input[name='hiddetailtype'][value='1']").each(function(){
										if(String(hidptid).toUpperCase() == String($(this).parent().find("input[name='hidptid']").val()).toUpperCase() ){
											curtxbCount = $(this).parent().parent().find("input[name='txbCount']").val();
											return false;
										}
									});
								}
								var ptcount = $(this).find("input[name='hidptcount']").val();
								var unitRatio = $(this).find("input[name='hidunitratio']").val();
								if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
									unitRatio = 1;
								}
								ptcount = ptcount * unitRatio * curtxbCount;
								lastptcount = lastptcount + ptcount;
							}else{
								var ptcount = $(this).find("input[name='txbCount']").val();
								var unitRatio = $(this).find("input[name='hidunitratio']").val();
								if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
									unitRatio = 1;
								}
								ptcount = ptcount * unitRatio;
								lastptcount = lastptcount + ptcount;
							}
						}
					}
				}
			});
			
			
			//最终得到 除本行之外所有的这个商品的数量之和
			lastptcount = Number(lastptcount) - Number(benPTCount)*Number(trTxbCount);
			//得出成分库存
			lastStock = (Number(stock)-Number(lastptcount))/benPTCount;
			if(!sFlag){
				sFlag = true;
				smallStock =(Number(stock)-Number(lastptcount))/benPTCount;
			}
			if(Number(lastStock) < Number(smallStock)){
				smallStock = lastStock;
			}
			remberId = remberId +","+ productid;
		});
		//循环获取 当前套餐
		/*var descname = $(obj).attr("descname");
		var desctype = $(obj).attr("descproductdetailtype");
		var nowPTCount = 0;
		if(type == 1){
			$(curTrObj).parent().find("input[name='txbCount']").each(function(){
				if($(this).attr("descproductdetailtype") == 1 && $.trim($(this).attr("descname"))== $.trim(descname) ){
					nowPTCount = nowPTCount + Number($(this).val());
				}
			});
		}
		nowPTCount = parseInt(nowPTCount);*/
		var stockdivtext = "";
		var optionalCount = Number(smallStock);// - Number(nowPTCount);
		if(optionalCount < 1){
			stockdivtext = "无可选数量";
		}else{
			stockdivtext = "可选数量："+parseInt(optionalCount)+"个";
		}
		$(curTrObj).find("div[name='stockdivtip']").html(stockdivtext);
		$(curTrObj).find(".stockFSvalue").show();
		return;
	}
	//库存
	var stock = $(curTrObj).find("input[name='hidstockcount']").val();
	if("undefined"==typeof stock || String(stock) == "" ||  String(stock) == "NaN"){
		return;
	}else{
		//获取当前选择的单位
		var curCount =  $(curTrObj).find("input[name='txbCount']").val();//当前行的数量
		var productid = $(curTrObj).find("input[name='hidProductId']").val();
		var txbUnit = $(curTrObj).find("input[name='txbUnit']").val();
		var hidUnitId =  $(curTrObj).find("input[name='hidUnitId']").val();
		var txbCount = $(curTrObj).find("input[name='txbCount']").val();
		var wareshouseidnow = $(curTrObj).find("input[name='hiddetailwarehouseid']").val();//当前行的仓库id
		if(isOpenMultipleWarehouse != 1){
			wareshouseidnow = $("#choose-warehouse-val").val();
		}
		if(pagetype == "TurnSale"){
			txbUnit = $(curTrObj).find("span[name='spanunitname']").text();
			if(isOpenMultipleWarehouse != 1){
				wareshouseidnow = $("#choose-warehouse-val").val();
			}else{
				wareshouseidnow = $(curTrObj).find("input[name='hiddetailwarehouseid']").val();
			}
		}
		if(pagetype == "LendTurnSale"){
			txbUnit = $(curTrObj).find("span[name='spanunitname']").text();
			wareshouseidnow = $("#hielendwarehouseid").val();
		}
		var resultStockCount = stock;
		if($(curTrObj).find("input[name='hidisgetwarehousestock']").val() != 1){
			var resultList = getStockByProductId(productid,wareshouseidnow);
			if(pagetype == "ReceOrder" || pagetype == "TurnSale"){
				if(undefined != resultList && resultList.length > 0){
					resultStockCount = Number(resultList[0].availablestock) + Number(getProductBillOrderStock(productid,wareshouseidnow));
				}else{
					resultStockCount = Number(getProductBillOrderStock(productid,wareshouseidnow));
				}
			}else if(pagetype == "Sale" || pagetype == "SaleOrder" || pagetype=="LendTurnSale"){
				if(undefined != resultList && resultList.length > 0){
					resultStockCount = Number(resultList[0].availablestock);
				}
			}
//			if($("#hidIsOpenIO").val() != 1 && $("#hidisopenmultiplewarehouse").val() != 1){
//				resultStockCount = resultList[0].availablestock;
//			}
			$(curTrObj).find("input[name='hidisgetwarehousestock']").val("1");
			$(curTrObj).find("input[name='hidstockcount']").val(resultStockCount);
		}
		//获取列表中 该商品的 数量之和
		var allTxbcount = 0;
		$("#tabdetail tr:gt(0)").each(function() {
			if (typeof (productid) != 'undefined' && productid != ''&& productid != null) {
				var productIdElement= $(this).find('input[name="hidProductId"]');
				var txbCountElement= $(this).find("input[name='txbCount']");
				var unitRatioElement = $(this).find("input[name='hidunitratio']");
				if( pagetype != "LendTurnSale"){
					var wareshouseidnow1 = $(this).find("input[name='hiddetailwarehouseid']").val();//循环行的仓库id
					if(1 == isOpenMultipleWarehouse && wareshouseidnow != undefined && wareshouseidnow !=""){
						if(productIdElement.length>0 && ""!=$(productIdElement).val() ){
							if( productid == $(productIdElement).val() &&  wareshouseidnow1 == wareshouseidnow){
								if(unitRatioElement.length>0 && ''!= unitRatioElement.val() && Number(unitRatioElement.val())>0){
									allTxbcount = allTxbcount + parseFloat( txbCountElement.val() ) * parseFloat( unitRatioElement.val() );
								}else{
									allTxbcount= allTxbcount + parseFloat( txbCountElement.val() );
								}
							}
						}
					}else{
						if(productIdElement.length>0 && ""!=$(productIdElement).val() ){
							if( productid == $(productIdElement).val() ){
								if(unitRatioElement.length>0 && ''!= unitRatioElement.val() && Number(unitRatioElement.val())>0){
									allTxbcount = allTxbcount + parseFloat( txbCountElement.val() ) * parseFloat( unitRatioElement.val() );
								}else{
									allTxbcount= allTxbcount + parseFloat( txbCountElement.val() );
								}
							}
						}
					}
				}else{
					if(productIdElement.length>0 && ""!=$(productIdElement).val() ){
						if( productid == $(productIdElement).val() ){
							if(unitRatioElement.length>0 && ''!= unitRatioElement.val() && Number(unitRatioElement.val())>0){
								allTxbcount = allTxbcount + parseFloat( txbCountElement.val() ) * parseFloat( unitRatioElement.val() );
							}else{
								allTxbcount= allTxbcount + parseFloat( txbCountElement.val() );
							}
						}
					}
				}
				
			}
		});
		var stockdivtext = "";
		var isMulUnit = true;
		var mainUnitName = $(curTrObj).find("ul[name='ulunitli']").find("li:first").find("input[name='lihideunitname']").val();
		if(pagetype == "Sale" || pagetype == "SaleOrder"){
			if($(curTrObj).find("ul[name='ulunitli']").find("li").length == 0){
				mainUnitName = $(curTrObj).find("input[name='txbUnit']").val();
				isMulUnit = false
			}else if($(curTrObj).find("ul[name='ulunitli']").find("li").length > 0){
				mainUnitName = $(curTrObj).find("ul[name='ulunitli']").find("li:first").find("span:first").text();
			}
		}else if(pagetype == "TurnSale" || pagetype == "LendTurnSale"){
			mainUnitName = $(curTrObj).find("span[name='spanunitname']").attr("mainunit");
			isMulUnit = false
		}
		if(isMulUnit){
			$(curTrObj).find("ul[name='ulunitli']").find("li").each(function(){
				if(hidUnitId.toUpperCase() == $(this).find("input[name='lihideunitid']").val().toUpperCase()){
					var isMainUnit = $(this).find("input[name='lihideismainunit']").val();
					var unitRatio = $(this).find("input[name='lihideratio']").val();
					var unitName = $(this).find("input[name='lihideunitname']").val();
					if(pagetype == "Sale" || pagetype == "SaleOrder"){
						unitName = $(this).find("span:first").text();
					}
					//去除本行已选数量
					curCount = curCount * unitRatio;
					allTxbcount = Number(allTxbcount) - Number(curCount);
					var optionalCount = Number(resultStockCount) - Number(allTxbcount);
					if(isMainUnit == 1){
						if(Number(optionalCount) <= 0){
							stockdivtext = "无可选数量";
						}else{
							stockdivtext = "可选数量："+Number(optionalCount).formatNum(true)+txbUnit;
						} 
					}else if(isMainUnit == 0 || isMainUnit == undefined || isMainUnit == null || isMainUnit == 'null'){
						if(Number(optionalCount) <= 0){
							stockdivtext = "无可选数量";
						}else{
							stockdivtext = "可选数量："+getRatioCount2WarehouseList(unitRatio,optionalCount,unitName,mainUnitName);
						} 
					}
					//跳出当前循环
					return false;
				}
			});
		}else{
			var unitRatio = 1;
			if(pagetype == "TurnSale" || pagetype == "LendTurnSale" || pagetype == "Sale" || pagetype == "SaleOrder"){
				unitRatio = $(curTrObj).find("input[name='hidunitratio']").val();
				if(unitRatio == "" || unitRatio == undefined || unitRatio == null){
					unitRatio = 1;
				}
			}
			curCount = curCount * unitRatio;
			allTxbcount = Number(allTxbcount) - Number(curCount);
			var optionalCount = Number(resultStockCount) - Number(allTxbcount);
			if(Number(optionalCount) <= 0){
				stockdivtext = "无可选数量";
			}else{
				stockdivtext = "可选数量："+getRatioCount2WarehouseList(unitRatio,optionalCount,txbUnit,mainUnitName);
			} 
		}
		
		$(curTrObj).find("div[name='stockdivtip']").html(stockdivtext);
		$(curTrObj).find(".stockFSvalue").show();
	}
}

function getProductBillOrderStock(productid,warehouseid){
	if(undefined == productid){
		return 0;
	}else{
		productid = String(productid).toUpperCase();
	}
	if(undefined != warehouseid){
		warehouseid = String(warehouseid).toUpperCase();
	}
	var productJosn = JSON.parse($("#productJosn").text()) ;
	var orderstock = productJosn[productid+'-&&-'+warehouseid];
	if(orderstock == undefined ){
		orderstock = 0;
	}
	return orderstock;
}

/**
 * 查询客户关联的商品
 * @param productid
 * @param clientid
 * @returns
 */
function valiateClietnRelateProduct(type,productid,clientid){
	var param = {};
	param["productid"] = productid;
	param["clientid"] = clientid;
	var url = "/UCenter-webapp/ClientInfo/getClientReliateProduct.json";
	$.post(url, param, function(result, resultState) {
		if (resultState == "success") {
			var o = result.relateproductids;
			if(undefined != o && null != o && "" != o && "null" != o){
				if(type == 0){
					showSuccessMsg("该商品对客户不可见，接单后会自动关联");
				}else if(type == 1){
					showSuccessMsg("该套餐中商品对客户不可见，接单后会自动关联");
				}
			}
		}
	});
}
