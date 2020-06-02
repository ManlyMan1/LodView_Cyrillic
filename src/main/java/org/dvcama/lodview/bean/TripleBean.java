package org.dvcama.lodview.bean;
import java.io.UnsupportedEncodingException;

public class TripleBean {
	private String nsValue = null, type = null, IRI = null, nsIRI = null, value = null, dataType = null, nsDataType = null, lang = null, url = null;
	private boolean isLocal = false;
	PropertyBean property = null;

	public PropertyBean getProperty() {
		return property;
	}

	public void setProperty(PropertyBean property) {
		this.property = property;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}
	public String getValue(boolean d) throws UnsupportedEncodingException
	{
			return new String(value.getBytes("ISO-8859-1"), "UTF-8").replace("#", "☞");
	}
	public String getNsValue() {
		return nsValue;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setNsValue(String nsValue) {
		this.nsValue = nsValue;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Override
	public String toString() {
		return "TripleBean [property=" + property + ", nsValue=" + nsValue + ", type=" + type + ", IRI=" + IRI + ", nsIRI=" + nsIRI + ", value=" + value + ", dataType=" + dataType + ", nsDataType=" + nsDataType + ", lang=" + lang + ", url=" + url + ",   isLocal=" + isLocal + "]";
	}

	public String getUrl() throws UnsupportedEncodingException{
		return url;
	}
	public String getUrl(boolean test) throws UnsupportedEncodingException{
		return new String(url.getBytes("ISO-8859-1"), "UTF-8").replace("#", "☞");
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isLocal() {
		return isLocal;
	}

	public void setLocal(boolean isLocal) {
		this.isLocal = isLocal;
	}

	public String getIRI() {
		return IRI;
	}

	public void setIRI(String iRI) {
		IRI = iRI;
	}

	public String getNsDataType() {
		return nsDataType;
	}

	public void setNsDataType(String nsDataType) {
		this.nsDataType = nsDataType;
	}

	public String getNsIRI() {
		return nsIRI;
	}

	public void setNsIRI(String nsIRI) {
		this.nsIRI = nsIRI;
	}
}
