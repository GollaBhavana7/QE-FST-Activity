from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/tables")

print(driver.title)

rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
print(len(rows)) 
columns = driver.find_elements(By.XPATH, "//table/tbody/tr[1]/td")
print(len(columns))
 
row3 = driver.find_elements(By.XPATH, "//table/tbody/tr[3]/td")
for cell in row3:
    print(cell.text) 
cell_value = driver.find_element(By.XPATH, "//table/tbody/tr[2]/td[2]")
print(cell_value.text)

driver.quit()