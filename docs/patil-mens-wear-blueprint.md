# Patil Mens Wear - Myntra-Style E-commerce Blueprint

## 1) Architecture Overview
- **Backend:** Spring Boot (REST APIs + JPA + Security)
- **Frontend:** React.js (Vite/CRA compatible)
- **Database:** MySQL
- **Auth:** JWT stateless authentication
- **Roles:** `ROLE_USER`, `ROLE_ADMIN`

## 2) Backend Deliverables Included
The starter backend code has been added under:

`money manager/moneymanager/src/main/java/in/sahilkokitkar/moneymanager/ecommerce`

### Implemented layers
- **Entity classes**
- **Repository layer**
- **Service interfaces + implementations**
- **Controller layer**
- **JWT configuration**

## 3) Entity Relationship Model
Core relationships:
- `UserEntity (1) -> (M) OrderEntity`
- `OrderEntity (1) -> (M) OrderItemEntity`
- `UserEntity (1) -> (1) CartEntity`
- `CartEntity (1) -> (M) CartItemEntity`
- `ProductEntity (M) -> (1) CategoryEntity`
- `UserEntity (1) -> (M) WishlistItemEntity`
- `WishlistItemEntity (M) -> (1) ProductEntity`

## 4) API Endpoint List (Starter)
Base path: `/api/ecommerce`

### Auth
- `POST /auth/register` - register user/admin
- `POST /auth/login` - login and receive JWT

### Products
- `POST /products/search` - search + filter + pagination + sort
- `POST /products/admin` - add product (admin)
- `PUT /products/admin/{id}` - update product (admin)
- `DELETE /products/admin/{id}` - delete product (admin)

### Orders
- `POST /orders/checkout/{userId}` - checkout/place order
- `GET /orders/user/{userId}` - user order history
- `GET /orders/admin/all` - admin order list

## 5) Database Schema (MySQL)
```sql
CREATE TABLE ecom_users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  full_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL
);

CREATE TABLE ecom_categories (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE ecom_products (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  brand VARCHAR(255) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  discount_price DECIMAL(10,2),
  sizes VARCHAR(255) NOT NULL,
  colors VARCHAR(255) NOT NULL,
  stock_quantity INT NOT NULL,
  image_url VARCHAR(600) NOT NULL,
  description TEXT,
  created_at DATETIME NOT NULL,
  category_id BIGINT NOT NULL,
  CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES ecom_categories(id)
);

CREATE TABLE ecom_carts (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL UNIQUE,
  CONSTRAINT fk_cart_user FOREIGN KEY (user_id) REFERENCES ecom_users(id)
);

CREATE TABLE ecom_cart_items (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  cart_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL,
  CONSTRAINT fk_cart_items_cart FOREIGN KEY (cart_id) REFERENCES ecom_carts(id),
  CONSTRAINT fk_cart_items_product FOREIGN KEY (product_id) REFERENCES ecom_products(id)
);

CREATE TABLE ecom_orders (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  status VARCHAR(30) NOT NULL,
  ordered_at DATETIME NOT NULL,
  CONSTRAINT fk_order_user FOREIGN KEY (user_id) REFERENCES ecom_users(id)
);

CREATE TABLE ecom_order_items (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  order_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  quantity INT NOT NULL,
  unit_price DECIMAL(10,2) NOT NULL,
  CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES ecom_orders(id),
  CONSTRAINT fk_order_item_product FOREIGN KEY (product_id) REFERENCES ecom_products(id)
);

CREATE TABLE ecom_wishlist_items (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL,
  CONSTRAINT fk_wishlist_user FOREIGN KEY (user_id) REFERENCES ecom_users(id),
  CONSTRAINT fk_wishlist_product FOREIGN KEY (product_id) REFERENCES ecom_products(id)
);
```

## 6) Suggested Frontend Folder Structure (React)
```text
src/
  api/
    axiosClient.js
    authApi.js
    productApi.js
    cartApi.js
    orderApi.js
  app/
    store.js
    routes.jsx
  assets/
  components/
    common/
      Navbar.jsx
      Footer.jsx
      SearchBar.jsx
      ProductCard.jsx
      Pagination.jsx
    home/
      HeroBanner.jsx
      CategoryGrid.jsx
      FeaturedProducts.jsx
      RecentlyAdded.jsx
    product/
      ProductFilters.jsx
      ProductSort.jsx
      ProductGallery.jsx
      SizeSelector.jsx
      ColorSelector.jsx
    cart/
      CartItemRow.jsx
      CartSummary.jsx
    checkout/
      CheckoutAddressForm.jsx
      PaymentSection.jsx
  pages/
    HomePage.jsx
    ProductListingPage.jsx
    ProductDetailPage.jsx
    CartPage.jsx
    WishlistPage.jsx
    CheckoutPage.jsx
    LoginPage.jsx
    SignupPage.jsx
    ProfilePage.jsx
    OrderHistoryPage.jsx
    admin/
      AdminDashboardPage.jsx
      ProductManagementPage.jsx
      CategoryManagementPage.jsx
      OrdersManagementPage.jsx
  context/
    AuthContext.jsx
    CartContext.jsx
  hooks/
    useAuth.js
    useCart.js
  styles/
```

## 7) UI Component Guidance (Myntra Inspired)
- Top navbar with logo + categories + search + profile/cart icons
- Full-width hero banner with CTA button
- Category tiles for Shirts, T-Shirts, Jeans, Blazers, Ethnic Wear, Accessories
- Product card hover states: image zoom + quick add to wishlist/cart
- Product detail layout with image gallery, size & color selector, price + discount badge
- Responsive breakpoints for mobile-first cards and filters drawer

## 8) ER Diagram Explanation (Text)
- A user can place multiple orders; each order holds multiple order items.
- Each order item references one product snapshot (product + unit price + qty).
- User has one active cart and many cart items.
- Product belongs to one category while one category can contain many products.
- Wishlist is implemented as user-product pairs to support quick favorites.

## 9) Step-by-Step Development Roadmap
1. Initialize backend modules (`entity`, `repository`, `service`, `controller`, `security`).
2. Configure JWT generation/validation and secure role-based routes.
3. Implement category/product CRUD with admin authorization.
4. Implement cart management and wishlist endpoints.
5. Implement checkout flow to convert cart items into order + order items.
6. Add product search/filter/pagination/sort APIs.
7. Build React base layout (navbar, hero, category grid, product cards).
8. Implement user auth screens and token-based route guards.
9. Implement product listing/detail/cart/checkout/order history pages.
10. Implement admin product/category/order management dashboard.
11. Add responsive polish and loading/error skeleton states.
12. Test end-to-end flow and deploy (Spring Boot + MySQL + React).
