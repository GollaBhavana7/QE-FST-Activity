from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/drag-drop")

print("Page Title:", driver.title)

actions = ActionChains(driver)

# Locate elements
ball = driver.find_element(By.ID, "ball")
d1 = driver.find_element(By.ID, "dropzone1")
d2 = driver.find_element(By.ID, "dropzone2")

# Drag and drop into Dropzone 1
actions.drag_and_drop(ball, d1).perform()

# Verify ball is inside Dropzone 1
if len(d1.find_elements(By.ID, "ball")) > 0:
    print("Ball dropped into Dropzone 1")
else:
    print("Ball NOT dropped into Dropzone 1")

# Re-locate ball (DOM can change after drag-drop)
ball = driver.find_element(By.ID, "ball")

# Drag and drop into Dropzone 2
ActionChains(driver).drag_and_drop(ball, d2).perform()

# Verify ball is inside Dropzone 2
if len(d2.find_elements(By.ID, "ball")) > 0:
    print("Ball dropped into Dropzone 2")
else:
    print("Ball NOT dropped into Dropzone 2")

driver.quit()