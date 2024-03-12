package com.qa.steps.ui;

import com.qa.pages.ui.PatientManagementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.internal.RequestSpecificationImpl;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.thread.IThreadWorkerFactory;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class dataentryOperatorsteps extends PatientManagementPage {
    PatientManagementPage p = new PatientManagementPage();

    @Given("User click on {string} button")
    public void userClickOnButton(String value) {
        new PatientManagementPage().ClickAddButton(value);
    }


    @Then("User should Select a country code and give MobileNumber")
    public void user_should_select_a_country_code_and_give_mobile_number() {

        new PatientManagementPage().ClickCountryCode();
    }

    @When("User should pass {string},{string},{string},{string},{string} field")
    public void userShouldPassField(String arg0, String arg1, String arg2, String arg3, String arg4) {
        new PatientManagementPage().MobileNumberField(arg0).ArabicField(arg1, arg2, arg3, arg4);
    }


    @When("User should pass {string},{string},{string},{string},{string}")
    public void userShouldPass(String arg0, String arg1, String arg2, String arg3, String arg4) throws InterruptedException {
        new PatientManagementPage().EnglishField(arg0, arg1, arg2, arg3, arg4);

    }

    @When("User should pass other basic details {string},{string},{string}, {string},{string}, {string}")
    public void userShouldPassOtherBasicDetails(String NationalId, String AlternateMobileNumber, String Street, String Area, String City, String Pincode) throws AWTException, InterruptedException {
        new PatientManagementPage().PatientDetailsPage(NationalId, AlternateMobileNumber, Street, Area, City, Pincode);

    }

    @Given("User is on the MOH Add patient Page")
    public void userIsOnTheMOHAddPatientPage() {
    }

    @Then("Uer should click continue button")
    public void uerShouldClickContinueButton() {
        //  p.ContinueButton();

    }


    @Then("User should Verify FirstName field throw an error message")
    public void userShouldVerifyFirstNameFieldThrowAnErrorMessage() {
    }

    @When("User should give Mobile number {string}")
    public void userShouldGiveMobileNumber(String MobileNumber) {
        new PatientManagementPage().MobileNumberField(MobileNumber);
    }

    @When("User should Validate Toast message is throw from required field like {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userShouldValidateToastMessageIsThrowFromRequiredFieldLike(String FirstName, String FatherName, String GrandFatherName, String FamilyName, String LastName, String ThirdName, String Firstname1, String DateOfBirth, String Gender) {
        new PatientManagementPage().waitForVisbilityFirstNameField(FirstName);
        Assert.assertEquals(new PatientManagementPage().text(FirstName), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(FatherName), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(GrandFatherName), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(FamilyName), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(LastName), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(ThirdName), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(Firstname1), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(DateOfBirth), "Required field cannot be left blank");
        Assert.assertEquals(new PatientManagementPage().text(Gender), "Required field cannot be left blank");

    }

    @And("User can pass single character in ArabicFirstname & EnglishLastName field- {string},{string}, it throw toast message")
    public void userCanPassSingleCharacterInArabicFirstnameEnglishLastNameFieldItThrowToastMessage(String ArabicFirstName, String EnglishFirstName) throws InterruptedException {
        new PatientManagementPage().OneCharactInArabicFirstEnglishFirstName(ArabicFirstName, EnglishFirstName);
        Assert.assertEquals(new PatientManagementPage().OneCharacterInArabicFirstValidation(), "Please enter a valid name, character limit 2 - 35");
        Assert.assertEquals(new PatientManagementPage().OneCharacterInEngFirstValidation(), "Please enter a valid name, character limit 2 - 35");

    }


    @And("User can pass date of birth below {int} years, toast will throw")
    public void userCanPassDateOfBirthBelowYearsToastWillThrow(int year) throws AWTException {
        new PatientManagementPage().DateSelector(year);
        System.out.println("Date Passed------------------");
        // In UI level validation is wrong for the Date of Birth field, user can passed more than 135 years old, then only toast displayed
        Assert.assertEquals(new PatientManagementPage().DOBToastMessage(), "Invalid. Date of birth (DOB) must be 1-125 years old");


    }

    @And("User can pass less than ten digit {string} for indian Number, toast will throw")
    public void userCanPassLessThanTenDigitForIndianNumberToastWillThrow(String Number) {
        new PatientManagementPage().ClearMobileNumberField(Number);
        Assert.assertEquals(MobileNumberValidation(), "Please enter valid phone number.");

    }

    @When("User should See Toast message is throw from required field like {string},{string},{string},{string},{string},{string},{string}")
    public void userShouldSeeToastMessageIsThrowFromRequiredFieldLike(String FirstName, String FatherName, String GrandFathername, String Familyname, String LastName, String ThirdName, String FirstName1) {

        Assert.assertEquals(OneSpecialCharacterInArabicFirstValidation(FirstName), "Please enter a valid name, character limit 2 - 35, no special characters");

        Assert.assertEquals(OneSpecialCharacterInAllOtherField(FatherName), "Please enter a valid name, character limit 1 - 35, no special characters");
        Assert.assertEquals(OneSpecialCharacterInAllOtherField(GrandFathername), "Please enter a valid name, character limit 1 - 35, no special characters");
        Assert.assertEquals(OneSpecialCharacterInAllOtherField(Familyname), "Please enter a valid name, character limit 1 - 35, no special characters");
        Assert.assertEquals(OneSpecialCharacterInAllOtherField(LastName), "Please enter a valid name, character limit 1 - 35, no special characters");
        Assert.assertEquals(OneSpecialCharacterInAllOtherField(ThirdName), "Please enter a valid name, character limit 1 - 35, no special characters");
        Assert.assertEquals(OneSpecialCharacterInEngFirstValidation(FirstName1), "Please enter a valid name, character limit 2 - 35, no special characters");
    }

    @And("User should click Continue Button")
    public void userShouldClickContinueButton() {
        new PatientManagementPage().ContinueButton();
    }

    @And("User should get Success message")
    public void userShouldGetSuccessMessage() {
        Assert.assertEquals(SuccessToastMessageforAfterCreatingPatient(), "Patient added successfully", "Patient is created successfully");

    }


    @Given("User can able to view More Filter option")
    public void userCanAbleToViewMoreFilterOption() {

    }

    @And("User Clicks on More Filters button")
    public void userClicksOnMoreFiltersButton() {
    }


    @When("User Clicks the  Gender button and  Select the {string} Check box , the gender is updated")
    public void userClicksTheGenderButtonAndSelectTheCheckBoxTheGenderIsUpdated(String Gender) throws InterruptedException {


        new PatientManagementPage().SelectGenderCheckBox(Gender);
        // UpdatedAsmale();
        Thread.sleep(5000);
        new PatientManagementPage().SelectGenderCheckBox(Gender);
    }

    @And("User click Apply Button")
    public void userClickApplyButton() {
        click(FilterApplyButton);


    }

    @When("User click on {string} label")
    public void userClickOnLabel(String labelName) {
        new PatientManagementPage().clickLabelModule(labelName);
    }


    @And("User should See Toast message is throw from required field like National id,Marital status{string},Blood Group{string},Nationality{string}, Languages {string}")
    public void userShouldSeeToastMessageIsThrowFromRequiredFieldLikeNationalIdMaritalStatusBloodGroupNationalityLanguages(String value1, String value2, String value3, String value4) {
        //new PatientManagementPage().NationalIdTostMessage();
        Assert.assertEquals(new PatientManagementPage().NationalIdTostMessage(), "National ID must be at least 5 digits", "National Id is validated");
        Assert.assertEquals(new PatientManagementPage().othertoastMessages(value1), "*Required field cannot be left", "Marital status is validated");
        Assert.assertEquals(new PatientManagementPage().othertoastMessages(value2), "*Required field cannot be left", "Blood group is validated");
        Assert.assertEquals(new PatientManagementPage().othertoastMessages(value3), "*Required field cannot be left", "Nationality is validated");
        Assert.assertEquals(new PatientManagementPage().othertoastMessages(value4), "*Required field cannot be left", "Languages is validated");

    }


    @And("User can able to click multiselect in {string},{string},{string} gender")
    public void userCanAbleToClickMultiselectInGender(String male, String female, String other) throws InterruptedException {
        new PatientManagementPage().SelectMultiGenderCheckBox(male, female, other);
    }


    @Given("User can able to click the {string} label")
    public void userCanAbleToClickTheLabel(String FilterlabelName) throws InterruptedException {
        new PatientManagementPage().clickFilterLabel(FilterlabelName);

    }


    @And("User should Enter the year {string}, click {string} for the month, and select {string} for the date in {string} module")
    public void userShouldEnterTheYearClickForTheMonthAndSelectForTheDateInModule(String year, String month, String date, String module) throws InterruptedException, AWTException {
        new PatientManagementPage().Setdate(year, month, date, module);

    }

    @And("User should click More Filter and Reset button")
    public void userShouldClickMoreFilterAndResetButton() throws InterruptedException {
        new PatientManagementPage().WaitforLoad().ClickMoreFilterButton().clickResetButton().ApplyButtonIndividul();

    }


    @Given("User Clicks on More Filters button for Filter")
    public void userClicksOnMoreFiltersButtonForFilter() throws InterruptedException {
        new PatientManagementPage().ClickMoreFilterButton();

    }


    @And("User should click {string} module")
    public void userShouldClickModule(String label) {
        new PatientManagementPage().clickHealthProfilerModule(label);
    }

    @And("User can able to pass a value during the dataparamter creating {string} as {string}")
    public void userCanAbleToPassAValueDuringTheDataparamterCreatingAs(String name, String value) {
        new PatientManagementPage().clickDataparameterName(name, value);

    }

    @And("User can able to select a value during the dataparamter creating {string} as {string}")
    public void userCanAbleToSelectAValueDuringTheDataparamterCreatingAs(String parametername, String value) {
        new PatientManagementPage().clickDataparameterListDropdown(parametername, value);
    }

    @And("User can able to Multiselect a value during the dataparamter creating {string} as {string}")
    public void userCanAbleToMultiselectAValueDuringTheDataparamterCreatingAs(String parametername, String unit) throws AWTException {
        new PatientManagementPage().clickDataparameteUnit(parametername, unit);
    }

    @And("User can click Add response button")
    public void userCanClickAddResponseButton() {
        new PatientManagementPage().clickResponseButton();
    }

    @And("User can able to put a value for checkbox option as {string}, {string}")
    public void userCanAbleToPutAValueForCheckboxOptionAs(String option, String code) {
        new PatientManagementPage().checkboxOptions(option, code);
    }

    @And("User can Click Add Answered Option")
    public void userCanClickAddAnsweredOption() {
        new PatientManagementPage().clickAddAnswerOptionButton();
    }

    @And("User should click {string} button")
    public void userShouldClickButton(String value) {
        new PatientManagementPage().ClickDataparameterSaveCancelButton(value);
    }

    @Given("User can able to put a value for checkbo option as")
    public void userCanAbleToPutAValueForCheckboOptionAs(io.cucumber.datatable.DataTable d) {
    }

//    @And("User can able to pass a value during the dataparamter creating {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
//    public void userCanAbleToPassAValueDuringTheDataparamterCreating(String paraname, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, io.cucumber.datatable.DataTable d) {
//        List<Map<String, String>> mp = d.asMaps(String.class, String.class);
//        new PatientManagementPage().clickDataparameterName(paraname, mp.get(0).get("Paramtername"));
//        new PatientManagementPage().clickDataparameterListDropdown(arg1, mp.get(0).get("Category"));
//
//    }
}

