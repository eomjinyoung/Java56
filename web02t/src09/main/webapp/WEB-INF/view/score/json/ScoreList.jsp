<%@ page import="com.google.gson.Gson"%>
<%@ page import="java56.vo.Score"%>
<%@ page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
List<Score> scores = (List<Score>)request.getAttribute("scores");
%>
<%=new Gson().toJson(scores)%>
