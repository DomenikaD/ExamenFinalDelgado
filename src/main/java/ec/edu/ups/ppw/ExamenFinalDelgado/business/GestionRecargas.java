package ec.edu.ups.ppw.ExamenFinalDelgado.business;

import java.util.List;

import ec.edu.ups.ppw.ExamenFinalDelgado.dao.RecargaDao;
import ec.edu.ups.ppw.ExamenFinalDelgado.model.Recarga;
import jakarta.inject.Inject;

public class GestionRecargas {
	
	@Inject
	private RecargaDao daoRecarga;
	
	
	public void guardarRecargas(Recarga recarga) {
		Recarga rec = daoRecarga.read(recarga.getCodigo());
		if (rec != null){
			daoRecarga.update(recarga);
		}else {
			daoRecarga.insert(recarga);
		}
	}
	
	public void actualizarRecarga(Recarga recarga) throws Exception {
		Recarga rec = daoRecarga.read(recarga.getCodigo());
		if (rec != null){
			daoRecarga.update(recarga);
		}else {
			throw new Exception("Recarga fue un Fracaso");
		}
	}
	
	
	/*
	 VER LA RECARGA POR EL NUMERO DE CEDULA DEL CLIENTE
	 */
	public Recarga getRecargaPorCedula(String cedula) throws Exception{
		
		if(cedula.length()!=10)
			throw new Exception("Cedula incorrecta");
			
		return daoRecarga.getRecargaPorCedula(cedula);
	}
	
	
	
	public void borrarRecarga(int codigo){
		
		daoRecarga.remove(codigo);
	}
	
	public List<Recarga> getRecargas(){
		return daoRecarga.getAll();
	}

}
