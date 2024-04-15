# Prometheus Basics

## What is Prometheus?
- **Definition**: Prometheus is an open-source monitoring tool designed to collect metrics data and provide visualization and alerting capabilities.
- **Features**:
  - Collects metrics data.
  - Visualizes collected data.
  - Generates alerts based on user-specified thresholds.
- **Data Collection**: Prometheus collects metrics by scraping targets that expose metrics through an HTTP endpoint.
- **Storage**: Scraped metrics are stored in a time series database.
- **Query Language**: Prometheus provides a built-in query language called PromQL for querying the stored metrics.

## Types of Metrics Monitored
Prometheus can monitor various types of metrics including:
- CPU/Memory Utilization
- Disk space
- Service Uptime
- Application-specific data:
  - Number of exceptions
  - Latency
  - Pending Requests

## Data Type for Monitoring
Prometheus is designed to monitor time-series data that is numeric in nature.

## Data Not Monitored by Prometheus
Prometheus is not suitable for monitoring the following types of data:
- Events
- System logs
- Traces

Prometheus focuses on collecting and analyzing time-series numeric data for effective monitoring and alerting.
