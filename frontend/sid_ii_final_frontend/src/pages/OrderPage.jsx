import Nav from '../components/Nav';
import React, { useState, useEffect } from 'react';
import ListCategory from '../components/OrderPageComponents/ListCategory';
import ListProducts from '../components/OrderPageComponents/ListProducts';
import { addOrder, addOrderDetail, getProducts, getCategories } from '../config/api';
import { toast } from 'react-toastify';

const categoriesMock = ['Electronics', 'Clothing', 'Home', 'Books', 'Toys'];

const productsMock = [
  { id: 1, description: 'Product 1', category: 'Electronics', quantity: 0,  },
  { id: 2, description: 'Product 2', category: 'Clothing', quantity: 0 },
  { id: 3, description: 'Product 3', category: 'Home', quantity: 0 },
  // ... other products
];

const OrderPage = () => {

  const [productos, setProductos] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('all');
  const [allCategories, setCategories] = useState([]);
  const [allProducts, setAllProducts] = useState([]);
  const [filteredProducts, setFilteredProducts] = useState([]);

  const obtenerProductos = async () => {
    try {
      const productosBackend = await getProducts();

      const productosFrontend = productosBackend.map((producto) => ({
        ...producto,
        quantity: 0, 
      }));

      setAllProducts(productosFrontend);
      setFilteredProducts(productosFrontend);

      const categoriasBackend = await getCategories();

      setCategories(categoriasBackend);
    } catch (error) {
      console.error('Error al obtener productos:', error);
    }
  };

  useEffect(() => {
    obtenerProductos();
  }, []);

  const handleLogout = () => {
    window.location.href = '/'; 
  };

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

  const generateOrderCode = () => {
    const randomLong = Math.floor(Math.random() * Number.MAX_SAFE_INTEGER);
    return randomLong;
  };

  const handlePurchase = async () => {

    const orderCode = generateOrderCode();

    const order = {
      orderCode,
      clientCode: localStorage.getItem('id'),
      orderDate: new Date(),
      deliverDate: new Date(),
      paymentDate: new Date(),
    };
  
    try {
      const orderResponse = await addOrder(order);
  
      const selectedProducts = allProducts.filter((product) => product.quantity > 0);
      const orderDetails = selectedProducts.map((product) => ({
        orderCode,
        productCode: product.id,
        quantity: product.quantity,
        price: product.price * product.quantity,
      }));
  
      for (const orderDetail of orderDetails) {
        await addOrderDetail(orderDetail);
      }
  
      console.log('Compra realizada con éxito');
      toast.success('Purchase and Order has been created succesfully',{
        position: "top-center",
        autoClose: 1000,
      })
    } catch (error) {
      console.error('Error al realizar la compra:', error);
      toast.error('Ocurrio un error', {
        position: "top-center",
        autoClose: 1000, 
      });
    }
  };

  return (
    <div>
        <Nav></Nav>
        <div>
          <ListCategory categories={allCategories} selectedCategory={selectedCategory} onSelectedCategory={handleSelectedCategory} />
          <button onClick={filterProducts}>Filter</button>
          <ListProducts products={filteredProducts} onQuantityChange={handleQuantityChange} />
          <button onClick={handlePurchase}>Buy</button>
        </div>
    </div>
  )
}

export default OrderPage;

