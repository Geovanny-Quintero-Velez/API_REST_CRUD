// InterestCategories.js
import React, { useEffect, useState } from 'react';

const InterestCategories = ({ register }) => {
  const [categories, setCategories] = useState([]);

  useEffect(() => {
    // Puedes hacer una solicitud HTTP aquí para obtener las categorías desde el backend
    // Por ahora, simplemente simulamos algunas categorías de ejemplo
    const mockCategories = ['Electronics', 'Clothing', 'Home Appliances', 'Books', 'Toys'];
    setCategories(mockCategories);
  }, []);

  return (
    <div className="mb-6">
      <h3 className="text-lg font-semibold mb-4">Interest Categories</h3>
      <label className="block mb-2">Select all that apply:</label>
      <div className="grid grid-cols-2 gap-4">
        {categories.map((category) => (
          <label key={category} className="flex items-center">
            <input
              type="checkbox"
              {...register('interestCategories')}
              value={category}
              className="mr-1"
            />
            {category}
          </label>
        ))}
      </div>
    </div>
  );
};

export default InterestCategories;
