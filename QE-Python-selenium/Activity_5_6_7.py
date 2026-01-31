from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/dynamic-controls")
print(driver.title)

sleep(2)

print("Checkbox")
print(driver.find_element(By.XPATH, "//input[@id='checkbox']").is_displayed())
driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()
print(driver.find_element(By.XPATH, "//input[@id='checkbox']").is_displayed())
print()

if not driver.find_element(By.XPATH, "//input[@id='checkbox']").is_displayed():
    driver.find_element(By.XPATH, "//button[text()='Toggle Checkbox']").click()

print("Check if Box Is Clicked")
print(driver.find_element(By.XPATH, "//input[@id='checkbox']").is_selected())
driver.find_element(By.XPATH, "//input[@id='checkbox']").click()
print(driver.find_element(By.XPATH, "//input[@id='checkbox']").is_selected())
print()

print("Text Input")
print(driver.find_element(By.XPATH, "//input[@id='textInput']").is_enabled())
driver.find_element(By.XPATH, "//button[text()='Enable Input']").click()
print(driver.find_element(By.XPATH, "//input[@id='textInput']").is_enabled())
print()

driver.quit()
