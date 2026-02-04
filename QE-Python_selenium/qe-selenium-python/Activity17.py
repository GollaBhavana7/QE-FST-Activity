from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.webdriver.firefox.service import Service
import time

driver = webdriver.Firefox()
driver.implicitly_wait(10)

driver.get("https://training-support.net/webelements/selects")
print("Page title:", driver.title)
 
selects = driver.find_elements(By.TAG_NAME, "select")
 
multi_select_element = selects[1]
multi_select = Select(multi_select_element) 
multi_select.select_by_visible_text("HTML")
print("Selected: HTML")
 
multi_select.select_by_index(3)
multi_select.select_by_index(4)
multi_select.select_by_index(5)
print("Selected options at indexes 3, 4, and 5")
 
multi_select.select_by_value("nodejs") 
multi_select.deselect_by_index(4)
print("Deselected the 5th option (Index 4)") 
print("Currently Selected Options:")
selected_options = multi_select.all_selected_options

for option in selected_options:
    print("Selected:", option.text)

driver.quit()