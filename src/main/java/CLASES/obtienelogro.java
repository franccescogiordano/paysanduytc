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
public class obtienelogro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date FechaObtencionLogro;
    @ManyToOne
    private funcionario funcionariopremiado;
    @ManyToOne
    private logros logrologrado;

    public funcionario getFuncionariopremiado() {
        return funcionariopremiado;
    }

    public void setFuncionariopremiado(funcionario funcionariopremiado) {
        this.funcionariopremiado = funcionariopremiado;
    }

    public logros getLogrologrado() {
        return logrologrado;
    }

    public void setLogrologrado(logros logrologrado) {
        this.logrologrado = logrologrado;
    }

    public Date getFechaObtencionLogro() {
        return FechaObtencionLogro;
    }

    public void setFechaObtencionLogro(Date FechaObtencionLogro) {
        this.FechaObtencionLogro = FechaObtencionLogro;
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
        if (!(object instanceof obtienelogro)) {
            return false;
        }
        obtienelogro other = (obtienelogro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return logrologrado.getLogro();
    }
    
}
