
package ec.com.infinityone.consultagarantia;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.com.infinityone.consultagarantia package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.com.infinityone.consultagarantia
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaGarantiaExecute }
     * 
     */
    public ConsultaGarantiaExecute createConsultaGarantiaExecute() {
        return new ConsultaGarantiaExecute();
    }

    /**
     * Create an instance of {@link ConsultaGarantiaExecuteResponse }
     * 
     */
    public ConsultaGarantiaExecuteResponse createConsultaGarantiaExecuteResponse() {
        return new ConsultaGarantiaExecuteResponse();
    }

    /**
     * Create an instance of {@link SDTGarantia }
     * 
     */
    public SDTGarantia createSDTGarantia() {
        return new SDTGarantia();
    }

}
