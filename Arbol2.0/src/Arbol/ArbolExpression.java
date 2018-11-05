package Arbol;

import java.util.Scanner;
import java.util.Stack;

public class ArbolExpression {
	
    public static void main(String args[]) { 
    	 // creamos el arbolExpression (instancia) para obtener los metodos
    	ArbolExpression obj = new ArbolExpression(); 
        String expresion = "a+b*c"; 
        //el scanner entrada es para leer por teclado
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese la expresion:");
        expresion = entrada.nextLine();
        
        //convertimos la expresion a un array de caracteres
        char[] charArray = expresion.toCharArray(); 
        //construimos el arbol con la exprexion infija
        Nodo root = obj.constructTreeInfijo(charArray); 

        
        //mandamos a llamar a los metodos de inorden, postorden y preorden para que impriman el arbol
        //dependiendo de su recorrido
        
        System.out.println("inorden es : "); 
        obj.inorder(root); 
        System.out.println("\n");
        System.out.println("postorfen es : "); 
        obj.postorden(root); 
        System.out.println("\n");
        System.out.println("preorden es : "); 
        obj.preorden(root); 
        
        
  
    } 


    //los siguientes recorridos son bajados del algoritmo que da wikipedia
    //https://es.wikipedia.org/wiki/Recorrido_de_%C3%A1rboles
    //son metodos recursivos que van recorriendo e imprimiendo la expresion regular
    
	 void inorder(Nodo t) { 
	        if (t != null) { 
	            inorder(t.left); 
	            System.out.print(t.value + " "); 
	            inorder(t.right); 
	        } 
	    } 
	 
	 void postorden(Nodo t) { 
	        if (t != null) { 
	        	postorden(t.left); 
	        	postorden(t.right); 
	            System.out.print(t.value + " "); 
	        } 
	    } 
	 
	 void preorden(Nodo t) { 
	        if (t != null) { 
	        	System.out.print(t.value + " "); 
	        	preorden(t.left); 
	        	preorden(t.right); 
	           
	        } 
	    } 
	 
	 //metodo bajado de internet solo checa por posibles operadores 
	 boolean esOperador(char c) { 
	        if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') { 
	            return true; 
	        } 
	        return false; 
	    } 
	
         
	    Nodo constructTreeInfijo(char infijo[]) { 
	        Stack<Nodo> st = new Stack(); 
	        Nodo t, t1; 
	  
	        //primero vamos a recorrer todos los elementos de la expresion
	        for (int i = 0; i < infijo.length; i++) { 
	  
	            // si es un operando (numero o letra) le creamos un nodo y lo metemos al stack
	            if (!esOperador(infijo[i])) { 
	                t = new Nodo(infijo[i]); 
	                st.push(t); 
	            } else 
	            { 
	            	// Si es un operador (+,-,*) 
	            	//le creamos un nodo 
	                t = new Nodo(infijo[i]); 
	  
	                // y su hijo izquierdo deberia ser el ultimo en la pila
	               // El pop remueve el ultimo elemento en la pila
                        t1 = st.pop();      
	  
	                //  se lo asignamos
	                t.left = t1; 
	                //ahora dejamos en la pila al operando 
	                st.push(t); 
	            } 
	        }
	        
	        //ahora empezamos con los hijos derechos
	        while(st.size()>1){
	        	//el ultimo elemento de la pila actualmente es el hijo del penultimo
                       // lo dejamos en t y al mismo tiempo lo sacamos de la pila
	        	t = st.pop(); 
                        //le asignamos el hijo t al ultimo elemento de la pila 
                        //repetimos el proceso hasta que solo quede 1 en la pila
	        	st.peek().right = t; 
	        	
	        }
	  
	        //cuando ya solo quede 1 elemento en la pila lo seleccionamos con peek (selecciona pero no lo expulsa)
	        t = st.peek(); 
	        //este es nuestro arbol de expresiones
	        return t; 
	    } 
}
