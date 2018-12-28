<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 头部 -->
<jsp:include page="/admin/header.jsp"></jsp:include>	


<!-- 分页 -->
<jsp:include page="/page.jsp">
<jsp:param value="/goods_list" name="url"/>
<jsp:param value="&id=${id }" name="param"/>
</jsp:include>