# EasyShop E-Commerce API – Phase 1 & 2

This is the backend for **EasyShop**, an online store application. It’s built using **Java**, **Spring Boot**, and **MySQL**, and tested using **Postman**. The backend provides RESTful endpoints for managing users, categories, and products.

## 🔧 My Contributions

As a backend developer for **Phases 1 and 2** of EasyShop, I completed the following:

### ✅ Fixing Bugs (Phase 2)
- Fixed issues with product search filters returning incorrect results.
- Addressed product duplication and update bugs.
- Created or reviewed unit tests where needed to confirm bug fixes.

### 🗂️ Categories Controller (Phase 1)
Tested and implemented full category management using Postman:

| Step | Action                          | Role         | Notes |
|------|----------------------------------|--------------|-------|
| 1    | Get Categories                   | Any user     | Confirm categories are returned |
| 2    | Login as Admin                   | ADMIN        | Used token in Postman for further requests |
| 3    | Add Category                     | ADMIN        | Created new category via POST |
| 4    | Update Category                  | ADMIN        | Updated name via PUT |
| 5    | Delete Category                  | ADMIN        | Removed category via DELETE |
| 6    | Login as User                    | USER         | Tested unauthorized access |
| 7    | Add Category (unauthorized)      | USER         | Confirmed 403 Forbidden error |

> 🔐 Only users with `ADMIN` role can add, update, or delete categories. Role-based security was tested using Postman token authentication.

---

## 📸 Screenshots

> 📌 After uploading your screenshots to GitHub, copy their image URLs and replace the placeholders below.

**1. Admin Login in Postman**  
![login as admin](https://github.com/user-attachments/assets/acb28b3f-80fa-450a-b5a1-ea13b330b938)


**2. Add Category as Admin**  
![Add Category](https://github.com/user-attachments/assets/ea051f07-61f7-449b-b830-cee3b0200b98)


**3. Get All Categories**  
![get all categories](https://github.com/user-attachments/assets/61474b8b-b955-4945-a9f0-159b462efcb3)

**4.Put Updated a product as an admin**
![Put update product 2](https://github.com/user-attachments/assets/4f895c35-92ab-455e-93c7-8257e07c12b8)
![Put update product 1](https://github.com/user-attachments/assets/d0872685-f8d3-469c-b3b6-1f9bd31a0bd2)

**5. Add category not admin**
![Add Category not admin](https://github.com/user-attachments/assets/bc7800eb-c02b-401c-9e08-4d853c46893b)

**6. Delete category as admin**
![Delete Category as admin](https://github.com/user-attachments/assets/f27e64f8-bbce-4797-86e3-e342cf4f4fb6)




---

## 📦 Technologies Used

- Java  
- Spring Boot  
- MySQL  
- Postman  
- GitHub

---

