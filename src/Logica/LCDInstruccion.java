package Logica;
/*
 Autor: H�ctor Triana 
 **/
//Clase para recibir las instrucciones en consola
public class LCDInstruccion {
	//Definiendo variables est�ticas de control
	private static String separadorCadena= ",";
	private static int minSize=1;
	private static int maxSize=10;
	
	private int size;//Tama�o de caracteres LCD
	private String numerosPrint;//N�meros a imprimir
	private String[] cadenaDescompuesta;//Contiene cadena sin separador (,)
	
	
	
	public LCDInstruccion(String instruccion){
		setterInstruccion(instruccion);
	}
	
	public int getTamano(){
		return size;
	}
	
	public String getNumerosPrint(){
		return numerosPrint;
	}
	
	//Capturando instrucci�n ingresada
	private void setterInstruccion(String instruccion){
		if(!instruccion.contains(separadorCadena)){
			throw new IllegalArgumentException(
					"La cadena ingresada no contiene separador coma (,)"
					);
		}
		
		//Descomponiendo cadena
		cadenaDescompuesta=instruccion.split(separadorCadena);
		
		if(cadenaDescompuesta.length!=2){
			throw new IllegalArgumentException(
					"La cadena ingresada debe tener 2 instrucciones"
					);
		}
		capturarTamano(cadenaDescompuesta[0]);
		capturaNumeros(cadenaDescompuesta[1]);
		
	}
	
	//Captura tama�o de cadena LCD ingresada
	private void capturarTamano(String tamanoDigitado){
		if(esNumerico(tamanoDigitado)==false){
			throw new NumberFormatException("Las instrucciones deben ser num�ricas");
		}
		
		int compruebaSize=Integer.parseInt(tamanoDigitado);
		if(compruebaSize<minSize||compruebaSize>maxSize){
			throw  new IllegalArgumentException(
                "El tama�o de cadena debe estar entre "+minSize+" y "+maxSize
            );
		}
		size=compruebaSize;
	}
	
	//Valida si las cadenas de instrucciones ingresadas son num�ricas
	private boolean esNumerico(String numero){
		 try {
	            Integer.parseInt(numero);
	            return true;
	        } catch (Exception ex) {
	            return false;
	        }
	}
	
	//Captura cifra ingresada en instrucci�n
	private void capturaNumeros(String numeroDigitado){
		if(esNumerico(numeroDigitado)==false){
			throw new NumberFormatException("Debe ingresar solo caracteres num�ricos");
		}
		numerosPrint=numeroDigitado;
	} 
	
	//Retorna num�ros ingresados en instrucci�n como un arreglo de cadenas
	public char[] numerosCadena(){
		String numerosCadena=String.valueOf(numerosPrint);
		return numerosCadena.toCharArray();
	}
	

}
