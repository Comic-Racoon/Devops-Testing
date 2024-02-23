# Understanding Desired State and Current State in Terraform

* Desired State vs. Current State:
    * Definition:
        * Desired state refers to the configuration specified in Terraform files, representing the ideal infrastructure configuration.
        * Current state refers to the actual state of deployed resources in the cloud environment.
    * Terraform's Functionality:
        * Terraform's primary function is to create, modify, and destroy infrastructure resources to match their desired state.
        * It achieves this by comparing the desired state defined in Terraform configuration files with the current state of resources in the cloud environment.
    
* Example Scenario:
    * Desired State:
        * The desired state represents the infrastructure configuration defined in Terraform files, such as EC2 instance type and image ID.
        * Terraform aims to create, modify, or destroy resources to match this desired state.
    * Current State:
        * The current state reflects the actual state of resources deployed in the cloud environment.
        * It may not always match the desired state due to manual modifications or changes made directly in the cloud environment.
    
* Terraform Plan and Apply:
    * Matching Desired State:
        * Terraform Plan analyzes the current state and desired state to determine the changes required to achieve the desired configuration.
        * Terraform Apply executes these changes, modifying the infrastructure to match the desired state.
        * It ensures that the deployed infrastructure aligns with the configuration specified in Terraform files.

* Practical Demonstration:
    * Creation of EC2 Instance:
        * Terraform creates an EC2 instance based on the desired state specified in the configuration files.
    * Manual Modifications:
        * Manual changes made to the infrastructure, such as stopping the EC2 instance and changing its instance type, result in a different current state.
    * Terraform Update:
        * Running Terraform Plan and Apply after manual modifications updates the infrastructure to match the desired state, restoring the specified configuration.
