package org.techlyric;

import javax.servlet.jsp.tagext.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.*;
import java.io.*;

public class DebugSectionTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		

		PageContext pageContext = (PageContext) getJspContext();

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		formatTag(request, request.getAttributeNames());
		if (request.getSession(false) != null) {
			try {
				formatTag( request.getSession(false), request.getSession(false).getAttributeNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void formatTag(HttpServletRequest request,java.util.Enumeration<String> attrEnums) throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		while (attrEnums.hasMoreElements()) {
			String s = attrEnums.nextElement();
			out.print(s);
			out.println("==" + request.getAttribute(s));
			out.println("<br />");
		}
	}
	private void formatTag(HttpSession session,java.util.Enumeration<String> attrEnums) throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		if( attrEnums.hasMoreElements() )
			out.println("<hr />");
		while (attrEnums.hasMoreElements()) {
			String s = attrEnums.nextElement();
			out.print(s);
			out.println("==" + session.getAttribute(s));
			out.println("<br />");
		}
	}
}
