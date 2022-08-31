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
@Table(name = "DETALLE_PEDIDO")
public class Detalle_Pedido implements Serializable {

private static final long serialVersionUID = 1L;

    @Id  
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_PEDIDO")
    private String ID_DETALLE_PEDIDO;
	
    
    @Column(name = "DESC_PEDIDO")
    private String DESC_PEDIDO;
   
    @Column(name = "CANTIDAD")
    private String CANTIDAD;
    
   
    
    @JoinColumn (name="ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto ID_PRODUCTO;



	
    
	public Detalle_Pedido() {
		
	}
	
	

	public Detalle_Pedido(String iD_DETALLE_PEDIDO, String dESC_PEDIDO, String cANTIDAD, Producto iD_PRODUCTO) {
		
		ID_DETALLE_PEDIDO = iD_DETALLE_PEDIDO;
		DESC_PEDIDO = dESC_PEDIDO;
		CANTIDAD = cANTIDAD;
		ID_PRODUCTO = iD_PRODUCTO;
	}



	public String getID_DETALLE_PEDIDO() {
		return ID_DETALLE_PEDIDO;
	}



	public void setID_DETALLE_PEDIDO(String iD_DETALLE_PEDIDO) {
		ID_DETALLE_PEDIDO = iD_DETALLE_PEDIDO;
	}



	public String getDESC_PEDIDO() {
		return DESC_PEDIDO;
	}



	public void setDESC_PEDIDO(String dESC_PEDIDO) {
		DESC_PEDIDO = dESC_PEDIDO;
	}



	public String getCANTIDAD() {
		return CANTIDAD;
	}



	public void setCANTIDAD(String cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}



	public Producto getID_PRODUCTO() {
		return ID_PRODUCTO;
	}



	public void setID_PRODUCTO(Producto iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
	}



	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle_Pedido)) {
            return false;
        }
        Detalle_Pedido other = (Detalle_Pedido) object;
        if ((this.ID_DETALLE_PEDIDO == null && other.ID_DETALLE_PEDIDO != null) || (this.ID_DETALLE_PEDIDO != null && !this.ID_DETALLE_PEDIDO.equals(other.ID_DETALLE_PEDIDO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Detalle_Pedido[ ID_DETALLE_PEDIDO=" + ID_DETALLE_PEDIDO + " ]";
    }
}
