Feature: Login Feature

@UserLogin
Scenario: Login in the applications
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
Then User click on the logout Link
Then LoginPage Title should be "Your store. Login" 

