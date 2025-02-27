Feature: Car Wash Booking

  Scenario Outline: User books a car wash
    Given the user is on the car wash booking page
    And I enter name <name>
    And I enter surname <surname>
    And I enter email <email>
    And I enter phone number <phone number>
    And I select Location
    And I select parking type
    And I enter Parking bay number <parking bay number>
    And I enter vehicle make <make>
    And I enter number plate <number plate>
    And I enter color <color>
    And I select a vehicle type
    And I select date
    And I select time slot
    When I click submit button
    Then The booking submitted successfully title should be displayed
    Examples:
      | name    | surname | email                   | phone number | parking bay number | make  | number plate | color  |
      | Lukh    | Hoho    | 2160098491@mycput.ac.za | 1234567890   | 001                | Polo  | CAA256987    | black  |
      | thando  | john    | 2160098491@mycput.ac.za | 1234567890   | 002                | truck | CAA256987    | yellow |
      | aphiwe  | Beme    | 2160098491@mycput.ac.za | 1234567890   | 003                | AMG   | CAA256987    | silver |
      | Sesihle | kwinana | 2160098491@mycput.ac.za | 1234567890   | 004                | mazda | CAA256987    | pink   |