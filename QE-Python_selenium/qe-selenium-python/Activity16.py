from selenium import webdriver
from selenium.webdriver.support.select import Select

from selenium.webdriver.common.by import By
driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/selects")


print(driver.title)
dropdown_ele=driver.find_element(By.TAG_NAME,'select') 
dropdown_obj=Select(dropdown_ele)
for opt in dropdown_obj.options:
    print(opt.text)
options=dropdown_obj.options
dropdown_obj.select_by_index(2)
dropdown_obj.select_by_value("four")
dropdown_obj.select_by_visible_text("Three")
driver.quit()