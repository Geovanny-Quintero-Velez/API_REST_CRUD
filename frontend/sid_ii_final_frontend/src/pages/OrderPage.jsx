import Nav from '../components/Nav';
import React, { useState, useEffect } from 'react';
import ListCategory from '../components/OrderPageComponents/ListCategory';
import ListProducts from '../components/OrderPageComponents/ListProducts';
import { addOrder, addOrderDetail, getProducts, getCategories, getDetail } from '../config/api';
import { toast } from 'react-toastify';

const categoriesMock = ['Electronics', 'Clothing', 'Home', 'Books', 'Toys'];

const productsMock = [
  { id: 1, description: 'Product 1', category: 'Electronics', quantity: 0, },
  { id: 2, description: 'Product 2', category: 'Clothing', quantity: 0 },
  { id: 3, description: 'Product 3', category: 'Home', quantity: 0 },
  // ... other products
];

const OrderPage = () => {

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

      const categoriasNames = categoriasBackend.map(categoria => categoria.name);

      setCategories(categoriasNames);
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
      const filtered = allProducts.filter((product) => product.categoria.name === selectedCategory);
      setFilteredProducts(filtered);
    }
  };

  const handleSelectedCategory = (category) => {
    setSelectedCategory(category);
  };

  const handleQuantityChange = (productId, change) => {
    setFilteredProducts((prevProducts) =>
      prevProducts.map((product) =>
        product.codigoProducto === productId ? { ...product, quantity: Math.max(0, product.quantity + change) } : product
      )
    );
    setAllProducts((prevProducts) =>
      prevProducts.map((product) =>
        product.codigoProducto === productId ? { ...product, quantity: Math.max(0, product.quantity + change) } : product
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
      numeroOrden: orderCode,
      codigoCliente: parseInt(localStorage.getItem('id')),
      fechaOrden: new Date(),
      fechaEnvio: new Date(),
      fechaPago: new Date(),
    };

    try {
      const orderResponse = await addOrder(order);

      const selectedProducts = allProducts.filter((product) => product.quantity > 0);
      var mul = 1
      const id = localStorage.getItem('id');
      const response = await getDetail(id);
      const dataExist = (response)? true : false;
      if(dataExist){
        mul=0.9
      }
      
      const orderDetails = selectedProducts.map((product) => ({
        numeroOrden: orderCode,
        productId: product.codigoProducto,
        cantidad: product.quantity,
        precio: product.precioVenta * product.quantity * mul,
      }));

      for (const orderDetail of orderDetails) {
        await addOrderDetail(orderDetail);
      }

      console.log('Compra realizada con éxito');
      toast.success('Purchase and Order has been created succesfully', {
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
    <div className='w-screen'>
      <Nav></Nav>
      <div className='h-screen w-screen bg-second flex items-center flex-col'>
        <h1 className=' py-7 font-bold text-white text-xl'>
          Product Catalog
        </h1>
        <div className=' w-4/5 p-3 bg-third rounded-md border-alter border-2 flex flex-col'>
          <ListCategory categories={allCategories} selectedCategory={selectedCategory} onSelectedCategory={handleSelectedCategory} filterProducts={filterProducts} />
          <hr className='border-t-2 border-red-500 my-4' />
          <ListProducts products={filteredProducts} onQuantityChange={handleQuantityChange} />
          <hr className='border-t-2 border-red-500 my-4' />
          <button onClick={handlePurchase} className='py-2 bg-primary text-white rounded-lg hover:bg-alter font-semibold my-5'>Buy</button>
        </div>
      </div>
    </div>
  )
}

export default OrderPage;

