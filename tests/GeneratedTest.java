const { test, expect } = require('@playwright/test');

test('Login Button Clickability Test', async ({ page }) => {
  await page.goto('http://localhost:8080');
  await page.hover('.login_button');
  await page.click('.login_button');
  await expect(page.locator('.login_page')).toBeVisible();
});

test('Login Form Submission Test', async ({ page }) => {
  await page.goto('http://localhost:8080');
  await page.click('.login_button');
  await page.fill('#username', 'user');
  await page.fill('#password', 'password');
  await page.click('#submit');
  await expect(page.locator('.login_success')).toBeVisible();
});

test('Invalid Login Credentials Test', async ({ page }) => {
  await page.goto('http://localhost:8080');
  await page.click('.login_button');
  await page.fill('#username', 'invalid_user');
  await page.fill('#password', 'invalid_password');
  await page.click('#submit');
  await expect(page.locator('.login_error')).toBeVisible();
};