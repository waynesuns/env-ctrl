<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="场馆及院校" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="院校和场馆属于人流比较集中的区域，其内部空气污染物浓度过高时人容易产生疲劳和易怒，这些区域的通风系统设计的原则在是能应对一切可能的室外空气质量问题的同时，以最小的运行费用为室内环境提供合适的空气质量。EC针对此类区域提出了专业气相净化方案，能够有效的去除空气中的硫氧化物、氮氧化物、烃类和挥发性有机物。" scope="request"/>

<c:set var="subItemSample1Title" value="乔治布什总统图书馆博物院" scope="request"/>
<c:set var="subItemSample1Info" value="德克萨斯州大学城乔治布什图书馆内藏有大量的珍贵文献，但由于室内酸性氧化物的浓度日益增大，对文献的腐蚀呈愈演愈烈之势，后经工程师们设计，媒体采用了特别设计的一种组合：高锰酸钾加上活性炭。Multi-Mix® Media（MM-1355）组合媒体经特殊处理，内置于一个二阶媒体单元系统。这种二阶式设计使乔治布什总统图书馆博物院的室外空气污染物在设备内滞留时间达到0.2秒，因此能彻底去除氮氧化物（NOX），硫氧化物（SOX）,臭氧（O3）和总烃在内的所有室外有害气体。效率达90%的终过滤器集成于USAH空气净化系统，作为对颗粒物的终端去除。所有已安装的过滤器具有UL等级I标准。无论物理过滤器、化学媒体还是化学媒体容纳单元都具有UL等级I认可的防火和不燃特性。" scope="request"/>

<c:set var="subItemSample2Title" value="佛罗里达州迈阿密市戴德郡学校" scope="request"/>
<c:set var="subItemSample2Info" value="戴德郡小学原有的通风系统设计中设计了新风系统，但该新风系统只能过滤大颗粒物，室外的气体污染物随新风进入室内，再加上室内人数较多，且前期装饰过程中产生的化学物质逐渐开始散发出来，多种因素造成室内空气质量大幅度下降，前期只能通过加大新风量的置换来缓解这种状况，后加装了APS-400机组进行过滤再循环后，达到了设计者预期的污染物过滤要求并使总新风量减少了大约50%，新风量的减少也意味着每年用于制冷的能量也显著减小。" scope="request"/>

<c:set var="subItemSample3Title" value="" scope="request"/>
<c:set var="subItemSample3Info" value="" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>