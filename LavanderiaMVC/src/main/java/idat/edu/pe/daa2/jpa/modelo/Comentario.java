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
@Table(name = "COMENTARIO")
public class Comentario implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_COMENTARIO")
    private String ID_COMENTARIO;
    
    @Column(name = "DESCRIPCION")
    private String DESCRIPCION;
    
   

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_COMENTARIO", fetch=FetchType.LAZY)
    private List<Comentario> comentarioList;



	public Comentario() {
		
	}



	public Comentario(String iD_COMENTARIO, String dESCRIPCION, List<Comentario> comentarioList) {
		
		ID_COMENTARIO = iD_COMENTARIO;
		DESCRIPCION = dESCRIPCION;
		this.comentarioList = comentarioList;
	}



	public String getID_COMENTARIO() {
		return ID_COMENTARIO;
	}



	public void setID_COMENTARIO(String iD_COMENTARIO) {
		ID_COMENTARIO = iD_COMENTARIO;
	}



	public String getDESCRIPCION() {
		return DESCRIPCION;
	}



	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}



	public List<Comentario> getComentarioList() {
		return comentarioList;
	}



	public void setComentarioList(List<Comentario> comentarioList) {
		this.comentarioList = comentarioList;
	}
    
    
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.ID_COMENTARIO == null && other.ID_COMENTARIO != null) || (this.ID_COMENTARIO != null && !this.ID_COMENTARIO.equals(other.ID_COMENTARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Comentario[ ID_COMENTARIO=" + ID_COMENTARIO + " ]";
    }
}
