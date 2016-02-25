package exLuqueBravoAntonio;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

/**
 * Previamente a las instrucciones, recuerda:
 * 
 * El c�digo no s�lo ha de compilar y funcionar seg�n estas disposiciones, sino
 * que ha de ser entendible y eficiente, sin redundancia y con una finalidad
 * clara. Empaqueta todos los ficheros .java en el paquete
 * exNombreApellido1Apellido2 Recuerda mantener la visibilidadm�s adecuada Dale
 * al c�digo un formato legible. Entrega la carpeta completa del c�digo fuente
 * comprimida en un fichero exNombreApellido1Apellido2 Genera la documentaci�n
 * javadoc y entr�gala junto con el resto de los documentos. Para ello: Cada
 * clase ha de tener su comentario junto con el nombre del autor correctamente
 * identificado seg�n javadoc Documenta en cada clase al menos un campo un
 * m�todo, con sus argumentos
 * 
 * Implementa al menos tres clases: TestCuentas, Persona y Cuenta y a��dele los
 * campos y m�todos que estimes oportunos seg�n estas instrucciones. Se nos pide
 * implementar el comportamiento de una cuenta corriente. Queremos hacer
 * hincapi� en el n�mero de cuenta, que ha de ser �nico. En este caso el n�mero
 * de cuenta se generar� mediante un contador com�n a todas las cuentas. La
 * primera cuenta deber� tener el c�digo de cuenta con valor 1. La cuenta
 * permitir� al menos las siguientes operaciones:
 * 
 * Ingreso a la cuenta de una cantidad de dinero. Reintegro de la cuenta de una
 * cantidad de dinero. La cuenta no puede llegar a n�meros rojos. En tal caso,
 * el reintegro no puede llevarse a cabo. Transferencia de una cantidad de
 * dinero desde una cuenta a otro. La cuenta origen de la transferencia no puede
 * llegar a n�meros rojos. En tal caso, la transferencia no puede llevarse a
 * cabo. Mostrar el estado de la cuenta, donde aparezcan todos los
 * atributos(toString())
 * 
 * Crea una clase TestCuentas donde estar� el m�todo main que lleve a cabo las
 * siguientes operaciones:
 * 
 * Ha de crear dos cuentas con las siguientes caracter�sticas: Primera cuenta:
 * de "Mortadelo", con dni 11223344 y direcci�n Mikasa. Saldo inicial de la
 * cuenta: 1000 euros Segunda cuenta: de Filemon, con dni 55667788 y direcci�n
 * Calle del Medio. Saldo inicial: 2000 euros. Una vez creadas las dos cuentas,
 * sobre la cuenta de Mortadelo han de realizarse las siguientes operaciones: Un
 * reintegro de 500 euros Un cambio de domicilio a la nueva direcci�n 13, Rue
 * del Percebe Una transferencia de la cuenta de Mortadelo a la de Filem�n, de
 * una cantidad de 500 euros. Una segunda transferencia de la cuenta de
 * Mortadelo a la de Filem�n, de una cantidad de 500 euros Un reintegro de la
 * cuenta de Mortadelo de 7 euros.
 * 
 * Como resultado, el programa mostrar� los siguientes mensajes: Cuenta: 1,
 * 1000.0, 11223344, Mortadelo, Mikasa. Cuenta: 2, 2000.0, 55667788, Filemon,
 * Calle del Medio.
 * 
 * --Despu�s de reintegro(500) Cuenta: 1, 500.0, 11223344, Mortadelo, Mikasa.
 * 
 * --Despu�s de setDireccion("13, Rue del Percebe") 11223344, Mortadelo, 13, Rue
 * del Percebe.
 * 
 * --Despu�s de transferencia(500) Cuenta: 1, 0.0, 11223344, Mortadelo, 13, Rue
 * del Percebe. Cuenta: 2, 2500.0, 55667788, Filemon, Calle del Medio. ERROR. No
 * se ha podido realizar la transferencia.
 * 
 * --Despu�s de transferencia(500) Cuenta: 1, 0.0, 11223344, Mortadelo, 13, Rue
 * del Percebe. Cuenta: 2, 2500.0, 55667788, Filemon, Calle del Medio. ERROR. No
 * se ha podido realizar el reintegro
 * 
 * --Despu�s de reintegro(7) Cuenta: 1, 0.0, 11223344, Mortadelo, 13, Rue del
 * Percebe.
 * 
 * Aseg�rate de que:
 * 
 * El DNI del titular es v�lido (expresi�n regular y algoritmo) En caso de
 * introducir un DNI err�neo o sin letra, se le indicar� al usario previamente a
 * la creaci�n del titular. Siempre se le exigir� la letra correcta. Lanza una
 * excepci�n en el caso en que el dni no sea correcto o el resto de los datos no
 * cumplan un m�nimo de formato. (regex)
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class Persona {
	/**
	 * Nombre de la persona.
	 */
	private String nombre;
	/**
	 * DNI de la persona.
	 */
	private String dni;
	/**
	 * Direcci&oacute;n del hogar de la persona.
	 */
	private String direccion;
	/**
	 * Cuenta corriente de la persona.
	 */
	private Cuenta cuenta;

	// private static final String DNI_PATTERN = "^[0-9]{8}[A-Z&&[^IOU]]$";
	/**
	 * Costructor de Persona.
	 * 
	 * @param nombre
	 *            Nombre de la persona.
	 * @param dni
	 *            DNI de la persona.
	 * @param direccion
	 *            Direcci&oacute;n del hogar de la persona.
	 * @param cuenta
	 *            Cuenta corriente de la persona.
	 */
	Persona(String nombre, String dni, String direccion, Cuenta cuenta) {// throws
																			// DniInvalidoException
																			// {
		setNombre(nombre);
		setDni(dni);
		setDireccion(direccion);
		setCuenta(cuenta);
	}

	/**
	 * Setter para la cuenta corriente de la persona.
	 * 
	 * @param cuenta
	 *            cuenta corriente de la persona.
	 */
	private void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * Getter de Cuenta.
	 * 
	 * @return Devuelve el estado del campo cuenta.
	 */
	Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * Setter de la direcci&oacute;n.
	 * 
	 * @param direccion
	 *            Direcci&oacute;n de la persona.
	 */
	void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Getter de la Direcci&oacute;n.
	 * 
	 * @return Devuelve el estado del campo direcci&oacute;n.
	 */
	String getDireccion() {
		return direccion;
	}

	/**
	 * Getter del DNI.
	 * 
	 * @return Devuelve el estado del campo DNI.
	 */
	String getDni() {
		return dni;
	}

	/**
	 * Setter del campo DNI.
	 * 
	 * @param dni
	 *            DNI de la persona.
	 */
	private void setDni(String dni) {// throws DniInvalidoException {
		// Pattern patron = Pattern.compile(DNI_PATTERN);
		// Matcher matcher = patron.matcher(dni);
		// if (matcher.find()) {
		this.dni = dni;
		// } else {
		// throw new DniInvalidoException();
		// }
	}

	/**
	 * Getter del nombre.
	 * 
	 * @return Devuelve el nombre de la persona.
	 */
	String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre.
	 * 
	 * @param nombre
	 *            Nombre de la persona.
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Muestra a la Persona.
	 * 
	 * @return Devuelve una cadena con la persona.
	 */
	public String mostrar() {
		return dni + ", " + nombre + ", " + direccion + ".";
	}

	@Override
	public String toString() {
		return cuenta + ", " + dni + ", " + nombre + ", " + direccion + ".";
	}
}
