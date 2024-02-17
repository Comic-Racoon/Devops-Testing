    Cluster Roles and Cluster Role Bindings:
        Namespaced vs. Cluster-Scoped Resources:
            Namespaced resources are confined within namespaces.
            Cluster-scoped resources are not associated with any namespace.
            Examples of namespaced resources: pods, replica sets, services.
            Examples of cluster-scoped resources: nodes, persistent volumes.

    Authorization for Cluster-Scoped Resources:
        Cluster Roles:
            Similar to roles but for cluster-scoped resources.
            Used to define permissions for cluster-wide operations.
            Examples include cluster admin, storage admin roles.
            Create a cluster role definition file specifying rules for resources.
            Use kubectl create clusterrole to create the cluster role.

    Linking Users to Cluster Roles:
        Cluster Role Bindings:
            Objects linking users to cluster roles.
            Name them appropriately (e.g., "Cluster Admin Role Binding").
            Specify user details in the subjects section.
            Provide details of the cluster role in the roleRef section.
            Use kubectl create clusterrolebinding to create the cluster role binding.

    Usage and Considerations:
        Cluster roles and bindings are for cluster-wide resources.
        Users authorized with cluster roles have access across the entire cluster.
        Cluster roles can also be used for namespaced resources, granting access across all namespaces.
        Kubernetes sets up default cluster roles during cluster initialization.