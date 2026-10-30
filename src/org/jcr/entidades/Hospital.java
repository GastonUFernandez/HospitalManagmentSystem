/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gastón Uriel Fernández
 */
public class Hospital {
  private String nombre;
  private String direccion;
  private String telefono;
  private List<Departamento> departamentos;
  private List<Paciente> pacientes;

  public Hospital(String nombre, String direccion, String telefono) {
    if (nombre == null || nombre.trim().isEmpty()) {
      throw new IllegalArgumentException("Error, El nombre del hospital no puede estar vacío.");
    }
    if (direccion == null || direccion.trim().isEmpty()) {
      throw new IllegalArgumentException("Error, la dirección no puede estar vacía.");
    }
    if (telefono == null || telefono.trim().isEmpty()) {
      throw new IllegalArgumentException("Error, el número de teléfono no puede estar vacío.");
    }

    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
    this.departamentos = new ArrayList<>();
    this.pacientes = new ArrayList<>();
  }

  public List<Departamento> getDepartamentos() {
    return Collections.unmodifiableList(departamentos);
  }

  public List<Paciente> getPacientes() {
    return Collections.unmodifiableList(pacientes);
  }

  public void agregarDepartamento(Departamento departamento) {
    if (departamento != null && !departamentos.contains(departamento)) {
      departamentos.add(departamento);
      if (departamento.getHospital() != this) {
        departamento.setHospital(this);
      }
    }
  }

  public void agregarPaciente(Paciente paciente) {
    if (paciente != null && !pacientes.contains(paciente)) {
      pacientes.add(paciente);
      if (paciente.getHospital() != this) {
        paciente.setHospital(this);
      }
    }
  }

  public void removerPaciente(Paciente paciente) {
    if (paciente != null && pacientes.contains(paciente)) {
      pacientes.remove(paciente);
      if (paciente.getHospital() == this) {
        paciente.setHospital(null);
      }
    }
  }
}
