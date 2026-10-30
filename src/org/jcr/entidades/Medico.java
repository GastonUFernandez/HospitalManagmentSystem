/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jcr.enums.EspecialidadMedica;
import org.jcr.enums.TipoSangre;
import org.jcr.util.Validador;

public class Medico extends Persona {
  private Matricula matricula;
  private EspecialidadMedica especialidad;
  private Departamento departamento;
  private List<Cita> citas;

  public Medico(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo,
      String numeroMatricula, EspecialidadMedica especialidad) {
    super(nombre, apellido, dni, fechaNacimiento, tipo);

    Validador.validarObjeto(especialidad, "Especialidad médica");

    this.matricula = new Matricula(numeroMatricula);
    this.especialidad = especialidad;
    this.citas = new ArrayList<>();
  }

  public Matricula getMatricula() {
    return matricula;
  }

  public void setMatricula(Matricula matricula) {
    Validador.validarObjeto(matricula, "Matrícula");
    this.matricula = matricula;
  }

  public EspecialidadMedica getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(EspecialidadMedica especialidad) {
    Validador.validarObjeto(especialidad, "Especialidad médica");
    this.especialidad = especialidad;
  }

  public Departamento getDepartamento() {
    return departamento;
  }

  public void setDepartamento(Departamento departamento) {
    Validador.validarObjeto(departamento, "Departamento");
    if (especialidad != departamento.getEspecialidad()) {
      throw new IllegalArgumentException(
          "Error, la especialidad del medico no coincide con la especialidad del departamento. ");
    }
    this.departamento = departamento;
  }
  
  public List<Cita> getCitas() {
    return Collections.unmodifiableList(citas);
  }

  public void setCitas(Cita cita) {
    Validador.validarObjeto(cita, "Nueva cita");
    this.citas.add(cita);
  }
}
