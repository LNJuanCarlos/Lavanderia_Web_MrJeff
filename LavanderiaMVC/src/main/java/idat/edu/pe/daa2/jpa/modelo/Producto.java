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
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

private static final long serialVersionUID = 1L;
	

    @Id  
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private String ID_PRODUCTO;
    
    @Column(name = "NOMBRE_PRODUCTO")
    private String NOMBRE_PRODUCTO;
    
    @Column(name = "VALOR_UNITARIO")
    private int VALOR_UNITARIO;
   
    @JoinColumn (name="ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria ID_CATEGORIA;

	public Producto() {

	}

	public Producto(String iD_PRODUCTO, String nOMBRE_PRODUCTO, int vALOR_UNITARIO, Categoria iD_CATEGORIA) {
		
		ID_PRODUCTO = iD_PRODUCTO;
		NOMBRE_PRODUCTO = nOMBRE_PRODUCTO;
		VALOR_UNITARIO = vALOR_UNITARIO;
		ID_CATEGORIA = iD_CATEGORIA;
	}

	public String getID_PRODUCTO() {
		return ID_PRODUCTO;
	}

	public void setID_PRODUCTO(String iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
	}

	public String getNOMBRE_PRODUCTO() {
		return NOMBRE_PRODUCTO;
	}

	public void setNOMBRE_PRODUCTO(String nOMBRE_PRODUCTO) {
		NOMBRE_PRODUCTO = nOMBRE_PRODUCTO;
	}

	public int getVALOR_UNITARIO() {
		return VALOR_UNITARIO;
	}

	public void setVALOR_UNITARIO(int vALOR_UNITARIO) {
		VALOR_UNITARIO = vALOR_UNITARIO;
	}

	public Categoria getID_CATEGORIA() {
		return ID_CATEGORIA;
	}

	public void setID_CATEGORIA(Categoria iD_CATEGORIA) {
		ID_CATEGORIA = iD_CATEGORIA;
	}
    
	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.ID_PRODUCTO == null && other.ID_PRODUCTO != null) || (this.ID_PRODUCTO != null && !this.ID_PRODUCTO.equals(other.ID_PRODUCTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idat.edu.pe.daa2.jpa.modelo.Producto[ ID_PRODUCTO=" + ID_PRODUCTO + " ]";
    } 

}
