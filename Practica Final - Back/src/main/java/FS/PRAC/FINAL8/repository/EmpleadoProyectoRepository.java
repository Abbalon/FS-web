package FS.PRAC.FINAL8.repository;

import FS.PRAC.FINAL8.model.Empleado;
import FS.PRAC.FINAL8.model.EmpleadoProyecto;
import FS.PRAC.FINAL8.model.EmpleadoProyectoPK;
import FS.PRAC.FINAL8.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoProyectoRepository extends JpaRepository<EmpleadoProyecto, Integer> {

    /**Comprueba que no esté ya asignado un empleado a un proyecto*/
    boolean existsByPk(EmpleadoProyectoPK pk);

    /**Comprueba que halla algún proyecto con empleados asignados*/
    boolean existsByPk_IdEmpleado(int idEmpleado);

    List<Proyecto> findAllByEmpleado(Empleado empleado);

    /**Compruba que halla algún proyecto con empleados asignados*/
    boolean existsByPk_IdProyecto(int idProyecto);
}
