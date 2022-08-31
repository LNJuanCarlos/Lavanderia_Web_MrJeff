package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;


import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name = "DISTRITO")
public class Distrito implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	    @Id  
	    @Basic(optional = false)
	    @Column(name = "ID_DISTRITO")
	    private String ID_DISTRITO;
	    
	    @Column(name = "NOMBRE_DISTRITO")
	    private String NOMBRE_DISTRITO;
	  
	    @JoinColumn (name="ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
	    @ManyToOne(optional = false)
	    private Departamento ID_DEPARTAMENTO;
	   


		public Distrito() {
			
		}


		
		public Distrito(String iD_DISTRITO, String nOMBRE_DISTRITO, Departamento iD_DEPARTAMENTO) {
			
			ID_DISTRITO = iD_DISTRITO;
			NOMBRE_DISTRITO = nOMBRE_DISTRITO;
			ID_DEPARTAMENTO = iD_DEPARTAMENTO;
		}



		public String getID_DISTRITO() {
			return ID_DISTRITO;
		}



		public void setID_DISTRITO(String iD_DISTRITO) {
			ID_DISTRITO = iD_DISTRITO;
		}



		public String getNOMBRE_DISTRITO() {
			return NOMBRE_DISTRITO;
		}



		public void setNOMBRE_DISTRITO(String nOMBRE_DISTRITO) {
			NOMBRE_DISTRITO = nOMBRE_DISTRITO;
		}



		public Departamento getID_DEPARTAMENTO() {
			return ID_DEPARTAMENTO;
		}



		public void setID_DEPARTAMENTO(Departamento iD_DEPARTAMENTO) {
			ID_DEPARTAMENTO = iD_DEPARTAMENTO;
		}



		public boolean equals(Object object) {
	        // TODO: Warning - this method won't work in the case the id fields are not set
	        if (!(object instanceof Distrito)) {
	            return false;
	        }
	        Distrito other = (Distrito) object;
	        if ((this.ID_DISTRITO == null && other.ID_DISTRITO != null) || (this.ID_DISTRITO != null && !this.ID_DISTRITO.equals(other.ID_DISTRITO))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public String toString() {
	        return "idat.edu.pe.daa2.jpa.modelo.Distrito[ ID_DISTRITO=" + ID_DISTRITO + " ]";
	    }
		
		
}

