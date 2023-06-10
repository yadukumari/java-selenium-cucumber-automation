@quote
  Feature:Quote Project

    @quote1
    Scenario: Quote basic test
      Given I go to "quote" page
      #And I print page details
      And I fill out required fields
      And I submit the form
      Then I verify fields saved correctly
      And I wait for 2 sec
      #Given I go to "google" page
      #And I go to "quote" page
      #And I wait for 1 sec
      #And I go back and forward,then refresh the page
      #And I wait for 3 sec
      #And I print logs to the console
      #And I change resolution to "phone"
      #And I change resolution to "desktop"

    @quote1oop
    Scenario: Quote basic test oop
      Given I go to "quote" page oop
      And I fill out required fields oop
      And I submit the form oop
      And I wait for 2 sec
      Then I verify fields saved correctly oop
      And I wait for 2 sec


    @quote2oop
    Scenario: Quote basic required labels
      Given I go to "quote" page oop
      And label "Name" has required asterisk
      And label "Username" has required asterisk
      And label "Password" has required asterisk
      And label "Confirm Password" has required asterisk
      And label "Email" has required asterisk
      #And label "I have read and accept Privacy Policy." has required asterisk
      And label "Phone Number" doesn't have required asterisk
      And label "Country of Origin" doesn't have required asterisk
      And label "Date of Birth" doesn't have required asterisk
      And label "Allowed to Contact?" doesn't have required asterisk
      And label "Gender" doesn't have required asterisk
      And label "Address" doesn't have required asterisk
      And label "Car Make" doesn't have required asterisk
      And label "Additional Information" doesn't have required asterisk
      And I wait for 2 sec

    @quote5
    Scenario: Required fields test
      Given I go to "quote" page
      Then I don't see "username" error message
      And I don't see "email" error message
      And I don't see "password" error message
      And I don't see "name" error message
      And I don't see "agreedToPrivacyPolicy" error message
      And I submit the form
      Then I see "username" error message "This field is required."
      And I see "email" error message "This field is required."
      And I see "password" error message "This field is required."
      And I see "name" error message "This field is required."
      And I see "agreedToPrivacyPolicy" error message "- Must check!"
      And I wait for 2 sec


    @quote6
    Scenario: Market username test
      Given I go to "quote" page
      When I fill out "username" field with "a"
      And I submit the form
      Then I see "username" error message "Please enter at least 2 characters."
      When I fill out "username" field with "ab"
      Then I don't see "username" error message


    @quote7
    Scenario: Market email test
      Given I go to "quote" page
      When I fill out "email" field with "john"
      And I submit the form
      Then I see "email" error message "Please enter a valid email address."
      When I fill out "email" field with "john@example.com"
      Then I don't see "email" error message

    @quote8
    Scenario: Market passwords test
      Given I go to "quote" page
      When I fill out "password" field with "1234"
      And I submit the form
      Then I see "password" error message "Please enter at least 5 characters."
      When I fill out "password" field with "12345"
      Then I don't see "password" error message
      When I fill out "confirmPassword" field with "1234"
      And I submit the form
      Then I see "confirmPassword" error message "Please enter at least 5 characters."
      When I fill out "confirmPassword" field with "54321"
      Then I see "confirmPassword" error message "Passwords do not match!"
      When I fill out "confirmPassword" field with "12345"
      Then I don't see "confirmPassword" error message


    @quote9
    Scenario: Select Interaction
      Given I go to "quote" page
      And I select "Toyota" and "BMW" from multi-select


    @quote3oop
    Scenario: Switching to iframes oop
      Given I go to "quote" page
      When I fill out contact name "Richard Roe" and phone "1234567891" oop
      And I fill out required fields oop
      And I submit the form