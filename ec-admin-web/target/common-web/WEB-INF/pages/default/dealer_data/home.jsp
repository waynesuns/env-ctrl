<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/include/taglib.jsp"%>
<jsp:include page="script.jsp" />
<div class="right">
	<div class="right_c">
		<h1>
			<fmt:message key="basic.data.management" />>><a href="dealer_msater_data/show/home.do"><fmt:message key="dealer.master.data" /></a>
		</h1>
		<div id="">
			<table width="770" class="table2" border="0" cellspacing="0"
				cellpadding="0">
				<tr style="width: 770px;">
					<td width="75" align="left"><fmt:message key="common.colon"><fmt:param><fmt:message key="common.brand"/></fmt:param></fmt:message>
					</td>
					<td width="155"><select id="brandId_search" onchange="getDealerArea('search')" name="brandId" style="width: 143px;">
							<option value="" selected="selected"> <fmt:message key="common.all" /></option>
					</select>
					</td>
					<td width="95" align="left"><fmt:message key="common.colon"><fmt:param>
					<fmt:message key="dealer.dealer.area" /></fmt:param></fmt:message> </td>
					<td width="155"><select id="dealerAreaId_search" onchange="getProvince('search')" name="dealerAreaId" style="width: 150px;">
							<option value="" selected="selected">
								<fmt:message key="common.all" />
							</option>
					</select>
					</td>
					<td width="75" align="left"><fmt:message key="common.colon"><fmt:param>
					<fmt:message key="common.province" /></fmt:param></fmt:message></td>
					<td width="155"><select id="provinceId_search" onchange="getCity('search')" name="provinceId" style="width: 150px;">
							<option value="" selected="selected">
								<fmt:message key="common.all" />
							</option>
					</select>
					</td>
				</tr>
				<tr>
					<td align="left"><fmt:message key="common.colon"><fmt:param><fmt:message key="common.city" /></fmt:param></fmt:message></td>
					<td><select id="cityId_search" name="cityId" style="width: 143px;">
							<option value="" selected="selected">
								<fmt:message key="common.all" />
							</option>
					</select>
					</td>
					<td align="left"><fmt:message key="common.colon"><fmt:param><fmt:message key="transport.dealer.code" /></fmt:param></fmt:message>
					</td>
					<td>
						<input type="text" name="dealerCode_search" onblur="this.value=$.trim(this.value);" style="width: 140px;" id="dealerCode_search" value="">
					</td>
					<td align="left"><fmt:message key="common.colon"><fmt:param><fmt:message key="dealer.export.dealername" /></fmt:param></fmt:message>
					</td>
					<td>
						<input type="text" name="dealerName_search"   onblur="this.value=$.trim(this.value);" style="width: 140px;" id="dealerName_search" value="">
					</td>
				</tr>
				<tr>
					<td align="left"><fmt:message key="common.colon"><fmt:param><fmt:message key="dealer.property" /></fmt:param></fmt:message>
					</td>
					<td>
						<select id="categoriesId_search" name="categoriesId" multiple="multiple" style="width: 143px;">
						</select>
					</td>
					
					<td align="left"><fmt:message key="common.colon"><fmt:param><fmt:message key="order.verify.config.sendto_subdealer" /></fmt:param></fmt:message>
					</td>
					<td>
						<select id="sendToSubDealer_search" name="sendToSubDealer" style="width: 150px;">
							<option value="" selected="selected">
								<fmt:message key="common.all" />
							</option>
							<option value="true">
								<fmt:message key="common.yes" />
							</option>
							<option value="no">
								<fmt:message key="common.no" />
							</option>
						</select>
					</td>
				</tr>
			</table>
			<div class="cl"></div>
			<div class="bb1 mt5 mb10"></div>
		</div>
		<div class="r">
			<div>
				<div class="r" style="width: 65px; height: 27px; display: inline-block; overflow: hidden; position: relative">
					<form id="uploadForm" action="<c:url value='/dealer_msater_data/import.do' />" method="post">
						<input
							style="width: 65px; height: 27px; position: absolute; top: 0; left: 0; z-index: 22; filter: alpha(opacity :   0); opacity: 0;"
							class="cursor" name="files" onclick="this.form.reset();" 
							onchange="importFile(this);" type="file" /> <input type="button"
							id="btn_id" style="margin-right: 0" class="btn1 cursor"
							value='<fmt:message key="btn.import"/>' />
					</form>
				</div> 
				<form action="<c:url value='/dealer_msater_data/export.do' />" method="post" id="exportForm" class="r">
					<input type="hidden" name="brandId" />
					<input type="hidden" name="dealerAreaId" />
					<input type="hidden" name="provinceId" />
					<input type="hidden" name="cityId" />
					<input type="hidden" name="dealerCode" />
					<input type="hidden" name="dealerName" />
					<input type="hidden" name="categoriesId" />
					<input type="hidden" name="sendToSubDealer" />
					<input type="button" class="btn1 cursor" value='<fmt:message key="btn.export"/>' onclick="exportFile();" />
				</form>
				<input class="btn1 ml5 cursor" style="float: right;" onclick="searchTrans()" type="button" value="查询" />
			</div>
		</div>
		<table id="dealer_table" style="display: none;" width="100%" class="table1" border="0" cellspacing="0" cellpadding="0">
			<thead>
				<tr>
					<th><fmt:message key="dealer.dealer.area" /></th>
					<th><fmt:message key="common.province" /></th>
					<th><fmt:message key="common.city" /></th>
					<th><fmt:message key="transport.dealer.code" /></th>
					<th><fmt:message key="transport.dealer.name" /></th>
					<th><fmt:message key="dealer.export.zipcode" /></th>
					<!-- <th>区号</th>
					<th>国家</th> -->
					<th><fmt:message key="dealer.export.delivery_person" /></th>
					<th><fmt:message key="dealer.export.delivery_phone_no" /></th>
					<th><fmt:message key="dealer.export.delivery_address" /></th>
					<th><fmt:message key="dealer.property" /></th>
					<th><fmt:message key="dealer.export.dealer.manager" /></th>
					<th><fmt:message key="dealer.export.dealer.manager.phone.no" /></th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div class="cl"></div>
</div>
