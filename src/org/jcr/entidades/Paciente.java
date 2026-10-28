/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;

import org.jcr.enums.TipoSangre;

public class Paciente extends Persona {
  private String nombre;
  private String apellido;
  private String dni;
  private LocalDate fechaNacimiento;
  private TipoSangre tipoSangre;
  private String telefono;
  private String direccion;
  private HistoriaClinica historia;

  public Paciente(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo,
      String telefono, String direccion) {
    super(nombre, apellido, dni, fechaNacimiento, tipo);
    this.telefono = telefono;
    this.direccion = direccion;
    this.historia = new HistoriaClinica();
  }

  public HistoriaClinica getHistoriaClinica() {
    return historia;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getDireccion() {
    return direccion;
  }

  // TODO: getHospital(), setHospital(Hospital)

  // TODO: addCita(Cita), getCitas()
}
