<%@ page language="java" contentType="text/html; charset=utf-8"

    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() 
            + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="keywords" content="杰普软件(www.briup.com)" />
<meta name="description" content="杰普软件(www.briup.com)" />
<title>杰普――跑步社区</title>
<link rel="stylesheet" type="text/css" id="css" href="style/main.css" />
<link rel="stylesheet" type="text/css" id="css" href="style/style1.css" />
<style type="text/css">
<!--
table{border-spacing:1px; border:1px solid #A2C0DA;}
td, th{padding:2px 5px;border-collapse:collapse;text-align:center; font-weight:normal;}
thead tr th{background:#FFFFFF;border:1px solid white; height:40px}
thead tr th.line1{background:#D3E5FD;}
thead tr th.line4{background:#C6C6C6;}
tbody tr td{height:35px;background:#CBE2FB;border:1px solid white; vertical-align:middle;}
tbody tr td.line4{background:#D5D6D8;}
tbody tr th{height:35px;background: #DFEDFF;border:1px solid white; vertical-align:middle;}
tfoot tr td{height:35px;background:#F5F5F5;border:1px solid white; vertical-align:middle; text-align:center}
-->
</style>
<script src="js/main.js" type="text/javascript"></script>
</head>
<body>
<div id="btm">
<div id="main">

  <div id="header">
    <div id="top"></div>
    <div id="logo">
      <h1>跑步社区</h1></div>
	  <div id="logout">
	<a href="login.html">注  销</a> | 收  藏
	 </div>
    <div id="mainnav">
      <ul>
      <li><a href="activity.html">首页</a></li>
      <li><a href="other/musicrun.html">音乐跑不停</a></li>
      <li><a href="other/equip.html">跑步装备库</a></li>
      <li><a href="other/guide.html">专业跑步指南</a></li>
      <li><a href="other/bbs.html">跑步论坛</a></li>
	
      </ul>
      <span></span>
    </div>
   </div>
  
  <div id="content" align="center">
     
     <div id="center">
       
		<form action="result_Flow.htm" method="post" name="form1">
			<table width="600">
				<thead>
					<tr>
						<th><h4>个性化空间</h4></th>
					</tr>
				</thead>
				<tr>
					<td width="100%">
						<table width="100%">
							<tbody>
							<tr>
								<td rowspan="5" width="30%" class="line4">
									<img src="upload/f9cbbd096b63f624ca2e94088" alt=Face width="84" height="84" ></td>
								<th width="25%" class="line1">
									昵称
								</th>
								<td width="45%">
									${nickname}
								</td>
							</tr>
							
							<tr>
								<th class="line1">
									性别
								</th>
								<td>
									${memberspace.getMemberinfo().getGender()}
								</td>
							</tr>
							<tr>
								<th class="line1">
									积分
								</th>
								<td>
									${memberspace.getMemberinfo().getPoint()}
								</td>
							</tr>
							<tr>
								<th class="line1">
									等级
								</th>
								<td>
									<c:if test="${memberspace.getMemberinfo().getGradeid() eq '1'}">
                                        		业余爱好者
		                                    </c:if>
		                                    <c:if test="${memberspace.getMemberinfo().getGradeid() eq '2'}">
		                                      	  跑步小将  
		                                    </c:if>
		                                    <c:if test="${memberspace.getMemberinfo().getGradeid() eq '3'}">
		                                                                                   跑步健将
		                                    </c:if>
		                                     <c:if test="${memberspace.getMemberinfo().getGradeid() eq '4'}">
		                                                                                 专业运动员
		                                    </c:if>
		                                     <c:if test="${memberspace.getMemberinfo().getGradeid() eq '5'}">
		                                                                                 顶级运动员
		                                    </c:if>
								</td>
							</tr>
							<tr>
								<th class="line1">
									来自
								</th>
								<td>
									${memberspace.getMemberinfo().getProvincecity()}
								</td>
							</tr>
							<tr>
								<th class="line1">
									跑步习惯与主张
								</th>
								<td colspan="2" height="90">
									<span >&nbsp;&nbsp;&nbsp;
										<!-- 清晨，喜欢一个人在操场上跑步，最喜欢体育明星是刘翔。
										愿意成为我的跑友者请与我(13900000000)联系。
											本人对跑步的主张是：生命在于运动！ -->
											${memberspace.getRunstar()}${memberspace.getRuntime()}${memberspace.getRunplace()}
									</span>
								</td>
							</tr>
							</tbody>
							<tfoot>
							<tr>
								<td colspan="3">
									<input type="button" value="修改"
										onclick="location.href='createSpace1.action?nickname=${nickname}';" style="width: 60;height: 25" />
									<input type="button" value="返回"
										onclick="location.href='createSpace1.action?nickname=${nickname}';" style="width: 60;height: 25" />
								</td>
							</tr>
							</tfoot>
						</table>
					</td>
					
				</tr>
				
			</table>
		</form>
	        
        <div id="hots">
          <h2>我的地盘</h2>
          <ul>
          <li>
           <div>
            <img src="images/a.gif" />
            <a href="modify.html">基本信息</a>
            <p>可修改自己的基本信息</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/b.gif" />
            <a href="messenger/inbox.html">我的信箱</a>
            <p>写信息、收件箱、发件箱</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/c.gif" />
            <a href="messenger/buddyList.html">我的好友</a>
            <p>好友管理及黑名单</p>
           </div>
          </li>
          <li>
           <div>
            <img src="images/d.gif" />
            <a href="space.html">个性空间</a>
            <p>创建自己的个性空间</p>
           </div>
          </li>
          </ul>
        </div> 
         
     </div>
     <div id="right">
       <h2>&nbsp;</h2>
      <ul><li></li>
      </ul>
     </div>
     <div class="clear"></div>
    
     
  </div>
  
  <div id="footer">
    <div id="copyright">
       <div id="copy">
       <p>CopyRight&copy;2009</p>
       <p>跑步社区(www.irun.com) </p>
        </div>
    </div>
    <div id="bgbottom"></div>
  </div>
  
</div>
</div>
</body>
</html>
