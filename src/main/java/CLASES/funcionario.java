/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLASES;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author franc
 */
@Entity
public class funcionario implements Serializable {

    @OneToMany(mappedBy = "funcionariobservado")
    private List<observacion> observaciones;

    @OneToMany(mappedBy = "funcionariopremiado")
    private List<obtienelogro> obtienelogros;

   
    @OneToMany(mappedBy = "funcionarioasignado")
    private List<obtienecargo> fechacargobtenido;

    @OneToMany(mappedBy = "licenciadefuncionario")
    private List<licencia> licencias;

    @ManyToMany(mappedBy = "funcionariosasignados")
    private List<horarios> horariosdelfuncionario;

    @OneToMany(mappedBy = "funcionariofalta")
    private List<faltas> faltasdelfuncionario;

    @OneToMany(mappedBy = "funcionariodueniodelcarne")
    private List<carnets> carnetsdelfuncionario;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private Date FechaNacimiento;
    private String celular;
    private String apellido;
    private int cedula;
    private obtienelogro logrofuncionario;

    public List<observacion> getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(List<observacion> observaciones) {
        this.observaciones = observaciones;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public List<obtienelogro> getObtienelogros() {
        return obtienelogros;
    }

    public void setObtienelogros(List<obtienelogro> obtienelogros) {
        this.obtienelogros = obtienelogros;
    }

    public obtienelogro getLogrofuncionario() {
        return logrofuncionario;
    }

    public void setLogrofuncionario(obtienelogro logrofuncionario) {
        this.logrofuncionario = logrofuncionario;
    }
    public List<obtienecargo> getFechacargobtenido() {
        return fechacargobtenido;
    }

    public void setFechacargobtenido(List<obtienecargo> fechacargobtenido) {
        this.fechacargobtenido = fechacargobtenido;
    }

    public List<licencia> getLicencias() {
        return licencias;
    }

    public void setLicencias(List<licencia> licencias) {
        this.licencias = licencias;
    }

    public List<horarios> getHorariosdelfuncionario() {
        return horariosdelfuncionario;
    }

    public void setHorariosdelfuncionario(List<horarios> horariosdelfuncionario) {
        this.horariosdelfuncionario = horariosdelfuncionario;
    }

    public List<faltas> getFaltasdelfuncionario() {
        return faltasdelfuncionario;
    }

    public void setFaltasdelfuncionario(List<faltas> faltasdelfuncionario) {
        this.faltasdelfuncionario = faltasdelfuncionario;
    }

    public List<carnets> getCarnetsdelfuncionario() {
        return carnetsdelfuncionario;
    }

    public void setCarnetsdelfuncionario(List<carnets> carnetsdelfuncionario) {
        this.carnetsdelfuncionario = carnetsdelfuncionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
        if (!(object instanceof funcionario)) {
            return false;
        }
        funcionario other = (funcionario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
}
