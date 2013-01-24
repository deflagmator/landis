




import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Format;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class pi_to_cms_with_hourly_data {

	public static String ultimo_bucle_generado;
	
	
	public static String hora_actual;
	
	public static String minutos_actual;
	
	public static String dia_actual;
	
	public static String año_actual;
	
	public static String año_largo;
	
	public static String mes_actual;
	
	public static String mes_corto;
	
	
	
	
	public static String hora_anterior;
	
	public static String minutos_hora_anterior;
	
	public static String dia_hora_anterior;
	
	public static String año_hora_anterior;
	
	public static String año_hora_anterior_largo;
	
	public static String mes_hora_anterior;
	
	public static String mes_corto_hora_anterior;
	
	
	
	
	public static String 	 hora_menos_dos_horas;
	
	public static String 	 minutos_menos_dos_horas;
	
	public static String 	 dia_menos_dos_horas ;
	
	public static String año_menos_dos_horas_corto;
	public static String 	 año_menos_dos_horas_largo;
	
	
	public static String mes_menos_dos_horas;
	public static String 	 mes_menos_dos_horas_corto ;
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Importación ficheros sistema PI a CMS");
		//Cogemos fecha y hora actuales.
		Integer	generar_ahora= 0;
		Integer bucle = 1;
		 ultimo_bucle_generado = "200101010000";
		propiedades Archivopropiedades1 = new propiedades();
		String minutos_generacion = Archivopropiedades1.minutos_generacion();
		
		while (bucle == 1){	
			System.out.println("Se generará el ficheros en los " + minutos_generacion + " minutos de cada hora");
			do {
			//Espera un tiempo 
				try {
				Thread.sleep(10000);
				
				Date fecha = new Date();
				
				Format formatter = new SimpleDateFormat("HH");
				 hora_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("mm");
				 minutos_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("dd");
				 dia_actual= formatter.format(fecha);
				formatter = new SimpleDateFormat("yy");
				 año_actual= formatter.format(fecha);
				 formatter = new SimpleDateFormat("yyyy");
				 año_largo= formatter.format(fecha);
				 formatter = new SimpleDateFormat("MM");
				 mes_corto= formatter.format(fecha);
				 formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
				 mes_actual= formatter.format(fecha);
				
				 
				GregorianCalendar cal_fecha = new GregorianCalendar ();
				cal_fecha.setTime(fecha);
				cal_fecha.add(Calendar.HOUR_OF_DAY,-1);
				Date Fecha_menos_una_hora = cal_fecha.getTime();
				
				formatter = new SimpleDateFormat("HH");
				 hora_anterior= formatter.format(Fecha_menos_una_hora);
				formatter = new SimpleDateFormat("mm");
				 minutos_hora_anterior= formatter.format(Fecha_menos_una_hora);
				formatter = new SimpleDateFormat("dd");
				 dia_hora_anterior= formatter.format(Fecha_menos_una_hora);
				formatter = new SimpleDateFormat("yy");
				 año_hora_anterior= formatter.format(Fecha_menos_una_hora);
				 formatter = new SimpleDateFormat("yyyy");
				 año_hora_anterior_largo= formatter.format(Fecha_menos_una_hora);
				 formatter = new SimpleDateFormat("MM");
				 mes_corto_hora_anterior= formatter.format(Fecha_menos_una_hora);
				 formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
				 mes_hora_anterior= formatter.format(Fecha_menos_una_hora);
				 
				 
				 
				 GregorianCalendar cal_fecha2 = new GregorianCalendar ();
					cal_fecha2.setTime(fecha);
					cal_fecha2.add(Calendar.HOUR_OF_DAY,-2);
					Date Fecha_menos_dos_horas = cal_fecha2.getTime();
					
					formatter = new SimpleDateFormat("HH");
					 hora_menos_dos_horas= formatter.format(Fecha_menos_dos_horas);
					formatter = new SimpleDateFormat("mm");
					 minutos_menos_dos_horas= formatter.format(Fecha_menos_dos_horas);
					formatter = new SimpleDateFormat("dd");
					 dia_menos_dos_horas= formatter.format(Fecha_menos_dos_horas);
					formatter = new SimpleDateFormat("yy");
					 año_menos_dos_horas_corto= formatter.format(Fecha_menos_dos_horas);
					 formatter = new SimpleDateFormat("yyyy");
					 año_menos_dos_horas_largo= formatter.format(Fecha_menos_dos_horas);
					 formatter = new SimpleDateFormat("MM");
					 mes_menos_dos_horas_corto= formatter.format(Fecha_menos_dos_horas);
					 formatter = new SimpleDateFormat("MMM",new Locale("us_US"));
					 mes_menos_dos_horas= formatter.format(Fecha_menos_dos_horas);
				 
			
				 
				 String nuevo_bucle_a_generar = año_actual + mes_actual + dia_actual + hora_actual + minutos_actual;
			
				 //importante admiración delante de ultimo_bucle_generado ....
			
				 if ( (Integer.parseInt(minutos_actual)-Integer.parseInt(minutos_generacion)) == 0 && !ultimo_bucle_generado.equals(nuevo_bucle_a_generar) ){
					 generar_ahora = 1;
			 	ultimo_bucle_generado = año_actual + mes_actual + dia_actual + hora_actual + minutos_actual;
				 }else{
				generar_ahora = 0;
				 }
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					
			}while(generar_ahora != 1);
				
			
				propiedades Archivopropiedades = new propiedades();
				String temp_outFile = Archivopropiedades.temp_outFile();
				String cms_outFile = Archivopropiedades.cms_outFile();
				System.out.println(temp_outFile);
				System.out.println(cms_outFile);
				
				//se comentan estas lineas para probar con el comando pisnap.
				//String texto1 = "@echo off\r\n@table piarc\r\n@mode list\r\n@istru tag, starttime, endtime, count\r\n@ostru tag, value\r\n@ostru ...\r\n";	
				//String texto2 = "FiscalMeter.Tag,"+ dia_hora_anterior+"-"+ mes_hora_anterior+"-"+año_hora_anterior+" "+hora_anterior+":00:00,"+dia_actual+"-"+mes_actual+"-"+año_actual+
				//		" "+hora_actual+":00:00,1\r\n";
				//String texto3 = "@endsection\r\n";
				//String todo = texto1+texto2+texto3;
				String todo= "@echo off\r\n@table pisnap\r\n@mode list\r\n@ostr tag, value\r\n@sele tag=FiscalMeter.Tag\r\n@ends\r\n";
				
				
				//System.out.println(todo);
				try {
				File f = new File("0ZIVtag.txt");
				FileWriter fw;
				fw = new FileWriter(f);
				fw.write(todo);
				fw.close();
				Runtime rt = Runtime.getRuntime();
				Process pr1;
				///////String archivo_salida = temp_outFile + "AmorebietaCMSPlantData_" + año_hora_anterior_largo + año_hora_anterior_largo + dia_hora_anterior + hora_anterior + "_ZIV.dat";
				///String archivo_salida = temp_outFile + "AmorebietaCMSPlantData_" + año_menos_dos_horas_largo + mes_menos_dos_horas_corto + dia_menos_dos_horas + hora_menos_dos_horas + "_ZIV.dat";
				String archivo_salida = temp_outFile + "AmorebietaCMSPlantData_" + año_hora_anterior_largo + mes_corto_hora_anterior + dia_hora_anterior + hora_anterior + "_ZIV.dat";
				
				
				
				String rt_exec = "cmd /c D://PI//adm//piconfig < 0ZIVtag.txt > " + archivo_salida;
				pr1 = rt.exec(rt_exec);
				
			//	System.out.println(rt_exec);
				BufferedReader input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
				String line=null;
				while((line=input.readLine()) != null) {
			        System.out.println(line); 
			        int exitVal;
			        exitVal = pr1.waitFor();
			        System.out.println("Exited with error code "+exitVal); 
				}			
				
				File file = new File(archivo_salida);
				System.out.println("Se va a mover el archivo " + archivo_salida);
				File dir = new File(cms_outFile);
				
				boolean success = file.renameTo(new File(dir, file.getName()));
				
				//boolean success = true;
				System.out.println("A la dirección " + cms_outFile);
				
				if (!success) {
				   System.out.println("No se ha podido mover el fichero");
				}else{
				 // System.out.println("Fichero " + "AmorebietaCMSPlantData_" + año_menos_dos_horas_largo + mes_menos_dos_horas_corto + dia_menos_dos_horas + hora_menos_dos_horas + "_ZIV.dat"+ " movido con exito");
					 System.out.println("Fichero " + "AmorebietaCMSPlantData_" + año_hora_anterior_largo + mes_corto_hora_anterior + dia_hora_anterior + hora_anterior + "_ZIV.dat"+ " movido con exito");
				}
				
				
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
				}catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				//////////////////HOURLY VALUES PLANT DATA
				
				try {
					
				// A veces los valores .TAG se quedan sin recalcular.
				// Por eso añado esta función para recalcular 2 horas hacia atrás antes exportar los valores
					
					Runtime rt = Runtime.getRuntime();
					Process pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=ACTUALTEMP.TAG,*-2h,*");
					BufferedReader input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
					String line=null;
					 while((line=input.readLine()) != null) {
		                    System.out.println(line); 
					 }
					 int exitVal = pr1.waitFor();
					 System.out.println("Exited with error code "+exitVal); 
					 
					 	rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=ACTUALHUMID.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
					
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=ACTUALPRESSURE.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=ACTUALWD.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=ACTUALWS.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=FFHGT1.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=FFHGT2.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=GT1START.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=GT2START.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=GT1SHUT.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=GT2SHUT.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=ACTUALPF.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=GASMETER_Nm3.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=GASMETER_MWhLHV.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 
						 
						 rt = Runtime.getRuntime();
						 pr1 = rt.exec("cmd /c D://PI//bin//pirecalc /ex=CO2Tn.TAG,*-2h,*");
						 input = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
						 line=null;
						 while((line=input.readLine()) != null) {
			                    System.out.println(line); 
						 }
						 exitVal = pr1.waitFor();
						 System.out.println("Exited with error code "+exitVal); 

						 String texto_hourly_values = "@echo off\r\n@table pisnap\r\n@mode list\r\n@ostr tag,value\r\n@sele tag=ACTUALTEMP.TAG\r\n@ends\r\n@sele tag=ACTUALHUMID.TAG\r\n@ends\r\n" +
				"@sele tag=ACTUALPRESSURE.TAG\r\n@ends\r\n@sele tag=ACTUALWD.TAG\r\n@ends\r\n@sele tag=ACTUALWS.TAG\r\n@ends\r\n@sele tag=FFHGT1.TAG\r\n@ends\r\n" +
				"@sele tag=FFHGT2.TAG\r\n@ends\r\n@sele tag=GT1START.TAG\r\n@ends\r\n@sele tag=GT2START.TAG\r\n@ends\r\n@sele tag=GT1SHUT.TAG\r\n@ends\r\n@sele tag=GT2SHUT.TAG\r\n"+
				"@ends\r\n@sele tag=ACTUALPF.TAG\r\n@ends\r\n@sele tag=GASMETER_Nm3.TAG\r\n@ends\r\n@sele tag=GASMETER_MWhLHV.TAG\r\n@ends\r\n@sele tag=CO2Tn.TAG\r\n@ends\r\n";
				
			//	System.out.println(texto_hourly_values);
				
				
					Thread.sleep(10000);
					File f2 = new File("hourly_output_snapshot.txt");
					FileWriter fw2;
					fw2 = new FileWriter(f2);
					fw2.write(texto_hourly_values);
					fw2.close();
					
					Runtime rt2 = Runtime.getRuntime();
					Process pr2;
					String archivo_salida2 = temp_outFile + "AmorebietaCMSPlantData_" + año_hora_anterior_largo + mes_corto_hora_anterior + dia_hora_anterior + hora_anterior + ".dat";
					String rt_exec2 = "cmd /c D://PI//adm//piconfig < hourly_output_snapshot.txt > " + archivo_salida2;
					pr2 = rt2.exec(rt_exec2);
					
				//	System.out.println(rt_exec2);
					BufferedReader input2 = new BufferedReader(new InputStreamReader(pr2.getInputStream()));
					String line2=null;
					while((line2=input2.readLine()) != null) {
				        System.out.println(line2); 
				        int exitVal2;
				        exitVal2 = pr2.waitFor();
				        System.out.println("Exited with error code "+exitVal2); 
					}
				
					File file2 = new File(archivo_salida2);
					System.out.println("Se va a mover el archivo " + archivo_salida2);
					File dir2 = new File(cms_outFile);
					boolean success2 = file2.renameTo(new File(dir2, file2.getName()));
					System.out.println("A la dirección " + cms_outFile);
					
					if (!success2) {
					   System.out.println("No se ha podido mover el fichero");
					}else{
					  System.out.println("Fichero " + "AmorebietaCMSPlantData_" + año_hora_anterior_largo + mes_corto_hora_anterior + dia_hora_anterior + hora_anterior + ".dat"+ " movido con exito");
					}
					
					
					
					
					
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
					
				
				
			 
			 
			 
			 
			 
			 
		}
		
	}

}
