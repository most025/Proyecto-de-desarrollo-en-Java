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



 2. Funcionalidades Mínimas.

    - Registro de clientes con nombre y edad.
    - Selección de tipo de entrada (General color verde o VIP color amarillo) y subtipo (Estudiantes color celeste).
    - Cálculo del precio final aplicando descuentos basados en el tipo de entrada. (Precio de entrada base: $ 1.600)
    - Utilizar arreglo bidimensional para asignación de asiento.
    - Confirmación de la compra con un resumen visual.

3.Detalles del diseño.

  - **Atributos sugeridos:**

      - En Entrada: tipo, precioBase, numeroAsiento.
      - En Persona: nombre, edad.
  - **Métodos sugeridos:**
      
      - `calcularPrecio()` en Entrada.
      - `generarAsiento()` en Entrada.
      - Métodos específicos en las subclases para calcular descuentos.
- Implementar clases concretas como EntradaGeneral y Entrada VIP con lógicas distintas.
