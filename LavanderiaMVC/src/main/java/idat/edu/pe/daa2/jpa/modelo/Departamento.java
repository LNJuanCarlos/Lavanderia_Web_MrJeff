package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable {
	 private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_DEPARTAMENTO")
    private String ID_DEPARTAMENTO;
    
    @Column(name = "NOMBRE_DEPARTAMENTO")
    private String NOMBRE_DEPARTAMENTO;
  
    @JoinColumn (name="ID_PAIS", referencedColumnName = "ID_PAIS")
    @ManyToOne(optional = false)
    private Pais ID_PAIS;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_DEPARTAMENTO", fetch=FetchType.LAZY)
    private List<Distrito> DISTRITOList;


	public Departamento() {
		
	}


	public Departamento(String iD_DEPARTAMENTO, String nOMBRE_DEPARTAMENTO, List<Distrito> dISTRITOList) {
		
		ID_DEPARTAMENTO = iD_DEPARTAMENTO;
		NOMBRE_DEPARTAMENTO = nOMBRE_DEPARTAMENTO;
		DISTRITOList = dISTRITOList;
	}


	public String getID_DEPARTAMENTO() {
		return ID_DEPARTAMENTO;
	}


	public void setID_DEPARTAMENTO(String iD_DEPARTAMENTO) {
		ID_DEPARTAMENTO = iD_DEPARTAMENTO;
	}


	public String getNOMBRE_DEPARTAMENTO() {
		return NOMBRE_DEPARTAMENTO;
	}


	public void setNOMBRE_DEPARTAMENTO(String nOMBRE_DEPARTAMENTO) {
		NOMBRE_DEPARTAMENTO = nOMBRE_DEPARTAMENTO;
	}


	public List<Distrito> getDISTRITOList() {
		return DISTRITOList;
	}


	public void setDISTRITOList(List<Distrito> dISTRITOList) {
		DISTRITOList = dISTRITOList;
	}

	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.ID_DEPARTAMENTO == null && other.ID_DEPARTAMENTO != null) || (this.ID_DEPARTAMENTO != null && !this.ID_DEPARTAMENTO.equals(other.ID_DEPARTAMENTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Departamento[ ID_DEPARTAMENTO=" + ID_DEPARTAMENTO + " ]";
    }
	
}
