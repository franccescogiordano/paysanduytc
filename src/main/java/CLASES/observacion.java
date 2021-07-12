/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author franc
 */
@Entity
public class observacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fechaobservacion;

    public Date getFechaobservacion() {
        return fechaobservacion;
    }

    public void setFechaobservacion(Date fechaobservacion) {
        this.fechaobservacion = fechaobservacion;
    }
  

    public void setFuncionariobservado(funcionario funcionariobservado) {
        this.funcionariobservado = funcionariobservado;
    }
    private String descripcion;
    private String gravedad;
    @ManyToOne
    private funcionario funcionariobservado;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public funcionario getFuncionariobservado() {
        return funcionariobservado;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof observacion)) {
            return false;
        }
        observacion other = (observacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CLASES.observacion[ id=" + id + " ]";
    }
    
}
