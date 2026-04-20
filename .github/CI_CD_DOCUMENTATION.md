# CI/CD Documentation for Test Engineers

Essential workflows for test automation with SHAFT Engine.

## VPN Requirement Notice ⚠️

**IMPORTANT:** The target website requires Sophos SSL VPN connection.

### CI/CD Options

Since Sophos VPN requires proprietary authentication, here are your options:

#### Option 1: Self-Hosted Runner (Recommended)
Run GitHub Actions on a machine already connected to VPN:

1. Set up a machine (physical or VM) with:
   - VPN already connected
   - Docker installed
   - Java 21 installed

2. Install GitHub Actions runner:
   ```bash
   # Download runner from GitHub repository Settings > Actions > Runners
   # Follow setup instructions
   ```

3. Update workflow to use self-hosted runner:
   ```yaml
   runs-on: self-hosted
   ```

#### Option 2: Local Testing Only
Skip CI for VPN-protected sites, run tests locally:

```bash
# Ensure VPN is connected
mvn clean test -DheadlessExecution=true
```

#### Option 3: VPN Gateway Proxy
Set up a VPN gateway that CI can route through:
- Configure a bastion host with VPN
- Route CI traffic through the proxy
- Requires IT/Network team setup

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

**Note:** Requires VPN connection. See options above.

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

## Running Tests Locally (Recommended)

Since the site requires VPN, run tests locally:

### Prerequisites
1. Connect to Sophos SSL VPN
2. Install Java 21
3. Install Maven

### Run Tests
```bash
# Compile
mvn clean compile

# Run all tests
mvn clean test -DheadlessExecution=true

# Run specific test class
mvn clean test -Dtest=APTests

# Generate Allure report
mvn allure:serve
```

## Test Reports

### Generate Locally
```bash
# After test run
mvn allure:report

# Open report
cd allure-report
start index.html
```

### CI Artifacts
If using self-hosted runner:
1. Go to Actions → Select workflow run
2. Download `allure-report-*` artifact
3. Extract and view `index.html`

## Setup for CI with VPN

### Using Self-Hosted Runner

1. **Prepare Machine:**
   ```bash
   # Windows Machine with VPN
   - Install Sophos SSL VPN Client
   - Connect VPN
   - Install Docker Desktop
   - Install Java 21
   - Install Maven
   ```

2. **Add Runner to Repository:**
   - GitHub Repo → Settings → Actions → Runners
   - Click "New self-hosted runner"
   - Follow OS-specific instructions
   - Start the runner: `./run.sh`

3. **Update Workflows:**
   Change `runs-on: ubuntu-latest` to `runs-on: self-hosted`

### Environment Variables

Create `.github/variables.env`:
```bash
BASE_URL=https://your-vpn-site.com
VPN_REQUIRED=true
```

## Troubleshooting

| Issue | Solution |
|-------|----------|
| Site not reachable | Verify VPN is connected |
| Selenium Grid timeout | Check Docker is running |
| Tests flaky | Increase retry attempts |
| SSL certificate error | Import VPN cert to Java keystore |

## Support

- SHAFT Engine: https://shafthq.github.io/
- GitHub Actions: Check the Actions tab for logs
