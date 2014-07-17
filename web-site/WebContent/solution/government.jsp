<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- content start -->
<c:set var="headerPicName" value="solution.jpg" scope="request"/>
<c:set var="subItems" scope="request">
	概览:solution/overview.html,化工:solution/chemica.html,医疗:solution/healthcare.html,市政:solution/government.html,军队:solution/army.html,住宅:solution/residence.html,场馆及院校:solution/venues.html,酒店及办公楼宇:solution/hotel.html
</c:set>
<c:set var="activeSubItem" value="市政" scope="request"/>
<c:set var="subItemTitle" value="领域应用及解决方案" scope="request"/>
<c:set var="subItemHeaderImgInfo" value="多年来，EC为多个行业的代表性公司提供了解决方案并在项目的实际运行中取得了良好的净化效果。" scope="request"/>
<c:set var="subItemInfo" value="市政工程主要指的是城市生活配套的各种公共基础设施建设，主要包括市政污水泵站、垃圾填埋场、隧道、大型车站等；这些公共基础设施在给人们带来生活保障的同时也难免会产生一系列的环境污染问题，例如异味气体（以H2S为例）、高浓度腐蚀性气体（以SO2为例），针对此类污染问题，EC提出了利用高浓度干式洗涤塔去除有毒有害气体的解决方案。干式洗涤塔将有效地消除污染物达到检测不到的水平。值得一提是，此方案维护工作量小，每年只需要更换维护即可,而无需传统湿式洗涤器复杂且频繁的维修程序。" scope="request"/>

<c:set var="subItemSample1Title" value="蒙特利尔国际机场" scope="request"/>
<c:set var="subItemSample1Info" value="蒙特利尔国际机场办公大楼内有1800名员工，该大楼原有设计中已含新风系统，但该大楼距机场跑道仅数十米，大楼完工后不断有员工反映在办公区域内部可以闻到飞机柴油的味道，经工程师设计后，机场办公大楼总流量为324000CFM的气流经过DAS系统的两个并联处理部分，分别为建筑供应180000CFM和144000CFM的清洁空气。总重为80000 lb.的Multi-Mix媒体内置于系统以保证空气品质等级。通过DAS机组净化后有效的降低了室内颗粒物的浓度和有害的室内污染气体浓度。" scope="request"/>

<c:set var="subItemSample2Title" value="迪拜隧道" scope="request"/>
<c:set var="subItemSample2Info" value="隧道在设计之初仅考虑了内部的通风设计，运营一段时间后，由于内部人数多，呼出的二氧化碳浓度持续走高，再加上挥发性有机物的浓度逐渐上升，单靠通风系统难以将隧道内部的污染气体浓度进行降低，后经我们的工程师推荐采用了APS小型净化机组系列，其主要作用是对通风后的隧道内空气进行一个内循环过滤净化，能够有效的降低VOCs的浓度，系统安装投入使用后，隧道内部空气质量大为好转，保证了隧道内部人员的呼吸健康。" scope="request"/>

<c:set var="subItemSample3Title" value="上海市浦东污水泵站" scope="request"/>
<c:set var="subItemSample3Info" value="上海浦东污水泵站位于上海外环线处，近期规模为8000m³/d,远景设计规模可达10000m³/d；由于泵站紧邻居民楼（相距仅数十米），运行中产生的大量恶臭气体对周边环境带来了极大的影响，为了完善该污水泵站功能，创造良好的生活工作环境，改建泵站除臭工程势在必行。在此之前，泵站曾经采用雾化除臭工艺，但由于臭气处理工艺不完善，总体处理效果远远低于预期，目前该除臭工艺已停用，泵站产生的臭气只能通过风机引入约8米的高空直接排放。直到选用HDS系列机组净化后，效果显著，恶臭气体浓度大大减小。" scope="request"/>

<c:set var="subItemSamplePicName" value="chemica.jpg" scope="request"/>

<c:import url="/template/subitem.jsp"/>