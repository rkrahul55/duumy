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
//CustomKeywords.'utilities.AccountNavigationUtil.SaveUpAccount'()

//CustomKeywords.'utilities.AccountNavigationUtil.TapOnSelectedAccount'('iSAVvy Savings Account')
Object getAccountName = ExcelFactory.getExcelDataWithDefaultSheet('Data Files/Create_Accounts.xlsx', 'Sheet1', true)
def accountToCreate
for (int row = 1; row <= getAccountName.getRowNumbers(); row++) {
	Mobile.delay(2)

	println(getAccountName.getRowNumbers())

	 accountToCreate = getAccountName.getValue('Create_account', row)

  
		CustomKeywords.'utilities.AccountNavigationUtil.TapOnSelectedAccount'(accountToCreate)
	



'Navigate till Page3 of account applicaiton'
CustomKeywords.'utilities.AccountNavigationUtil.NavigateTillPage3ForAccountApplication'()
//
//Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.BackButton'), 
//   GlobalVariable.G_SmallTimeOut)

'Verify  Page3 text is displayed'
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	   [('Verify') : 'Step 3 of 5']), 'Step 3 of 5')

'Check close button is displayed to user'
Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Close_Button',
	   [('Verify') : 'Step 3 of 5']), GlobalVariable.G_SmallTimeOut)

'Check back button is displayed to user'
Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Back_Button',
	   [('Verify') : 'Step 3 of 5']), GlobalVariable.G_SmallTimeOut)

//'Verify  SaveUp Account text is displayed'
//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
//	   [('Verify') : 'SaveUp Account Application']), 'SaveUp Account Application')

'Verify  Please fill in your account details text is displayed'
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	   [('Verify') : 'Please fill in your account details']), 'Please fill in your account details')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	   [('Verify') : 'Get a Maybank Platinum Debit Card with your new account.']), 'Get a Maybank Platinum Debit Card with your new account.')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	[('Verify') : 'Maybank Platinum Debit Card']), 'Maybank Platinum Debit Card')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	[('Verify') : 'Preferred name on card']), 'Preferred name on card')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	[('Verify') : 'Purpose of account opening']), 'Purpose of account opening')

Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
	[('Verify') : 'Promo / referral code']), 'Promo / referral code')

if(accountToCreate.equals('Ar Rihla Regular Savings Account–i'))
{
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
		[('Verify') : 'Agreed monthly savings amount']), 'Agreed monthly savings amount')
	
	
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD'), '50')
	
	Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD'),'999' ,GlobalVariable.G_SmallTimeOut)
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
		[('Verify') : 'Please input amount between SGD 50 to 1,000 in multiples of 10.']), 'Please input amount between SGD 50 to 1,000 in multiples of 10.')

	
	Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD'),'49' ,GlobalVariable.G_SmallTimeOut)
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
		[('Verify') : 'Please input amount between SGD 50 to 1,000 in multiples of 10.']), 'Please input amount between SGD 50 to 1,000 in multiples of 10.')

	
	Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD'),'1010' ,GlobalVariable.G_SmallTimeOut)
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
		[('Verify') : 'Please input amount between SGD 50 to 1,000 in multiples of 10.']), 'Please input amount between SGD 50 to 1,000 in multiples of 10.')


	Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD'),'63' ,GlobalVariable.G_SmallTimeOut)
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
		[('Verify') : 'Please input amount between SGD 50 to 1,000 in multiples of 10.']), 'Please input amount between SGD 50 to 1,000 in multiples of 10.')

	
	Mobile.clearText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD') ,GlobalVariable.G_SmallTimeOut)
	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Dynamic_Xpaths/android.widget.TextView -Verify_Text',
		[('Verify') : 'Please input amount between SGD 50 to 1,000 in multiples of 10.']), 'Please input amount between SGD 50 to 1,000 in multiples of 10.')

		
	Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Default Value SGD'),'1000' ,GlobalVariable.G_SmallTimeOut)
	
	}

//Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.CloseButton'), 
//    GlobalVariable.G_SmallTimeOut)

//Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - PageNumberLabel'), 
//    GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()
//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get a Maybank Platinum Debit Card with your new account'), 
//    'Get a Maybank Platinum Debit Card with your new account.')

//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Maybank Platinum Debit Card'), 
//    'Maybank Platinum Debit Card')

//'should be as per singpass'
//Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox'), 
//    'Cillain Murphy')
Object excelData = ExcelFactory.getExcelDataWithDefaultSheet('Data Files/myinfo-test-profiles.xlsx', 'Automation_NTB', true)


println(excelData.getValue('name', 1))
Mobile.takeScreenshot()
'Verify name of the user matches from singpass'
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : excelData.getValue('name', 1)]), excelData.getValue('name', 1))

'Verify name cannot be greater then 19 characters'
Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : excelData.getValue('name', 1)]),'ASDFHKJBKKJHMNBVBVNVHGFFHFHGHJFJFJFJFJF' ,GlobalVariable.G_SmallTimeOut)

CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_NameTextBoxValidation1')
Mobile.verifyElementVisible(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.view.ViewGroup'), GlobalVariable.G_SmallTimeOut)

'Verify that name field can accept single character also'
Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : 'ASDFHKJBKKJHMNBVBVN']),'A' ,GlobalVariable.G_SmallTimeOut)

Mobile.takeScreenshot()
'Verify that name field can accept alphanumeric character also'
Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : 'A']), 'ABC123',GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()

CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_NameTextBoxValidation2')

'Verify the error message if alpha numeric and special characters in name field are entered'
Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : 'ABC123']),'a@1.cv$$#', GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()


Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Please input valid Preferred name on card'), 
    'Please input valid Preferred name on card.')
Mobile.takeScreenshot()
CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_NameTextBoxValidation3')

'Verify the error message if nothing is entered in name field'
Mobile.clearText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : 'a@1.cv$$#']), GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Please fill in Preferred name on card'), 
    'Please fill in Preferred name on card.')
Mobile.takeScreenshot()
CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_NameTextBoxValidation4')
'Verify that name field can accept numeric character only'
Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - NameTextBox',
	[('Verify') : 'e.g. Danial Ariff']),'1234', GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Purpose of account opening'), 
    'Purpose of account opening')
Mobile.takeScreenshot()

'Verify default value in drodpwn list is Savings'
Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Text From Account Opening DropDown List'),
	'Savings')

//Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Savings'), GlobalVariable.G_SmallTimeOut)

'Verify that values in dropdown list are as per test data'
List<String> Employement_List = ['Savings', 'Payroll', 'Transactional', 'Loan Repayment', 'Investment']

println(Employement_List.size())

for (int i = 0; i < Employement_List.size(); i++) {
	Mobile.delay(3)
	Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Get Text From Account Opening DropDown List'), GlobalVariable.G_SmallTimeOut)
	Mobile.delay(3)

	Mobile.scrollToText(Employement_List[i])

	Mobile.verifyElementText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - AccountOpeningDropdown',
			[('Verify') : Employement_List[i]]), Employement_List[i])
	
				Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - AccountOpeningDropdown',
				[('Verify') : Employement_List[i]]), 4, FailureHandling.OPTIONAL)
	CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_Employement_List')
	Mobile.takeScreenshot()
	Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Done'), GlobalVariable.G_SmallTimeOut)
}


CustomKeywords.'utilities.Mobile_Keywords.scrollFromTopToBottom'()
Mobile.verifyElementExist(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.TextView - Promo  referral code'), 
    GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()


Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - PromoCodeTextBox',
	[('Verify') : 'Optional']), 'ABCDEFGHIJKLMNOPQRSTUVQWSXTTDSFSDFS',GlobalVariable.G_SmallTimeOut)

CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_NameTextBoxValidation4')

'19 characters validation'
Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - PromoCodeTextBox',
	[('Verify') : 'ABCDEFGHIJKLMNOPQRST']),'AC343BBSDasfgQ240', GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()
CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_PromoCodeTextBoxValidation1')

Mobile.setText(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.EditText - PromoCodeTextBox',
	[('Verify') : 'AC343BBSDasfgQ240']), 'AC@###!`',GlobalVariable.G_SmallTimeOut)
Mobile.takeScreenshot()
CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_PromoCodeTextBoxValidation2')
Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page3/android.widget.BackButton'),
	GlobalVariable.G_SmallTimeOut)
CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7_PromoCodeTextBoxValidation3')
Mobile.tap(findTestObject('Object Repository/MBBB_CASA_STP_SG_MAE/Account_Application_Page2/android.widget.TextView - Next'), GlobalVariable.G_SmallTimeOut)

CustomKeywords.'utilities.Mobile_Keywords.takeScreenshot'('SG_CASA_STP_7')

}
//Mobile.closeApplication()

