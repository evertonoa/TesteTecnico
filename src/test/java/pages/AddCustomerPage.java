package pages;

import core.BasePage;

public class AddCustomerPage extends BasePage{

	public final String FIRST_NAME_TXT_FIELD_XPATH = "//input[@ng-model='fName']";
	public final String LAST_NAME_TXT_FIELD_XPATH = "//input[@ng-model='lName']";
	public final String POST_CODE_TXT_FIELD_XPATH = "//input[@placeholder='Post Code']";
	public final String ADD_CUSTOMER_BUTTON_XPATH = "//button[@class='btn btn-default']";
			
	public AddCustomerPage typeFirstName(String firstName) {
		typeTextIntoField(FIRST_NAME_TXT_FIELD_XPATH, firstName);
		return this;
	}
			
	public AddCustomerPage typeLastName(String lastName) {
		typeTextIntoField(LAST_NAME_TXT_FIELD_XPATH, lastName);
		return this;
	}

	public AddCustomerPage typePostCode(String postCode) {
		typeTextIntoField(POST_CODE_TXT_FIELD_XPATH, postCode);
		return this;
	}

	public AddCustomerPage AddCustomer() {
		clickOnButton(ADD_CUSTOMER_BUTTON_XPATH);
		return this;
	}
	
	public String getAlertSuccessMessage() {
		return getAlertMessage();
	}
	
	
}
