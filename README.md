# Santander Dev Week 2023
Java RESTful API criada para Santander Dev Week 2023

## Diagrama de classes

```mermaid
classDiagram
  class User {
    - name: string
    - account: Account
    - features: Feature[]
    - card: Card
    - news: News[]
  }
  
  class Account {
    - number: string
    - agency: string
    - balance: number
    - limit: number
  }
  
  class Feature {
    - icon: string
    - description: string
  }
  
  class Card {
    - number: string
    - limit: number
  }
  
  class News {
    - icon: string
    - description: string
  }
  
  User "1" *-- "1" Account
  User "1" *-- "N" Feature
  User "1" *-- "1" Card
  User "1" *-- "N" News
```
