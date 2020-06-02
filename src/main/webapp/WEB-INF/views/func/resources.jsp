<div>
<br>
</div>
<%@page session="true" %>




<c:forEach items='${data.keySet()}' var="aprop">
	<label class="${c1name}">
<a data-label="${aprop.getLabel() }"  data-comment="${aprop.getComment()}" href="${aprop.getPropertyUrl()}">
            <c:choose>
				<c:when test='${aprop.getNsProperty().startsWith("null:")}'>&lt;${aprop.getProperty().replaceAll("([#/])([^#/]+)$","$1<span>$2")}</span>&gt;</c:when>
				<c:otherwise>${aprop.getNsProperty().replaceAll(":",":<span>")}</span>
			</c:otherwise>
			</c:choose></a></label>
	<div class="${c2name} value">
		<c:forEach items='${data.get(aprop)}' var="ela">

			<div class="toOneLine">
				<a title="&lt;${ela.getValue()}&gt;" name="${ela.getUrl(true).replaceAll("lod.ruthes.org", "|domain|/ruthes-cloud")}" onmouseout="ChangeLeave(this.name)" onmouseover="ChangeOver(this.name)" class="<c:if test="${results.getLinking().contains(ela.getUrl())}">linkingElement</c:if> <c:if test="${ela.isLocal()}">isLocal</c:if>" 
                href="${ela.getUrl(true)}<c:if test='${ela.isLocal()}'></c:if>" 
                <c:if test="${!ela.isLocal()}">target="_blank" </c:if>>              
                    
                    <c:choose>
						<c:when test='${ela.getNsValue().startsWith("null:")}'>&lt;${ela.getValue()}&gt;</c:when>
						<c:otherwise>${ela.getNsValue().replaceAll(" :",":<span>")}</c:otherwise>
					</c:choose>
				</a>

              <!--  <c:if test = '${ela.getValue().contains("lod.ruthes.org") == true}'>
                <input type = "button" name="${ela.getValue().replaceAll("lod.ruthes.org", "|domain|/ruthes-cloud")}" onclick="ChangeOver(this.name)" value="Expand"></input>
                </c:if>-->
               
                <input type = "button" name="${ela.getUrl(true).replaceAll("lod.ruthes.org", "|domain|/ruthes-cloud")}" onclick="ChangeOver(this.name)" value="Expand"></input>
			</div>
			<c:if test = '${ela.getUrl(true).contains("lod.ruthes.org") == true}'>
                <iframe  id="iframe_${ela.getUrl(true).replaceAll("lod.ruthes.org", "|domain|/ruthes-cloud")}"  src=" " style="display: none; border-style:solid; border-width:medium"  width=92%></iframe> 
			</c:if>
            <c:if test = '${ela.getUrl(true).contains("lod.ruthes.org") == false}'>
                <iframe  id="iframe_${ela.getUrl(true).replaceAll("lod.ruthes.org", "|domain|/ruthes-cloud")}" src=" " style="display: none; border-style:solid; border-width:medium"  width=92%></iframe> 
			</c:if>
            <!-- onmouseover="ChangeLeave('')" onmouseout="iframeLeave(this.id)" -->
		</c:forEach>
	</div>
</c:forEach>
