package tags;

import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTableTag extends TagSupport {

	public int number;
	public String color;

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub

		// Print table
		// 1-10
		try {
			JspWriter out = pageContext.getOut();
			out.println("<div style='color:"+color+"'>");
			out.print("<br>");
			for (int i = 1; i <= 10; i++) {
				out.println((i * number)+"<br>");
			}
			out.print("</div>");

		} catch (Exception e) {
			// TODO: handle exception
		}

		return SKIP_BODY;
	}

}
