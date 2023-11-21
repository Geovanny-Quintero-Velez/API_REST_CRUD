import React from 'react';

const ListProducts = ({ products, onQuantityChange }) => (
  <div>
    {products.map((product) => (
      <div key={product.id}>
        <h3>{product.description}</h3>
        <p>Quantity: <button onClick={() => onQuantityChange(product.id, -1)}>-</button> {product.quantity} <button onClick={() => onQuantityChange(product.id, 1)}>+</button></p>
        <hr />
      </div>
    ))}
  </div>
);

export default ListProducts;

