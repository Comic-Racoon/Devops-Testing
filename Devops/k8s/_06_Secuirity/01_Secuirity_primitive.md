    Host Security:
        Secure access to cluster hosts by disabling root access and password-based authentication.
        Utilize SSH key-based authentication for access to hosts.
        Implement additional security measures to safeguard physical or virtual infrastructure hosting Kubernetes.

    Authentication Mechanisms:
        Define who can access the cluster through authentication mechanisms.
        Options include user IDs/passwords, tokens, certificates, and integration with external providers like LDAP.
        Service accounts are created for machines accessing the cluster.

    Authorization Mechanisms:
        Control user permissions and actions within the cluster through authorization mechanisms.
        Implement role-based access controls (RBAC) where users are associated with groups and specific permissions.
        Explore additional authorization modules like attribute-based access control, Node authorizers, and webhooks.

    TLS Encryption:
        Secure communication between cluster components (e.g., etcd cluster, kube-controller-manager, scheduler, API server, Kubelet, kube-proxy) using TLS encryption.
        Detailed configuration of TLS certificates between components ensures secure communication channels.

    Network Policies:
        Control communication between applications within the cluster using network policies.
        By default, all pods can access each other, but network policies allow for fine-grained control over network traffic.
        Implementation details of network policies will be covered in subsequent lectures.

These security primitives form the foundation for ensuring the security of a Kubernetes cluster. By implementing robust authentication, authorization, encryption, and network policies, administrators can mitigate risks and protect sensitive data and resources within the cluster. Further exploration and detailed configuration of these security mechanisms will be covered in upcoming lectures.