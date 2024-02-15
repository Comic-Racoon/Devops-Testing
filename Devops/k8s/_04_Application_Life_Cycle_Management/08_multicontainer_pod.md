    Benefits:
        Enables development and deployment of independent, small, and reusable code.
        Facilitates scalability, modification, and maintenance of individual services.

    Working Together:
        Despite independence, sometimes services need to collaborate (e.g., web server and logging service).
        Need one agent instance per web server instance.
        Services should remain separate for development and deployment purposes.
        Multi-container pods facilitate cooperation while maintaining independence.

    Characteristics of Multi-container Pods:
        Containers share the same lifecycle (created and destroyed together).
        Share the same network space (can refer to each other as localhost).
        Access to the same storage volumes.

    Creating Multi-container Pods:
        Update pod definition file to include information about additional container.
        Container section under the spec section is an array, allowing multiple containers.
        Example: Add a new container named log agent to the existing pod definition file.

By leveraging multi-container pods, services can collaborate effectively while remaining independently developed and deployed. This approach streamlines communication and resource sharing between related components without the need for complex configurations.