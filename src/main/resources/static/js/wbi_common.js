function showSuccessMsg(message) {
	parent.showSuccessMsg(message);
}
function showErrorMsg(message) {
	parent.showErrorMsg(message);
}
function showAlertMsg(message) {
	parent.showAlertMsg(message);
}
// 系统确认框
function isConfirm(message) {
	return confirm(message);
}
var Account = Account || {};
var Branch = Branch || {};
// 载入属性下拉框
Branch.loadBranchDropDownBox = function($_obj, opts, propertyname) {
	if ($_obj.length == 0) {
		return
	};
	var opts = $.extend(true, {
		data : function() {
			return '/UCenter-webapp/commondata/GetBranchSelect.htm';
		},
		ajaxOptions : {},
		width : 200,
		height : 300,
		formatText : function(row) {
			return row.branchname;
		},
		text : 'branchname',
		value : 'branchid',
		defaultSelected : 0,
		defaultFlag : false,
		cache : false,
		editable : true,
		forceSelection : false,
		callback : {
			onChange : function(data) {
			}
		},
		extraListHtml : ''
	}, opts);
	var combo = $_obj.combo(opts).getCombo();
	return combo;
};

function getproductversion() {
	return parent.$('#productversion').val();
}
// 载入属性下拉框
Branch.loadBranchDropDownBoxNormal = function($_obj, opts, propertyname) {
	if ($_obj.length == 0) {
		return
 };
	var opts = $.extend(true, {
		data : function() {
			return '/UCenter-webapp/commondata/GetBranchSelect.htm?normal=1';
		},
		ajaxOptions : {},
		width : 200,
		height : 300,
		formatText : function(row) {
			return row.branchname;
		},
		// formatResult: 'name',
		text : 'branchname',
		value : 'branchid',
		defaultSelected : 0,
		defaultFlag : false,
		cache : false,
		editable : true,
		forceSelection : false,
		callback : {
			onChange : function(data) {
			}
		},
		extraListHtml : ''
	}, opts);
	var combo = $_obj.combo(opts).getCombo();
	return combo;
};
Account.loadAccountDropDownBox = function($_obj, opts, propertyname) {
	if ($_obj.length == 0) {
		return
	};
	var opts = $.extend(true, {
		data : function() {
			return 'Common/GetAccountSelect.htm';
		},
		ajaxOptions : {},
		width : 200,
		height : 300,
		formatText : function(row) {
			return row.accountsimplename;
		},
		// formatResult: 'name',
		text : 'accountsimplename',
		value : 'accountid',
		defaultSelected : 0,
		defaultFlag : false,
		cache : false,
		editable : true,
		forceSelection : false,
		callback : {
			onChange : function(data) {
			}
		},
		extraListHtml : ''
	}, opts);
	var combo = $_obj.combo(opts).getCombo();
	return combo;
};
// 小数
function decimal(obj) {
	var value = $(obj).val();
	if (isNaN(value) && "-" != value) {
		showErrorMsg("仅允许输入数值");
		value = value + "";
		// document.execCommand('undo');
		//value = value.substring(0, value.length - 1);
		//value = value.substring(0, 9);
		//$(obj).val(value);
		$(obj).val("0");
		$(obj).change();
	}
	value = parseInt(value);
	if (value > 1000000000 || value < -1000000000) {
		if(undefined!= $(obj).attr("errortip") && null!= $(obj).attr("errortip") && ""!= $(obj).attr("errortip")){
			showErrorMsg($(obj).attr("errortip"));
		}else{
			showErrorMsg("输入数值不得大于10亿或小于-10亿");
		}
		value = value + "";
		value = value.substring(0, value.length - 1);
		if (value.indexOf("-") != -1) {
			value = value.substring(0, 10);
		} else {
			value = value.substring(0, 9);
		}
		// document.execCommand('undo');
		$(obj).val(value);
		$(obj).change();
	}
}

var Business = Business || {};
Business.supplierCombo = function($_obj, opts) {
	if ($_obj.length == 0) {
		return
    };
	var opts = $.extend(true, {
		data : function() {
			return "/UCenter-webapp/commondata/getsupplier.htm";
		},
		ajaxOptions : {},
		width : 120,
		height : 300,
		formatText : function(row) {
			return row.text;
		},
		// formatResult: 'name',
		text : 'text',
		value : 'value',
		defaultSelected : 0,
		defaultFlag : false,
		cache : false,
		editable : true,
		forceSelection : false,
		triggerCls : 'nospan',
		callback : {
			onChange : function(data) {
			}
		},
		extraListHtml : ''
	}, opts);

	var supplierCombo = $_obj.combo(opts).getCombo();
	return supplierCombo;
};

Business.customerCombo = function($_obj, opts, branchId) {
	if ($_obj.length == 0) {
		return
    };
	var opts = $.extend(true, {
		data : function() {
			return "/UCenter-webapp/commondata/getcustomer.htm?branchid="
					+ branchId;
		},
		ajaxOptions : {},
		width : 120,
		height : 300,
		formatText : function(row) {
			return row.text;
		},
		// formatResult: 'name',
		text : 'text',
		value : 'value',
		defaultSelected : 0,
		defaultFlag : false,
		cache : false,
		editable : true,
		forceSelection : false,
		triggerCls : 'nospan',
		callback : {
			onChange : function(data) {
			}
		},
		extraListHtml : ''
	}, opts);
	var customerCombo = $_obj.combo(opts).getCombo();
	return customerCombo;
};
function getDocumentById(id) {
	return $(
			$(window.parent.document).find(".main:visible").find("#iframe")[0].contentDocument)
			.find("#" + id);
}
function isEffective(value) {
	var flag = true;
	if (value == '' || value == null || value == undefined) {
		flag = false;
	}
	return flag;
}
function isSysBranch(branchid) {
	var flag = false;
//	$.ajax({
//		async : false,
//		url : 'Common/IsSysBranch.json',// 跳转到 action
//		data : {
//			branchid : branchid
//		},
//		type : 'post',
//		cache : false,
//		dataType : 'json',
//		success : function(data) {
//			if (data.ok == '1') {
//				flag = true;
//			}
//		},
//		error : function() {
//		}
//	});
	var issysbranchflag = $(parent.document).find("#issysbranch").val();
	if(String(issysbranchflag) == '1'){
		flag = true;
	}
	
	return flag;
}
function initprint(busitype) {
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
		/*if (tempcodeArr.length == 1) {
			window.open($(".temp" + templatecode).attr("href"));
		}*/
	}
}
function setPrintTemplateList(busitype) {
	var tempcode = "";
	var tempcodeArr = new Array('00', '01', '02', '03', '04', '05');
	switch (busitype) {
	case 302:
		tempcodeArr=new Array('00','01');
		break;
	case 3:
		tempcodeArr = new Array('00', '01', '02', '03', '04', '05');
		break;
	case 1:
		tempcodeArr = new Array('00', '01', '02', '03', '04');
		break;
	case 4:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 2:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 7:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 8:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 9:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 10:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 11:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 21:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 20:
		tempcodeArr = new Array('00', '01', '02', '03');
		break;
	case 22:
		tempcodeArr = new Array('00', '01');
		break;
	case 23:
		tempcodeArr = new Array('00', '01');
		break;
	case 24:
		tempcodeArr = new Array('00', '01');
		break;
	case 25:
		tempcodeArr = new Array('00', '01');
		break;
	}
	$.ajax({
		dataType : "json",
		data : {
			busitype : busitype
		},
		url : "/UCenter-webapp/PrintTemplate/TemplateList.json",
		cache : false,
		type : "post",
		async : false,
		success : function(data) {
			if (data == null || data.listMap.length == 0) {
				tempcode = "all";
			} else {
				for (var i = 0; i < data.listMap.length; i++) {
					if (data.listMap[i].isshow == 0) {
						tempcodeArr = deleteArray(tempcodeArr,
								data.listMap[i].templatecode);
					}
				}
				tempcode = tempcodeArr.join(',');
			}
		},
		error : function() {

		}
	});
	return tempcode;
}
function deleteArray(list, key) {
	var index = 0;
	for (var i = 0; i < list.length; i++) {
		if (list[i] == key) {
			index = i;
			break;
		}
	}
	list.splice(index, 1);
	return list;
}

function checksession() {
	var flag = false;
	$.ajax({
		async : false,
		url : '../UCenter-webapp/index/checksession.json',// 跳转到 action
		data : {},
		type : 'post',
		cache : false,
		dataType : 'json',
		success : function(data) {
			if (data.flag == '1') {
				$('.loadding').hide();
				window.parent.showMainPage(
						'../UCenter-webapp/Login/reloginpassword.htm.htm?random'
								+ Math.random(), '录入密码', 200, 400);
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

// 用户页面href 重定向使用，作用：校验session 过期弹出录入密码框页面
function openUrl(url) {
	if (checksession()) {
		return;
	} else {
		location = url;
	}
}

/**
 * 获取出入库
 * 
 * @param isasync
 *            是否异步
 * @param iostate
 *            出入库状态 1：待入库或待出库 0：已入库或已出库 2：部分入库或出库
 * @param writeback
 *            是否作废 1.是 0.否
 * @param productid
 *            商品id
 * @returns
 */
function common_getWarehouseIODetail(isasync, iostate, writeback, productid) {
	var records = null;
	var basepath = $("#basepath", parent.document).val();
	var url = basepath + "/UCenter-webapp/Common/GetWarehouseIODetail.json";
	var param = {};
	param["iostate"] = iostate;
	param["writeback"] = writeback;
	param["productid"] = productid;
	$.YY_post(url, param, function(result, resultState) {
		if (resultState == "success") {
			records = result.records;
		} else {
			showErrorMsg("获取出入库详情集合失败");
		}
	}, null, null, null, isasync);
	return records;
}
/**
 * 获取业务设置
 * 
 * @param configcode
 *            业务设置编码
 * @param isasync
 *            是否异步
 * @returns
 */
function common_getSysConfig(isasync, configcode) {
	var record = null;
	var basepath = $("#basepath", parent.document).val();
	var url = basepath + "/UCenter-webapp/Common/GetSysConfig.json";
	var param = {};
	param["configcode"] = configcode;
	$.YY_post(url, param, function(result, resultState) {
		if (resultState == "success") {
			record = result.record;
		} else {
			showErrorMsg("获取业务设置失败");
		}
	}, null, null, null, isasync);
	return record;
}
// 打印
function OpenPrint(printUrl, width, height, menuId) {
	// 检查按钮权限
	if (!checkPerm(menuId, "PERM_PRINT")) {
		return;
	}
	var pv = $(parent.document).find("#productversion").val();
	if(pv == 51){
		window.parent.showMainPage(printUrl, '打印单据', height, width, true);
	}else{
		window.parent.showMainPage(printUrl, '打印单据', height, width);
	}
}

function reload(arg) {
	rememberCheckboxMap={};
    $("#resultList").flexReload(myPage,true);
    $("#selectAllCheckbox").removeAttr("checked");

}


// 选择单据: arg:1.应收 2.应付 3.预收 4.预付
//type：请求的业务类型：1：新增收款  2：新增付款  3：核销
//wfbusidate：业务日期  -2017年5月22日 10:50:04 增加参数
function selectBill(arg,clientid,supplierid,branchid,opentabname,type,wfbusidate){
	window.parent.showMainPage('/UCenter-webapp/Common/HXBillPopList.htm?type='+type+'&arg='+arg+"&clientid="+clientid+"&supplierid="+supplierid+"&branchid="+branchid+"&wfbusidate="+wfbusidate, opentabname, 550,
				1000);
}
function writebackchecksob(busiType, busiId){
	var tip = false;
	
	var nowsobid = $(parent.document).find("#sobid").val();
	if(nowsobid != undefined && nowsobid !=""){
		var url="";
		var param={};
		param['busiType'] = busiType;
		param['busiId'] = busiId;
		url='/UCenter-webapp/WriteOff/getsobidByBusiid.json';
		$.ajax({
	        dataType: "json",
	        data: param,
	        cache: false,
	        async: false,
	        url: url,
	        type: "post",
	        success: function(o) {
	        	var billsobid = o.billsobid;
				if(nowsobid != billsobid){
					showErrorMsg("该单据的关联单据不在本账套，无法作废");
					tip = true;
				}
	        },
	        error: function() {
	        }
	    });
	}
	return tip;
}

//0=期初，1=进货，2=进货退货，3=销售，4=销售退货，5=盘点，6=组装拆卸,7=调拨,
//8=借入,9=借出,10=借入归还,11=借出归还,12=借出转销售,13=借入转进货,14=待入库单,
//15=待出库单,21=入库单,20=出库单,24=收款单
function checkequalsSOB(busiType, busiId,isallow,clientid,supplierid){
	if(busiType == 0){//期初
		return;
	}
	var nowsobid = $(parent.document).find("#sobid").val();
	if(nowsobid != undefined && nowsobid !=""){
		var url="";
		var param={};
		param['busiType'] = busiType;
		param['busiId'] = busiId;
		url='/UCenter-webapp/WriteOff/getsobidByBusiid.json';
		$.post(url, param, function(result, resultState) {
			if (resultState == "success") {
				var billsobid = result.billsobid;
				if(nowsobid.toLowerCase() != billsobid.toLowerCase()){
					showErrorMsg("单据不在当前账套，您可以切换账套查看");
				}else{
					ShowBillDetail(busiType, busiId,isallow,clientid,supplierid);
				}
			}
		});
	}
	
}

/**
 * 加载仓库下拉框  包括列表和批量
 */
function loadWarehouseDropListData(){
	$.ajax({
		dataType : "json",
		data : {},
		cache : false,
		async : false,
		url : "/UCenter-webapp/commondata/getwarehouse.json?type=1",
		type : "post",
		success : function(data) {
			var isHaveSelected=0;
			for ( var i = 0; i < data.Items.length; i++) {

				if(data.Items[i]["selected"]=="1"){
					if(data.Items[i]["islocked"]=="1"){//分仓盘点锁定判断
						isHaveSelected=1;
						$("input[name='hiddetailwarehouseid']").val(data.Items[i]["value"]);
						$("input[name='txbWarehouse']").val(data.Items[i]["text"]);
						$("#warehouseDropList .droplist").append("<div style='color:#FD6C54;' title='盘点中' class=\"list-item select\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					
					}else{
						isHaveSelected=1;
						$("input[name='hiddetailwarehouseid']").val(data.Items[i]["value"]);
						$("input[name='txbWarehouse']").val(data.Items[i]["text"]);
						$("#warehouseDropList .droplist").append("<div class=\"list-item select\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					}
				}else{
					if(data.Items[i]["islocked"]=="1"){
						$("#warehouseDropList .droplist").append("<div style='color:#FD6C54;' title='盘点中' class=\"list-item\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					}else{
						$("#warehouseDropList .droplist").append("<div class=\"list-item\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					}
			 	}
			}
			if(isHaveSelected==0&&data.Items.length>0){
				$("input[name='hiddetailwarehouseid']").val(data.Items[0]["value"]);
				$("input[name='txbWarehouse']").val(data.Items[0]["text"]);
			}
			$('.selectArrow').click(function(event) {
				event.stopPropagation();
			});
		},
		error : function() {
			alert("加载列表仓库下拉框失败");
		}
	});
}


/**
 * 加载仓库下拉框  包括列表和批量
 */
function loadWarehouseDropListDataMB(){
	$.ajax({
		dataType : "json",
		data : {},
		cache : false,
		async : false,
		url : "/UCenter-webapp/commondata/getwarehouse.json?type=1",
		type : "post",
		success : function(data) {
			var isHaveSelected=0;
			for ( var i = 0; i < data.Items.length; i++) {

				if(data.Items[i]["selected"]=="1"){
					if(data.Items[i]["islocked"]=="1"){//分仓盘点锁定判断
						isHaveSelected=1;
						$("input[name='hiddetailwarehouseid']").val(data.Items[i]["value"]);
						$("input[name='txbWarehouse']").val(data.Items[i]["text"]);
						$("#warehouseDropList .droplist").append("<div style='color:#FD6C54;' title='盘点中' class=\"list-item select\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					
					}else{
						isHaveSelected=1;
						$("input[name='hiddetailwarehouseid']").val(data.Items[i]["value"]);
						$("input[name='txbWarehouse']").val(data.Items[i]["text"]);
						$("#warehouseDropList .droplist").append("<div class=\"list-item select\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					}
				}else{
					if(data.Items[i]["islocked"]=="1"){
						$("#warehouseDropList .droplist").append("<div style='color:#FD6C54;' title='盘点中' class=\"list-item\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					}else{
						$("#warehouseDropList .droplist").append("<div class=\"list-item\" data-islocked=\""+data.Items[i]["islocked"]+"\" onclick=\"chooseWarehouse(this)\" data-value=\""+data.Items[i]["value"]+"\"data-name=\""+data.Items[i]["text"]+"\">"+data.Items[i]["text"]+"</div>");
					}
			 	}
			}
			if(isHaveSelected==0&&data.Items.length>0){
				$("input[name='hiddetailwarehouseid']").val(data.Items[0]["value"]);
				$("input[name='txbWarehouse']").val(data.Items[0]["text"]);
			}
			$('.selectArrow').click(function(event) {
				event.stopPropagation();
			});
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
	if(warehouseid==undefined || warehouseid==null || warehouseid==""){
		warehousename="预订";
		$('#ishideproductcount').val("1");
	}else{
		$('#ishideproductcount').val("0");
	}
	$("input[name='hiddetailwarehouseid']").val(warehouseid);
	$("input[name='txbWarehouse']").val(warehousename);

	$("#warehouseid").val(warehouseid);
	
	$(".yun-ui-droplist-wrap").hide();
}
function showWarehouseDropList(obj){
	$(".FSvalue").hide();
	$(obj).parent().find("div[name='warehouselist']").show();
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

/*
 * 分仓盘点锁定仓库判断
 * @param warehouseid
 * @returns {Boolean}
 */
function checkisLockWarehouse(warehouseid,type){
	var pv = $(parent.document).find("#productversion").val();
	var flat = false;
	if(pv!=3){
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
		        	var warehousename = o.serviceResult.warehousesimplename;
		        	if(lock != undefined && lock!=null && lock!=""){
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
			        		if(lock == 1){
			        			alert("原单据中的仓库正在盘点，请解锁该仓库后再进行此操作！");
				        		flat = true;
			        		}
			        	}
			        	else if(type==6){
			        		if(lock == 1){
			        			showErrorMsg("作废前请锁定帐套，点击【盘点前锁定】可以锁定帐套。");
			        			flat = true;
			        		}
			        	}
			        	else if(type == 7){
			        		if(lock == 1){
			        			showErrorMsg("盘点前请锁定帐套，点击【盘点前锁定】可以锁定帐套。");
			        			flat = true;
			        		}
			        	}
			        	else if(type == 8){
			        		if(lock == 1){
			        			showErrorMsg(warehousename+"仓库正在盘点");
			        			flat = true;
			        		}
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
//作废他人权限-多仓
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
        			var islocked = o.serviceResult[0].islocked;
        			if(islocked != undefined && islocked!=null && islocked!=""){
        				if(o.serviceResult[0].islocked == 1){
            				if(type ==1){
            					islocked = true;
            				}else{
            					showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
                				islocked = true;	
            				}
            			}
        			}
        			
        		}
        },
        error: function() {
        }
    });
	return islocked;
}

//免费版
function getwarehouseislockedEdit(type){
	var userid = parent.$("#userid").val();//当前登录的用户
	var islockedtip = false;
	$.ajax({
        dataType: "json",
        data: {userid:userid},
        cache: false,
        async: false,
        url: "/UCenter-webapp/Warehouse/getuserwarehouseinfo.json?" + Math.random(),
        type: "post",
        success: function(o) {
        		if(o.count > 0){
        			var islocked = o.serviceResult[0].islocked;
        			if(islocked != undefined && islocked!=null && islocked!=""){
        				if(o.serviceResult[0].islocked == 1){
        					islockedtip = true;
//            				if(type ==1){
//            					islocked = true;
//            				}else{
//            					showErrorMsg("当前帐套为盘点状态,请先解锁帐套.");
//                				islocked = true;	
//            				}
            			}else{
            				showErrorMsg("盘点前请锁定帐套，点击【盘点前锁定】可以锁定帐套。");
            				islockedtip = false;	
            			}
        			}else{
        				showErrorMsg("盘点前请锁定帐套，点击【盘点前锁定】可以锁定帐套。");
        				islockedtip = false;	
        			}
        			
        		}
        },
        error: function() {
        }
    });
	return islockedtip;
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
        			if(type==1){
        				if(o.count2){
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


$.fn.mergeCell = function(options) {
	return this.each(function() {
		var cols = options.cols;
		for (var i = cols.length - 1; cols[i] != undefined; i--) {
			// fixbug console调试
			// console.debug(cols[i]);
			mergeCell($(this), cols[i]);
		}
		dispose($(this));
	});
};
function mergeCell($table, colIndex) {
	$table.data('col-content', ''); // 存放单元格内容
	$table.data('col-rowspan', 1); // 存放计算的rowspan值 默认为1
	$table.data('col-td', $()); // 存放发现的第一个与前一行比较结果不同td(jQuery封装过的),
								// 默认一个"空"的jquery对象
	$table.data('trNum', $('tbody tr', $table).length); // 要处理表格的总行数,
														// 用于最后一行做特殊处理时进行判断之用

	// 我们对每一行数据进行"扫面"处理 关键是定位col-td, 和其对应的rowspan
	$('tbody tr', $table).each(
			function(index) {
				// td:eq中的colIndex即列索引
				var $td = $('td:eq(' + colIndex + ')', this);

				// 取出单元格的当前内容
				var currentContent = $td.html();

				// 第一次时走此分支
				if ($table.data('col-content') == '') {

					$table.data('col-content', currentContent);
					$table.data('col-td', $td);

				} else {
					if(!$(this).is(":hidden")){
						// 上一行与当前行内容相同
						if ($table.data('col-content') == currentContent) {
							// 上一行与当前行内容相同则col-rowspan累加, 保存新值
							var rowspan = $table.data('col-rowspan') + 1;
							$table.data('col-rowspan', rowspan);
							// 值得注意的是 如果用了$td.remove()就会对其他列的处理造成影响
							$td.hide();
	
							// 最后一行的情况比较特殊一点
							// 比如最后2行 td中的内容是一样的,
							// 那么到最后一行就应该把此时的col-td里保存的td设置rowspan
							if (++index == $table.data('trNum'))
								$table.data('col-td').attr('rowspan',
										$table.data('col-rowspan'));
	
						} else { // 上一行与当前行内容不同
							// col-rowspan默认为1, 如果统计出的col-rowspan没有变化, 不处理
							if ($table.data('col-rowspan') != 1) {
								$table.data('col-td').attr('rowspan',
										$table.data('col-rowspan'));
							}
							// 保存第一次出现不同内容的td, 和其内容, 重置col-rowspan
							$table.data('col-td', $td);
							$table.data('col-content', $td.html());
							$table.data('col-rowspan', 1);
						}
					}
				}
			});
}
function dispose($table) {
	$table.removeData();
}


function detailRecord(i){
	$("#row"+i+'_detail').toggle();
}

function doCancel(){
	window.parent.doCancel();
}

var WBI_COMMON={};

(function (original) {  
	  jQuery.fn.clone = function () {  
	    var result           = original.apply(this, arguments),  
	        my_textareas     = this.find('textarea').add(this.filter('textarea')),  
	        result_textareas = result.find('textarea').add(result.filter('textarea')),  
	        my_selects       = this.find('select').add(this.filter('select')),  
	        result_selects   = result.find('select').add(result.filter('select'));  
	  
	    for (var i = 0, l = my_textareas.length; i < l; ++i) $(result_textareas[i]).val($(my_textareas[i]).val());  
	    for (var i = 0, l = my_selects.length;   i < l; ++i) result_selects[i].selectedIndex = my_selects[i].selectedIndex;  
	  
	    return result;  
	  };  
}) (jQuery.fn.clone);  

function showModel(obj){
	if(obj==null||obj==undefined||obj=="undefined"){
		obj = $(".popArea");
	}
	window.parent.showMainModel(obj.clone());
	 
}
//打印信息
function showMsg(msg) {
	window.parent.showSuccessMsg(msg);
	if($(".noActionButton").length>0){
		$(".noActionButton").removeClass('noActionButton');
	}
	if($(".loadding").length>0){
		$(".loadding").hide();
	}
}

function showErrorMsg(msg){
	if(window!=parent)
		window.parent.showErrorMsg(msg);
	if($(".noActionButton").length>0){
		$(".noActionButton").removeClass('noActionButton');
	}
	if($(".loadding").length>0){
		$(".loadding").hide();
	}
}

function getParentWindow(){
	return $(window.parent.document).find(".main:visible").find("#iframe")[0].contentWindow;
}

function load(){
	$("#SearchKeyWord").val($.trim($("#SearchKeyWord").val()));
	$("#resultList").flexReload(myPage,true);
	$("#selectAllCheckbox").removeAttr("checked");
}

function parentCancelReload() {
	window.parent.doCancel();
	load();
}

function refresh_page() {
	$("#SearchKeyWord").val("");
	window.parent.doCancel();
	load();
}

function search(){
	$("#resultList").flexReload(myPage);
}

// 取得选中的id列表
//function getSelectIds() {
//	var cids = "";
//	var selCtrls = $("input[listcheck='0']:checked");
//	var id_len = selCtrls.length;
//	for (var i = 0; i < id_len; i++) {
//		if(i==0){
//			cids += selCtrls[i].value ;
//		} else {
//			cids += ','+selCtrls[i].value;
//		}
//	}
//	return cids;
//}

function doCommonSave() {
	$("#myForm").submit();
	if($("#myForm").find(".n-error:visible").length>0){
		return;
	}
	var param = $('#myForm').serializeObject(); 
	var moduleName = $("#moduleName").val();
	$.YY_post(moduleName+"/save.json", param, function(result, resultState) {
		if (resultState == "success") {
			if (result.serviceResult.statu == 1) {
				showMsg(result.serviceResult.message);
				refresh_page();
			} else {
				showErrorMsg(result.serviceResult.message);
			}
		} else {
			showErrorMsg("操作失败");
		}
	});
}


function deleteSel(id){//删除单行值传ID，否则不传值或者null
	var moduleName = $("#moduleName").val();
	var ids ;
	if(id==null||id==undefined||id=="undefined"){
		ids = getSelectIds();
	} else {
		ids = id;
	}
	if (ids == '' ) {
		showMsg("请选择要操作的数据");
		return;
	}
	if (!confirm("您确定要删除吗？")) {
		return;
	}
	var param = {};
	param[moduleName+"Id"] = ids;
	param["isdel"] = 1;
	$.YY_post(moduleName+"/delete.json", param, function(result, resultState) {
		if (resultState == "success") {
			if (result.serviceResult.statu == 1) {
				showMsg(result.serviceResult.message);
				clearRememberCheckboxMap();
				refresh_page();
			} else {
				showErrorMsg(result.serviceResult.message);
			}
		} else {
			showErrorMsg("删除失败");
		}
	});
}

// 启用或停用
function operateRecord(operateName) {
	var moduleName = $("#moduleName").val();
	var ids = getSelectIds();
	if (ids == '' ) {
		showErrorMsg("请选择要操作的数据");
		return;
	}
	var param = {},msg='';
	if (operateName == "start") {
		param["isstop"] = 0;
		msg="是否启用选中条目?";
	} else if (operateName == "stop") {
		param["isstop"] = 1;
		msg="是否停用选中条目?";
	} else {
		showErrorMsg("参数错误");
		return;
	}
	if (!confirm(msg)) {
		return;
	}
	param[moduleName+"Id"] = ids;

	$.YY_post(moduleName+"/operate.json", param, function(result, resultState) {
		if (resultState == "success") {
			if (result.serviceResult.statu == 1) {
				showMsg(result.serviceResult.message);
				clearRememberCheckboxMap();
				refresh_page();
			} else {
				showErrorMsg(result.serviceResult.message);
			}
		} else {
			showErrorMsg("操作失败");
		}
	});
}

/**
 * 区别于wbill_common.js的同名方法
 * 内容同 initBranch 方法
 */
function wbi_initBranch(branchId){
	$.ajax({  
        type: "POST",  
        url: "Branch/getBranch.json",  
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
    	        	showModel();
    			} else {
    				showErrorMsg(result.serviceResult.message);
    			}
    		} else {
    			showErrorMsg("操作失败");
    		}
        }
 });  
}

function wbi_initBranchWarehouse(branchId,domId){
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
    	        	
    	        	obj = $("#"+domId);
    	        	window.parent.showMainModel(obj.clone());
    			} else {
    				showErrorMsg(result.serviceResult.message);
    			}
    		} else {
    			showErrorMsg("操作失败");
    		}
        }
 });  
}

/**
 * 载入门店
 * @param branchId
 */
function initBranch(branchId){
	$.ajax({  
        type: "POST",  
        url: "Branch/getBranch.json",  
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
    	        	showModel();
    			} else {
    				showErrorMsg(result.serviceResult.message);
    			}
    		} else {
    			showErrorMsg("操作失败");
    		}
        }
 });  
}

WBI_COMMON.getSysConfig = function(configcode){
	var param = {},jsonObj={};
	if(configcode!=null&&configcode!=undefined||configcode!=""){
		param.configcode = configcode;
	}
	$.ajax({  
        type: "POST", 
        async: false, 
        data: param,
        url: "SysConfig/getSysConfig.json",  
        success:function(obj){  
        	jsonObj= obj;
        }  
	}); 
	return jsonObj;
};

WBI_COMMON.getSysConfigByCode = function(configcode){
	var obj = WBI_COMMON.getSysConfig(configcode);
	config = obj.configSBList==null?null:obj.configSBList[0];
	return config;
};

//根据门店ID获取门店信息
WBI_COMMON.getBranchById = function(id){
	var obj=null;
	$.ajax({  
        type: "POST", 
        async: false, 
        data: {id:id},
        url: "Branch/getBranchById.json",  
        success:function(result){  
        	if (result.serviceResult.statu == 1) {
        		obj = result.serviceResult.t;
			} 
        }  
	}); 
	return obj;
};

WBI_COMMON.getBillnoBySetType = function(settype){
	var obj=null;
	$.ajax({  
        type: "POST", 
        async: false, 
        data: {settype:settype},
        url: "BillnoSetting/getBillnoBySetType.json",  
        success:function(result){  
        	if (result.serviceResult.statu == 1) {
        		obj = result.serviceResult.t;
			} else {
				showMsg("单号获取失败");
			} 
        }  
	}); 
	return obj!=null?obj.setno:"";
};

//业务设置
function updateConfig(param) {
	$.ajax({  
        type: "POST",  
        url: "/UCenter-webapp/SysConfig/updateConfig.json", 
        data: param,
        success:function(result, resultState){
        	if (resultState == "success") {
    			if (result.serviceResult.statu == 1) {
    				var pv = $(parent.document).find("#productversion").val();
    				var configvalue=param.configvalue;
    				var configcode=param.configcode;
    				if('IsOpenIO'==configcode)
    				{
    					$("#isopenio",parent.document).val(configvalue);
    				}
    				if(param.configcode == "PriceDecimalDigits"){//设置小数弹出消息提示
    					alert("价格小数位设置成功，您需要重新登录该设置才会生效");
    				}else if(param.configcode == "CountDecimalDigits"){//设置数量小数弹出消息提示
    					alert("数量小数位设置成功，您需要重新登录该设置才会生效");
    				} else if(param.configcode == "OddProcess"){
    					alert("零头处理设置成功，您需要重新登录该设置才会生效");
    				} else if(param.configcode == "IsOpenBillRedPacket" || param.configcode == "RedPacketSupportAccountId" ||param.configcode == "RedPacketMaxRate"){
    					//
    				}else if(param.configcode == "IsAllowNegativeOrderGoods"){
    					showSuccessMsg("更新网店设置成功");
    				}else {
    					showSuccessMsg(result.serviceResult.message);
    					if(pv == 51 && 'IsOpenMultipleWarehouse'==configcode && param["isSetUpPage"] == 1){
    						showSuccessMsg("已开启多仓功能");
    					}
    					//parent.refreshAllTab();
    				}
    				if('IsOpenMultipleWarehouse'==configcode){
    					parent.$("#hidisopenmultiplewarehouse").val(configvalue);
    					if(pv == 51){
    						$("#show_main_cover").hide();
        					$("#showMainTipArea").hide();
    					}
    				}
    				//修改客户等级价是否开启时需要更新index.jsp页面的隐藏域值
    				if('IsOpenClientRankPrice'==configcode){
    					parent.$("#hidisopenclientrankprice").val(configvalue);
    				}
    				//快速打印
    				if('isusefirstprint'==configcode){
    					parent.$("#isusefirstprint").val( configvalue );//更新缓存
    				}
    			} else {
    				showErrorMsg(result.serviceResult.message);
    				var id = param.configcode;
    				var configValue = param.configvalue;
    				if(configValue==0){
    					$("#"+id).attr("checked","checked");
    				} else {
    					$("#"+id).removeAttr("checked");
    				}
    			}
    		} else {
    			showMsg("设置失败");
    		}
        }
    });
}
// var jsonuserinfo = $('#form').serializeObject(); 
//显示保存按钮
function showButton(){
	//this.value=this.value.replace(/^\s+|\s+$/g,'');
	if($(".noActionButton").length>0){
		$(".noActionButton").removeClass("noActionButton");
	}
}

function getCurrentDate(){
	 var now = new Date();
     var year = now.getFullYear();       //年
     var month = (now.getMonth() + 1)>9?(now.getMonth() + 1):'0'+(now.getMonth() + 1);     //月
     var day = now.getDate();            //日
     return year+'-'+month+'-'+day;
}

/** @param diclname 数据字典明细表名称
* @param dicmname 数据字典主表名称
* 获取业务编号*/
function getBillno(diclname,dicmname){
	var param = {},jsonObj={};
	param.diclname = diclname;
	param.dicmname = dicmname;
	$.ajax({  
        type: "POST", 
        async: false, 
        data: param,
        url: "BillnoSetting/getNewBillno.json",  
        success:function(obj){  
        	jsonObj= obj;
        }  
	}); 
	return jsonObj;
}

//绑定 Enter 键盘键
function BindEnter(obj)
{
    if(obj.keyCode == 13)
        {
    		obj.click();
            obj.returnValue = false;
        }
}

/**
 * @param val
 * @returns 
 * 处理空字符
 */
function dealNullString(val){
	if(val==null||val==undefined||val=="null"){
		return "";
	}
	return val;
}

function initprint(busitype){
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

function setPrintTemplateList(busitype){
	var tempcode="";
	var tempcodeArr=new Array('00','01','02','03','04','05');
	switch (busitype) {
	case 3:
		tempcodeArr=new Array('00','01','02','03','04','05');
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
function showException(obj,url){
	var errorMessage='';
	if(obj.exception.stackTrace.length>0){
		for(var i=0;i<obj.exception.stackTrace.length;i++){
			errorMessage+=(obj.exception.stackTrace[i].className+"."+obj.exception.stackTrace[i].methodName+":"+obj.exception.stackTrace[i].lineNumber+"<br>");
		}
	}
	$('#exceptionMesMain').remove();
	$('#exceptionMes').remove();
	$("body").append($("<input type='hidden' id='exceptionMesMain' value='"+obj.exception.message+"'>"));
	$("body").append($("<input type='hidden' id='exceptionMes' value='"+errorMessage+"'>"));
	window.parent.showMainPage(url,'请求出现错误',400,850);
}
//验证为数字、字母、下划线，长度为30
function CheckCode(str) {
    var flat = true;
    if (!str.match(/^[A-Za-z0-9_-]+$/))
        flat = false;
    if (str.length > 50)
        flat = false;
    return flat;
}