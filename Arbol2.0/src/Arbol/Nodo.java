package Arbol;

public class Nodo {
	//Lo mas basico, el arbol se compone de un nodo izquierdo, derecho y un valor 
	//en esta ocacion es tipo char ya que son expresiones regulares
    char value; 
    Nodo left, right; 
    //esto es el constructor
    Nodo(char item) { 
        value = item; 
        left = right = null; 
    } 
}
