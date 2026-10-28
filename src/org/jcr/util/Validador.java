
package org.jcr.util;

public class Validador {

  // Validar textos obligatorios (nulos, vacíos o solo espacios)
  public static void validarString(String valor, String nombreCampo) {
    if (valor == null || valor.trim().isEmpty()) {
      throw new IllegalArgumentException("El campo " + nombreCampo + " no puede ser nulo o vacío.");
    }
  }

  // Validar formato de DNI (7 u 8 dígitos numéricos)
  public static void validarDni(String dni) {
    validarString(dni, "DNI");
    if (!dni.matches("^\\d{7,8}$")) {
      throw new IllegalArgumentException("El DNI debe tener entre 7 y 8 dígitos numéricos.");
    }
  }

  // Validar formato de matrícula médica (MP- seguido de 4 a 6 dígitos)
  public static void validarMatricula(String numeroMatricula) {
    validarString(numeroMatricula, "Matrícula");
    if (!numeroMatricula.startsWith("MP-")) {
      throw new IllegalArgumentException("La matrícula debe comenzar con 'MP-'.");
    }
    String resto = numeroMatricula.substring(3);
    if (resto.length() < 4 || resto.length() > 6) {
      throw new IllegalArgumentException("La matrícula debe tener entre 4 y 6 dígitos después de 'MP-'.");
    }
    for (int i = 0; i < resto.length(); i++) {
      if (!Character.isDigit(resto.charAt(i))) {
        throw new IllegalArgumentException("Los caracteres posteriores a 'MP-' deben ser dígitos.");
      }
    }
  }

  // Validar que un objeto no sea nulo
  public static void validarObjeto(Object objeto, String nombreCampo) {
    if (objeto == null) {
      throw new IllegalArgumentException("El campo " + nombreCampo + " no puede ser nulo.");
    }
  }
}
