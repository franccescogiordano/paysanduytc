/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author franc
 */
@Entity
public class obtienecargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date FechaObtencionCargo;
   
  
    
   
    
    @ManyToOne
   private funcionario funcionarioasignado;

    public funcionario getFuncionarioasignado() {
        return funcionarioasignado;
    }

    public void setFuncionarioasignado(funcionario funcionarioasignado) {
        this.funcionarioasignado = funcionarioasignado;
    }
    @ManyToOne
     private cargo cargoobtenido;

    public Date getFechaObtencionCargo() {
        return FechaObtencionCargo;
    }

    public void setFechaObtencionCargo(Date FechaObtencionCargo) {
        this.FechaObtencionCargo = FechaObtencionCargo;
    }


    public cargo getCargoobtenido() {
        return cargoobtenido;
    }

    public void setCargoobtenido(cargo cargoobtenido) {
        this.cargoobtenido = cargoobtenido;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof obtienecargo)) {
            return false;
        }
        obtienecargo other = (obtienecargo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CLASES.obitenecargo[ id=" + id + " ]";
    }
    
}
