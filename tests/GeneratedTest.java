const { test, expect } = require('@playwright/test');

test('Facebook Login Test Case', async ({ page }) => {
  await page.goto('https://www.facebook.com/');
  await page.fill('#email', 'user@example.com');
  await page.fill('#pass', 'password123');
  await page.click('#login_button');
  await expect(page.locator('#login_success_message')).toBeVisible();
  await expect(page.locator('#profile_picture')).toBeVisible();
});

test('Invalid Facebook Login Test Case', async ({ page }) => {
  await page.goto('https://www.facebook.com/');
  await page.fill('#email', 'wrong_email@example.com');
  await page.fill('#pass', 'wrong_password');
  await page.click('#login_button');
  await expect(page.locator('#login_error_message')).toBeVisible();
});

test('Facebook Logout Test Case', async ({ page }) => {
  await page.goto('https://www.facebook.com/');
  await page.fill('#email', 'user@example.com');
  await page.fill('#pass', 'password123');
  await page.click('#login_button');
  await page.click('#logout_button');
  await expect(page.locator('#login_button')).toBeVisible();
});