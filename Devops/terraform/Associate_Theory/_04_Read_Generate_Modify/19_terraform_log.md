# Terraform Debugging with TF_LOG

## Introduction
- Terraform provides detailed logs that can be enabled using the TF_LOG environment variable.
- TF_LOG can be set to different log levels (TRACE, DEBUG, INFO, WARN, ERROR) to control verbosity.

## Purpose of Debugging
- Debugging helps diagnose issues with Terraform configurations or binary.
- Enables detailed inspection of Terraform actions and errors.

## Enabling Detailed Logs
1. Set the TF_LOG environment variable to the desired log level (e.g., TRACE).
2. Run Terraform commands to generate detailed logs.

## Practical Demonstration
- Example: Using a simple Terraform configuration to create an EC2 instance.
- Without TF_LOG, minimal output is generated.
- With TF_LOG=TRACE, extensive logs are produced, showing detailed Terraform actions and information.

## Output Management
- Logs can be overwhelming on the terminal.
- Use TF_LOG_PATH to store logs in a specific file for easier analysis.
- Example: Export TF_LOG_PATH to a file (/tmp/terraform-crash.log) to store detailed logs.

## Conclusion
- TF_LOG is a powerful tool for debugging Terraform configurations and troubleshooting issues.
- By enabling detailed logs, users can gain insights into Terraform's actions and diagnose errors effectively.
- Remember to manage log output to avoid cluttering the terminal and facilitate analysis.

---
