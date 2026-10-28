/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;

import org.jcr.enums.TipoSangre;
import org.jcr.util.Validador;

public class Paciente extends Persona {
  private String telefono;
  private String direccion;
  private HistoriaClinica historialClinico;

  public Paciente(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo,
      String telefono, String direccion) {
    super(nombre, apellido, dni, fechaNacimiento, tipo);

    Validador.validarString(telefono, "Teléfono");
    Validador.validarString(direccion, "Dirección");

    this.telefono = telefono;
    this.direccion = direccion;

    this.historialClinico = new HistoriaClinica(this);
  }

  public String getTelefono() {
    return telefono;
  }

  public String getDireccion() {
    return direccion;
  }

}
