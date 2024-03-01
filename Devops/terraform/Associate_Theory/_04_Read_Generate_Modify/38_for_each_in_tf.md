* **Understanding For_each Interaction in Terraform**

  * **Advantages Over Count**
    * Utilizes a map or set as an index for created resources.
    * Provides flexibility and simplicity, especially when adding new elements.
    * Resource address is directly mapped to the element name in the set.

  * **Practical Example: Creating IAM Users**
    * Instead of using count, a set is used to define IAM user names.
    * IAM users are created with names based on set elements.
    * Adding or removing elements from the set does not affect other resources.

  * **Usage Considerations**
    * `for_each` is beneficial when resources require distinct values.
    * Provides a more intuitive way to manage resources compared to count.

  * **Example: Creating EC2 Instances**
    * Demonstrates how to use `for_each` with a map to create multiple instances with different configurations.
    * Each instance is identified by a unique key in the map.
    * Allows for the creation of multiple instances with varying attributes in a concise manner.

  * **Each Object**
    * Within the `for_each` block, an `each` object is available.
    * Contains two attributes: `each.key` and `each.value`.
    * `each.key` represents the key of the current element in the map or set.
    * `each.value` represents the value associated with the current key.

  * **Conclusion**
    * Leveraging `for_each` provides greater flexibility and control over resource creation compared to `count`.
    * Enables the creation of resources with distinct attributes using sets or maps as index values.
    * Understanding the `each` object is essential for effectively working with `for_each` in Terraform.

---


### Example 1 - IAM User
```sh
provider "aws" {
  region     = "us-west-2"
  access_key = ""
  secret_key = ""
}

resource "aws_iam_user" "iam" {
  for_each = toset( ["user-01","user-02", "user-03"] )
  name     = each.key
}
```

### Example 2 - EC2 Instance
```sh
resource "aws_instance" "myec2" {
  ami = "ami-0cea098ed2ac54925"
  for_each  = {
      key1 = "t2.micro"
      key2 = "t2.medium"
   }
  instance_type    = each.value
  key_name         = each.key
  tags =  {
   Name = each.value
    }
}
```