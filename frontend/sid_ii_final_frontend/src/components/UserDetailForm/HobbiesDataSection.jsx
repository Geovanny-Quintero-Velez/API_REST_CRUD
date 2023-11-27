import React from 'react';
import { useForm, useFieldArray } from 'react-hook-form';

const HobbiesDataSection = ({ control, register, remove }) => {
  const {
    fields: hobbiesFields,
    append: appendHobbies,
    remove: removeHobbies,
  } = useFieldArray({
    control,
    name: 'pasatiempos',
  });

  return (
    <div className="mb-7 flex flex-col items-center">
        <h3 className="text-lg font-semibold mb-4">Hobbies</h3>
        {hobbiesFields.map((hobby, index) => (
          <div key={hobby.id} className="mb-5 flex justify-center flex-wrap">
            <input
              {...register(`pasatiempos[${index}]`)}
              placeholder={`Hobby ${index + 1}`}
              className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
            />
            <button type="button" onClick={() => removeHobbies(index)} className="px-2 py-1 bg-red-500 text-white rounded">
              Remove hobbie
            </button>
          </div>
        ))}
        <button type="button" onClick={() => appendHobbies('')} className="px-7 py-2 bg-blue-500 text-white rounded">
          Add Hobby
        </button>
      </div>
  );
};

export default HobbiesDataSection;
