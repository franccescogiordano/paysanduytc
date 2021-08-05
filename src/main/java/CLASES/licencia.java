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
public class licencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int DiasTomados;
    private Date Desde;
    private Date Hasta;
    private Date FechaDeSolicitud;
    @ManyToOne
    private funcionario licenciadefuncionario;

    public int getDiasTomados() {
        return DiasTomados;
    }

    public void setDiasTomados(int DiasTomados) {
        this.DiasTomados = DiasTomados;
    }

    public Date getDesde() {
        return Desde;
    }

    public void setDesde(Date Desde) {
        this.Desde = Desde;
    }

    public Date getHasta() {
        return Hasta;
    }

    public void setHasta(Date Hasta) {
        this.Hasta = Hasta;
    }

    public Date getFechaDeSolicitud() {
        return FechaDeSolicitud;
    }

    public void setFechaDeSolicitud(Date FechaDeSolicitud) {
        this.FechaDeSolicitud = FechaDeSolicitud;
    }

    public funcionario getLicenciadefuncionario() {
        return licenciadefuncionario;
    }

    public void setLicenciadefuncionario(funcionario licenciadefuncionario) {
        this.licenciadefuncionario = licenciadefuncionario;
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
        if (!(object instanceof licencia)) {
            return false;
        }
        licencia other = (licencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return licenciadefuncionario.getNombre()+" "+ licenciadefuncionario.getApellido();
    }
    
}
