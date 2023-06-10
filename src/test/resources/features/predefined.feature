@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"
    
  @predefined2
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title contains "Bing"
    And element with xpath "//input[@id='sb_form_q']" should be displayed
    When I type "Behavior driven development" into element with xpath "//input[@id='sb_form_q']"
    And I click on element with xpath "//label[@id='search_icon']"
    And I wait for element with xpath "//ol[@id='b_results']" to be present
    And element with xpath "//ol[@id='b_results']" should contain text "Cucumber"
    And I wait for 3 sec
    
    
  @predefined3
  Scenario: Predefined steps for yahoo
    Given I open url "https://www.yahoo.com"
    And I should see page title contains "Yahoo"
    And element with xpath "//input[@id='ybar-sbq']" should be displayed
    When I type "Behavior driven development" into element with xpath "//input[@id='ybar-sbq']"
    And I click on element with xpath "//button[@id='ybar-search']"
    And I wait for element with xpath "//div[@id='cols']" to be present
    Then element with xpath "//div[@id='cols']" should contain text "Cucumber"
    And I wait for 2 sec

  @predefined4
  Scenario: Predefined steps for ecosia
    Given I open url " https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    And element with xpath "//input[@name='q']" should be displayed
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@aria-label='Submit']"
    Then I wait for element with xpath "//main[@id='main']" to be present
    Then element with xpath "//main[@id='main']" should contain text "Cucumber"
    And I wait for 2 sec

  @Predefined5
  Scenario: Predefined Steps for gibiru
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    And element with xpath "//input[@id='q']" should be displayed
    When I type "Behavior driven development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='starter-template']" to be present
    And element with xpath "//div[@class='starter-template']" should contain text "Cucumber"
    And I wait for 2 sec

    @predefined6
    Scenario: Predefined steps for duckcuckgo
      Given I open url "https://duckduckgo.com"
      Then I should see page title contains "DuckDuckGo"
      And element with xpath "//input[@id='searchbox_input']" should be displayed
      When I type "Behavior Driven Development" into element with xpath "//input[@id='searchbox_input']"
      And I click on element with xpath "//button[@aria-label='Search']"
      Then I wait for element with xpath "//div[@class='results--main']" to be present
      And element with xpath "//div[@class='results--main']" should contain text "Cucumber"
      And I wait for 2 sec

    @predefined7
    Scenario: Predefined steps for Startpage
      Given I open url "https://www.startpage.com"
      Then I should see page title contains "Startpage"
      And I wait for element with xpath "//input[@id='q']" to be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
      And I click on element with xpath "//form[@id='search']//button[@id='search-btn']"
      Then I wait for element with xpath "//div[@class='mainline-results mainline-results__web']" to be present
      And element with xpath "//div[@class='mainline-results mainline-results__web']" should contain text "Cucumber"
      And I wait for 2 sec

    @predefined8
    Scenario: Predefined steps for searchencrypt
      Given I open url " https://www.searchencrypt.com"
      Then I should see page title contains "Search Encrypt"
      And I wait for element with xpath "//input[@name='q']" to be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
      And I click on element with xpath "//button[@type='submit']"
      And I wait for element with xpath "//section[@class='serp__results container']" to be present
      Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"
      And I wait for 2 sec
      
    @predefined9
    Scenario: Dealing with Hidden element because of Cookie
      Given I open url " https://www.ecosia.org"
      Then I should see page title contains "Ecosia"
      When I click on element with xpath "//button[@data-test-id='cookie-notice-accept']"
      And I click on element with xpath "//a[@data-test-id='legaltitle'][contains(@href,'tos')]"
      Then element with xpath "//h2[contains(text(),'Terms of service')]" should be present

    @predefined10
    Scenario: Validate responsive UI
      Given I open url "https://skryabin.com/market/quote.html"
      When I resize window to 993 and 1200
      Then element with xpath "//b[@id='location']" should be displayed
      Then element with xpath "//b[@id='currentDate']" should be displayed
      Then element with xpath "//b[@id='currentTime']" should be displayed
      And I wait for 2 sec
      When I resize window to 768 and 1200
      Then element with xpath "//b[@id='location']" should be displayed
      Then element with xpath "//b[@id='currentDate']" should be displayed
      Then element with xpath "//b[@id='currentTime']" should be displayed
      And I wait for 2 sec
      When I resize window to 767 and 1200
      Then element with xpath "//b[@id='location']" should not be displayed
      Then element with xpath "//b[@id='currentDate']" should not be displayed
      Then element with xpath "//b[@id='currentTime']" should not be displayed
      And I wait for 2 sec

    @predefined11
    Scenario: Username Length
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='username']" should be displayed
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    And element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
    When I type "b" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should not be displayed
    And I wait for 2 sec


    @predefined12
    Scenario:Only valid email address.
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "ydgdf_gmail.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
    When I type "ydgdfe92@gmail.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be displayed
    And I wait for 2 sec

    @predefined13
    Scenario: Validate password fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "password123" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword'][@disabled='disabled']" should not be present
    When I clear element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//input[@id='confirmPassword'][@disabled='disabled']" should be present
    And I wait for 2 sec


    @predefined14
    Scenario: Valid Name fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Yadu" into element with xpath "//input[@id='firstName']"
    And I type "Kumari" into element with xpath "//input[@id='middleName']"
    And I type "Ramesh" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//button[@type='button']/span[text()='Save']"
    Then element with xpath "//input[@value='Yadu Kumari Ramesh']" should be displayed
    And I wait for 2 sec

    @predefined15
    Scenario: Validate Privacy Policy
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "- Must check!"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed
    And I wait for 2 sec

    @predefined16
    Scenario: Validate non-required feilds
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234544345" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='India']"  
    And I click on element with xpath "//input[@name='gender'][@value='female']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "555 W.ufyeiufg, Avenue Apt#12, yfdgsku,CA -129345" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Other']"
    When I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    When I type "03/02/1928" into element with xpath "//input[@id='dateOfBirth']"
    And I wait for 2 sec

    @predefined17
    Scenario: Validate the present data with submitted data
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Yadu" into element with xpath "//input[@id='firstName']"
    And I type "Kumari" into element with xpath "//input[@id='middleName']"
    And I type "Ramesh" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//button[@type='button']/span[text()='Save']"
    When I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='India']"
    And I type "555 W.ufyeiufg, Avenue Apt#12, yfdgsku,CA -129345" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Other']"
    When I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    When I type "03/02/1928" into element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//input[@name='gender'][@value='female']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    When I type "1234544345" into element with xpath "//input[@name='phone']"
    And I type "Yadukumari" into element with xpath "//input[@name='username']"
    When I type "password123" into element with xpath "//input[@id='password']"
    And I type "password123" into element with xpath "//input[@id='confirmPassword']"
    When I type "ydgdf@gmail.com" into element with xpath "//input[@name='email']"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='username'][text()='Yadukumari']" should be displayed
    Then element with xpath "//b[@name='carMake'][text()='Other']" should be displayed
    Then element with xpath "//b[@name='name'][text()='Yadu Kumari Ramesh']" should be displayed
    Then element with xpath "//b[@name='address'][text()='555 W.ufyeiufg, Avenue Apt#12, yfdgsku,CA -129345']" should be displayed
    Then element with xpath "//b[@name='phone'][text()='1234544345']" should be displayed
    Then element with xpath "//b[@name='dateOfBirth'][text()='03/02/1928']" should be displayed
    Then element with xpath "//b[@name='password']" should not contain text "password123"
    And I wait for 2 sec














  


    
    









      # desktop:1200/993
      #tablet: 1200/768
      #mobile: 1200/767





    

  