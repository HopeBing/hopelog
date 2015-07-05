<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="leftNav">
	<c:forEach items="${leftNavs}" var="nav">
		<div class="box">
			<h2><a href="#">${nav.name }</a></h2>
			<ul class="list">
				<c:forEach items="${nav.childNav}" var="navItem">
					<li>
						<a href="${navItem.url}">${navItem.name}</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</c:forEach>
</div>