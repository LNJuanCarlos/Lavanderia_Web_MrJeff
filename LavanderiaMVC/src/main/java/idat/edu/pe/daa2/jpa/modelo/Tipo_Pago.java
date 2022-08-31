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
@Table(name = "TIPO_PAGO")
public class Tipo_Pago implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PAGO")
    private String ID_TIPO_PAGO;
    
    @Column(name = "DESC_TIPO_PAGO")
    private String DESC_TIPO_PAGO;
  

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_TIPO_PAGO", fetch=FetchType.LAZY)
    private List<Tipo_Pago> tipo_pagoList;


	public Tipo_Pago() {
		
	}


	public Tipo_Pago(String iD_TIPO_PAGO, String dESC_TIPO_PAGO, List<Tipo_Pago> tipo_pagoList) {
		
		ID_TIPO_PAGO = iD_TIPO_PAGO;
		DESC_TIPO_PAGO = dESC_TIPO_PAGO;
		this.tipo_pagoList = tipo_pagoList;
	}


	public String getID_TIPO_PAGO() {
		return ID_TIPO_PAGO;
	}


	public void setID_TIPO_PAGO(String iD_TIPO_PAGO) {
		ID_TIPO_PAGO = iD_TIPO_PAGO;
	}


	public String getDESC_TIPO_PAGO() {
		return DESC_TIPO_PAGO;
	}


	public void setDESC_TIPO_PAGO(String dESC_TIPO_PAGO) {
		DESC_TIPO_PAGO = dESC_TIPO_PAGO;
	}


	public List<Tipo_Pago> getTipo_pagoList() {
		return tipo_pagoList;
	}


	public void setTipo_pagoList(List<Tipo_Pago> tipo_pagoList) {
		this.tipo_pagoList = tipo_pagoList;
	}
	
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo_Pago)) {
            return false;
        }
        Tipo_Pago other = (Tipo_Pago) object;
        if ((this.ID_TIPO_PAGO == null && other.ID_TIPO_PAGO != null) || (this.ID_TIPO_PAGO != null && !this.ID_TIPO_PAGO.equals(other.ID_TIPO_PAGO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Tipo_Pago[ ID_TIPO_PAGO=" + ID_TIPO_PAGO + " ]";
    }
    
    
}
