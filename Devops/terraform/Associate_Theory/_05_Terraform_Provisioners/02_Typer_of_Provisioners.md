# Terraform Provisioners

* Overview
  * Terraform provisioners are a key feature that sets Terraform apart from other infrastructure as code tools.
  
* Purpose
  * Execute scripts on local or remote machines during resource creation or destruction.
  
* Example Scenario
  * When creating an EC2 instance with Terraform, it's not enough to just provision the instance; often, additional configuration steps are needed, such as installing and configuring software like Nginx or Apache.

* Demo
  * Creating an EC2 instance and automatically installing Nginx using provisioners.
  
  * Code Example:
    ```terraform
    resource "aws_instance" "example" {
      ami           = "ami-0c55b159cbfafe1f0"
      instance_type = "t2.micro"
      key_name      = "terraform"
      
      provisioner "remote-exec" {
        inline = [
          "sudo yum install -y nginx",
          "sudo systemctl start nginx"
        ]
      }
    }
    ```

  * Execution Steps:
    1. Apply Terraform configuration.
    2. Terraform creates EC2 instance.
    3. Terraform connects to the instance via SSH.
    4. Executes provisioner scripts to install and start Nginx.
    
  * Result:
    * EC2 instance created successfully.
    * Nginx installed and running on the instance.
  
  * Verification:
    * Access EC2 instance's public IP in a browser.
    * Default Nginx page should be visible.
    
* Conclusion
  * Terraform provisioners enable automation of application configuration alongside resource creation, providing a seamless end-to-end solution for infrastructure management.

* Some more Types Of provisioners are :
    * chef
    * connection
    * file
    * habitat
    * null_resource
    * salt-masterless
    * local-exec
    * Remote-exec