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
@Table(name = "CLIENTE")

public class Cliente implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	

    @Id  
    @Basic(optional = false)
    @Column(name = "DNI")
    private String DNI;
    
    @Column(name = "NOMBRES")
    private String NOMBRES;
   
    @Column(name = "APELLIDOS")
    private String APELLIDOS;
    
    @Column(name = "DIRECCION")
    private String DIRECCION;
    
    @Column(name = "SEXO")
    private String SEXO;
    
    @Column(name = "EMAIL")
    private String EMAIL;
    
    @Column(name = "TELEFONO")
    private String TELEFONO;
    
    @JoinColumn (name="ID_DISTRITO", referencedColumnName = "ID_DISTRITO")
    @ManyToOne(optional = false)
    private Distrito ID_DISTRITO;
   
    
   

	public Cliente() {
		
	}
	
	

	public Cliente(String dNI, String nOMBRES, String aPELLIDOS, String dIRECCION, String sEXO, String eMAIL,
			String tELEFONO, Distrito iD_DISTRITO) {
		
		DNI = dNI;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		DIRECCION = dIRECCION;
		SEXO = sEXO;
		EMAIL = eMAIL;
		TELEFONO = tELEFONO;
		ID_DISTRITO = iD_DISTRITO;
	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getNOMBRES() {
		return NOMBRES;
	}



	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}



	public String getAPELLIDOS() {
		return APELLIDOS;
	}



	public void setAPELLIDOS(String aPELLIDOS) {
		APELLIDOS = aPELLIDOS;
	}



	public String getDIRECCION() {
		return DIRECCION;
	}



	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}



	public String getSEXO() {
		return SEXO;
	}



	public void setSEXO(String sEXO) {
		SEXO = sEXO;
	}



	public String getEMAIL() {
		return EMAIL;
	}



	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}



	public String getTELEFONO() {
		return TELEFONO;
	}



	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}



	public Distrito getID_DISTRITO() {
		return ID_DISTRITO;
	}



	public void setID_DISTRITO(Distrito iD_DISTRITO) {
		ID_DISTRITO = iD_DISTRITO;
	}



	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.DNI == null && other.DNI != null) || (this.DNI != null && !this.DNI.equals(other.DNI))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Cliente[ DNI=" + DNI + " ]";
    }
    
 


}
