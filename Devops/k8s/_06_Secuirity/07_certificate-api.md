    Initial Certificate Setup:
        A CA server was set up to generate a pair of key and certificate files.
        Certificates were generated for various components in the cluster, including an admin certificate for the initial cluster administrator.

    Adding a New Admin:
        A new administrator joined the team and required access to the cluster.
        The new admin created a private key and generated a certificate signing request (CSR).
        The CSR was sent to the cluster administrator.
        The cluster administrator, being the only admin, signed the CSR using the CA server's private key and root certificate, thereby generating a certificate for the new admin.

    Certificate Rotation:
        Certificates have a validity period and need to be rotated when they expire.
        The process involves generating a new CSR and getting it signed by the CA server.

    CA Server in Kubernetes Setup:
        The CA server is essentially a pair of key and certificate files generated and stored securely.
        In the Kubernetes setup, these files are typically stored on the master node, making it the CA server.
        Tools like kubeadm also create and store CA files on the master node.

    Introduction of Certificates API:
        Kubernetes offers a certificates API for automated management of certificates, signing requests, and rotation.
        With the certificates API, certificate signing requests can be sent directly to Kubernetes through an API call.
        Administrators can review and approve signing requests using kubectl commands.

    Controller Manager Responsibility:
        All certificate-related operations in the Kubernetes control plane are handled by the Controller Manager.
        Specifically, controllers such as CSR-Approving and CSR-Signing within the Controller Manager are responsible for approving and signing certificate signing requests.

    Access to CA Key Pairs:
        Any component or entity needing to sign certificates requires access to the CA server's root certificate and private key.

Overall, the process involves generating, managing, and rotating certificates securely within the Kubernetes cluster, with the Controller Manager playing a key role in certificate-related operations.
