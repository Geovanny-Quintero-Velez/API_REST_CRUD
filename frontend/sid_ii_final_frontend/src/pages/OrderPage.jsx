import Nav from '../components/Nav';
import React, { useState } from 'react';
import ListCategory from '../components/OrderPageComponents/ListCategory';
import ListProducts from '../components/OrderPageComponents/ListProducts';

const categoriesMock = ['Electronics', 'Clothing', 'Home', 'Books', 'Toys'];

const productsMock = [
  { id: 1, description: 'Product 1', category: 'Electronics', quantity: 0 },
  { id: 2, description: 'Product 2', category: 'Clothing', quantity: 0 },
  { id: 3, description: 'Product 3', category: 'Home', quantity: 0 },
  // ... other products
];

const OrderPage = () => {

  const handleLogout = () => {
    window.location.href = '/'; 
  };

  const [selectedCategory, setSelectedCategory] = useState('all');
  const [allProducts, setAllProducts] = useState(productsMock);
  const [filteredProducts, setFilteredProducts] = useState(productsMock);

  const filterProducts = () => {
    if (selectedCategory === 'all') {
      // Show all products
      setFilteredProducts(allProducts);
    } else {
      // Filter by category
      const filtered = allProducts.filter((product) => product.category === selectedCategory);
      setFilteredProducts(filtered);
    }
  };

  const handleSelectedCategory = (category) => {
    setSelectedCategory(category);
  };

  const handleQuantityChange = (productId, change) => {
    setFilteredProducts((prevProducts) =>
      prevProducts.map((product) =>
        product.id === productId ? { ...product, quantity: Math.max(0, product.quantity + change) } : product
      )
    );
    setAllProducts((prevProducts) =>
      prevProducts.map((product) =>
        product.id === productId ? { ...product, quantity: Math.max(0, product.quantity + change) } : product
      )
    );
  };

  const handlePurchase = () => {
    // Logic to process the purchase
    console.log('Purchase completed');
  };

  return (
    <div>
        <Nav></Nav>
        <div>
          <ListCategory categories={categoriesMock} selectedCategory={selectedCategory} onSelectedCategory={handleSelectedCategory} />
          <button onClick={filterProducts}>Filter</button>
          <ListProducts products={filteredProducts} onQuantityChange={handleQuantityChange} />
          <button onClick={handlePurchase}>Buy</button>
        </div>
    </div>
  )
}

export default OrderPage;

