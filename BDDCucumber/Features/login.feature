Feature: Login 

Description: this test is to verify user can login to the applicationwih valid credentials


Scenario: Successful Login with valid credentials 
   Given User Launch Chrome browser
   When User opens URL "http://admin-demo.nopcommerce.com/login"
   And  User enters Email as "admin@yourstore.com" and Password as "admin"
   And  Click on Login
   Then Page Title should be "Dashboard / nopCommerce administration"
   When User click on log out Link  
   Then Page Title should be "Your store. Login"
   And close browser
 
 
 
 
Scenario Outline: Login using multiple credentials 
	 Given User Launch Chrome browser
	 When User opens URL "http://admin-demo.nopcommerce.com/login"
	 And  User enters Email as "<email>" and Password as "<password>"
	 And  Click on Login
	 Then Page Title should be "Dashboard / nopCommerce administration"
	 When User click on log out Link  
	 Then Page Title should be "Your store. Login"
	 And close browser
	 
	 Examples:
        | email               | password |
        | admin@yourstore.com | admin    |
        | admin@yourstore.com | admin123 |
        | james@yourstore.com | admin    |
          
        
        
          
     
 