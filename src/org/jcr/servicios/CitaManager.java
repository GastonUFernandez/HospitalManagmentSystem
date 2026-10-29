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
  };

  public List<Cita> getCitasPorMedico(Medico medico) {
  };

  public List<Cita> getCitasPorSala(Sala sala) {
  };
}
