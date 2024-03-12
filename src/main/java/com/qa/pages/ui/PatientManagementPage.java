package com.qa.pages.ui;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PatientManagementPage extends BasePage {

    @FindBy(xpath = "//button[@aria-label='Select country']")
    protected WebElement CountryCode;
    @FindBy(xpath = "//span[text()='India']")
    protected WebElement IndiaCode;
    @FindBy(xpath = "//input[@type='tel']")
    protected WebElement NumberField;
    @FindBy(xpath = "//button[text()='Continue']")
    protected WebElement ContinueButton;
    @FindBy(xpath = "//input[@name='firstName']")
    protected WebElement ArabicFirstName;
    @FindBy(xpath = "//input[@name='fatherName']")
    protected WebElement ArabicFatherName;
    @FindBy(xpath = "//input[@name='grandFatherName']")
    protected WebElement ArabicGrandFatherName;
    @FindBy(xpath = "//input[@name='familyName']")
    protected WebElement ArabicFamilyName;
    @FindBy(xpath = "//input[@name='lastName']")
    protected WebElement EngLastName;

    @FindBy(xpath = "//input[@name='thirdName']")
    protected WebElement EngThirdName;
    @FindBy(xpath = "//input[@name='secondName']")
    protected WebElement EngSecondName;
    @FindBy(xpath = "//input[@name='firstNameEng']")
    protected WebElement EngFirstName;

    @FindBy(xpath = "//input[@name='dob']")
    protected WebElement DateOfBrith;
    @FindBy(xpath = "//div[@id='mui-component-select-gender']")
    protected WebElement GenderTab;
    @FindBy(xpath = "//li[text()='Female']")
    protected WebElement Female;
    @FindBy(xpath = "//button[text()='Continue']")
    protected WebElement Continue;
    @FindBy(xpath = "//input[@name='nationalId']")
    protected WebElement NationalId;
    @FindBy(xpath = "//label[text()='Marital Status']//following-sibling::*")
    protected WebElement MaritalStatusDropDown;
    @FindBy(xpath = "//li[text()='Divorced']")
    protected WebElement SelectDivorced;
    @FindBy(xpath = "//label[text()='Blood Group']//following-sibling::*")
    protected WebElement BloodGroupDropDown;
    @FindBy(xpath = "//li[text()='O Positive']")
    protected WebElement SelectOPostive;
    @FindBy(xpath = "//label[text()='Nationality']//following-sibling::*")
    protected WebElement NationalityDropDown;
    @FindBy(xpath = "//li[text()='Indian']")
    protected WebElement SelectIndian;
    @FindBy(xpath = "//label[text()='Languages Spoken']//following-sibling::*")
    protected WebElement LanguagesSpokenDropDown;
    @FindBy(xpath = "//li[text()='Arabic']")
    protected WebElement SelectArabic;
    @FindBy(xpath = "//li[text()='Bulgarian']")
    protected WebElement SelectBulgarian;
    @FindBy(xpath = "//li[text()='Bosnian']")
    protected WebElement SelectBosnian;
    @FindBy(xpath = "//li[text()='English']")
    protected WebElement SelectEnglish;
    @FindBy(xpath = "//div[text()='4 items selected']")
    protected WebElement LanguagesSelected;
    @FindBy(xpath = "//label[text()='Highest Qualification']//following-sibling::*")
    protected WebElement HighestQualificationDropDown;
    @FindBy(xpath = "//li[text()='Primary School Education']")
    protected WebElement SelectPrimarySchoolEducation;
    @FindBy(xpath = "//label[text()='Occupation']//following-sibling::*")
    protected WebElement OccupationDropDown;
    @FindBy(xpath = "//li[text()='Employed']")
    protected WebElement SelectEmployed;
    @FindBy(xpath = "//input[@name='current.street']")
    protected WebElement CurrentAddressStreet;
    @FindBy(xpath = "//input[@name='current.area']")
    protected WebElement CurrentAddressArea;
    @FindBy(xpath = "(//label[text()='Country'])[1]//following-sibling::*")
    protected WebElement CurrentAddressCountryDropDown;
    @FindBy(xpath = "//li[text()='Egypt']")
    protected WebElement CurrentAddressSelectEgypt;

    @FindBy(xpath = "(//label[text()='State'])[1]//following-sibling::*")
    protected WebElement CurrentAddressStateDropDown;
    @FindBy(xpath = "//li[text()='Dakahlia']")
    protected WebElement CurrentAddressSelectAndorraLaVella;
    @FindBy(xpath = "//input[@name='current.city']")
    protected WebElement CurrentAddressCity;
    @FindBy(xpath = "//input[@name='current.pincode']")
    protected WebElement CurrentAddressPincode;
    @FindBy(xpath = "//input[@type='checkbox']")
    protected WebElement ClickSameAsCurrentAddress;
    @FindBy(xpath = "(//p[text()='Please enter a valid name, character limit 2 - 35'])[1]")
    protected WebElement ArabicFirstNameToastMessage;
//    public String errorMessage(){
//        getText(By.xpath("(//p[text()='Please enter a valid name, character limit 2 - 35'])[1]");
//    }

    public WebElement getArabicFirstNameToastMessage() {
        // gettextWeb(getArabicFirstNameToastMessage());
        //getText()
        return ArabicFirstNameToastMessage;
    }

    public WebElement getEnglishFirstNameToastMessage() {
        return EnglishFirstNameToastMessage;
    }

    public WebElement getInvalidDateOfBrith() {
        return InvalidDateOfBrith;
    }

    public List<WebElement> getGenderOptions() {
        return GenderOptions;
    }

    @FindBy(xpath = "(//p[text()='Please enter a valid name, character limit 2 - 35'])[2]")
    protected WebElement EnglishFirstNameToastMessage;
    @FindBy(xpath = "//p[text()='Invalid. Date of birth (DOB) must be 1-125 years old']")
    protected WebElement InvalidDateOfBrith;
    @FindBy(xpath = "//li[@role='option']")
    protected List<WebElement> GenderOptions;

    @FindBy(xpath = "//p[text()='Add New Patient']")
    protected WebElement AddButton;

    public PatientManagementPage ClickAddButton(String value) {
        waitForVisibility(By.xpath("//p[text()='"+value+"']"));
        click(By.xpath("//p[text()='"+value+"']"));
        return this;
    }

    public PatientManagementPage ClickCountryCode() {
        click(CountryCode);
        waitForVisibility(By.xpath("//span[text()='Saudi Arabia']"));
//ScrollUpOrDown(false,IndiaCode);
        click(IndiaCode);
        return this;

    }

    public PatientManagementPage MobileNumberField(String value) {
        sendKeys(NumberField, value);

        return this;
    }

    public PatientManagementPage ContinueButton() {
        waitForVisibility(ContinueButton);
        click(ContinueButton);
        return this;
    }

    public void ArabicField(String FirstName, String FatherName, String GrandFatherName, String FamilyName) {
        implicityWait();
        ArabicFirstName.sendKeys(FirstName);
        ArabicFatherName.sendKeys(FatherName);
        ArabicGrandFatherName.sendKeys(GrandFatherName);
        ArabicFamilyName.sendKeys(FamilyName);

    }

    public void EnglishField(String LastName, String ThirdName, String SecondName, String FirstName, String DateOfBirth) throws InterruptedException {
        EngLastName.sendKeys(LastName);
        EngThirdName.sendKeys(ThirdName);
        EngSecondName.sendKeys(SecondName);
        EngFirstName.sendKeys(FirstName);
        ScrollUpOrDown(String.valueOf(true), DateOfBrith);
        Thread.sleep(2000);
        waitForVisibility(DateOfBrith);
        DateOfBrith.click();
        DateOfBrith.sendKeys(DateOfBirth);
        GenderTab.click();
        Female.click();
    }

    public void PatientDetailsPage(String National, String AlternativePhoneNumbers, String Street, String Area, String City, String Pincode) throws AWTException, InterruptedException {
        //Basic details
        NationalId.sendKeys(National);
        MaritalStatusDropDown.click();
        // waitForVisibility(SelectDivorced);
        SelectDivorced.click();
        BloodGroupDropDown.click();
        SelectOPostive.click();
        NationalityDropDown.click();
        ScrollUpOrDown(String.valueOf(true), SelectIndian);
        SelectIndian.click();
        LanguagesSpokenDropDown.click();
        SelectArabic.click();
        SelectBulgarian.click();
        SelectBosnian.click();
        ScrollUpOrDown(String.valueOf(true), SelectEnglish);
        SelectEnglish.click();
        Thread.sleep(2000);
        keyBoardActionEscape();
        Thread.sleep(4000);
        keyBoardActionEscape();
        CountryCode.click();
        waitForVisibility(By.xpath("//span[text()='Saudi Arabia']"));
        IndiaCode.click();
        NumberField.sendKeys(AlternativePhoneNumbers);
        //Education & Occupation
        HighestQualificationDropDown.click();
        SelectPrimarySchoolEducation.click();
        OccupationDropDown.click();
        SelectEmployed.click();
        //Current Address
        CurrentAddressStreet.sendKeys(Street);
        CurrentAddressArea.sendKeys(Area);
        CurrentAddressCountryDropDown.click();
        ScrollUpOrDown(String.valueOf(true), CurrentAddressSelectEgypt);
        CurrentAddressSelectEgypt.click();
        CurrentAddressStateDropDown.click();
        CurrentAddressSelectAndorraLaVella.click();
        CurrentAddressCity.sendKeys(City);
        CurrentAddressPincode.sendKeys(Pincode);
        ClickSameAsCurrentAddress.click();

    }

    public void waitForVisbilityFirstNameField(String value) {
        waitForVisibility(By.xpath("(//label[text()='" + value + "'])[1]//following::p[text()='Required field cannot be left blank'][1]"));
    }

    public String text(String value) {
        return getText(By.xpath("(//label[text()='" + value + "'])[1]//following::p[text()='Required field cannot be left blank'][1]"));
    }

    public String text1(String value) {
        return getText(By.xpath("(//label[text()='" + value + "'])[2]//following::p[text()='Required field cannot be left blank'][1]"));
    }


    @FindBy(xpath = "(//label[text()='Date of Birth'])//following::p[text()='Invalid. Date of birth (DOB) must be 1-125 years old']")
    protected WebElement DateOfBrithtoastMessage;

    public String DOBToastMessage() {
        return DateOfBrithtoastMessage.getText();
    }

    public PatientManagementPage DateSelector(int a) throws AWTException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMMyyyy");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lt = now.minusYears(a);
        DateOfBrith.click();
        DateOfBrith.sendKeys(dtf.format(lt));
        keyBoardActionTab();
        return this;
    }

    public void OneCharactInArabicFirstEnglishFirstName(String FirstName, String LastName) throws InterruptedException {
        ArabicFirstName.sendKeys(FirstName);
        EngFirstName.sendKeys(LastName);
        Thread.sleep(2000);
    }

    public String OneCharacterInArabicFirstValidation() {
        return getText(By.xpath("(//label[text()='First Name'])[1]//following::p[text()='Please enter a valid name, character limit 2 - 35'][1]"));
    }

    public String OneCharacterInEngFirstValidation() {
        return getText(By.xpath("(//label[text()='First Name'])[2]//following::p[text()='Please enter a valid name, character limit 2 - 35'][1]"));
    }

    public void ClearMobileNumberField(String Number) {
        ScrollUpOrDown(String.valueOf(false), NumberField);
        click(NumberField);
        for (int i = 0; i < 10; i++) {
            NumberField.sendKeys(Keys.BACK_SPACE);
        }
        NumberField.sendKeys(Number);
    }

    public String MobileNumberValidation() {
        return getText(By.xpath("//span[text()='Mobile Number']//following::p[text()='Please enter valid phone number.']"));
    }

    //

    public String OneSpecialCharacterInArabicFirstValidation(String value) {
        return getText(By.xpath("(//label[text()='" + value + "'])[1]//following::p[text()='Please enter a valid name, character limit 2 - 35, no special characters'][1]"));
    }

    public String OneSpecialCharacterInEngFirstValidation(String value) {
        return getText(By.xpath("(//label[text()='" + value + "'])[2]//following::p[text()='Please enter a valid name, character limit 2 - 35, no special characters'][1]"));
    }

    public String OneSpecialCharacterInAllOtherField(String value) {
        return getText(By.xpath("//label[text()='" + value + "']//following::p[text()='Please enter a valid name, character limit 1 - 35, no special characters'][1]"));

    }

    @FindBy(xpath = "//p[text()='Success']//following::p[text()='Patient added successfully']")
    protected WebElement SuccessToastMessage;

    public String SuccessToastMessageforAfterCreatingPatient() {
        return SuccessToastMessage.getText();
    }

    public void GenderCheckbox(int a) {
        click(By.xpath("(//input[@type='checkbox'])[" + a + "]"));
    }

    @FindBy(xpath = "//p[text()='Gender']")
    protected WebElement FilterGender;
    @FindBy(xpath = "//p[text()='Apply']")
    protected WebElement FilterApplyButton;

    public PatientManagementPage ApplyButtonIndividul() {
        click(FilterApplyButton);
        return this;
    }

    @FindBy(xpath = "//p[text()='More Filters']")
    protected WebElement MoreFilterButton;

    public PatientManagementPage ClickMoreFilterButton() throws InterruptedException {
        waitForVisibility(MoreFilterButton);
        click(MoreFilterButton);
        return this;
    }

    @FindBy(xpath = "//span[text()='Loading']//parent::div[1]")
    protected WebElement WaitforLoader;

    public PatientManagementPage WaitforLoad() {
        waitForInVisibility(WaitforLoader);
        return this;

    }

    public void SelectGenderCheckBox(String gender) throws InterruptedException {
        try {
            waitForVisibility(By.xpath("//p[text()='More Filters']"));
            click(By.xpath("//p[text()='More Filters']"));
            click(FilterGender);
            click(By.xpath("(//input[@type='checkbox'])[1]//following::span[text()='" + gender + "']"));
            click(FilterApplyButton);

        } catch (Exception e) {
            Thread.sleep(10000);
            waitForVisibility(By.xpath("//p[text()='More Filters']"));
            click(By.xpath("//p[text()='More Filters']"));
            click(By.xpath("(//input[@type='checkbox'])[1]//following::span[text()='" + gender + "']"));
            click(FilterApplyButton);

        }
    }


    public PatientManagementPage SelectMultiGenderCheckBox(String male, String female, String other) throws InterruptedException {

        waitForVisibility(MoreFilterButton);
        click(MoreFilterButton);
        click(FilterGender);
        click(By.xpath("(//input[@type='checkbox'])[1]//following::span[text()='" + male + "']"));
        click(By.xpath("(//input[@type='checkbox'])[1]//following::span[text()='" + female + "']"));
        click(By.xpath("(//input[@type='checkbox'])[1]//following::span[text()='" + other + "']"));
        click(FilterApplyButton);
        return this;
    }


    @FindBy(xpath = "//p[text()='Gender']//following-sibling::p[text()='Male']")
    protected WebElement UpdatedAsMale;

    public void UpdatedAsmale() {
        UpdatedAsMale.isDisplayed();
    }

    public void ClickMoreoption(String id) {
        click(By.xpath("//span[text()='" + id + "']//following::td[4]//button"));
    }


    public void clickLabelModule(String value) {
        click(By.xpath("//li[@aria-label='" + value + "']"), "clicking label");

    }

    public String NationalIdTostMessage() {
        return getText(By.xpath("//p[text()='National ID must be at least 5 digits']"));

    }

    public String othertoastMessages(String value) {
        return getText(By.xpath("(//p[text()='*Required field cannot be left'])[" + value + "]"));
    }

    @FindBy(xpath = "//span[text()='TODAY']//preceding::span[@class='k-button-text']")
    protected WebElement MonthSelectorButton;
    @FindBy(xpath = "//span[text()='TODAY']")
    protected WebElement TodaySelectorButton;

    public void Setdate(String value, String month, String date, String module) throws AWTException, InterruptedException {
        Thread.sleep(5000);
        waitForVisibility(MonthSelectorButton);
        actionsMoveToElement(MonthSelectorButton);
        Thread.sleep(5000);
        waitForVisibility(MonthSelectorButton);
        actionsMoveToElement(MonthSelectorButton);
        System.out.println("clicked button");
        click(By.xpath("//p[text()='"+module+"']//parent::div"));
        keyBoardActionTab();
        Thread.sleep(2000);
        keyBoardActionTab();

        int attempts = 0;
        int maxattempts = 200;

        try {
            Thread.sleep(2000);
            click(By.xpath("//span[text()='" + value + "']"));
        } catch (Exception e) {
            while (attempts < maxattempts) {
                Thread.sleep(3000);
                int size = getDriver().findElements(By.xpath("//span[text()='" + value + "']")).size();
                if (size == 1) {
                    System.out.println("entered if condition block");
                    click(By.xpath("//span[text()='" + value + "']"));
                    // found=true;
                    break;
                } else {
                    System.out.println("entered else condition block");
                    keyBoardActionUpArrow();
                }
                attempts++;


            }
        }

        click(By.xpath("//span[text()='TODAY']//following::span[text()='" + month + "'][1]"));
        //   click month calender date
        click(By.xpath("//span[text()='TODAY']//following::span[text()='" + date + "'][1]"));
    }

    public void clickFilterLabel(String value) {
        click(By.xpath("//p[text()='"+value+"']//parent::div"),"like Added on, Added to, Added from");

    }

    public PatientManagementPage clickResetButton() {
        click(By.xpath("//p[text()='Reset']"));
        return this;
    }
    public void clickHealthProfilerModule(String value){
        click(By.xpath("//h6[text()='"+value+"']"));
    }
    public void clickDataparameterName(String parametername, String value){
       clickAndSendKeys(By.xpath("//label[text()='"+parametername+"']//following::input[1]"),value, "Value passed");

    }

    public void clickDataparameterListDropdown(String parametername, String value){
        click(By.xpath("//label[text()='"+parametername+"']//following::div[1]"));
        waitForVisibility(By.xpath("//li[text()='"+value+"']"));
        ScrollUpOrDownBy(String.valueOf(true),By.xpath("//li[text()='"+value+"']"));
        click(By.xpath("//li[text()='"+value+"']"));

    }
    public void clickDataparameteUnit(String parametername, String unit) throws AWTException {
        ScrollUpOrDownBy(String.valueOf(true),By.xpath("//label[text()='"+parametername+"']//following::div[1]"));
        click(By.xpath("//label[text()='"+parametername+"']//following::div[1]"));
        waitForVisibility(By.xpath("//span[text()='"+unit+"']"));
        ScrollUpOrDownBy(String.valueOf(true),By.xpath("//span[text()='"+unit+"']"));
        click(By.xpath("//span[text()='"+unit+"']"));
        keyBoardActionTab();
    }
    public PatientManagementPage clickResponseButton(){
        click(By.xpath("//p[text()='Click Here to Add Response Type']//preceding-sibling::button"));
    return this;}

@FindBy(xpath = "//button[@aria-label='Maximum 200 options allowed']//preceding::input[2]")
    protected WebElement CheckboxOption;
    @FindBy(xpath = "//button[@aria-label='Maximum 200 options allowed']//preceding::input[1]")
    protected WebElement CheckboxCode;
    public void checkboxOptions(String option,String code){
        clickAndSendKeys(CheckboxOption,option,"Check Option is added");
        clickAndSendKeys(CheckboxCode,code,"Option code is added");

    }
    @FindBy(xpath = "//button[@aria-label='Maximum 200 options allowed']")
    protected WebElement AddAnswerOptionButton;
    public void clickAddAnswerOptionButton(){
        click(AddAnswerOptionButton);
    }
public void ClickDataparameterSaveCancelButton(String value){
        click(By.xpath("//button[text()='"+value+"']"));
}




}










