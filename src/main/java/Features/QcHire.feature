Feature: Test Qc Hire Website

#Scenario: verify Application landing page
     #Given User is on Application page
     #Then Verify user is on Application Page
     #Then login on Application
     #Then verify that user is successfully logged in
     #Then click on QuickSearchButton
     #Then Enter Skills to search
     #Then click on SearchReseumeBtn
     
      
      @sanity
  Scenario: Verify Application landing page
     Given User is on Application page
     Then Verify user is on Application Page
     
     @sanity
  Scenario: Verify User loggen In Successfully
     Given login on Application
     Then verify that user is successfully logged in
     
     
     @sanity
  Scenario: Verify User is able to search skills and download resume by QuiclkSearch	
     Given click on QuickSearchButton
     Then Enter Skills to search
     Then click on SearchReseumeBtn
     Then Click on Candidate Title
     Then Click on Download Button
     
     
     @sanity @regression
  Scenario: Verify that meritPlus report is working fine
     Given user is on search Result page
     Then Select all resumes from the Recency
     Then Refine on Non-IT Skill Quotient filter
     Then click on candidate Title
     Then click on meritplus report button
     
     
  Scenario: Verify that user is able to refine IT Skill Quotient filter and candidate's Techgig profile.
     Given user is on search Result page
     Then Select all resumes from the Recency
     Then Refine on IT Skill Quotient filter
     Then click on candidate Title
     Then click on check now button
     
  Scenario: Verify that user is able to post job.
     Given user is on dashboard page.
     Then user clicked on post a job 
    
     
     
  Scenario: Verify that user is able to send mass sms.
     Given user is on search Result page by searching email
     Then Click on user's checkbox
     Then Click on the Send Job As sms 
     Then Select the particular job to send
     Then Select the Template
     Then click on now radio button
     Then Click on Send Sms button
     Then Verify that sms is successfully sent
     
     
   Scenario: Verify that user is able to send email.
     Given user is on search Result page by searching email
     Then Click on user's checkbox
     Then Click on Send Email button
     Then select the job designation
     Then Select the Minimuma and Maximum experience
     Then Select the job location
     Then Select the template
     Then Enter the Email Id
     Then Click on candidate can reply checkbox.
     Then Click on send button
     Then verify that email is successfully send.
     
     
     Scenario: Verify that user is able to shortlist the candidates
     Given user is on search Result page
     Then select candidates checkbox randomly 
     Then Click on shortlist button
     Then Create a folder with name as current date
     Then verify that folder is created successfully
     
    