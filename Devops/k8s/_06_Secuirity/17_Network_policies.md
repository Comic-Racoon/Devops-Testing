Traffic Flow in Kubernetes:
    Overview:
        Traffic flows between components like web server, API server, and database server.
        Ingress: Traffic incoming to a component.
        Egress: Traffic outgoing from a component.

Example Traffic Flow:
    Web Server to API Server:
        Ingress: User request to web server on port 80.
        Egress: Web server request to API server on port 5000.
    API Server to Database Server:
        Ingress: API server request to database server on port 3306.
        Egress: Database server response to API server.

Traffic Rules:
    Ingress Rule: Accept traffic coming into a component.
    Egress Rule: Allow traffic going out from a component.
    Rules are defined based on traffic direction and port numbers.

Network Security in Kubernetes:
    Networking Prerequisite:
        Pods should communicate without additional configuration.
        Kubernetes default: All pods can communicate with each other.
    Network Policies:
        Object in Kubernetes for defining network rules.
        Allow or block traffic based on rules.
        Applied to specific pods using labels and selectors.

Applying Network Policies:
    Creating a Network Policy:
        Define ingress or egress rules based on requirements.
        Use labels and selectors to apply policies to specific pods.
    Example: DB Pod Network Policy:
        Only allow ingress traffic from API pod on port 3306.

Implementation:
    Define network policy rules in an object definition file.
    Use labels and selectors to apply policies to specific pods.
    Apply the network policy using kubectl create command.

Notes:
    Network policies are enforced by the network solution in use.
    Not all network solutions support network policies.
    Check documentation for network solution support.
    Policies can be created even if not supported but won't be enforced.