from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/dynamic-controls")
print(driver.title)

wait = WebDriverWait(driver, 15)

toggle_checkbox_btn = (By.XPATH, "//button[contains(.,'Toggle Checkbox')]")
checkbox = (By.CSS_SELECTOR, "input[type='checkbox']")

# Click to remove checkbox
wait.until(EC.element_to_be_clickable(toggle_checkbox_btn)).click()

# Wait until checkbox is invisible/removed
wait.until(EC.invisibility_of_element_located(checkbox))
print("Checkbox is removed (not visible).")

# Click to add checkbox back
wait.until(EC.element_to_be_clickable(toggle_checkbox_btn)).click()

# Wait for checkbox to be present again
cb = wait.until(EC.presence_of_element_located(checkbox))

# Wait until checkbox is clickable
wait.until(EC.element_to_be_clickable(checkbox))
print("Checkbox appeared.")

# Select checkbox if not already selected
if not cb.is_selected():
    cb.click()

print("Checkbox selected:", cb.is_selected())

driver.quit()
