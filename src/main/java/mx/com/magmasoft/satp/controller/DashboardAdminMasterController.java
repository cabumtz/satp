/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.controller;


import java.io.Serializable;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author Carlos
 */
public class DashboardAdminMasterController implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7172764785906923852L;
	private DashboardModel dashboardModel;
	
	public DashboardAdminMasterController()
	{
		dashboardModel = new DefaultDashboardModel();
		
		DashboardColumn col1 = new DefaultDashboardColumn();
		DashboardColumn col2 = new DefaultDashboardColumn();
		DashboardColumn col3 = new DefaultDashboardColumn();
		DashboardColumn col4 = new DefaultDashboardColumn();
		
		col1.addWidget("configuracion");
		
		col2.addWidget("administradores");
		col2.addWidget("concecionarios");
		
		col3.addWidget("choferes");
		col3.addWidget("unidades");
		
		dashboardModel.addColumn(col1);
		dashboardModel.addColumn(col2);
		dashboardModel.addColumn(col3);
		dashboardModel.addColumn(col4);
	}

	public DashboardModel getDashboardModel()
	{
		return dashboardModel;
	}

	public void setDashboardModel(DashboardModel dashboardModel)
	{
		this.dashboardModel = dashboardModel;
	}
	
	
}
