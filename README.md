# P_1_H-J-A

Asignatura: Herramientas informáticas para juegos de azar. Práctica 1


Objetivo: Aplicación que calcula el valor de una mano en el juego NLHE.

Tipos de entradas y salidas:

A) Indicar la mejor jugada dadas 5 cartas:
   
   Ejemplo de fichero de entrada "entrada.txt"--> AhAcQhJhTh*
   
   En ejecución: $> java -jar nombreProyecto.jar 1 entrada.txt salida.txt
   
   (1)- Número de apartado que desea probar.
   (*)- El fichero de entrada puede contener varias manos.
   
   Ejemplo de fichero de salida "salida.txt" para la ejecución anterior:
   
   AhAcQhJhTh
   - Best hand: Pair of Aces (AhAc)
   - Draw: Straight Gutshot
   - Draw Flush

B) Indicar la mejor jugada teniendo 2 cartas propias y 3, 4 o 5 cartas comunes (Carta_1Carta_2;n;CartasComunes):
   
   Ejemplo de fichero de entrada --> AhAc;3;QhJhTh
                                     AhAc;5;As2s3h4dJd*
   
   (*)- El fichero de entrada puede contener varias manos.
   
   En ejecución: $> java -jar nombreProyecto.jar 2 entrada2.txt salida2.txt            
   
   Ejemplo de fichero de salida "salida2.txt" para la ejecución anterior:                  
   
   AhAc;3;QhJhTh
   - Best hand: Pair of Aces with AhAcQhJhTh
   - Draw: Straight Gutshot
   - Draw Flush
   
   AhAc;5;As2s3h4dJd
   - Best hand: Three of a kind (Aces) with AhAcAs4dJd

C) Dados n jugadores (2 <= n <= 9) con 2 cartas cada uno y 5 cartas comunes, ordenar los jugadores de mejor a peor mano:
   (N;J1CartasJug1;J2CartasJug2;...;JNCartasJugN;CartasComunes)
   
   Donde:
        N es el número de jugadores presentes en la mano
   
   Ejemplo de fichero de entrada --> 4;J1AhAc;J2JsJh;J37c8c;J44sKc;5dKs6cTh9h
   
   En ejecución: $> java -jar nombreProyecto.jar 3 entrada3.txt salida3.txt
   
   Ejemplo de fichero de salida "salida2.txt" para la ejecución anterior:
   
   4;J1AhAc;J2JsJh;J37c8c;J44sKc;5dKs6cTh9h
   J3: 6c7c8c9hTh (Straight)
   J1: AhAcKsTh9h (Pair of Aces)
   J4: 4sKcKsTh9h (Pair of Kings)
   J2: JsJhKsTh9h (Pair of Jacks)
   




Pagina tutorial git:

http://rogerdudler.github.io/git-guide/index.es.html

otra:

http://rogerdudler.github.io/git-guide/files/git_cheat_sheet.pdf
