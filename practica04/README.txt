Este programa se compila a dos niveles, primero como paquete y segundo como programa. 
Para compilar el paquete uno se tiene que situar en la carpeta src, a continuación, se compilará con el siguiente comando:
javac shapesSVG/Vector2.java shapesSVG/Linea.java shapesSVG/Rectangulo.java shapesSVG/Triangulo.java shapesSVG/Circulo.java
Ésto se debe hacer si se realiza cualquier cambio en las clases dentro del paquete shapesSVG.
Para compilar el programa que emplea estas clases basta con poner javac Main.java. Puesto que el programa como tal es el main.

De la misma manera, éste programa tiene dos maneras de ejecutarse. Como un programa cualquiera de java usando el comando 
java Main.java 
en la terminal. Este tipo de ejecución sólo nos regresa una cadena de texto, que no es de mucha utilidad.
Para ejecutar en forma de HTML se tiene que emplear el comando:
java Main.java > Main.html esto producirá en la carpeta src un archivo llamado Main.html, que al abrirse con el navegador nos mostrarpa una página con las figuras descritas en el Main.
