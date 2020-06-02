package org.dvcama.lodview.utils;
import java.io.*;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.LinkedHashMap;
import java.util.HashMap;
import org.dvcama.lodview.bean.OntologyBean;
import org.dvcama.lodview.bean.PropertyBean;
import org.dvcama.lodview.bean.ResultBean;
import org.dvcama.lodview.bean.TripleBean;
import org.dvcama.lodview.conf.ConfigurationBean;
import org.dvcama.lodview.conf.ConfigurationBean.ColorStrategy;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;

/*

<h3>
						<sp:message code='title.blankNodes' text='blank nodes' />
					</h3>
					<%
						// first level of blank nodes 
						%>
						<c:forEach items='${results.getBnodes(results.getMainIRI()).keySet()}' var="prop">
							
						<label class="c1" onmouseover="show(${prop})">
							<a data-label="${prop.getLabel()}"  data-comment="${prop.getComment()}"  href="${prop.getPropertyUrl()}"><c:choose>
										<c:when test='${prop.getNsProperty().startsWith("null:")}'>&lt;${prop.getProperty().replaceAll("([#/])([^#/]+)$","$1<span>$2")}</span>&gt;</c:when>
										<c:otherwise>${prop.getNsProperty().replaceAll(":",":<span>")}</span>
										</c:otherwise>
									</c:choose></a></label>
							<div class="c2 valuecnt">
								<c:forEach items='${results.getBnodes(results.getMainIRI()).get(prop)}' var="iel">
									<div class="toOneLine">
										<a href="#t_${iel.getValue()}" id="${iel.getValue()}"> _:${iel.getValue()}</a>
									</div>
									
									<c:set var="c1name" value="c3" scope="page"></c:set>
									<c:set var="c2name" value="c4" scope="page"></c:set>
									<c:set var="contentIRI" value="${iel.getValue()}" scope="page" />
									<%@include file="func/contents.jsp"%>
								</c:forEach>
							</div>
						</c:forEach>
*/
public class BnodesHelper {
	public String getBnodesBlock(final ResultBean results, final String contentIRI) {
		String result="";
		//try(FileWriter writer = new FileWriter("/home/narrowbarrow/notes3.txt", true))
        {
			result = "<div class=\"c2 valuecnt\">";
			for (Map.Entry<PropertyBean, List<TripleBean>> entry : results.getBnodes(contentIRI).entrySet()) 
			{
				List<TripleBean> value = entry.getValue();
				for (TripleBean tripleBean : value) {
					
					result += "<c:set var=\"c1name\" value=\"c3\" scope=\"page\"></c:set> <c:set var=\"c2name\" value=\"c4\" scope=\"page\"></c:set>";
					String localIRI = tripleBean.getIRI();
					//result += contents(localIRI, results);
				}
				// now work with key and value...
			}

			result+="</div>";
			//writer.write(result);
            //writer.flush();
        }
		//catch(IOException ex)
		{
             
          //  System.out.println(ex.getMessage());
        } 
	    
		return result;
	}

	public String contents(final String contentIRI, final ResultBean results) {
		String result = "<%@page session=\"true\" %>";
		//result += literals(results.getLiterals(contentIRI), results);
		result += resources(results.getResources(contentIRI), results);
		result += bnodes(results.getBnodes(contentIRI), results);
		return result;
	}

	String literals(final LinkedHashMap<PropertyBean, List<TripleBean>> data, final ResultBean results) {
		String result = "<%@page session=\"true\"%><%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\"%>";
		for (final PropertyBean iprop : data.keySet()) {
			if (results.getDescriptionProperty() != iprop) {
				result += "<label class=\"${c1name}\">";
				result += "<a data-label=" + iprop.getLabel() + " data-comment=" + iprop.getComment() + " href="
						+ iprop.getPropertyUrl() + ">";
				if (iprop.getNsProperty().startsWith("null:")) {
					result += "&lt;" + iprop.getProperty().replaceAll("([#/])([^#/]+)$", "$1<span>$2") + "</span>&gt;";
				} else {
					result += iprop.getNsProperty().replaceAll(":", ":<span>") + "</span>";
				}
				result += "</a> </label>";
				boolean veryShortProps = true, done = false;
				for (final TripleBean ela : data.get(iprop)) {
					if (!done) {
						if (ela.getValue().length() > 8 || !ela.getLang().equals("")) {
							veryShortProps = false;
							done = true;
						}
					}
				}
				result += "<div class=\"${c2name} value ";
				if(veryShortProps) result+="multiInLineBlock";
				done = false;
				for (final TripleBean ela : data.get(iprop)) {
					if (veryShortProps) {
						result += "<span class=\"multiInLine\"> ";
						if (!done)
							if (ela.getDataType() != null && !ela.getDataType().equals("")) {
								result += "<span class=\"dType\">"
										+ ela.getNsDataType().replaceAll("null:(.*)", "&lt;$1&gt;") + "</span>";
								done = true;
							}

						result += ela.getValue() + "&#160;</span>";
					} else {
						result += "<div class=\"toMultiLine ";
						if (ela.getLang() != null && !ela.getLang().equals("")) {
							result += " lang " + ela.getLang() + "\" data-lang=\"" + ela.getLang() + "\">";

						}
						result += "<div class=\"fixed\">";
						if (ela.getNsDataType() != null && !ela.getDataType().equals(""))
							result += "<span class=\"dType\">"
									+ ela.getNsDataType().replaceAll("null:(.*)", "&lt;$1&gt;") + "</span>";
						result += ela.getValue() + "&#160;</div";
						result += "</div>";
					}
				}
				result += "</div>";
			}
		}
return result;
	}

	String resources(final LinkedHashMap<PropertyBean, List<TripleBean>> data, final ResultBean results) {
		final String result="";

		return result;
	}

	String bnodes(final LinkedHashMap<PropertyBean, List<TripleBean>> data, final ResultBean results) {

		final String result="";

		return result;
	}
	// <c:set var="data" value="${results.getLiterals(contentIRI)}" scope="page" />
	// <%@include file="literals.jsp"%>
	// <%
	// /* resources */
	// %>
	// <c:set var="data" value="${results.getResources(contentIRI)}" scope="page" />
	// <%@include file="resources.jsp"%>
	// <%
	// /* bnodes */
	// %>
	// <c:set var="data" value="${results.getBnodes(contentIRI)}" scope="page" />
	// <%@include file="bnodes.jsp"%>
	//
	/*
	 * 
	 * <div class="c2 valuecnt"> <c:forEach
	 * items='${results.getBnodes(acontentIRI)}' var="iel"> <c:set var="c1name"
	 * value="c3" scope="page"></c:set> <c:set var="c2name" value="c4"
	 * scope="page"></c:set> <c:set var="contentIRI" value="${iel.getValue()}"
	 * scope="page" /> </c:forEach> </div>
	 * 
	 */
}
