from selenium import webdriver
from selenium.webdriver.common.by import By
from time import sleep

with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/target-practice")
    print(driver.title)

    sleep(2)

    print("Third Header Text: " + driver.find_element(By.XPATH, "//h3[text()='Heading #3']").text)
    print("Fifth Header Color: " + driver.find_element(By.XPATH, "//h5[text()='Heading #5']").value_of_css_property("color"))

    print("Purple Button Class: " + driver.find_element(By.CSS_SELECTOR, "button.bg-purple-200").get_attribute("class"))
    print("Slate Button Text: " + driver.find_element(By.CSS_SELECTOR, "button.bg-slate-200").text)
    driver.quit()


