package idat.edu.pe.daa2.jpa.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	
private static final long serialVersionUID = 1L;
	

    @Id  
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private String ID_USUARIO;
    
    @Column(name = "NOM_USUARIO")
    private String NOM_USUARIO;
    
    @Column(name = "PASSWORD")
    private String PASSWORD;
   
    @Column(name = "ESTADO")
    private String ESTADO;


	public Usuario() {
		
	}

	public Usuario(String iD_USUARIO, String nOM_USUARIO, String pASSWORD, String eSTADO) {
		
		ID_USUARIO = iD_USUARIO;
		NOM_USUARIO = nOM_USUARIO;
		PASSWORD = pASSWORD;
		ESTADO = eSTADO;
	}

	public String getID_USUARIO() {
		return ID_USUARIO;
	}

	public void setID_USUARIO(String iD_USUARIO) {
		ID_USUARIO = iD_USUARIO;
	}

	public String getNOM_USUARIO() {
		return NOM_USUARIO;
	}

	public void setNOM_USUARIO(String nOM_USUARIO) {
		NOM_USUARIO = nOM_USUARIO;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}


	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.ID_USUARIO == null && other.ID_USUARIO != null) || (this.ID_USUARIO != null && !this.ID_USUARIO.equals(other.ID_USUARIO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Usuario[ ID_USUARIO=" + ID_USUARIO + " ]";
    }
    
    
}
