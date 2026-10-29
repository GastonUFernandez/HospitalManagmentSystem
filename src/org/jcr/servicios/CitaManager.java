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

  public Cita programarCita(Paciente paciente, Medico medico, Sala sala, LocalDateTime fecha, double costo)
      throws CitaException {
  };

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
