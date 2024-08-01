/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

/**
 *
 * @author LENOVO
 */
import Services.PacienteService;
import Models.Paciente;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PacienteService pacienteService = new PacienteService();

        // Crear un nuevo paciente
        Paciente nuevoPaciente = new Paciente(
                "1",
                "Juan Perez",
                "123 Calle Principal",
                LocalDate.of(1985, 5, 15),
                LocalDate.now(),
                "Pabellon A"
        );
        pacienteService.createPaciente(nuevoPaciente);

        // Leer un paciente
        Paciente pacienteLeido = pacienteService.readPaciente("1");
        System.out.println("Paciente leído: " + pacienteLeido.getNombreCompleto());

        // Actualizar un paciente
        pacienteLeido.setDireccion("456 Calle Secundaria");
        pacienteService.updatePaciente(pacienteLeido);

        // Listar todos los pacientes
        List<Paciente> pacientes = pacienteService.listPacientes();
        System.out.println("Lista de pacientes:");
        for (Paciente paciente : pacientes) {
            System.out.println(paciente.getNombreCompleto());
        }

        // Eliminar un paciente
        pacienteService.deletePaciente("1");
    }
}
