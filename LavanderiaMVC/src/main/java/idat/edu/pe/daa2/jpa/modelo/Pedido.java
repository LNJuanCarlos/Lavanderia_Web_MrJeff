package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

	
private static final long serialVersionUID = 1L;
	

    @Id  
    @Basic(optional = false)
    @Column(name = "ID_PEDIDO")
    private String ID_PEDIDO;
    
    @Column(name = "FEC_PEDIDO")
    private Date FEC_PEDIDO;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_PEDIDO", fetch=FetchType.LAZY)
    private List<Pedido> pedidoList;

	public Pedido() {
		
	}

	public Pedido(String iD_PEDIDO, Date fEC_PEDIDO, List<Pedido> pedidoList) {
		
		ID_PEDIDO = iD_PEDIDO;
		FEC_PEDIDO = fEC_PEDIDO;
		this.pedidoList = pedidoList;
	}

	public String getID_PEDIDO() {
		return ID_PEDIDO;
	}

	public void setID_PEDIDO(String iD_PEDIDO) {
		ID_PEDIDO = iD_PEDIDO;
	}

	public Date getFEC_PEDIDO() {
		return FEC_PEDIDO;
	}

	public void setFEC_PEDIDO(Date fEC_PEDIDO) {
		FEC_PEDIDO = fEC_PEDIDO;
	}

	public List<Pedido> getPedidoList() {
		return pedidoList;
	}

	public void setPedidoList(List<Pedido> pedidoList) {
		this.pedidoList = pedidoList;
	}
    
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.ID_PEDIDO == null && other.ID_PEDIDO != null) || (this.ID_PEDIDO != null && !this.ID_PEDIDO.equals(other.ID_PEDIDO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Pedido[ ID_PEDIDO=" + ID_PEDIDO + " ]";
    }
    
}
