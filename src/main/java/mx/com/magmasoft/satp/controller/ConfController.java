/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.controller;

import java.io.Serializable;

/**
 * 
 * @author Carlos
 */
public class ConfController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8397935807995443329L;
	private String themeName;
	private String contextPath;

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}


}
