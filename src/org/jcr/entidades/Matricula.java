package org.jcr.entidades;

import org.jcr.util.Validador;

public class Matricula {
  private String numero;

  public Matricula(String numero) {
    Validador.validarMatricula(numero);
    this.numero = numero;
  }

  public String getNumero() {
    return numero;
  }
}
