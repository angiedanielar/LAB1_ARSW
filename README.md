# LAB1_ARSW 🚀

**Integrantes:**


* _Angie Daniela Ruiz Alfonso_
* _Juan Sebastian Díaz Salamanca_ 


## Black List Search 📄
### _Part I - Introduction to threads in JAVA_


**¿Cómo cambia la salida?:**
_La salida con run() nos muestra cada hilo con su rango asignado en el respectivo orden VS con start() nos muestra cada hilo sin orden, mezclando los rangos asignados._


**¿Por qué?:**
_Porque start() crea un nuevo hilo, lo hace ejecutable y luego run() hace que el nuevo hilo comience su vida dentro de este método VS que si llamamos a run() directamente no se crea un nuevo hilo y se ejecutarÃ¡ el código dentro de run() en el hilo actual._


### _Part III - Discussion_

**¿Cómo se podría modificar la implementación para minimizar el número de consultas en estos casos? y ¿Qué nuevo elemento aportaría esto al problema?**
_La estrategia de paralelismo implementada anteriormente es ineficaz en ciertos casos, ya que la búsqueda aún se realiza incluso cuando los N subprocesos ya han encontrado el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso. Se podría mejorar usando una variable estática común para los hilos, que vaya contando las ocurrencias de los hilos, así todos los hilos verian y usarian el mismo valor, logrando que cuando llegue al monto minímo para saber si es un servidor malicioso no siga consultando de forma ineficiente como lo hace actualmente, teniendo en cuenta que no se asegura que no se presenten condiciones de carrera al no ser thread-safe, este sería el nuevo elemento que se aportaría al problema en sí, pero que teniendo en cuenta las lecturas se podría utilizar un tipo de dato atómico para deshacernos de los problemas de seguridad en el hilo._


### _Part IV - Performance Evaluation_
 * 1 Hilo
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/1.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/1_1.jpeg)


 * 8 Hilos
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/8.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/8_1.jpeg)


 * 16 Hilos  
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/16.jpg) 
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/16_1.jpeg)


 * 50 Hilos   
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/50.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/50_1.jpeg)


 * 100 Hilos    
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/100.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/100_1.jpeg)  


**_Gráfica de Tiempo de solución vs Número de subprocesos:_**


![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/grafica.jpg) 


**De acuerdo con la ley de Amdahl, donde S (n) es la mejora teórica del rendimiento, P la fracción paralela del algoritmo y el número de subprocesos, cuanto mayor sea n, mejor debería ser esta mejora. ¿Por qué no se logra el mejor rendimiento con los 50 hilos? ¿Cómo se compara este rendimiento cuando se usa 100? y ¿Cómo se comporta la solución al usar tantos subprocesos de procesamiento como núcleos en comparación con el resultado de usar el doble?**
_Entre más hilos, mejor rendimiento obtendremos, en nuestro programa el usar hilos estamos mejorando el tiempo de ejecución de los mismos. Al comenzar el análisis vemos que los resultados varian, el cambio es bastante grande cuando pasamos de 1 hilo a 8,  pero al pasar de 8 a 16 vemos que se reduce a la aproximadamente la mitad el tiempo de solución, luego de nuevo vemos un cambio grande al pasar de 16 a 50, y para finalizar volvemos a ver que al usar 50 y su doble, también se reduce a la aproximadamente la mitad el tiempo de solución. Los cambios son notorios en cada uno de los casos. Dependiendo del computador que se use puede que estos resultados tiendan a ser constantes._


**Según lo anterior, si para este problema en lugar de 100 subprocesos en una sola CPU se pudiera utilizar 1 subproceso en cada una de las 100 máquinas hipotéticas, ¿Se aplicaría mejor la ley de Amdahl?. Si se utilizan x subprocesos en lugar de 100 / x máquinas distribuidas (donde x es el número de núcleos de estas máquinas), ¿se mejoraría?**
_Suponiendo que tenemos una conexión a 100 máquinas, en teoría se tienen 100 CPUs, de los cuales solo estaríamos usando 1 hilo por cada CPU, entonces la velocidad y capacidad de procesamiento mejorarían bastante, ya que no estamos sobrecargando un solo CPU con muchos hilos sino que de esta forma cada CPU estaría trabajando sin necesidad de sobrecarga, pero con la velocidad de 100 hilos paralelos._


## Snake Race 🐍
### Parte 1
#### PrimeFinder

* _Ejercicio solucionado_
* _Añadido el contador de primos encontrados hasta T milisegundos_
* _Añadido la instrucción de presionar ENTER para continuar con la búsqueda_

### Parte 2
_SnakeRace es una versión autónoma, multi-serpiente del famoso juego llamado "Sanke" basado en el proyecto de Joao Andrade. Este ejercicio es un 'fork' de su trabajo._
* _N serpientes trabajan de manera autónoma_
* _El concepto de colisión no existe entre ellas. La unica forma de que mueran es estrellándose en una pared._
* _Hay ratones distribuidos a lo largo del juego. Como en el juego clásico, cada vez que una serpiente come un ratón, crece._
* _Hay algunos puntos rojos (flechas rojas) que teleportan las serpientes._
* _Los rayos casuan que la serpiente incremente su velocidad._

### Parte 3

_Posibles condiciones de carrera:_
* _Hay un hilo encargado de dibujar el cuerpo de la serpiente. Este mismo hilo lo comparten las serpientes para cambiar su tamaño o su posición cuando ocurre algún evento._  
  
_Uso innecesario de esperas activas:_
* _Es posible que exista una espera activa innnecesaria en init() ya que siempre esta mirando si las serpientes estan vivas (implementación de un while) y al final cuando ya no quede ninguna, terminar el juego. Por otro lado, los hilos que manejan la velocidad del juego usan un método sleep() y no estan a la espera de algún notify().

_Un uso incorrecto o inadecuado de las colecciones:_
* _Es posible que se lance una excepción "Exception in thread "AWT-EventQueue-0" java.util.ConcurrentModificationException" cuando se intenta dibujar dos veces en una celda a la vez diferentes serpientes, es decir, no hay ningun tipo de bloqueo de celda. Todo el tiempo se esta iterando sobre la colección que se usa para repesentar la serpiente._  

**Soluciones propuestas:**

* _Hicimos que se sincronizaran los hilos al momento de dibujar las serpientes para evitar concurrencia._

* _Se modificó la velocidad del juego para revisar su comportamiento en un entorno donde se dan los eventos más rápido._

* _Implementación de Pausa y Reanudar, con implementación de notify() para evitar pausas activas innecesarias._
  
## ¡¡¡Compile and run instructions!!! 🛠️


**_Para compilar:_**
_maven package_


**_Para ejecutar las pruebas:_**
_mvn test_


**_Para ejecutar las clases principales:_** 
 * _mvn exec:java -Dexec.mainClass="edu.eci.arsw.threads.CountThreadsMain"_


 * _mvn exec:java -Dexec.mainClass="edu.eci.arsw.blacklistvalidator.Main"_
 
 
 * _mvn exec:java -Dexec.mainClass="edu.eci.arsw.primefinder.Main"_
  
  
 * _mvn exec:java -Dexec.mainClass="snakepackage.SnakeApp"_












