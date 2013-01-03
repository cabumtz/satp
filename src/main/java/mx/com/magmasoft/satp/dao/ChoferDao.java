package mx.com.magmasoft.satp.dao;

import java.io.Serializable;
import java.util.List;

import mx.com.magmasoft.satp.filtros.busqueda.FiltroChofer;
import mx.com.magmasoft.satp.vo.Chofer;

public interface ChoferDao extends Serializable {

	public abstract List<Chofer> listaChoferes();

	public abstract Integer guardar(Chofer chofer);

	public abstract List<Chofer> getListaChoferesPorRuta(Integer idRuta);

	public abstract List<Chofer> getListaChoferesPorFiltro(FiltroChofer filtro);

}