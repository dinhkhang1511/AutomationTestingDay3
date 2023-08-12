import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.event.TestCaseStarted as TestCaseStarted
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keysa

def rand = new Random()

def store_name = 'storekohetest' + rand.nextInt(1000)

def setNewStoreName(def store_name, def rand) {
	return WebUI.sendKeys(input_store_name, store_name)
}

WebUI.callTestCase(findTestCase('LoginShopify/LoginShopify'), [('input_email') : findTestObject('LoginShopifyPage/input_email')
        , ('input_password') : findTestObject('LoginShopifyPage/input_password'), ('btn_login') : findTestObject('LoginShopifyPage/btn_login')
        , ('a_store1') : findTestObject('LoginShopifyPage/a_account1')], FailureHandling.STOP_ON_FAILURE)



def is_error = true
while (is_error) {
	setNewStoreName(store_name, rand)
	WebUI.delay(5)
	WebUI.click(btn_create_store)
	is_error = WebUI.verifyElementPresent(txt_error_store_url, 10, FailureHandling.OPTIONAL)
}

setStoreNameInGlobalVariable(store_name)

def setStoreNameInGlobalVariable(def name) {
	GlobalVariable.store_name = name
}



