from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/dynamic-content")
print("Page Title:", driver.title)

wait = WebDriverWait(driver, 15)
actions = ActionChains(driver) 
btn = wait.until(EC.visibility_of_element_located((By.ID, "genButton")))
actions.move_to_element(btn).click().perform()
 
word_el = wait.until(EC.visibility_of_element_located((By.ID, "word")))
wait.until(lambda d: "release" in word_el.text.lower())

print("Release text found:", word_el.text)

driver.quit()