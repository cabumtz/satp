package mx.com.magmasoft.satp.ui.controller;

import mx.com.magmasoft.satp.exception.ParseException;
import mx.com.magmasoft.satp.ui.util.MenuDescriptionUtil;
import mx.com.magmasoft.satp.ui.vo.MenuElem;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

public class MainMenuController {
	
	private MenuModel menuModel;

	public MainMenuController() {
		
		
		
		menuModel = new DefaultMenuModel();
		
	}
	
	
	private MenuModel createMenuModel() {
		MenuModel model;
		Submenu submenu;
		MenuItem menuItem; 
		
		model = new DefaultMenuModel();
		
		submenu = new Submenu();
		submenu.setLabel("Choferes");
		
		
		return model;
	}
	
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	private static MenuModel generateMenuModel(String uri) throws Exception {
		
		MenuElem menuItem;
		
		try {
			menuItem = MenuDescriptionUtil.parseMenuDescription(uri);
			
			return translateMenuElem2MenuItem(menuItem);
			
		} catch (ParseException pe) {
			throw pe;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static MenuModel translateMenuElem2MenuItem(MenuElem menuElem) {
		
		MenuModel model;
		MenuItem menuItem;
		Submenu submenu;
		
		model = new DefaultMenuModel();
		
		for( MenuElem elem : menuElem.getChildren() ) {
			submenu = new Submenu();
			submenu.setLabel(elem.getLabel());
			
			
			model.addSubmenu(submenu);
		}
		
		return null;
	}
	
	private static void translateSubmenu(Submenu submenu) {
		
		
		
	}
	
}
