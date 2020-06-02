package org.dvcama.lodview.bean;
import java.util.regex.*;

public class RegexBean {
	public String value = null;
	public String result = null;

	public void setValue(String val) {
		value = val;
		result = regex("value=(.+), dataType=", value);
	}

	public String getValue() {
		return value;
	}

	public String getResult() {
		return result;
	}
	public String getR()
	{return "word";}
	public String regex(String pattern, String text) {
		Pattern _Pattern = java.util.regex.Pattern.compile(pattern);

		Matcher matcher = _Pattern.matcher(text);
		while (matcher.find()) {
			return matcher.group(1);
		}
		return "";
	}

}
