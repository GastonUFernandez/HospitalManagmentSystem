/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.enums;

/**
 *
 * @author Gastón Uriel Fernández
 */
public enum EspecialidadMedica {
    CARDIOLOGIA("Cardiología"),
    PEDIATRIA("Pediatría"),
    NEUROLOGIA("Neurología"),
    TRAUMATOLOGIA("Traumatología"),
    DERMATOLOGIA("Dermatología"),
    GINECOLOGIA("Ginecología"),
    MEDICINA_GENERAL("Medicina General"),
    OFALMOLOGIA("Oftalmología"),
    PSIQUIATRIA("Psiquiatría"),
    ONCOLOGIA("Oncología"),
    UROLOGIA("Urología"),
    OTORRINOLARINGOLOGIA("Otorrinolaringología");

    private final String descripcion;

    private EspecialidadMedica(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
