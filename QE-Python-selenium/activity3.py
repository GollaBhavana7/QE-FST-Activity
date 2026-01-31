from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/login-form")
    print(driver.title)

    sleep(2)

    driver.find_element(By.XPATH, "//input[@id='username']").send_keys("admin")
    sleep(2)
    driver.find_element(By.XPATH, "//input[@id='password']").send_keys("password")
    sleep(2)
    driver.find_element(By.XPATH, "//button[text()='Submit']").click()
    sleep(2)
    driver.quit()


