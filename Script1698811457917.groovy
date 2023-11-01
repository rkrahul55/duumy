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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import com.kms.katalon.core.testdata.reader.ExcelFactory as ExcelFactory

Object getAccountName = ExcelFactory.getExcelDataWithDefaultSheet('Data Files/EligibilityCheck.xlsx', 'Sheet1', true)

for (int row = 1; row <= getAccountName.getRowNumbers(); row++) {
    Mobile.delay(2)

    println(getAccountName.getRowNumbers())

    def accountToCreate = getAccountName.getValue('Account_Name', row)

    println(accountToCreate)

    def id = getAccountName.getValue('Id', row)

    println(id)

    def Exceptional_Data_Handling = getAccountName.getValue('Exceptional_Data_Handling', row)

    'Call Test case to launch .\tapk'
    WebUI.callTestCase(findTestCase('CASA_STP_SG_MAE/NavigateToHomeScreen'), [:], FailureHandling.STOP_ON_FAILURE)

    'Tap On More Button From Home Screen'
    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Screens/android.widget.TextView - More'), 
        GlobalVariable.G_SmallTimeOut)

    'Tap on Apply Button'
    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Screens/android.widget.TextView - Apply'), 
        GlobalVariable.G_SmallTimeOut)

    if (accountToCreate.equals('Ar Rihla Regular Savings Account–i')) {
        CustomKeywords.'utilities.Mobile_Keywords.scrollFromTopToBottom'()
    }
    
    'Take Screenshot'
    Mobile.takeScreenshot()

    'Verify that account is visible on screen'
    Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Accounts/android.widget.TextView - TapOnSelectedAccount', 
            [('Verify') : accountToCreate]), GlobalVariable.G_SmallTimeOut)

    'Tapping on Account'
    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Accounts/android.widget.TextView - TapOnSelectedAccount', 
            [('Verify') : accountToCreate]), GlobalVariable.G_SmallTimeOut)

    Mobile.delay(2)

    'Tap on Apply Button'
    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Screens/android.widget.TextView - Apply Now'), 
        GlobalVariable.G_SmallTimeOut)

    'Take Screenshot'
    Mobile.takeScreenshot()

    Mobile.delay(2)

    'Tapping on singpass option'
    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Accounts/android.widget.ImageView'), GlobalVariable.G_SmallTimeOut, 
        FailureHandling.STOP_ON_FAILURE)

    Mobile.delay(2)

    Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/SingPass_Screen/android.widget.EditText - Please enter IC Number'), 
        id, GlobalVariable.G_SmallTimeOut)

    Mobile.delay(2)

    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/SingPass_Screen/android.widget.TextView - Proceed'), 
        GlobalVariable.G_SmallTimeOut)

    if (Exceptional_Data_Handling.equals('FIN, Residential Status = Blank')) {
        Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
                [('Verify') : 'You do not meet the eligibility requirements for this account. Get in touch with us if you need assistance. [109]']), 
            'You do not meet the eligibility requirements for this account. Get in touch with us if you need assistance. [109]')
    } //Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/SingPass_Screen/android.widget.TextView - Proceed'), GlobalVariable.G_SmallTimeOut)
    else if (Exceptional_Data_Handling.equals('Age below 16 years old')) {
        Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
                [('Verify') : 'You do not meet the eligibility requirements for this account. Get in touch with us if you need assistance [110]']), 
            'You do not meet the eligibility requirements for this account. Get in touch with us if you need assistance [110]')
    } else if (Exceptional_Data_Handling.equals('Age below 50 years old')) {
        Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
                [('Verify') : 'You do not meet the eligibility requirements for this account. Get in touch with us if you need assistance [110]']), 
            'You do not meet the eligibility requirements for this account. Get in touch with us if you need assistance [110]')
    } else if (Exceptional_Data_Handling.equals('No data found in myInfo')) {
        Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
                [('Verify') : 'We are unable to obtain your data from Singpass. Please try again after a few minutes. Get in touch with us if you need assistance.']), 
            'We are unable to obtain your data from Singpass. Please try again after a few minutes. Get in touch with us if you need assistance.')
    } 
	else if (Exceptional_Data_Handling.equals('Blank_Principal_Name')) {
        Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
                [('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']), 
            'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
    }
	
	else if (Exceptional_Data_Handling.equals('Blank_Gender')) {
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
				[('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']),
			'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
	}
	
	else if (Exceptional_Data_Handling.equals('Blank_Race')) {
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
				[('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']),
			'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
	}
	
	else if (Exceptional_Data_Handling.equals('Blank_DOB')) {
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
				[('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']),
			'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
	}
	
	
	else if (Exceptional_Data_Handling.equals('Blank_Nationality')) {
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
				[('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']),
			'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
	}
	
	else if (Exceptional_Data_Handling.equals('Blank_Country')) {
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
				[('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']),
			'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
	}
	
	else if (Exceptional_Data_Handling.equals('Blank_Address')) {
		Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
				[('Verify') : 'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.']),
			'We are unable to proceed with the account application as the Myinfo data provided is incomplete. \n\n Please contact +65 6643 0566 or support@myinfo.gov.sg if you require further assistance on the Myinfo registration.')
	}
}

