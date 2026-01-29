import pytest
@pytest.mark.activity
def test_substring():
    str_1="Hello world"
    str_2="Hello"
    assert str_2 in str_1