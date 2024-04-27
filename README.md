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

Los pasos para construir y entender este código de un convertidor de monedas en Java son los siguientes:

Inicialización de Variables y Estructuras de Datos:
Se inicializa una variable booleana running que controla si el programa continúa ejecutándose.
Se crea un objeto HashMap llamado convertidorMonedas para almacenar los códigos de moneda y sus nombres.
Entrada de Usuario:
Se solicita al usuario que seleccione la moneda de origen y la moneda de destino.
Se utiliza un bucle do-while para repetir el proceso hasta que el usuario decida detenerse.
Consulta HTTP:
Se utiliza la clase HttpURLConnection para enviar una solicitud HTTP GET a un servicio web que proporciona tasas de cambio de moneda.
Se construye la URL de la solicitud utilizando los códigos de moneda seleccionados por el usuario.
Se establece la conexión y se obtiene la respuesta del servicio web.
Si la respuesta es exitosa, se lee y procesa la respuesta JSON para obtener la tasa de cambio.
Salida de Resultados:
Se calcula el monto convertido multiplicando la cantidad ingresada por la tasa de cambio obtenida.
Se muestra el resultado al usuario junto con las monedas de origen y destino.
Manejo de Excepciones:
Se manejan posibles errores durante la solicitud HTTP y el procesamiento de la respuesta JSON.
Se informa al usuario si ocurre algún error durante el proceso.
Bucle de Continuación:
Se pregunta al usuario si desea realizar otra conversión de moneda.
Si el usuario elige continuar, el bucle se repite; de lo contrario, el programa finaliza con un mensaje de agradecimiento.
Este código demuestra cómo utilizar Java para interactuar con servicios web mediante solicitudes HTTP y procesar datos JSON. Además, muestra cómo estructurar un programa de manera modular utilizando funciones y estructuras de datos como HashMaps.






Este programa fue desarrollado por Sebastian Leonel Lopez Salgado.
Este proyecto es publico
