// LocationInput.js
import React from 'react';

const LocationInput = ({ register }) => (
  <div className="mb-6">
    <h3 className="text-lg font-semibold mb-4">Place of Residence</h3>
    <input
      {...register('location.city')}
      placeholder="City of Residence"
      className="border p-2 rounded"
    />
    <input
      {...register('location.state')}
      placeholder="State of Residence"
      className="border p-2 rounded ml-2"
    />
    <input
      {...register('location.country')}
      placeholder="Country of Residence"
      className="border p-2 rounded ml-2"
    />
  </div>
);

export default LocationInput;
