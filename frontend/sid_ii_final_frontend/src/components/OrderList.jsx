import React, { useEffect, useState } from 'react';
import { getOrders } from '../config/api'
import OrderCard from './OrderCard';

const OrderList = () => {
    const [orders, setOrders] = useState([]);

    const codigoCliente = parseInt(localStorage.getItem('id'),10);

    useEffect(() => {
   
        try{
          getOrdersByClient(codigoCliente) 
            .then((data) => {
                setOrders(data);
          })
        }catch(error){
            throw error
        }
      }, []);

      return (
        <div className='h-screen w-screen bg-third flex flex-col items-center'>
          <h1 className='text-2xl text-black font-bold py-5'>Your Orders</h1>
        <div className='bg-second w-5/6 rounded-lg overflow-auto ' style={{ height: '30rem' }}>
      
        {orders.length > 0 ? (
      <div className='grid grid-cols-1 w-full ml-20'>
        {orders.map((order) => (
          <OrderCard order={order} key={order.numeroOrden} />
        ))}
      </div>
    ) : (
      <div className='flex flex-col justify-center items-center h-full'>
        <h1 className='text-third font-semibold text-xl'>You do not have any order</h1>
      </div>
    )}
      
    </div>
    </div>
      );
}

export default OrderList