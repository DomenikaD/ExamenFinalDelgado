package ec.edu.ups.ppw.ExamenFinalDelgado.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Recarga {
	
	//Atributos
	
	
	@Id
	private int codigo;
	
	
	private String cedula;
	
	private String telefono;
	private String operador;
	private int monto;
	
	
	
	//Getters & Setters
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	
	
	
	//ToString
	@Override
	public String toString() {
		return "Recarga [codigo=" + codigo + ", cedula=" + cedula + ", telefono=" + telefono + ", operador=" + operador
				+ ", monto=" + monto + "]";
	}
	
	
	

}
