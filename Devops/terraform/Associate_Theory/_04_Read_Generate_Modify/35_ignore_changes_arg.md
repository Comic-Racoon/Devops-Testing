* **Understanding the ignore_changes Argument in Terraform**

  * **Introduction**
    * The `ignore_changes` argument, used within the Lifecycle block in Terraform, allows users to ignore specific attribute changes made to infrastructure objects outside of Terraform.
    * It is particularly useful in scenarios where certain configurations of resources, such as EC2 instances, are modified manually or by external processes.

  * **Key Points to Note**
    * The `ignore_changes` argument allows users to selectively ignore changes to specific attributes of resources, preventing Terraform from reverting them during plan or apply operations.
    * Users can specify individual attributes or use the `all` keyword to ignore all changes, providing flexibility in managing configurations.
    * Terraform will create and destroy remote objects if necessary but will not propose updates to them, even if the configuration is modified, ensuring consistency in production environments.

  * **Conclusion**
    * Understanding and utilizing the `ignore_changes` argument in Terraform enhances flexibility and control over resource management, particularly in scenarios where manual or external modifications to resource configurations need to be accommodated.

---


### ignore-changes.tf (Base Code)

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
### ignore-changes.tf (Manual Added Attribute List)

```sh
provider "aws" {
  region     = "us-east-1"
}

resource "aws_instance" "myec2" {
    ami = "ami-0f34c5ae932e6f0e4"
    instance_type = "t2.micro"

    tags = {
        Name = "HelloWorld"
    }

    lifecycle {
      ignore_changes = [tags,instance_type]
    }

}
```


### ignore-changes.tf (Using ALL)

```sh
provider "aws" {
  region     = "us-east-1"
}

resource "aws_instance" "myec2" {
    ami = "ami-0f34c5ae932e6f0e4"
    instance_type = "t2.micro"

    tags = {
        Name = "HelloWorld"
    }

    lifecycle {
      ignore_changes = all
    }

}
```