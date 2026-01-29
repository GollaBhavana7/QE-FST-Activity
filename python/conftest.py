import pytest
import requests
from bs4 import BeautifulSoup

@pytest.fixture
def input_value():
    return 12

@pytest.fixture
def home_page_content():
    response=requests.get('https://training-support.net')
    content=response.content
    soup=BeautifulSoup(content,'html.parser') 
    return soup

import pytest
@pytest.fixture
def list_value():
    return list(range(0,11)) 