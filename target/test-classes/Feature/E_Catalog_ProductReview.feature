Feature: Product Review Feature

Background:
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
When User click on the Catalog Menu
And User click on the product review menu Item 
Then User should be on the product review Page

@searchProductReview
Scenario: Search product review by product name
Given User Enter the product name in the search box
And User click on the review search button
Then User should found the product reviews in the reviews table

@UpdateProductResview
Scenario: Update product review detail
Given User Enter the product name in the search box
And User click on the review search button
When User click on the searched product review Edit button
Then It should be open Edit product review details page
When User update the review Text
And User click on the review SAVE  button
Then Conformation message should be displayed as "The product review has been updated successfully."

@ApproveSelectedProductReview
Scenario: Approve Selected Product Review
Given User Enter the product name in the search box
And User click on the review search button
Then User check the checkbox of searched product review
And User click on the approve selected button
Then User should found the tick mark in product review table in is approved field

@DisApprovedSelectedProductReview
Scenario: Approve Selected Product Review
Given User Enter the product name in the search box
And User click on the review search button
Then User check the checkbox of searched product review
And User click on the DisApprove selected button
Then User should found the Cross mark in product review table in is approved field

@DeleteProductReview
Scenario: Delete selected Product review
Given User check the checkbox of product review in the table
When User click on the review Delete selected button
And User click on the conform review delete YES button