<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="../frame/header.jsp"%>
<%@ taglib prefix="a" uri="http://www.aquilokyrie.com/atl"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<ul class="list-group">
				<a:iterator collection="CategoryList" itemId="category">
					<li class="list-group-item"><span class="badge">${category.count }</span><a href="#">${category.name }</a>
					</li>
				</a:iterator>
			</ul>
		</div>
		<div class="col-md-4">
			<a:iterator collection="LeftArticleList" itemId="articleLeft">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${articleLeft.title }</h3>
					</div>
					<div class="panel-body">${articleLeft.content }</div>
					<div class="panel-footer text-right">${articleLeft.createDate }</div>
				</div>
			</a:iterator>
		</div>
		<div class="col-md-4">
			<a:iterator collection="RightArticleList" itemId="articleRight">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${articleRight.title }</h3>
					</div>
					<div class="panel-body">${articleRight.content }</div>
					<div class="panel-footer text-right">${articleRight.createDate }</div>
				</div>
			</a:iterator>
		</div>
	</div>
	<!-- end of row -->
</div>
<!-- end of container-fluid -->

<%@include file="../frame/footer.jsp"%>