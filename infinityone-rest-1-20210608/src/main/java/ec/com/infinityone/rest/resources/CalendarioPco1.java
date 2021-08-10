package ec.com.infinityone.rest.resources;



/**
 * Insert the type's description here.
 * Creation date: (28/04/2003 15:12:24)
 * @author: Fernando Tapia
 */
public class CalendarioPco1 {
        
	public static final String CALENDARIO = "CALENDARIO";
	public static final String LABORABLE = "CALENDARIO";
	private static com.ibm.calendar.Calendar calendario =null;
	//private static java.util.Vector st = obtenerFechasEspecialesHabiles();//ManejadorTokens.armarTokenizer(pco.facturacion.metaData.Empresa.DIAS_ESPECIALES_HABILES,";");
/**
 * CalendarioPco constructor comment.
 */
public CalendarioPco1() {
	super();
}
/**
 * Encuentra una fecha final sumando d�as y verificando si es o no feriado o fin de semana
 * @parametros java.sql.Date fechaInicial,int numeroDias, String tipoPlazo
 * @return java.sql.Date df
 * @fecha 2011-02-04
 * @autor ftapia
 * @excepciones throws Throwable
 */
public static java.sql.Date calcularFechaFinal(java.sql.Date fechaInicial,int numeroDias, String tipoPlazo, String festivos) throws Throwable{
	java.sql.Date df = null;
	
	getUnCalendario(festivos);
	getUnCalendario().getHolidays();

	if(tipoPlazo.equalsIgnoreCase("CAL")){
            System.out.println("CALENDARIO");
		df = calcularFechaFinalCalendario(fechaInicial, numeroDias);
	}else if(tipoPlazo.equalsIgnoreCase("LAB")){
            System.out.println("LABBBBO");
		df = calcularFechaFinalLaborable(fechaInicial, numeroDias);
	}
	
	return df;
}
/**
 * Calcula la fecha final calendario
 * @parametros java.sql.Date fechaInicial, int numeroDias
 * @return java.sql.Date df
 * @fecha 2011-02-04
 * @autor ftapia
 * @excepciones
 */
public static java.sql.Date calcularFechaFinalCalendario(java.sql.Date fechaInicial, int numeroDias) {
	long dil = fechaInicial.getTime();
	Long numeroDiasl = new Long(numeroDias);

	long numeroDiasFinal = dil + (numeroDiasl.longValue()*((1*24)*60*60*1000));
	java.sql.Date df = new java.sql.Date(numeroDiasFinal);
 
	return df;
}
	
/**
 * Calcula la fecha final laborables
 * @parametros java.sql.Date fechaInicial, int numeroDias
 * @return java.sql.Date df
 * @fecha 2011-02-04
 * @autor ftapia
 * @excepciones throws Throwable
 */
public static java.sql.Date calcularFechaFinalLaborable(java.sql.Date fechaInicial, int numeroDias)throws Throwable{

	long dil = fechaInicial.getTime();
	long numeroDiasFinal = 0;
	java.sql.Date f = fechaInicial;
	java.sql.Date df = new java.sql.Date(dil);
	
	for (int i = 0; i < numeroDias; i++){
		numeroDiasFinal = dil + (24*60*60*1000);
		df = new java.sql.Date(numeroDiasFinal);
		
		getUnCalendario().setSelectedDate(df);
		java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
		gc.setTime(df);
		
		df = saltaDiasNoLaborables(df);
		dil = df.getTime();
	}
	
    return df;
}
	

	
/**
 * Valida si la fecha es feriado
 * @parametros java.sql.Date fecha
 * @rerurn boolean resultado
 * @fecha 2011-03-17
 * @autor brivera
 * @excepciones throws ErrorFacturacion 
*/
public static boolean esFeriado(java.sql.Date fecha) throws Throwable{
	boolean resultado = false; 

	getUnCalendario().setSelectedDate(fecha);
	java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
	gc.setTime(fecha);
	
	if(getUnCalendario().isHoliday(gc)){
		resultado = true;
	}
	
	return resultado;
}
/**
 * Valida si la fecha es fin de semana
 * @parametros java.sql.Date fecha
 * @rerurn boolean resultado
 * @fecha 2011-02-24
 * @autor brivera
 * @excepciones throws ErrorFacturacion 
*/
public static boolean esFinDeSemana(java.sql.Date fecha) throws Throwable{
	
	boolean resultado = false;
	getUnCalendario().setSelectedDate(fecha);
	java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
	gc.setTime(fecha);
	//pco.facturacion.metaData.varios.FechaEspecialHabil temp;
	
	//java.util.Vector v = obtenerFechasEspecialesHabiles();
	if((gc.get(gc.DAY_OF_WEEK)==1) || (gc.get(gc.DAY_OF_WEEK)==7)) { //getCalendar1().isWeekend(fecha.getDay())){
	
            /*for (int i = 0; i < st.size(); i++){
			temp = (pco.facturacion.metaData.varios.FechaEspecialHabil)st.get(i);
			
			if(temp.getFecha().compareTo(fecha)==0)
				return resultado;
            }*/
	
            resultado = true;
	}

	return resultado;
}
/**
 * se ha cambiado la logica del metodo para utilizar este metodo como un Singlenton
 * revisar si esto es correcto o NO
 * Creation date: (28/04/2003 15:13:15)
 * @return com.ibm.calendar.Calendar
 */
public static com.ibm.calendar.Calendar getCalendario() {
	return calendario;

	/*	
	if(calendario==null){
		try{
			calendario = new com.ibm.calendar.Calendar();
			pco.facturacion.metaData.varios.Festivo f = new pco.facturacion.metaData.varios.Festivo();
			java.util.Vector v = f.buscarTodo();
			String s = "";
			for (int i = 0; i < v.size(); i++){
				s = s + ((pco.facturacion.metaData.varios.Festivo)v.get(i)).getFestivo().trim();
				if (i < (v.size()-1)) s = s + ",";
			}
			calendario.setHolidays(s);
		}catch(Throwable t ){
			throw new Throwable("00014","No se ha logrado generar el calendario para para PCO");//
		}
		
		
	}
	return calendario;
	*/
}
/**
 * Devuelve un Calendario incluyendo o excluyendo los festivos.
 * @parametros ()
 * @return com.ibm.calendar.Calendar calendario
 * @fecha throws Throwable
 * @autor ftapia
 * @excepciones throws Throwable
 */
public static com.ibm.calendar.Calendar getUnCalendario() throws Throwable{
	
	if(calendario==null){
		try{
			calendario = new com.ibm.calendar.Calendar();
                                         
                        
	//		pco.facturacion.metaData.varios.Festivo f = new pco.facturacion.metaData.varios.Festivo();
			
	//		java.util.Vector v = f.buscarTodo(true);
			

                        String s = "";
			/*
                        for (int i = 0; i < v.size(); i++){
				s = s + ((pco.facturacion.metaData.varios.Festivo)v.get(i)).getFestivo().trim();
				if (i < (v.size()-1)) s = s + ",";
			}
			*/
                        
			//Borrar esto
				s="2021/7/7,2021/7/10,2021/7/15,/2/27,/3/1,/3/2,/3/3,/3/4";
			//Borrar esto
			calendario.setHolidays(s);
		}catch(Throwable t ){
			throw new Throwable("No se ha logrado generar el calendario con las fechas festivas");//
		}
	}
	
	return calendario;
}

public static com.ibm.calendar.Calendar getUnCalendario(String festivos) throws Throwable{
	
      
	if(calendario==null){
		try{
			calendario = new com.ibm.calendar.Calendar();
                                                
	//		pco.facturacion.metaData.varios.Festivo f = new pco.facturacion.metaData.varios.Festivo();
			
	//		java.util.Vector v = f.buscarTodo(true);
			

                        String s = "";
			/*
                        for (int i = 0; i < v.size(); i++){
				s = s + ((pco.facturacion.metaData.varios.Festivo)v.get(i)).getFestivo().trim();
				if (i < (v.size()-1)) s = s + ",";
			}
			*/
                        
			//Borrar esto
			//	s="2021/7/7,2021/7/10,2021/7/15,/2/27,/3/1,/3/2,/3/3,/3/4";
			System.out.println("CALENDARIO.getCalendar(festivos) "+festivos);
                        //Borrar esto
			calendario.setHolidays(festivos);
		}catch(Throwable t ){
			throw new Throwable("No se ha logrado generar el calendario con las fechas festivas");//
		}
	}
	
	return calendario;
}

/**
 * Se obtienen las fechas cargadas en la tabla FECHAESPECIALHABIL para tomar fechas por a�o que siendo fines de semana deben ser consideradas
 * como habiles para el calculo de fechas de Vmto o Acredirtaci�n
 * @parametros ()
 * @return java.util.Vector vFechasHabiles
 * @fecha (05/03/2007 15:13:15)
 * @autor ftapia
 * @excepciones


public static java.util.Vector obtenerFechasEspecialesHabiles() {

	java.util.Vector vFechasHabiles = null;
	try{
		vFechasHabiles = pco.facturacion.metaData.varios.FechaEspecialHabil.buscarTodo();
	}catch(Throwable t){
		pco.util.LoggerManager.logger.debug("Error en CalendarioPCO.obtenerFechasEspecialesHabiles()::"+t.toString());
	}
	
	return vFechasHabiles;
}
 */

/**
 * Salta a siguiente primer d�a laborable
 * @parametros java.sql.Date fecha
 * @return java.sql.Date df
 * @fecha 2011-02-04
 * @autor ftapia
 * @excepciones throws Throwable
 */
private static java.sql.Date saltaDiasNoLaborables(java.sql.Date fecha) throws Throwable{
        System.out.println("saltaDiasNoLaborables: "+ fecha);
        java.sql.Date fechaFinal = fecha; 
	getUnCalendario().setSelectedDate(fechaFinal);
        System.out.println("getUnCalendario().setSelectedDate(fechaFinal): "+ getUnCalendario().getSelectedDate());
	long numeroDiasFinal=0;
	java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
	gc.setTime(fecha);
        System.out.println("gc.setTime(fecha): "+gc.getTime());
	numeroDiasFinal =  fecha.getTime();
	
	//java.util.StringTokenizer st = ManejadorTokens.armarTokenizer(pco.facturacion.metaData.Empresa.DIAS_ESPECIALES_HABILES,";");
	if(getUnCalendario().isHoliday(gc)){
            System.out.println("getUnCalendario().isHoliday(gc): "+ getUnCalendario().isHoliday(gc));
		numeroDiasFinal = fechaFinal.getTime();
		numeroDiasFinal = numeroDiasFinal + (24*60*60*1000);
		java.sql.Date d = new java.sql.Date(numeroDiasFinal);
		fechaFinal = d;
		fechaFinal = saltaDiasNoLaborables(fechaFinal);
	}else if(esFinDeSemana(fecha)){//(gc.get(gc.DAY_OF_WEEK)==1) || (gc.get(gc.DAY_OF_WEEK)==7)) { //getCalendar1().isWeekend(fecha.getDay())){
		System.out.println("esFinDeSemana(fecha): "+ fecha+ " - "+esFinDeSemana(fecha));
            numeroDiasFinal = numeroDiasFinal + (24*60*60*1000);
		java.sql.Date d = new java.sql.Date(numeroDiasFinal);
			
		fechaFinal = d;
		fechaFinal = saltaDiasNoLaborables(fechaFinal);
	}
	
	return fechaFinal;
}
/**
 * Insert the method's description here.
 * Creation date: (28/04/2003 15:13:15)
 * @param newCalendario com.ibm.calendar.Calendar
 */
public static void setCalendario(com.ibm.calendar.Calendar newCalendario) {
	calendario = newCalendario;
}
/**
 * Comment
 */
private static java.sql.Date verificaFeriado(java.sql.Date fecha) throws Throwable{
		java.sql.Date fechaFinal = fecha; 
		getUnCalendario().setSelectedDate(fechaFinal);
		long numeroDiasFinal=0;
		java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
		gc.setTime(fecha);
		numeroDiasFinal =  fecha.getTime();
		if(getUnCalendario().isHoliday(gc)){
			numeroDiasFinal = fechaFinal.getTime();
			numeroDiasFinal = numeroDiasFinal + (24*60*60*1000);
			java.sql.Date d = new java.sql.Date(numeroDiasFinal);
			fechaFinal = d;
			fechaFinal = verificaFeriado(fechaFinal);
			
		}
    return fechaFinal;
}
/**
 * Comment
 */
private static java.sql.Date verificaFinDeSemana(java.sql.Date fecha)throws Throwable {
		java.sql.Date fechaFinal = fecha; 
		getUnCalendario().setSelectedDate(fechaFinal);
		long numeroDiasFinal=0;
		java.util.GregorianCalendar gc = new java.util.GregorianCalendar();
		gc.setTime(fechaFinal);
		numeroDiasFinal = fechaFinal.getTime();
		
		if((gc.get(gc.DAY_OF_WEEK)==1) || (gc.get(gc.DAY_OF_WEEK)==7)) { //getCalendar1().isWeekend(fecha.getDay())){
			numeroDiasFinal = numeroDiasFinal + (24*60*60*1000);
			java.sql.Date d = new java.sql.Date(numeroDiasFinal);
			fechaFinal = d;
			fechaFinal = verificaFinDeSemana(fechaFinal);
			
		}
    return fechaFinal;
}
	
}
