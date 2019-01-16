/**
 * 过滤停用套餐
 */
function filterDisableProductPT()
{
	return;
	var ptstate=null;
	var productdetailtype=null;
	var obj=null;
	var count=0;
	$(".productptdiv :visible").each(function()
	{
		ptstate=$(this).attr("ptstate");
		productdetailtype=$(this).attr("productdetailtype");
		if('0'==ptstate && '1'==productdetailtype)
		{
			count++;
			obj=$(this).parent().parent().parent().parent().find(".delLite");
			removerow(obj);
			addrow();
		}
	});
	initorder();
	if(count!=0)
	{
		var title="友情提醒";
		var content="原单中存在的商品套餐已停用，系统已自动剔除。";
		parent.layer.alert(
			content, 
			{
				title: [title, 'font-weight: bolder;']
			}
		);
	}
}
/**
 * 过滤停用商品
 */
function filterDisabledProduct(notTitle)
{
	var productversion = parent.$("#productversion").val();
	var result = {};//结果
	var productstate=null;
	$(".spanproductname").each(function(){
		productstate=$(this).attr("productstate");
		ptstate = $(this).attr("ptstate");
		var productdetailtype=$(this).attr("productdetailtype");
		//商品停用
		if(productdetailtype=="0" && undefined != productstate && productstate!="" && '0' == productstate)
		{
			result.hasdisabled = 1;
			$(this).addClass("fontRed filterError");
			if(1!=notTitle)
				$(this).attr("title","该商品已停用，请删除");
		}
		//套餐停用
		if(productversion == "51"){
			if(productdetailtype=="1" && undefined != productstate && productstate!=""  && '1' != productstate){
				result.hasdisabled = 1;
				$(this).addClass("fontRed filterError");
				//标记名称置红的原因是：已被停用
				$(this).attr("productNameRedType", "isstop");
				
				if(1!=notTitle){
					if('0' == productstate){
						$(this).attr("title","该套餐已停用，请删除");
					}
					if('2' == productstate){
						$(this).attr("title","该套餐未开始，请删除");
					}
					if('3' == productstate){
						$(this).attr("title","该套餐已过期，请删除");
					}
				}
			}
		}else{
			if(productdetailtype=="1" && undefined != productstate && productstate!=""  && ('0' == String(ptstate) || '1' != productstate )){
				result.hasdisabled = 1;
				$(this).addClass("fontRed filterError");
				//标记名称置红的原因是：已被停用
				$(this).attr("productNameRedType", "isstop");
				
				if(1!=notTitle){
					if('0' == ptstate){
						$(this).attr("title","该套餐已停用，请删除");
					}
					if('0' == productstate){
						$(this).attr("title","该套餐已停用，请删除");
					}
					if('2' == productstate){
						$(this).attr("title","该套餐未开始，请删除");
					}
					if('3' == productstate){
						$(this).attr("title","该套餐已过期，请删除");
					}
				}
			}
		}
		
	});
	return result;
}
/**
 * 过滤删除商品
 */
function filterIsdelProduct(){
	var isdel=null;
	$(".spanproductname").each(function()
	{
		isdel=$(this).attr("isdel");
		//商品停用
		if(undefined != isdel && '1' == isdel)
		{
			$(this).addClass("fontRed filterError").attr("title","该商品已被删除，请从列表移除");
		}
	});
}
/**
 * 过滤异常
 */
function filterError()
{
	var pagebusinessname=$("#pagebusinessname").val();
	var content=null;
	var title=null;
	if('transfers'==pagebusinessname)
	{
		title="调拨商品存在异常";
		content="调拨商品存在异常（调拨单列表中已标红），请根据标红提示修改后继续调拨";
	}
	if('assembly'==pagebusinessname)
	{
		title="组装拆卸商品存在异常";
		content="组装拆卸存在异常（组装拆卸单列表中已标红），请根据标红提示修改后继续组装拆卸";
	}
	if('buy'==pagebusinessname)
	{
		title="进货商品存在异常";
		content="进货存在异常（进货单列表中已标红），请根据标红提示修改后继续进货";
	}
	if('sale'==pagebusinessname)
	{
		title="销售商品存在异常";
		content="销售存在异常（销售单列表中已标红），请根据标红提示修改后继续销售";
	}
	if('salereturn'==pagebusinessname)
	{
		title="销售退货商品存在异常";
		content="销售退货存在异常（销售退货单列表中已标红），请根据标红提示修改后继续销售退货";
	}
	if('SaleReturn-CopyAdd'==pagebusinessname)
	{
		title="进货退货商品存在异常";
		content="进货退货存在异常（进货货单列表中已标红），请根据标红提示修改后继续进货退货";
	}
	if('buyorder'==pagebusinessname)
	{
		title="进货订单商品存在异常";
		content="进货订单存在异常（进货订单列表中已标红），请根据标红提示修改后继续进货";
	}
	if('saleorder'==pagebusinessname)
	{
		title="销售订单商品存在异常";
		content="销售订单存在异常（销售订单列表中已标红），请根据标红提示修改后继续销售";
	}
	if('invtak'==pagebusinessname)
	{
		title="盘点单商品存在异常";
		content="盘点单存在异常（盘点单列表中已标红），请根据标红提示修改后继续盘点";
	}
	if('borrow-buy'==pagebusinessname)
	{
		title="借入转进货商品存在异常";
		content="借入转进货单存在异常（借入转进货列表中已标红），请根据标红提示修改后继续进货";
	}
	if('lend-sale'==pagebusinessname)
	{
		title="借出转销售商品存在异常";
		content="借出转销售单存在异常（借出转销售列表中已标红），请根据标红提示修改后继续销售";
	}
	if('lend-return'==pagebusinessname)
	{
		title="归还单商品存在异常";
		content="归还单存在异常（归还列表中已标红），请根据标红提示修改后继续归还";
	}
	if('order-buy'==pagebusinessname)
	{
		title="订单转进货商品存在异常";
		content="订单转进货单存在异常（订单转进货列表中已标红），请根据标红提示修改后继续进货";
	}
	if('order-sale'==pagebusinessname)
	{
		title="订单转销售商品存在异常";
		content="订单转销售单存在异常（订单转销售列表中已标红），请根据标红提示修改后继续销售";
	}
	if('orderPlusManagerShopOrder-receOrder'==pagebusinessname)
	{
		title="网店订单接单存在异常";
		content="标红商品（名称）已停用，请启用商品后再接单";
	}
	var flag=true;
	var length=$(".filterError").length;
	if(0!=length)
	{
		parent.layer.alert(
		content, 
		{
			title: [title, 'font-weight: bolder;'],
			btn: ['修改']
		}
		);
		flag=false;
	}
	return flag;
}


//过滤无权限仓库
function filterNoPermWarehouse(){
	var isHavaNoPermWarehouse=false;
	$("#tabdetail tr:gt(0)").each(function(){
		var productid = $(this).find("input[name='hidProductId']").val();
		if (typeof (productid) != 'undefined' && productid != '') {
	
			var warehouseid=$(this).find("input[name='hiddetailwarehouseid']").val();
			//alert($("#warehouseDropList .droplist div[data-value='"+warehouseid+"']"));
			
			if(warehouseid!=""&&$("#warehouseDropList .droplist div[data-value='"+warehouseid+"']").val()==undefined){
				isHavaNoPermWarehouse=true;
				$(this).find("input[name='hiddetailwarehouseid']").val("");
				$(this).find("input[name='txbWarehouse']").val("");
	
			}
		}
	});
	var isAdmin = parent.$("#isAdminRole").val();
	if(isHavaNoPermWarehouse && "true"!=isAdmin){
		showSuccessMsg("无权限仓库已经帮您过滤，请重新选择出库仓库");
		return isHavaNoPermWarehouse;
	}
	return isHavaNoPermWarehouse;
}