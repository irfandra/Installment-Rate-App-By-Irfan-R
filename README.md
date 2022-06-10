
# Installment Rate App By Irfan R
A Project which handle customer, product and transaction data with MS SQL database by performing CRUD Operation 
and also calculating all necessary prices such as monthly payment, down payment, and etc.


## This Application is built for following purpose:

- Storing data of customer until product.
- Editing or Deleting data between product and customer.
- Calculating installment rate (Down Payment, Monthly Payment, Total First Payment, and Total Price) 
- Tracking transaction for every purchase.

## Technologies used :
#### Back-End Development
- Java 
- Spring Boot
- MS SQL
#### Database used :
- MS SQL

#### ERD Design
![alt text](https://github.com/irfandra//blob/[branch]/image.jpg](https://github.com/irfandra/Installment-Rate-App-By-Irfan-R/blob/main/InstallmentAppERD.png)?raw=true)


## Variables

| Key | Value | Type |
| --- | ------|-------------|
| base_url | http://localhost:8080 | string |



## Endpoints

* [Category](#category)
    1. [Get All Category](#1-get-all-category)
    1. [Insert New Category](#2-insert-new-category)
    1. [Update Category](#3-update-category)
    1. [Delete Category By CategoryName](#4-delete-category-by-categoryname)
* [Product](#product)
    1. [Get All Product](#1-get-all-product)
    1. [Insert New Product](#2-insert-new-product)
    1. [Update Product](#3-update-product)
    1. [Delete Product by Id](#4-delete-product-by-id)
* [Customer](#customer)
    1. [Get All Customer](#1-get-all-customer)
    1. [Insert New Customer](#2-insert-new-customer)
    1. [Delete Customer By Id](#3-delete-customer-by-id)
    1. [Update Customer](#4-update-customer)
* [PaymentDetail](#paymentdetail)
    1. [Get All Payment Detail](#1-get-all-payment-detail)
    1. [Insert New Payment Detail](#2-insert-new-payment-detail)
    1. [Update Payment Detail](#3-update-payment-detail)
    1. [Delete Payment Detail By ID](#4-delete-payment-detail-by-id)
* [Transaction](#transaction)
    1. [Get All Transaction](#1-get-all-transaction)
    1. [Get Transaction By Customer FullName](#2-get-transaction-by-customer-fullname)
    1. [Insert New Transaction](#3-insert-new-transaction)
    1. [Delete Transaction By Id](#4-delete-transaction-by-id)

--------



## Category



### 1. Get All Category



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/category/get-all
```



### 2. Insert New Category



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/category/insert
```



***Body:***

```js        
{
    "categoryName":"Airplane",
    "description" : "Brand New or Used Airplane"
}
```



### 3. Update Category



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/category/Airplane
```



***Body:***

```js        
{
    "description":"Brand New Airplane and Used Airplane"
}
```



### 4. Delete Category By CategoryName



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/category/by-string/Airplane
```



## Product



### 1. Get All Product



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/product/get-all
```



### 2. Insert New Product



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/product/insert
```



***Body:***

```js        
{
"productName":"Audi R8 V10",
"description":"Brand New 2012 Facelift",
"price":900000000,
"categoryName":"Car"

}
```



### 3. Update Product



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/product/Audi R8 V10
```



***Body:***

```js        
{
   
    "description":"Used Car 2010"
}
```



### 4. Delete Product by Id



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/product/by-string/Audi R8 V10
```



## Customer



### 1. Get All Customer



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/customer/get-all
```



### 2. Insert New Customer



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/customer/insert
```



***Body:***

```js        
{
    "firstName": "Andrew",
    "lastName": "Tate",
    "birthDate": "11/10/1990",
    "phone": "08282919182",
    "address": "LAX"
}
```



### 3. Delete Customer By Id



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/customer/by-integer/6
```



### 4. Update Customer



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/customer/6
```



***Body:***

```js        
{
    "lastName": "Collins",
   
    "phone": "08282919182",
    "address": "New York City"
}
```



## PaymentDetail



### 1. Get All Payment Detail



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/paymentDetail/get-all
```



### 2. Insert New Payment Detail



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/paymentDetail/insert
```



***Body:***

```js        
{
    "installmentYear":"2",
    "interestRate":0.05
}
```



### 3. Update Payment Detail



***Endpoint:***

```bash
Method: PUT
Type: RAW
URL: {{base_url}}/paymentDetail/7
```



***Body:***

```js        
{
    "installmentYear":3
   
}
```



### 4. Delete Payment Detail By ID



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/paymentDetail/by-integer/7
```



## Transaction



### 1. Get All Transaction



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/transaction/get-all
```



### 2. Get Transaction By Customer FullName



***Endpoint:***

```bash
Method: GET
Type: 
URL: {{base_url}}/transaction/get-by-full-name
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| fullName | Andrew |  |



### 3. Insert New Transaction



***Endpoint:***

```bash
Method: POST
Type: RAW
URL: {{base_url}}/transaction/insert
```



***Body:***

```js        
{
    "customerId":"2",
    "paymentId":"1",
    "productName":"Mercedes Benz C300"
}
```



### 4. Delete Transaction By Id



***Endpoint:***

```bash
Method: DELETE
Type: 
URL: {{base_url}}/transaction/delete
```



***Query params:***

| Key | Value | Description |
| --- | ------|-------------|
| transactionId | TRX/2022/JUNE/3 |  |



---
[Back to top](#installment-rate-app-by-irfan-r)


