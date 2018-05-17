package FS.PRAC.FINAL8.controller;

public class RestURIConstants {
    /**
     * URI's para empleado
     * */
    /**POST*/
    public static final String ADD_EMPLEADO = "/empleado";//POST
    /**[PUT | DELETE]*/
    public static final String DEL_EMPLEADO = "/empleado";//[PUT | DELETE]
    /**GET*/
    public static final String GET_EMPLEADO = "/empleado";//GET

    /**
     * URI's para proyecto
     * */
    public static final String ADD_PROYECTO = "/proyecto";//POST
    public static final String DEL_PROYECTO = "/proyecto";//[PUT | DELETE]
    public static final String GET_PROYECTOS = "/proyecto";//GET Muestra todos los proyectos
    public static final String GET_PROYECTO = "/proyecto/{idPro}";//GET Muestra la info del proyecto seleccionado

    /**
     * URI's para proyecto-empleado
     * */
    public static final String ADD_PR_EM = "/prem";//POST
    public static final String DEL_PR_EM = "/prem";//[PUT | DELETE]
    public static final String GET_PR_EM = "/prem";//GET
    public static final String GET_EM_TO_PRO = "/prem/{idPro}";//GET muestra los empleados asignados a ese proyecto
}
