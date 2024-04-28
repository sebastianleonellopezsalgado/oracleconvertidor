# oracleconvertidor
Alura Challenges ONE 6
Convertidor de Monedas
Este es un convertidor de monedas simple desarrollado en Java. Te permite convertir una cantidad de una moneda a otra utilizando las tasas de cambio en tiempo real de la API de ExchangeRate-API.

Requisitos
Java 8 o superior
Conexión a Internet
Uso
Sigue las instrucciones en pantalla para realizar conversiones de moneda.
Funcionalidades
Conversión entre cinco monedas: USD, ARS, BRL, COP, MXN.
Interfaz de usuario intuitiva y fácil de usar.
Utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.

Este programa es un convertidor de monedas que permite al usuario convertir una cantidad de una moneda a otra utilizando tasas de cambio en tiempo real obtenidas de una API en línea.

Estructura del Programa:
Clase Principal (ConvertidorMonedas): Contiene el método main, que inicia la ejecución del programa. Este método se encarga de interactuar con el usuario y coordinar las conversiones de moneda.
Método main: Es el punto de entrada del programa. Aquí se inicializan las variables, se solicita la entrada del usuario y se llama a otros métodos para realizar las conversiones y manejar la lógica del programa.
Método sendHttpGETRequest: Este método realiza una solicitud HTTP GET a una API de tasas de cambio en línea para obtener la tasa de cambio entre dos monedas específicas.
Método getExchangeRate: Se encarga de extraer la tasa de cambio de la respuesta JSON obtenida del método sendHttpGETRequest.
HashMap convertidorMonedas: Almacena los códigos de moneda y sus respectivos identificadores para facilitar la selección del usuario.
Interacción con el Usuario:
El programa solicita al usuario que seleccione la moneda de origen y la moneda de destino.
Luego, pide al usuario que ingrese la cantidad que desea convertir.
Realiza la conversión utilizando las tasas de cambio proporcionadas por la API.
Finalmente, pregunta al usuario si desea continuar usando el convertidor o salir del programa.
Manejo de Excepciones:
El programa maneja posibles errores de red y JSON mediante excepciones IOException y JSONException, respectivamente. En caso de error, muestra un mensaje de error al usuario.
Implementación de la Lógica:
La lógica del programa se implementa de manera modular, con métodos separados para realizar la solicitud HTTP y para extraer la tasa de cambio de la respuesta JSON.
Esto facilita el mantenimiento y la comprensión del código, ya que cada método se encarga de una tarea específica.
En resumen, este programa proporciona una manera sencilla y eficiente de convertir monedas utilizando datos en tiempo real de una API en línea, con una interfaz de usuario amigable y un manejo adecuado de errores.





Este programa fue desarrollado por Sebastian Leonel Lopez Salgado.
Este proyecto es publico
