# Variable Assignment in Terraform

* Introduction
    * Multiple ways to assign values to variables in Terraform
        * Environmental variables
        * Command line flags
        * From file option
        * Variable defaults

* Environmental Variables
    * Example using Windows:
        * Set variable using `setx` command
        * Format: `TF_VAR_variable_name=value`
    * Example using Linux/Mac:
        * Set variable using `export` command
        * Format: `export TF_VAR_variable_name=value`

* Command Line Flags
    * Specify variables directly in the command line using flags
        * Example: `terraform plan -var="variable_name=value"`

* Variable Defaults
    * Default values specified in `variables.tf` file
        * If no explicit value is mentioned, default value is assigned
        * Example:
            * Define variable `instancetype` with default value `t2.micro`

* Using Variables in Terraform
    * Example Scenario with EC2 Instance
        * `ec2_variable.tf` file with hardcoded values
        * Create `variables.tf` file to define variables
        * Reference variables in Terraform code
            * Syntax: `var.variable_name`
    * Execution:
        * `terraform plan`
        * `terraform apply`

* Terraform.tfvars File
    * File containing variable assignments
        * Preferred method in production environments
        * Example:
            * Create `terraform.tfvars` file with variable assignments
            * Format: `variable_name=value`

* Customizing File Name
    * Default filename: `terraform.tfvars`
        * Terraform automatically reads from this file
    * Custom filenames require explicit specification
        * Use `terraform plan -var-file="custom_filename.tfvars"`

* Conclusion
    * Recommended practice: Define variables in `variables.tf`, assign values in `terraform.tfvars`
    * Flexible options for variable assignment provide scalability and ease of maintenance
