/**
 * @param tableId     		操作的table的id
 * @param dataTable	  	    dataTable对象
 * @param hideColumns		数组,要隐藏的列的索引
 * @param oSettings
 * @param tableDrawFlag     存放已经合并过的页码数组
 * 
 * 后台json 封装key = rowSpanFlag ； value = 需要鉴别数据的不同
 */
function drawTable(tableId,currentTable,hideColumns,oSettings,tableDrawFlag){
	//每页从开始的索引号
	var idisplayStart = oSettings._iDisplayStart;
	//每页显示的数目
	var iDisplayLength = oSettings._iDisplayLength;
	if(currentTable==null||tableDrawFlag[idisplayStart]==1)
		return ;
	// 获取dataTable数据JSON
	var aaData = currentTable.DataTable.settings[0].aoData;
	if(aaData=="")
		return;
	
	tableDrawFlag[idisplayStart] = 1;
	var trs = $('#'+tableId).find('tbody').find('tr'); 
	var nextId;
	var currentId;
	var rowspan = 1;
	var rowIndex = 0; 
	for(var i=0;i<iDisplayLength;i++){
		var currentJsonIndex = idisplayStart+i;
		if(currentJsonIndex==aaData.length)
			break;
		currentId = aaData[currentJsonIndex]._aData.rowSpanFlag;
		if(i+1!=iDisplayLength&&aaData[currentJsonIndex+1]!=null)
			nextId = aaData[currentJsonIndex+1]._aData.rowSpanFlag;
		else
			nextId = "";
		if((currentId!=nextId||nextId=="")&&rowspan>1){
			var tds = $(trs[rowIndex]).find('td');
			// 给列加上跨行属性 
			for(var index in hideColumns)
				$(tds[hideColumns[index]]).attr("rowSpan",rowspan);
			
			for(var j=1;j<rowspan;j++){
				var deTds = $(trs[rowIndex+j]).find('td');
				for(var index in hideColumns)
					$(deTds[hideColumns[index]]).remove();
			}
			rowIndex = i;
			rowspan = 1;
		}
		if(currentId==nextId)
			rowspan++;
		else
			rowIndex++;
	}
	javascript:scroll(0,0);
}