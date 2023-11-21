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
    <div className="mb-6">
        <h3 className="text-lg font-semibold mb-4">Children</h3>
        {childrenFields.map((child, index) => (
          <div key={child.id} className="mb-4">
            <input
              {...register(`children[${index}].name`)}
              placeholder={`Name ${index + 1}`}
              className="border p-2 rounded"
            />
            <input
              {...register(`children[${index}].birthDate`)}
              type="date"
              placeholder={`Birth Date ${index + 1}`}
              className="border p-2 rounded ml-2"
            />
            <select
              {...register(`children[${index}].gender`)}
              className="border p-2 rounded ml-2"
            >
              <option value="">Select Gender</option>
              <option value="male">Male</option>
              <option value="female">Female</option>
            </select>
            <label className="ml-2">
              Studies
              <input
                {...register(`children[${index}].studies`)}
                type="checkbox"
                className="ml-1"
              />
            </label>
            <button type="button" onClick={() => removeChildren(index)} className="px-2 py-1 bg-red-500 text-white rounded ml-2">
              Remove
            </button>
          </div>
        ))}
        <button type="button" onClick={() => appendChildren({})} className="px-4 py-2 bg-blue-500 text-white rounded">
          Add Child
        </button>
      </div>
  );
};

export default ChildrenDataSection;
