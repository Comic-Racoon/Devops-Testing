Requirements Clarification:
    Goal: Protect the database pod, allowing access only from the API pod on port 3306.
    No concern about the web or API pods' traffic; allow all traffic to/from those pods.
    Create a network policy (db-policy) to enforce these rules.

Blocking All Traffic to Database Pod:
    Create a network policy (db-policy) associated with the database pod.
    Use pod selector with match labels to block all traffic to/from the database pod.

Defining Ingress Policy:
    Ingress Policy: Allow incoming traffic from the API pod.
    Single network policy can have ingress, egress, or both; in this case, only ingress is needed.
    Use ingress section to define rules.
    Each rule has from and ports fields.
    Define from the API pod to the database pod on port 3306.

Handling Multiple API Pods in Different Namespaces:
    Add namespaceSelector along with podSelector to restrict access to the API pod in the desired namespace.
    Ensure the namespace has the required label for proper selection.

Allowing Traffic from External Backup Server:
    Use ipBlock selector for IP address ranges.
    Specify the IP address of the backup server.
    Add ingress rule to allow traffic from the backup server to the database pod.

Egress Policy:
    Egress Policy: Allow outgoing traffic from the database pod.
    Add egress section to define rules.
    Use to field to specify destinations.
    Define egress rule to allow traffic from the database pod to an external backup server on port 80.

Example Implementation:
    Configure network policy (db-policy) to block all traffic except from the API pod and to the backup server.
    Use selectors and labels for pod and namespace filtering.
    Ensure proper configuration for ingress and egress rules based on traffic requirements.

