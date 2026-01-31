from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from time import sleep

driver = webdriver.Firefox()

driver.get("https://training-support.net/webelements/mouse-events")
driver.maximize_window

cargo_lock = driver.find_element(By.XPATH, "//h1[text()='Cargo.lock']")
print(driver.title)

actions = ActionChains(driver)

sleep(2)

cargo_lock = driver.find_element(By.XPATH, "//h1[text() = 'Cargo.lock']")
actions.move_to_element(cargo_lock).click().perform()

actions.move_to_element(cargo_lock).click().perform()
sleep(1)

confirmation1 = driver.find_element(By.XPATH, "//p[@id='result']").text
print(confirmation1)

src = driver.find_element(By.XPATH, "//h1[text()='src']")
actions.double_click(src).perform()

confirmation1 = driver.find_element(By.XPATH, "//p[@id='result']").text
print(confirmation1)

driver.quit()
