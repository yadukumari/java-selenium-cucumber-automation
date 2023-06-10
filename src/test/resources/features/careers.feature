@Careers
  Feature: Careers

    @careers1 @post_position @clean_position
    Scenario: Updating positions details via UI
      Given I go to "careers" page oop
      And I login as "recruiter"
