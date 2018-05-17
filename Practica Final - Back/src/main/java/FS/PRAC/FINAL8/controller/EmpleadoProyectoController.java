/**
 * Controlador para el modelo EmpleadoProyecto
 *
 * @see: FS.PRAC.FINAL8.model.EmpleadoProyecto
 */

package FS.PRAC.FINAL8.controller;

import FS.PRAC.FINAL8.model.Empleado;
import FS.PRAC.FINAL8.model.EmpleadoProyecto;
import FS.PRAC.FINAL8.model.EmpleadoProyectoPK;
import FS.PRAC.FINAL8.model.Proyecto;
import FS.PRAC.FINAL8.repository.EmpleadoProyectoRepository;
import FS.PRAC.FINAL8.repository.EmpleadoRepository;
import FS.PRAC.FINAL8.repository.ProyectoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

import static FS.PRAC.FINAL8.controller.RestURIConstants.*;

//@RestController
@Controller
public class EmpleadoProyectoController {

    /** */
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoProyectoController.class);

    /**Control de fechas
     SimpleDateFormat sdf = new SimpleDateFormat();
     private Calendar fechaActual; // = Calendar.getInstance();*/

    @Autowired
    private EmpleadoProyectoRepository empleadoProyectoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    /**
     * Añade un empleadoProyecto en la BD, si no existe nadie con su NIF
     * */
    @RequestMapping(value = ADD_PR_EM, method = RequestMethod.POST)
    @ResponseBody
    public String addEmpleadoProyecto(
            @RequestBody EmpleadoProyectoPK pk
    ) {
        logger.info("Trying to asign a employee to a project");
        logger.info("");
        logger.info("Recived info:");
        logger.info(pk.toString());

        EmpleadoProyecto insertado = new EmpleadoProyecto(
                pk,
                empleadoRepository.getOne(pk.getIdEmpleado()),
                proyectoRepository.getOne(pk.getIdProyecto()),
                Calendar.getInstance());

        String message = "Asignacion de empleado a proyecto: ";

        try {
            if (!empleadoProyectoRepository.existsByPk(insertado.getPk())) { //¿Está ya el usuario en el proyecto?
                if (!empleadoRepository.existsByIdEmpleadoAndFBajaIsNull(insertado.getPk().getIdEmpleado())) { //¿Está el usuario dado de baja?
                    if (!proyectoRepository.existsByIdProyectoAndFBajaIsNullAndFFinIsNull(insertado.getPk().getIdProyecto())) { //¿Está el proyecto dado de baja o fianlizado?
                        //TODO Verificar campos: fechas ...
                        empleadoProyectoRepository.save(insertado);
                        message += "CORRECTA: " + insertado.toString();
                    } else {
                        message += "Proyecto no dado de alta o finalizado.";
                    }
                } else {
                    message += "Empleado no dado de alta o dado de baja.";
                }
            } else {
                logger.info("Employee: '" + insertado.getPk().getIdEmpleado() + "' already exists in the proyect " + insertado.getPk().getIdProyecto());
                message += "ya EXISTE";
            }

        } catch (Exception e) {
            ManErrorControler.showError(logger, e);
        }

        logger.info(message);

        return message;
    }

    /**
     * Inhabilita un empleadoProyecto en la BD
     *
     * */
    @RequestMapping(value = DEL_PR_EM, method = RequestMethod.PUT)
    @ResponseBody
    public boolean delEmpleadoProyecto(
            @RequestBody EmpleadoProyecto empleadoProyecto
    ) {
        boolean success = false;
        logger.info("Trying to disable a employee");
        logger.info("");

        String message = "EmpleadoProyecto: ";

        try {
            if (empleadoProyectoRepository.existsByPk(empleadoProyecto.getPk())) {
                empleadoProyectoRepository.delete(empleadoProyecto);
                message += "ELIMINADO";
                success = true;
            } else {
                logger.info("The employee: '" + empleadoProyecto.getPk().getIdEmpleado() + "' is not asigned to the proyect: " + empleadoProyecto.getPk().getIdProyecto());
                message += "NO EXISTE";
            }

        } catch (Exception e) {
            ManErrorControler.showError(logger, e);
            message += "FALTAN CAMPOS";
        }

        logger.info(message);

        return success;
    }

    /**
     * Muestra los empleadoProyectos cuya F_BAJA sea NULL
     * */
    @RequestMapping(value = GET_PR_EM, method = RequestMethod.GET)
    @ResponseBody
    public List<EmpleadoProyecto> getEmpleadoProyecto() {

        logger.info("Showing all employees-proyect");
        logger.info("");

        List<EmpleadoProyecto> allEmpleadoProyecto = null;

        try {
            allEmpleadoProyecto = empleadoProyectoRepository.findAll();
//            allEmpleadoProyecto = empleadoProyectoRepository.findAll();
            logger.info(allEmpleadoProyecto.toString());
        } catch (Exception e) {
            ManErrorControler.showError(logger, e);
        }

        return allEmpleadoProyecto;
    }

    /**
     * Muestra los empleados de un proyecto
     * */
    @RequestMapping(value = GET_EM_TO_PRO, method = RequestMethod.GET)
    @ResponseBody
    public List<Empleado> getEmpleados(
            @PathVariable("idPro") int idPro
    ) {

        logger.info("Showing all employees from a proyect");
        logger.info("");

        Proyecto proyectoSeleccionado = null;
        List<Empleado> EmpleadoAsignados = null;

        try {
            proyectoSeleccionado = proyectoRepository.getProyectoByIdProyecto(idPro);
            EmpleadoAsignados = proyectoSeleccionado.getEmpleados();
        } catch (Exception e) {
            ManErrorControler.showError(logger, e);
        }

        return EmpleadoAsignados;
    }
}
