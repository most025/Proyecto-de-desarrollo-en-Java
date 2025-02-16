# Requirimienntos Tecnicos del programa.

1.  Requirimientos técnicos:

- **Clases Abstractas:**

  - Diseñar dos clases abstractas que definan características y comportamientos generales.
  - Ejemplo: Persona (atributos: nombre, edad) y Entrada (atributos: Tipo, precio, asientos).

- **Jerarquia:**

  - Crear una jerarquía de clases con tres niveles.
  - Ejemplo:

    - Primer nivel: Entrada (**Abstracta**).
    - Segundo nivel: EntradaGeneral y EntradaVip (heredan de entrada).
    - Tercer nivel: Subtipos específicos como EntradaEstudiante que heredan de entradaGeneral.

- **Polimorfismo:**

    - Implementar métodos polimórficos que calculen el precio final de la entrada basado en descuentos o promociones.

    - Ejemplo: Un método `calcularPrecio()` en Entrada que sea sobreescrito en las subclases.


- **Interfaz Gráfica:**
    
    - Crear una interfaz grafica con **Swing** o **JavaFX** que permita:

      - Seleccionar el tipo de entrada.
      - Ingresar datos de la persona.
      - Mostrar el precio final de la entrada.
      - Confirmar compra.
      - Generar entrada con número de asiento.

