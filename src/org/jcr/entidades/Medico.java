/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;

import org.jcr.enums.EspecialidadMedica;
import org.jcr.enums.TipoSangre;

public class Medico extends Persona {
  private String nombre;
  private String apellido;
  private String dni;
  private LocalDate fechaNacimiento;
  private TipoSangre tipoSangre;
  private String numeroMatricula;
  private EspecialidadMedica especialidad;

  public Medico(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo,
      String numeroMatricula, EspecialidadMedica especialidad) {
    super(nombre, apellido, dni, fechaNacimiento, tipo);
    this.numeroMatricula = numeroMatricula;
    this.especialidad = especialidad;
  }

    // public Matricula getMatricula() {
    //     return matricula;
    // }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }
  
  
}
