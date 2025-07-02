# Python Classes: Complete Guide

## Table of Contents
1. [Basic Class Creation](#basic-class-creation)
2. [Types of Constructors](#constructors)
3. [Object Creation - No `new` Keyword](#object-creation)
4. [Understanding Method Types](#method-types)
5. [The `self` Parameter Explained](#the-self-parameter)
6. [Object Equality & Comparison](#object-equality)
7. [Encapsulation & Access Modifiers](#encapsulation)
8. [Name Mangling Explained](#name-mangling)
9. [Properties - The Magic of @property](#properties)
10. [Combining @dataclass with @property](#dataclass-properties)
11. [Field Types and Type Hints](#field-types)
12. [Static & Class Methods](#static-methods)
13. [API Classes vs Normal Classes](#api-vs-normal)
14. [Pydantic for Advanced Validation](#pydantic)
15. [Overloading in Python](#overloading)
16. [Advanced Constructor Patterns](#constructor-patterns)
17. [Best Practices & Guidelines](#best-practices)

---

## Basic Class Creation

### What is a Class?
A class is a **blueprint** for creating objects. Think of it like a cookie cutter - it defines the shape and structure, but each cookie (object) is a separate instance.

### Basic Syntax
```python
class ClassName:
    """Class docstring - describes what this class does"""
    
    def __init__(self, parameters):
        """Constructor - called when creating new objects"""
        self.attribute = value
    
    def method_name(self):
        """Instance method - works with object data"""
        return something
```

### Real Example: Person Class
```python
class Person:
    """Represents a person with name and age"""
    
    def __init__(self, name, age):
        # Instance attributes - unique to each person
        self.name = name
        self.age = age
        self.friends = []  # Empty list for each person
    
    def introduce(self):
        """Method to introduce the person"""
        return f"Hi, I'm {self.name} and I'm {self.age} years old"
    
    def have_birthday(self):
        """Increase age by 1"""
        self.age += 1
        return f"Happy birthday! Now I'm {self.age}"
    
    def add_friend(self, friend_name):
        """Add a friend to the list"""
        if friend_name not in self.friends:
            self.friends.append(friend_name)
            return f"{friend_name} is now my friend!"
        return f"{friend_name} is already my friend!"

# Creating and using objects
alice = Person("Alice", 25)
bob = Person("Bob", 30)

print(alice.introduce())  # Hi, I'm Alice and I'm 25 years old
print(alice.have_birthday())  # Happy birthday! Now I'm 26
print(alice.add_friend("Charlie"))  # Charlie is now my friend!
```

### Using @dataclass for Simpler Classes
When you mainly need to store data, `@dataclass` generates common methods automatically:

```python
from dataclasses import dataclass, field
from typing import List

@dataclass
class Product:
    """Product in an online store"""
    name: str
    price: float
    category: str = "general"  # Default value
    tags: List[str] = field(default_factory=list)  # Mutable default
    
    def __post_init__(self):
        """Called after __init__ for additional validation"""
        if self.price < 0:
            raise ValueError("Price cannot be negative")
        if not self.name.strip():
            raise ValueError("Name cannot be empty")
    
    def add_tag(self, tag: str):
        """Add a tag to the product"""
        if tag not in self.tags:
            self.tags.append(tag)
    
    def is_expensive(self) -> bool:
        """Check if product is expensive"""
        return self.price > 100

# @dataclass automatically provides:
# - __init__ method
# - __repr__ method (string representation)
# - __eq__ method (equality comparison)

laptop = Product("Gaming Laptop", 1200.99, "electronics")
mouse = Product("Wireless Mouse", 25.50, "electronics")

print(laptop)  # Product(name='Gaming Laptop', price=1200.99, ...)
print(laptop == mouse)  # False
print(laptop.is_expensive())  # True
```

### Key Differences: Regular Class vs @dataclass

| Feature | Regular Class | @dataclass |
|---------|---------------|------------|
| __init__ | Must write manually | Generated automatically |
| __repr__ | Must write manually | Generated automatically |
| __eq__ | Must write manually | Generated automatically |
| Type hints | Optional | Required for auto-generation |
| Validation | In __init__ | In __post_init__ |

---

## Types of Constructors

### 1. Default Constructor
When you don't define `__init__`, Python provides a default constructor:

```python
class Car:
    pass  # No __init__ defined

# Python provides default constructor
car = Car()  # Works - uses default constructor
print(car)   # <__main__.Car object at 0x...>

# You can add attributes after creation
car.make = "Toyota"
car.model = "Camry"
print(car.make)  # Toyota
```

### 2. Primary Constructor (`__init__`)
The main way to initialize objects with data:

```python
class Car:
    def __init__(self, make, model, year=2024):
        """Primary constructor - main way to create objects"""
        self.make = make
        self.model = model
        self.year = year
        self.mileage = 0
        self.is_running = False
    
    def start_engine(self):
        self.is_running = True
        return f"{self.make} {self.model} engine started!"

# Using primary constructor
car1 = Car("Toyota", "Camry")           # year defaults to 2024
car2 = Car("Honda", "Civic", 2023)     # explicit year
car3 = Car(make="Ford", model="F-150", year=2022)  # named parameters
```

### 3. Multiple Constructors (Alternative Constructors)
Python doesn't support method overloading, but you can create alternative constructors using class methods:

```python
from datetime import datetime

class Person:
    def __init__(self, name, age):
        """Primary constructor"""
        self.name = name
        self.age = age
        self.created_at = datetime.now()
    
    @classmethod
    def from_birth_year(cls, name, birth_year):
        """Alternative constructor from birth year"""
        current_year = datetime.now().year
        age = current_year - birth_year
        return cls(name, age)  # Calls primary constructor
    
    @classmethod
    def from_string(cls, person_string):
        """Alternative constructor from string"""
        name, age_str = person_string.split(',')
        return cls(name.strip(), int(age_str.strip()))
    
    @classmethod
    def baby(cls, name):
        """Alternative constructor for babies"""
        return cls(name, 0)
    
    @classmethod
    def from_dict(cls, data):
        """Alternative constructor from dictionary"""
        return cls(data['name'], data['age'])

# Multiple ways to create Person objects
person1 = Person("Alice", 25)                           # Primary constructor
person2 = Person.from_birth_year("Bob", 1995)          # From birth year
person3 = Person.from_string("Charlie, 30")            # From string
person4 = Person.baby("Diana")                          # Baby constructor
person5 = Person.from_dict({"name": "Eve", "age": 28}) # From dictionary

print(person2.age)  # Calculated age based on birth year
```

### 4. Factory Pattern Constructors
Create different types of objects based on parameters:

```python
class BankAccount:
    def __init__(self, account_number, balance, account_type):
        """Primary constructor"""
        self.account_number = account_number
        self.balance = balance
        self.account_type = account_type
        self.transaction_history = []
    
    @classmethod
    def create_checking(cls, account_number, initial_deposit=0):
        """Factory method for checking account"""
        return cls(account_number, initial_deposit, "CHECKING")
    
    @classmethod
    def create_savings(cls, account_number, initial_deposit=0):
        """Factory method for savings account"""
        return cls(account_number, initial_deposit, "SAVINGS")
    
    @classmethod
    def create_business(cls, account_number, initial_deposit=0):
        """Factory method for business account"""
        return cls(account_number, initial_deposit, "BUSINESS")

# Different ways to create accounts
checking = BankAccount.create_checking("CHK001", 1000)
savings = BankAccount.create_savings("SAV001", 5000)
business = BankAccount.create_business("BUS001", 10000)
```

### 5. Flexible Constructor with *args and **kwargs
```python
class FlexiblePerson:
    def __init__(self, *args, **kwargs):
        """Flexible constructor that handles multiple argument patterns"""
        if len(args) == 1 and isinstance(args[0], str) and not kwargs:
            # Single string argument - name only
            self.name = args[0]
            self.age = 0
            self.email = None
        elif len(args) == 2:
            # Two arguments - name and age
            self.name, self.age = args
            self.email = kwargs.get('email')
        elif 'name' in kwargs:
            # Keyword arguments
            self.name = kwargs['name']
            self.age = kwargs.get('age', 0)
            self.email = kwargs.get('email')
        else:
            raise ValueError("Invalid arguments for Person constructor")

# Multiple ways to create
person1 = FlexiblePerson("Alice")                                    # Name only
person2 = FlexiblePerson("Bob", 25)                                  # Name and age
person3 = FlexiblePerson("Charlie", 30, email="charlie@email.com")   # With email
person4 = FlexiblePerson(name="Diana", age=28, email="diana@email.com")  # All kwargs
```

### Constructor Best Practices
```python
class GoodConstructor:
    def __init__(self, required_param, optional_param=None, *, keyword_only_param):
        """
        Well-designed constructor
        
        Args:
            required_param: Must be provided
            optional_param: Has default value
            keyword_only_param: Must be passed as keyword (after *)
        """
        # Validate inputs
        if not required_param:
            raise ValueError("required_param cannot be empty")
        
        # Set attributes
        self.required_param = required_param
        self.optional_param = optional_param or "default"
        self.keyword_only_param = keyword_only_param
        
        # Initialize computed attributes
        self.created_at = datetime.now()

# Usage
obj = GoodConstructor("value", keyword_only_param="must_be_keyword")
```

---

## Name Mangling

### How Python Handles Private Attributes
When you use double underscores (`__`), Python performs **name mangling**:

```python
class Example:
    def __init__(self):
        self.public = "everyone can see"
        self._protected = "convention: internal use"
        self.__private = "name mangled by Python"
    
    def __private_method(self):
        return "this gets name mangled too"
    
    def access_private(self):
        return self.__private  # Works inside the class

obj = Example()

# What you can access:
print(obj.public)        # ✅ Works
print(obj._protected)    # ✅ Works (convention, not enforced)
# print(obj.__private)   # ❌ AttributeError

# But Python renamed it!
print(obj._Example__private)        # ✅ Works! Name mangling revealed
print(obj._Example__private_method()) # ✅ Works! Method also mangled
```

### Seeing Name Mangling in Action
```python
class TestMangling:
    def __init__(self):
        self.normal = "normal"
        self._single = "single underscore"
        self.__double = "double underscore"
    
    def __hidden_method(self):
        return "hidden method"

obj = TestMangling()

# See all attributes
print("All attributes:")
for attr in dir(obj):
    if not attr.startswith('__') or 'Test' in attr:
        print(f"  {attr}")

# Output shows:
#   _TestMangling__double         ← Name mangled
#   _TestMangling__hidden_method  ← Name mangled
#   _single                       ← Unchanged
#   normal                        ← Unchanged
```

### Why Name Mangling Exists
```python
class Parent:
    def __init__(self):
        self.__family_secret = "parent secret"
    
    def reveal_secret(self):
        return self.__family_secret

class Child(Parent):
    def __init__(self):
        super().__init__()
        self.__family_secret = "child secret"  # Different from parent's!
    
    def reveal_child_secret(self):
        return self.__family_secret

child = Child()
print(child.reveal_secret())       # "parent secret"
print(child.reveal_child_secret()) # "child secret"

# Name mangling prevents accidental conflicts:
print(child._Parent__family_secret)  # "parent secret"
print(child._Child__family_secret)   # "child secret"
```

---

## Combining @dataclass with @property

### The Challenge
You can't directly use field names that conflict with properties:

```python
# ❌ This doesn't work well
@dataclass
class BadExample:
    name: str  # This creates a field AND we want a property
    
    @property
    def name(self):  # Conflicts with the field!
        return self._name
```

### Solution: Use field(init=False) and Custom __init__
```python
from dataclasses import dataclass, field
from typing import Optional

@dataclass
class Person:
    # Private fields for properties
    _name: str = field(init=False, repr=False)
    _email: Optional[str] = field(default=None, init=False, repr=False)
    
    # Public fields (no properties needed)
    age: int = 0
    created_at: str = ""
    
    def __init__(self, name: str, age: int = 0, email: Optional[str] = None):
        self.age = age
        self.created_at = str(datetime.now())
        # Use property setters for validation
        self.name = name
        self.email = email
    
    @property
    def name(self) -> str:
        return self._name
    
    @name.setter
    def name(self, value: str):
        if not value.strip():
            raise ValueError("Name cannot be empty")
        self._name = value.strip().title()
    
    @property
    def email(self) -> Optional[str]:
        return self._email
    
    @email.setter  
    def email(self, value: Optional[str]):
        if value and '@' not in value:
            raise ValueError("Invalid email format")
        self._email = value.lower() if value else None
    
    @property
    def display_name(self) -> str:
        """Computed property"""
        return f"{self._name} ({self._email})" if self._email else self._name

# Usage - gets benefits of both @dataclass and @property
person = Person("john doe", 25, "JOHN@EXAMPLE.COM")
print(person.name)         # "John Doe" (property transformed it)
print(person.email)        # "john@example.com" (property lowercased it)
print(person.display_name) # "John Doe (john@example.com)"
print(person)              # Still gets dataclass __repr__
```

### Alternative: Properties for Computed Fields Only
```python
@dataclass
class Product:
    name: str
    price: float
    tax_rate: float = 0.10
    
    @property
    def price_with_tax(self) -> float:
        """Computed property - doesn't conflict with fields"""
        return self.price * (1 + self.tax_rate)
    
    @property
    def display_price(self) -> str:
        """Computed property for formatting"""
        return f"${self.price_with_tax:.2f}"
    
    def __post_init__(self):
        """Validation in __post_init__ instead of properties"""
        if self.price < 0:
            raise ValueError("Price cannot be negative")

product = Product("Laptop", 999.99)
print(product.display_price)  # "$1099.99"
```

---

## Field Types and Type Hints

### Basic Type Hints in Classes
```python
from typing import List, Dict, Optional, Union
from datetime import datetime

class User:
    def __init__(
        self, 
        username: str,
        age: int,
        email: Optional[str] = None,
        tags: List[str] = None,
        metadata: Dict[str, Union[str, int]] = None
    ):
        self.username: str = username
        self.age: int = age
        self.email: Optional[str] = email
        self.tags: List[str] = tags or []
        self.metadata: Dict[str, Union[str, int]] = metadata or {}
        self.created_at: datetime = datetime.now()
    
    def add_tag(self, tag: str) -> None:
        self.tags.append(tag)
    
    def get_age_in_days(self) -> int:
        return self.age * 365
```

### Advanced Type Hints with @dataclass
```python
from dataclasses import dataclass, field
from typing import List, Dict, Optional, ClassVar
from enum import Enum

class UserRole(Enum):
    ADMIN = "admin"
    USER = "user"
    GUEST = "guest"

@dataclass
class AdvancedUser:
    username: str
    role: UserRole
    age: int = 0
    email: Optional[str] = None
    
    # List with default factory
    permissions: List[str] = field(default_factory=list)
    
    # Dict with default factory
    preferences: Dict[str, str] = field(default_factory=dict)
    
    # Class variable (shared by all instances)
    total_users: ClassVar[int] = 0
    
    # Field that's not included in __init__
    created_at: datetime = field(default_factory=datetime.now, init=False)
    
    # Field not shown in __repr__
    internal_id: str = field(default="", repr=False)
    
    def __post_init__(self):
        AdvancedUser.total_users += 1
        if not self.internal_id:
            self.internal_id = f"user_{self.total_users}"

# Usage with type checking
user = AdvancedUser(
    username="alice",
    role=UserRole.ADMIN,
    age=25,
    email="alice@example.com"
)
```

### Custom Type Annotations
```python
from typing import TypeVar, Generic, Protocol

# Type variable
T = TypeVar('T')

class Container(Generic[T]):
    def __init__(self, value: T):
        self._value: T = value
    
    def get(self) -> T:
        return self._value
    
    def set(self, value: T) -> None:
        self._value = value

# Protocol for type checking
class Drawable(Protocol):
    def draw(self) -> str: ...

class Shape:
    def __init__(self, name: str):
        self.name = name
    
    def process_drawable(self, obj: Drawable) -> str:
        """Accepts any object with a draw() method"""
        return obj.draw()

# Usage
string_container = Container[str]("hello")
int_container = Container[int](42)
```

---

## Object Creation

### Python vs Other Languages

**The Big Difference**: Python doesn't use the `new` keyword like other languages.

```python
# ✅ Python - Direct class call
car = Car("Toyota", "Camry")
person = Person("Alice", 25)

# ❌ Other languages require 'new'
# Java: Car car = new Car("Toyota", "Camry");
# C#: var car = new Car("Toyota", "Camry");
# JavaScript: let car = new Car("Toyota", "Camry");
```

### What Happens Behind the Scenes
When you call `Car("Toyota", "Camry")`, Python does this:

1. **Calls `__new__`**: Creates a new empty instance
2. **Calls `__init__`**: Initializes the instance with your data
3. **Returns the object**: Gives you the fully initialized object

```python
class Car:
    def __new__(cls, make, model):
        print(f"Creating new {cls.__name__} instance")
        instance = super().__new__(cls)
        return instance
    
    def __init__(self, make, model):
        print(f"Initializing car with {make} {model}")
        self.make = make
        self.model = model

# When you create a car:
car = Car("Toyota", "Camry")
# Output:
# Creating new Car instance
# Initializing car with Toyota Camry
```

---

## Method Types

Understanding different method types is crucial for proper Python programming.

### 1. Instance Methods (Most Common)
**Purpose**: Work with specific object data
**Requirements**: Must have `self` as first parameter
**Usage**: Called on object instances

```python
class BankAccount:
    def __init__(self, account_number, balance=0):
        self.account_number = account_number
        self.balance = balance
        self.transaction_history = []
    
    def deposit(self, amount):
        """Instance method - works with THIS account's data"""
        if amount > 0:
            self.balance += amount  # Modifies THIS account
            self.transaction_history.append(f"Deposited ${amount}")
            return f"New balance: ${self.balance}"
        return "Invalid amount"
    
    def withdraw(self, amount):
        """Instance method - checks THIS account's balance"""
        if 0 < amount <= self.balance:
            self.balance -= amount
            self.transaction_history.append(f"Withdrew ${amount}")
            return f"New balance: ${self.balance}"
        return "Insufficient funds or invalid amount"
    
    def get_history(self):
        """Instance method - returns THIS account's history"""
        return self.transaction_history.copy()

# Each account is independent
alice_account = BankAccount("ACC001", 1000)
bob_account = BankAccount("ACC002", 500)

alice_account.deposit(200)  # Only affects Alice's account
print(alice_account.balance)  # 1200
print(bob_account.balance)    # 500 (unchanged)
```

### 2. Class Methods (@classmethod)
**Purpose**: Work with the class itself, not instances
**Requirements**: Must have `cls` as first parameter
**Usage**: Alternative constructors, class-level operations

```python
from datetime import datetime

class Employee:
    # Class variables (shared by all employees)
    company_name = "TechCorp"
    employee_count = 0
    min_salary = 30000
    
    def __init__(self, name, salary, hire_date=None):
        # Instance variables (unique to each employee)
        self.name = name
        self.salary = salary
        self.hire_date = hire_date or datetime.now().date()
        
        # Update class variable
        Employee.employee_count += 1
    
    @classmethod
    def get_company_info(cls):
        """Class method - returns company information"""
        return f"Company: {cls.company_name}, Employees: {cls.employee_count}"
    
    @classmethod
    def from_string(cls, employee_string):
        """Class method - alternative constructor"""
        # Parse "John Doe,50000" format
        name, salary = employee_string.split(',')
        return cls(name.strip(), int(salary.strip()))
    
    @classmethod
    def create_intern(cls, name):
        """Class method - create intern with minimum salary"""
        return cls(name, cls.min_salary)
    
    @classmethod
    def set_minimum_salary(cls, new_minimum):
        """Class method - modify class variable"""
        cls.min_salary = new_minimum
    
    def get_info(self):
        """Instance method - returns this employee's info"""
        return f"{self.name}: ${self.salary} (hired {self.hire_date})"

# Using class methods
print(Employee.get_company_info())  # Company: TechCorp, Employees: 0

# Alternative constructors
emp1 = Employee.from_string("Alice Johnson,55000")
emp2 = Employee.create_intern("Bob Smith")
emp3 = Employee("Charlie Brown", 65000)

print(Employee.get_company_info())  # Company: TechCorp, Employees: 3

# Modify class data
Employee.set_minimum_salary(35000)
print(f"New minimum salary: ${Employee.min_salary}")
```

### 3. Static Methods (@staticmethod)
**Purpose**: Utility functions that belong logically to the class
**Requirements**: No `self` or `cls` parameter
**Usage**: Helper functions, validation, calculations

```python
import re
import math

class MathUtils:
    """Collection of mathematical utility functions"""
    
    @staticmethod
    def add(a, b):
        """Simple addition - no class/instance data needed"""
        return a + b
    
    @staticmethod
    def calculate_distance(x1, y1, x2, y2):
        """Calculate distance between two points"""
        return math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    
    @staticmethod
    def is_prime(number):
        """Check if a number is prime"""
        if number < 2:
            return False
        for i in range(2, int(math.sqrt(number)) + 1):
            if number % i == 0:
                return False
        return True
    
    @staticmethod
    def factorial(n):
        """Calculate factorial"""
        if n < 0:
            raise ValueError("Factorial not defined for negative numbers")
        if n <= 1:
            return 1
        return n * MathUtils.factorial(n - 1)

class ValidationUtils:
    """Collection of validation utility functions"""
    
    @staticmethod
    def is_valid_email(email):
        """Validate email format"""
        pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
        return re.match(pattern, email) is not None
    
    @staticmethod
    def is_strong_password(password):
        """Check if password is strong"""
        if len(password) < 8:
            return False
        has_upper = any(c.isupper() for c in password)
        has_lower = any(c.islower() for c in password)
        has_digit = any(c.isdigit() for c in password)
        has_special = any(c in "!@#$%^&*" for c in password)
        return has_upper and has_lower and has_digit and has_special
    
    @staticmethod
    def clean_phone_number(phone):
        """Clean and format phone number"""
        # Remove all non-digit characters
        digits = re.sub(r'\D', '', phone)
        if len(digits) == 10:
            return f"({digits[:3]}) {digits[3:6]}-{digits[6:]}"
        elif len(digits) == 11 and digits[0] == '1':
            return f"1-({digits[1:4]}) {digits[4:7]}-{digits[7:]}"
        return "Invalid phone number"

# Static methods can be called on class or instance
print(MathUtils.add(5, 3))  # 8
print(MathUtils.is_prime(17))  # True
print(MathUtils.factorial(5))  # 120

print(ValidationUtils.is_valid_email("test@example.com"))  # True
print(ValidationUtils.is_strong_password("Weak123"))  # False
print(ValidationUtils.clean_phone_number("555-123-4567"))  # (555) 123-4567

# Also works with instances (though uncommon)
math_instance = MathUtils()
print(math_instance.add(10, 20))  # 30
```

### When to Use Each Method Type

| Use Case | Method Type | Example |
|----------|-------------|---------|
| Modify object data | Instance method | `account.deposit(100)` |
| Access object data | Instance method | `account.get_balance()` |
| Create objects differently | Class method | `Employee.from_string("John,50000")` |
| Access/modify class data | Class method | `Employee.get_count()` |
| Utility functions | Static method | `MathUtils.calculate_area(5, 10)` |
| Validation functions | Static method | `ValidationUtils.is_valid_email(email)` |

---

## The `self` Parameter

### Why `self` is Essential
`self` represents **the current instance** of the class. It's how Python knows which object you're working with.

### Understanding `self` with Examples

```python
class Counter:
    def __init__(self, start_value=0):
        self.value = start_value  # 'self' refers to THIS specific counter
    
    def increment(self):
        self.value += 1  # Increment THIS counter's value
        return self.value
    
    def get_value(self):
        return self.value  # Return THIS counter's value

# Create multiple counters
counter1 = Counter(0)
counter2 = Counter(100)

# Each counter maintains its own value
print(counter1.increment())  # 1
print(counter1.increment())  # 2
print(counter2.increment())  # 101
print(counter1.get_value())  # 2 (counter1's value unchanged)
print(counter2.get_value())  # 101
```

### What Happens When You Call Methods
```python
class Person:
    def __init__(self, name):
        self.name = name
    
    def greet(self):
        return f"Hello, I'm {self.name}"

person = Person("Alice")

# When you call: person.greet()
# Python actually calls: Person.greet(person)
print(person.greet())  # "Hello, I'm Alice"
print(Person.greet(person))  # Same result - explicit 'self'
```

### Common `self` Errors and Solutions

#### Error 1: Missing `self` Parameter
```python
class BadExample:
    def __init__(self, value):
        self.value = value
    
    def get_value():  # ❌ Missing 'self'
        return self.value

# This causes: TypeError: get_value() takes 0 positional arguments but 1 was given

class GoodExample:
    def __init__(self, value):
        self.value = value
    
    def get_value(self):  # ✅ Includes 'self'
        return self.value
```

#### Error 2: Wrong Variable Reference
```python
class Calculator:
    def __init__(self):
        self.result = 0
    
    def add(self, number):
        result += number  # ❌ Should be 'self.result'
        return result

# This causes: UnboundLocalError: local variable 'result' referenced before assignment

class Calculator:
    def __init__(self):
        self.result = 0
    
    def add(self, number):
        self.result += number  # ✅ Correct
        return self.result
```

### When `self` is NOT Needed

```python
class MixedMethods:
    class_variable = "shared"
    
    def __init__(self, value):
        self.value = value
    
    def instance_method(self):
        # ✅ Needs 'self' - works with instance data
        return f"Instance value: {self.value}"
    
    @classmethod
    def class_method(cls):
        # ✅ Uses 'cls' instead of 'self' - works with class data
        return f"Class variable: {cls.class_variable}"
    
    @staticmethod
    def static_method(a, b):
        # ✅ No 'self' or 'cls' - pure utility function
        return a + b

# Outside the class - regular functions don't need 'self'
def regular_function(name):
    return f"Hello {name}"
```

---

## Object Equality

### Default Behavior: Identity Comparison
By default, Python compares object **identity** (memory location), not **values**:

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

person1 = Person("Alice", 25)
person2 = Person("Alice", 25)  # Same data, different object

print(person1 == person2)  # False - different objects in memory
print(person1 is person2)  # False - different objects
print(id(person1))         # Different memory address
print(id(person2))         # Different memory address
```

### Custom Equality with `__eq__`
To compare based on values, implement the `__eq__` method:

```python
class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    def __eq__(self, other):
        """Define when two persons are considered equal"""
        # Check if 'other' is also a Person
        if not isinstance(other, Person):
            return False
        # Compare based on name and age
        return self.name == other.name and self.age == other.age
    
    def __repr__(self):
        """String representation for debugging"""
        return f"Person('{self.name}', {self.age})"

person1 = Person("Alice", 25)
person2 = Person("Alice", 25)
person3 = Person("Bob", 30)

print(person1 == person2)  # True - same name and age
print(person1 == person3)  # False - different name and age
print(person1 == "Alice")  # False - not a Person object
```

### Complete Comparison Implementation
```python
class Product:
    def __init__(self, name, price, category):
        self.name = name
        self.price = price
        self.category = category
    
    def __eq__(self, other):
        """Equality: same name and category"""
        if not isinstance(other, Product):
            return False
        return self.name == other.name and self.category == other.category
    
    def __lt__(self, other):
        """Less than: compare by price"""
        if not isinstance(other, Product):
            return NotImplemented
        return self.price < other.price
    
    def __le__(self, other):
        """Less than or equal"""
        return self < other or self == other
    
    def __gt__(self, other):
        """Greater than"""
        if not isinstance(other, Product):
            return NotImplemented
        return self.price > other.price
    
    def __ge__(self, other):
        """Greater than or equal"""
        return self > other or self == other
    
    def __hash__(self):
        """Make object hashable (can be used in sets/dicts)"""
        return hash((self.name, self.category))
    
    def __repr__(self):
        return f"Product('{self.name}', ${self.price}, '{self.category}')"

# Usage
laptop = Product("Gaming Laptop", 1200, "Electronics")
mouse = Product("Wireless Mouse", 25, "Electronics")
laptop2 = Product("Gaming Laptop", 1100, "Electronics")  # Same name/category, different price

print(laptop == laptop2)  # True - same name and category
print(laptop > mouse)     # True - higher price
print(laptop >= laptop2)  # True - equal products, higher price

# Can use in sets (because we implemented __hash__)
products = {laptop, mouse, laptop2}
print(len(products))  # 2 - laptop and laptop2 are considered equal
```

### Automatic Equality with @dataclass
```python
@dataclass
class Book:
    title: str
    author: str
    isbn: str
    price: float = 0.0
    
    def __post_init__(self):
        """Validation after initialization"""
        if not self.isbn:
            raise ValueError("ISBN is required")

# @dataclass automatically implements __eq__ based on ALL fields
book1 = Book("Python Guide", "John Doe", "123456789", 29.99)
book2 = Book("Python Guide", "John Doe", "123456789", 29.99)
book3 = Book("Python Guide", "John Doe", "123456789", 39.99)

print(book1 == book2)  # True - all fields match
print(book1 == book3)  # False - different price
```

Continue in next part... 

---

## Encapsulation

### Access Control Patterns
| Pattern | Meaning | Enforcement | Example |
|---------|---------|-------------|---------|
| `name` | Public | None | `self.username` |
| `_name` | Protected | Convention only | `self._internal_data` |
| `__name` | Private | Name mangling | `self.__secret` |

### Real Example
```python
class BankAccount:
    def __init__(self, account_number, balance):
        # ✅ Public - external interface
        self.account_number = account_number
        
        # ⚠️ Protected - internal implementation
        self._balance = balance
        self._transaction_history = []
        
        # 🔒 Private - security sensitive
        self.__pin = "1234"
    
    # ✅ Public method - main interface
    def get_balance(self):
        return self._balance
    
    def deposit(self, amount):
        if self._validate_amount(amount):  # Use protected method
            self._balance += amount
            return True
        return False
    
    # ⚠️ Protected method - internal use
    def _validate_amount(self, amount):
        return isinstance(amount, (int, float)) and amount > 0
    
    # 🔒 Private method - truly internal
    def __authenticate(self, pin):
        return pin == self.__pin

# Usage
account = BankAccount("123456", 1000)
print(account.account_number)    # ✅ Public access
print(account._balance)          # ⚠️ Can access but shouldn't
# print(account.__pin)           # ❌ AttributeError (name mangled)
```

---

## Properties

### The Magic of @property
Properties make **methods look like attributes** while providing **control**:

```python
class Temperature:
    def __init__(self, celsius=0):
        self.__celsius = celsius
    
    @property
    def celsius(self):
        """Get temperature in Celsius"""
        return self.__celsius
    
    @celsius.setter
    def celsius(self, value):
        """Set temperature with validation"""
        if value < -273.15:
            raise ValueError("Below absolute zero!")
        self.__celsius = value
    
    @property
    def fahrenheit(self):
        """Computed property - always up to date"""
        return (self.__celsius * 9/5) + 32

# Usage - looks like attributes!
temp = Temperature(25)
print(temp.celsius)     # 25 (calls getter)
temp.celsius = 30       # Calls setter with validation
print(temp.fahrenheit)  # 86.0 (computed automatically)
```

### When to Use Properties

```python
class User:
    def __init__(self, email):
        self._email = None
        self.email = email  # Uses property setter
    
    @property
    def email(self):
        return self._email
    
    @email.setter
    def email(self, value):
        # ✅ Use properties for:
        if '@' not in value:           # 1. Validation
            raise ValueError("Invalid email")
        self._email = value.lower()    # 2. Data transformation
        print(f"Email updated")        # 3. Side effects (logging)
    
    @property
    def username(self):               # 4. Computed values
        return self._email.split('@')[0] if self._email else None
```

---

## Static Methods

### Complete Example
```python
class FileManager:
    # Class variables
    max_file_size = 1024 * 1024  # 1MB
    allowed_extensions = ['.txt', '.pdf', '.doc']
    
    def __init__(self, base_path):
        self.base_path = base_path
        self.files = []
    
    @staticmethod
    def validate_filename(filename):
        """Static method - pure utility function"""
        invalid_chars = '<>:"/\\|?*'
        return not any(char in filename for char in invalid_chars)
    
    @staticmethod
    def get_file_extension(filename):
        """Static method - helper function"""
        return filename.split('.')[-1] if '.' in filename else ''
    
    @classmethod
    def get_allowed_extensions(cls):
        """Class method - access class data"""
        return cls.allowed_extensions.copy()
    
    @classmethod
    def set_max_size(cls, size_mb):
        """Class method - modify class data"""
        cls.max_file_size = size_mb * 1024 * 1024
    
    def add_file(self, filename):
        """Instance method - works with specific manager"""
        if self.validate_filename(filename):  # Use static method
            self.files.append(filename)
            return True
        return False

# Static methods - can call on class or instance
print(FileManager.validate_filename("document.txt"))  # True
print(FileManager.get_file_extension("file.pdf"))     # pdf

# Class methods
FileManager.set_max_size(5)  # Set to 5MB
print(FileManager.get_allowed_extensions())

# Instance methods
manager = FileManager("/documents")
manager.add_file("report.txt")
```

---

## API Classes vs Normal Classes

### Understanding the Difference

| Aspect | Normal Classes | API Classes |
|--------|----------------|-------------|
| **Purpose** | Business logic, internal operations | Data validation, HTTP serialization |
| **Validation** | Optional, manual | Automatic, strict validation |
| **Serialization** | Not needed | JSON/dict conversion required |
| **Documentation** | Internal docs | API documentation, examples |
| **Error Handling** | Application exceptions | HTTP status codes, API errors |
| **Security** | Internal trust | Input sanitization, validation |

### Normal Classes (Internal Business Logic)
```python
class BankAccount:
    """Normal class for internal business operations"""
    
    def __init__(self, account_number: str, balance: float = 0.0):
        self.account_number = account_number
        self.balance = balance
        self.transactions = []
    
    def deposit(self, amount: float) -> bool:
        """Internal business logic - trusts input"""
        if amount > 0:
            self.balance += amount
            self.transactions.append(f"Deposit: +${amount}")
            return True
        return False
    
    def withdraw(self, amount: float) -> bool:
        """Internal logic with basic validation"""
        if amount > 0 and amount <= self.balance:
            self.balance -= amount
            self.transactions.append(f"Withdrawal: -${amount}")
            return True
        return False
    
    def get_balance(self) -> float:
        return self.balance

# Usage - internal to your application
account = BankAccount("123456", 1000.0)
account.deposit(500)
print(account.get_balance())  # 1500.0
```

### API Classes (Web API Data Models)
```python
from pydantic import BaseModel, Field, validator
from typing import Optional, List
from decimal import Decimal
from datetime import datetime

class CreateAccountRequest(BaseModel):
    """API request model with strict validation"""
    account_holder: str = Field(..., min_length=2, max_length=100)
    initial_deposit: Decimal = Field(default=Decimal('0.00'), ge=0)
    account_type: str = Field(..., regex="^(checking|savings)$")
    
    @validator('account_holder')
    def validate_name(cls, v):
        if not v.strip():
            raise ValueError('Account holder name cannot be empty')
        return v.strip().title()
    
    class Config:
        schema_extra = {
            "example": {
                "account_holder": "John Doe",
                "initial_deposit": "1000.00",
                "account_type": "checking"
            }
        }

class AccountResponse(BaseModel):
    """API response model for consistent output"""
    account_id: str
    account_holder: str
    balance: Decimal
    account_type: str
    created_at: datetime
    is_active: bool = True
    
    class Config:
        json_encoders = {
            datetime: lambda v: v.isoformat(),
            Decimal: lambda v: str(v)
        }

class TransferRequest(BaseModel):
    """API request model with complex validation"""
    from_account: str = Field(..., description="Source account ID")
    to_account: str = Field(..., description="Destination account ID")
    amount: Decimal = Field(..., gt=0, description="Transfer amount")
    description: Optional[str] = Field(None, max_length=200)
    
    @validator('amount')
    def validate_amount(cls, v):
        if v <= 0:
            raise ValueError('Transfer amount must be positive')
        if v > Decimal('10000.00'):
            raise ValueError('Transfer amount cannot exceed $10,000')
        return v
    
    @validator('to_account')
    def accounts_must_be_different(cls, v, values):
        if 'from_account' in values and v == values['from_account']:
            raise ValueError('Cannot transfer to the same account')
        return v
```

### Real-World API Example with FastAPI
```python
from fastapi import FastAPI, HTTPException
from typing import Dict
import uuid

app = FastAPI(title="Banking API", version="1.0.0")

# In-memory storage (normally would be database)
accounts_db: Dict[str, dict] = {}

@app.post("/accounts", response_model=AccountResponse)
async def create_account(request: CreateAccountRequest):
    """Create a new bank account"""
    # API class validates input automatically
    account_id = str(uuid.uuid4())
    
    # Convert to internal business object
    account = BankAccount(account_id, float(request.initial_deposit))
    
    # Store in database
    accounts_db[account_id] = {
        "account_id": account_id,
        "account_holder": request.account_holder,
        "balance": request.initial_deposit,
        "account_type": request.account_type,
        "created_at": datetime.now(),
        "is_active": True
    }
    
    # Convert to API response
    return AccountResponse(**accounts_db[account_id])

@app.post("/transfer")
async def transfer_money(request: TransferRequest):
    """Transfer money between accounts"""
    # API validation happens automatically
    from_account = accounts_db.get(request.from_account)
    to_account = accounts_db.get(request.to_account)
    
    if not from_account or not to_account:
        raise HTTPException(status_code=404, detail="Account not found")
    
    # Use internal business logic
    if from_account["balance"] >= request.amount:
        from_account["balance"] -= request.amount
        to_account["balance"] += request.amount
        return {"status": "success", "message": "Transfer completed"}
    else:
        raise HTTPException(status_code=400, detail="Insufficient funds")
```

### When to Use Each

#### Use Normal Classes For:
- Internal business logic
- Data processing
- Database models (SQLAlchemy)
- Service classes
- Utility classes

```python
class EmailService:
    """Internal service class"""
    def send_email(self, to: str, subject: str, body: str) -> bool:
        # Internal email logic - trusts input
        pass

class ReportGenerator:
    """Internal data processing"""
    def generate_monthly_report(self, month: int, year: int) -> dict:
        # Internal reporting logic
        pass
```

#### Use API Classes For:
- HTTP request/response models
- Data validation
- API documentation
- External integrations
- Microservice communication

```python
class UserRegistrationRequest(BaseModel):
    """API request model with validation"""
    email: str = Field(..., regex=r'^[\w\.-]+@[\w\.-]+\.\w+$')
    password: str = Field(..., min_length=8)
    full_name: str = Field(..., min_length=2)

class UserResponse(BaseModel):
    """API response model"""
    id: int
    email: str
    full_name: str
    is_active: bool
```

---

## Pydantic for Advanced Validation

### Why Pydantic?
Pydantic provides **runtime data validation** and **automatic serialization** - perfect for APIs, configuration, and data processing.

### Basic Pydantic Model
```python
from pydantic import BaseModel, Field, validator
from typing import Optional, List
from datetime import datetime
from enum import Enum

class Status(Enum):
    ACTIVE = "active"
    INACTIVE = "inactive"
    PENDING = "pending"

class User(BaseModel):
    """Pydantic model with automatic validation"""
    name: str = Field(..., min_length=1, max_length=100)
    email: str = Field(..., regex=r'^[\w\.-]+@[\w\.-]+\.\w+$')
    age: int = Field(..., ge=0, le=150)
    status: Status = Status.ACTIVE
    tags: List[str] = Field(default_factory=list)
    metadata: dict = Field(default_factory=dict)
    created_at: datetime = Field(default_factory=datetime.now)
    
    @validator('name')
    def name_must_not_be_empty(cls, v):
        if not v.strip():
            raise ValueError('Name cannot be empty')
        return v.strip().title()
    
    @validator('tags')
    def validate_tags(cls, v):
        if len(v) > 10:
            raise ValueError('Too many tags (max 10)')
        return [tag.lower() for tag in v]
    
    class Config:
        # Validate on assignment (not just during creation)
        validate_assignment = True
        # Generate example for documentation
        schema_extra = {
            "example": {
                "name": "John Doe",
                "email": "john@example.com",
                "age": 30,
                "status": "active",
                "tags": ["developer", "python"]
            }
        }

# Usage - automatic validation
try:
    user = User(
        name="  john doe  ",  # Will be cleaned and titled
        email="john@example.com",
        age=30,
        tags=["PYTHON", "API"]  # Will be lowercased
    )
    print(user.name)  # "John Doe"
    print(user.tags)  # ["python", "api"]
    
    # Automatic serialization
    print(user.dict())  # Convert to dictionary
    print(user.json())  # Convert to JSON string
    
except ValueError as e:
    print(f"Validation error: {e}")
```

### Advanced Pydantic Features
```python
from pydantic import BaseModel, Field, validator, root_validator
from typing import Optional, Union
from decimal import Decimal

class Product(BaseModel):
    """Advanced Pydantic model with complex validation"""
    name: str = Field(..., description="Product name")
    price: Decimal = Field(..., gt=0, description="Product price")
    category: str = Field(..., description="Product category")
    discount_percent: Optional[float] = Field(None, ge=0, le=100)
    tax_rate: float = Field(0.10, ge=0, le=1)
    
    @validator('name')
    def validate_name(cls, v):
        if len(v.split()) < 2:
            raise ValueError('Product name must have at least 2 words')
        return v.title()
    
    @validator('category')
    def validate_category(cls, v):
        allowed_categories = ['electronics', 'clothing', 'books', 'food']
        if v.lower() not in allowed_categories:
            raise ValueError(f'Category must be one of: {allowed_categories}')
        return v.lower()
    
    @root_validator
    def validate_discount(cls, values):
        """Root validator - can access multiple fields"""
        price = values.get('price')
        discount = values.get('discount_percent')
        
        if discount and price:
            discount_amount = price * (discount / 100)
            if discount_amount > price * 0.9:  # Max 90% discount
                raise ValueError('Discount cannot exceed 90% of product price')
        
        return values
    
    @property
    def final_price(self) -> Decimal:
        """Computed property"""
        base_price = self.price
        if self.discount_percent:
            base_price *= (1 - self.discount_percent / 100)
        return base_price * (1 + self.tax_rate)
    
    class Config:
        # Allow arbitrary types (like Decimal)
        arbitrary_types_allowed = True
        # Validate on assignment
        validate_assignment = True
```

### Pydantic vs Regular Classes vs Dataclass

```python
# Regular class - manual validation
class RegularProduct:
    def __init__(self, name, price, category):
        if not name or len(name.split()) < 2:
            raise ValueError("Invalid name")
        if price <= 0:
            raise ValueError("Invalid price")
        # ... manual validation for each field
        
        self.name = name
        self.price = price
        self.category = category

# Dataclass - minimal validation
@dataclass
class DataclassProduct:
    name: str
    price: float
    category: str
    
    def __post_init__(self):
        if self.price <= 0:
            raise ValueError("Invalid price")
        # ... manual validation

# Pydantic - automatic validation
class PydanticProduct(BaseModel):
    name: str = Field(..., min_length=5)
    price: Decimal = Field(..., gt=0)
    category: str = Field(..., regex="^(electronics|clothing|books)$")
    
    # Automatic validation, serialization, documentation
```

### Real-World Pydantic Example
```python
from pydantic import BaseModel, Field, validator, AnyHttpUrl
from typing import List, Optional
from datetime import datetime

class APIKey(BaseModel):
    """API key configuration model"""
    name: str = Field(..., description="API key name")
    key: str = Field(..., min_length=32, description="The actual API key")
    permissions: List[str] = Field(default_factory=list)
    expires_at: Optional[datetime] = None
    is_active: bool = True
    
    @validator('key')
    def validate_key_format(cls, v):
        if not v.startswith('sk-'):
            raise ValueError('API key must start with "sk-"')
        return v

class ServiceConfig(BaseModel):
    """Complete service configuration with nested models"""
    service_name: str = Field(..., description="Name of the service")
    debug: bool = Field(default=False)
    database_url: AnyHttpUrl = Field(..., description="Database connection URL")
    api_keys: List[APIKey] = Field(default_factory=list)
    max_connections: int = Field(default=10, ge=1, le=1000)
    timeout_seconds: float = Field(default=30.0, gt=0)
    
    @validator('service_name')
    def validate_service_name(cls, v):
        if not v.replace('-', '').replace('_', '').isalnum():
            raise ValueError('Service name must be alphanumeric (with - or _)')
        return v.lower()
    
    class Config:
        # JSON schema generation
        schema_extra = {
            "example": {
                "service_name": "user-service",
                "debug": False,
                "database_url": "postgresql://user:pass@localhost/db",
                "api_keys": [
                    {
                        "name": "production",
                        "key": "sk-1234567890abcdef1234567890abcdef",
                        "permissions": ["read", "write"]
                    }
                ],
                "max_connections": 50,
                "timeout_seconds": 30.0
            }
        }

# Load from JSON/dict with automatic validation
config_data = {
    "service_name": "MY-API-SERVICE",
    "database_url": "postgresql://localhost/mydb",
    "api_keys": [
        {
            "name": "dev",
            "key": "sk-abcdef1234567890abcdef1234567890",
            "permissions": ["read"]
        }
    ]
}

config = ServiceConfig(**config_data)
print(config.service_name)  # "my-api-service" (lowercased by validator)
print(config.json(indent=2))  # Pretty JSON output
```

---

## Overloading

### Method Overloading (Not Supported)
Python doesn't support traditional method overloading. Use these alternatives:

#### 1. Default Parameters
```python
class Calculator:
    def add(self, a, b, c=None, d=None):
        """Single method with optional parameters"""
        result = a + b
        if c is not None:
            result += c
        if d is not None:
            result += d
        return result

calc = Calculator()
print(calc.add(1, 2))        # 3
print(calc.add(1, 2, 3))     # 6
print(calc.add(1, 2, 3, 4))  # 10
```

#### 2. Variable Arguments
```python
class MathOperations:
    def add(self, *args):
        """Accept any number of arguments"""
        return sum(args)
    
    def multiply(self, *args):
        result = 1
        for arg in args:
            result *= arg
        return result
```

#### 3. Type-Based Dispatch
```python
class DataProcessor:
    def process(self, data):
        """Different behavior based on type"""
        if isinstance(data, str):
            return data.upper()
        elif isinstance(data, list):
            return [item * 2 for item in data]
        elif isinstance(data, dict):
            return {k: v * 2 for k, v in data.items()}
        else:
            raise TypeError(f"Unsupported type: {type(data)}")
```

### Operator Overloading (Fully Supported)
```python
class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y
    
    def __add__(self, other):
        """Overload + operator"""
        return Vector(self.x + other.x, self.y + other.y)
    
    def __mul__(self, scalar):
        """Overload * operator"""
        return Vector(self.x * scalar, self.y * scalar)
    
    def __eq__(self, other):
        """Overload == operator"""
        return self.x == other.x and self.y == other.y
    
    def __str__(self):
        """Overload str() function"""
        return f"Vector({self.x}, {self.y})"

# Natural operator syntax!
v1 = Vector(3, 4)
v2 = Vector(1, 2)
result = v1 + v2  # Vector(4, 6)
scaled = v1 * 2   # Vector(6, 8)
```

### Using functools.singledispatch for Method Overloading
```python
from functools import singledispatch

class DataFormatter:
    """Using singledispatch for method overloading alternative"""
    
    @singledispatch
    @staticmethod
    def format_data(data):
        """Default formatter"""
        return f"Unknown type: {type(data).__name__}"
    
    @format_data.register
    @staticmethod
    def _(data: int):
        """Format integers"""
        return f"Integer: {data:,}"
    
    @format_data.register
    @staticmethod
    def _(data: float):
        """Format floats"""
        return f"Float: {data:.2f}"
    
    @format_data.register
    @staticmethod
    def _(data: str):
        """Format strings"""
        return f"String: '{data}'"
    
    @format_data.register
    @staticmethod
    def _(data: list):
        """Format lists"""
        return f"List with {len(data)} items: {data}"
    
    @format_data.register
    @staticmethod
    def _(data: dict):
        """Format dictionaries"""
        return f"Dict with keys: {list(data.keys())}"

# Usage - automatically dispatches to correct method based on type
formatter = DataFormatter()
print(formatter.format_data(1000))              # Integer: 1,000
print(formatter.format_data(3.14159))           # Float: 3.14
print(formatter.format_data("hello"))           # String: 'hello'
print(formatter.format_data([1, 2, 3]))         # List with 3 items: [1, 2, 3]
print(formatter.format_data({"a": 1, "b": 2}))  # Dict with keys: ['a', 'b']
print(formatter.format_data(True))              # Unknown type: bool
```

---

## Advanced Constructor Patterns

### 1. Builder Pattern for Complex Objects
```python
class DatabaseConnection:
    """Complex object that benefits from builder pattern"""
    
    def __init__(self):
        self.host = None
        self.port = None
        self.database = None
        self.username = None
        self.password = None
        self.ssl_enabled = False
        self.timeout = 30
        self.pool_size = 5
        self._connection = None
    
    @classmethod
    def builder(cls):
        """Start building a DatabaseConnection"""
        return DatabaseConnectionBuilder()
    
    def connect(self):
        """Establish the database connection"""
        if not all([self.host, self.port, self.database]):
            raise ValueError("Missing required connection parameters")
        
        connection_string = f"postgresql://{self.username}:{self.password}@{self.host}:{self.port}/{self.database}"
        self._connection = connection_string  # Simplified
        return f"Connected to {connection_string}"

class DatabaseConnectionBuilder:
    """Builder for DatabaseConnection"""
    
    def __init__(self):
        self._connection = DatabaseConnection()
    
    def host(self, host: str):
        self._connection.host = host
        return self
    
    def port(self, port: int):
        self._connection.port = port
        return self
    
    def database(self, database: str):
        self._connection.database = database
        return self
    
    def credentials(self, username: str, password: str):
        self._connection.username = username
        self._connection.password = password
        return self
    
    def ssl(self, enabled: bool = True):
        self._connection.ssl_enabled = enabled
        return self
    
    def timeout(self, seconds: int):
        self._connection.timeout = seconds
        return self
    
    def pool_size(self, size: int):
        self._connection.pool_size = size
        return self
    
    def build(self) -> DatabaseConnection:
        """Build the final DatabaseConnection object"""
        return self._connection

# Usage - fluent interface
db = (DatabaseConnection.builder()
      .host("localhost")
      .port(5432)
      .database("myapp")
      .credentials("admin", "secret")
      .ssl(True)
      .timeout(60)
      .pool_size(10)
      .build())

print(db.connect())
```

### 2. Factory Pattern with Registration
```python
from typing import Dict, Type, Callable
from abc import ABC, abstractmethod

class Vehicle(ABC):
    """Abstract base class for vehicles"""
    
    def __init__(self, make: str, model: str):
        self.make = make
        self.model = model
    
    @abstractmethod
    def start_engine(self) -> str:
        pass
    
    def __str__(self):
        return f"{self.__class__.__name__}: {self.make} {self.model}"

class Car(Vehicle):
    def start_engine(self) -> str:
        return f"Car engine started: Vroom! 🚗"

class Motorcycle(Vehicle):
    def start_engine(self) -> str:
        return f"Motorcycle engine started: Vroom vroom! 🏍️"

class Truck(Vehicle):
    def start_engine(self) -> str:
        return f"Truck engine started: VROOOOM! 🚛"

class VehicleFactory:
    """Factory with dynamic registration"""
    
    _registry: Dict[str, Type[Vehicle]] = {}
    
    @classmethod
    def register(cls, vehicle_type: str, vehicle_class: Type[Vehicle]):
        """Register a new vehicle type"""
        cls._registry[vehicle_type.lower()] = vehicle_class
    
    @classmethod
    def create(cls, vehicle_type: str, make: str, model: str) -> Vehicle:
        """Create a vehicle of the specified type"""
        vehicle_class = cls._registry.get(vehicle_type.lower())
        if not vehicle_class:
            available = list(cls._registry.keys())
            raise ValueError(f"Unknown vehicle type: {vehicle_type}. Available: {available}")
        
        return vehicle_class(make, model)
    
    @classmethod
    def available_types(cls) -> list:
        """Get list of available vehicle types"""
        return list(cls._registry.keys())

# Register vehicle types
VehicleFactory.register("car", Car)
VehicleFactory.register("motorcycle", Motorcycle)
VehicleFactory.register("truck", Truck)

# Usage
car = VehicleFactory.create("car", "Toyota", "Camry")
bike = VehicleFactory.create("motorcycle", "Harley", "Sportster")
truck = VehicleFactory.create("truck", "Ford", "F-150")

print(car.start_engine())   # Car engine started: Vroom! 🚗
print(bike.start_engine())  # Motorcycle engine started: Vroom vroom! 🏍️
print(truck.start_engine()) # Truck engine started: VROOOOM! 🚛

print(f"Available types: {VehicleFactory.available_types()}")
```

### 3. Dependency Injection Constructor
```python
from typing import Protocol, Optional
from abc import ABC, abstractmethod

# Protocols for dependency injection
class Logger(Protocol):
    def log(self, message: str) -> None: ...

class Database(Protocol):
    def save(self, data: dict) -> bool: ...
    def find(self, id: str) -> Optional[dict]: ...

class EmailService(Protocol):
    def send_email(self, to: str, subject: str, body: str) -> bool: ...

# Concrete implementations
class ConsoleLogger:
    def log(self, message: str) -> None:
        print(f"LOG: {message}")

class FileLogger:
    def __init__(self, filename: str):
        self.filename = filename
    
    def log(self, message: str) -> None:
        with open(self.filename, 'a') as f:
            f.write(f"LOG: {message}\n")

class MockDatabase:
    def __init__(self):
        self.data = {}
    
    def save(self, data: dict) -> bool:
        self.data[data.get('id', 'unknown')] = data
        return True
    
    def find(self, id: str) -> Optional[dict]:
        return self.data.get(id)

class MockEmailService:
    def send_email(self, to: str, subject: str, body: str) -> bool:
        print(f"EMAIL TO {to}: {subject}")
        return True

# Service class with dependency injection
class UserService:
    """Service class that depends on external services"""
    
    def __init__(
        self,
        logger: Logger,
        database: Database,
        email_service: EmailService,
        config: Optional[dict] = None
    ):
        self.logger = logger
        self.database = database
        self.email_service = email_service
        self.config = config or {}
    
    def create_user(self, username: str, email: str) -> bool:
        """Create a new user with all dependencies"""
        try:
            self.logger.log(f"Creating user: {username}")
            
            user_data = {
                'id': f"user_{len(username)}",
                'username': username,
                'email': email,
                'created_at': 'now'
            }
            
            # Save to database
            if self.database.save(user_data):
                self.logger.log(f"User {username} saved to database")
                
                # Send welcome email
                if self.email_service.send_email(
                    email,
                    "Welcome!",
                    f"Hello {username}, welcome to our service!"
                ):
                    self.logger.log(f"Welcome email sent to {email}")
                    return True
            
            return False
            
        except Exception as e:
            self.logger.log(f"Error creating user {username}: {e}")
            return False
    
    @classmethod
    def create_production(cls, log_file: str = "app.log"):
        """Factory method for production environment"""
        return cls(
            logger=FileLogger(log_file),
            database=MockDatabase(),  # Would be real database
            email_service=MockEmailService(),  # Would be real email service
            config={'environment': 'production'}
        )
    
    @classmethod
    def create_development(cls):
        """Factory method for development environment"""
        return cls(
            logger=ConsoleLogger(),
            database=MockDatabase(),
            email_service=MockEmailService(),
            config={'environment': 'development', 'debug': True}
        )
    
    @classmethod
    def create_testing(cls, mock_logger=None, mock_db=None, mock_email=None):
        """Factory method for testing with optional mocks"""
        return cls(
            logger=mock_logger or ConsoleLogger(),
            database=mock_db or MockDatabase(),
            email_service=mock_email or MockEmailService(),
            config={'environment': 'test'}
        )

# Usage - different configurations for different environments
prod_service = UserService.create_production()
dev_service = UserService.create_development()
test_service = UserService.create_testing()

# All use the same interface but different implementations
dev_service.create_user("alice", "alice@example.com")
```

### 4. Lazy Initialization Pattern
```python
class ExpensiveResource:
    """Resource that's expensive to create"""
    
    def __init__(self, config_file: str):
        self._config_file = config_file
        self._connection = None
        self._cache = None
        self._initialized = False
    
    @property
    def connection(self):
        """Lazy initialization of connection"""
        if self._connection is None:
            print(f"Initializing expensive connection from {self._config_file}")
            self._connection = f"connection_to_{self._config_file}"
        return self._connection
    
    @property
    def cache(self):
        """Lazy initialization of cache"""
        if self._cache is None:
            print("Initializing expensive cache")
            self._cache = {}
        return self._cache
    
    def get_data(self, key: str):
        """Method that uses lazy-loaded resources"""
        # Cache is only created when first needed
        if key in self.cache:
            return self.cache[key]
        
        # Connection is only created when first needed
        data = f"data_from_{self.connection}_for_{key}"
        self.cache[key] = data
        return data

# Usage - resources only created when needed
resource = ExpensiveResource("production.conf")
print("Resource created, but nothing loaded yet")

# Now connection and cache are initialized
data = resource.get_data("user_123")
print(data)
```

### 5. Copy Constructor Pattern
```python
from copy import deepcopy
from typing import Optional

class Configuration:
    """Class with copy constructor pattern"""
    
    def __init__(
        self,
        host: str = "localhost",
        port: int = 8080,
        debug: bool = False,
        features: Optional[dict] = None,
        copy_from: Optional['Configuration'] = None
    ):
        if copy_from:
            # Copy constructor - create from existing instance
            self.host = copy_from.host
            self.port = copy_from.port
            self.debug = copy_from.debug
            self.features = deepcopy(copy_from.features)
        else:
            # Regular constructor
            self.host = host
            self.port = port
            self.debug = debug
            self.features = features or {}
    
    @classmethod
    def copy(cls, other: 'Configuration') -> 'Configuration':
        """Alternative copy constructor as class method"""
        return cls(copy_from=other)
    
    def with_debug(self, debug: bool = True) -> 'Configuration':
        """Create a copy with modified debug setting"""
        new_config = Configuration(copy_from=self)
        new_config.debug = debug
        return new_config
    
    def with_port(self, port: int) -> 'Configuration':
        """Create a copy with modified port"""
        new_config = Configuration(copy_from=self)
        new_config.port = port
        return new_config
    
    def __repr__(self):
        return f"Configuration(host='{self.host}', port={self.port}, debug={self.debug}, features={self.features})"

# Usage
base_config = Configuration("production.com", 443, False, {"ssl": True})
print(f"Base: {base_config}")

# Copy constructors
debug_config = Configuration(copy_from=base_config).with_debug(True)
dev_config = base_config.with_port(8080).with_debug(True)
test_config = Configuration.copy(base_config).with_port(9999)

print(f"Debug: {debug_config}")
print(f"Dev: {dev_config}")
print(f"Test: {test_config}")
```

---

## Best Practices

### 1. Class Design Principles
```python
# ✅ Good: Single Responsibility
class EmailSender:
    """Handles only email sending"""
    def send_email(self, to, subject, body):
        pass

class UserValidator:
    """Handles only user validation"""
    @staticmethod
    def validate_email(email):
        return '@' in email

# ❌ Bad: Multiple Responsibilities
class UserManager:
    """Tries to do everything"""
    def create_user(self): pass
    def send_welcome_email(self): pass
    def validate_data(self): pass
    def save_to_database(self): pass
```

### 2. Proper Encapsulation
```python
class BankAccount:
    def __init__(self, account_number, initial_balance=0):
        self.account_number = account_number  # Public - account identifier
        self._balance = initial_balance       # Protected - internal data
        self.__pin = "1234"                   # Private - sensitive data
    
    @property
    def balance(self):                        # Controlled access
        return self._balance
    
    def deposit(self, amount):               # Public interface
        if self._validate_amount(amount):    # Protected helper
            self._balance += amount
            return True
        return False
    
    def _validate_amount(self, amount):      # Protected - for subclasses
        return isinstance(amount, (int, float)) and amount > 0
    
    def __authenticate(self, pin):           # Private - internal only
        return pin == self.__pin
```

### 3. Method Organization
```python
class DataProcessor:
    # Class variables first
    DEFAULT_ENCODING = 'utf-8'
    MAX_SIZE = 1024
    
    def __init__(self, source):
        # Instance variables
        self.source = source
        self.processed_data = None
    
    # Public methods first
    def process(self):
        """Main public interface"""
        raw_data = self._load_data()
        self.processed_data = self._clean_data(raw_data)
        return self.processed_data
    
    # Protected methods next
    def _load_data(self):
        """Protected helper method"""
        pass
    
    def _clean_data(self, data):
        """Protected helper method"""
        pass
    
    # Private methods last
    def __validate_source(self):
        """Private validation"""
        pass
    
    # Static/class methods at the end
    @staticmethod
    def is_valid_format(data_format):
        """Utility function"""
        return data_format in ['json', 'csv', 'xml']
    
    @classmethod
    def from_file(cls, filename):
        """Alternative constructor"""
        return cls(filename)
```

### 4. Error Handling
```python
class SafeCalculator:
    def divide(self, a, b):
        """Division with proper error handling"""
        try:
            self._validate_numbers(a, b)
            if b == 0:
                raise ValueError("Cannot divide by zero")
            return a / b
        except TypeError:
            raise TypeError("Arguments must be numbers")
    
    def _validate_numbers(self, *args):
        """Protected validation method"""
        for arg in args:
            if not isinstance(arg, (int, float)):
                raise TypeError(f"Expected number, got {type(arg)}")
```

### 5. Documentation Best Practices
```python
class DocumentedClass:
    """
    A well-documented class example.
    
    This class demonstrates proper documentation practices
    including class docstrings, method docstrings, and type hints.
    
    Attributes:
        name (str): The name of the instance
        value (int): The numeric value
    """
    
    def __init__(self, name: str, value: int):
        """
        Initialize a new DocumentedClass instance.
        
        Args:
            name (str): The name for this instance
            value (int): The initial value
            
        Raises:
            ValueError: If value is negative
            TypeError: If name is not a string
        """
        if not isinstance(name, str):
            raise TypeError("Name must be a string")
        if value < 0:
            raise ValueError("Value cannot be negative")
        
        self.name = name
        self.value = value
    
    def process_data(self, data: list) -> dict:
        """
        Process the provided data.
        
        Args:
            data (list): List of items to process
            
        Returns:
            dict: Processed results with counts and statistics
            
        Example:
            >>> obj = DocumentedClass("test", 5)
            >>> result = obj.process_data([1, 2, 3])
            >>> print(result)
            {'count': 3, 'sum': 6}
        """
        return {
            'count': len(data),
            'sum': sum(data) if data else 0
        }
```

### Quick Checklist for Good Classes
- [ ] Clear, single responsibility
- [ ] Proper method organization (public → protected → private → static/class)
- [ ] Good encapsulation (appropriate access levels)
- [ ] Type hints for parameters and return values
- [ ] Comprehensive docstrings
- [ ] Error handling with meaningful messages
- [ ] Use `@dataclass` for simple data containers
- [ ] Properties for controlled attribute access

Remember: **Start simple, add complexity only when needed!** 🚀 