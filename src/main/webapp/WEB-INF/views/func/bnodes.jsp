<%@page session="true" %>
<c:forEach items='${data.keySet()}' var="aprop">
	<label class="${c1name}"><a data-label="${aprop.getLabel()}"  data-comment="${aprop.getComment()}" href="${aprop.getPropertyUrl()}"><c:choose>
				<c:when test='${aprop.getNsProperty().startsWith("null:")}'>&lt;${aprop.getProperty().replaceAll("([#/])([^#/]+)$","$1<span>$2")}</span>&gt;</c:when>
				<c:otherwise>${aprop.getNsProperty().replaceAll(":",":<span>")}</span>
				</c:otherwise>
			</c:choose></a></label>
	<div class="${c2name} valuecnt">
		<c:forEach items='${data.get(aprop)}' var="ela">
			<a style="display:none" href="#${ela.getValue()}" id="t_${ela.getValue()}"> _:${ela.getValue()}</a>
			<c:set var="acontentIRI" value="${ela.getValue()}" scope="page" />
			
			
			
			
			<!--
				<iframe class="bnode_iframe" id="t_${ela.getValue()}" src=" " style="display: block; border-style:solid; border-width:medium"  width=92%></iframe>
			
			--> 
		</c:forEach>
	</div>
</c:forEach>
