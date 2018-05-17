/**
 * Controlador para el modelo Empleado
 *
 * @see: FS.PRAC.FINAL8.model.Empleado
 * */

package FS.PRAC.FINAL8.controller;

import FS.PRAC.FINAL8.model.Empleado;
import FS.PRAC.FINAL8.repository.EmpleadoProyectoRepository;
import FS.PRAC.FINAL8.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static FS.PRAC.FINAL8.controller.RestURIConstants.*;

//@RestController
@Controller
public class EmpleadoController {

    /** */
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    /**Control de fechas*/
    SimpleDateFormat sdf = new SimpleDateFormat();
    private Calendar fechaActual; // = Calendar.getInstance();

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoProyectoRepository emPre;

    /**
     * Añade un empleado en la BD, si no existe nadie con su NIF
     * */
    @RequestMapping(value = ADD_EMPLEADO, method = RequestMethod.POST)//, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE
    @ResponseBody
    public Empleado addEmpleado(
                @RequestBody Empleado empleado
            ){
        logger.info("Trying to create a new employee");
        logger.info("");
        logger.info("Recived info:");
        logger.info(empleado.toString());

        String message = "Empleado: ";

        try{
            if(!empleadoRepository.existsByTxNif(empleado.getTxNif())){
                //TODO Verificar campos: fechas ...
                empleadoRepository.save(empleado);
                message += "AÑADIDO";
            }
            else{
                logger.info("The NIF: '" + empleado.getTxNif() + "' already exists in the system.");
                message += "‘Es obligatorio introducir todos los datos para dar de alta un nuevo empleado’";
            }

        }catch (Exception e){
            ManErrorControler.showError(logger, e);
        }

        logger.info(message);

        return empleado;
    }

    /**
     * Inhabilita un empleado en la BD
     *
     * */
    @RequestMapping(value = DEL_EMPLEADO, method = RequestMethod.PUT)
    @ResponseBody
    public boolean delEmpleado(
            @RequestBody Empleado empleado
    ){
        boolean success = false;

        logger.info("Trying to disable a employee");
        logger.info("");
        logger.info(empleado.toString());

        String message = "Empleado: ";

        try{
            if(!emPre.existsByPk_IdEmpleado(empleado.getIdEmpleado())) {
                if (empleadoRepository.existsByTxNif(empleado.getTxNif())) {
                    empleado.setfBaja(Calendar.getInstance());
                    empleadoRepository.save(empleado);
                    message += "ELIMINADO";
                    success = true;
                } else {
                    logger.info("The NIF: '" + empleado.getTxNif() + "' does not exists in the system.");
                    message += "NO EXISTE";
                }
            } else {
                logger.info("The employee: '" + empleado.getTxNif() + "' is asigned to a proyect.");
                message += "‘No se puede dar de baja al empleado "+ empleado.getTxNombre() + " "
                + empleado.getTxApellido1() + " " + empleado.getTxApellido2() + " porque está asignado a algún proyecto.";
            }

        }catch (Exception e){
            ManErrorControler.showError(logger, e);
            message += "FALTAN CAMPOS";
    }

        logger.info(message);

        return success;
    }

    /**
     * Muestra los empleados cuya F_BAJA sea NULL
     * */
    @RequestMapping(value = GET_EMPLEADO, method = RequestMethod.GET)
    @ResponseBody
    public List<Empleado> getEmpleado(){

        logger.info("Showing all employees");
        logger.info("");

        List<Empleado> allEmpleado = null;

        try{
            allEmpleado = empleadoRepository.findAllByFBajaIsNull();
//            allEmpleado = empleadoRepository.findAll();
        }catch (Exception e){
            ManErrorControler.showError(logger, e);
        }

        return allEmpleado;
    }
}
