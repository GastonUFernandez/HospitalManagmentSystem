/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDateTime;

import org.jcr.enums.EstadoCita;
import org.jcr.util.Validador;

public class Cita {
  private Paciente paciente;
  private Medico medico;
  private Sala sala;
  private LocalDateTime fechaHora;
  private double costo;
  private EstadoCita estado;
  private String observaciones;

  public Cita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fechaHora, double costo) {
    Validador.validarObjeto(paciente, "Paciente");
    Validador.validarObjeto(medico, "Medico");
    Validador.validarObjeto(sala, "Sala");
    Validador.validarObjeto(fechaHora, "Fecha y Hora de la cita");

    this.paciente = paciente;
    this.medico = medico;
    this.sala = sala;
    this.fechaHora = fechaHora;
    this.costo = costo;
    this.estado = EstadoCita.PROGRAMADA;
    this.observaciones = "";
  }

  public Paciente getPaciente() {
    return paciente;
  }

  public Medico getMedico() {
    return medico;
  }

  public Sala getSala() {
    return sala;
  }

  public LocalDateTime getFechaHora() {
    return fechaHora;
  }

  public double getCosto() {
    return costo;
  }

  public EstadoCita getEstado() {
    return estado;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setEstado(EstadoCita nuevoEstado) {
    Validador.validarObjeto(nuevoEstado, "Estado de Cita");

    this.estado = nuevoEstado;
  }

  public void setObservaciones(String nuevaObservacion) {
    if (nuevaObservacion == null || nuevaObservacion.trim().isEmpty()) {
      this.observaciones = "";
    } else {

      this.observaciones = nuevaObservacion;
    }
  }
}
