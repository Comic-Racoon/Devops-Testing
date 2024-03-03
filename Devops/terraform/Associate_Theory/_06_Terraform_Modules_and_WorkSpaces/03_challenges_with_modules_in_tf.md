# Overriding Variables in Terraform Modules

## Introduction
- Building multiple environments like staging and production requires dynamic configuration
- Hardcoding values in modules makes it difficult to customize environments

## Understanding the Challenge
- Hardcoding values in modules prevents overriding from the destination
- Example: instance type hardcoded as `t2.micro` in module

## Implementing Variable Override
- Define instance type as a variable in the module
- Create a `variables.tf` file in the modules directory
- Assign a default value to the `instance_type` variable (e.g., `t2.micro`)
- Use the variable `var.instance_type` in the resource block
- Override the variable from the destination by explicitly specifying it

## Example Implementation
- Modify `myec2.tf` in the project directory to specify `instance_type = "t2.large"`
- Terraform plan reflects the overridden instance type as `t2.large`

## Conclusion
- Variables in Terraform modules allow for dynamic configuration
- Default values provide flexibility while allowing explicit overrides
- Design modules to balance flexibility and control over configurations
