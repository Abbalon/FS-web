/**
 * El modelo sigue la siguiente estrctura SQL
 * CREATE TABLE IF NOT EXISTS `practica_test`.`em_empleados` (
 * `id_Empleado` INT(11) NOT NULL AUTO_INCREMENT,
 * `b_Servmilitar` CHAR(1) NOT NULL,
 * `cx_Edocivil` CHAR(1) NOT NULL,
 * `f_Alta` DATETIME NOT NULL,
 * `f_Baja` DATETIME NULL DEFAULT NULL,
 * `f_Nacimiento` DATETIME NOT NULL,
 * `n_Telefono1` VARCHAR(12) NOT NULL,
 * `n_Telefono2` VARCHAR(12) NOT NULL,
 * `tx_Apellido1` VARCHAR(40) NOT NULL,
 * `tx_Apellido2` VARCHAR(40) NOT NULL,
 * `tx_Email` VARCHAR(40) NOT NULL,
 * `tx_Nif` VARCHAR(9) NOT NULL,
 * `tx_Nombre` VARCHAR(30) NOT NULL,
 * PRIMARY KEY (`id_Empleado`),
 * UNIQUE INDEX `UK_hl79rru3yioy0pfxt7wqaagu0` (`tx_Email` ASC),
 * UNIQUE INDEX `UK_m9qa9hlyn3s8dtqmbrvqmuac4` (`tx_Nif` ASC))
 * ENGINE = MyISAM
 * AUTO_INCREMENT = 3
 * DEFAULT CHARACTER SET = utf8
 */
package FS.PRAC.FINAL8.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "EM_EMPLEADOS")
public class Empleado {

    private static final String NOT_NULL = "Cannot be Null.";
    private static final String SIZE_LIMIT = "Limit of characters exceded or none founded.";

    /**
     *PRIMARY_KEY
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY, AUTO
    @Column(name = "id_Empleado")
    private int idEmpleado;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 9, message = SIZE_LIMIT)
    @Column(name = "tx_Nif", unique = true)
    private String txNif;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 30, message = SIZE_LIMIT)
    @Column(name = "tx_Nombre")
    private String txNombre;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 40, message = SIZE_LIMIT)
    @Column(name = "tx_Apellido1")
    private String txApellido1;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 40, message = SIZE_LIMIT)
    @Column(name = "tx_Apellido2")
    private String txApellido2;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 40, message = SIZE_LIMIT)
    @Column(name = "tx_Email", unique = true)
    private String txEmail;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 12, message = SIZE_LIMIT)
    @Column(name = "n_Telefono1")
    private String nTelefono1;

    @NotNull(message = NOT_NULL)
    @Size(min = 1, max = 12, message = SIZE_LIMIT)
    @Column(name = "n_Telefono2")
    private String nTelefono2;

    @NotNull(message = NOT_NULL)
    @Column(name = "f_Nacimiento")
    private Calendar fNacimiento;

    @NotNull(message = NOT_NULL)
    @Column(name = "f_Alta")
    private Calendar fAlta;


    @Column(name = "f_Baja")
    private Calendar fBaja;

    @NotNull(message = NOT_NULL)
    @Size(max = 1, message = SIZE_LIMIT)
    @Column(name = "cx_Edocivil")
    private String cxEdocivil;

    @NotNull(message = NOT_NULL)
    @Size(max = 1, message = SIZE_LIMIT)
    @Column(name = "b_Servmilitar")
    private String bServmilitar;

    /*@OneToMany(mappedBy = "empleado")
    private List<EmpleadoProyecto> proyectos;*/

    @ManyToMany
    @JoinTable(name = "PR_EMPLEADOS_PROYECTO", joinColumns = {
            @JoinColumn(name ="id_Empleado",nullable = false, updatable = false)
    },inverseJoinColumns = {
            @JoinColumn(name = "id_Proyecto", nullable = false, updatable = false)
    })
    private List<Proyecto> proyectos;

    /**
     * Default void constructor
     * */
    public Empleado() {
    }

    /**
     * Default copy constructor
     * */
    public Empleado(Empleado empleado) {
        this.setCxEdocivil(empleado.getCxEdocivil());
        this.setbServmilitar(empleado.getbServmilitar());
        this.setfAlta(empleado.getfAlta());
        this.setfBaja(empleado.getfBaja());
        this.setfNacimiento(empleado.getfNacimiento());
        this.setnTelefono1(empleado.getnTelefono1());
        this.setnTelefono2(empleado.getnTelefono2());
        this.setTxApellido1(empleado.getTxApellido1());
        this.setTxApellido2(empleado.getTxApellido2());
        this.setTxEmail(empleado.getTxEmail());
        this.setTxNif(empleado.getTxNif());
        this.setTxNombre(empleado.getTxNombre());
    }


    /**
     * Getters & Setters
     * */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTxNif() {
        return txNif;
    }

    public void setTxNif(String txNif) {
        this.txNif = txNif;
    }

    public String getTxNombre() {
        return txNombre;
    }

    public void setTxNombre(String txNombre) {
        this.txNombre = txNombre;
    }

    public String getTxApellido1() {
        return txApellido1;
    }

    public void setTxApellido1(String txApellido1) {
        this.txApellido1 = txApellido1;
    }

    public String getTxApellido2() {
        return txApellido2;
    }

    public void setTxApellido2(String txApellido2) {
        this.txApellido2 = txApellido2;
    }

    public String getTxEmail() {
        return txEmail;
    }

    public void setTxEmail(String txEmail) {
        this.txEmail = txEmail;
    }

    public String getnTelefono1() {
        return nTelefono1;
    }

    public void setnTelefono1(String nTelefono1) {
        this.nTelefono1 = nTelefono1;
    }

    public String getnTelefono2() {
        return nTelefono2;
    }

    public void setnTelefono2(String nTelefono2) {
        this.nTelefono2 = nTelefono2;
    }

    public Calendar getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(Calendar fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public Calendar getfAlta() {
        return fAlta;
    }

    public void setfAlta(Calendar fAlta) {
        this.fAlta = fAlta;
    }

    public Calendar getfBaja() {
        return fBaja;
    }

    public void setfBaja(Calendar fBaja) {
        this.fBaja = fBaja;
    }

    /**Returns parsed the employee's civil state*/
    public String getCxEdocivil() {
        return (this.cxEdocivil.equals("S")) ? "Soltero" : "Casado";
    }

    /**Set the capital letter*/
    public void setCxEdocivil(String cxEdocivil) {
        this.cxEdocivil = cxEdocivil.substring(0, 1);
    }

    public String getbServmilitar() {
        return (this.bServmilitar.equals("S")) ? "Sí" : "No";
    }

    public void setbServmilitar(String bServmilitar) {
        this.bServmilitar = bServmilitar.substring(0, 1);
    }

    /*public List<Proyecto> getProyectos() {
        return proyectos;
    }*/

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    /**Metodo que muestra el contenido del objeto Empleado*/
    @Override
    public String toString() {
        return "Empleado{" +
                ", idEmpleado=" + idEmpleado +
                ", txNif='" + txNif + '\'' +
                ", txNombre='" + txNombre + '\'' +
                ", txApellido1='" + txApellido1 + '\'' +
                ", txApellido2='" + txApellido2 + '\'' +
                ", txEmail='" + txEmail + '\'' +
                ", nTelefono1='" + nTelefono1 + '\'' +
                ", nTelefono2='" + nTelefono2 + '\'' +
                ", fNacimiento=" + fNacimiento +
                ", fAlta=" + fAlta +
                ", fBaja=" + fBaja +
                ", cxEdocivil=" + cxEdocivil +
                ", bServmilitar=" + bServmilitar +
                '}';
    }
}
