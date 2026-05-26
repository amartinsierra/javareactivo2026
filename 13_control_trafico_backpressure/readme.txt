Implementar un sistema de radar que emite la velocidad y matricula de un vehiculo cada medio segundo. 
El cliente estará formado por dos hilos:
-Multará a los vehiculos que superen la velocidad permitida . Este cliente se ejecuta en un hilo io y su velocidad de cosumo es de 1 segundo. Los que no pueda procesar se perderán
-Mostrará la velocidad media de los vehiculos recibidos durante los últimos 5 segundos. Procesa los vehículos a una velocidad de medio segundo