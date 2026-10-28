/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;

import org.jcr.enums.EspecialidadMedica;
import org.jcr.enums.TipoSangre;
import org.jcr.util.Validador;

public class Medico extends Persona {
  private EspecialidadMedica especialidad;
  private Matricula matricula;

  public Medico(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo,
      String numeroMatricula, EspecialidadMedica especialidad) {
    super(nombre, apellido, dni, fechaNacimiento, tipo);

    this.matricula = new Matricula(numeroMatricula);

    Validador.validarObjeto(especialidad, "Especialidad médica");
    this.especialidad = especialidad;
  }

  public Matricula getMatricula() {
    return matricula;
  }

  public EspecialidadMedica getEspecialidad() {
    return especialidad;
  }

}
