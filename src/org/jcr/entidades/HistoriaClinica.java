/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoriaClinica {
  private Paciente paciente;
  private String numeroHistoria;
  private List<String> diagnosticos = new ArrayList<>();
  private List<String> tratamientos = new ArrayList<>();
  private List<String> alergias = new ArrayList<>();

  HistoriaClinica(Paciente paciente) {
    this.numeroHistoria = "HC-" + paciente.getDni() + "-" + LocalDate.now().getYear();
    this.paciente = paciente;
  }

  public String getNumeroHistoria() {
    return numeroHistoria;
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public void agregarDiagnostico(String diagnostico) {
    if (diagnostico != null && !diagnostico.trim().isEmpty()) {
      diagnosticos.add(diagnostico);
    }
  }

  public List<String> getDiagnosticos() {
    return new ArrayList<>(diagnosticos);
  }

  public void agregarTratamiento(String tratamiento) {
    if (tratamiento != null && !tratamiento.trim().isEmpty()) {
      tratamientos.add(tratamiento);
    }
  }

  public List<String> getTratamientos() {
    return new ArrayList<>(tratamientos);
  }

  public void agregarAlergia(String alergia) {
    if (alergia != null && !alergia.trim().isEmpty()) {
      alergias.add(alergia);
    }
  }

  public List<String> getAlergias() {
    return new ArrayList<>(alergias);
  }
}
