# Auditoría Cósmica: El Detector de Primos

## Niveles realizados
He realizado los Niveles 1, 2, 3 y 4.

## Tabla de pruebas

| Valor | Salida de factor | Código de salida |
| :--- | :--- | :---: |
| **360** | `360: 2 2 2 3 3 5` | `0` |
| **1** | `1:` | `0` |
| **17** | `17: 17` | `0` |
| **hola** | `factor: 'hola' is not a valid positive integer` | `1` |
| **-5** | `factor: '-5' is not a valid positive integer` | `1` |
![Captura desde 2026-10-01 14-23-03.png](capturas/Captura%20desde%202026-10-01%2014-23-03.png)

## Error encontrado durante el desarrollo
Un error que tuve al probar el Nivel 4 fue un `NumberFormatException` cuando introducía textos como `"hola"` o números negativos. El programa intentaba hacer `Integer.parseInt(numero)` para pasar la entrada al bucle que comprueba si es primo y fallaba.

Lo solucioné metiendo el parseo del número dentro de un bloque `try-catch (NumberFormatException e)`. De esta forma, si la entrada no es un entero válido, se captura el fallo y el programa continúa normalmente para que el comando `factor` muestre su propio mensaje de error por la salida correspondiente.
## Contenido de los ficheros de log (Nivel 3)

### `factor_output.log`
![Captura de pantalla 2026-10-01 143438.png](capturas/Captura%20de%20pantalla%202026-10-01%20143438.png)

### `factor_error.log`
![Captura de pantalla 2026-10-01 143432.png](capturas/Captura%20de%20pantalla%202026-10-01%20143432.png)

## Ejemplo de ejecucion de si es primo o no
![Captura desde 2026-10-01 14-23-53.png](capturas/Captura%20desde%202026-10-01%2014-23-53.png)

