// InterestCategories.js
import React, { useEffect, useState } from 'react';
import { getCategories } from '../../config/api';

const InterestCategories = ({ register }) => {
  const [categories, setCategories] = useState([]);

  const obtenerProductos = async () => {
    try {

      const categoriasBackend = await getCategories();

      const categoriasNames = categoriasBackend.map(categoria => categoria.name);

      setCategories(categoriasNames);
    } catch (error) {
      console.error('Error al obtener categorias:', error);
    }
  };
  
  useEffect(() => {
    obtenerProductos();
  }, []);

  return (
    <div className="mb-5 flex flex-col items-center">
      <h3 className="text-lg font-semibold mb-2">Interest Categories</h3>
      <label className="mb-4">Select all that apply:</label>
      <div className="w-4/5 p-3 rounded-md border-alter border-2 justify-center grid grid-cols-2 gap-4">
        {categories.map((category) => (
          <label key={category} className="flex items-center">
            <input
              type="checkbox"
              {...register('categoriasDeInteres')}
              value={category}
              className="mr-2 transform scale-150"
            />
            {category}
          </label>
        ))}
      </div>
    </div>
  );
};

export default InterestCategories;
