package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		try {
			//task.......:tag
			JspWriter out = pageContext.getOut();
			out.println("<h1>Hello this is my custom tag</h1>");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}

	
}
