/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.jcr.entidades;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import org.jcr.util.Validador;





/**
 *
 * @author Gastón Uriel Fernández
 */
public class Sala {
    private String numero;
    private String tipo;
    private Departamento departamento;
    private List<Cita> citas;

    Sala(String numero, String tipo, Departamento departamento) {
        Validador.validarString(tipo, "Tipo de sala");
        Validador.validarString(numero, "Número de sala");
        if (departamento == null){
            throw new IllegalArgumentException("Error, el departamento no puede ser nulo.");
        }
        this.numero = numero;
        this.tipo = tipo;
        this.departamento = departamento;
        this.citas = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(citas);  
    }
    public void addCita(Cita cita) {
        if (cita != null && !citas.contains(cita)) {
            citas.add(cita);
        }
    }     
}
