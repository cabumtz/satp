package mx.com.magmasoft.satp.ui.util;

import mx.com.magmasoft.satp.exception.ParseException;
import mx.com.magmasoft.satp.ui.vo.MenuElem;

import org.apache.commons.digester.Digester;

public class MenuDescriptionUtil {
	
	
	public static MenuElem parseMenuDescription(String uri) throws ParseException {
		Digester digester;
		MenuElem result;
		String[] attributes;
		String[] properties;
		
		
		
		digester = new Digester();
		
		digester.push(new MenuElem());
		
		digester.addObjectCreate("mi", MenuElem.class);
		
		attributes = new String[] { "label", "url" };
		properties = new String[] { "label", "url" };
		digester.addSetNestedProperties("mi", attributes, properties);
		
		digester.addSetNext("mi-list/mi", "addChild", "mx.com.magmasoft.satp.ui.vo.MenuItem");
		
		try{
			
			result = (MenuElem) digester.parse(uri);
			return result;
			
		} catch (Exception e) {
			throw new ParseException(e);
		}
			
			
	}
	
	
}
