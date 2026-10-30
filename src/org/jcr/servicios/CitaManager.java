/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.servicios;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.jcr.entidades.Cita;
import org.jcr.entidades.Medico;
import org.jcr.entidades.Paciente;
import org.jcr.entidades.Sala;
import org.jcr.excepciones.CitaException;

public class CitaManager implements CitaService {
  private List<Cita> listaCitas;
  static final int HORAS_ENTRE_CITAS = 2;

  public CitaManager() {
    this.listaCitas = new ArrayList<>();
  }

  @Override
  public Cita programarCita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fecha, double costo)
      throws CitaException {
    if (paciente == null || medico == null || sala == null || fecha == null || costo < 0) {
      throw new IllegalArgumentException("Error el campo no puede estar vacío. ");
    }

    if (fecha.isBefore(LocalDateTime.now())) {
      throw new CitaException("Error: No se puede programar una cita en una fecha pasada.");
    }

    if (!medico.getEspecialidad().equals(sala.getDepartamento().getEspecialidad())) {
      throw new CitaException("Error: La especialidad del médico no coincide con la de la sala.");
    }

    // 1. Validar la superposición contra las citas existentes PRIMERO
    for (Cita c : listaCitas) {
      boolean mismoMedico = c.getMedico().equals(medico);
      boolean mismaSala = c.getSala().equals(sala);

      if (mismoMedico || mismaSala) {
        long minutosDiferencia = Math.abs(java.time.temporal.ChronoUnit.MINUTES.between(c.getFechaHora(), fecha));
        if (minutosDiferencia < 120) {
          throw new CitaException("Error: Existe una superposición de menos de 2 horas para el médico o la sala.");
        }
      }
    }
    
    // Crea una nueva Cita
    Cita cita = new Cita(paciente, medico, sala, fecha, costo);
    listaCitas.add(cita);
    
    // Agrega la cita a Paciente y Medico
    paciente.addCita(cita);
    medico.addCita(cita);
    
    return cita;
  }

  @Override
  public List<Cita> getCitasPorPaciente(Paciente paciente) {
    List<Cita> resultado = new ArrayList<>();

    // Valida que el paciente no sea nulo
    if (paciente == null) {
      return resultado;
    }

    for (Cita cita : listaCitas) {
      // Valida que la cita sea del paciente
      if (cita.getPaciente().equals(paciente)) {
        resultado.add(cita);
      }
    }

    return resultado;
  };

  @Override
  public List<Cita> getCitasPorMedico(Medico medico) {
    List<Cita> resultado = new ArrayList<>();

    // Valida que el medico no sea nulo
    if (medico == null) {
      return resultado;
    }

    for (Cita cita : listaCitas) {
      // Valida que la cita sea del medico
      if (cita.getMedico().equals(medico)) {
        resultado.add(cita);
      }
    }

    return resultado;
  };

  @Override
  public List<Cita> getCitasPorSala(Sala sala) {
    List<Cita> resultado = new ArrayList<>();

    // Valida que la sala no sea nulo
    if (sala == null) {
      return resultado;
    }

    for (Cita cita : listaCitas) {
      // Valida que la cita sea de la sala
      if (cita.getSala().equals(sala)) {
        resultado.add(cita);
      }
    }

    return resultado;
  };
}
