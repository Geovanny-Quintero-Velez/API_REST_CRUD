// LocationInput.js
import React from 'react';

const LocationInput = ({ register }) => (
  <div className="mt-3 mb-3 flex justify-center flex-wrap">
    <h3 className="text-lg font-semibold mb-4">Place of Residence</h3>
    <input
      {...register('location.city')}
      placeholder="City of Residence"
      className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
    />
    <input
      {...register('location.state')}
      placeholder="State of Residence"
      className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
    />
    <input
      {...register('location.country')}
      placeholder="Country of Residence"
      className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
    />
  </div>
);

export default LocationInput;
