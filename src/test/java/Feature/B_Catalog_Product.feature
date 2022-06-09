Feature: Product feature

Background:
Given User is already on the login page
When User Enters the emailid as "admin@yourstore.com" and password as "admin"
And User click on the login button
Then Page title should be "Dashboard / nopCommerce administration"
When User click on the Catalog Menu
And User click on the product menu Item 
Then User is on the products page

@AddNewProduct
Scenario: Add new Product into Application
Given User click on the Add new button
Then It should be open Add product page
When User fill up the Add product form
And User click on the product save button
Then Verify the conformation message "The new product has been added successfully."


@SearchProduct
Scenario: Search a product from product List
Given User click on the Add new button
Then It should be open Add product page
When User fill up the Add product form
And User click on the product save button
When User enter product name in the product search box
And Click on the product search button 
Then User should found product name in the Search table

@UpdateProduct
Scenario: Update a product information
Given User click on the Add new button
Then It should be open Add product page
When User fill up the Add product form
And User click on the product save button
When User enter product name in the product search box
And Click on the product search button 
When User Click on the serached product Edit button
Then It should be open Edit product detail page
When User update the product price
And Click on the product update SAVE button
Then Validate the conformation message as "The product has been updated successfully."

@DeleteProduct
Scenario: Delete selected Product from product table
Given User click on the Add new button
Then It should be open Add product page
When User fill up the Add product form
And User click on the product save button
When User enter product name in the product search box
And Click on the product search button 
When User check the searched product checkbox
And User click on the delete button
And Click on the conform product delete YES button 
Then Varify the text in the product table as "No data available in table"

@DownloadPDFCatalog
Scenario: Download Calatalog as PDF
Given User click on the Download calatlog as PDF button
Then Validate the downloaded catalog PDF

@ExportProductCatalog
Scenario: Export selected product in Excel File
Given User select the product from product table
When User click on the Export droupdown button
When User select the Export to Excel(Selected) option
Then Validate the downloaded product catalog excel file