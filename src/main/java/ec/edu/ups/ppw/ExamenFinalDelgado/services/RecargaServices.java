package ec.edu.ups.ppw.ExamenFinalDelgado.services;

import java.util.List;

import ec.edu.ups.ppw.ExamenFinalDelgado.business.GestionRecargas;
import ec.edu.ups.ppw.ExamenFinalDelgado.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargaServices {
	
	
	@Inject
	private GestionRecargas gRecargas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Recarga recarga) {
		try {
			gRecargas.guardarRecargas(recarga);
			return Response.ok(recarga).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage (99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();		
			}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar (Recarga recarga) {
		try {
			gRecargas.actualizarRecarga(recarga);
			return Response.ok(recarga).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("id") int codigo) {
		try {
			gRecargas.borrarRecarga(codigo);
			return "OK";
		}catch (Exception e) {
			// TODO: handle exception
			return "ERROR";
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer(@QueryParam("dni") String cedula) {
		try {
			System.out.println("cedula " +  cedula );
			Recarga rec = gRecargas.getRecargaPorCedula(cedula);
			return Response.ok(rec).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Recarga no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	
	@GET
	@Path("{dni}/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response leer2(@PathParam("dni") String cedula) {
		try{
			System.out.println("cedula " +  cedula );
			Recarga rec = gRecargas.getRecargaPorCedula(cedula);
			return Response.ok(rec).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Recarga no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas(){
		List<Recarga> recargas = gRecargas.getRecargas();
		if(recargas.size()>0)
			return Response.ok(recargas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran recargas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	

}
