var Record={};
Record.getWarehouse = function (warehouseid) {
	var record=null;
	var url = window.location.protocol+"//" + window.location.host+ "/UCenter-webapp/Warehouse/GetRecord.json";
	var param={};
	param["warehouseid"]=warehouseid;
	$.YY_post(url, param, function(result, resultState) {
		if (resultState == "success") {
			record=result.record;
		} else {
		}
	},
	null,
	null,
	null,
	false
	);
	return record;
};