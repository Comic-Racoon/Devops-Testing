Notes on Ingress in Kubernetes

    Introduction
        Explanation on the differences between services and ingress.
        Brief overview of addressing services and pods.

    Scenario: Deploying an Application
        Deployment of an application for an online store.
        Use of services (cluster IP and node port) for accessibility.
        Configuration of DNS server to simplify URL access.

    Cloud Environment Considerations
        Use of load balancer type service in cloud environments.
        Automatic provisioning of network load balancer (GCP example).

    Scaling and Complexity
        Introduction of new services and need for load balancing.
        Challenges with multiple load balancers and SSL configuration.
        Desire for centralized management within Kubernetes.

    Introduction to Ingress
        Definition of Ingress and its purpose.
        Comparison with traditional load balancers.
        Native integration within Kubernetes.

    Deployment of Ingress Controller
        Selection of Ingress controller (e.g., Nginx).
        Deployment of Ingress controller as a Kubernetes deployment.
        Configuration via deployment file, config map, and service account.

    Configuration of Ingress Resources
        Creation of Ingress resources using definition files.
        Definition of backend services for traffic routing.
        Differentiation based on URL paths and domain names.
        Explanation of rules and host fields.

    Comparing Traffic Splitting Methods
        Comparison of URL-based and host-based traffic splitting.
        Analysis of rule structures for different scenarios.

