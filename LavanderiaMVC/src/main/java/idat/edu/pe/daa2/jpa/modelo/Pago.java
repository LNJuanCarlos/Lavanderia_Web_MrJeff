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
@Table(name = "PAGO")
public class Pago implements Serializable {
	
private static final long serialVersionUID = 1L;
	

    @Id  
    @Basic(optional = false)
    @Column(name = "ID_PAGO")
    private String ID_PAGO;
    
    @Column(name = "DESCRIPCION_PAGO")
    private String DESCRIPCION_PAGO;
   
    @Column(name = "MONTO_TOTAL")
    private Double MONTO_TOTAL;
    
    @Column(name = "TIPO_PAGO")
    private String TIPO_PAGO;
    
    @Column(name = "ESTADO")
    private String ESTADO;
    
 
    @JoinColumn (name="DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Cliente DNI;
   
    
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @ManyToOne(optional = false)
    private Pedido ID_PEDIDO;
    
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto ID_PRODUCTO;
    
    @JoinColumn(name = "ID_TIPO_PAGO", referencedColumnName = "ID_TIPO_PAGO")
    @ManyToOne(optional = false)
    private Tipo_Pago ID_TIPO_PAGO;

	public Pago() {
		
	}

	public Pago(String iD_PAGO, String dESCRIPCION_PAGO, Double mONTO_TOTAL, String tIPO_PAGO, String eSTADO,
			Cliente dNI, Pedido iD_PEDIDO, Producto iD_PRODUCTO, Tipo_Pago iD_TIPO_PAGO) {
		
		ID_PAGO = iD_PAGO;
		DESCRIPCION_PAGO = dESCRIPCION_PAGO;
		MONTO_TOTAL = mONTO_TOTAL;
		TIPO_PAGO = tIPO_PAGO;
		ESTADO = eSTADO;
		DNI = dNI;
		ID_PEDIDO = iD_PEDIDO;
		ID_PRODUCTO = iD_PRODUCTO;
		ID_TIPO_PAGO = iD_TIPO_PAGO;
	}

	public String getID_PAGO() {
		return ID_PAGO;
	}

	public void setID_PAGO(String iD_PAGO) {
		ID_PAGO = iD_PAGO;
	}

	public String getDESCRIPCION_PAGO() {
		return DESCRIPCION_PAGO;
	}

	public void setDESCRIPCION_PAGO(String dESCRIPCION_PAGO) {
		DESCRIPCION_PAGO = dESCRIPCION_PAGO;
	}

	public Double getMONTO_TOTAL() {
		return MONTO_TOTAL;
	}

	public void setMONTO_TOTAL(Double mONTO_TOTAL) {
		MONTO_TOTAL = mONTO_TOTAL;
	}

	public String getTIPO_PAGO() {
		return TIPO_PAGO;
	}

	public void setTIPO_PAGO(String tIPO_PAGO) {
		TIPO_PAGO = tIPO_PAGO;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public Cliente getDNI() {
		return DNI;
	}

	public void setDNI(Cliente dNI) {
		DNI = dNI;
	}

	public Pedido getID_PEDIDO() {
		return ID_PEDIDO;
	}

	public void setID_PEDIDO(Pedido iD_PEDIDO) {
		ID_PEDIDO = iD_PEDIDO;
	}

	public Producto getID_PRODUCTO() {
		return ID_PRODUCTO;
	}

	public void setID_PRODUCTO(Producto iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
	}

	public Tipo_Pago getID_TIPO_PAGO() {
		return ID_TIPO_PAGO;
	}

	public void setID_TIPO_PAGO(Tipo_Pago iD_TIPO_PAGO) {
		ID_TIPO_PAGO = iD_TIPO_PAGO;
	}
    
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.ID_PAGO == null && other.ID_PAGO != null) || (this.ID_PAGO != null && !this.ID_PAGO.equals(other.ID_PAGO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Pago[ ID_PAGO=" + ID_PAGO + " ]";
    }
    

}
