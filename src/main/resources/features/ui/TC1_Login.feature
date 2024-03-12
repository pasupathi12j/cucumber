Feature: Verify MOH Login

  @demo
  Scenario Outline: Verify Login with Valid Credentials
    Given User is on the MOH LoginPage
    When User should login "<userName>" and "<password>"
    Then User should verify after Login success message "Demo user"
    Examples:
      | userName | password |
#      | demo     | 1234     |
    | +91 9999912345 | Platform@321       |
