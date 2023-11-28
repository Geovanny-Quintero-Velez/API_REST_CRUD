import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { getOrder } from '../config/api'
import { getOrderDetails } from '../config/api'

const OrderDetailPage = () => {
  const [orden, setOrden] = useState(null);
  const [detallesOrden, setDetalles] = useState([])

    const navigate = useNavigate()
    const params = useParams()

    const obtenerElementos = async () => {
        try {
        const idstring = params.id; 
        const numero = parseInt(idstring,10);

          const ordenBackend = await getOrder(numero);
    
          const detallesOrdenBackend = await getOrderDetails(numero);
    
          setOrden(ordenBackend);
          setDetalles(detallesOrdenBackend);
        } catch (error) {
          console.error('Error al obtener orden:', error);
        }
    };

    
    const calcularTotal = (detalles) => {
        return detalles.reduce((total, detalle) => total + detalle.precio * detalle.cantidad, 0);
    };

  useEffect(() => {
    obtenerElementos();
    },[]);

    return (
      <div className="flex justify-center items-center h-screen">
        <div className="text-center">
          <h2 className="text-2xl font-bold mb-4">Order Details #{orden?.numeroOrden}</h2>
          <p>Order Date: {orden?.fechaOrden}</p>
          <p>Shipping Date: {orden?.fechaEnvio}</p>
          <p>Payment Date: {orden?.fechaPago}</p>
  
          <h3 className="text-lg font-semibold mt-6 mb-2">Order Details</h3>
          <table className="w-full border-collapse">
            <thead>
              <tr>
                <th className="border p-2">Product</th>
                <th className="border p-2">Quantity</th>
                <th className="border p-2">Price</th>
              </tr>
            </thead>
            <tbody>
              {detallesOrden.map((detalle) => (
                <tr key={detalle.id}>
                  <td className="border p-2">{detalle.producto.descripcion}</td>
                  <td className="border p-2">{detalle.cantidad}</td>
                  <td className="border p-2">{detalle.precio}</td>
                </tr>
              ))}
            </tbody>
          </table>
  
          <p className="mt-4">Total: {calcularTotal(detallesOrden)}</p>
        </div>
      </div>
    );
};

export default OrderDetailPage;