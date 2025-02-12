# Dockerfile: CMD vs ENTRYPOINT

## **Overview**

In a Dockerfile, both `CMD` and `ENTRYPOINT` define how a container should run, but they serve different purposes.

### **Key Differences:**

1. **CMD (Command):**

   - Provides default arguments for the container at runtime.
   - Can be overridden when running the container using command-line arguments.
   - Only the last `CMD` instruction in a Dockerfile takes effect.

2. **ENTRYPOINT:**

   - Defines the executable that runs when the container starts.
   - Cannot be easily overridden using command-line arguments.
   - Ensures that the container always runs a specific application.

---

## **Example 1: Using CMD**

```dockerfile
FROM ubuntu
CMD ["echo", "Hello, world!"]
```

#### **Behavior:**

- Running the container:
  ```sh
  docker run myimage
  ```
  Output: `Hello, world!`
- Overriding the command:
  ```sh
  docker run myimage ls
  ```
  Output: List of files in the container.

---

## **Example 2: Using ENTRYPOINT**

```dockerfile
FROM ubuntu
ENTRYPOINT ["echo", "Hello"]
```

#### **Behavior:**

- Running the container:
  ```sh
  docker run myimage
  ```
  Output: `Hello`
- Overriding:
  ```sh
  docker run myimage world!
  ```
  Output: `Hello world!`

---

## **Example 3: Combining ENTRYPOINT and CMD**

```dockerfile
FROM ubuntu
ENTRYPOINT ["ping"]
CMD ["-c", "4", "google.com"]
```

#### **Behavior:**

- Running the container:
  ```sh
  docker run myimage
  ```
  Equivalent to:
  ```sh
  ping -c 4 google.com
  ```
- Overriding CMD:
  ```sh
  docker run myimage -c 2 example.com
  ```
  Equivalent to:
  ```sh
  ping -c 2 example.com
  ```

---

# **Real-World Example: Running a Web Server**

## **1️⃣ Using CMD: Flexible Default Command**

```dockerfile
FROM nginx:latest
CMD ["nginx", "-g", "daemon off;"]
```

### **Behavior:**

- Running the container:
  ```sh
  docker run mynginx
  ```
  Runs `nginx -g "daemon off;"`
- Overriding at runtime:
  ```sh
  docker run mynginx nginx -t
  ```
  Runs `nginx -t` (to test the Nginx configuration).

## **2️⃣ Using ENTRYPOINT: Enforcing Nginx Execution**

```dockerfile
FROM nginx:latest
ENTRYPOINT ["nginx"]
CMD ["-g", "daemon off;"]
```

### **Behavior:**

- Running the container:
  ```sh
  docker run mynginx
  ```
  Equivalent to:
  ```sh
  nginx -g "daemon off;"
  ```
- Overriding at runtime:
  ```sh
  docker run mynginx -t
  ```
  Equivalent to:
  ```sh
  nginx -t
  ```

## **3️⃣ Mixing ENTRYPOINT and CMD for a Dynamic Script**

```dockerfile
FROM ubuntu
COPY start.sh /start.sh
RUN chmod +x /start.sh
ENTRYPOINT ["/start.sh"]
CMD ["default-arg"]
```

### **start.sh**

```sh
#!/bin/bash
echo "Starting application with argument: $@"
```

### **Behavior:**

- Default execution:
  ```sh
  docker run myapp
  ```
  Output:
  ```
  Starting application with argument: default-arg
  ```
- Overriding at runtime:
  ```sh
  docker run myapp custom-arg
  ```
  Output:
  ```
  Starting application with argument: custom-arg
  ```

---

## **Summary**

| Scenario                           | CMD | ENTRYPOINT |
| ---------------------------------- | --- | ---------- |
| Running a flexible Nginx           | ✅   | ❌          |
| Ensuring Nginx always runs         | ❌   | ✅          |
| Running a script with default args | ✅   | ✅          |

### **When to Use What?**

- **Use **`` when you want a **default** command that can be changed easily.
- **Use **`` when you want a **fixed command** that always runs.
- **Combine both** when you want a **fixed base command** with **modifiable arguments**.

---

### **📌 Author**

Created for Docker beginners and developers exploring CMD vs. ENTRYPOINT. 🚀

