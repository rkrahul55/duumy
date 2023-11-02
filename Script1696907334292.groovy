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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory
//CustomKeywords.'utilities.AccountNavigationUtil.TapOnSelectedAccount'('iSAVvy Savings Account')
Object getAccountName = ExcelFactory.getExcelDataWithDefaultSheet('Data Files/Create_Accounts.xlsx', 'Sheet1', true)

for (int row = 1; row <= getAccountName.getRowNumbers(); row++) {
	Mobile.delay(2)

	println(getAccountName.getRowNumbers())

	 accountToCreate = getAccountName.getValue('Create_account', row)

  
		CustomKeywords.'utilities.AccountNavigationUtil.TapOnSelectedAccount'(accountToCreate)
	
}

CustomKeywords.'utilities.AccountNavigationUtil.NavigateTillPage3ForAccountApplication'()

CustomKeywords.'utilities.AccountNavigationUtil.NavigateTillPage4ForAccountApplication'()

CustomKeywords.'utilities.AccountNavigationUtil.NavigateTillPage5ForAccountApplication'()

CustomKeywords.'utilities.AccountNavigationUtil.NavigateTillPage6ForAccountApplication'()

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_SubmitForm_Page/android.widget.TextView - Submit'), GlobalVariable.G_SmallTimeOut)


Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/One_Time_Password_Page/android.widget.TextView - VerifyText',
		[('Verify') : 'One Time Password']), 'One Time Password')


Object excelData = ExcelFactory.getExcelDataWithDefaultSheet('Data Files/myinfo-test-profiles.xlsx', 'Automation_NTB', true)


println(excelData.getValue('mobileno - prefix', 1))
println(excelData.getValue('mobileno - areacode', 1))
println(excelData.getValue('mobileno - nbr',1))

def mobile_num=excelData.getValue('mobileno - nbr', 1)
println(mobile_num.substring(5, 9))

def extracted_num=mobile_num.substring(5, 9)

String textToVerify='To complete your application, \nplease verify your mobile number. An OTP will be sent to'+" "+excelData.getValue('mobileno - prefix', 1)+excelData.getValue('mobileno - areacode', 1)+" "+" "+'XXXX'+" "+" "+extracted_num+'.'
println (textToVerify)

def actualText=findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/GetText By Index',
		[('i') : 2])
println (actualText)

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/GetText By Index',
		[('i') : 2]), 'To complete your application, \nplease verify your mobile number. An OTP will be sent to'+" "+excelData.getValue('mobileno - prefix', 1)+excelData.getValue('mobileno - areacode', 1)+" "+" "+'XXXX'+" "+" "+extracted_num+'.'+" ",FailureHandling.OPTIONAL)


CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('OTP_Screen1')

//Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_SubmitForm_Page/android.widget.TextView - Confirm'), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	[('Verify') : 'Confirm']), GlobalVariable.G_SmallTimeOut)

//String newTextToVerify='Enter OTP sent to'+" "+excelData.getValue('mobileno - prefix', 1)+excelData.getValue('mobileno - areacode', 1)+" "+" "+" "+'XXXX'+" "+" "+" "+extracted_num
//println (newTextToVerify)
//
//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/GetText By Index',
//		[('i') : 2]), 'newTextToVerify',FailureHandling.OPTIONAL)

Mobile.takeScreenshot()

def otpText=Mobile.getText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView - GetOTP'), GlobalVariable.G_SmallTimeOut, FailureHandling.STOP_ON_FAILURE)
println otpText

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView - ResendOTP_Text'), 'Resend OTP',FailureHandling.OPTIONAL)

CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('OTP_Screen2')

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TickButton'), GlobalVariable.G_SmallTimeOut)

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView -keypad',
	[('Verify') : 'Please enter an OTP that consists of 6 digits.']),'Please enter an OTP that consists of 6 digits.')
Mobile.takeScreenshot()


		Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView -keypad',
				[('Verify') : '1']),GlobalVariable.G_SmallTimeOut )

		Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView -keypad',
				[('Verify') : '2']),GlobalVariable.G_SmallTimeOut )

		Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView -keypad',
				[('Verify') : '3']),GlobalVariable.G_SmallTimeOut )

		Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TickButton'), GlobalVariable.G_SmallTimeOut)
		
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView -keypad',
			[('Verify') : 'Please enter an OTP that consists of 6 digits.']),'Please enter an OTP that consists of 6 digits.')
		
		Mobile.takeScreenshot()
		
		Mobile.waitForElementPresent(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
			[('Verify') : 'Resend OTP']), 150)
		
		Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
			[('Verify') : 'Resend OTP']), GlobalVariable.G_SmallTimeOut)
		
		Mobile.takeScreenshot()
		
		def newOtpText=Mobile.getText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/OTP_Screen/android.widget.TextView - GetOTP'), GlobalVariable.G_SmallTimeOut, FailureHandling.STOP_ON_FAILURE)
		println newOtpText
		
		Mobile.verifyNotMatch(otpText, newOtpText, false)