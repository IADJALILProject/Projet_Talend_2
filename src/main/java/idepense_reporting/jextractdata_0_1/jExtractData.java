// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package idepense_reporting.jextractdata_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_1
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: jExtractData Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class jExtractData implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(depenseFolder != null){
				
					this.setProperty("depenseFolder", depenseFolder.toString());
				
			}
			
			if(dataFolder != null){
				
					this.setProperty("dataFolder", dataFolder.toString());
				
			}
			
			if(dataJour != null){
				
					this.setProperty("dataJour", dataJour.toString());
				
			}
			
			if(encodage != null){
				
					this.setProperty("encodage", encodage.toString());
				
			}
			
			if(fieldSeparator != null){
				
					this.setProperty("fieldSeparator", fieldSeparator.toString());
				
			}
			
			if(projectFolder != null){
				
					this.setProperty("projectFolder", projectFolder.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String depenseFolder;
		public String getDepenseFolder(){
			return this.depenseFolder;
		}
		
public String dataFolder;
public String getDataFolder(){
	return this.dataFolder;
}
public String dataJour;
public String getDataJour(){
	return this.dataJour;
}
public String encodage;
public String getEncodage(){
	return this.encodage;
}
public String fieldSeparator;
public String getFieldSeparator(){
	return this.fieldSeparator;
}
		public String projectFolder;
		public String getProjectFolder(){
			return this.projectFolder;
		}
		
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "jExtractData";
	private final String projectName = "IDEPENSE_REPORTING";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				jExtractData.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(jExtractData.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tChronometerStart_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tChronometerStart_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tChronometerStop_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tChronometerStop_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileList_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileList_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFlowToIterate_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tChronometerStart_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tChronometerStop_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileList_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFixedFlowInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tChronometerStart_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tChronometerStart_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tChronometerStart_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tChronometerStart_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tChronometerStart_1", false);
		start_Hash.put("tChronometerStart_1", System.currentTimeMillis());
		
	
	currentComponent="tChronometerStart_1";

	
		int tos_count_tChronometerStart_1 = 0;
		

	
	
	Long currentTimetChronometerStart_1 = System.currentTimeMillis();
	
	globalMap.put("tChronometerStart_1",currentTimetChronometerStart_1);
	globalMap.put("tChronometerStart_1_STARTTIME", currentTimetChronometerStart_1);
 



/**
 * [tChronometerStart_1 begin ] stop
 */
	
	/**
	 * [tChronometerStart_1 main ] start
	 */

	

	
	
	currentComponent="tChronometerStart_1";

	

 


	tos_count_tChronometerStart_1++;

/**
 * [tChronometerStart_1 main ] stop
 */
	
	/**
	 * [tChronometerStart_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tChronometerStart_1";

	

 



/**
 * [tChronometerStart_1 process_data_begin ] stop
 */
	
	/**
	 * [tChronometerStart_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tChronometerStart_1";

	

 



/**
 * [tChronometerStart_1 process_data_end ] stop
 */
	
	/**
	 * [tChronometerStart_1 end ] start
	 */

	

	
	
	currentComponent="tChronometerStart_1";

	

 

ok_Hash.put("tChronometerStart_1", true);
end_Hash.put("tChronometerStart_1", System.currentTimeMillis());




/**
 * [tChronometerStart_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tChronometerStart_1 finally ] start
	 */

	

	
	
	currentComponent="tChronometerStart_1";

	

 



/**
 * [tChronometerStart_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tChronometerStart_1_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";

	
		int tos_count_tPostjob_1 = 0;
		

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tChronometerStop_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tChronometerStop_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tChronometerStop_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tChronometerStop_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tChronometerStop_1", false);
		start_Hash.put("tChronometerStop_1", System.currentTimeMillis());
		
	
	currentComponent="tChronometerStop_1";

	
		int tos_count_tChronometerStop_1 = 0;
		
	
	long timetChronometerStop_1;
	
		timetChronometerStop_1 = System.currentTimeMillis() - startTime;
		
	   		System.out.print("[ tChronometerStop_1 ]  ");
		
	  	System.out.println("" + "  " + timetChronometerStop_1 + " milliseconds");
	  	 
	
	Long currentTimetChronometerStop_1 = System.currentTimeMillis();
	globalMap.put("tChronometerStop_1", currentTimetChronometerStop_1);
	
	globalMap.put("tChronometerStop_1_STOPTIME", currentTimetChronometerStop_1);
	globalMap.put("tChronometerStop_1_DURATION", timetChronometerStop_1);
 



/**
 * [tChronometerStop_1 begin ] stop
 */
	
	/**
	 * [tChronometerStop_1 main ] start
	 */

	

	
	
	currentComponent="tChronometerStop_1";

	

 


	tos_count_tChronometerStop_1++;

/**
 * [tChronometerStop_1 main ] stop
 */
	
	/**
	 * [tChronometerStop_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tChronometerStop_1";

	

 



/**
 * [tChronometerStop_1 process_data_begin ] stop
 */
	
	/**
	 * [tChronometerStop_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tChronometerStop_1";

	

 



/**
 * [tChronometerStop_1 process_data_end ] stop
 */
	
	/**
	 * [tChronometerStop_1 end ] start
	 */

	

	
	
	currentComponent="tChronometerStop_1";

	

 

ok_Hash.put("tChronometerStop_1", true);
end_Hash.put("tChronometerStop_1", System.currentTimeMillis());




/**
 * [tChronometerStop_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tChronometerStop_1 finally ] start
	 */

	

	
	
	currentComponent="tChronometerStop_1";

	

 



/**
 * [tChronometerStop_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tChronometerStop_1_SUBPROCESS_STATE", 1);
	}
	

public void tFileList_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileList_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tFileList_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileList_1", false);
		start_Hash.put("tFileList_1", System.currentTimeMillis());
		
	
	currentComponent="tFileList_1";

	
		int tos_count_tFileList_1 = 0;
		
	
 
     
    
  String directory_tFileList_1 = context.projectFolder + context.dataFolder;
  final java.util.List<String> maskList_tFileList_1 = new java.util.ArrayList<String>();
  final java.util.List<java.util.regex.Pattern> patternList_tFileList_1 = new java.util.ArrayList<java.util.regex.Pattern>(); 
    maskList_tFileList_1.add(TalendDate.getDate("YYYYMMDD"));  
  for (final String filemask_tFileList_1 : maskList_tFileList_1) {
	String filemask_compile_tFileList_1 = filemask_tFileList_1;
	
		filemask_compile_tFileList_1 = org.apache.oro.text.GlobCompiler.globToPerl5(filemask_tFileList_1.toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);
	
		java.util.regex.Pattern fileNamePattern_tFileList_1 = java.util.regex.Pattern.compile(filemask_compile_tFileList_1);
	patternList_tFileList_1.add(fileNamePattern_tFileList_1);
  }
  int NB_FILEtFileList_1 = 0;

  final boolean case_sensitive_tFileList_1 = true;
	
	
	
    final java.util.List<java.io.File> list_tFileList_1 = new java.util.ArrayList<java.io.File>();
    final java.util.Set<String> filePath_tFileList_1 = new java.util.HashSet<String>();
	java.io.File file_tFileList_1 = new java.io.File(directory_tFileList_1);
     
		file_tFileList_1.listFiles(new java.io.FilenameFilter() {
			public boolean accept(java.io.File dir, String name) {
				java.io.File file = new java.io.File(dir, name);
                if (file.isDirectory()) {
                	
    	String fileName_tFileList_1 = file.getName();
		for (final java.util.regex.Pattern fileNamePattern_tFileList_1 : patternList_tFileList_1) {
          	if (fileNamePattern_tFileList_1.matcher(fileName_tFileList_1).matches()){
					if(!filePath_tFileList_1.contains(file.getAbsolutePath())) {
			          list_tFileList_1.add(file);
			          filePath_tFileList_1.add(file.getAbsolutePath());
			        }
			}
		}
                }
              return true;
            }
          }
      ); 
      java.util.Collections.sort(list_tFileList_1);
    
    for (int i_tFileList_1 = 0; i_tFileList_1 < list_tFileList_1.size(); i_tFileList_1++){
      java.io.File files_tFileList_1 = list_tFileList_1.get(i_tFileList_1);
      String fileName_tFileList_1 = files_tFileList_1.getName();
      
      String currentFileName_tFileList_1 = files_tFileList_1.getName(); 
      String currentFilePath_tFileList_1 = files_tFileList_1.getAbsolutePath();
      String currentFileDirectory_tFileList_1 = files_tFileList_1.getParent();
      String currentFileExtension_tFileList_1 = null;
      
      if (files_tFileList_1.getName().contains(".") && files_tFileList_1.isFile()){
        currentFileExtension_tFileList_1 = files_tFileList_1.getName().substring(files_tFileList_1.getName().lastIndexOf(".") + 1);
      } else{
        currentFileExtension_tFileList_1 = "";
      }
      
      NB_FILEtFileList_1 ++;
      globalMap.put("tFileList_1_CURRENT_FILE", currentFileName_tFileList_1);
      globalMap.put("tFileList_1_CURRENT_FILEPATH", currentFilePath_tFileList_1);
      globalMap.put("tFileList_1_CURRENT_FILEDIRECTORY", currentFileDirectory_tFileList_1);
      globalMap.put("tFileList_1_CURRENT_FILEEXTENSION", currentFileExtension_tFileList_1);
      globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);
      
 



/**
 * [tFileList_1 begin ] stop
 */
	
	/**
	 * [tFileList_1 main ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 


	tos_count_tFileList_1++;

/**
 * [tFileList_1 main ] stop
 */
	
	/**
	 * [tFileList_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 



/**
 * [tFileList_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileList_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 



/**
 * [tFileList_1 process_data_end ] stop
 */
	
	/**
	 * [tFileList_1 end ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

  
    }
  globalMap.put("tFileList_1_NB_FILE", NB_FILEtFileList_1);
  

  
 

 

ok_Hash.put("tFileList_1", true);
end_Hash.put("tFileList_1", System.currentTimeMillis());

   			if (((Integer)globalMap.get("tFileList_1_NB_FILE"))==0


) {
   				
					if(execStat){
   	 					runStat.updateStatOnConnection("If1", 0, "true");
					}
				tJava_1Process(globalMap);
			}

			   
   				else{
					if(execStat){   
   	 					runStat.updateStatOnConnection("If1", 0, "false");
					}   	 
   				}



/**
 * [tFileList_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileList_1 finally ] start
	 */

	

	
	
	currentComponent="tFileList_1";

	

 



/**
 * [tFileList_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileList_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


new java.io.File(context.projectFolder+context.dataFolder+ context.dataJour).mkdirs();

 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());




/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tJava_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tFixedFlowInput_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_IDEPENSE_REPORTING_jExtractData = new byte[0];
    static byte[] commonByteArray_IDEPENSE_REPORTING_jExtractData = new byte[0];

	
			    public String JobName;

				public String getJobName () {
					return this.JobName;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jExtractData.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jExtractData.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jExtractData = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jExtractData = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_IDEPENSE_REPORTING_jExtractData, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jExtractData, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jExtractData.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jExtractData.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jExtractData = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jExtractData = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_IDEPENSE_REPORTING_jExtractData, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jExtractData, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jExtractData) {

        	try {

        		int length = 0;
		
					this.JobName = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jExtractData) {

        	try {

        		int length = 0;
		
					this.JobName = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.JobName,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.JobName,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("JobName="+JobName);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFixedFlowInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();




	
	/**
	 * [tFlowToIterate_1 begin ] start
	 */

				
			int NB_ITERATE_tRunJob_1 = 0; //for statistics
			

	
		
		ok_Hash.put("tFlowToIterate_1", false);
		start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());
		
	
	currentComponent="tFlowToIterate_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tFlowToIterate_1 = 0;
		

int nb_line_tFlowToIterate_1 = 0;
int counter_tFlowToIterate_1 = 0;

 



/**
 * [tFlowToIterate_1 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_1", false);
		start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_1";

	
		int tos_count_tFixedFlowInput_1 = 0;
		


StringBuilder result_tFixedFlowInput_1 = new StringBuilder();
	result_tFixedFlowInput_1.append("akRFUEVOU0UNCmpTT1VTX0NBVEVHT1JJRQ0KakNBVEVHT1JJRQ0K");
String originalFileContent_tFixedFlowInput_1 = "";
try {
    originalFileContent_tFixedFlowInput_1 = new String(java.util.Base64.getMimeDecoder().decode(result_tFixedFlowInput_1.toString()), utf8Charset);
} catch (java.lang.Exception e) {
globalMap.put("tFixedFlowInput_1_ERROR_MESSAGE",e.getMessage());
    e.printStackTrace();
}

int nb_line_tFixedFlowInput_1 = 0;

for (int i_tFixedFlowInput_1 = 0 ; i_tFixedFlowInput_1 < 1 ; i_tFixedFlowInput_1++) {	

java.io.InputStream ins_tFixedFlowInput_1 = new java.io.ByteArrayInputStream(originalFileContent_tFixedFlowInput_1.getBytes(utf8Charset));        
org.talend.fileprocess.FileInputDelimited fid_tFixedFlowInput_1 = new org.talend.fileprocess.FileInputDelimited(ins_tFixedFlowInput_1, utf8Charset,context.fieldSeparator,"\n",true, 0, 0, -1, -1, false);

while (fid_tFixedFlowInput_1.nextRecord()) {
	nb_line_tFixedFlowInput_1++;
			row1 = new row1Struct();

				if(0 < fid_tFixedFlowInput_1.getColumnsCountOfCurrentRow()){
					String colContent = fid_tFixedFlowInput_1.get(0);				
                    		row1.JobName = (colContent == null || colContent.length() == 0) ? null: colContent;			
				} else { 
					
					row1.JobName = null;
				
				}
			
			

 



/**
 * [tFixedFlowInput_1 begin ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 main ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 


	tos_count_tFixedFlowInput_1++;

/**
 * [tFixedFlowInput_1 main ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tFlowToIterate_1 main ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

	
    	
              globalMap.put("JobName", row1.JobName); 
	   nb_line_tFlowToIterate_1++;  
       counter_tFlowToIterate_1++;
       globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);
 


	tos_count_tFlowToIterate_1++;

/**
 * [tFlowToIterate_1 main ] stop
 */
	
	/**
	 * [tFlowToIterate_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 process_data_begin ] stop
 */
	NB_ITERATE_tRunJob_1++;
	
	
				if(execStat){
					runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tRunJob_1);
					//Thread.sleep(1000);
				}				
			

	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
		int tos_count_tRunJob_1 = 0;
		
class DealChildJobLibrary_tRunJob_1 {

	public String replaceJarPathsFromCrcMap(String originalClassPathLine) throws java.lang.Exception {
		String classPathLine = "";
		String crcMapPath = new java.io.File("../crcMap").getCanonicalPath();
		if (isNeedAddLibsPath( crcMapPath)) {
			java.util.Map<String, String> crcMap = null;
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(crcMapPath)) {
				@Override
				public Class<?> resolveClass(java.io.ObjectStreamClass desc) throws java.io.IOException, ClassNotFoundException {
					if(!"java.util.HashMap".equals(desc.getName())) {
						throw new java.io.InvalidClassException("Unauthorized deserialization attempt : " + desc.getName());
					}
					return super.resolveClass(desc);
				}
			};
			crcMap = (java.util.Map<String, String>) ois.readObject();
			ois.close();
			classPathLine = addLibsPath(originalClassPathLine, crcMap);
		} else {
			classPathLine = originalClassPathLine;
		}
		return classPathLine;
	}
	
	private boolean isNeedAddLibsPath(String crcMapPath) {
		if (!(new java.io.File(crcMapPath).exists())) {// when not use cache
			return false;
		}
		return true;
	}
	
	
	private String addLibsPath(String line, java.util.Map<String, String> crcMap) {
		for (java.util.Map.Entry<String, String> entry : crcMap.entrySet()) {
			line = adaptLibPaths(line, entry);
		}
		return line;
	}
	
	private String adaptLibPaths(String line, java.util.Map.Entry<String, String> entry) {
		String jarName = entry.getValue();
		String crc = entry.getKey();
		String libStringFinder = "../lib/" + jarName;
		if (line.contains(libStringFinder)) {
			line = line.replace(libStringFinder, "../../../cache/lib/" + crc + "/" + jarName);
		} else if (line.contains(":$ROOT_PATH/" + jarName + ":")) {
			line = line.replace(":$ROOT_PATH/" + jarName + ":", ":$ROOT_PATH/../../../cache/lib/" + crc + "/" + jarName + ":");
		} else if (line.contains(";" + jarName + ";")) {
			line = line.replace(";" + jarName + ";", ";../../../cache/lib/" + crc + "/" + jarName + ";");
		}
		return line;
	}
	
}
	DealChildJobLibrary_tRunJob_1 dealChildJobLibrary_tRunJob_1 = new DealChildJobLibrary_tRunJob_1();

	class JVMArgumentHelper_tRunJob_1 {
		
		
		
		private void addClasspath(java.util.List<String> target_argument_list, String job_origin_classpath) {
			
			String extra_classpath = null;
			String path_separator = System.getProperty("path.separator");
			if (path_separator != null && path_separator.length() > 1) {
				throw new RuntimeException("path separator should be single character");
			}
			
			if(extra_classpath!=null && !extra_classpath.isEmpty()) {
				if(extra_classpath.endsWith(path_separator)) {
					target_argument_list.add(extra_classpath+job_origin_classpath);
				} else if(extra_classpath.contains(path_separator)) {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				} else if(extra_classpath.endsWith(":")) {
					target_argument_list.add(extra_classpath.replace(":", path_separator)+job_origin_classpath);
				} else if(extra_classpath.endsWith(";")) {
					target_argument_list.add(extra_classpath.replace(";", path_separator)+job_origin_classpath);
				} else if(extra_classpath.contains(":")) {
					target_argument_list.add(concatStr(extra_classpath.replace(":", path_separator), path_separator, job_origin_classpath));
				} else if(extra_classpath.contains(";")) {
					target_argument_list.add(concatStr(extra_classpath.replace(";", path_separator), path_separator, job_origin_classpath));
				} else {
					target_argument_list.add(concatStr(extra_classpath, path_separator, job_origin_classpath));
				}
				return;
			}
			
			target_argument_list.add(job_origin_classpath);
		}
		
		private String concatStr(String s1, String s2, String s3) {
			java.lang.StringBuilder strB = new java.lang.StringBuilder();
			strB.append(s1).append(s2).append(s3);
			return strB.toString();
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child) {
			addArgumentsTo(target_argument_list, argument_from_child, false);
		}
		
		public void addArgumentsTo(java.util.List<String> target_argument_list, String argument_from_child, boolean isCP) {
			if(isCP) {
				addClasspath(target_argument_list, argument_from_child);
				return;
			}
		
			
			
			
			target_argument_list.add(argument_from_child);
			
		}
		
		
	}
	
	JVMArgumentHelper_tRunJob_1 jvm_argument_helper_tRunJob_1 = new JVMArgumentHelper_tRunJob_1();
	
	String audit_jar_path_tRunJob_1 = System.getProperty("classpath.extended");
	
		//For different jobs, job name must be different, but classpath and JVM arguments are possbilely different
		java.util.Map<String,List<String>> childJob_commandLine_Mapper_tRunJob_1 = new java.util.HashMap<String,List<String>>();
		java.util.List<String> childJob_commandLine_tRunJob_1 = null;
		String classpathSeparator_tRunJob_1 = System.getProperty("path.separator");
		if (classpathSeparator_tRunJob_1 != null && classpathSeparator_tRunJob_1.length() > 1) {
			throw new RuntimeException("path separator should be single character");
		}
		
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
					childJob_commandLine_tRunJob_1.add("java");
					
					final java.util.List<String> cc_tRunJob_1_0 = childJob_commandLine_tRunJob_1;
					if(enableLogStash){
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("audit."))
							.forEach(key -> cc_tRunJob_1_0.add("-D" + key + "=" + System.getProperty(key)));
					}
							
					System.getProperties().stringPropertyNames().stream()
						.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
						.forEach(key -> cc_tRunJob_1_0.add("-D" + key + "=" + System.getProperty(key)));
					
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Dtalend.component.manager.m2.repository=../lib".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		String classpath_tRunJob_1_0_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/commons-collections-3.2.2.jar;../lib/commons-math3-3.6.1.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/commons-codec-1.14.jar;../lib/poi-4.1.2-20200903124306_modified_talend.jar;../lib/dom4j-2.1.3.jar;../lib/slf4j-api-1.7.29.jar;../lib/poi-ooxml-schemas-4.1.2-20200903124306_modified_talend.jar;../lib/xmlbeans-3.1.0.jar;../lib/talendcsv-1.0.0.jar;../lib/crypto-utils-0.31.12.jar;../lib/jboss-marshalling-river-2.0.12.Final.jar;../lib/SparseBitSet-1.2.jar;../lib/commons-collections4-4.4.jar;../lib/commons-compress-1.21.jar;../lib/curvesapi-1.06.jar;../lib/advancedPersistentLookupLib-1.3.jar;../lib/poi-ooxml-4.1.2-20200903124306_modified_talend.jar;../lib/trove.jar;../lib/poi-scratchpad-4.1.2-20200903124306_modified_talend.jar;jcategorie_0_1.jar;";
				    		
				    		if(audit_jar_path_tRunJob_1!=null && !audit_jar_path_tRunJob_1.isEmpty()) {
				      			classpath_tRunJob_1_0_5 += audit_jar_path_tRunJob_1;
				      		}
				      		
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_0_5).replaceAll(";",classpathSeparator_tRunJob_1), true);
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "idepense_reporting.jcategorie_0_1.jCATEGORIE".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("jCATEGORIE",childJob_commandLine_tRunJob_1);	
			
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
					childJob_commandLine_tRunJob_1.add("java");
					
					final java.util.List<String> cc_tRunJob_1_1 = childJob_commandLine_tRunJob_1;
					if(enableLogStash){
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("audit."))
							.forEach(key -> cc_tRunJob_1_1.add("-D" + key + "=" + System.getProperty(key)));
					}
							
					System.getProperties().stringPropertyNames().stream()
						.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
						.forEach(key -> cc_tRunJob_1_1.add("-D" + key + "=" + System.getProperty(key)));
					
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Dtalend.component.manager.m2.repository=../lib".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		String classpath_tRunJob_1_1_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/SparseBitSet-1.2.jar;../lib/commons-math3-3.6.1.jar;../lib/commons-collections4-4.4.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/commons-compress-1.21.jar;../lib/commons-codec-1.14.jar;../lib/curvesapi-1.06.jar;../lib/poi-4.1.2-20200903124306_modified_talend.jar;../lib/dom4j-2.1.3.jar;../lib/poi-ooxml-4.1.2-20200903124306_modified_talend.jar;../lib/slf4j-api-1.7.29.jar;../lib/poi-ooxml-schemas-4.1.2-20200903124306_modified_talend.jar;../lib/xmlbeans-3.1.0.jar;../lib/poi-scratchpad-4.1.2-20200903124306_modified_talend.jar;../lib/talendcsv-1.0.0.jar;../lib/crypto-utils-0.31.12.jar;jdepense_0_1.jar;";
				    		
				    		if(audit_jar_path_tRunJob_1!=null && !audit_jar_path_tRunJob_1.isEmpty()) {
				      			classpath_tRunJob_1_1_5 += audit_jar_path_tRunJob_1;
				      		}
				      		
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_1_5).replaceAll(";",classpathSeparator_tRunJob_1), true);
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "idepense_reporting.jdepense_0_1.jDEPENSE".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("jDEPENSE",childJob_commandLine_tRunJob_1);	
			
				childJob_commandLine_tRunJob_1 = new java.util.ArrayList<String>();
				
					childJob_commandLine_tRunJob_1.add("java");
					
					final java.util.List<String> cc_tRunJob_1_2 = childJob_commandLine_tRunJob_1;
					if(enableLogStash){
						System.getProperties().stringPropertyNames().stream()
							.filter(it -> it.startsWith("audit."))
							.forEach(key -> cc_tRunJob_1_2.add("-D" + key + "=" + System.getProperty(key)));
					}
							
					System.getProperties().stringPropertyNames().stream()
						.filter(it -> it.startsWith("runtime.lineage.") || "classpath.extended".equals(it))
						.forEach(key -> cc_tRunJob_1_2.add("-D" + key + "=" + System.getProperty(key)));
					
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Dtalend.component.manager.m2.repository=../lib".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Xms256M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-Xmx1024M".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "-cp".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		String classpath_tRunJob_1_2_5 = ".;../lib/routines.jar;../lib/log4j-slf4j-impl-2.13.2.jar;../lib/log4j-api-2.13.2.jar;../lib/log4j-core-2.13.2.jar;../lib/log4j-1.2-api-2.13.2.jar;../lib/SparseBitSet-1.2.jar;../lib/commons-math3-3.6.1.jar;../lib/commons-collections4-4.4.jar;../lib/jboss-marshalling-2.0.12.Final.jar;../lib/commons-compress-1.21.jar;../lib/commons-codec-1.14.jar;../lib/curvesapi-1.06.jar;../lib/poi-4.1.2-20200903124306_modified_talend.jar;../lib/dom4j-2.1.3.jar;../lib/poi-ooxml-4.1.2-20200903124306_modified_talend.jar;../lib/slf4j-api-1.7.29.jar;../lib/poi-ooxml-schemas-4.1.2-20200903124306_modified_talend.jar;../lib/xmlbeans-3.1.0.jar;../lib/poi-scratchpad-4.1.2-20200903124306_modified_talend.jar;../lib/talendcsv-1.0.0.jar;../lib/crypto-utils-0.31.12.jar;jsous_categorie_0_1.jar;";
				    		
				    		if(audit_jar_path_tRunJob_1!=null && !audit_jar_path_tRunJob_1.isEmpty()) {
				      			classpath_tRunJob_1_2_5 += audit_jar_path_tRunJob_1;
				      		}
				      		
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, dealChildJobLibrary_tRunJob_1.replaceJarPathsFromCrcMap(classpath_tRunJob_1_2_5).replaceAll(";",classpathSeparator_tRunJob_1), true);
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "idepense_reporting.jsous_categorie_0_1.jSOUS_CATEGORIE".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--father_pid="+pid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--root_pid="+rootPid.replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--father_node=tRunJob_1".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "--context=Default".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				    		jvm_argument_helper_tRunJob_1.addArgumentsTo(childJob_commandLine_tRunJob_1, "%*".replaceAll(";",classpathSeparator_tRunJob_1));
				    
				childJob_commandLine_Mapper_tRunJob_1.put("jSOUS_CATEGORIE",childJob_commandLine_tRunJob_1);	
			

 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
		if(childJob_commandLine_Mapper_tRunJob_1.get(((String)globalMap.get("JobName")))==null){
			throw new RuntimeException("The child job named "+((String)globalMap.get("JobName"))+" is not in the job list.");
		}
		paraList_tRunJob_1.addAll(childJob_commandLine_Mapper_tRunJob_1.get(((String)globalMap.get("JobName"))));
	
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + null);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	
		
		context.synchronizeContext();
            class ContextProcessor_tRunJob_1 {
                    private void transmitContext_0() {
                    parentContextMap_tRunJob_1.put("depenseFolder", context.depenseFolder);
                    paraList_tRunJob_1.add("--context_type " + "depenseFolder" + "=" + "id_File");
                    parentContextMap_tRunJob_1.put("dataFolder", context.dataFolder);
                    paraList_tRunJob_1.add("--context_type " + "dataFolder" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("dataJour", context.dataJour);
                    paraList_tRunJob_1.add("--context_type " + "dataJour" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("encodage", context.encodage);
                    paraList_tRunJob_1.add("--context_type " + "encodage" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("fieldSeparator", context.fieldSeparator);
                    paraList_tRunJob_1.add("--context_type " + "fieldSeparator" + "=" + "id_String");
                    parentContextMap_tRunJob_1.put("projectFolder", context.projectFolder);
                    paraList_tRunJob_1.add("--context_type " + "projectFolder" + "=" + "id_Directory");
                        }
                    public void transmitAllContext() {
                        transmitContext_0();
                    }
            }
            new ContextProcessor_tRunJob_1().transmitAllContext();
		java.util.Enumeration<?> propertyNames_tRunJob_1 = context.propertyNames();
		while (propertyNames_tRunJob_1.hasMoreElements()) {
			String key_tRunJob_1 = (String) propertyNames_tRunJob_1.nextElement();
			Object value_tRunJob_1 = (Object) context.get(key_tRunJob_1);
			if(value_tRunJob_1!=null) {  
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + value_tRunJob_1);
			} else {
				paraList_tRunJob_1.add("--context_param " + key_tRunJob_1 + "=" + NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY);
			}
			
		}
		

	Object obj_tRunJob_1 = null;

	
	
				class ConsoleHelper_tRunJob_1 {
					private Thread getNormalThread(Process process) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getInputStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											System.out.println(line);
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_1_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}

					private Thread getErrorThread(Process process, StringBuffer sb) {
						return new Thread() {
							public void run() {
								try {
									java.io.BufferedReader reader = new java.io.BufferedReader(
											new java.io.InputStreamReader(
													process.getErrorStream()));
									String line = "";
									try {
										while ((line = reader.readLine()) != null) {
											sb.append(line)
													.append("\n");
										}
									} finally {
										reader.close();
									}
								} catch (java.io.IOException ioe) {
globalMap.put("tRunJob_1_ERROR_MESSAGE",ioe.getMessage());
						            
									ioe.printStackTrace();
								}
							}
						};
					}
				}
				ConsoleHelper_tRunJob_1 consoleHelper_tRunJob_1 = new ConsoleHelper_tRunJob_1();

		Runtime runtime_tRunJob_1 = Runtime.getRuntime();
		Process ps_tRunJob_1 = null;

		//0 indicates normal termination
        int result_tRunJob_1;
        StringBuffer errorMsg_tRunJob_1 = new StringBuffer();
        try {
            ps_tRunJob_1 = runtime_tRunJob_1.exec((String[])paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));

            Thread normal_tRunJob_1 = consoleHelper_tRunJob_1.getNormalThread(ps_tRunJob_1);
            normal_tRunJob_1.start();

            Thread error_tRunJob_1 = consoleHelper_tRunJob_1.getErrorThread(ps_tRunJob_1, errorMsg_tRunJob_1);
            error_tRunJob_1.start();

            result_tRunJob_1 = ps_tRunJob_1.waitFor();
            normal_tRunJob_1.join();
            error_tRunJob_1.join();
        } catch (ThreadDeath tde) {
globalMap.put("tRunJob_1_ERROR_MESSAGE",tde.getMessage());
            ps_tRunJob_1.destroy();
            throw tde;
        }

		globalMap.put("tRunJob_1_CHILD_RETURN_CODE",result_tRunJob_1);
		if(result_tRunJob_1 != 0){
   			globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE",errorMsg_tRunJob_1.toString());
			
				
				System.err.println("Child job returns " + result_tRunJob_1 + ". It doesn't terminate normally.\n" + errorMsg_tRunJob_1.toString());
			
  		}

		

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */
						if(execStat){
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tRunJob_1);
						}				
					




	
	/**
	 * [tFlowToIterate_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 process_data_end ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_end ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

		}
	  fid_tFixedFlowInput_1.close();
	}

	globalMap.put("tFixedFlowInput_1_NB_LINE", nb_line_tFixedFlowInput_1);

 

ok_Hash.put("tFixedFlowInput_1", true);
end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());




/**
 * [tFixedFlowInput_1 end ] stop
 */

	
	/**
	 * [tFlowToIterate_1 end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

globalMap.put("tFlowToIterate_1_NB_LINE",nb_line_tFlowToIterate_1);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tFlowToIterate_1", true);
end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());




/**
 * [tFlowToIterate_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFixedFlowInput_1 finally ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 finally ] stop
 */

	
	/**
	 * [tFlowToIterate_1 finally ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 finally ] stop
 */

	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final jExtractData jExtractDataClass = new jExtractData();

        int exitCode = jExtractDataClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = jExtractData.class.getClassLoader().getResourceAsStream("idepense_reporting/jextractdata_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = jExtractData.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("depenseFolder", "id_File");
                        if(context.getStringValue("depenseFolder") == null) {
                            context.depenseFolder = null;
                        } else {
                            context.depenseFolder=(String) context.getProperty("depenseFolder");
                        }
                        context.setContextType("dataFolder", "id_String");
                        if(context.getStringValue("dataFolder") == null) {
                            context.dataFolder = null;
                        } else {
                            context.dataFolder=(String) context.getProperty("dataFolder");
                        }
                        context.setContextType("dataJour", "id_String");
                        if(context.getStringValue("dataJour") == null) {
                            context.dataJour = null;
                        } else {
                            context.dataJour=(String) context.getProperty("dataJour");
                        }
                        context.setContextType("encodage", "id_String");
                        if(context.getStringValue("encodage") == null) {
                            context.encodage = null;
                        } else {
                            context.encodage=(String) context.getProperty("encodage");
                        }
                        context.setContextType("fieldSeparator", "id_String");
                        if(context.getStringValue("fieldSeparator") == null) {
                            context.fieldSeparator = null;
                        } else {
                            context.fieldSeparator=(String) context.getProperty("fieldSeparator");
                        }
                        context.setContextType("projectFolder", "id_Directory");
                        if(context.getStringValue("projectFolder") == null) {
                            context.projectFolder = null;
                        } else {
                            context.projectFolder=(String) context.getProperty("projectFolder");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("depenseFolder")) {
                context.depenseFolder = (String) parentContextMap.get("depenseFolder");
            }if (parentContextMap.containsKey("dataFolder")) {
                context.dataFolder = (String) parentContextMap.get("dataFolder");
            }if (parentContextMap.containsKey("dataJour")) {
                context.dataJour = (String) parentContextMap.get("dataJour");
            }if (parentContextMap.containsKey("encodage")) {
                context.encodage = (String) parentContextMap.get("encodage");
            }if (parentContextMap.containsKey("fieldSeparator")) {
                context.fieldSeparator = (String) parentContextMap.get("fieldSeparator");
            }if (parentContextMap.containsKey("projectFolder")) {
                context.projectFolder = (String) parentContextMap.get("projectFolder");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileList_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileList_1) {
globalMap.put("tFileList_1_SUBPROCESS_STATE", -1);

e_tFileList_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : jExtractData");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     89924 characters generated by Talend Open Studio for Data Integration 
 *     on the 16 octobre 2024 à 22:46:31 CEST
 ************************************************************************************************/