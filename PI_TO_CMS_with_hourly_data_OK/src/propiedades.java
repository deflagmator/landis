


	import java.io.*;
import java.util.Properties;
public class propiedades {
	
	
	String archivo_properties="pi_to_cms.properties";
	
	
	String temp_outFile;
	String cms_outFile;
	String minutos_generacion;
	
	Properties prop  = new Properties();
	
	String temp_outFile(){
			try{
				prop.load(new FileInputStream(archivo_properties));
				temp_outFile = prop.getProperty("temp_outFile");
			}catch(IOException e){
			}
			return temp_outFile;
			}
	String cms_outFile(){
		try{
			prop.load(new FileInputStream(archivo_properties));
			cms_outFile = prop.getProperty("cms_outFile");
		}catch(IOException e){
		}
		return cms_outFile;
		}
	
	String minutos_generacion(){
		try{
			prop.load(new FileInputStream(archivo_properties));
			minutos_generacion = prop.getProperty("minutos_generacion");
		}catch(IOException e){
		}
		return minutos_generacion;
		}
	

	
}