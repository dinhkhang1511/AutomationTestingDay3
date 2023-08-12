package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object host
     
    /**
     * <p></p>
     */
    public static Object partner_id
     
    /**
     * <p></p>
     */
    public static Object partner_host
     
    /**
     * <p></p>
     */
    public static Object install_app_host
     
    /**
     * <p></p>
     */
    public static Object store_name
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            host = selectedVariables['host']
            partner_id = selectedVariables['partner_id']
            partner_host = selectedVariables['partner_host']
            install_app_host = selectedVariables['install_app_host']
            store_name = selectedVariables['store_name']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
