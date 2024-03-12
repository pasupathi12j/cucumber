Feature: Verify User Management for Facility Admin

  Scenario Outline: Verify FA can create Facility Admin successfully
    Given User is on the MOH LoginPage
    When User should login "+918798798798" and "Platform@321"
    And User should navigate to Home screen
    When User click on "User Management" module
    When User click on Add User button
    Then User Should see Add Facility Admin Button
    When User click on Add Facility Admin Button
    Then User Should navigate to Create User Page
    And User Should see "Facility Admin" Role In Role Type Field
    When User enter mobile number as "+91 9940027579"
    And User click on continue button
    When User enter "<firstname>", "<lastname>","<DDMMYYYY>" "<Gender>", "<Email>"
    And User click on continue button
    Then User should see Success message "Clinician Added Successfully"
    Examples:
      | firstname  | lastname | DDMMYYYY | Gender | Email                 |
      | sangeetha1 | Anbu1    | 11111988 | Female | sangeetha@securra.com |


  Scenario Outline: Verify FA can create DATA ENTRY OPERATOR successfully
    Given User is on the MOH LoginPage
    When User should login "+918798798798" and "Platform@321"
    And User should navigate to Home screen
    When User click on "User Management" module
    When User click on Add User button
    Then User Should see Add Data Entry Operator Button
    When User click on Add Data Entry Operator Button
    Then User Should navigate to Create User Page
    And User Should see "Data Entry Operator" Role In Role Type Field
    When User enter mobile number as "+91 9940027690"
    And User click on continue button
    When User enter "<firstname>", "<lastname>","<DDMMYYYY>" "<Gender>", "<Email>"
    And User click on continue button
    Then User should see Success message "Clinician Added Successfully"
    Examples:
      | firstname  | lastname | DDMMYYYY | Gender | Email                 |
      | sangeetha1 | Anbu1    | 11111988 | Female | sangeetha@securra.com |

@User1
  Scenario Outline: Verify FA can filter user based on Male, Female, others
    Given User is on the MOH LoginPage
    When User should login "+919999912345" and "Platform@321"
   # And User should navigate to Home screen
    When User click on "User Management" module
    When User Click on More Filters button
    Then User Should navigate Filter popup
    When User Apply "<Gender>" Filter
    Then User Should see the result only for "<Gender>" Clinician data
    Examples:
      | Gender |
      | Male   |
      | Female |
      | Others |

  Scenario Outline: Verify FA can filter user based on Role
    Then User Should navigate Filter popup
    When User Apply "<Role>" Role Filter
    Then User Should see the result only for "<Role>" Clinician Role data
    Examples:
      | Role                |
      | Facility Admin      |
      | Data Entry Operator |