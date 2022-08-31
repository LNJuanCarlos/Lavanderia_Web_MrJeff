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
@Table(name = "OPINION")
public class Opinion implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_OPINION")
    private String ID_OPINION;
    
    @Column(name = "PUNTUACION")
    private int PUNTUACION;
    
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_OPINION", fetch=FetchType.LAZY)
    private List<Opinion> opinionList;



	public Opinion() {
		
	}



	public Opinion(String iD_OPINION, int pUNTUACION, List<Opinion> opinionList) {
		
		ID_OPINION = iD_OPINION;
		PUNTUACION = pUNTUACION;
		this.opinionList = opinionList;
	}



	public String getID_OPINION() {
		return ID_OPINION;
	}



	public void setID_OPINION(String iD_OPINION) {
		ID_OPINION = iD_OPINION;
	}



	public int getPUNTUACION() {
		return PUNTUACION;
	}



	public void setPUNTUACION(int pUNTUACION) {
		PUNTUACION = pUNTUACION;
	}



	public List<Opinion> getOpinionList() {
		return opinionList;
	}



	public void setOpinionList(List<Opinion> opinionList) {
		this.opinionList = opinionList;
	}
    
    
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opinion)) {
            return false;
        }
        Opinion other = (Opinion) object;
        if ((this.ID_OPINION == null && other.ID_OPINION != null) || (this.ID_OPINION != null && !this.ID_OPINION.equals(other.ID_OPINION))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Opinion[ ID_OPINION=" + ID_OPINION + " ]";
    }

}
