[![es](https://img.shields.io/badge/lang-es-yellow.svg)](./README.md)
[![en](https://img.shields.io/badge/lang-en-red.svg)](./README.en.md)

## Solucionador del Problema de las N-Reinas

Este proyecto tiene como objetivo resolver el problema de las N-Reinas utilizando dos enfoques diferentes: la Búsqueda en Amplitud (BFS, por sus siglas en inglés) y la Búsqueda Local de Rayo (Local Beam Search). El problema de las N-Reinas es un problema clásico en informática y optimización combinatoria, donde el objetivo es colocar N reinas de ajedrez en un tablero de ajedrez N×N de tal manera que ninguna reina amenace a otra. Mientras que BFS explora sistemáticamente todas las configuraciones posibles, la Búsqueda Local de Rayo se centra en explorar estados prometedores de manera iterativa. Estos enfoques demuestran diferentes estrategias para resolver problemas de optimización combinatoria.

### NQueensBFS

La clase NQueensBFS proporciona una solución al problema de las N-Reinas utilizando el algoritmo de Búsqueda en Amplitud (BFS). Explora sistemáticamente todas las configuraciones posibles de reinas en el tablero de ajedrez y verifica si cada configuración es válida.

### LocalBeamSearch

Haz local o Local Beam Search se inicializa con una población donde sus estados son generados aleatoriamente. Luego, por algún número de generaciones se comprobará si cada elemento es una solución. De no serlo, se explora cada uno de sus sucesores. En el caso del problema de las reinas, tendrá 8 sucesores, uno por cada columna, y será considerado sucesor de dicho estado si disminuye el número de amenazas de su padre. Esto es, si nuestra población es de 10 elementos por cada generación, estos producirán en conjunto 80 sucesores, cada uno mejor que su progenitor, y a la siguiente generación solamente se conservan los 10 mejores, iterando así hasta encontrar una solución.
