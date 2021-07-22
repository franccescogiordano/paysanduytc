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
public class carnets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String tipocarnet;
    private Date fechavencimiento;
    private Date FechaRenovacion;
    private String estado="Vigente";

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    @ManyToOne
    private funcionario funcionariodueniodelcarne;

    public String getTipocarnet() {
        return tipocarnet;
    }

    public void setTipocarnet(String tipocarnet) {
        this.tipocarnet = tipocarnet;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public Date getFechaRenovacion() {
        return FechaRenovacion;
    }

    public void setFechaRenovacion(Date FechaRenovacion) {
        this.FechaRenovacion = FechaRenovacion;
    }

    public funcionario getFuncionariodueniodelcarne() {
        return funcionariodueniodelcarne;
    }

    public void setFuncionariodueniodelcarne(funcionario funcionariodueniodelcarne) {
        this.funcionariodueniodelcarne = funcionariodueniodelcarne;
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
        if (!(object instanceof carnets)) {
            return false;
        }
        carnets other = (carnets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getFuncionariodueniodelcarne().getNombre();
    }
    
}
