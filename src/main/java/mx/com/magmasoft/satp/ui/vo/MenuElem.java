package mx.com.magmasoft.satp.ui.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuElem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4328157521585026863L;
	private String label;
	private String url;
	private List<MenuElem> children = new ArrayList<MenuElem>();

	public MenuElem() {
		super();
	}

	public MenuElem(String label, String url) {
		super();
		this.label = label;
		this.url = url;
	}

	public MenuElem(String label, List<MenuElem> children) {
		super();
		this.label = label;
		this.children = children;
	}

	public MenuElem(String label, String url, List<MenuElem> children) {
		super();
		this.label = label;
		this.url = url;
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuElem> getChildren() {
		return children;
	}

	public void setChildren(List<MenuElem> children) {
		this.children = children;
	}

	public void addChild(MenuElem child) {
		children.add(child);
	}
}
