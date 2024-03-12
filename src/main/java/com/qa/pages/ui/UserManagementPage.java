package com.qa.pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserManagementPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/ul[1]/li/svg")
    protected WebElement logo;
    @FindBy(xpath = "//h6[text()='User Management']")
    protected WebElement userMgmt;

    @FindBy(xpath = "//p[text()='User Management']")
    protected WebElement userMgmtText;

    @FindBy(xpath = "//button[@id=\"basic-menu\"]")
    protected WebElement addUserButton;

    @FindBy(xpath = "//p[text()='Clinician']")
    protected WebElement addClinician;


    @FindBy(xpath = "//ul[@role='menu']//p[text()='Facility Admin']")
    protected WebElement addFacilityAdmin;


    @FindBy(xpath = "//ul[@role='menu']//p[text()='Data Entry Operator']")
    protected WebElement addDataEntryOperator;

    @FindBy(xpath = "//p[text()='User Onboarding']")
    protected WebElement userOnboardingText;

    @FindBy(xpath = "//input[@value=\"+966\"]")
    protected WebElement mobileField;

    @FindBy(xpath = "//input[@placeholder='Mobile number']")
    protected WebElement mobileNumberField;


    @FindBy(xpath = "//div[text()='Clinician']")
    protected WebElement cliDropdown;

    @FindBy(xpath = "//p[text()='More Filters']")
    protected WebElement moreFilters;

    @FindBy(xpath = "//p[text()='Gender']")
    protected WebElement genderText;

    @FindBy(xpath = " //div[contains(@class,'style_filter-item-container__tagMb css-1r482s6')]//p[text()='Role']")
    protected WebElement roleTab;

    @FindBy(xpath = " //div[contains(@class,'style_filter-item-container__tagMb css-1r482s6')]//p[text()='Added on']")
    protected WebElement addedOn;

    @FindBy(xpath = "//input[@name='firstName']")
    //  @FindBy(name="firstName")
    protected WebElement adminFirstName;

    @FindBy(name = "lastName")
    protected WebElement adminLastName;
    @FindBy(xpath = "//input[@placeholder=\"MM/DD/YYYY\"]")
    protected WebElement adminDOB;
    @FindBy(name = "gender")
    protected WebElement adminGender;
    @FindBy(name = "email")
    protected WebElement adminEmail;
    @FindBy(xpath = "//button[text()='Continue']")
    protected WebElement btnContinue;

    @FindBy(xpath = "//input[@placeholder='Search Users by Name, Mobile Number']")

    protected WebElement searchField;

    @FindBy(xpath = "//table/tbody/tr[1]")
    protected WebElement viewTableData;

    @FindBy(xpath = "//button[@aria-label='action-menu-0']")
    protected WebElement threeDot;
    @FindBy(xpath = "//li[@role='menuitem']//span[1]")
    protected WebElement clickView;

    @FindBy(xpath = "//ul[@role='menu']//li[2]")
    protected WebElement editButton;
    @FindBy(xpath = "//p[text()='Save']")
    protected WebElement saveButton;

    @FindBy(xpath = "//div[@title='Save']//button//p[text()='Save']")
    protected WebElement popupSave;

    @FindBy(xpath = "//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-1tsrs1']")
    protected WebElement profilePic;

    @FindBy(xpath = "//input[@placeholder='Phone number']")
    protected WebElement alternatePhoneNumber;


    @FindBy(xpath = "//input[@name='address.street']")
    protected WebElement addressStreet;


    @FindBy(xpath = "//input[@name='address.area']")
    protected WebElement addressArea;

    @FindBy(xpath = "//input[@name='address.city']")
    protected WebElement addressCity;

    @FindBy(xpath = "//input[@name='address.state']")
    protected WebElement addressState;

    @FindBy(xpath = "//input[@name='address.country']")
    protected WebElement addressCountry;
    @FindBy(xpath = "//input[@name='address.pincode']")
    protected WebElement addressPinCode;

    @FindBy(xpath = "//p[text()='Go Back']")
    protected WebElement goBack;

    // @FindBy(xpath="//ul[@role='listbox']")
    @FindBy(xpath = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9')]//li[text()='English']")
    //div[contains(@class, 'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation8 MuiPopover-paper MuiMenu-paper MuiMenu-paper css-pwxzbm')]//li[text()='English']
    protected WebElement languageDropdown;


    public void clickMoreFilters() {
        getDriver().getWindowHandles();
        System.out.println("Mainwindowshandle" + getDriver().getWindowHandles());
        waitForVisibility(moreFilters);
        click(moreFilters);
    }

    public Boolean GenderTextPresent() {
        getDriver().getWindowHandles();
        System.out.println("In child Window" + getDriver().getWindowHandles());
        waitForVisibility(genderText);
        return genderText.isDisplayed();
    }

    public UserManagementPage clickFilterOption(String filterOption) {
        //    click(By.xpath("//div[contains(@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-7 style_filter-item-container__tagMb css-1z10m5x')]//span[text()='"+genderValue+"']"));
        //    click(By.xpath("//div[contains(@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-7 style_filter-item-container__tagMb css-1z10m5x')]//span[text()='"+filterOption+"']"));
        click(By.xpath("//div[contains(@class, 'style_filter-item-container__tagMb css-1z10m5x')]//span[text()='" + filterOption + "']"));

        return this;
    }

    public UserManagementPage clickDate() {
        click(By.xpath("//span[text()='TODAY']"));
        return this;
    }

    public UserManagementPage clickRole() {
        click(roleTab);
        return this;
    }

    public UserManagementPage clickAddedOn() {
        click(addedOn);
        return this;
    }

    public void clickApply() {
        click(By.xpath("//p[text()='Apply']"), "Clicking Apply Button");
    }

    public void clickModule(String value) {
        click(By.xpath("//h6[text()='" + value + "']"), "clicking module");
    }

    public String fetchPageName(String pageName) {
        utils.waitForElement(getDriver(), "//p[text()='" + pageName + "']", 60);
        return getText(By.xpath("//p[text()='" + pageName + "']"));
    }

    public void clickAddUser() {
        waitForVisibility(addUserButton);
        click(addUserButton);
    }

    public boolean addClinicianButton() {
        waitForVisibility(addClinician);
        return addClinician.isDisplayed();

    }

    public boolean addFacilityAdminButton() {
        waitForVisibility(addFacilityAdmin);
        return addFacilityAdmin.isDisplayed();
    }

    public boolean addDataEntryOperatorButton() {
        waitForVisibility(addDataEntryOperator);
        return addDataEntryOperator.isDisplayed();

    }


    public void selectDropDown(String value) {
        //   WebElement element=getDriver().findElement(By.id("menu-gender"));
        click(By.id("mui-component-select-gender"));
        click(By.xpath("//li[text()='" + value + "']"));
//        WebElement element=getDriver().findElement(By.xpath("//ul[@role='listbox']"));
//              Select dropdown = new Select(element);
//        dropdown.selectByIndex(2);
//        dropdown.selectByValue(value);
    }

    public Boolean tableGenderData(String genderData) {

        utils.waitForElement(getDriver(), "//table/tbody/tr[1]/td[2]", 60);
        Boolean setFlag = true;
        WebElement gender = getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        List<WebElement> col = getDriver().findElements(By.xpath("//table/tbody/tr"));
        int value = col.size();
        System.out.println("value " + value);
        List<WebElement> row = getDriver().findElements(By.xpath("//table/tbody/tr[1]/td"));
        int value1 = row.size();
        System.out.println("value1 " + value1);


        List<WebElement> values = getDriver().findElements(By.cssSelector(".k-table-tbody td:nth-child(2)"));

        for (int i = 0; i < values.size(); i++) {

            if (values.get(i).getText().contains(genderData))
                System.out.println(values.get(i).getText());
            else {
                System.out.println(values.get(i).getText());
                setFlag = false;
            }
        }
        return setFlag;

    }

    public Boolean tableRoleData(String roleData) {
        Boolean setFlag = true;
        List<WebElement> values = getDriver().findElements(By.cssSelector(".k-table-tbody td:nth-child(3)"));

        for (int i = 0; i < values.size(); i++) {

            if (values.get(i).getText().contains(roleData))
                System.out.println(values.get(i).getText());
            else {
                System.out.println(values.get(i).getText());
                setFlag = false;
            }
        }
        return setFlag;

    }

    public void clickClinicianButton() {
        click(addClinician);

    }

    public void clickContinueButton() {
        click(btnContinue);
    }

    public void clickFacilityButton() {
        click(addFacilityAdmin);

    }


    public void clickDataEntryOperatorButton() {
        click(addDataEntryOperator);
    }

    public boolean createUserPage() {
        waitForVisibility(userOnboardingText);
        return userOnboardingText.isDisplayed();
    }

    public String roleDropdown(String role) {
        return getText(By.xpath("//div[text()='" + role + "']"));

    }

    public void enterDetails(String fName, String lName, String ddmmyyyy, String gender, String email) throws InterruptedException {
        //    adminFirstName.sendKeys(Keys.TAB);
        waitForVisibility(adminFirstName);
        Thread.sleep(3000);
        adminFirstName.click();
        adminFirstName.sendKeys(fName);
        adminLastName.sendKeys(lName);

        adminDOB.click();
        adminDOB.sendKeys(ddmmyyyy);
        selectDropDown(gender);
        adminEmail.sendKeys(email);


//
//        //   adminFirstName.sendKeys(firstName);
//        waitForVisibility( adminFirstName);
//        adminFirstName.click();
//        setAttribute(adminFirstName, firstName );
//    //  sendKeys(adminFirstName, firstName);
//      //  sendKeys(adminFirstName, firstName);
//        sendKeys(adminLastName, lastName);
//
////        click(adminDOB);
////        adminDOB.sendKeys(Integer.toString(24));
////        adminDOB.sendKeys(Keys.ARROW_RIGHT);
////        adminDOB.sendKeys(Integer.toString(01));
////        adminDOB.sendKeys(Keys.ARROW_RIGHT);
////        adminDOB.sendKeys(Integer.toString(1996));
//        selectDropDown(gender);
//   //     sendKeys(adminGender, gender);
//        adminGender.sendKeys(Keys.ARROW_DOWN);
//        adminGender.sendKeys(Keys.ENTER);
//        sendKeys(adminEmail, email);
//        click(btnContinue);

    }

    public void enterMobileNumber(String number) {
        mobileField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        mobileNumberField.click();
        //   mobileField.clear();
        mobileNumberField.sendKeys(number);
        //  setAttribute(mobileField, number);
    }

    public void enterName(String fname, String lname) {
        adminFirstName.sendKeys(Keys.TAB);
        waitForVisibility(adminFirstName);
        adminFirstName.sendKeys(fname);
        adminLastName.sendKeys(lname);

    }

    public void searchData(String fName) throws InterruptedException {
        //     click(searchField);
        searchField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        searchField.sendKeys(fName);
        searchField.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

    public String[] getViewData() {

//    String[] datas = new String[4];
//      for(int i =1; i<=4; i++) {
//          for (String data1 : datas) {
//             getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[" + i + "]")).getText();
//
//          }
//          System.out.println("datas0"+datas[0]);
//          System.out.println("datas1"+datas[1]);
//          System.out.println("datas2"+datas[2]);
//          System.out.println("datas3"+datas[3]);
//
//
//
//        }

        String[] data = new String[4];
        data[0] = getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        data[1] = getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
        data[2] = getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();

        System.out.println("data0" + data[0]);
        System.out.println("data1" + data[1]);
        System.out.println("data2" + data[2]);
        return data;
    }

    public void clickView() throws InterruptedException {
        Thread.sleep(3000);
        waitForVisibility(threeDot);
        click(threeDot);
        click(clickView);

    }

    public String[] viewDetails() throws InterruptedException {
        Thread.sleep(3000);
        String attribute = "value";
        String[] data = new String[6];
        data[0] = getAttribute(mobileNumberField, attribute);
        data[1] = getAttribute(adminFirstName, attribute);
        data[2] = getAttribute(adminLastName, attribute);
        data[3] = getAttribute(adminDOB, attribute);
        data[4] = getAttribute(adminGender, attribute);
        data[5] = getAttribute(adminEmail, attribute);


        System.out.println("data0" + data[0]);
        System.out.println("data1" + data[1]);
        System.out.println("data2" + data[2]);
        System.out.println("data3" + data[3]);
        System.out.println("data4" + data[4]);
        System.out.println("data5" + data[5]);
        return data;
    }

    public boolean editButtonDisplayed() {
        waitForVisibility(threeDot);
        click(threeDot);
        waitForVisibility(editButton);
        editButton.isDisplayed();
        click(editButton);


        return true;
    }

    public void editDetails(String editMobileNumber, String editfname, String editlname, String editDDMMYYYY, String editgender, String editemail) throws InterruptedException {
        //  mobileNumberField.clear();
        Thread.sleep(2000);
        mobileNumberField.sendKeys(Keys.CONTROL, "a");
        mobileNumberField.sendKeys(Keys.DELETE);
        mobileNumberField.sendKeys(editMobileNumber);

        //adminFirstName.clear();
        adminFirstName.sendKeys(Keys.CONTROL, "a");
        adminFirstName.sendKeys(Keys.DELETE);
        adminFirstName.sendKeys(editfname);


        adminLastName.sendKeys(Keys.CONTROL, "a");
        adminLastName.sendKeys(Keys.DELETE);
        adminLastName.sendKeys(editlname);

        adminDOB.sendKeys(Keys.CONTROL, "a");
        adminDOB.sendKeys(Keys.DELETE);
        adminDOB.sendKeys(editDDMMYYYY);


        selectDropDown(editgender);

        adminEmail.sendKeys(Keys.CONTROL, "a");
        adminEmail.sendKeys(Keys.DELETE);
        adminEmail.sendKeys(editemail);


    }

    public void editContinueButton() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("//p[text()='Continue']"));

    }

    public void clickSave() throws InterruptedException {
        Thread.sleep(2000);
        waitForVisibility(saveButton);
        click(saveButton);
        waitForVisibility(popupSave);
        click(popupSave);
    }

    public void addAdditionalDetails(String aleternatephone, String langauage, String street, String area, String city, String state, String Country, String pincode) throws InterruptedException {


        //        WebElement upload_file = getDriver().findElement(By.xpath("//div[@class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-1tsrs1']"));
//        upload_file.click();
//        upload_file.sendKeys("C:\\Users\\Securra.LAPTOP469\\Desktop\\Images\\pic.jpg");
        alternatePhoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        alternatePhoneNumber.sendKeys(aleternatephone);

//        WebElement dropdown = getDriver().findElement(By.id("mui-component-select-languagesSpoken"));
//        Select drop = new Select(dropdown);
//        drop.selectByIndex(0);
        click(By.id("mui-component-select-languagesSpoken"));
        Thread.sleep(2000);
        languageDropdown.sendKeys(Keys.ARROW_DOWN);
        languageDropdown.sendKeys(Keys.ARROW_DOWN);
        languageDropdown.click();
        languageDropdown.sendKeys(Keys.TAB);
        addressStreet.sendKeys(street);
        addressArea.sendKeys(area);
        addressCity.sendKeys(city);
        addressState.sendKeys(state);
        addressCountry.sendKeys(Country);
        addressPinCode.sendKeys(pincode);
    }

    public void clickGoBack() {
        waitForVisibility(goBack);
        click(goBack);

    }

    public Boolean dateResult() {
        List<WebElement> values = getDriver().findElements(By.cssSelector(".k-table-tbody td:nth-child(3)"));
        if (values.size() > 0)
            return true;
        else
            return false;
    }

    public String changesSavedSuccessMessage() {
        utils.waitForElement(getDriver(), "//p[text()='Changes Saved!']", 60);
        return getText(By.xpath("//p[text()='Changes Saved!']"));
    }

    public void clickSection(String section) {
        utils.waitForElement(getDriver(), "//p[text()='" + section + "']", 60);
        click(By.xpath("//p[text()='" + section + "']"));
    }

    public Boolean notContainModule(String module) {
        boolean b ;
   //     utils.waitForElement(getDriver(), "//h6[text()='" + module + "']", 40);
        if (getDriver().findElements(By.xpath("//h6[text()='" + module + "']")).size() == 0)
            b = true;
        else
            b = false;
        return b;
    }
}