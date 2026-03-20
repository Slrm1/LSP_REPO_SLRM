# Question 2 - Part 2: Proposed Improved Design (CRC)

Class: Order  
Responsibilities:
- Store order data (customer, email, item, base price)
- Validate required fields
- Provide read-only access to order details  
Collaborators:
- None

Class: PricingService  
Responsibilities:
- Calculate tax for an order
- Apply discount policy
- Compute final total  
Collaborators:
- Order
- DiscountPolicy
- TaxPolicy

Class: DiscountPolicy  
Responsibilities:
- Determine whether discount applies
- Calculate discount amount from order price  
Collaborators:
- Order

Class: TaxPolicy  
Responsibilities:
- Provide tax rate
- Calculate tax amount for order subtotal  
Collaborators:
- Order

Class: ReceiptFormatter  
Responsibilities:
- Build receipt text from order and total
- Format output consistently for display/storage  
Collaborators:
- Order

Class: OrderRepository  
Responsibilities:
- Persist processed order records
- Handle storage-specific exceptions  
Collaborators:
- Order
- ReceiptFormatter

Class: NotificationService  
Responsibilities:
- Send confirmation notifications
- Format customer confirmation message  
Collaborators:
- Order

Class: ActivityLogger  
Responsibilities:
- Record processing events with timestamp
- Capture success/failure events  
Collaborators:
- None

Class: OrderProcessingService  
Responsibilities:
- Orchestrate end-to-end order processing workflow
- Coordinate pricing, persistence, notification, and logging
- Return processing result  
Collaborators:
- Order
- PricingService
- ReceiptFormatter
- OrderRepository
- NotificationService
- ActivityLogger

