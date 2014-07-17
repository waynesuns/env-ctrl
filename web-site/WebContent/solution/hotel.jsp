<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="酒店及办公楼宇" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="以酒店和办公楼为代表的某些领域现阶段呈现出区域面积大、人数多、对空气质量要求高等三大特点；在早期的楼宇新风系统设计中，绝大部分新风系统知识加装了简单的初效过滤段，随着室外污染气体（以硫氧化物和氮氧化物为首）浓度的日益增长，去除新风中的有毒有害气体的需求显得更加迫切；针对此类项目，我们提出了系统的改造方案，即在不改变原有室内新风管道的前提下仅在新风机房增加气相过滤设备，在源头上去除污染气体以及PM2.5等颗粒物。" scope="request"/>

<c:set var="subItemSample1Title" value="迪拜塔" scope="request"/>
<c:set var="subItemSample1Info" value="迪拜塔作为全球最著名的的七星级酒店，在设计之初，如何保证室内空气品质就是一个极其充满挑战的设计；后经工程师们设计，新风在引入到室内前，经过DAS净化机组的过滤，考虑到七星级酒店客人对于空气品质的要求，DAS机组内置的媒体净化段设计为3级，并标配的了初效以及高效颗粒物过滤段，整套净化系统设计完成投入使用后，酒店内的每个房间所获得的新风内含的颗粒物浓度以及有害气体浓度均降至标准以下，为入住的客人带来了最好呼吸的空气。" scope="request"/>

<c:set var="subItemSample2Title" value="内华达州太浩湖海瑞斯赌场高层观光大厅" scope="request"/>
<c:set var="subItemSample2Info" value="大多数美国城市已禁止在酒吧和餐馆中吸烟。但吸烟者和非吸烟者是可以共存的：一个合理设计的过滤系统可以减少有害气体和颗粒物的排放，同时还能满足地方法律规章的要求。空气净化系统（A.P.S.）设计旨在去除由香烟雾释放的颗粒物和气相污染物。环境控制的目标是为高层观光大厅提供12ACH （换气次数每小时）风量的100%再循环空气，从而在烟雾集中区域有效去除ETS（环境烟草烟雾）同时使侧流（二手）烟雾对非吸烟者的影响降至最低。香烟雾是由颗粒物和气相污染物组成的特别复杂的混合物，因此它的处理必须经过不同尺度的过滤器。A.P.S.-1500空气净化系统通过一个HEPA（高效颗粒物捕获，95%）过滤器收集所有的颗粒物，再通过二阶媒体单元去除所有有害气体，其中包括香烟燃烧所释放的致癌物。" scope="request"/>

<c:set var="subItemSample3Title" value="北京富凯大厦" scope="request"/>
<c:set var="subItemSample3Info" value="北京富凯大厦（北京证监会办公所在地）原有自己一套独立的新风系统，大厦每层均设有独立的新风机房，该套新风系统设计时仅安装了G4级别的初效过滤段，随着北京空气情况的日益恶劣，该套系统已远不能为办公人员提供洁净的新风；后经工程师现场勘测后，提出了在原有新风主机后加装AG系列净化系统的方案，在保证风量风压不变并且不改动原有室内管道的前提下仅对新风机房的管路进行了改造，项目改造完成后，现场进行了颗粒物浓度的检测，出风口的颗粒物浓度均为个位数，大大提高了室内的空气品质。" scope="request"/>

<c:set var="subItemSample4Title" value="钓鱼台国宾馆" scope="request"/>
<c:set var="subItemSample4Info" value="一般来说，室内封闭环境空气质量要比室外空气质量差，尤其长时间使用空调的环境，各种污染更多。绝大多数的酒店客房是相对密闭的环境，只靠空调新风来调节空气。而我们传统的新风只有简单的针对毛发灰尘等大颗粒物的初效过滤器，对PM2.5颗粒物和各种气体污染的过滤几乎没有效果。而且酒店的相对密闭导致其装修污染物和各种生活异味很难快速散发，所以很多酒店在清洁房间后会喷洒香水来遮盖异味。而通过使用APG系列净化系统，能大大改善室内的空气质量，能去除包括各类装修污染物、PM2.5、从新风系统进来的室外汽车尾气甚至是前面住客留下的体味烟味等。" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>