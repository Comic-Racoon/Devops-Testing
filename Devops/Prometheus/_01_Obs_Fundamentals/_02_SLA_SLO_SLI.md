# SLI/SLO/SLA in System Design

When designing systems or applications, it's crucial for teams to establish specific, measurable targets/goals to strike the right balance between product development and operational work. These targets allow customers and end users to quantify the level of reliability they should expect from a service.

## Service Level Indicator (SLI)
- **Definition**: Quantitative measure of some aspect of the level of service provided.
- **Common SLIs**:
  - Request Latency
  - Error Rate
  - Saturation
  - Throughput
  - Availability
- **Considerations**: Choose metrics that accurately measure user experience; metrics like high CPU or memory usage may not impact users directly.

## Service Level Objective (SLO)
- **Definition**: Target value or range for an SLI.
- **Example**:
  - SLI: Latency
  - SLO: Latency < 100ms
- **Purpose**: Quantify the reliability of a product to a customer.
- **Considerations**: SLOs should be directly related to customer experience; setting overly aggressive SLOs (e.g., 100% uptime) may come at a higher cost.

## Service Level Agreement (SLA)
- **Definition**: Contract between a vendor and a user that guarantees a certain SLO.
- **Consequences**: Not meeting an SLO can result in financial penalties or other consequences.

### Importance of Balance
- **Goal**: Achieve the right level of reliability to make customers happy.
- **Perfection vs. Practicality**: The goal is not to achieve perfection but to meet customers' expectations with the right level of reliability.
- **Example**: If a customer is satisfied with 99% reliability, striving for higher uptime may not add additional value.

Establishing and adhering to SLIs, SLOs, and SLAs is essential for ensuring that systems and applications meet the required level of reliability and performance, ultimately enhancing customer satisfaction.
