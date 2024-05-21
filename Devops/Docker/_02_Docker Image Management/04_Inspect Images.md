# Inspecting Docker Images

Docker images are composed of multiple layers. We will discuss some high-level commands to inspect these images, including viewing the image layers and detailed configuration.

## Commands to Inspect Docker Images

1. **Viewing Image List**

    - **Command:** `docker image ls`
    - **Description:** Lists all available Docker images along with their IDs.

2. **Viewing Image History**

    - **Command:** `docker image history <image_name>`
    - **Description:**
        - Displays all the layers that make up a particular image.
        - Shows the commands used to create each layer.
        - **Use Case:** Useful for exploring the construction of an existing image when the Dockerfile is not available.

3. **Inspecting Image Details**

    - **Command:** `docker image inspect <image_name>`
    - **Description:**
        - Provides detailed information about the image in JSON format.
        - **Details Included:**
            - Configuration specified in the Dockerfile.
            - Parent or base image used.
            - Environment variables.
            - Exposed ports.
            - Volumes.
            - Entry points.
            - Physical and virtual size of the image.
        - **Filtering Output with JSONPath:**
            - JSONPath expressions can be used to filter the JSON output.
            - **Syntax:** `docker image inspect -f "{{ jsonpath_expression }}" <image_name>`

4. **JSONPath Expressions for Filtering**

    - **Overview:** JSONPath is a way to extract specific parts of a JSON document.
    - **Examples:**
        - **Retrieving the OS:**
            - **Command:** `docker image inspect -f "{{ .Os }}" <image_name>`
        - **Retrieving the Architecture:**
            - **Command:** `docker image inspect -f "{{ .Architecture }}" <image_name>`
        - **Combining Outputs:**
            - **Command:** `docker image inspect -f "OS: {{ .Os }}, Architecture: {{ .Architecture }}" <image_name>`
        - **Retrieving Exposed Ports:**
            - **Command:** `docker image inspect -f "{{ .ContainerConfig.ExposedPorts }}" <image_name>`

## Learning JSONPath

- **Resource:** Introductory course on JSONPath available on our site.
- **Description:** Short course with hands-on exercises to help develop skills for creating JSONPath expressions.

By using these commands and JSONPath expressions, you can effectively inspect and understand the details of Docker images, making it easier to manage and utilize them in your projects.
