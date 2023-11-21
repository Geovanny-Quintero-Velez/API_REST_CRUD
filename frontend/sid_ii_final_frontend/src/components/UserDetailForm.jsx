import React from 'react';
import { useForm, useFieldArray } from 'react-hook-form';
import ChildrenDataSection from './UserDetailForm/ChildrenDataSection';
import HobbiesDataSection from './UserDetailForm/HobbiesDataSection';
import LocationInput from './UserDetailForm/LocationInput';
import InterestCategories from './UserDetailForm/InterestCategories';
import {getDetail, addDetail, updateDetail} from '../config/api';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';

const UserDetailForm = () => {
  const {
    register,
    control,
    handleSubmit,
    setValue,
    getValues,
    formState: { errors },
  } = useForm({
    defaultValues: {
      children: [{ nombre: '', edad: '', genero: '' }],
      hobbies: [],
      location: { city: '', state: '', country: '' },
      interestCategories: [],
    },
  });

  const navigate = useNavigate()

  const id = localStorage.getItem('id');

  const onSubmit = handleSubmit(async data => {
    const response = await getDetail(id);
    const dataExist = response.data && response.data.id;
    if(dataExist){
      await updateDetail(id,data)
        toast.success('Detail updated succesfully',{
            position: "top-center",
            autoClose: 1000,
        })
    }else{
      await addDetail(data)
      toast.success('Detail has been created succesfully',{
        position: "top-center",
        autoClose: 1000,
      })
    }
    navigate('/welcome')
  });

  return (
    <form onSubmit={onSubmit} className="max-w-xl mx-auto mt-8 p-8 bg-white rounded shadow">
      <LocationInput register={register} />
      <hr></hr>
      <ChildrenDataSection control={control} register={register}></ChildrenDataSection>
      <hr></hr>
      <HobbiesDataSection control={control} register={register}></HobbiesDataSection>
      <hr></hr>
      <InterestCategories register={register} />
      <hr></hr>
      <button type="submit" className="px-6 py-4 bg-red-500 text-white rounded ml-2">Send data</button>
    </form>
  );
};

export default UserDetailForm;
