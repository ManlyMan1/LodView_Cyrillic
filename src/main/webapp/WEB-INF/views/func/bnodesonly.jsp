<%@page session="true" %>
<%
				/* literals */
			%>
			
			<c:set var="data" value="${results.getBnodes(contentIRI)}" scope="page" />
			<%@include file="bnodes.jsp"%>