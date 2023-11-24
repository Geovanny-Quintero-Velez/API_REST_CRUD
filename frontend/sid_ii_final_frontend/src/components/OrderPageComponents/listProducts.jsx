import React from 'react';

const ListProducts = ({ products, onQuantityChange }) => (
  <div className='ml-5 mr-5 w-4/5 p-3 justify-center grid grid-cols-2 gap-4'>
    {products.map((product) => (
      <div key={product.id} className='flex flex-wrap justify-center'>
        <h3 className='text-xl'>{product.description}</h3>
        <p className='mt-1 flex flex-row items-center'>Amount: 
          <button onClick={() => onQuantityChange(product.id, -1)} className='ml-2 bg-second text-white text-2xl w-5 h-7 font-bold rounded-md flex items-center justify-center'>-</button>
          <span className="ml-2 border-alter border-2 px-2">{product.quantity}</span>
          <button onClick={() => onQuantityChange(product.id, 1)} className='ml-2 bg-blue-500 text-2xl w-5 h-7 font-bold text-white rounded-md flex items-center justify-center'>+</button>
        </p>
      </div>
    ))}
  </div>
);

export default ListProducts;

