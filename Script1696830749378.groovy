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

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Marketing Consent']), 'Marketing Consent')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'I consent to Maybank contacting me about products and services.']), 'I consent to Maybank contacting me about products and services.')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Post']), 'Post')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Email']), 'Email')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'SMS / Other messaging services']), 'SMS / Other messaging services')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Advisory from Singapore Police Force - Warning']), 'Advisory from Singapore Police Force - Warning')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Declaration']), 'Declaration')

Mobile.takeScreenshot()

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'I have read, understood and agree to the ']), 'I have read, understood and agree to the ')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Individual Tax Residency Self-Certification Form Instruction.']), 'Individual Tax Residency Self-Certification Form Instruction.')

CustomKeywords.'utilities.Mobile_Keywords.scrollFromTopToBottom'()

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Terms and Conditions']), 'Terms and Conditions')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Deposit Insurance Scheme']), 'Deposit Insurance Scheme')

Mobile.takeScreenshot()

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'I am the beneficial owner of the account to be opened under this application.']), 'I am the beneficial owner of the account to be opened under this application.')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'I declare that I am neither a United States (U.S.) Citizen nor hold a U.S. Permanent Resident Green Card nor am I a U.S. resident and agree to the FATCA Declaration.']), 
    'I declare that I am neither a United States (U.S.) Citizen nor hold a U.S. Permanent Resident Green Card nor am I a U.S. resident and agree to the FATCA Declaration.')

CustomKeywords.'utilities.Mobile_Keywords.scrollFromBottomToTop'()

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Post']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Email']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'SMS / Other messaging services']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Phone Call']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'SMS / Other messaging services']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Phone Call']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Post']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'Email']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText', 
        [('Verify') : 'I have read and agree to the Advisory from Singapore Police Force.']), GlobalVariable.G_SmallTimeOut)

Mobile.takeScreenshot()

Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - Advisory from Singapore Police Force'), 
    GlobalVariable.G_SmallTimeOut)

Mobile.delay(2)

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'WARNING']), 'WARNING')

//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',[('Verify') : 'Your bank account should be for your own use and you are responsible for all transaction made through your bank account. ']),'Your bank account should be for your own use and you are responsible for all transaction made through your bank account. ')
//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',[('Verify') : 'You may be facilitating criminal activities such as money laundering and/or unlicensed money lending if you:']),'You may be facilitating criminal activities such as money laundering and/or unlicensed money lending if you:')
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'Your bank account should be for \nyour own use and you are \nresponsible for all transaction \nmade through your bank account. ']), 
    'Your bank account should be for \nyour own use and you are \nresponsible for all transaction \nmade through your bank account. ')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'You may be facilitating criminal activities such as money \nlaundering and/or unlicensed \nmoney lending if you:']), 
    'You may be facilitating criminal activities such as money \nlaundering and/or unlicensed \nmoney lending if you:')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'knowingly allow other people to \noperate, access and/or control of \nyour bank account; and/or']), 
    'knowingly allow other people to \noperate, access and/or control of \nyour bank account; and/or')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'knowingly receive money from \nstrangers, dubious sources, or \nother unverified sources.']), 'knowingly receive money from \nstrangers, dubious sources, or \nother unverified sources.')

CustomKeywords.'utilities.Mobile_Keywords.scrollFromTopToBottom'()

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'You can be prosecuted for the \nrelevant offences if your bank \naccount is used to receive or \ntransfer money linked to criminals \nactivities. These offences carry a \npunishment of a fine and/or \nimprisonment.']), 
    'You can be prosecuted for the \nrelevant offences if your bank \naccount is used to receive or \ntransfer money linked to criminals \nactivities. These offences carry a \npunishment of a fine and/or \nimprisonment.')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'You should make the necessary application to your bank if you \nwish to authorise the operation, \naccess and/or control of your bank \naccount to a third party. A failure to \ndo so would subject your bank \naccount to additional risk \nmitigation measures and, in some \ncases, your bank may terminate or \nrestrict your use of your bank \naccount and other related \naccounts you may have with your \nbank.']), 
    'You should make the necessary application to your bank if you \nwish to authorise the operation, \naccess and/or control of your bank \naccount to a third party. A failure to \ndo so would subject your bank \naccount to additional risk \nmitigation measures and, in some \ncases, your bank may terminate or \nrestrict your use of your bank \naccount and other related \naccounts you may have with your \nbank.')

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.view.ViewGroup'), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'Individual Tax Residency Self-Certification Form Instruction.']), GlobalVariable.G_SmallTimeOut)

Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
        [('Verify') : 'Continue']), GlobalVariable.G_SmallTimeOut)

'Verify values in drodown list as per test data'
List<String> termsAndConditions = ['Terms and Conditions of \nAccess', 'Terms and Conditions of \nInternet Banking Services'
    , 'Terms and Conditions of \nIntegrated Maybank2u \nServices', 'Personal Data Protection Act \n(PDPA) and Marketing \nConsent'
    , 'Terms and Conditions of \nAccount Opening on Remote Channels', 'Terms and Conditions \nGoverning Savings Accounts']

println(termsAndConditions.size())

for (int i = 0; i < termsAndConditions.size(); i++) {
    Mobile.delay(2)

    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
            [('Verify') : 'Terms and Conditions']), GlobalVariable.G_SmallTimeOut)

    Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
            [('Verify') : termsAndConditions[i]]), GlobalVariable.G_SmallTimeOut)

    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text', 
            [('Verify') : termsAndConditions[i]]), GlobalVariable.G_SmallTimeOut)

    Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Back_Button1', 
            [('Verify') : termsAndConditions[i]]), GlobalVariable.G_SmallTimeOut)
}


Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page5/android.widget.TextView - VerifyText',
	[('Verify') : 'Deposit Insurance Scheme']), GlobalVariable.G_SmallTimeOut)


Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Back_Button1',
		[('Verify') : 'Deposit Insurance Scheme']), GlobalVariable.G_SmallTimeOut)

