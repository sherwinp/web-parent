package org.techlyric;

import javax.servlet.jsp.tagext.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import java.io.*;

public class DebugSectionTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		
		PageContext pageContext = (PageContext) getJspContext();  
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest(); 
		HttpSession session = (HttpSession) pageContext.getSession(); 
		java.util.Enumeration<String> reqEnum = session.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			out.print(s);
			out.println("==" + session.getAttribute(s));
			out.println("<br />");
		}
	}
}
