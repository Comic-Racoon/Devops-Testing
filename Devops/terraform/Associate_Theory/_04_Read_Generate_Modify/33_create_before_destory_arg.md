* **Understanding Create Before Destroy Argument in Terraform**

  * **Introduction**
    * The `create_before_destroy` argument under the Lifecycle block in Terraform allows customization of resource lifecycle management.
    * It ensures that the replacement object is created before the prior object is destroyed, providing flexibility and control over resource updates.

  * **Default Resource Behavior**
    * By default, when Terraform changes a resource attribute that cannot be updated in place due to remote API limitations, it destroys the existing object and creates a new replacement object.
    * This default behavior may not always be desirable, especially in production environments where uninterrupted availability is crucial.

  * **Practical Demonstration**
    * Demonstrated the default behavior by modifying the AMI ID of an EC2 instance using Terraform.
    * Observed that Terraform first destroys the existing instance and then creates a new instance with the updated configuration.

  * **Create Before Destroy Argument**
    * `create_before_destroy` argument under the Lifecycle block alters the default behavior by ensuring that the replacement object is created before the prior object is destroyed.
    * This can be crucial in production environments where uninterrupted availability is required during resource updates.

  * **Implementation**
    * Added the `create_before_destroy` argument under the Lifecycle block in the Terraform configuration to demonstrate the modified workflow.
    * Verified the workflow by modifying the AMI ID again and observing that the new instance is created before the old instance is destroyed.

  * **Conclusion**
    * Understanding the `create_before_destroy` argument provides insight into resource lifecycle management customization in Terraform.
    * Utilizing this argument offers flexibility and control over resource updates, especially in production environments where uninterrupted availability is essential.

---

### create-before-destroy.tf (Base Code)
```sh
provider "aws" {
  region     = "us-east-1"
}

resource "aws_instance" "myec2" {
    ami = "ami-0f34c5ae932e6f0e4"
    instance_type = "t2.micro"

    tags = {
        Name = "HelloEarth"
    }
}
```
### create-before-destroy.tf (Final Code)
```sh
provider "aws" {
  region     = "us-east-1"
}

resource "aws_instance" "myec2" {
    ami = "ami-0f34c5ae932e6f0e4"
    instance_type = "t2.micro"

    tags = {
        Name = "HelloEarth"
    }

    lifecycle {
      create_before_destroy = true
    }
}
```