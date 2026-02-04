from selenium import webdriver
from selenium.webdriver.common.by import By 
driver = webdriver.Firefox()
 
driver.get("https://training-support.net/webelements/dynamic-attributes")
print(driver.title)
 
full_name = driver.find_element(By.XPATH, "//input[contains(@placeholder,'Full')]")
email = driver.find_element(By.XPATH, "//input[contains(@placeholder,'Email')]")
dob = driver.find_element(By.XPATH, "//input[contains(@data-testid,'event-date')]")
additional_details = driver.find_element(By.XPATH, "//textarea[contains(@class,'focus')]")
submit_btn = driver.find_element(By.XPATH, "//button[contains(text(),'Sub')]") 
full_name.send_keys("Bhavana")
email.send_keys("bhavs@gmail.com")
dob.send_keys("2003-06-17")
additional_details.send_keys("Hi")
 
submit_btn.click()
 
success_msg = driver.find_element(By.ID, "action-confirmation")
print(success_msg.text) 
driver.quit()