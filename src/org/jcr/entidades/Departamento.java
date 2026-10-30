/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.jcr.enums.EspecialidadMedica;
import org.jcr.util.Validador;

/**
 *
 * @author Gastón Uriel Fernández
 */
public class Departamento {
  private String nombre;
  private EspecialidadMedica especialidad;
  private Hospital hospital;
  private List<Medico> medicos;
  private List<Sala> salas;

  public Departamento(String nombre, EspecialidadMedica especialidad) {
    Validador.validarString(nombre, "Nombre");
    if (especialidad == null) {
      throw new IllegalArgumentException("Error, no puede quedar el campo vacío.");
    }
    this.nombre = nombre;
    this.especialidad = especialidad;
    this.medicos = new ArrayList<>();
    this.salas = new ArrayList<>();
  }

  public void setHospital(Hospital hospital) {
    if (this.hospital != hospital) {
      Hospital hospitalAnterior = this.hospital;
      this.hospital = hospital;
      if (hospitalAnterior != null) {
          hospitalAnterior.removerDepartamento(this);
      }
      if (hospital != null && !hospital.getDepartamentos().contains(this)) {
        hospital.agregarDepartamento(this);
      }
    }
  }

  public Sala crearSala(String numero, String tipo) {
    Validador.validarObjeto(numero, tipo);
    Sala nuevaSala = new Sala(numero, tipo, this);
    salas.add(nuevaSala);
    return nuevaSala;
  }

  public void agregarMedico(Medico medico) {
    if (medico == null) {
      throw new IllegalArgumentException("Error, el campo no puede estar vacío.");
    }
    if (medico.getEspecialidad() != this.especialidad) {
      throw new IllegalArgumentException("Error, la especialidad no coincide con el departamento.");
    }
    if (!medicos.contains(medico)) {
      medicos.add(medico);
      if (medico.getDepartamento() != this) {
        medico.setDepartamento(this);
      }
    }
  }
  
  public void removerMedico(Medico medico) {
    if (medico != null && medicos.contains(medico)) {
      medicos.remove(medico);
      if (medico.getDepartamento() == this) {
        medico.setDepartamento(null);
      }
    }
  }

  public String getNombre() {
    return nombre;
  }

  public EspecialidadMedica getEspecialidad() {
    return especialidad;
  }

  public Hospital getHospital() {
    return hospital;
  }

  public List<Medico> getMedicos() {
    return Collections.unmodifiableList(medicos);
  }

  public List<Sala> getSalas() {
    return Collections.unmodifiableList(salas);
  }
}
