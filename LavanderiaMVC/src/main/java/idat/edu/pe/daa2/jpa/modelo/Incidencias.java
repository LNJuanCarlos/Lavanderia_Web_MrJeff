package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "INCIDENCIAS")
public class Incidencias implements Serializable {
	
private static final long serialVersionUID = 1L;
	

    @Id  
    @Basic(optional = false)
    @Column(name = "ID_INCIDENCIAS")
    private String ID_INCIDENCIAS;
    
    @Column(name = "ASUNTO_INC")
    private String ASUNTO_INC;
   
    @Column(name = "DESCRIPCION_INC")
    private String DESCRIPCION_INC;
    
    @Column(name = "ESTADO_INC")
    private String ESTADO_INC;
    
    @Column(name = "FEC_INC")
    private Date FEC_INC;
    
   
    
    @JoinColumn (name="DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Cliente DNI;
    
    
    @JoinColumn (name="ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    @ManyToOne(optional = false)
    private Pedido ID_PEDIDO;
    
    @JoinColumn (name="ID_OPINION", referencedColumnName = "ID_OPINION")
    @ManyToOne(optional = false)
    private Opinion ID_OPINION;
    
    @JoinColumn (name="ID_COMENTARIO", referencedColumnName = "ID_COMENTARIO")
    @ManyToOne(optional = false)
    private Comentario ID_COMENTARIO;

	
   
	public Incidencias() {
		
	}

	
	
	public Incidencias(String iD_INCIDENCIAS, String aSUNTO_INC, String dESCRIPCION_INC, String eSTADO_INC,
			Date fEC_INC, Cliente dNI, Pedido iD_PEDIDO, Opinion iD_OPINION, Comentario iD_COMENTARIO) {
		
		ID_INCIDENCIAS = iD_INCIDENCIAS;
		ASUNTO_INC = aSUNTO_INC;
		DESCRIPCION_INC = dESCRIPCION_INC;
		ESTADO_INC = eSTADO_INC;
		FEC_INC = fEC_INC;
		DNI = dNI;
		ID_PEDIDO = iD_PEDIDO;
		ID_OPINION = iD_OPINION;
		ID_COMENTARIO = iD_COMENTARIO;
	}



	public String getID_INCIDENCIAS() {
		return ID_INCIDENCIAS;
	}



	public void setID_INCIDENCIAS(String iD_INCIDENCIAS) {
		ID_INCIDENCIAS = iD_INCIDENCIAS;
	}



	public String getASUNTO_INC() {
		return ASUNTO_INC;
	}



	public void setASUNTO_INC(String aSUNTO_INC) {
		ASUNTO_INC = aSUNTO_INC;
	}



	public String getDESCRIPCION_INC() {
		return DESCRIPCION_INC;
	}



	public void setDESCRIPCION_INC(String dESCRIPCION_INC) {
		DESCRIPCION_INC = dESCRIPCION_INC;
	}



	public String getESTADO_INC() {
		return ESTADO_INC;
	}



	public void setESTADO_INC(String eSTADO_INC) {
		ESTADO_INC = eSTADO_INC;
	}



	public Date getFEC_INC() {
		return FEC_INC;
	}



	public void setFEC_INC(Date fEC_INC) {
		FEC_INC = fEC_INC;
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



	public Opinion getID_OPINION() {
		return ID_OPINION;
	}



	public void setID_OPINION(Opinion iD_OPINION) {
		ID_OPINION = iD_OPINION;
	}



	public Comentario getID_COMENTARIO() {
		return ID_COMENTARIO;
	}



	public void setID_COMENTARIO(Comentario iD_COMENTARIO) {
		ID_COMENTARIO = iD_COMENTARIO;
	}



	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidencias)) {
            return false;
        }
        Incidencias other = (Incidencias) object;
        if ((this.ID_INCIDENCIAS == null && other.ID_INCIDENCIAS != null) || (this.ID_INCIDENCIAS != null && !this.ID_INCIDENCIAS.equals(other.ID_INCIDENCIAS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Incidencias[ ID_INCIDENCIAS=" + ID_INCIDENCIAS + " ]";
    }
    
}
