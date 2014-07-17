<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="化工" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="化工行业包含化工、炼油、冶金、能源、轻工、医药等多个领域，不同类型的化工领域特征污染物不同，按照污染物存在的形态，化工废气可分为颗粒污染物和气态污染物，颗粒污染物包括粉尘、烟尘、雾尘、煤尘等；气态污染物包括含硫化合物、含氯化合物、碳氧化合物、碳氢化合物、卤氧化合物等。这些污染物大多都有刺激性或腐蚀性，会直接损害人体健康，并腐蚀控制设备的表面；EC提出的空气净化方案除了能解决常见的颗粒物过滤外，还能利用其专业的气相媒体过滤段有效的去除多种有害气体，从而为客户提供真正意义上洁净的空气。" scope="request"/>

<c:set var="subItemSample1Title" value="印度尼西亚安达兰纸浆造纸厂" scope="request"/>
<c:set var="subItemSample1Info" value="安达兰纸浆造纸厂生产设备多，造成了周边污染气体浓度居高不下，尤其是与生产车间相距不远的办公室区域，我们的工程师在现场勘测完以后提出了采用DAS系列进行净化的方案，分别在每栋办公大楼的新风机房内加装一台30000m³/h的DAS机组，这种设计的优势在于可以将新风机组引入的新风进行气相媒体段的净化，从而将新风里污染气体的浓度降到最低值，颗粒物的浓度更是降低至个位数级别。" scope="request"/>

<c:set var="subItemSample2Title" value="扬子石化－巴斯夫" scope="request"/>
<c:set var="subItemSample2Info" value="扬子石化－巴斯夫有限责任公司属于世界五百强企业，其主要生产线通过裂解生产乙烯，由于在蒸汽裂解过程中易产生苯系有机物、其他烃类化合物以及氮化物和硫化物，多种有害物质随排风系统排放到大气中，严重影响了办公区域以及设备间的空气质量；该项目后经过工程师量身设计，为其控制室、设备间、马达室选用DAS（卧式深床气相净化系统）系列机型。该机组投入使用后，极大的降低了室外引进的新风中的VOC（挥发性有机物）和颗粒物浓度，改善了室内空气品质。对系统进行预定周期的检测后证实，原先12个月的设计使用周期在不更换媒体条件下仍可延长3个月。根据美国仪表学会的标准71.04，相关监测报告确认受保护区域的环境始终维持在G1水平。" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>