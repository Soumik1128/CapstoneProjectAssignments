import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
import os
import time

# Fixture for WebDriver setup and teardown
@pytest.fixture(scope="module")
def driver():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()

# Generic function to validate checkbox state
def validate_checkbox(driver, checkbox, expected_state):
    actual_state = checkbox.is_selected()
    assert actual_state == expected_state, f"Expected {expected_state}, but got {actual_state}."

# Test 1: Verify the title of the page
def test_verify_page_title(driver):
    driver.get("http://the-internet.herokuapp.com/")
    assert driver.title == "The Internet", "Page title does not match."

# Test 2: Click on Checkboxes link and validate checkbox states
def test_checkboxes(driver):
    driver.find_element(By.LINK_TEXT, "Checkboxes").click()
    text_element = driver.find_element(By.TAG_NAME, "h3")
    assert text_element.text == "Checkboxes", f"Unexpected text: {text_element.text}"

    checkboxes = driver.find_elements(By.CSS_SELECTOR, "input[type='checkbox']")
    validate_checkbox(driver, checkboxes[0], expected_state=False)  # Checkbox 1 should not be checked
    validate_checkbox(driver, checkboxes[1], expected_state=True)   # Checkbox 2 should be checked
    driver.back()

# Test 3: Click on File Upload link and upload a file
def test_file_upload(driver):
    driver.find_element(By.LINK_TEXT, "File Upload").click()
    text_element = driver.find_element(By.TAG_NAME, "h3")
    assert text_element.text == "File Uploader", f"Unexpected text: {text_element.text}"

    # Locate the file input and upload button
    file_input = driver.find_element(By.ID, "file-upload")
    upload_button = driver.find_element(By.ID, "file-submit")

    # Get a sample file path and upload
    sample_file_path = os.path.abspath("sample.txt")
    with open("sample.txt", "w") as file:
        file.write("This is a sample file for upload testing.")

    file_input.send_keys(sample_file_path)
    upload_button.click()
    time.sleep(4)

    # Verify upload success message
    success_message = driver.find_element(By.TAG_NAME, "h3").text
    assert success_message == "File Uploaded!", f"Unexpected success message: {success_message}"

    # # Cleanup sample file
    # os.remove("sample.txt")
