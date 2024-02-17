Generating Certificates

    Using OpenSSL
        Create CA Private Key
            openssl genrsa -out ca.key
        Generate Certificate Signing Request (CSR)
            openssl req -new -key ca.key -out ca.csr
            Specify Common Name (CN) as Kubernetes-CA
        Sign Certificate
            openssl x509 -req -in ca.csr -signkey ca.key -out ca.crt
    Generating Client Certificates
        Admin User
            Create Private Key
                openssl genrsa -out admin.key
            Generate CSR
                openssl req -new -key admin.key -out admin.csr
                Specify CN as Kube Admin
            Sign Certificate
                openssl x509 -req -in admin.csr -CA ca.crt -CAkey ca.key -out admin.crt
        Other Components (e.g., kube-scheduler, kube-controller-manager, kube-proxy)
            Follow similar process as Admin User
    Server-Side Certificates
        ETCD Server
            Name: ETCD-server
            Additional peer certificates for HA setup
            Specify keys while starting ETCD server
        Kube API Server
            Name: Kube-API-server
            Include alternate names in OpenSSL config file
            Sign with CA certificate and key
            Specify names in certificate for various aliases
        Kubelets Server
            Name: Node0X (e.g., Node01, Node02)
            Generate for each node
            Include in kubelet config file
            Specify group name as System Nodes for permissions

Certificate Usage

    Managing the Cluster
        Use certificates in REST API calls
        Utilize kubeconfig file for configuration
    Configuration
        Specify CA file for verification
        Provide API server certificates
        Specify client certificates for API server to connect to ETCD and kubelets
        Include kubelet node certificates
    Naming and Authentication
        Ensure correct naming format for nodes
        Add nodes to System Nodes group for permissions