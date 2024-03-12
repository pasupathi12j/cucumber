package com.qa.steps.ui;

import com.qa.pages.ui.UserManagementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.lang.ref.SoftReference;

public class userManagementSteps {

    @When("User click on {string} module")
    public void userClickOnModule(String value) {
     new UserManagementPage().clickModule(value);
    }

    @Then("User should navigate to User Management page")
    public void userShouldNavigateToUserManagementPage(String pageName) {
        String referenceMessage=new UserManagementPage().fetchPageName(pageName);
        Assert.assertTrue(referenceMessage.contains("User Management"));
    }

    @When("User click on Add User button")
    public void userClickOnAddUserButton() {
        new UserManagementPage().clickAddUser();

    }

    @Then("User should see Add Clinician button")
    public void userShouldSeeAddClinicianButton() {
        new UserManagementPage().addClinicianButton();
    }

    @When("User Click on Add Clinician button")
    public void userClickOnAddClinicianButton() {
        new UserManagementPage().clickClinicianButton();
    }

    @Then("User should navigate Add Clinician Page")
    public void userShouldNavigateAddClinicianPage() {
        new UserManagementPage().createUserPage();
    }

    @When("User enter mobile number as {string}")
    public void userEnterMobileNumberAs(String phoneNumber) {

        new UserManagementPage().enterMobileNumber(phoneNumber);
    }

    @And("User click on continue button")
    public void userClickOnContinueButton() {
        new UserManagementPage().clickContinueButton();
    }



//    @When("User enter {string}, {string}, {string}, {string}")
//    public void userEnter(String firstName, String lastName, String gender) {
//        new UserManagementPage().enterAdminDetails(firstName,lastName,gender);
//    }



//    @And("User Should see Clinician Role In Role Type Field")
//    public void userShouldSeeClinicianRoleInRoleTypeField() {
//        Assert.assertTrue((new UserManagementPage().roleDropdown(dropdown).contains("Clinician"), "Assertion on \"Clinician\"n");
//    }

    @Then("User should navigate to {string} page")
    public void userShouldNavigateToPage(String page) {
        String pageName=new UserManagementPage().fetchPageName(page);
        System.out.println("page name"+pageName);
        Assert.assertTrue(pageName.contains(page));
    }

    @Then("User should see table data")
    public void userShouldSeeTableData(String genderData) {
  //    Boolean referenceMessage =  new UserManagementPage().tableData(genderData);
    //  System.out.println("referenceMessage"+referenceMessage);

    }


    @Then("User Should navigate Filter popup")
    public void userShouldNavigateFilterPopup() {
        Assert.assertTrue(new UserManagementPage().GenderTextPresent(), "Gender Text is showing");
    }

    @When("User Apply {string} Filter")
    public void userApplyFilter(String filterOption) throws InterruptedException {
        new UserManagementPage().clickFilterOption(filterOption).clickApply();
    }

    @Then("User Should see the result only for {string} Clinician data")
    public void userShouldSeeTheResultOnlyForClinicianData(String genderData) {
        Boolean referenceMessage =  new UserManagementPage().tableGenderData(genderData);
        Assert.assertTrue(new UserManagementPage().tableGenderData(genderData));
        System.out.println("referenceMessage"+referenceMessage);


    }

    @When("User Click on More Filters button")
    public void userClickOnMoreFiltersButton() {
        new UserManagementPage().clickMoreFilters();
    }

    @When("User Apply {string} Role Filter")
    public void userApplyRoleFilter(String role) {
        new UserManagementPage().clickRole().clickFilterOption(role).clickApply();
    }

    @Then("User Should see the result only for {string} Clinician Role data")
    public void userShouldSeeTheResultOnlyForClinicianRoleData(String role) {
        Boolean referenceMessage =  new UserManagementPage().tableRoleData(role);
        Assert.assertTrue(new UserManagementPage().tableRoleData(role));
        System.out.println("referenceMessage"+referenceMessage);

    }


    @Then("User Should see Add Facility Admin Button")
    public void userShouldSeeAddFacilityAdminButton() {
        new UserManagementPage().addFacilityAdminButton();
    }

    @And("User Should see {string} Role In Role Type Field")
    public void userShouldSeeRoleInRoleTypeField(String dropDown) {
        Assert.assertTrue((new UserManagementPage().roleDropdown(dropDown)).contains(dropDown), "Assertion on Role Dropdown");
    }

    @When("User click on Add Facility Admin Button")
    public void userClickOnAddFacilityAdminButton() {
        new UserManagementPage().clickFacilityButton();
    }


    @When("User enter firstname as {string} and lastname as {string}")
    public void userEnterFirstnameAsAndLastnameAs(String fName, String lName) {
        new UserManagementPage().enterName(fName,lName);
    }

    @When("User select gender as {string}")
    public void userSelectGenderAs(String gender) {
        new UserManagementPage().selectDropDown(gender);

    }




//    @When("User enter {string}, {string}, {string}, {string}")
//    public void userEnter(String fName, String lName, String gender, String email) {
//        new UserManagementPage().enterAdminDetails(fName,lName, gender, email);
//    }

    @Then("User Should navigate to Create User Page")
    public void userShouldNavigateToCreateUserPage() {
        new UserManagementPage().createUserPage();

    }

    @When("User enter {string}, {string},{string} {string}, {string}")
    public void userEnter(String fName, String lName, String DDMMYYYY, String gender, String email) throws InterruptedException {
        new UserManagementPage().enterDetails(fName,lName,DDMMYYYY,gender,email);
    }

    @Then("User Should see Add Data Entry Operator Button")
    public void userShouldSeeAddDataEntryOperatorButton() {
        new UserManagementPage().addDataEntryOperatorButton();
    }

    @When("User click on Add Data Entry Operator Button")
    public void userClickOnAddDataEntryOperatorButton() {
        new UserManagementPage().clickDataEntryOperatorButton();
    }

    @When("User search data by {string}")
    public void userSearchDataBy(String fName) throws InterruptedException {
      new UserManagementPage().searchData(fName);


    }

    @Then("User should see the data in the result")
    public void userShouldSeeTheDataInTheResult() {
       String[] data = new UserManagementPage().getViewData();
       SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(data[0].contains("sangee"));
        softAssert.assertTrue(data[1].contains("Female"));
        String referencemessage =data[3].replace(" ","");
        softAssert.assertTrue(referencemessage.contains("+919940027578"));
        softAssert.assertAll();
   //    Assert.assertTrue(data[0].contains("sangeetha"));
  //     Assert.assertTrue(data[1].contains("Female"));
   //    Assert.assertTrue((data[2].contains("+91 9940027509")));
    }

    @Then("User should see the data in the result as {string}, {string},{string}")
    public void userShouldSeeTheDataInTheResultAs(String firstname, String gender, String mobile) {

        String[] data = new UserManagementPage().getViewData();
        SoftAssert softAssert =new SoftAssert();
        System.out.println("name"+data[0]);
        softAssert.assertTrue(data[0].contains(firstname));
        System.out.println("gender"+data[1]);
        softAssert.assertTrue(data[1].contains(gender));
        System.out.println(data[2].replace("+91", ""));
        System.out.println(mobile.replace("+91",""));
        softAssert.assertTrue(data[2].replace(" ", "").contains(mobile.replace(" ","")));
        softAssert.assertAll();
    }


    @Then("User should see View {string} on clicking three dots")
    public void userShouldSeeViewOnClickingThreeDots(String sea) {
    }

    @Then("User should see {string} option on clicking three dots")
    public void userShouldSeeOptionOnClickingThreeDots(String firstname) throws InterruptedException {
        new UserManagementPage().searchData(firstname);
        new UserManagementPage().clickView();


    }



    @Then("User should see View option for the user {string} on clicking three dots")
    public void userShouldSeeViewOptionForTheUserOnClickingThreeDots(String firstname) throws InterruptedException {
        new UserManagementPage().searchData(firstname);

    }

    @And("User should verify the details {string}, {string},{string} {string},{string}, {string} in view Details page")
    public void userShouldVerifyTheDetailsInViewDetailsPage(String mobilenumber, String fName, String lName, String DDMMYYYY, String gender, String email) throws InterruptedException {
     String data[]= new UserManagementPage().viewDetails();
        SoftAssert softAssert =new SoftAssert();
        System.out.println(data[0].replace(" ", ""));
        System.out.println(data[3].replace("/",""));
        System.out.println(mobilenumber.replace(" ",""));
        softAssert.assertTrue(data[0].replace(" ","").contains(mobilenumber.replace(" ","")));
        softAssert.assertTrue(data[1].contains(fName));
        softAssert.assertTrue(data[2].contains(lName));
        softAssert.assertTrue(data[3].replace("/","").contains(DDMMYYYY));
        softAssert.assertTrue(data[4].replace(" ","").contains(gender));
        softAssert.assertTrue(data[5].contains(email));
        softAssert.assertAll();
    }

    @And("User should see the Edit button")
    public void userShouldSeeTheEditButton() {

    new UserManagementPage().editButtonDisplayed();

    }

    @When("when user edit the details as {string}, {string},{string},{string}, {string}, {string}")
    public void whenUserEditTheDetailsAs(String editmobile, String editfname, String editlname, String editddmyyyy, String editgender, String editemail) throws InterruptedException {
       new UserManagementPage().editDetails(editmobile,editfname,editlname,editddmyyyy,editgender,editemail);
    }


    @And("User click on Edit button")
    public void userClickOnEditButton() {
     //   new UserManagementPage().clickEditButton();

    }

    @When("User click on View button")
    public void userClickOnViewButton() throws InterruptedException {
        new UserManagementPage().clickView();
    }

    @And("I click on continue button in Edit Details")
    public void iClickOnContinueButtonInEditDetails() throws InterruptedException {
        new UserManagementPage().editContinueButton();

    }


    @Then("User click on save button in Additional Details")
    public void userClickOnSaveButtonInAdditionalDetails() throws InterruptedException {
        new UserManagementPage().clickSave();
    }



    @And("User Click on GO Back in View Details page")
    public void userClickOnGOBackInViewDetailsPage() {
        new UserManagementPage().clickGoBack();
    }

    @When("User apply date filter")
    public void userApplyDateFilter() {
        new UserManagementPage().clickAddedOn().clickDate().clickApply(); }

    @Then("User Should see the result for the date")
    public void userShouldSeeTheResultForTheDate() {
      Assert.assertTrue(new UserManagementPage().dateResult());

    }

    @And("User can add Additional Details as {string},{string},{string},{string}")
    public void userCanAddAdditionalDetailsAs(String arg0, String arg1, String arg2, String arg3) {
    }



    @Then("User can add Additional Details as {string},{string},{string},{string},{string},{string},{string},{string}")
    public void userCanAddAdditionalDetailsAs(String alternatephonenumber, String language, String street, String area, String city, String state, String country, String addresspin) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
     new UserManagementPage().addAdditionalDetails(alternatephonenumber,language,street,area,city,state,country,addresspin);
    }

    @And("User Should see Changes Saved Success message")
    public void userShouldSeeChangesSavedSuccessMessage() {
      new UserManagementPage().changesSavedSuccessMessage();
      System.out.println(new UserManagementPage().changesSavedSuccessMessage());
      Assert.assertTrue(new UserManagementPage().changesSavedSuccessMessage().contains("Changes Saved!"));
    }

    @When("User click on {string} section")
    public void userClickOnSection(String section) {
        new UserManagementPage().clickSection(section);

    }

    @Then("User Should not see {string} module")
    public void userShouldNotSeeModule(String module) {
        System.out.println(new UserManagementPage().notContainModule(module));
        Assert.assertTrue(new UserManagementPage().notContainModule(module));
    }
}
