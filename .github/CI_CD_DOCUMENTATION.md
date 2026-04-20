# CI/CD Documentation for Test Engineers

Essential workflows for test automation with SHAFT Engine.

## Workflows Overview

### 1. Web End-to-End Testing (`web.yml`)
**Purpose:** Run automated web tests against your application

**Triggers:**
- Push to `main` or `develop` branches
- Pull requests
- Manual trigger with browser selection

**What it does:**
- Starts Selenium Grid (Docker)
- Runs tests in headless mode
- Generates Allure reports
- Uploads test artifacts

**Manual Trigger Options:**
- Browser: chrome, firefox, edge, all

### 2. PR Checks (`pr-checks.yml`)
**Purpose:** Validate test code changes before merging

**Triggers:** Pull requests to `main` or `develop`

**What it does:**
- Compiles the project
- Runs unit tests
- Uploads results for review

### 3. Scheduled Regression (`scheduled-regression.yml`)
**Purpose:** Daily full regression test suite

**Triggers:**
- Daily at midnight UTC (automated)
- Manual trigger

**What it does:**
- Runs complete test suite
- Tests all browsers
- Captures screenshots on failure
- Retains reports for 30 days

## Running Tests

### Via GitHub Actions (Manual)
1. Go to **Actions** tab in your repository
2. Select **Web End-to-End Testing**
3. Click **Run workflow**
4. Select browser and branch
5. Click **Run workflow**

### Local Development
```bash
# Compile
mvn clean compile

# Run tests
mvn clean test -DheadlessExecution=true

# Generate Allure report
mvn allure:serve
```

## Test Reports

### Download Reports
1. Go to Actions → Select workflow run
2. Scroll to **Artifacts** section
3. Download `allure-report-*` or `test-logs-*`

### View Locally
```bash
# Extract and open Allure report
cd allure-report
start index.html  # Windows
open index.html   # Mac
```

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Selenium Grid timeout | Check Docker is running |
| Tests flaky | Increase retry attempts: `-DretryMaximumNumberOfAttempts=2` |
| Out of memory | Adjust in `pom.xml` compiler settings |
| Element not found | Check selectors, add waits |

## Support

- SHAFT Engine Docs: https://shafthq.github.io/
- GitHub Actions logs: Check the **Actions** tab
- Test artifacts: Download from workflow runs
