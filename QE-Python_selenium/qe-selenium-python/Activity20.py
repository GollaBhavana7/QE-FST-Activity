from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
driver.maximize_window()
driver.implicitly_wait(20)
wait = WebDriverWait(driver, 10)

driver.get("https://training-support.net/webelements/alerts")
print("Page Title: " + driver.title)

driver.find_element(By.XPATH, "//button[contains(text(),'Prompt')]").click()

wait.until(EC.alert_is_present())
alert = driver.switch_to.alert
print("Alert Text: " + alert.text)

alert.send_keys("Awesome!")
alert.accept()

driver.quit()