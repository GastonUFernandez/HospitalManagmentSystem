/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.jcr.entidades;

import java.time.LocalDate;
import org.jcr.enums.EspecialidadMedica;
import org.jcr.enums.TipoSangre;
import org.jcr.util.Validador;

public class Medico extends Persona {
    private Matricula matricula;
    private EspecialidadMedica especialidad;
    private Departamento departamento;

    public Medico(String nombre, String apellido, String dni, LocalDate fechaNacimiento, TipoSangre tipo,
        String numeroMatricula, EspecialidadMedica especialidad) {
        super(nombre, apellido, dni, fechaNacimiento, tipo);

        Validador.validarObjeto(especialidad, "Especialidad médica");
        
        this.matricula = new Matricula(numeroMatricula);
        this.especialidad = especialidad;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        Validador.validarObjeto(matricula, "Matrícula");
        this.matricula = matricula;
    }

    public EspecialidadMedica getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadMedica especialidad) {
        Validador.validarObjeto(especialidad, "Especialidad médica");
        this.especialidad = especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
