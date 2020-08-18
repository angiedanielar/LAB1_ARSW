## LAB1_ARSW 🚀

**Integrantes:**


_Angie Daniela Ruiz Alfonso_


_Juan Sebastian D�az Salamanca_ 


### Black List Search
#### Part I - Introduction to threads in JAVA


**�C�mo cambia la salida?:**
_La salida con run() nos muestra cada hilo con su rango asignado en el respectivo orden VS con start() nos muestra cada hilo sin orden, mezclando los rangos asignados._


**�Por qu�?:**
_Porque start() crea un nuevo hilo, lo hace ejecutable y luego run() hace que el nuevo hilo comience su vida dentro de este m�todo VS que si llamamos a run() directamente no se crea un nuevo hilo y se ejecutará el c�digo dentro de run() en el hilo actual._


#### Part III - Discussion

**�C�mo se podr�a modificar la implementaci�n para minimizar el n�mero de consultas en estos casos? y �Qu� nuevo elemento aportar�a esto al problema?**


_La estrategia de paralelismo implementada anteriormente es ineficaz en ciertos casos, ya que la b�squeda a�n se realiza incluso cuando los N subprocesos ya han encontrado el n�mero m�nimo de ocurrencias requeridas para reportar al servidor como malicioso. Se podr�a mejorar usando una variable est�tica com�n para los hilos, se usa como un factor comun con las consultas pasadas, teniendo en cuenta que no se asegura que no se presenten condiciones de carrera al no ser thread-safe, este ser�a el nuevo elemento que se aportar�a al problema, pero que teniendo en cuenta las lecturas se podr�a utilizar un tipo de dato at�mico para deshacernos de los problemas de seguridad en el hilo._


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


**Gr�fica de Tiempo de soluci�n vs N�mero de subprocesos:**


![alt text](https://raw.githubusercontent.com/angiedanielar/LAB1_ARSW/master/imagenes/grafica.jpg) 


**De acuerdo con la ley de Amdahl, donde S (n) es la mejora te�rica del rendimiento, P la fracci�n paralela del algoritmo y el n�mero de subprocesos, cuanto mayor sea n, mejor deber�a ser esta mejora. �Por qu� no se logra el mejor rendimiento con los 50 hilos? �C�mo se compara este rendimiento cuando se usa 100? y �C�mo se comporta la soluci�n al usar tantos subprocesos de procesamiento como núcleos en comparaci�n con el resultado de usar el doble?**


_Entre m�s hilos, mejor rendimiento obtendremos, en nuestro programa el usar hilos estamos mejorando el tiempo de ejecuci�n de los mismos. Al comenzar el an�lisis vemos que los resultados varian, el cambio es bastante grande cuando pasamos de 1 hilo a 8,  pero al pasar de 8 a 16 vemos que se reduce a la aproximadamente la mitad el tiempo de soluci�n, luego de nuevo vemos un cambio grande al pasar de 16 a 50, y para finalizar volvemos a ver que al usar 50 y su doble, tambi�n se reduce a la aproximadamente la mitad el tiempo de soluci�n. Los cambios son notorios en cada uno de los casos. Dependiendo del computador que se use puede que estos resultados tiendan a ser constantes._


**Seg�n lo anterior, si para este problema en lugar de 100 subprocesos en una sola CPU se pudiera utilizar 1 subproceso en cada una de las 100 m�quinas hipot�ticas, �Se aplicar�a mejor la ley de Amdahl?. Si se utilizan x subprocesos en lugar de 100 / x m�quinas distribuidas (donde x es el n�mero de n�cleos de estas m�quinas), �se mejorar�a? Explica tu respuesta.**


_Suponiendo que tenemos una conexi�n a 100 m�quinas, en teor�a se tienen 100 CPUs, de los cuales solo estar�amos usando 1 hilo por cada CPU, entonces la velocidad y capacidad de procesamiento mejorar�an bastante, ya que no estamos sobrecargando un solo CPU con muchos hilos sino que de esta forma cada CPU estar�a trabajando sin necesidad de sobrecarga, pero con la velocidad de 100 hilos paralelos._


### Snake Race
#### Parte 2


1. _N serpientes funciona de forma aut�noma._
2. _El concepto de colisi�n no existe entre ellos. La �nica forma en que mueren es chocando contra una pared._
3. _Hay ratones distribuidos a lo largo del juego. Como en el juego cl�sico, cada vez que una serpiente se come un rat�n, crece._
4. _Hay algunos puntos (flechas rojas) que teletransportan a las serpientes._
5. _Los rayos hacen que la serpiente aumente su velocidad._


#### Parte 3


_Soluciones a los items de la Parte 2:_

1. _ _
2. _ _
3. _ _
4. _ _
5. _ _









