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
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Id  
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIA")
    private String ID_CATEGORIA;
    
    @Column(name = "DESC_CATEGORIA")
    private String DESC_CATEGORIA;
  

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ID_CATEGORIA", fetch=FetchType.LAZY)
    private List<Categoria> categoriaList;


	public Categoria() {
		
	}


	public Categoria(String iD_CATEGORIA, String dESC_CATEGORIA, List<Categoria> categoriaList) {
		
		ID_CATEGORIA = iD_CATEGORIA;
		DESC_CATEGORIA = dESC_CATEGORIA;
		this.categoriaList = categoriaList;
	}


	public String getID_CATEGORIA() {
		return ID_CATEGORIA;
	}


	public void setID_CATEGORIA(String iD_CATEGORIA) {
		ID_CATEGORIA = iD_CATEGORIA;
	}


	public String getDESC_CATEGORIA() {
		return DESC_CATEGORIA;
	}


	public void setDESC_CATEGORIA(String dESC_CATEGORIA) {
		DESC_CATEGORIA = dESC_CATEGORIA;
	}


	public List<Categoria> getCategoriaList() {
		return categoriaList;
	}


	public void setCategoriaList(List<Categoria> categoriaList) {
		this.categoriaList = categoriaList;
	}
    
	public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.ID_CATEGORIA == null && other.ID_CATEGORIA != null) || (this.ID_CATEGORIA != null && !this.ID_CATEGORIA.equals(other.ID_CATEGORIA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Categoria[ ID_CATEGORIA=" + ID_CATEGORIA + " ]";
    }
	
}
