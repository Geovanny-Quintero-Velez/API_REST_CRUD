import React from 'react';

const ListCategory = ({ categories, selectedCategory, onSelectedCategory, filterProducts}) => (
  <div className='flex flex-row justify-center'>
    <label className='font-bold ml-3'>Category:</label>
    <select value={selectedCategory} onChange={(e) => onSelectedCategory(e.target.value)} className='w-3/5 mb-5 ml-3 rounded-md border-alter border-2 hover:border-2 hover:border-alter'>
      <option value="all">All</option>
      {categories.map((category) => (
        <option key={category} value={category}>
          {category}
        </option>
      ))}
    </select>
    <button onClick={filterProducts} className='ml-5 mr-5 bg-primary px-5 h-7 text-white rounded-md hover:bg-alter'>Filter</button>
  </div>
);

export default ListCategory;
