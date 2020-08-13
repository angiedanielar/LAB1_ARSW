## LAB1_ARSW 🚀

**Integrantes:**


_Angie Daniela Ruiz Alfonso_


_Juan Sebastian Diaz Salamanca_ 


### Black List Search
#### Part I - Introduction to threads in JAVA


**¿Cómo cambia la salida?:**
_La salida con run() nos muestra cada hilo con su rango asignado en el respectivo orden VS con start() nos muestra cada hilo sin orden, mezclando los rangos asignados._


**¿Por qué?:**
_Porque start() crea un nuevo hilo, lo hace ejecutable y luego run() hace que el nuevo hilo comience su vida dentro de este método VS que si llamamos a run() directamente no se crea un nuevo hilo y se ejecutará el código dentro de run() en el hilo actual._


#### Part III - Discussion

_¿Cómo se podría modificar la implementación para minimizar el número de consultas en estos casos?_ 
La estrategia de paralelismo implementada anteriormente es ineficaz en ciertos casos, ya que la búsqueda aún se realiza incluso cuando los N subprocesos ya han encontrado el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso. Se podría mejorar 

_¿Qué nuevo elemento aportaría esto al problema?_


#### Part IV - Performance Evaluation
**JVM:**



**Gráfica de Tiempo de solución vs Número de subprocesos:**
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/grafica.jpg) 


_De acuerdo con la ley de Amdahl, donde S (n) es la mejora teórica del rendimiento, P la fracción paralela del algoritmo yn el número de subprocesos, cuanto mayor sea n, mejor debería ser esta mejora. ¿Por qué no se logra el mejor rendimiento con los 500 hilos? ¿Cómo se compara este rendimiento cuando se usa 200?_


_¿Cómo se comporta la solución al usar tantos subprocesos de procesamiento como núcleos en comparación con el resultado de usar el doble?_


_Según lo anterior, si para este problema en lugar de 100 subprocesos en una sola CPU se pudiera utilizar 1 subproceso en cada una de las 100 máquinas hipotéticas, ¿Se aplicaría mejor la ley de Amdahl?. Si se utilizan x subprocesos en lugar de 100 / x máquinas distribuidas (donde x es el número de núcleos de estas máquinas), ¿se mejoraría? Explica tu respuesta._


### Snake Race
#### Parte 2


1. _N serpientes funciona de forma autónoma._
2. _El concepto de colisión no existe entre ellos. La única forma en que mueren es chocando contra una pared._
3. _Hay ratones distribuidos a lo largo del juego. Como en el juego clásico, cada vez que una serpiente se come un ratón, crece._
4. _Hay algunos puntos (flechas rojas) que teletransportan a las serpientes._
5. _Los rayos hacen que la serpiente aumente su velocidad._


#### Parte 3


_Soluciones a los items de la Parte 2:_

1. _ _
2. _ _
3. _ _
4. _ _
5. _ _









