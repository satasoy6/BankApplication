@api
  Feature: GmiBank Api Test
    Scenario: Read all customer
      Given user go to api endpoint "https://www.gmibank.com/api/tp-customers"
      And read all customers and set response