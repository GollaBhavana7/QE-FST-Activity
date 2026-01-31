from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    print(driver.title)

    driver.find_element(By.ID, "username").send_keys("admin")
    driver.find_element(By.ID, "password").send_keys("password")
    driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/form/button").click()
"""    driver.quit()
"""

