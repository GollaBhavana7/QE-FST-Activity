from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC 

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 10)
driver.get("https://training-support.net/webelements/alerts")
print("Page title is:", driver.title)
driver.find_element(By.ID, "simple").click() 
wait.until(EC.alert_is_present())
alert = driver.switch_to.alert 
print("Alert text is:", alert.text)
alert.accept()
driver.quit()  