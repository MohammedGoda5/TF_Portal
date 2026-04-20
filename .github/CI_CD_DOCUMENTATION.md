# CI/CD Documentation

This document describes the CI/CD workflows configured for the TFPortal project.

## Workflows Overview

### 1. PR Checks (`pr-checks.yml`)
**Triggers:** Pull requests to `main` or `develop` branches

**Purpose:** Validates code changes before merging

**Jobs:**
- Compile the project
- Run unit tests
- Upload test results as artifacts

### 2. Web End-to-End Testing (`web.yml`)
**Triggers:**
- Push to `main` or `develop` branches
- Pull requests to `main` or `develop`
- Manual trigger with browser selection

**Purpose:** Runs automated web tests using Selenium Grid

**Features:**
- Matrix testing across Chrome, Firefox, and Edge
- Selenium Grid with Docker Compose
- Parallel test execution
- Allure report generation
- Test artifact retention (14 days)

**Manual Trigger Options:**
- Browser selection (chrome, firefox, edge, all)

### 3. Scheduled Regression (`scheduled-regression.yml`)
**Triggers:**
- Daily at midnight UTC (cron schedule)
- Manual trigger with environment selection

**Purpose:** Full regression testing suite

**Features:**
- Tests against staging/production environments
- Multiple browser support
- Enhanced retry mechanism (2 attempts)
- Longer artifact retention (30 days)
- Screenshot capture on failure

### 4. Code Quality (`code-quality.yml`)
**Triggers:**
- Push to `main` or `develop`
- Pull requests
- Weekly schedule (Monday 2 AM)

**Jobs:**
- **CodeQL Analysis:** Security vulnerability scanning
- **Dependency Check:** OWASP dependency vulnerability scanning

### 5. Release (`release.yml`)
**Triggers:**
- Git tags starting with 'v'
- Manual trigger with version input

**Purpose:** Creates release packages and GitHub releases

**Output:**
- Packaged source code and JAR files
- GitHub release with auto-generated notes

### 6. Notifications (`notifications.yml`)
**Triggers:** Workflow run completion from other workflows

**Purpose:** Sends notifications on failure

**Channels:**
- Slack (requires `SLACK_WEBHOOK_URL` secret)
- Microsoft Teams (requires `TEAMS_WEBHOOK_URL` secret)

## Dependency Management

### Dependabot (`dependabot.yml`)
**Configuration:**
- Weekly checks on Sundays at 2 AM Cairo time
- Maven dependencies: up to 10 open PRs
- GitHub Actions: up to 5 open PRs
- Grouped updates for dev dependencies

## Required Secrets

Configure these in your repository settings:

| Secret Name | Purpose |
|-------------|---------|
| `SLACK_WEBHOOK_URL` | Slack notifications for failed builds |
| `TEAMS_WEBHOOK_URL` | Microsoft Teams notifications |

## Test Reports

### Allure Reports
Generated reports are available as workflow artifacts:
- Download from the Actions tab
- Extract and open `index.html`
- Retention: 14 days (regression: 30 days)

### Viewing Test Results
1. Go to Actions tab in GitHub
2. Select the workflow run
3. Download artifacts from the bottom of the run summary

## Local Development

To run tests locally:
```bash
# Compile
mvn clean compile

# Run tests
mvn clean test -DheadlessExecution=true

# Generate Allure report
mvn allure:report
```

## Troubleshooting

### Common Issues

1. **Selenium Grid timeout**
   - Check Docker is running
   - Increase wait timeout in workflow

2. **Out of memory during tests**
   - Maven compiler memory settings are configured in pom.xml
   - Adjust `-Xmx` parameters if needed

3. **Flaky tests**
   - Use the retry mechanism: `-DretryMaximumNumberOfAttempts=2`
   - Review test stability and timing issues

## Support

For issues with CI/CD pipelines:
1. Check the Actions tab for detailed logs
2. Review artifact outputs
3. Contact the test automation team
