
# Running Selenium Tests in Docker: Step-by-Step Guide

## Introduction

This guide documents the process of setting up and running Selenium tests using Docker and Selenium Grid. It explains each step, why it is necessary, and how to troubleshoot common issues.

## Steps:

1. Setting up `docker-compose.yml` 
2. Running the containers
3. Connecting tests to Selenium Grid

## Setting up Selenium Grid in Docker:

Step 1: Create a docker-compose.yml file and define the Selenium Grid hub, Chrome nodes as well as test-runner container. 
Step 2: Start Selenium Grid and Nodes

Run the following command:

`docker-compose up -d`

This starts:

    1. selenium-hub on port 4444
    2. A Chrome browser node registered to the hub
    3. A container for running your test cases

#### To check if the hub is running:

> curl http://localhost:4444/status  [ If ready: true, Selenium Grid is up and running.]

## Running Tests on Dockerized Selenium Grid.

Modify your test setup to use RemoteWebDriver:

public void setup() throws MalformedURLException {

    String remoteUrl = "http://localhost:4444/wd/hub";
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setBrowserName("chrome");
    this.driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);

}

## Run Tests Inside the Container

Execute: `docker-compose up --exit-code-from test-runner`

This runs the tests inside the test-runner container and exits when done.








