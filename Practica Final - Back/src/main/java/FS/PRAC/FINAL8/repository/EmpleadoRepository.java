package FS.PRAC.FINAL8.repository;

import FS.PRAC.FINAL8.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    /**
     * Busca si existe un empleado en la BD.
     * */
    boolean existsByTxNif(String TX_NIF);

    /**
     * Muestra todos empleados con F_BAJA igual a NULL
     * */
    List<Empleado> findAllByFBajaIsNull();

    /**
     * Devuelve si el usuario tiene fecha de baja*/
    boolean existsByIdEmpleadoAndFBajaIsNull(int IdEmpleado);
}
