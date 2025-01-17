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


package idepense_reporting.jcategorie_0_1;

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
 





@SuppressWarnings("unused")

/**
 * Job: jCATEGORIE Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class jCATEGORIE implements TalendJob {

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
	private final String jobName = "jCATEGORIE";
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
				jCATEGORIE.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(jCATEGORIE.this, new Object[] { e , currentComponent, globalMap});
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

			public void tFileInputExcel_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileOutputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileOutputDelimited_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class Liste_DepenseStruct implements routines.system.IPersistableRow<Liste_DepenseStruct> {
    final static byte[] commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];
    static byte[] commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];

	
			    public String NUM_DEPENSE;

				public String getNUM_DEPENSE () {
					return this.NUM_DEPENSE;
				}
				
			    public java.util.Date DT_DEPENSE;

				public java.util.Date getDT_DEPENSE () {
					return this.DT_DEPENSE;
				}
				
			    public String LB_DESCRIPTION_DEPENSE;

				public String getLB_DESCRIPTION_DEPENSE () {
					return this.LB_DESCRIPTION_DEPENSE;
				}
				
			    public String LB_CATEGORIE;

				public String getLB_CATEGORIE () {
					return this.LB_CATEGORIE;
				}
				
			    public String LB_SOUS_CATEGORIE;

				public String getLB_SOUS_CATEGORIE () {
					return this.LB_SOUS_CATEGORIE;
				}
				
			    public Float MT_DEPENSE;

				public Float getMT_DEPENSE () {
					return this.MT_DEPENSE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
					this.DT_DEPENSE = readDate(dis);
					
					this.LB_DESCRIPTION_DEPENSE = readString(dis);
					
					this.LB_CATEGORIE = readString(dis);
					
					this.LB_SOUS_CATEGORIE = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.MT_DEPENSE = null;
           				} else {
           			    	this.MT_DEPENSE = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
					this.DT_DEPENSE = readDate(dis);
					
					this.LB_DESCRIPTION_DEPENSE = readString(dis);
					
					this.LB_CATEGORIE = readString(dis);
					
					this.LB_SOUS_CATEGORIE = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.MT_DEPENSE = null;
           				} else {
           			    	this.MT_DEPENSE = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
					// java.util.Date
				
						writeDate(this.DT_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_DESCRIPTION_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_CATEGORIE,dos);
					
					// String
				
						writeString(this.LB_SOUS_CATEGORIE,dos);
					
					// Float
				
						if(this.MT_DEPENSE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.MT_DEPENSE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
					// java.util.Date
				
						writeDate(this.DT_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_DESCRIPTION_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_CATEGORIE,dos);
					
					// String
				
						writeString(this.LB_SOUS_CATEGORIE,dos);
					
					// Float
				
						if(this.MT_DEPENSE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.MT_DEPENSE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NUM_DEPENSE="+NUM_DEPENSE);
		sb.append(",DT_DEPENSE="+String.valueOf(DT_DEPENSE));
		sb.append(",LB_DESCRIPTION_DEPENSE="+LB_DESCRIPTION_DEPENSE);
		sb.append(",LB_CATEGORIE="+LB_CATEGORIE);
		sb.append(",LB_SOUS_CATEGORIE="+LB_SOUS_CATEGORIE);
		sb.append(",MT_DEPENSE="+String.valueOf(MT_DEPENSE));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Liste_DepenseStruct other) {

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

public static class Liste_Depense_ExporteeStruct implements routines.system.IPersistableRow<Liste_Depense_ExporteeStruct> {
    final static byte[] commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];
    static byte[] commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];

	
			    public String NUM_DEPENSE;

				public String getNUM_DEPENSE () {
					return this.NUM_DEPENSE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NUM_DEPENSE="+NUM_DEPENSE);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(Liste_Depense_ExporteeStruct other) {

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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];
    static byte[] commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];

	
			    public String NUM_DEPENSE;

				public String getNUM_DEPENSE () {
					return this.NUM_DEPENSE;
				}
				
			    public java.util.Date DT_DEPENSE;

				public java.util.Date getDT_DEPENSE () {
					return this.DT_DEPENSE;
				}
				
			    public String LB_DESCRIPTION_DEPENSE;

				public String getLB_DESCRIPTION_DEPENSE () {
					return this.LB_DESCRIPTION_DEPENSE;
				}
				
			    public String LB_CATEGORIE;

				public String getLB_CATEGORIE () {
					return this.LB_CATEGORIE;
				}
				
			    public String LB_SOUS_CATEGORIE;

				public String getLB_SOUS_CATEGORIE () {
					return this.LB_SOUS_CATEGORIE;
				}
				
			    public Float MT_DEPENSE;

				public Float getMT_DEPENSE () {
					return this.MT_DEPENSE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
					this.DT_DEPENSE = readDate(dis);
					
					this.LB_DESCRIPTION_DEPENSE = readString(dis);
					
					this.LB_CATEGORIE = readString(dis);
					
					this.LB_SOUS_CATEGORIE = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.MT_DEPENSE = null;
           				} else {
           			    	this.MT_DEPENSE = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
					this.DT_DEPENSE = readDate(dis);
					
					this.LB_DESCRIPTION_DEPENSE = readString(dis);
					
					this.LB_CATEGORIE = readString(dis);
					
					this.LB_SOUS_CATEGORIE = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.MT_DEPENSE = null;
           				} else {
           			    	this.MT_DEPENSE = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
					// java.util.Date
				
						writeDate(this.DT_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_DESCRIPTION_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_CATEGORIE,dos);
					
					// String
				
						writeString(this.LB_SOUS_CATEGORIE,dos);
					
					// Float
				
						if(this.MT_DEPENSE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.MT_DEPENSE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
					// java.util.Date
				
						writeDate(this.DT_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_DESCRIPTION_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_CATEGORIE,dos);
					
					// String
				
						writeString(this.LB_SOUS_CATEGORIE,dos);
					
					// Float
				
						if(this.MT_DEPENSE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.MT_DEPENSE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NUM_DEPENSE="+NUM_DEPENSE);
		sb.append(",DT_DEPENSE="+String.valueOf(DT_DEPENSE));
		sb.append(",LB_DESCRIPTION_DEPENSE="+LB_DESCRIPTION_DEPENSE);
		sb.append(",LB_CATEGORIE="+LB_CATEGORIE);
		sb.append(",LB_SOUS_CATEGORIE="+LB_SOUS_CATEGORIE);
		sb.append(",MT_DEPENSE="+String.valueOf(MT_DEPENSE));
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

public static class after_tFileInputExcel_1Struct implements routines.system.IPersistableRow<after_tFileInputExcel_1Struct> {
    final static byte[] commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];
    static byte[] commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];

	
			    public String NUM_DEPENSE;

				public String getNUM_DEPENSE () {
					return this.NUM_DEPENSE;
				}
				
			    public java.util.Date DT_DEPENSE;

				public java.util.Date getDT_DEPENSE () {
					return this.DT_DEPENSE;
				}
				
			    public String LB_DESCRIPTION_DEPENSE;

				public String getLB_DESCRIPTION_DEPENSE () {
					return this.LB_DESCRIPTION_DEPENSE;
				}
				
			    public String LB_CATEGORIE;

				public String getLB_CATEGORIE () {
					return this.LB_CATEGORIE;
				}
				
			    public String LB_SOUS_CATEGORIE;

				public String getLB_SOUS_CATEGORIE () {
					return this.LB_SOUS_CATEGORIE;
				}
				
			    public Float MT_DEPENSE;

				public Float getMT_DEPENSE () {
					return this.MT_DEPENSE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
					this.DT_DEPENSE = readDate(dis);
					
					this.LB_DESCRIPTION_DEPENSE = readString(dis);
					
					this.LB_CATEGORIE = readString(dis);
					
					this.LB_SOUS_CATEGORIE = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.MT_DEPENSE = null;
           				} else {
           			    	this.MT_DEPENSE = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
					this.DT_DEPENSE = readDate(dis);
					
					this.LB_DESCRIPTION_DEPENSE = readString(dis);
					
					this.LB_CATEGORIE = readString(dis);
					
					this.LB_SOUS_CATEGORIE = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.MT_DEPENSE = null;
           				} else {
           			    	this.MT_DEPENSE = dis.readFloat();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
					// java.util.Date
				
						writeDate(this.DT_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_DESCRIPTION_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_CATEGORIE,dos);
					
					// String
				
						writeString(this.LB_SOUS_CATEGORIE,dos);
					
					// Float
				
						if(this.MT_DEPENSE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.MT_DEPENSE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
					// java.util.Date
				
						writeDate(this.DT_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_DESCRIPTION_DEPENSE,dos);
					
					// String
				
						writeString(this.LB_CATEGORIE,dos);
					
					// String
				
						writeString(this.LB_SOUS_CATEGORIE,dos);
					
					// Float
				
						if(this.MT_DEPENSE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.MT_DEPENSE);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NUM_DEPENSE="+NUM_DEPENSE);
		sb.append(",DT_DEPENSE="+String.valueOf(DT_DEPENSE));
		sb.append(",LB_DESCRIPTION_DEPENSE="+LB_DESCRIPTION_DEPENSE);
		sb.append(",LB_CATEGORIE="+LB_CATEGORIE);
		sb.append(",LB_SOUS_CATEGORIE="+LB_SOUS_CATEGORIE);
		sb.append(",MT_DEPENSE="+String.valueOf(MT_DEPENSE));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tFileInputExcel_1Struct other) {

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
public void tFileInputExcel_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 0);

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


		tFileInputExcel_2Process(globalMap);

		row1Struct row1 = new row1Struct();
Liste_DepenseStruct Liste_Depense = new Liste_DepenseStruct();
Liste_Depense_ExporteeStruct Liste_Depense_Exportee = new Liste_Depense_ExporteeStruct();





	
	/**
	 * [tFileOutputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileOutputDelimited_1", false);
		start_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileOutputDelimited_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Liste_Depense");
					}
				
		int tos_count_tFileOutputDelimited_1 = 0;
		

String fileName_tFileOutputDelimited_1 = "";
    fileName_tFileOutputDelimited_1 = (new java.io.File(context.projectFolder + context.dataFolder  + " IDEP_DEPENSE.csv")).getAbsolutePath().replace("\\","/");
    String fullName_tFileOutputDelimited_1 = null;
    String extension_tFileOutputDelimited_1 = null;
    String directory_tFileOutputDelimited_1 = null;
    if((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
        if(fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1.lastIndexOf("/")) {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
            extension_tFileOutputDelimited_1 = "";
        } else {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("."));
            extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
        }
        directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("/"));
    } else {
        if(fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(0, fileName_tFileOutputDelimited_1.lastIndexOf("."));
            extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1.substring(fileName_tFileOutputDelimited_1.lastIndexOf("."));
        } else {
            fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
            extension_tFileOutputDelimited_1 = "";
        }
        directory_tFileOutputDelimited_1 = "";
    }
    boolean isFileGenerated_tFileOutputDelimited_1 = true;
    java.io.File filetFileOutputDelimited_1 = new java.io.File(fileName_tFileOutputDelimited_1);
    globalMap.put("tFileOutputDelimited_1_FILE_NAME",fileName_tFileOutputDelimited_1);
        if(filetFileOutputDelimited_1.exists()){
            isFileGenerated_tFileOutputDelimited_1 = false;
        }
            int nb_line_tFileOutputDelimited_1 = 0;
            int splitedFileNo_tFileOutputDelimited_1 = 0;
            int currentRow_tFileOutputDelimited_1 = 0;

            final String OUT_DELIM_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:FIELDSEPARATOR */context.fieldSeparator/** End field tFileOutputDelimited_1:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_tFileOutputDelimited_1 = /** Start field tFileOutputDelimited_1:ROWSEPARATOR */"\n"/** End field tFileOutputDelimited_1:ROWSEPARATOR */;


                        //routines.system.Row
                        java.io.Writer outtFileOutputDelimited_1 = null;

                        outtFileOutputDelimited_1 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_tFileOutputDelimited_1, true),context.encodage));


        resourceMap.put("out_tFileOutputDelimited_1", outtFileOutputDelimited_1);
resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

 



/**
 * [tFileOutputDelimited_1 begin ] stop
 */




	
	/**
	 * [tFileOutputDelimited_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileOutputDelimited_2", false);
		start_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());
		
	
	currentComponent="tFileOutputDelimited_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"Liste_Depense_Exportee");
					}
				
		int tos_count_tFileOutputDelimited_2 = 0;
		

String fileName_tFileOutputDelimited_2 = "";
    fileName_tFileOutputDelimited_2 = (new java.io.File(context.projectFolder + context.dataFolder  + " IDEP_DEPENSE_NUMERO.csv")).getAbsolutePath().replace("\\","/");
    String fullName_tFileOutputDelimited_2 = null;
    String extension_tFileOutputDelimited_2 = null;
    String directory_tFileOutputDelimited_2 = null;
    if((fileName_tFileOutputDelimited_2.indexOf("/") != -1)) {
        if(fileName_tFileOutputDelimited_2.lastIndexOf(".") < fileName_tFileOutputDelimited_2.lastIndexOf("/")) {
            fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
            extension_tFileOutputDelimited_2 = "";
        } else {
            fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0, fileName_tFileOutputDelimited_2.lastIndexOf("."));
            extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
        }
        directory_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0, fileName_tFileOutputDelimited_2.lastIndexOf("/"));
    } else {
        if(fileName_tFileOutputDelimited_2.lastIndexOf(".") != -1) {
            fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(0, fileName_tFileOutputDelimited_2.lastIndexOf("."));
            extension_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2.substring(fileName_tFileOutputDelimited_2.lastIndexOf("."));
        } else {
            fullName_tFileOutputDelimited_2 = fileName_tFileOutputDelimited_2;
            extension_tFileOutputDelimited_2 = "";
        }
        directory_tFileOutputDelimited_2 = "";
    }
    boolean isFileGenerated_tFileOutputDelimited_2 = true;
    java.io.File filetFileOutputDelimited_2 = new java.io.File(fileName_tFileOutputDelimited_2);
    globalMap.put("tFileOutputDelimited_2_FILE_NAME",fileName_tFileOutputDelimited_2);
        if(filetFileOutputDelimited_2.exists()){
            isFileGenerated_tFileOutputDelimited_2 = false;
        }
            int nb_line_tFileOutputDelimited_2 = 0;
            int splitedFileNo_tFileOutputDelimited_2 = 0;
            int currentRow_tFileOutputDelimited_2 = 0;

            final String OUT_DELIM_tFileOutputDelimited_2 = /** Start field tFileOutputDelimited_2:FIELDSEPARATOR */context.fieldSeparator/** End field tFileOutputDelimited_2:FIELDSEPARATOR */;

            final String OUT_DELIM_ROWSEP_tFileOutputDelimited_2 = /** Start field tFileOutputDelimited_2:ROWSEPARATOR */"\n"/** End field tFileOutputDelimited_2:ROWSEPARATOR */;


                        //routines.system.Row
                        java.io.Writer outtFileOutputDelimited_2 = null;

                        outtFileOutputDelimited_2 = new java.io.BufferedWriter(new java.io.OutputStreamWriter(
                        new java.io.FileOutputStream(fileName_tFileOutputDelimited_2, true),context.encodage));


        resourceMap.put("out_tFileOutputDelimited_2", outtFileOutputDelimited_2);
resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

 



/**
 * [tFileOutputDelimited_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
Liste_DepenseStruct Liste_Depense_tmp = new Liste_DepenseStruct();
Liste_Depense_ExporteeStruct Liste_Depense_Exportee_tmp = new Liste_Depense_ExporteeStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFileInputExcel_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_1", false);
		start_Hash.put("tFileInputExcel_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_1";

	
		int tos_count_tFileInputExcel_1 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Fh6sCHU6dx0Z3h4rRmLYXfDYCpKHQn4M/cTEvQ==");
        String password_tFileInputExcel_1 = decryptedPassword_tFileInputExcel_1;
        if (password_tFileInputExcel_1.isEmpty()){
            password_tFileInputExcel_1 = null;
        }
			class RegexUtil_tFileInputExcel_1 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_1 regexUtil_tFileInputExcel_1 = new RegexUtil_tFileInputExcel_1();

		Object source_tFileInputExcel_1 = context.depenseFolder;
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_1 = null;

		if(source_tFileInputExcel_1 instanceof String){
			workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_1), password_tFileInputExcel_1, true);
		} else if(source_tFileInputExcel_1 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_1 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_1, password_tFileInputExcel_1);
		} else{
			workbook_tFileInputExcel_1 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
        sheetList_tFileInputExcel_1.addAll(regexUtil_tFileInputExcel_1.getSheets(workbook_tFileInputExcel_1, "DEPENSE", false));
    	if(sheetList_tFileInputExcel_1.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_1 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_1 : sheetList_tFileInputExcel_1) {
			if(sheet_FilterNull_tFileInputExcel_1!=null && sheetList_FilterNull_tFileInputExcel_1.iterator()!=null && sheet_FilterNull_tFileInputExcel_1.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_1.add(sheet_FilterNull_tFileInputExcel_1);
			}
		}
		sheetList_tFileInputExcel_1 = sheetList_FilterNull_tFileInputExcel_1;
	if(sheetList_tFileInputExcel_1.size()>0){
		int nb_line_tFileInputExcel_1 = 0;

        int begin_line_tFileInputExcel_1 = 3;

        int footer_input_tFileInputExcel_1 = 0;

        int end_line_tFileInputExcel_1=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1:sheetList_tFileInputExcel_1){
			end_line_tFileInputExcel_1+=(sheet_tFileInputExcel_1.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_1 -= footer_input_tFileInputExcel_1;
        int limit_tFileInputExcel_1 = -1;
        int start_column_tFileInputExcel_1 = 2-1;
        int end_column_tFileInputExcel_1 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_1 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(0);
        int rowCount_tFileInputExcel_1 = 0;
        int sheetIndex_tFileInputExcel_1 = 0;
        int currentRows_tFileInputExcel_1 = (sheetList_tFileInputExcel_1.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_1 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_1 = df_tFileInputExcel_1.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_1 = begin_line_tFileInputExcel_1; i_tFileInputExcel_1 < end_line_tFileInputExcel_1; i_tFileInputExcel_1++){

        	int emptyColumnCount_tFileInputExcel_1 = 0;

        	if (limit_tFileInputExcel_1 != -1 && nb_line_tFileInputExcel_1 >= limit_tFileInputExcel_1) {
        		break;
        	}

            while (i_tFileInputExcel_1 >= rowCount_tFileInputExcel_1 + currentRows_tFileInputExcel_1) {
                rowCount_tFileInputExcel_1 += currentRows_tFileInputExcel_1;
                sheet_tFileInputExcel_1 = sheetList_tFileInputExcel_1.get(++sheetIndex_tFileInputExcel_1);
                currentRows_tFileInputExcel_1 = (sheet_tFileInputExcel_1.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_1_CURRENT_SHEET",sheet_tFileInputExcel_1.getSheetName());
            if (rowCount_tFileInputExcel_1 <= i_tFileInputExcel_1) {
                row_tFileInputExcel_1 = sheet_tFileInputExcel_1.getRow(i_tFileInputExcel_1 - rowCount_tFileInputExcel_1);
            }
		    row1 = null;
					int tempRowLength_tFileInputExcel_1 = 6;
				
				int columnIndex_tFileInputExcel_1 = 0;
			
			String[] temp_row_tFileInputExcel_1 = new String[tempRowLength_tFileInputExcel_1];
			int excel_end_column_tFileInputExcel_1;
			if(row_tFileInputExcel_1==null){
				excel_end_column_tFileInputExcel_1=0;
			}else{
				excel_end_column_tFileInputExcel_1=row_tFileInputExcel_1.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_1;
			if(end_column_tFileInputExcel_1 == -1){
				actual_end_column_tFileInputExcel_1 = excel_end_column_tFileInputExcel_1;
			}
			else{
				actual_end_column_tFileInputExcel_1 = end_column_tFileInputExcel_1 >	excel_end_column_tFileInputExcel_1 ? excel_end_column_tFileInputExcel_1 : end_column_tFileInputExcel_1;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_1 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_1;i++){
				if(i + start_column_tFileInputExcel_1 < actual_end_column_tFileInputExcel_1){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_1 = row_tFileInputExcel_1.getCell(i + start_column_tFileInputExcel_1);
					if(cell_tFileInputExcel_1!=null){
					switch (cell_tFileInputExcel_1.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_1)) {
									temp_row_tFileInputExcel_1[i] =cell_tFileInputExcel_1.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_1[i] = df_tFileInputExcel_1.format(cell_tFileInputExcel_1.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_1[i] =String.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_1.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_1[i] = cell_tFileInputExcel_1.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_1)) {
											temp_row_tFileInputExcel_1[i] =cell_tFileInputExcel_1.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_1 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_1.getNumericCellValue());
										temp_row_tFileInputExcel_1[i] = ne_tFileInputExcel_1.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_1[i] =String.valueOf(cell_tFileInputExcel_1.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_1[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_1[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_1[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_1[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_1 = false;
			row1 = new row1Struct();
			int curColNum_tFileInputExcel_1 = -1;
			String curColName_tFileInputExcel_1 = "";
			try{
							columnIndex_tFileInputExcel_1 = 0;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "NUM_DEPENSE";

				row1.NUM_DEPENSE = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				row1.NUM_DEPENSE = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 1;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "DT_DEPENSE";

				if(1<actual_end_column_tFileInputExcel_1){
					try{
						if(row_tFileInputExcel_1.getCell(columnIndex_tFileInputExcel_1+ start_column_tFileInputExcel_1).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_tFileInputExcel_1.getCell(columnIndex_tFileInputExcel_1+ start_column_tFileInputExcel_1))){
							row1.DT_DEPENSE = row_tFileInputExcel_1.getCell(columnIndex_tFileInputExcel_1+ start_column_tFileInputExcel_1).getDateCellValue();
						}
						else{
                            java.util.Date tempDate_tFileInputExcel_1 = ParserUtils.parseTo_Date(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], "dd/MM/yyyy");
                            if(tempDate_tFileInputExcel_1.after((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS")).parse("9999/12/31 23:59:59.999"))||tempDate_tFileInputExcel_1.before((new SimpleDateFormat("yyyy/MM/dd")).parse("1900/01/01"))){
                                throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
                            }else{
                                row1.DT_DEPENSE = tempDate_tFileInputExcel_1;
                            }
						}
					}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
						
						throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_1+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_1 + " )");
					}
				}

			}else{
				row1.DT_DEPENSE = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 2;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "LB_DESCRIPTION_DEPENSE";

				row1.LB_DESCRIPTION_DEPENSE = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				row1.LB_DESCRIPTION_DEPENSE = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 3;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "LB_CATEGORIE";

				row1.LB_CATEGORIE = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				row1.LB_CATEGORIE = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 4;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "LB_SOUS_CATEGORIE";

				row1.LB_SOUS_CATEGORIE = temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1];
			}else{
				row1.LB_SOUS_CATEGORIE = null;
				emptyColumnCount_tFileInputExcel_1++;
			}
							columnIndex_tFileInputExcel_1 = 5;
						
			if( temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1].length() > 0) {
				curColNum_tFileInputExcel_1=columnIndex_tFileInputExcel_1 + start_column_tFileInputExcel_1 + 1;
				curColName_tFileInputExcel_1 = "MT_DEPENSE";

				row1.MT_DEPENSE = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_1[columnIndex_tFileInputExcel_1], null, '.'==decimalChar_tFileInputExcel_1 ? null : decimalChar_tFileInputExcel_1));
			}else{
				row1.MT_DEPENSE = null;
				emptyColumnCount_tFileInputExcel_1++;
			}

				nb_line_tFileInputExcel_1++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_1_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_1 = true;
					 System.err.println(e.getMessage());
					 row1 = null;
			}


		



 



/**
 * [tFileInputExcel_1 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 


	tos_count_tFileInputExcel_1++;

/**
 * [tFileInputExcel_1 main ] stop
 */
	
	/**
	 * [tFileInputExcel_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.NUM_DEPENSE = row1.NUM_DEPENSE ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.NUM_DEPENSE = '" + row2HashKey.NUM_DEPENSE + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

Liste_Depense = null;
Liste_Depense_Exportee = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'Liste_Depense'
Liste_Depense_tmp.NUM_DEPENSE = row1.NUM_DEPENSE ;
Liste_Depense_tmp.DT_DEPENSE = row1.DT_DEPENSE ;
Liste_Depense_tmp.LB_DESCRIPTION_DEPENSE = row1.LB_DESCRIPTION_DEPENSE ;
Liste_Depense_tmp.LB_CATEGORIE = row1.LB_CATEGORIE ;
Liste_Depense_tmp.LB_SOUS_CATEGORIE = row1.LB_SOUS_CATEGORIE ;
Liste_Depense_tmp.MT_DEPENSE = row1.MT_DEPENSE ;
Liste_Depense = Liste_Depense_tmp;

// # Output table : 'Liste_Depense_Exportee'
Liste_Depense_Exportee_tmp.NUM_DEPENSE = row1.NUM_DEPENSE ;
Liste_Depense_Exportee = Liste_Depense_Exportee_tmp;
}  // closing inner join bracket (2)
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "Liste_Depense"
if(Liste_Depense != null) { 



	
	/**
	 * [tFileOutputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Liste_Depense"
						
						);
					}
					


                    StringBuilder sb_tFileOutputDelimited_1 = new StringBuilder();
                            if(Liste_Depense.NUM_DEPENSE != null) {
                        sb_tFileOutputDelimited_1.append(
                            Liste_Depense.NUM_DEPENSE
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(Liste_Depense.DT_DEPENSE != null) {
                        sb_tFileOutputDelimited_1.append(
                            FormatterUtils.format_Date(Liste_Depense.DT_DEPENSE, "dd/MM/yyyy")
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(Liste_Depense.LB_DESCRIPTION_DEPENSE != null) {
                        sb_tFileOutputDelimited_1.append(
                            Liste_Depense.LB_DESCRIPTION_DEPENSE
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(Liste_Depense.LB_CATEGORIE != null) {
                        sb_tFileOutputDelimited_1.append(
                            Liste_Depense.LB_CATEGORIE
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(Liste_Depense.LB_SOUS_CATEGORIE != null) {
                        sb_tFileOutputDelimited_1.append(
                            Liste_Depense.LB_SOUS_CATEGORIE
                        );
                            }
                            sb_tFileOutputDelimited_1.append(OUT_DELIM_tFileOutputDelimited_1);
                            if(Liste_Depense.MT_DEPENSE != null) {
                        sb_tFileOutputDelimited_1.append(
                            Liste_Depense.MT_DEPENSE
                        );
                            }
                    sb_tFileOutputDelimited_1.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);


                    nb_line_tFileOutputDelimited_1++;
                    resourceMap.put("nb_line_tFileOutputDelimited_1", nb_line_tFileOutputDelimited_1);

                        outtFileOutputDelimited_1.write(sb_tFileOutputDelimited_1.toString());




 


	tos_count_tFileOutputDelimited_1++;

/**
 * [tFileOutputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileOutputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

 



/**
 * [tFileOutputDelimited_1 process_data_begin ] stop
 */
	
	/**
	 * [tFileOutputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	

 



/**
 * [tFileOutputDelimited_1 process_data_end ] stop
 */

} // End of branch "Liste_Depense"




// Start of branch "Liste_Depense_Exportee"
if(Liste_Depense_Exportee != null) { 



	
	/**
	 * [tFileOutputDelimited_2 main ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"Liste_Depense_Exportee"
						
						);
					}
					


                    StringBuilder sb_tFileOutputDelimited_2 = new StringBuilder();
                            if(Liste_Depense_Exportee.NUM_DEPENSE != null) {
                        sb_tFileOutputDelimited_2.append(
                            Liste_Depense_Exportee.NUM_DEPENSE
                        );
                            }
                    sb_tFileOutputDelimited_2.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_2);


                    nb_line_tFileOutputDelimited_2++;
                    resourceMap.put("nb_line_tFileOutputDelimited_2", nb_line_tFileOutputDelimited_2);

                        outtFileOutputDelimited_2.write(sb_tFileOutputDelimited_2.toString());




 


	tos_count_tFileOutputDelimited_2++;

/**
 * [tFileOutputDelimited_2 main ] stop
 */
	
	/**
	 * [tFileOutputDelimited_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_2";

	

 



/**
 * [tFileOutputDelimited_2 process_data_begin ] stop
 */
	
	/**
	 * [tFileOutputDelimited_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_2";

	

 



/**
 * [tFileOutputDelimited_2 process_data_end ] stop
 */

} // End of branch "Liste_Depense_Exportee"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputExcel_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_1_NB_LINE",nb_line_tFileInputExcel_1);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_1 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_1.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_1", true);
end_Hash.put("tFileInputExcel_1", System.currentTimeMillis());




/**
 * [tFileInputExcel_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	



		
			
					if(outtFileOutputDelimited_1!=null) {
						outtFileOutputDelimited_1.flush();
						outtFileOutputDelimited_1.close();
					}
				
				globalMap.put("tFileOutputDelimited_1_NB_LINE",nb_line_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME",fileName_tFileOutputDelimited_1);
			
		
		
		resourceMap.put("finish_tFileOutputDelimited_1", true);
	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Liste_Depense");
			  	}
			  	
 

ok_Hash.put("tFileOutputDelimited_1", true);
end_Hash.put("tFileOutputDelimited_1", System.currentTimeMillis());




/**
 * [tFileOutputDelimited_1 end ] stop
 */




	
	/**
	 * [tFileOutputDelimited_2 end ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_2";

	



		
			
					if(outtFileOutputDelimited_2!=null) {
						outtFileOutputDelimited_2.flush();
						outtFileOutputDelimited_2.close();
					}
				
				globalMap.put("tFileOutputDelimited_2_NB_LINE",nb_line_tFileOutputDelimited_2);
				globalMap.put("tFileOutputDelimited_2_FILE_NAME",fileName_tFileOutputDelimited_2);
			
		
		
		resourceMap.put("finish_tFileOutputDelimited_2", true);
	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"Liste_Depense_Exportee");
			  	}
			  	
 

ok_Hash.put("tFileOutputDelimited_2", true);
end_Hash.put("tFileOutputDelimited_2", System.currentTimeMillis());




/**
 * [tFileOutputDelimited_2 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tFileInputExcel_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_1";

	

 



/**
 * [tFileInputExcel_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tFileOutputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_1";

	


		if(resourceMap.get("finish_tFileOutputDelimited_1") == null){ 
			
				
						java.io.Writer outtFileOutputDelimited_1 = (java.io.Writer)resourceMap.get("out_tFileOutputDelimited_1");
						if(outtFileOutputDelimited_1!=null) {
							outtFileOutputDelimited_1.flush();
							outtFileOutputDelimited_1.close();
						}
					
				
			
		}
	

 



/**
 * [tFileOutputDelimited_1 finally ] stop
 */




	
	/**
	 * [tFileOutputDelimited_2 finally ] start
	 */

	

	
	
	currentComponent="tFileOutputDelimited_2";

	


		if(resourceMap.get("finish_tFileOutputDelimited_2") == null){ 
			
				
						java.io.Writer outtFileOutputDelimited_2 = (java.io.Writer)resourceMap.get("out_tFileOutputDelimited_2");
						if(outtFileOutputDelimited_2!=null) {
							outtFileOutputDelimited_2.flush();
							outtFileOutputDelimited_2.close();
						}
					
				
			
		}
	

 



/**
 * [tFileOutputDelimited_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];
    static byte[] commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String NUM_DEPENSE;

				public String getNUM_DEPENSE () {
					return this.NUM_DEPENSE;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.NUM_DEPENSE == null) ? 0 : this.NUM_DEPENSE.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.NUM_DEPENSE == null) {
							if (other.NUM_DEPENSE != null)
								return false;
						
						} else if (!this.NUM_DEPENSE.equals(other.NUM_DEPENSE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.NUM_DEPENSE = this.NUM_DEPENSE;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.NUM_DEPENSE = this.NUM_DEPENSE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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
			if(length > commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length) {
				if(length < 1024 && commonByteArray_IDEPENSE_REPORTING_jCATEGORIE.length == 0) {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[1024];
				} else {
   					commonByteArray_IDEPENSE_REPORTING_jCATEGORIE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length);
			strReturn = new String(commonByteArray_IDEPENSE_REPORTING_jCATEGORIE, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_IDEPENSE_REPORTING_jCATEGORIE) {

        	try {

        		int length = 0;
		
					this.NUM_DEPENSE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.NUM_DEPENSE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		

		

        }

		
        	finally {}

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		

		

        }

		
        	finally {}

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
        	}
        	finally {}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
        	}
        	finally {}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("NUM_DEPENSE="+NUM_DEPENSE);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.NUM_DEPENSE, other.NUM_DEPENSE);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
public void tFileInputExcel_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", 0);

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



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tFileInputExcel_2 - inputs:(after_tFileInputExcel_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2) outputs:(Liste_Depense,Liste_Depense_Exportee)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tFileInputExcel_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_2", false);
		start_Hash.put("tFileInputExcel_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_2";

	
		int tos_count_tFileInputExcel_2 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:u3AFSFnNC6crXMEMRMsZiYkX2RfproTGiG2YFw==");
        String password_tFileInputExcel_2 = decryptedPassword_tFileInputExcel_2;
        if (password_tFileInputExcel_2.isEmpty()){
            password_tFileInputExcel_2 = null;
        }
			class RegexUtil_tFileInputExcel_2 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_2 regexUtil_tFileInputExcel_2 = new RegexUtil_tFileInputExcel_2();

		Object source_tFileInputExcel_2 = context.depenseFolder;
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_2 = null;

		if(source_tFileInputExcel_2 instanceof String){
			workbook_tFileInputExcel_2 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_2), password_tFileInputExcel_2, true);
		} else if(source_tFileInputExcel_2 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_2 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_2, password_tFileInputExcel_2);
		} else{
			workbook_tFileInputExcel_2 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_2 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
        sheetList_tFileInputExcel_2.addAll(regexUtil_tFileInputExcel_2.getSheets(workbook_tFileInputExcel_2, "DEPENSE_EXPORTEE", false));
    	if(sheetList_tFileInputExcel_2.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_2 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_2 : sheetList_tFileInputExcel_2) {
			if(sheet_FilterNull_tFileInputExcel_2!=null && sheetList_FilterNull_tFileInputExcel_2.iterator()!=null && sheet_FilterNull_tFileInputExcel_2.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_2.add(sheet_FilterNull_tFileInputExcel_2);
			}
		}
		sheetList_tFileInputExcel_2 = sheetList_FilterNull_tFileInputExcel_2;
	if(sheetList_tFileInputExcel_2.size()>0){
		int nb_line_tFileInputExcel_2 = 0;

        int begin_line_tFileInputExcel_2 = 3;

        int footer_input_tFileInputExcel_2 = 0;

        int end_line_tFileInputExcel_2=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_2:sheetList_tFileInputExcel_2){
			end_line_tFileInputExcel_2+=(sheet_tFileInputExcel_2.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_2 -= footer_input_tFileInputExcel_2;
        int limit_tFileInputExcel_2 = -1;
        int start_column_tFileInputExcel_2 = 2-1;
        int end_column_tFileInputExcel_2 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_2 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_2 = sheetList_tFileInputExcel_2.get(0);
        int rowCount_tFileInputExcel_2 = 0;
        int sheetIndex_tFileInputExcel_2 = 0;
        int currentRows_tFileInputExcel_2 = (sheetList_tFileInputExcel_2.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_2 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_2 = df_tFileInputExcel_2.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_2 = begin_line_tFileInputExcel_2; i_tFileInputExcel_2 < end_line_tFileInputExcel_2; i_tFileInputExcel_2++){

        	int emptyColumnCount_tFileInputExcel_2 = 0;

        	if (limit_tFileInputExcel_2 != -1 && nb_line_tFileInputExcel_2 >= limit_tFileInputExcel_2) {
        		break;
        	}

            while (i_tFileInputExcel_2 >= rowCount_tFileInputExcel_2 + currentRows_tFileInputExcel_2) {
                rowCount_tFileInputExcel_2 += currentRows_tFileInputExcel_2;
                sheet_tFileInputExcel_2 = sheetList_tFileInputExcel_2.get(++sheetIndex_tFileInputExcel_2);
                currentRows_tFileInputExcel_2 = (sheet_tFileInputExcel_2.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_2_CURRENT_SHEET",sheet_tFileInputExcel_2.getSheetName());
            if (rowCount_tFileInputExcel_2 <= i_tFileInputExcel_2) {
                row_tFileInputExcel_2 = sheet_tFileInputExcel_2.getRow(i_tFileInputExcel_2 - rowCount_tFileInputExcel_2);
            }
		    row2 = null;
		    row2 = null;
					int tempRowLength_tFileInputExcel_2 = 1;
				
				int columnIndex_tFileInputExcel_2 = 0;
			
			String[] temp_row_tFileInputExcel_2 = new String[tempRowLength_tFileInputExcel_2];
			int excel_end_column_tFileInputExcel_2;
			if(row_tFileInputExcel_2==null){
				excel_end_column_tFileInputExcel_2=0;
			}else{
				excel_end_column_tFileInputExcel_2=row_tFileInputExcel_2.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_2;
			if(end_column_tFileInputExcel_2 == -1){
				actual_end_column_tFileInputExcel_2 = excel_end_column_tFileInputExcel_2;
			}
			else{
				actual_end_column_tFileInputExcel_2 = end_column_tFileInputExcel_2 >	excel_end_column_tFileInputExcel_2 ? excel_end_column_tFileInputExcel_2 : end_column_tFileInputExcel_2;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_2 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_2;i++){
				if(i + start_column_tFileInputExcel_2 < actual_end_column_tFileInputExcel_2){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_2 = row_tFileInputExcel_2.getCell(i + start_column_tFileInputExcel_2);
					if(cell_tFileInputExcel_2!=null){
					switch (cell_tFileInputExcel_2.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_2[i] = cell_tFileInputExcel_2.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_2)) {
									temp_row_tFileInputExcel_2[i] =cell_tFileInputExcel_2.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_2[i] = df_tFileInputExcel_2.format(cell_tFileInputExcel_2.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_2[i] =String.valueOf(cell_tFileInputExcel_2.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_2.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_2[i] = cell_tFileInputExcel_2.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_2)) {
											temp_row_tFileInputExcel_2[i] =cell_tFileInputExcel_2.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_2 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_2.getNumericCellValue());
										temp_row_tFileInputExcel_2[i] = ne_tFileInputExcel_2.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_2[i] =String.valueOf(cell_tFileInputExcel_2.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_2[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_2[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_2[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_2[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_2 = false;
			row2 = new row2Struct();
			int curColNum_tFileInputExcel_2 = -1;
			String curColName_tFileInputExcel_2 = "";
			try{
							columnIndex_tFileInputExcel_2 = 0;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "NUM_DEPENSE";

				row2.NUM_DEPENSE = temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2];
			}else{
				row2.NUM_DEPENSE = null;
				emptyColumnCount_tFileInputExcel_2++;
			}

				nb_line_tFileInputExcel_2++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_2_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_2 = true;
					 System.err.println(e.getMessage());
					 row2 = null;
			}


		



 



/**
 * [tFileInputExcel_2 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 


	tos_count_tFileInputExcel_2++;

/**
 * [tFileInputExcel_2 main ] stop
 */
	
	/**
	 * [tFileInputExcel_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.NUM_DEPENSE = row2.NUM_DEPENSE;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */

} // End of branch "row2"




	
	/**
	 * [tFileInputExcel_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_2_NB_LINE",nb_line_tFileInputExcel_2);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_2 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_2.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_2", true);
end_Hash.put("tFileInputExcel_2", System.currentTimeMillis());




/**
 * [tFileInputExcel_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
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
	 * [tFileInputExcel_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", 1);
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
        final jCATEGORIE jCATEGORIEClass = new jCATEGORIE();

        int exitCode = jCATEGORIEClass.runJobInTOS(args);

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
            java.io.InputStream inContext = jCATEGORIE.class.getClassLoader().getResourceAsStream("idepense_reporting/jcategorie_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = jCATEGORIE.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileInputExcel_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputExcel_1) {
globalMap.put("tFileInputExcel_1_SUBPROCESS_STATE", -1);

e_tFileInputExcel_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : jCATEGORIE");
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
 *     126969 characters generated by Talend Open Studio for Data Integration 
 *     on the 16 octobre 2024 à 22:46:30 CEST
 ************************************************************************************************/