import React from 'react';

const ListCategory = ({ categories, selectedCategory, onSelectedCategory }) => (
  <div>
    <label>Category:</label>
    <select value={selectedCategory} onChange={(e) => onSelectedCategory(e.target.value)}>
      <option value="all">All</option>
      {categories.map((category) => (
        <option key={category} value={category}>
          {category}
        </option>
      ))}
    </select>
  </div>
);

export default ListCategory;
