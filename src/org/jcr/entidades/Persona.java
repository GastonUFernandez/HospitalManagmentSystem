/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;
import java.time.Period;

import org.jcr.enums.TipoSangre;
<<<<<<< Updated upstream
import org.jcr.util.Validador;
=======
>>>>>>> Stashed changes

public abstract class Persona {
  private String nombre;
  private String apellido;
  private String dni;
  private LocalDate fechaNacimiento;
  private TipoSangre tipoSangre;

  Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo) {
<<<<<<< Updated upstream
    Validador.validarString(nombre, "Nombre");
    Validador.validarString(apellido, "Apellido");
    Validador.validarDni(dni);
    Validador.validarObjeto(tipo, "Tipo de sangre");
    Validador.validarObjeto(fechaNacimiento, "Fecha de nacimiento");

=======
>>>>>>> Stashed changes
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaNacimiento = fechaNacimiento;
    this.tipoSangre = tipo;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getNombreCompleto() {
    return nombre + " " + apellido;
  }

  public String getDni() {
    return dni;
  }

  public LocalDate getFechaNacimiento() {
    return fechaNacimiento;
  }

  public int getEdad() {
    LocalDate hoy = LocalDate.now();
    Period diferencia = Period.between(fechaNacimiento, hoy);
    return diferencia.getYears();
  }

  public TipoSangre getTipoSangre() {
    return tipoSangre;
  }
}
