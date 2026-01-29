import pytest
@pytest.mark.group1
def test_add():
    x=2
    y=3
    assert y+x

@pytest.mark.activity
def test_greater():
    x=2
    y=3
    assert x>y

@pytest.mark.activity
def test_lesser():
    x=2
    y=3
    assert y<x

