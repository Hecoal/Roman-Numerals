

package romanos;
import java.util.*;
public class Romanos {

   
    private final static String CP = "I,V,X,L,C,D,M";
    
    private boolean Comprobar (String[] elementos) throws Exception{
        
            int correctos =0;
            int index =0;
            
            if(elementos.length>10)
            {
                throw new Exception ("No puedes ingresar mas de 10 caracteres");
            } 
            else{
                
                   
                
            for (int i = 0; i < elementos.length;i++) 
            {
                index=0;
                for(int e=0; e< elementos[i].length(); e++) 
                {
                    index++;
                    for(int o=0; o<CP.length(); o++) 
                    {
                        if(elementos[i].toCharArray()[e]== CP.toCharArray()[o]) 
                        {
                            if(index == elementos[i].length())
                            {
                                correctos++;
                            }
                        }
                    }
                }
            }
            if(correctos!=elementos.length) 
            {
                throw new Exception("Solo puedes usar numeros romanos");
            } 
            return true;
            }
       }
            
    private String[] obtenerElementos(String cadena) throws Exception{
  
    for (int i=0; i<cadena.length();i++)
    {
        if(' '==cadena.charAt(i))
        {
            throw new Exception ("No puedes usar espacios");
        }
    }
    String [] elementos = cadena.split(""); 
    if(elementos.length>=1)
    {
        return elementos;
    }else
    {
        System.out.println(elementos.length);
        throw new Exception("Necesitas ingresar minimo 1 elemento");    
    }
    }
            
    private void Proceso (int suma, String cadena) throws Exception
    {
        char Romano[]={'I','V','X','L','C','D','M'};
        int valor []={1,5,10,50,100,500,1000};
        int ant=0;
       
        
        char letra;
      
        
        for (int i=0;i<cadena.length();i++)
        {
            letra=cadena.charAt(i);
            
            for(int x=0;x<Romano.length;x++ )
            {
               if(letra==Romano[x])
               {
                   
                   suma=suma+valor[x];
                   
                   if(ant<valor[x])
                   {
                       suma=suma-ant*2;
                      
                       
                       ant=valor[x];
                       
                   }
                   else
                   {
                       ant=valor[x];
                   }
                   
               }
            }
        }
        System.out.println("La conversion de Romano a arabigo a: "+ suma);
        
    } 

    
    
   
    public static void main(String[] args) {
        
     Scanner teclado = new Scanner(System.in);
     Romanos digitos = new Romanos();
     System.out.println("**************************************************");
     System.out.println("**Bienvenido a la calculadora de numeros romanos**");
     System.out.println("**************************************************");
     
     System.out.println("Introduzca hasta diez caracteres romanos para convertirlos a Arabigos: >");
     String cadena = teclado.nextLine();
     
     try
     {
         String [] elementos = digitos.obtenerElementos(cadena);
        
        if( digitos.Comprobar(elementos))
        //(elementos))
        {
            digitos.Proceso(0, cadena);
        }
        }catch(Exception e )
                {
                 
                    System.out.println(e.getMessage());
                    digitos.main(args);
                } 
     }  
}
