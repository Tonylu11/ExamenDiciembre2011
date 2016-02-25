package exLuqueBravoAntonio;

/**
 * Previamente a las instrucciones, recuerda:
 * 
 * El código no sólo ha de compilar y funcionar según estas disposiciones, sino
 * que ha de ser entendible y eficiente, sin redundancia y con una finalidad
 * clara. Empaqueta todos los ficheros .java en el paquete
 * exNombreApellido1Apellido2 Recuerda mantener la visibilidadmás adecuada Dale
 * al código un formato legible. Entrega la carpeta completa del código fuente
 * comprimida en un fichero exNombreApellido1Apellido2 Genera la documentación
 * javadoc y entrégala junto con el resto de los documentos. Para ello: Cada
 * clase ha de tener su comentario junto con el nombre del autor correctamente
 * identificado según javadoc Documenta en cada clase al menos un campo un
 * método, con sus argumentos
 * 
 * Implementa al menos tres clases: TestCuentas, Persona y Cuenta y añádele los
 * campos y métodos que estimes oportunos según estas instrucciones. Se nos pide
 * implementar el comportamiento de una cuenta corriente. Queremos hacer
 * hincapié en el número de cuenta, que ha de ser único. En este caso el número
 * de cuenta se generará mediante un contador común a todas las cuentas. La
 * primera cuenta deberá tener el código de cuenta con valor 1. La cuenta
 * permitirá al menos las siguientes operaciones:
 * 
 * Ingreso a la cuenta de una cantidad de dinero. Reintegro de la cuenta de una
 * cantidad de dinero. La cuenta no puede llegar a números rojos. En tal caso,
 * el reintegro no puede llevarse a cabo. Transferencia de una cantidad de
 * dinero desde una cuenta a otro. La cuenta origen de la transferencia no puede
 * llegar a números rojos. En tal caso, la transferencia no puede llevarse a
 * cabo. Mostrar el estado de la cuenta, donde aparezcan todos los
 * atributos(toString())
 * 
 * Crea una clase TestCuentas donde estará el método main que lleve a cabo las
 * siguientes operaciones:
 * 
 * Ha de crear dos cuentas con las siguientes características: Primera cuenta:
 * de "Mortadelo", con dni 11223344 y dirección Mikasa. Saldo inicial de la
 * cuenta: 1000 euros Segunda cuenta: de Filemon, con dni 55667788 y dirección
 * Calle del Medio. Saldo inicial: 2000 euros. Una vez creadas las dos cuentas,
 * sobre la cuenta de Mortadelo han de realizarse las siguientes operaciones: Un
 * reintegro de 500 euros Un cambio de domicilio a la nueva dirección 13, Rue
 * del Percebe Una transferencia de la cuenta de Mortadelo a la de Filemón, de
 * una cantidad de 500 euros. Una segunda transferencia de la cuenta de
 * Mortadelo a la de Filemón, de una cantidad de 500 euros Un reintegro de la
 * cuenta de Mortadelo de 7 euros.
 * 
 * Como resultado, el programa mostrará los siguientes mensajes: Cuenta: 1,
 * 1000.0, 11223344, Mortadelo, Mikasa. Cuenta: 2, 2000.0, 55667788, Filemon,
 * Calle del Medio.
 * 
 * --Después de reintegro(500) Cuenta: 1, 500.0, 11223344, Mortadelo, Mikasa.
 * 
 * --Después de setDireccion("13, Rue del Percebe") 11223344, Mortadelo, 13, Rue
 * del Percebe.
 * 
 * --Después de transferencia(500) Cuenta: 1, 0.0, 11223344, Mortadelo, 13, Rue
 * del Percebe. Cuenta: 2, 2500.0, 55667788, Filemon, Calle del Medio. ERROR. No
 * se ha podido realizar la transferencia.
 * 
 * --Después de transferencia(500) Cuenta: 1, 0.0, 11223344, Mortadelo, 13, Rue
 * del Percebe. Cuenta: 2, 2500.0, 55667788, Filemon, Calle del Medio. ERROR. No
 * se ha podido realizar el reintegro
 * 
 * --Después de reintegro(7) Cuenta: 1, 0.0, 11223344, Mortadelo, 13, Rue del
 * Percebe.
 * 
 * Asegúrate de que:
 * 
 * El DNI del titular es válido (expresión regular y algoritmo) En caso de
 * introducir un DNI erróneo o sin letra, se le indicará al usario previamente a
 * la creación del titular. Siempre se le exigirá la letra correcta. Lanza una
 * excepción en el caso en que el dni no sea correcto o el resto de los datos no
 * cumplan un mínimo de formato. (regex)
 * 
 * @author Antonio Luque Bravo
 * @version 1.0
 *
 */
public class Cuenta {
	/**
	 * C&oacute;digo est&aacute;tico del c&oacute;digo de la cuenta.
	 */
	private static int codigoCuenta = 1;
	/**
	 * id que se incrementar&aacute; con el n&uacute;mero de cuenta.
	 */
	private int id;
	/**
	 * Saldo inicial de la cuenta.
	 */
	private double saldoInicial;

	/**
	 * Constructor Cuenta.
	 * 
	 * @param saldoInicial
	 *            Saldo inicial de la cuenta.
	 * @throws NumerosRojosException
	 *             Cuando el saldo de la cuenta es negativo.
	 */
	Cuenta(int saldoInicial) throws NumerosRojosException {
		setId(codigoCuenta);
		++codigoCuenta;
		setSaldoInicial(saldoInicial);
	}

	/**
	 * Getter de la id de la cuenta.
	 * 
	 * @return Devuelve el estado del campo id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter de la id de la cuenta.
	 * 
	 * @param id
	 *            id de la cuenta.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter del saldo inicial.
	 * 
	 * @return Devuelve el saldo inicial de la cuenta.
	 */
	public double getSaldoInicial() {
		return saldoInicial;
	}

	/**
	 * Setter del Saldo Inicial.
	 * 
	 * @param saldoInicial
	 *            Saldo inicial de la cuenta.
	 * @throws NumerosRojosException
	 *             Cuando el saldo es negativo.
	 */
	public void setSaldoInicial(double saldoInicial) throws NumerosRojosException {
		if (saldoInicial < 0)
			throw new NumerosRojosException();
		this.saldoInicial = saldoInicial;
	}

	/**
	 * Ingresar una cantidad a la cuenta.
	 * 
	 * @param cantidad
	 *            Cantidad ingresar.
	 * @throws NumerosRojosException
	 *             Cuando el saldo de la cuenta es negativo.
	 */
	void ingreso(int cantidad) throws NumerosRojosException {
		setSaldoInicial(getSaldoInicial() + cantidad);
	}

	/**
	 * Retira una cantidad de la cuenta.
	 * 
	 * @param cantidad
	 *            Cantidad a retirar de la cuenta.
	 * @throws NumerosRojosException
	 *             Cuando el saldo de la cuenta es negativo.
	 */
	void reintegro(int cantidad) throws NumerosRojosException {
		setSaldoInicial(getSaldoInicial() - cantidad);
	}

	/**
	 * Transfiere una cantidad de una cuenta a otra.
	 * 
	 * @param cuenta
	 *            Cuenta a donde se ingresar&aacute; el dinero.
	 * @param cantidad
	 *            Cantidad a extraer de la cuenta.
	 * @throws NumerosRojosException
	 *             Cuando el saldo de la cuenta es negativo.
	 * @throws TrasferenciaFallidaException
	 *             Cuando el saldo de la cuenta a la que se le extrae el dinero
	 *             es 0
	 */
	void transferencia(Cuenta cuenta, int cantidad) throws NumerosRojosException, TrasferenciaFallidaException {
		if (this.getSaldoInicial() == 0) {
			throw new TrasferenciaFallidaException();
		}
		this.setSaldoInicial(this.getSaldoInicial() - cantidad);
		cuenta.setSaldoInicial(cuenta.getSaldoInicial() + cantidad);
	}

	@Override
	public String toString() {
		return "Cuenta: " + id + ", " + saldoInicial;
	}
}
