import React from 'react';
import { useForm, useFieldArray } from 'react-hook-form';

const ChildrenDataSection = ({ control, register, remove }) => {
  const {
    fields: childrenFields,
    append: appendChildren,
    remove: removeChildren,
  } = useFieldArray({
    control,
    name: 'children',
  });

  

  return (
    <div className="w-3/5 mb-7 justify-center flex flex-col items-center">
        <h3 className="text-lg font-semibold mb-4">Children</h3>
        {childrenFields.map((child, index) => (
          <div key={child.id} className="w-4/5 mb-5 justify-center flex flex-col items-center">
            <input
              {...register(`children[${index}].name`)}
              placeholder={`Name ${index + 1}`}
              className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
            />
            <input
              {...register(`children[${index}].birthDate`)}
              type="date"
              placeholder={`Birth Date ${index + 1}`}
              className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
            />
            <select
              {...register(`children[${index}].gender`)}
              className='w-4/5 mb-4 rounded-md border-alter border-2 hover:border-2 hover:border-alter'
            >
              <option value="">Select Gender</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
            <label className="w-4/5 mb-4 p-2 rounded-md border-alter border-2 justify-center flex">
              Is the child studied?
              <input
                {...register(`children[${index}].studies`)}
                type="checkbox"
                className="ml-3 transform scale-150"
              />
            </label>
            <button type="button" onClick={() => removeChildren(index)} className="px-2 py-1 bg-red-500 text-white rounded">
              Remove child
            </button>
          </div>
        ))}
        <button type="button" onClick={() => appendChildren({})} className="px-7 py-2 bg-blue-500 text-white rounded">
          Add Child
        </button>
      </div>
  );
};

export default ChildrenDataSection;
