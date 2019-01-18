var grid;
var mypage;

$(function() {
	init();
	$(".helpinfo").hover(
			function(){$(this).find(".tips").show();},
			function(){$(this).find(".tips").hide();});
	var productversion = $(parent.document).find("#productversion").val();
	if(productversion==1||productversion==3 || productversion == 51){
		$("[id$=_branch]").hide();
	} else {
		initBranchSelect('','branchid');
	}
	initProbationPeriodOptimization();
});

function initProbationPeriodOptimization(reduce){
	//试用期员工优化
	var productversion = $(parent.document).find("#productversion").val();
	var demo = $(parent.document).find("#loginType").val();
	if( demo != "demo" && (productversion == "1" || productversion == "2")){
		var isPay = $(parent.document).find("#isuserpay").val();
		var regDate = "2018-04-25";
		var startDate = $(parent.document).find("#startDate").val();
		//判断当前时间 是否 大于等于 开始时间
		var a = moment(startDate).isAfter(regDate);
		if(isPay == "false"){
			var UserCountSpan = $("#usercount").val();
			if(reduce != undefined){
				UserCountSpan = Number(UserCountSpan)-Number(reduce);
			}
			var PPAEmpCount = $(parent.document).find("#AllowEmpCountSpan").text();
			var contactid = $(parent.document).find("#contactid").val();
			var tiphtml = "您当前用户数为"+PPAEmpCount+",最多可添加"+PPAEmpCount+"个员工，目前已添加员工数为"+UserCountSpan+"，如需添加更多用户数，请联系客服("+$("#tel").val()+")";
			//a为真 则表示该用户是 发版之后注册的
			if(!a){
				var isShengchan = $("#isShengchan").val();
				if(isShengchan == "false"){
					tiphtml="您当前用户数为"+PPAEmpCount+",最多可添加"+PPAEmpCount+"个员工，" +
					"目前已添加员工数为"+UserCountSpan+"，" +
					"<a target='_blank' href='"+window.location.protocol+"//paytest.yingyuntech.com:7443/login/doinit.htm?contactid="+contactid+"'>点此添加更多用户数</a>。";
				}else{
					tiphtml="您当前用户数为"+PPAEmpCount+",最多可添加"+PPAEmpCount+"个员工，" +
					"目前已添加员工数为"+UserCountSpan+"，" +
					"<a target='_blank' href='"+window.location.protocol+"//pay.zhsmjxc.com/login/doinit.htm?contactid="+contactid+"'>点此添加更多用户数</a>。";
				}
			}
			
			/*if(UserCountSpan != undefined && String(UserCountSpan) != "" && PPAEmpCount != undefined && String(PPAEmpCount) != ""){
				if( Number(UserCountSpan) < Number(PPAEmpCount) ){
					var isShengchan = $("#isShengchan").val();
					if(isShengchan == "false"){
						tiphtml="您当前用户数为"+PPAEmpCount+",最多可添加"+PPAEmpCount+"个员工，" +
						"目前已添加员工数为"+UserCountSpan+"，" +
						"<a target='_blank' href='"+window.location.protocol+"//paytest.yingyuntech.com:7443/login/doinit.htm?contactid="+contactid+"'>点此添加更多用户数</a>。";
					}else{
						tiphtml="您当前用户数为"+PPAEmpCount+",最多可添加"+PPAEmpCount+"个员工，" +
						"目前已添加员工数为"+UserCountSpan+"，" +
						"<a target='_blank' href='"+window.location.protocol+"//pay.zhsmjxc.com/login/doinit.htm?contactid="+contactid+"'>点此添加更多用户数</a>。";
					}
				}
			}*/
			$("#ProbationPeriodTip").html(tiphtml);
			$("#ProbationPeriodTip").show();
		}
	}
}

function init() {
	var productversion = $(parent.document).find("#productversion").val();
	var demo = $(parent.document).find("#loginType").val();
	var page_colmodel=new Array();
	page_colmodel.push({
		display : '序号',
		name : 'no',
		width : '45',
		isNo : true,
		isReplaceHtml:true,
		replaceHtmlFunction : 'replaceHtml',
		customLineStyles:'customLineStylesFunction'
	});
	if('2'==productversion)
	{
		page_colmodel.push({
			display : '所属门店',
			name : 'branchname',
			sortable : false,
			align : 'left'
		});
	}
	page_colmodel.push({
		display : '用户名',
		name : 'userloginname',
		sortable : true,
		align : 'left'
	});
	page_colmodel.push({
		display : '员工姓名',
		name : 'username',
		sortable : true,
		align : 'left'
	});
	page_colmodel.push({
		display : '角色',
		name : 'rolename',
		align : 'left'
	});
	page_colmodel.push({
		display : '性别',
		name : 'usersex',
		width : '35',
		zero : '男',
		one : '女'
	});
	page_colmodel.push({
		display : '手机号',
		name : 'userphone',
		width : '100',
		align : 'left'
	});
	page_colmodel.push({
		display : '邮箱',
		name : 'useremail',
		width : '100',
		align : 'left'
	});
	page_colmodel.push({
		display : '状态',
		name : 'userstatus',
		width : '100'
	});
	page_colmodel.push({
		display : '地址',
		name : 'address',
		isNotHeader:true,
		width : '100',
		align : 'left'
	});
	page_colmodel.push({
		display : '操作',
		name : '',
		width : '100',
		sortable : false,
		align : 'center',
		isButton : true
	});
	
	var page_colmodel_detail=new Array();
	page_colmodel_detail.push({
		display : '员工姓名',
		name : 'username',
		isHeader:true,
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '用户名',
		name : 'userloginname',
		isHeader:true,
		isGeneral:true,
		align : 'left'
	});
	if('2'==productversion)
	{
		page_colmodel_detail.push({
			display : '所属门店',
			name : 'branchname',
			sortable : false,
			align : 'left'
		});
	}
	page_colmodel_detail.push({
		display : '角色',
		name : 'rolename',
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '地址',
		name : 'address',
		isWrap : true,
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '性别',
		name : 'usersex',
		width : '35',
		zero : '男',
		one : '女'
	});
	if('3'!=productversion)
	{
		page_colmodel_detail.push({
			display : '关联仓库',
			name : 'warehousename',
			width : '100',
			align : 'left'
		});
	}
	page_colmodel_detail.push({
		display : '价格权限',
		name : 'pricePrivilege',
		width : '100',
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '状态',
		name : 'userstatus',
		width : '100',
		isWrap : true
	});
	page_colmodel_detail.push({
		display : '手机号',
		name : 'userphone',
		width : '100',
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '查看他人单据',
		name : 'viewOtherorder',
		width : '100',
		isWrap : true,
		align : 'left'
	});
	if(productversion != 3){
		page_colmodel_detail.push({
			display : '作废他人单据',
			name : 'viewwirteback',
			width : '100',
			isWrap : true,
			align : 'left'
		});
	}
	if('51'==productversion || '1'==productversion || '2'==productversion){
		page_colmodel_detail.push({
			display : '查看他人客户',
			name : 'viewclient',
			width : '100',
			isWrap : true,
			align : 'left'
		});
	}
	
	page_colmodel_detail.push({
		display : '邮箱',
		name : 'useremail',
		width : '100',
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '查看其他门店库存',
		name : 'viewOtherwarehouse',
		width : '100',
		align : 'left'
	});
	page_colmodel_detail.push({
		display : '从其他门店调拨',
		name : 'allowOtherShopTran',
		width : '100',
		align : 'left'
	});
//	page_colmodel_detail.push({
//		display : '权限',
//		name : 'permflag',
//		width : '100',
//		align : 'left'
//	});
//	if(demo=="demo"){
//		var page_buttons = [ {
//			name : '详细',
//			bclass : 'operate details',
//			onpress : 'detailRecord'
//		}];
//	}else{
		var page_buttons = [ {
			name : '详细',
			bclass : 'operate details',
			onpress : 'detailRecord'
		},{
			name : '编辑',
			bclass : 'operate edit',
			onpress : 'editRecord',
			isHide : 'isHideEditButton'
		}, {
			name : '删除',
			bclass : 'operate del',
			onpress : 'deleteRecord',
			isHide : 'isHideButton'
		} ];
//	}
	
	var page = {
		id : "SysUser-page",		
		url : "SysUser/page.json",
		dataType : 'json',
		colModel : page_colmodel,
		colModel_Detail : page_colmodel_detail,
		buttons : page_buttons,
		sortname : 'CreateDate',
		sortorder : 'desc',
		usepager : true,
		useRp : true,
		rp : 10,
		showTableToggleBtn : false,
		width : 'auto',
		height : 'auto',
		setPageParams : 'getPageParams()',
		isEnableShowOrHide:false
	};
	myPage = page;
	$("#resultList").flexigrid(page);
	// DoMore();
}

function getPageParams() {
	return [ {
		name : 'SearchKeyWord',
		value : $("#SearchKeyWord").val()
	} ,{
		name : 'branchid',
		value : $("#branchid").length>0?$("#branchid").val():""
	}];
}

function isHideButton(i)
{
	var data=getData(i);
	var isShengchan = $("#isShengchan").val();
	//演示账号
//	if(isShengchan == "false"){//测试环境
//		//演示账号
//		if(		"1"==$("#isdemo").val() && (
//				/*"30A04079-ADDB-4F38-9F7B-E5ABF31EBDD4"==data.userid 
//				|| "FF32EA90-B1E8-4690-A728-EC5349CD276B"==data.userid || "9A2139F6-3F96-4557-8FB2-7D282DD9B152"==data.userid
//				|| "F7BC38AC-3B03-4844-8FC1-5AFBB00C7AD9"==data.userid || "6B89C14F-A576-4253-B8C9-26A789F28D80"==data.userid
//				|| "tihuanzhengshihuanjing"==data.userid 
//				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid
//				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid*/
//				"liansuoyanshi@126.com"==data.userloginname || "ceshiyanshi@126.com"==data.userloginname
//				|| "zhsm888"==data.userloginname || "zhsm8888"==data.userloginname
//				|| "zhsm666"==data.userloginname || "zhsm6666"==data.userloginname
//				|| "zhsmjxc66"==data.userloginname || "zhsmjxc6"==data.userloginname
//				|| "zhsmjxc88"==data.userloginname || "zhsmjxc8"==data.userloginname
//				
//				|| "13211113333"==data.userloginname || "yanjiu1"==data.userloginname || "yanjiu2"==data.userloginname || "yanjiu3"==data.userloginname
//				|| "13211112222"==data.userloginname || "jiadian1"==data.userloginname || "jiadian2"==data.userloginname || "jiadian3"==data.userloginname
//				|| "13333334444"==data.userloginname || "meizhuang1"==data.userloginname || "meizhuang2"==data.userloginname || "meizhuang3"==data.userloginname
//				|| "18188881122"==data.userloginname || "wenti1"==data.userloginname || "wenti2"==data.userloginname || "wenti3"==data.userloginname
//				|| "13133332222"==data.userloginname || "qixiu1"==data.userloginname || "qixiu2"==data.userloginname || "qixiu3"==data.userloginname
//				|| "13211114444"==data.userloginname || "qitahang1"==data.userloginname || "qitahang2"==data.userloginname || "qitahang3"==data.userloginname
//				
//				)
//		){
//			return true;
//		}
//	}else{//生产环境
		//演示账号
		if(		"1"==$("#isdemo").val() && (
				/*"30A04079-ADDB-4F38-9F7B-E5ABF31EBDD4"==data.userid 
				|| "FF32EA90-B1E8-4690-A728-EC5349CD276B"==data.userid || "9A2139F6-3F96-4557-8FB2-7D282DD9B152"==data.userid
				|| "F7BC38AC-3B03-4844-8FC1-5AFBB00C7AD9"==data.userid || "6B89C14F-A576-4253-B8C9-26A789F28D80"==data.userid
				|| "tihuanzhengshihuanjing"==data.userid 
				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid
				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid*/
				"liansuoyanshi@126.com"==data.userloginname || "ceshiyanshi@126.com"==data.userloginname
				|| "zhsm888"==data.userloginname || "zhsm8888"==data.userloginname
				|| "zhsm666"==data.userloginname || "zhsm6666"==data.userloginname
				|| "zhsmjxc66"==data.userloginname || "zhsmjxc6"==data.userloginname
				|| "zhsmjxc88"==data.userloginname || "zhsmjxc8"==data.userloginname
				
				|| "19282345678"==data.userloginname || "xiaoshou111"==data.userloginname || "caiwu111"==data.userloginname || "cangguan111"==data.userloginname
				|| "19292345678"==data.userloginname || "xiaoshou222"==data.userloginname || "caiwu222"==data.userloginname || "cangguan222"==data.userloginname
				|| "19262345678"==data.userloginname || "xiaoshou333"==data.userloginname || "caiwu333"==data.userloginname || "cangguan333"==data.userloginname
				|| "19272345678"==data.userloginname || "xiaoshou444"==data.userloginname || "caiwu444"==data.userloginname || "cangguan444"==data.userloginname
				|| "19242345678"==data.userloginname || "cw1234"==data.userloginname || "cgz1234"==data.userloginname || "xs1234"==data.userloginname
				|| "19252345678"==data.userloginname || "xiaoshou555"==data.userloginname || "caiwu555"==data.userloginname || "cangguan555"==data.userloginname
				|| "19212345676"==data.userloginname || "xiaoshou1003"==data.userloginname || "cangguan1003"==data.userloginname || "caiwu1002"==data.userloginname
				|| "19212345677"==data.userloginname || "youqian001"==data.userloginname || "youhuo001"==data.userloginname || "meili001"==data.userloginname
				|| "19212345670"==data.userloginname || "cw_0001"==data.userloginname || "cg_0001"==data.userloginname || "xs_0001"==data.userloginname
				|| "19212345671"==data.userloginname || "zhsmys10001"==data.userloginname || "zhsmys10002"==data.userloginname || "zhsmys10003"==data.userloginname
				|| "19212345672"==data.userloginname || "yingyunkenan"==data.userloginname || "yingyunxioahua"==data.userloginname || "yingyunxiaoli"==data.userloginname
				|| "19212345673"==data.userloginname || "murphy1"==data.userloginname || "murphy2"==data.userloginname || "murphy3"==data.userloginname
				|| "19212345674"==data.userloginname || "gzswckl111"==data.userloginname || "gzswckl222"==data.userloginname || "gzswckl333"==data.userloginname
				|| "19212345675"==data.userloginname || "jxfjxf"==data.userloginname || "zlzlzl"==data.userloginname || "zyyzyy"==data.userloginname
				|| "19212345678"==data.userloginname || "zhsm001"==data.userloginname || "zhsm002"==data.userloginname || "zhsm003"==data.userloginname
				|| "19212345679"==data.userloginname || "zhsm011"==data.userloginname || "zhsm022"==data.userloginname || "zhsm033"==data.userloginname
				|| "19222345678"==data.userloginname || "caiwuzu1"==data.userloginname || "cangguancaigou2"==data.userloginname || "xiaoshouzu3"==data.userloginname
				|| "19232345678"==data.userloginname || "yingyuncaiwu"==data.userloginname || "yingyuncangguan"==data.userloginname || "yingyunxiaoshou"==data.userloginname
				
				)
		){
			return true;
		}
//	}
	if($("#issys").val()==0||(data!=null&&data!=undefined&&data.isroot==1))
	{
		return true;
	}
}

function isHideEditButton(i){
	var data=getData(i);
	var isroot = $("#isroot").val();
	var isShengchan = $("#isShengchan").val();
//	if(isShengchan == "false"){//测试环境
//		//演示账号
//		if(		"1"==$("#isdemo").val() && (
//				/*"30A04079-ADDB-4F38-9F7B-E5ABF31EBDD4"==data.userid 
//				|| "FF32EA90-B1E8-4690-A728-EC5349CD276B"==data.userid || "9A2139F6-3F96-4557-8FB2-7D282DD9B152"==data.userid
//				|| "F7BC38AC-3B03-4844-8FC1-5AFBB00C7AD9"==data.userid || "6B89C14F-A576-4253-B8C9-26A789F28D80"==data.userid
//				|| "tihuanzhengshihuanjing"==data.userid 
//				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid
//				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid*/
//				"liansuoyanshi@126.com"==data.userloginname || "ceshiyanshi@126.com"==data.userloginname
//				|| "zhsm888"==data.userloginname || "zhsm8888"==data.userloginname
//				|| "zhsm666"==data.userloginname || "zhsm6666"==data.userloginname
//				|| "zhsmjxc66"==data.userloginname || "zhsmjxc6"==data.userloginname
//				|| "zhsmjxc88"==data.userloginname || "zhsmjxc8"==data.userloginname
//				
//				|| "13211113333"==data.userloginname || "yanjiu1"==data.userloginname || "yanjiu2"==data.userloginname || "yanjiu3"==data.userloginname
//				|| "13211112222"==data.userloginname || "jiadian1"==data.userloginname || "jiadian2"==data.userloginname || "jiadian3"==data.userloginname
//				|| "13333334444"==data.userloginname || "meizhuang1"==data.userloginname || "meizhuang2"==data.userloginname || "meizhuang3"==data.userloginname
//				|| "18188881122"==data.userloginname || "wenti1"==data.userloginname || "wenti2"==data.userloginname || "wenti3"==data.userloginname
//				|| "13133332222"==data.userloginname || "qixiu1"==data.userloginname || "qixiu2"==data.userloginname || "qixiu3"==data.userloginname
//				|| "13211114444"==data.userloginname || "qitahang1"==data.userloginname || "qitahang2"==data.userloginname || "qitahang3"==data.userloginname
//				
//				)
//		){
//			return true;
//		}
//	}else{//生产环境
		//演示账号
		if(		"1"==$("#isdemo").val() && (
				/*"30A04079-ADDB-4F38-9F7B-E5ABF31EBDD4"==data.userid 
				|| "FF32EA90-B1E8-4690-A728-EC5349CD276B"==data.userid || "9A2139F6-3F96-4557-8FB2-7D282DD9B152"==data.userid
				|| "F7BC38AC-3B03-4844-8FC1-5AFBB00C7AD9"==data.userid || "6B89C14F-A576-4253-B8C9-26A789F28D80"==data.userid
				|| "tihuanzhengshihuanjing"==data.userid 
				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid
				|| "tihuanzhengshihuanjing"==data.userid || "tihuanzhengshihuanjing"==data.userid*/
				"liansuoyanshi@126.com"==data.userloginname || "ceshiyanshi@126.com"==data.userloginname
				|| "zhsm888"==data.userloginname || "zhsm8888"==data.userloginname
				|| "zhsm666"==data.userloginname || "zhsm6666"==data.userloginname
				|| "zhsmjxc66"==data.userloginname || "zhsmjxc6"==data.userloginname
				|| "zhsmjxc88"==data.userloginname || "zhsmjxc8"==data.userloginname
				
				|| "19282345678"==data.userloginname || "xiaoshou111"==data.userloginname || "caiwu111"==data.userloginname || "cangguan111"==data.userloginname
				|| "19292345678"==data.userloginname || "xiaoshou222"==data.userloginname || "caiwu222"==data.userloginname || "cangguan222"==data.userloginname
				|| "19262345678"==data.userloginname || "xiaoshou333"==data.userloginname || "caiwu333"==data.userloginname || "cangguan333"==data.userloginname
				|| "19272345678"==data.userloginname || "xiaoshou444"==data.userloginname || "caiwu444"==data.userloginname || "cangguan444"==data.userloginname
				|| "19242345678"==data.userloginname || "cw1234"==data.userloginname || "cgz1234"==data.userloginname || "xs1234"==data.userloginname
				|| "19252345678"==data.userloginname || "xiaoshou555"==data.userloginname || "caiwu555"==data.userloginname || "cangguan555"==data.userloginname
				|| "19212345676"==data.userloginname || "xiaoshou1003"==data.userloginname || "cangguan1003"==data.userloginname || "caiwu1002"==data.userloginname
				|| "19212345677"==data.userloginname || "youqian001"==data.userloginname || "youhuo001"==data.userloginname || "meili001"==data.userloginname
				|| "19212345670"==data.userloginname || "cw_0001"==data.userloginname || "cg_0001"==data.userloginname || "xs_0001"==data.userloginname
				|| "19212345671"==data.userloginname || "zhsmys10001"==data.userloginname || "zhsmys10002"==data.userloginname || "zhsmys10003"==data.userloginname
				|| "19212345672"==data.userloginname || "yingyunkenan"==data.userloginname || "yingyunxioahua"==data.userloginname || "yingyunxiaoli"==data.userloginname
				|| "19212345673"==data.userloginname || "murphy1"==data.userloginname || "murphy2"==data.userloginname || "murphy3"==data.userloginname
				|| "19212345674"==data.userloginname || "gzswckl111"==data.userloginname || "gzswckl222"==data.userloginname || "gzswckl333"==data.userloginname
				|| "19212345675"==data.userloginname || "jxfjxf"==data.userloginname || "zlzlzl"==data.userloginname || "zyyzyy"==data.userloginname
				|| "19212345678"==data.userloginname || "zhsm001"==data.userloginname || "zhsm002"==data.userloginname || "zhsm003"==data.userloginname
				|| "19212345679"==data.userloginname || "zhsm011"==data.userloginname || "zhsm022"==data.userloginname || "zhsm033"==data.userloginname
				|| "19222345678"==data.userloginname || "caiwuzu1"==data.userloginname || "cangguancaigou2"==data.userloginname || "xiaoshouzu3"==data.userloginname
				|| "19232345678"==data.userloginname || "yingyuncaiwu"==data.userloginname || "yingyuncangguan"==data.userloginname || "yingyunxiaoshou"==data.userloginname
				|| "19292345679"==data.userloginname
				)
		){
			return true;
		}
//	}
	
	if(isroot!=1&&(data!=null&&data!=undefined&&data.isroot==1))
	{
		return true;
	}
}


function replaceText(i) {
	var data = getData(i);
	if (data!=null&&data!=undefined&&data.usersex == 0) {
		return "男";
	} else {
		return "女";
	}
}

function replaceHtml(i){
	var data = getData(i);
	if(data!=null&&data!=undefined&&data.isroot=="1"){
		if(data.isbindqywx){
			return "<div class='Corporate_Main_Account'></div>";
		}
		return "<div class='baseAcount'></div>";
	}
	if(data.isbindqywx){
		return "<div class='Corporate_WeChat_Account'></div>";
	}
	return "";
}

function deleteRecord(i){
	if(checkCurrentSob()){
		return;
	}
	var data=getData(i);
	if(data!=null&&data!=undefined&&data.isroot=="1"){
		showMsg("主账号不能删除");
		return;
	}
	deleteSel(data.userid);
	initProbationPeriodOptimization(1);
}

//跳转添加页
function goAdd() {
	if(checkCurrentSob()){
		return;
	}
	$.ajax({  
        type: "post",  
        url: "SysUser/checkUserCanAdd.json",  
        async:false,
        cache:false,    
	    dataType:'json',
        success:function(data){
        	if(data.isok=="1"){
        		var title = "新增员工";
            	var url = "SysUser/goAdd.htm?parent_tabid="+$("#tabid").val();
            	var id = "addUser";
            	parent.addTabByTitleAndUrl(title, url, id,'WBI');
        	} else {
        		var pv = $(parent.document).find("#productversion").val();
        		if(pv != 3){
        			showMsg("员工数量已达上限，如需添加请联系客服");	
        		}
        		if(pv == 3){
        			var title = "多员工管理";
                	var url = "FunctionalIntroduce/MoreSalesManIntroducePage.htm";
                	var id = "FunctionalIntroduce-MoreSalesManIntroducePage";
                	parent.addTabByTitleAndUrl(title, url, id,'WBI');
        		}
        	}
        }
    });
}

//跳转添加页
function editRecord(i) {
	if(checkCurrentSob()){
		return;
	}
	var data=getData(i);
	var title = "编辑员工";
	var url = "SysUser/goAdd.htm?id="+data.userid+"&parent_tabid="+$("#tabid").val();
	var id = "editUser";
	parent.addTabByTitleAndUrl(title, url, id,'WBI',true);
}


//保存
/*function doSave() {
	var param = {};
	param["SysUserId"] = $("#SysUserId").val();
	param["userloginname"] = $("#userloginname").val();
	param["username"] = $("#username").val();
	param["usersex"] = $("input[name='usersex']:checked").val();
	param["userpassword"] = $("#userpassword").val();
	param["branchid"] = $("input[name='branchid']:checked").val();
	
	param["userphone"] = $("#userphone").val();
	param["useremail"] = $("#useremail").val();
	param["address"] = $("#address").val();
	param["userstatus"] = $("input[name='userstatus']:checked").val();
}*/

function customLineStylesFunction(i)
{
	var data=getData(i);
	if(data.userstatus=='锁定')
	{
		return "cancellation";
	}
	else
	{
		return "";
	}
}
