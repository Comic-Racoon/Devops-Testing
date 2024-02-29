* **Saving Terraform Plan to File**
  * After generating a Terraform plan, it can be saved to a specific file path.
  * The saved plan can be later used with "terraform apply" to ensure only the planned changes are applied.

* **Example Syntax**
  * Use "terraform plan" followed by "out" to specify the file path where the plan will be saved.

* **Practical Demonstration**
  * In today's demonstration, we have a simple Terraform configuration:
    ```hcl
    provider "aws" {
      region = "us-west-2"
    }

    resource "aws_instance" "example" {
      ami           = "ami-0c55b159cbfafe1f0"
      instance_type = "t2.micro"
    }
    ```

  * **Terraform Plan**
    * Executing `terraform plan` confirms creation of 1 EC2 instance of type t2.micro.

  * **Saving Plan to File**
    * Use `-out=demopath` to save the plan to a file named "demopath".
    * Message confirms plan was saved to "demopath".

  * **Using Saved Plan**
    * Despite changes in Terraform configuration, the saved plan can be applied to ensure consistency.
    * Execute `terraform apply demopath` to apply the saved plan.

  * **Applying Plan**
    * Terraform applies the plan from the file, creating the EC2 instance as planned.

  * **Cleanup**
    * After testing, resources can be destroyed using `terraform destroy`.

This process ensures that even with changes in Terraform configurations, the planned changes can be consistently applied using the saved plan file.
