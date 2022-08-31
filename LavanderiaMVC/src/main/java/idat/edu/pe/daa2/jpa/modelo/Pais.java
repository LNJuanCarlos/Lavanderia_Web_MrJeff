package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "PAIS")
public class Pais implements Serializable {
	 private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_PAIS")
    private String ID_PAIS;
    
    @Column(name = "NOMBRE_PAIS")
    private String NOMBRE_PAIS;
  

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_PAIS", fetch=FetchType.LAZY)
    private List<Pais> paisList;


	public Pais() {
		
	}

	
	public Pais(String iD_PAIS, String nOMBRE_PAIS, List<Pais> paisList) {
		ID_PAIS = iD_PAIS;
		NOMBRE_PAIS = nOMBRE_PAIS;
		this.paisList = paisList;
	}


	

	public String getID_PAIS() {
		return ID_PAIS;
	}


	public void setID_PAIS(String iD_PAIS) {
		ID_PAIS = iD_PAIS;
	}


	public String getNOMBRE_PAIS() {
		return NOMBRE_PAIS;
	}


	public void setNOMBRE_PAIS(String nOMBRE_PAIS) {
		NOMBRE_PAIS = nOMBRE_PAIS;
	}


	public List<Pais> getPaisList() {
		return paisList;
	}


	public void setPaisList(List<Pais> paisList) {
		this.paisList = paisList;
	}


	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.ID_PAIS == null && other.ID_PAIS != null) || (this.ID_PAIS != null && !this.ID_PAIS.equals(other.ID_PAIS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Pais[ ID_PAIS=" + ID_PAIS + " ]";
    }
    

}
