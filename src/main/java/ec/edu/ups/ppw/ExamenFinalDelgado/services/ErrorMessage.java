package ec.edu.ups.ppw.ExamenFinalDelgado.services;

public class ErrorMessage {
	
		private int codigo;
		private String mensaje;
		
		public ErrorMessage(int codigo, String mensaje) {
			this.codigo = codigo;
			this.mensaje = mensaje;
			
		}	
		
			//Getters & Setters
		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}




}
