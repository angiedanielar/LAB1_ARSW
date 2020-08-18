## LAB1_ARSW ðŸš€

**Integrantes:**


_Angie Daniela Ruiz Alfonso_


_Juan Sebastian Díaz Salamanca_ 


### Black List Search
#### Part I - Introduction to threads in JAVA


**¿Cómo cambia la salida?:**
_La salida con run() nos muestra cada hilo con su rango asignado en el respectivo orden VS con start() nos muestra cada hilo sin orden, mezclando los rangos asignados._


**¿Por qué?:**
_Porque start() crea un nuevo hilo, lo hace ejecutable y luego run() hace que el nuevo hilo comience su vida dentro de este método VS que si llamamos a run() directamente no se crea un nuevo hilo y se ejecutarÃ¡ el código dentro de run() en el hilo actual._


#### Part III - Discussion

**¿Cómo se podrí­a modificar la implementación para minimizar el número de consultas en estos casos? y ¿Qué nuevo elemento aportaría esto al problema?**


_La estrategia de paralelismo implementada anteriormente es ineficaz en ciertos casos, ya que la búsqueda aún se realiza incluso cuando los N subprocesos ya han encontrado el número mínimo de ocurrencias requeridas para reportar al servidor como malicioso. Se podrí­a mejorar usando una variable estática común para los hilos, se usa como un factor comun con las consultas pasadas, teniendo en cuenta que no se asegura que no se presenten condiciones de carrera al no ser thread-safe, este sería el nuevo elemento que se aportaría al problema, pero que teniendo en cuenta las lecturas se podría utilizar un tipo de dato atómico para deshacernos de los problemas de seguridad en el hilo._


#### Part IV - Performance Evaluation
**JVM:**
##### 1 Hilo
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/1.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/1_1.jpeg)

##### 8 Hilos
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/8.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/8_1.jpeg)

##### 16 Hilos  
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/16.jpg) 
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/16_1.jpeg)

##### 50 Hilos   
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/50.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/50_1.jpeg)

##### 100 Hilos    
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/100.jpg)
![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/100_1.jpeg)  


**Gráfica de Tiempo de solución vs Número de subprocesos:**


![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/grafica.jpg) 


**De acuerdo con la ley de Amdahl, donde S (n) es la mejora teórica del rendimiento, P la fracción paralela del algoritmo y el número de subprocesos, cuanto mayor sea n, mejor deberí­a ser esta mejora. ¿Por qué no se logra el mejor rendimiento con los 50 hilos? ¿Cómo se compara este rendimiento cuando se usa 100? y ¿Cómo se comporta la solución al usar tantos subprocesos de procesamiento como nÃºcleos en comparación con el resultado de usar el doble?**


_Entre más hilos, mejor rendimiento obtendremos, en nuestro programa el usar hilos estamos mejorando el tiempo de ejecución de los mismos. Al comenzar el análisis vemos que los resultados varian, el cambio es bastante grande cuando pasamos de 1 hilo a 8,  pero al pasar de 8 a 16 vemos que se reduce a la aproximadamente la mitad el tiempo de solución, luego de nuevo vemos un cambio grande al pasar de 16 a 50, y para finalizar volvemos a ver que al usar 50 y su doble, también se reduce a la aproximadamente la mitad el tiempo de solución. Los cambios son notorios en cada uno de los casos. Dependiendo del computador que se use puede que estos resultados tiendan a ser constantes._


**Según lo anterior, si para este problema en lugar de 100 subprocesos en una sola CPU se pudiera utilizar 1 subproceso en cada una de las 100 máquinas hipotéticas, ¿Se aplicaría mejor la ley de Amdahl?. Si se utilizan x subprocesos en lugar de 100 / x máquinas distribuidas (donde x es el número de núcleos de estas máquinas), ¿se mejorarí­a? Explica tu respuesta.**


_Suponiendo que tenemos una conexión a 100 máquinas, en teoría se tienen 100 CPUs, de los cuales solo estaríamos usando 1 hilo por cada CPU, entonces la velocidad y capacidad de procesamiento mejorarían bastante, ya que no estamos sobrecargando un solo CPU con muchos hilos sino que de esta forma cada CPU estaría trabajando sin necesidad de sobrecarga, pero con la velocidad de 100 hilos paralelos._


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









