* **Understanding the prevent_destroy Argument in Terraform**

  * **Introduction**
    * The `prevent_destroy` argument, when used under the Lifecycle block in Terraform, prevents the destruction of a resource when commands like `terraform destroy` are executed.
    * This argument serves as a safety measure against accidental deletion of critical resources, especially in production environments.

  * **Key Points to Note**
    * The `prevent_destroy` argument provides a safety measure against accidental deletion of critical resources, such as database instances, which may be costly to reproduce.
    * This setting must be present in the configuration for the protection to apply. Removing the resource block entirely would allow the remote object to be destroyed.
    * It is crucial to ensure that this setting is used judiciously, considering the implications on resource management and workflow.

  * **Conclusion**
    * Understanding and utilizing the `prevent_destroy` argument in Terraform can enhance resource management and mitigate risks associated with accidental resource deletion, particularly in production environments.

---


### prevent-destroy.tf (Base Code)

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

### prevent-destroy.tf (Final Code)

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
      prevent_destroy = true
    }
}
```
