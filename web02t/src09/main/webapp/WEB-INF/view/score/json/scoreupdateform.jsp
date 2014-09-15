<%@page import="com.google.gson.Gson"%>
<%@page import="java56.vo.Score"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
Score score = (Score) request.getAttribute("score");
%>
<%=new Gson().toJson(score)%>
    
    
    
    
    
    