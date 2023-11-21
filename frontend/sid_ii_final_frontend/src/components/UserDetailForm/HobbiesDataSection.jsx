import React from 'react';
import { useForm, useFieldArray } from 'react-hook-form';

const HobbiesDataSection = ({ control, register, remove }) => {
  const {
    fields: hobbiesFields,
    append: appendHobbies,
    remove: removeHobbies,
  } = useFieldArray({
    control,
    name: 'hobbies',
  });

  return (
    <div>
        <h3>Hobbies</h3>
        {hobbiesFields.map((hobby, index) => (
          <div key={hobby.id}>
            <input
              {...register(`hobbies[${index}]`)}
              placeholder={`Hobby ${index + 1}`}
            />
            <button type="button" onClick={() => removeHobbies(index)} className="px-2 py-1 bg-red-500 text-white rounded">
              Remove
            </button>
          </div>
        ))}
        <button type="button" onClick={() => appendHobbies('')} className="px-4 py-2 bg-blue-500 text-white rounded">
          Add Hobby
        </button>
      </div>
  );
};

export default HobbiesDataSection;
