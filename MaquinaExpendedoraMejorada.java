public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //Contador de billetes imprimidos
    private int numeroBilletesVendidos;
    //Maquina normal o con premio
    private boolean premio;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioMaquina) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroBilletesVendidos = 0;
        premio = premioMaquina;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }       
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            numeroBilletesVendidos = numeroBilletesVendidos + 1;
            if (premio == true) {
                System.out.println("# Descuento de " + (precioBillete*10/100) + " euros en el cine.");
            }
        }
        else {
            System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
        } 
    }
       
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }

    /**
     * Vacía todo el dinero que hay en la máquina.
     */
    public int vaciarDineroDeLaMaquina() {
        int vaciado = 0;
        if (balanceClienteActual > 0) {
            System.out.println("¡Hay una operación en proceso!");
            vaciado = -1;
        }
        else {
            vaciado = totalDineroAcumulado + balanceClienteActual;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return vaciado;
    }
        
    /**
     * Devulve el número de billetes vendidos desde la puesta en funcionamiento de la máquina.
     */
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }
    
    /**
     * Imprime el número de billetes vendidos desde la puesta en funcionamiento de la máquina.
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println((numeroBilletesVendidos) + " billetes vendidos");
    }
}
