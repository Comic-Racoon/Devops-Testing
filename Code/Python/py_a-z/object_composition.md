# Object Composition & Dependency Injection Reference

## Core Concepts

### Object Composition
- **"Has-a" relationships** vs "Is-a" (inheritance)
- Build objects by combining smaller, focused components
- More flexible than inheritance hierarchies
- Easier to test and reason about

### Dependency Injection (DI)
- **Extract dependencies out** of classes
- **Pass dependencies in** via constructor
- **Depend on interfaces**, not concrete implementations

## Python Implementation Patterns

### Basic Composition with @dataclass
```python
from dataclasses import dataclass
from typing import Optional

@dataclass
class Engine:
    horsepower: int
    fuel_type: str
    
    def start(self) -> str:
        return f"Starting {self.horsepower}hp {self.fuel_type} engine"

@dataclass
class Car:
    make: str
    model: str
    engine: Engine  # Composition - Car "has-a" Engine
    _running: bool = False  # Single underscore: internal use
    
    @property
    def is_running(self) -> bool:
        return self._running
    
    def start_car(self) -> str:
        self._running = True
        return self.engine.start()
```

### Underscore Conventions
- `_variable`: Internal use (convention, still accessible)
- `__variable`: Name mangling (truly private)
- `__method__`: Special/dunder methods

## Dependency Injection Patterns

### 1. Interface-Based DI (Recommended)
```python
from typing import Protocol

# Define interface
class PaymentInterface(Protocol):
    def process_payment(self, amount: float) -> bool: ...

# Depend on interface
@dataclass
class OrderService:
    payment: PaymentInterface  # Interface, not concrete class
    
    def create_order(self, amount: float):
        return self.payment.process_payment(amount)

# Multiple implementations
class StripePaymentService:
    def process_payment(self, amount: float) -> bool:
        # Stripe implementation
        return True

class PayPalPaymentService:
    def process_payment(self, amount: float) -> bool:
        # PayPal implementation
        return True
```

### 2. Environment-Based Dependencies
```python
def create_payment_service(env: str) -> PaymentInterface:
    if env == "production":
        return StripePaymentService("sk_live_123")
    elif env == "development":
        return MockPaymentService()
    else:
        return TestPaymentService()

# Usage
payment = create_payment_service("production")
order_service = OrderService(payment=payment)
```

## Production-Ready Patterns

### Choice Matrix
| Scenario | Best Approach | Why |
|----------|---------------|-----|
| **Scripts < 500 lines** | Manual DI | Simple, no overhead |
| **Web APIs** | Framework DI (FastAPI) | Lifecycle management |
| **Enterprise Apps** | DI Container | Complex dependencies |
| **Microservices** | Service Registry | Environment isolation |
| **Testing** | Pytest fixtures | Easy mocking |
| **CLI Tools** | Click context | Command-level deps |

### FastAPI Example
```python
from fastapi import FastAPI, Depends

app = FastAPI()

def get_payment_service() -> PaymentInterface:
    return StripePaymentService("sk_123")

@app.post("/orders")
async def create_order(
    order_data: OrderCreateModel,
    payment: PaymentInterface = Depends(get_payment_service)
):
    order_service = OrderService(payment=payment)
    return order_service.create_order(order_data)
```

### DI Container Example
```python
from dependency_injector import containers, providers

class ApplicationContainer(containers.DeclarativeContainer):
    # Infrastructure
    database = providers.Singleton(Database, url="localhost:5432")
    
    # Services
    payment = providers.Factory(StripePaymentService, api_key="sk_123")
    
    # Business Logic
    order_service = providers.Factory(
        OrderService,
        database=database,
        payment=payment
    )
```

## Interface vs Abstract Base Class

### Use Interface (Protocol) When:
- Multiple **independent** implementations
- No shared code between implementations
- Pure duck typing

### Use Abstract Base Class When:
- Implementations share **common logic**
- Want to enforce method signatures
- Need shared helper methods

```python
from abc import ABC, abstractmethod

class BasePaymentService(ABC):
    def __init__(self, api_key: str):
        self.api_key = api_key
        self.session = self._create_session()  # Shared logic
    
    def _create_session(self):
        # Common HTTP setup
        pass
    
    @abstractmethod
    def process_payment(self, amount: float) -> bool:
        pass

class StripePaymentService(BasePaymentService):
    def process_payment(self, amount: float) -> bool:
        # Stripe-specific implementation
        return True
```

## Instantiation vs Injection

### Instantiation = Creating Objects
```python
# Creating the objects
stripe = StripePaymentService("sk_123")
database = PostgreSQLDatabase("localhost:5432")
```

### Injection = Providing Dependencies
```python
# Providing dependencies to objects
order_service = OrderService(
    payment=stripe,     # Injecting payment dependency
    database=database   # Injecting database dependency
)
```

## Testing with DI

### Pytest Fixtures
```python
@pytest.fixture
def mock_payment():
    return Mock(spec=PaymentInterface)

@pytest.fixture
def order_service(mock_payment):
    return OrderService(payment=mock_payment)

def test_order_creation(order_service, mock_payment):
    order_service.create_order(100.0)
    mock_payment.process_payment.assert_called_once_with(100.0)
```

## Best Practices

### ✅ Do
- Extract dependencies from classes
- Use interfaces for swappable dependencies
- Inject dependencies via constructor
- Use factories for complex object creation
- Mock dependencies in tests

### ❌ Don't
- Create dependencies inside classes
- Hard-code external services
- Over-engineer simple code
- Use DI for basic operations (math, strings)

### Red Flags
```python
# ❌ Bad - creates its own dependencies
class OrderService:
    def __init__(self):
        self.payment = StripePaymentService("sk_123")  # Hard-coded!

# ✅ Good - dependencies injected
class OrderService:
    def __init__(self, payment: PaymentInterface):
        self.payment = payment
```

## Quick Reference

### The Golden Rule
**Use DI when you have actual dependencies that need to be:**
- Swapped (different implementations)
- Mocked (for testing)
- Configured (different environments)

### Core Pattern
1. **Define interface** (Protocol)
2. **Extract dependencies** out of class
3. **Inject via constructor**
4. **Create implementations** separately
5. **Wire together** at application boundary

### Decision Tree
- Simple script? → Manual DI
- Web API? → Framework DI
- Complex app? → DI Container
- Need shared logic? → Abstract base class
- Independent implementations? → Interface only

## Design Patterns with Object Composition

### 1. Factory Pattern
**When to use:** Complex object creation, environment-based configuration, hiding implementation details

```python
from abc import ABC, abstractmethod
from typing import Protocol

class DatabaseInterface(Protocol):
    def connect(self) -> bool: ...
    def query(self, sql: str) -> list: ...

class DatabaseFactory:
    @staticmethod
    def create_database(db_type: str, connection_string: str) -> DatabaseInterface:
        if db_type == "postgresql":
            return PostgreSQLDatabase(connection_string)
        elif db_type == "mysql":
            return MySQLDatabase(connection_string)
        elif db_type == "sqlite":
            return SQLiteDatabase(connection_string)
        else:
            raise ValueError(f"Unsupported database type: {db_type}")

# Usage
database = DatabaseFactory.create_database("postgresql", "localhost:5432")
```

### 2. Strategy Pattern
**When to use:** Multiple algorithms/behaviors, runtime switching, avoiding if/else chains

```python
from typing import Protocol

class PaymentStrategy(Protocol):
    def process_payment(self, amount: float) -> dict: ...

class CreditCardPayment:
    def process_payment(self, amount: float) -> dict:
        return {"method": "credit_card", "amount": amount, "fee": amount * 0.03}

class PayPalPayment:
    def process_payment(self, amount: float) -> dict:
        return {"method": "paypal", "amount": amount, "fee": amount * 0.025}

class CryptocurrencyPayment:
    def process_payment(self, amount: float) -> dict:
        return {"method": "crypto", "amount": amount, "fee": amount * 0.01}

@dataclass
class PaymentProcessor:
    strategy: PaymentStrategy
    
    def process(self, amount: float) -> dict:
        return self.strategy.process_payment(amount)
    
    def change_strategy(self, new_strategy: PaymentStrategy):
        self.strategy = new_strategy

# Usage
processor = PaymentProcessor(CreditCardPayment())
result = processor.process(100.0)
processor.change_strategy(PayPalPayment())  # Switch at runtime
```

### 3. Observer Pattern
**When to use:** Event-driven systems, decoupling event producers from consumers

```python
from typing import Protocol, List

class EventListener(Protocol):
    def handle_event(self, event: dict) -> None: ...

class EmailNotificationService:
    def handle_event(self, event: dict) -> None:
        if event["type"] == "order_created":
            print(f"Sending email for order {event['order_id']}")

class SMSNotificationService:
    def handle_event(self, event: dict) -> None:
        if event["type"] == "order_created":
            print(f"Sending SMS for order {event['order_id']}")

class AnalyticsService:
    def handle_event(self, event: dict) -> None:
        print(f"Recording analytics: {event}")

@dataclass
class OrderService:
    listeners: List[EventListener]
    
    def create_order(self, order_data: dict) -> str:
        order_id = "ORD-123"
        
        # Business logic
        print(f"Order {order_id} created")
        
        # Notify all listeners
        event = {"type": "order_created", "order_id": order_id, "data": order_data}
        for listener in self.listeners:
            listener.handle_event(event)
        
        return order_id

# Usage
order_service = OrderService([
    EmailNotificationService(),
    SMSNotificationService(),
    AnalyticsService()
])
```

### 4. Repository Pattern
**When to use:** Data access abstraction, testability, separation of concerns

```python
from typing import Protocol, Optional, List
from abc import ABC, abstractmethod

class User:
    def __init__(self, id: int, name: str, email: str):
        self.id = id
        self.name = name
        self.email = email

class UserRepository(Protocol):
    def find_by_id(self, user_id: int) -> Optional[User]: ...
    def find_by_email(self, email: str) -> Optional[User]: ...
    def save(self, user: User) -> User: ...
    def delete(self, user_id: int) -> bool: ...

class DatabaseUserRepository:
    def __init__(self, db_connection):
        self.db = db_connection
    
    def find_by_id(self, user_id: int) -> Optional[User]:
        # Real database query
        result = self.db.query(f"SELECT * FROM users WHERE id = {user_id}")
        return User(**result) if result else None
    
    def save(self, user: User) -> User:
        # Real database save
        self.db.execute("INSERT INTO users...", user)
        return user

class InMemoryUserRepository:
    def __init__(self):
        self.users = {}
        self.next_id = 1
    
    def find_by_id(self, user_id: int) -> Optional[User]:
        return self.users.get(user_id)
    
    def save(self, user: User) -> User:
        if user.id is None:
            user.id = self.next_id
            self.next_id += 1
        self.users[user.id] = user
        return user

@dataclass
class UserService:
    repository: UserRepository
    
    def create_user(self, name: str, email: str) -> User:
        user = User(None, name, email)
        return self.repository.save(user)
    
    def get_user(self, user_id: int) -> Optional[User]:
        return self.repository.find_by_id(user_id)

# Usage
# Production
db_repo = DatabaseUserRepository(db_connection)
user_service = UserService(db_repo)

# Testing
memory_repo = InMemoryUserRepository()
test_user_service = UserService(memory_repo)
```

### 5. Decorator Pattern
**When to use:** Adding behavior without modifying classes, cross-cutting concerns

```python
from typing import Protocol
from functools import wraps
import time

class ServiceInterface(Protocol):
    def process_request(self, data: dict) -> dict: ...

class CoreService:
    def process_request(self, data: dict) -> dict:
        return {"result": f"Processed {data}"}

# Decorator classes
@dataclass
class LoggingDecorator:
    wrapped_service: ServiceInterface
    
    def process_request(self, data: dict) -> dict:
        print(f"Logging: Processing {data}")
        result = self.wrapped_service.process_request(data)
        print(f"Logging: Result {result}")
        return result

@dataclass
class CachingDecorator:
    wrapped_service: ServiceInterface
    cache: dict = None
    
    def __post_init__(self):
        if self.cache is None:
            self.cache = {}
    
    def process_request(self, data: dict) -> dict:
        cache_key = str(data)
        if cache_key in self.cache:
            print("Cache hit!")
            return self.cache[cache_key]
        
        result = self.wrapped_service.process_request(data)
        self.cache[cache_key] = result
        return result

@dataclass
class TimingDecorator:
    wrapped_service: ServiceInterface
    
    def process_request(self, data: dict) -> dict:
        start_time = time.time()
        result = self.wrapped_service.process_request(data)
        end_time = time.time()
        print(f"Processing took {end_time - start_time:.2f} seconds")
        return result

# Usage - chain decorators
service = CoreService()
service = LoggingDecorator(service)
service = CachingDecorator(service)
service = TimingDecorator(service)

result = service.process_request({"key": "value"})
```

### 6. Command Pattern
**When to use:** Undo/redo functionality, queuing operations, decoupling invoker from receiver

```python
from typing import Protocol, List
from abc import ABC, abstractmethod

class Command(Protocol):
    def execute(self) -> None: ...
    def undo(self) -> None: ...

class Document:
    def __init__(self):
        self.content = ""
    
    def add_text(self, text: str):
        self.content += text
    
    def remove_text(self, length: int):
        self.content = self.content[:-length]

class AddTextCommand:
    def __init__(self, document: Document, text: str):
        self.document = document
        self.text = text
    
    def execute(self) -> None:
        self.document.add_text(self.text)
    
    def undo(self) -> None:
        self.document.remove_text(len(self.text))

class RemoveTextCommand:
    def __init__(self, document: Document, length: int):
        self.document = document
        self.length = length
        self.removed_text = ""
    
    def execute(self) -> None:
        self.removed_text = self.document.content[-self.length:]
        self.document.remove_text(self.length)
    
    def undo(self) -> None:
        self.document.add_text(self.removed_text)

class DocumentEditor:
    def __init__(self, document: Document):
        self.document = document
        self.command_history: List[Command] = []
        self.current_position = -1
    
    def execute_command(self, command: Command):
        # Remove any commands after current position
        self.command_history = self.command_history[:self.current_position + 1]
        
        command.execute()
        self.command_history.append(command)
        self.current_position += 1
    
    def undo(self):
        if self.current_position >= 0:
            command = self.command_history[self.current_position]
            command.undo()
            self.current_position -= 1
    
    def redo(self):
        if self.current_position < len(self.command_history) - 1:
            self.current_position += 1
            command = self.command_history[self.current_position]
            command.execute()

# Usage
document = Document()
editor = DocumentEditor(document)

editor.execute_command(AddTextCommand(document, "Hello "))
editor.execute_command(AddTextCommand(document, "World!"))
print(document.content)  # "Hello World!"

editor.undo()
print(document.content)  # "Hello "

editor.redo()
print(document.content)  # "Hello World!"
```

### 7. Builder Pattern
**When to use:** Complex object construction, optional parameters, immutable objects

```python
from typing import Optional

@dataclass
class DatabaseConfig:
    host: str
    port: int
    username: str
    password: str
    database: str
    ssl_enabled: bool = False
    timeout: int = 30
    pool_size: int = 5

class DatabaseConfigBuilder:
    def __init__(self):
        self.reset()
    
    def reset(self):
        self._host: Optional[str] = None
        self._port: Optional[int] = None
        self._username: Optional[str] = None
        self._password: Optional[str] = None
        self._database: Optional[str] = None
        self._ssl_enabled: bool = False
        self._timeout: int = 30
        self._pool_size: int = 5
        return self
    
    def host(self, host: str):
        self._host = host
        return self
    
    def port(self, port: int):
        self._port = port
        return self
    
    def credentials(self, username: str, password: str):
        self._username = username
        self._password = password
        return self
    
    def database(self, database: str):
        self._database = database
        return self
    
    def ssl(self, enabled: bool = True):
        self._ssl_enabled = enabled
        return self
    
    def timeout(self, timeout: int):
        self._timeout = timeout
        return self
    
    def pool_size(self, size: int):
        self._pool_size = size
        return self
    
    def build(self) -> DatabaseConfig:
        if not all([self._host, self._port, self._username, self._password, self._database]):
            raise ValueError("Missing required configuration")
        
        return DatabaseConfig(
            host=self._host,
            port=self._port,
            username=self._username,
            password=self._password,
            database=self._database,
            ssl_enabled=self._ssl_enabled,
            timeout=self._timeout,
            pool_size=self._pool_size
        )

# Usage
config = (DatabaseConfigBuilder()
          .host("localhost")
          .port(5432)
          .credentials("user", "password")
          .database("myapp")
          .ssl(True)
          .timeout(60)
          .pool_size(10)
          .build())
```

## Pattern Selection Guide

### By Use Case
| Need | Pattern | Example |
|------|---------|---------|
| **Object Creation** | Factory | Database connections, services |
| **Runtime Behavior** | Strategy | Payment methods, sorting algorithms |
| **Event Handling** | Observer | Notifications, UI updates |
| **Data Access** | Repository | Database abstraction |
| **Add Behavior** | Decorator | Logging, caching, validation |
| **Undo/Redo** | Command | Text editors, transaction systems |
| **Complex Construction** | Builder | Configuration objects, SQL queries |

### By Complexity
| Simple | Medium | Complex |
|--------|---------|---------|
| Strategy | Factory | Observer |
| Repository | Decorator | Command |
| - | Builder | - |

### Common Combinations
- **Repository + Factory**: Data access with multiple database types
- **Strategy + Factory**: Runtime algorithm selection
- **Observer + Command**: Event-driven systems with undo capability
- **Decorator + Repository**: Adding caching/logging to data access 