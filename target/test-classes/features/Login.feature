 Feature: login into application
 
 Scenario Outline: Positive test validating login
 Given Initialize the browser with chrome
 And Navigate to "http://qaclickacademy.com/" site
 And Click on login link in home page to land on secure sign in page
 When User enters <Username> and <Password> and login
 Then Verify that user not logged in
 And close browsers
 
 Examples:
 |Username                      |Passoword|
 |Yuvarajsrinicasna07@gmail.com |Yuvi@1907|
 |Yuvarajsrinicasna197@gmail.com|Yuvi@1997|
 
 