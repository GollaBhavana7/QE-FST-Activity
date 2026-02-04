from selenium import webdriver
from selenium.webdriver.common.by import By
import time

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/keyboard-events")

print(driver.title)

# Locate the heading element using the same XPath
keyboard = driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/h1")

# Pause for 3 seconds (like Thread.sleep in Java)
time.sleep(3)

# Print heading text
print(keyboard.text)

driver.quit()