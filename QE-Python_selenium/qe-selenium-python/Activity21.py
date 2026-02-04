from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

driver = webdriver.Firefox()
wait = WebDriverWait(driver, 20)

driver.get("https://training-support.net/webelements/tabs")
print(driver.title)

tab_btn = driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/button")
original_handle = driver.current_window_handle
print("original:" + original_handle)

tab_btn.click()
time.sleep(2)
wait.until(EC.number_of_windows_to_be(2))

handles = driver.window_handles
for handle in handles:
    if handle != original_handle:
        driver.switch_to.window(handle)

window2_handle = driver.current_window_handle
print("new window:" + window2_handle)
print("new title: " + driver.title)
print(driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/h2/span").text)

tab_btn2 = driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/button")
tab_btn2.click()
time.sleep(2)
wait.until(EC.number_of_windows_to_be(3))

handles2 = driver.window_handles
for handle in handles2:
    if handle != window2_handle and handle != original_handle:
        driver.switch_to.window(handle)

print("new window:" + driver.current_window_handle)
print("new title: " + driver.title)
print(driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/h2/span").text)

driver.quit()