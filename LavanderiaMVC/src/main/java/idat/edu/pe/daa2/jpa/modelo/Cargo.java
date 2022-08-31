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
@Table(name = "CARGO")
public class Cargo implements Serializable {

	
private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_CARGO")
    private String ID_CARGO;
    
    @Column(name = "NOMBRE_CARGO")
    private String NOMBRE_CARGO;
    
    @Column(name = "SUELDO")
    private int SUELDO;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_CARGO", fetch=FetchType.LAZY)
    private List<Cargo> cargoList;

	public Cargo() {
		
	}

	public Cargo(String iD_CARGO, String nOMBRE_CARGO, int sUELDO, List<Cargo> cargoList) {
		
		ID_CARGO = iD_CARGO;
		NOMBRE_CARGO = nOMBRE_CARGO;
		SUELDO = sUELDO;
		this.cargoList = cargoList;
	}

	public String getID_CARGO() {
		return ID_CARGO;
	}

	public void setID_CARGO(String iD_CARGO) {
		ID_CARGO = iD_CARGO;
	}

	public String getNOMBRE_CARGO() {
		return NOMBRE_CARGO;
	}

	public void setNOMBRE_CARGO(String nOMBRE_CARGO) {
		NOMBRE_CARGO = nOMBRE_CARGO;
	}

	public int getSUELDO() {
		return SUELDO;
	}

	public void setSUELDO(int sUELDO) {
		SUELDO = sUELDO;
	}

	public List<Cargo> getCargoList() {
		return cargoList;
	}

	public void setCargoList(List<Cargo> cargoList) {
		this.cargoList = cargoList;
	}
    
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.ID_CARGO == null && other.ID_CARGO != null) || (this.ID_CARGO != null && !this.ID_CARGO.equals(other.ID_CARGO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Cargo[ ID_CARGO=" + ID_CARGO + " ]";
    }
}
