@test
Feature: Patient Management Module
#  Background:
#    Given User is on the MOH LoginPage
#    Then User should login "+919999970109" and "Platform@321"
#    #QA-+919999970109 +91 9999912348 dev-DEO +916766766763
#    When User click on "Patient Management" label
   # When User click on "Patient Management" module
  @rickj1
  Scenario Outline: Verify data entry operator can create a Patient successfully
    Given User click on "Add New Patient" button
    And User should Select a country code and give MobileNumber
    When User should pass "<MobileNumber>","<FirstName>","<FatherName>","<GrandFatherName>","<FamilyName>" field
   When User should pass "<LastName>","<ThirdName>","<SecondName>","<FirstName>","<DateOfBirth>"
   And User should click Continue Button
    When User should pass other basic details "<National Id>","<Alternative Phone Number>","<Street>", "<Area>","<City>", "<Pincode>"
   And User should click Continue Button
    And User should get Success message

    Examples:
      | MobileNumber | FirstName | FatherName  | GrandFatherName  | FamilyName      | LastName      | ThirdName     | SecondName      | FirstName      | DateOfBirth | National Id | Alternative Phone Number | Street  | Area    | City     | Pincode |
      | 9751495190   | Rickj     | RickjFather | rickjGrandFather | RickjFamilyName  | RickjLastname | RicjThirdName | RickjSecondName | RickjFirstName | 12/06/1997    | 12121       | 9751495190               | Street1 | Chennai | Chennai1 | 123456  |

  @rickj2
  Scenario: verify user can able to view a toast message for un-Filled field in Creating a data entry operator of basic details page
    Given User click on "Add New Patient" button
    And User should Select a country code and give MobileNumber
    When User should give Mobile number "9751495190"
    And User should click Continue Button
    When User should Validate Toast message is throw from required field like "First Name","Father Name","Grand Father Name","Family Name","Last Name","Third Name","First Name","Date of Birth","Gender"
    And User can pass date of birth below 135 years, toast will throw
    And User can pass single character in ArabicFirstname & EnglishLastName field- "a","b", it throw toast message
    And User can pass less than ten digit "975149519" for indian Number, toast will throw

@rickj3
Scenario Outline: Verify Firstname,second Name,third name and lastname should accept only strings for Arabic and English Field
  Given User click on "Add New Patient" button
  And User should Select a country code and give MobileNumber
  When User should pass "<MobileNumber>","<FirstName>","<FatherName>","<GrandFatherName>","<FamilyName>" field
  When User should pass "<LastName>","<ThirdName>","<SecondName>","<FirstName>","<DateOfBirth>"
  When User should See Toast message is throw from required field like "First Name","Father Name","Grand Father Name","Family Name","Last Name","Third Name","First Name"
  Examples:
    | MobileNumber | FirstName  | FatherName  | GrandFatherName  | FamilyName  | LastName  | ThirdName  | SecondName  | FirstName | DateOfBirth |
    | 9751495190   | FirstName1 | FatherName1 | GrandFatherName1 | FamilyName1 | LastName1 | ThirdName1 | SecondName1 | FirstName | 12/06/1997  |
  @rickj4
  Scenario: Verify toast is message displayed for unfilled field in patient details page
    Given User click on "Add New Patient" button
    And User should Select a country code and give MobileNumber
    When User should pass "<MobileNumber>","<FirstName>","<FatherName>","<GrandFatherName>","<FamilyName>" field
    When User should pass "<LastName>","<ThirdName>","<SecondName>","<FirstName>","<DateOfBirth>"
    And User should click Continue Button
    And User should click Continue Button
    And User should See Toast message is throw from required field like National id,Marital status"<1>",Blood Group"<2>",Nationality"<3>", Languages "<4>"
  @rickj5
  Scenario: Verify Data Entry operator can able to fetch the patient details by using filter option using gender
    Given User can able to view More Filter option
    And User Clicks on More Filters button
    When User Clicks the  Gender button and  Select the "Male" Check box , the gender is updated
    When User Clicks the  Gender button and  Select the "Female" Check box , the gender is updated
    When User Clicks the  Gender button and  Select the "Others" Check box , the gender is updated
    And User can able to click multiselect in "Male","Female","Others" gender
@rickj6
  Scenario: Verify Data Entry operator can able to fetch the patient details by using filter option using Added on, Added from, Added to
    Given User Clicks on More Filters button for Filter
    And User can able to click the "Added on" label
    When User should Enter the year "2024", click "Jan" for the month, and select "1" for the date in "Added on" module
    And User click Apply Button
    And User should click More Filter and Reset button
    Given User Clicks on More Filters button for Filter
    When User can able to click the "Added from" label
    And User should Enter the year "2023", click "Jan" for the month, and select "1" for the date in "Added from" module
    When User can able to click the "Added to" label
    And User should Enter the year "2024", click "Jan" for the month, and select "23" for the date in "Added to" module
    And User click Apply Button

  @rickj7
  Scenario: Verify RA can able to create the individual dataparameter in Check box
    Given User is on the MOH LoginPage
    Then User should login "+919999912345" and "Platform@321"
    When User click on "Health Profiler" label
    And User should click "Data Parameter Library" module
    And User click on "Add New Data Parameter" button
    And User can able to pass a value during the dataparamter creating "Parameter Name" as "task1"
    And User can able to select a value during the dataparamter creating "Category" as "Person"
    And User can able to select a value during the dataparamter creating "Code Type" as "SNOMED"
    And User can able to pass a value during the dataparamter creating "Code" as "task121"
    And User can able to select a value during the dataparamter creating "Country" as "Anguilla"
    And User can able to select a value during the dataparamter creating "Unit Category" as "UoM Lab"
    And User can able to Multiselect a value during the dataparamter creating "unit" as "%"
    And User can able to select a value during the dataparamter creating "Default Unit" as "%"
    And User can click Add response button
    When User can able to select a value during the dataparamter creating "Response Type" as "Checkbox"
    And User can able to put a value for checkbox option as "checkbox1", "100"
    And User can Click Add Answered Option
    And User should click "Save" button

#    And User can able to pass a value during the dataparamter creating "Parameter Name","Category","Code Type","Code","Country","Unit Category","Unit","Default Unit","Response Type","Checkbox"
#    |Paramtername|Category|Codetype|Code|Country|Unitcategory|Unit|Defaultunit|Checkboxoption|Optioncode|
#    |task1       |Person  |SNOMED  |task121|Anguilla|UoM Lab |%   |%          |checkbox1     |100       |

















