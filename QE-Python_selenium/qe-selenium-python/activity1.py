from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net")

    print(driver.title)

    driver.find_element(By.LINK_TEXT, "About Us").click()
    sleep(2)

    print(driver.title)


    driver.quit()


