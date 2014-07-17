<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="医疗" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="呼吸道感染、泌尿感染和肠胃道感染是医院感染部位的前三甲，呼吸道感染首当其冲。医院空气污染带来的感染难以防范又不易察觉，医院又是病菌的集散地，悬浮在空气中的PM2.5更是病菌的生生不息的乐土，这对于病人来说简直是“雪上加霜”。除此之外，医疗行业大量使用福尔马林（甲醛溶液）作为防腐消毒剂，甲醛不仅会带来刺鼻性气味且其本身属于有毒有害物质。气相媒体滤料MM-1000主要成分是高锰酸钾浸渍活性氧化铝和活性炭，能够有效的去除甲醛等有毒有害气体，同时配备的HEPA13级别的高效过滤段能够使颗粒物的去除率达到99.99%，全面满足医院空气污染治理需求。" scope="request"/>

<c:set var="subItemSample1Title" value="美国内华达州里诺市肖沃医疗中心" scope="request"/>
<c:set var="subItemSample1Info" value="美国内华达州里诺市肖沃医疗中心为解决空气污染问题，经工程师们推荐后选择了APS（小型室内净化机组）,安装后的APS分布于各个科室的吊顶空间内，经过内循环过滤净化，有效的去除了颗粒物以及污染气体；且APS在安装的过程中充分考虑了原有的室内空间，将立式与卧式两款机型与现场条件相匹配，营造一个最佳的设计与安装效果。" scope="request"/>

<c:set var="subItemSample2Title" value="多伦多法医病理实验室" scope="request"/>
<c:set var="subItemSample2Info" value="多伦多法医病理实验室由解剖室、尸体贮藏室、其它各种实验室、私人办公室和办公厅组成。未处理和已处理的腐烂尸体产生的异味以及有害气体严重影响了办公人员的身体健康；通过选用A.P.S.（小型气相净化机组）净化后，病理实验室室内的空气品质得到极大的改善，腐烂尸体的异味得到了有效的控制，整个实验室内的甲醛浓度也降到了室内标准值以下。" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>