from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Firefox()
driver.get("https://training-support.net/webelements/tables")
print(driver.title)
rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
print(len(rows)) 
columns = driver.find_elements(By.XPATH, "//table/tbody/tr[1]/td")
print(len(columns))
 
fifth_row_book = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
print(fifth_row_book.text) 
price_header = driver.find_element(By.XPATH, "//table/thead/tr/th[5]")
price_header.click()
 
fifth_row_book_after = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
print(fifth_row_book_after.text) 
driver.quit()